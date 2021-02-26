package ui;

import java.util.Scanner;

public class ConsoleUI {
	Scanner input = new Scanner(System.in);
	
	public String handleInput() {
		return input.nextLine();
	}
	
	public void handleOutput(String out) {
		System.out.println(out);
	}
}
