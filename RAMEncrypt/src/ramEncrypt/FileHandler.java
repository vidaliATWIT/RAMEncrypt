package ramEncrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	File inputFile;
	File outputFile;
	File encryptFile;
	File keyFile;
	Scanner read;
	PrintWriter write;
	
	public FileHandler () {
		
	}
	
	public void setFile(String filePath, int i) {
		if (i==0) {
			inputFile = new File(filePath);
		} else if (i==1) {
			keyFile = new File(filePath);
		} else {
			//null
		}
	}
	
	public void setFileReader(int i) {
		if (i==0) {
			try {
				read = new Scanner(inputFile);
			} catch (FileNotFoundException e) {
				System.out.println("INVALID FILE PATH");
				System.exit(0);
			}
 		} else if (i==1) {
 			try {
				read = new Scanner(keyFile);
			} catch (FileNotFoundException e) {
				System.out.println("INVALID FILE PATH");
				System.exit(0);
			}
 		}
	}
	
	
	public String getText() {
		StringBuilder text = new StringBuilder();
		try {
			while (read.hasNext()) {
				text.append(read.nextLine());
			//	text.append("\n");
			}
		} catch (Exception e) {
		}
		System.out.println(text.toString());
		read.close();
		return text.toString(); 
	}
	

	
	public void newOutputFile(String filepath, int type) {
		if (type==0) {
			outputFile = new File(filepath.concat("//encrypt.txt"));
		} else if (type==1) {
			outputFile = new File(filepath.concat("//output.txt"));
		} else if (type==2) {
			outputFile = new File(filepath.concat("//key.txt"));
		}
	}
	
	public void setFileWrite() {
		try {
			write = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			System.out.println("No file with that path found.");
		}
	}
	
	public void setText(String text) {
		write.println(text);
		write.close();
	}
}
