package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	JButton encryptButton, dencryptButton, nextButton, backButton, ButtonFinish;
	JTextField nameField;
	JTextField fileField1, fileField2, fileField3, infoField;
	JLabel fileName1, fileName2, fileName3;
	JPanel filePanel1, filePanel2, filePanel3, pathPanel1, pathPanel2, pathPanel3, nextPanel, backPanel, infoPanel;
	JTextArea infoArea;
	JPanel[] startPanels;
	JPanel[] encryptPanels;
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\vidali\\Desktop\\icon.png");
	
	public Window() {
		super("RAMEncrypt");
		getContentPane().setLayout(new FlowLayout());
		window = new JFrame("RAMEncrypt");
		window.setIconImage(icon);
		window.setSize(320, 240);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane();
		window.getContentPane().setLayout(null);
		window.setVisible(true);
		window.setResizable(false);
		con = window.getContentPane();
		this.titleNamePanel = new JPanel();
		this.titleNameLabel = new JLabel("RAMEncrypt v0.1");
		this.encryptButton = new JButton("Encypt");
		this.dencryptButton = new JButton("De-encrypt");
		this.startButtonPanel = new JPanel();
		this.filePanel1 = new JPanel();
		filePanel2 = new JPanel();
		filePanel3 = new JPanel();
		fileName3 = new JLabel();
		pathPanel1 = new JPanel();
		pathPanel2 = new JPanel();
		pathPanel3 = new JPanel();
		fileField1 = new JTextField(10);
		fileField2 = new JTextField(10);
		fileField3 = new JTextField(10);
		nextButton = new JButton("FINISH");
		backButton = new JButton("BACK");
		fileName1 = new JLabel();
		fileName2 = new JLabel();
		fileName3 = new JLabel();
		nextPanel = new JPanel();
		backPanel = new JPanel();
		infoPanel = new JPanel();
		infoArea = new JTextArea();
		startPanels = new JPanel[] {titleNamePanel, startButtonPanel};
		//initStartScreen();
		//initEncryptWindow();
	}
	
	public void initEncryptWindow(String path1, String path2, String path3) {
		this.filePanel1.setBounds(20, 13, 128, 30);
		
		fileName1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fileName1.setHorizontalAlignment(SwingConstants.LEFT);
		this.fileName1.setForeground(Color.black);
		this.filePanel1.add(fileName1);
		
		filePanel2.setBounds(20, 86, 128, 30);
		fileName2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fileName2.setHorizontalAlignment(SwingConstants.LEFT);
		filePanel2.add(fileName2);
	
		filePanel3.setBounds(160, 13, 128, 30);
		fileName3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fileName3.setHorizontalAlignment(SwingConstants.LEFT);
		filePanel3.add(fileName3);
	
		fileField1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pathPanel1.setBounds(20, 43, 128, 30);
		pathPanel1.add(fileField1);
	
		fileField2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pathPanel2.setBounds(20, 116, 128, 30);
		fileField2.setBounds(20, 150, 60, 30);
		fileField2.setBackground(Color.WHITE);
		pathPanel2.add(fileField2);

		fileField3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pathPanel3.setBounds(160, 43, 128, 30);
		fileField3.setBounds(160, 60, 60, 30);
		fileField3.setBackground(Color.WHITE);
		pathPanel3.add(fileField3);
		
	
		nextPanel.setBounds(228, 157, 60, 35);

		backPanel.setBounds(20, 157, 60, 35);
		
	
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 10));

		backButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		nextPanel.add(nextButton);
		backPanel.add(backButton);
		

		infoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		infoPanel.setBounds(160, 86, 128, 60);
		infoPanel.setLayout(new BorderLayout(0, 0));

		infoArea.setEditable(false);
		infoArea.setWrapStyleWord(true);
		infoArea.setTabSize(2);
		infoArea.setLineWrap(true);
		infoArea.setFont(new Font("Javanese Text", Font.PLAIN, 10));
		infoPanel.add(infoArea);
		
		setEncrypt(path1, path2, path3);
		
		con.add(filePanel1);
		con.add(filePanel2);
		con.add(filePanel3);
		con.add(pathPanel1);
		con.add(pathPanel2);
		con.add(pathPanel3);
		con.add(nextPanel);
		con.add(backPanel);
		con.add(infoPanel);
		this.window.setVisible(true);
		this.con.setVisible(true);
		encryptPanels = new JPanel[] {filePanel1, filePanel2, filePanel3, pathPanel1, pathPanel2, pathPanel3, nextPanel, backPanel, infoPanel};
	}
	
	public void setEncrypt(String path1, String path2, String path3) {
		fileName1.setText(path1);
		fileName2.setText(path2);
		fileName3.setText(path3);
	}
	
	public void initStartScreen() {
		
		this.titleNamePanel.setBounds(35, 50, 240, 50);
		
		this.titleNameLabel.setForeground(Color.black);
		
		this.startButtonPanel.setBounds(105, 100, 100, 80);
		
		this.encryptButton.setForeground(Color.black);
	
		this.encryptButton.setFocusPainted(false);
		
		this.dencryptButton.setForeground(Color.black);
		this.dencryptButton.setFocusPainted(false);
		
		this.titleNamePanel.add(titleNameLabel);
		this.startButtonPanel.add(encryptButton);
		this.startButtonPanel.add(dencryptButton);
		
		this.con.add(titleNamePanel);
		this.con.add(startButtonPanel);
		this.window.setVisible(true);
		this.con.setVisible(true);
	}
	
	public void clearPanel(JPanel[] panels) {
		for (int i = 0; i<panels.length; i++) {
			panels[i].setVisible(false);
		}
	}
	
	public void showPanel(JPanel[] panels) {
		for (JPanel a: panels) 
			a.setVisible(true);
	}
	
	public JPanel[] getStartPanels() {
		return startPanels;
	}

	public JPanel[] getEncryptPanels() {
		return encryptPanels;
	}

	public void initEncryptScreen() {
		
	}
	
	public JButton getButton1() {
		return encryptButton;
	}

	public void setButton1(JButton button1) {
		encryptButton = button1;
	}

	public JButton getButton2() {
		return dencryptButton;
	}

	public void setButton2(JButton button2) {
		dencryptButton = button2;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JTextField getFileField3() {
		return fileField3;
	}

	public void setFileField3(JTextField fileField3) {
		this.fileField3 = fileField3;
	}

	public JTextField getFileField1() {
		return fileField1;
	}

	public JTextField getFileField2() {
		return fileField2;
	}

	public JTextArea getInfoArea() {
		return infoArea;
	}
	
	
}
