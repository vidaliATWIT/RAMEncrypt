package ramEncrypt;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Encryptor {
	private char[] newText;
	private char[] originalText;
	private Integer[] key;
	private String[] refArray;
	
	Encryptor(String word, int seed) {
		refArray = new String[word.length()]; 
		genRefArray(word, seed);
		genNewKey(word);
	}
	
	Encryptor(String key) {
		stringToKey(key);
	}
	

	public void setKey(Integer[] key) {
		this.key = key;
	}
	
	Encryptor() {
		
	}
	
	public Integer[] getKey() {
		return key;
	}
	
	//Splits reference name to obtain the 8bit code at the end
	private String parseMemory(String ref) {
		return ref.split("@")[1];
	}
	
	//generates reference value
	private String genRef(int seed) {
		Object ref = new Object();
		for (int i = 0; i<seed; i++) {
			ref = new Object();
		}
		//System.out.println(ref.toString());
		return parseMemory(ref.toString());
	}
	
	//generates reference value array
	private void genRefArray(String word, int seed) {
		for (int i = 0; i<word.length(); i++) {
			refArray[i] = genRef(seed);
		}
	}
	
	//generates new ascii code
	private int getAsciiCode(int i, int j, int k) {
		return refArray[j].charAt(Math.min(k, refArray[j].length()-1)) - 32; //the min is necessary to keep the variation in memory locations from causing an exception
	}

	//generates new ascii alphabet
	public void genNewKey(String text) {
		key = new Integer[text.length()];
		int j = 0; //count for asciiArray
		int k = 0; //count for character
		for (int i = 0; i<text.length(); i++) {
			key[i] = getAsciiCode(i, j, k);
			if (i%8==0) {j++;  k=0;} else {k++;}
		}
	}
	
	public String makeString(char[] characters) {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i<characters.length; i++) {
			message.append(characters[i]);
		}
		return message.toString();
	}
	
	public String encrypt(String oldText) {
		newText = new char[oldText.length()];
		for (int i = 0; i<oldText.length(); i++) {
			newText[i] = (char)(oldText.charAt(i) + key[i]);
			if (newText[i] > 126) {
				newText[i] -= 2*key[i];
				key[i]= -1*key[i];
			}
		}
		return makeString(newText);
	}
	
	public String deEncrypt(String newText) {
		originalText = new char[newText.length()];
		for (int i = 0; i<newText.length(); i++) {
			originalText[i] = (char)(newText.charAt(i) - key[i]);
		//	System.out.println(originalText[i]);
		}
		return makeString(originalText);
	}
	
	public String keyToString() {
		StringBuilder keyString = new StringBuilder();
		for (int i = 0; i<key.length; i++) {
			keyString.append(key[i]);
			keyString.append("/");
		}
		return keyString.toString();
	}
	
	public void stringToKey(String keyString) {
		key = new Integer[keyString.length()];
		String[] keySplit = keyString.split("/");
		for (int i = 0; i<(keySplit.length); i++) {
			key[i] = (int) Integer.parseInt(keySplit[i]);
			//System.out.println(key[i]);
		}
	}
}
