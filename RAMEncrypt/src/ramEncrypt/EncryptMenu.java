package ramEncrypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import ui.ConsoleUI;
import ui.Window;

public class EncryptMenu implements ActionListener {

	private String word;
	private String newWord;
	private Encryptor encrypt;
	private FileHandler file = new FileHandler();
	private Window win;
	int state;
	
	public EncryptMenu() {
		windowLoop();
		//menuLoop();
	}
	
	public void windowLoop() {
		win = new Window();
		state = 0;
		win.initStartScreen();
		initActionListener();
	}
	
	public void actionEncrypt(String[] filepaths) {
		file.setFile(filepaths[0], 0);
		file.newOutputFile(filepaths[1], 0);
		file.setFileReader(0);
		word = file.getText();
		encrypt = new Encryptor(word, 333);
		newWord = encrypt.encrypt(word);
		file.setFileWrite();
		file.setText(newWord);
		file.newOutputFile(filepaths[2], 2);
		file.setFileWrite();
		file.setText(encrypt.keyToString());
	}
	
	public void actionDecrypt(String[] filepaths) {
		file.setFile(filepaths[0], 1);
		file.setFileReader(1);
		encrypt = new Encryptor(file.getText());
		file.setFile(filepaths[1], 0);
		file.setFileReader(0);
		file.newOutputFile(filepaths[2], 1);
		file.setFileWrite();
		file.setText(encrypt.deEncrypt(file.getText()));
	}
	
	public void initActionListener() {
		win.getButton1().addActionListener(this);
		win.getButton2().addActionListener(this);
		win.getFileField1().addActionListener(this);
		win.getFileField2().addActionListener(this);
		win.getFileField3().addActionListener(this);
		win.getNextButton().addActionListener(this);
		win.getBackButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (state==0) {
			if (e.getSource().equals(win.getButton1())) {
				state = 1;
				win.clearPanel(win.getStartPanels());
				win.initEncryptWindow("load .txt: ", "save file: ", "save key:");
				win.showPanel(win.getEncryptPanels());
			} else if (e.getSource().equals(win.getButton2())) {
				state = 2;
				win.clearPanel(win.getStartPanels());
				win.initEncryptWindow("load key: ", "load file: ", "save out:");
				win.showPanel(win.getEncryptPanels());
			} 
		}
		else if (state==1) {
			String[] filepaths = new String[]{"","",""};
			if (e.getSource()==(win.getFileField1())) {
				System.out.println("test1");
			}
			if (e.getSource()==(win.getFileField2())) {
				System.out.println("test2");
			}
			if (e.getSource()==(win.getFileField3())) {
				System.out.println("test3");
			}
			if (e.getSource()==(win.getBackButton())) {
				state=0;
				clearText();
				win.clearPanel(win.getEncryptPanels());
				win.showPanel(win.getStartPanels());
				win.initStartScreen();
			} else if (e.getSource()==win.getNextButton()) {
				filepaths[0] = win.getFileField1().getText();
				filepaths[1] = win.getFileField2().getText();
				filepaths[2] = win.getFileField3().getText();
				if (validateFilepaths(filepaths)) {
					win.getInfoArea().setText("The file was succesfully encrypted!");
					actionEncrypt(filepaths);
				} else
					win.getInfoArea().setText("The filepaths were not valid!");
			}
		}
		else if (state==2) {
			String[] filepaths = new String[]{"","",""};
			if (e.getSource().equals(win.getFileField1())) {
			}
			if (e.getSource().equals(win.getFileField2())) {
			}
			if (e.getSource().equals(win.getFileField3())) {
			}
			if (e.getSource().equals(win.getBackButton())) {
				state=0;
				clearText();
				win.clearPanel(win.getEncryptPanels());
				win.showPanel(win.getStartPanels());
			} else if (e.getSource().equals(win.getNextButton())) {
				filepaths[0] = win.getFileField1().getText();
				filepaths[1] = win.getFileField2().getText();
				filepaths[2] = win.getFileField3().getText();
				if (validateFilepaths(filepaths)) {
					win.getInfoArea().setText("The file was decrypted!");
					actionDecrypt(filepaths);
				} else
					win.getInfoArea().setText("The filepaths were not valid!");
			}
		}
	}
	
	public boolean validateFilepaths(String[] filePaths) {
		int i=0;
		while (i<3) {
			if (!isValidPath(filePaths[i]))
					i=4;
			i++;
		}
		return (i==3);
	}
	
	public boolean isValidPath(String filePath) {
			File f = new File(filePath); 
			return f.exists();
	}
	
	public void clearText() {
		win.getInfoArea().setText("");
		win.getFileField1().setText("");
		win.getFileField2().setText("");
		win.getFileField3().setText("");
	}
	
}

