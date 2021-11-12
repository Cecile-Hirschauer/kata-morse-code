package morse;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUserInterface {
	MorseDecoder decoder = new MorseDecoder();
	MorseEncoder encoder = new MorseEncoder();
	private InputStream inputStream;
	private PrintStream printStream;
	private Scanner scanner;

	public ConsoleUserInterface(InputStream in, PrintStream out) {
		this.inputStream = in;
		this.printStream = out;
		this.scanner = new Scanner(inputStream);

	}
	
	public void run() {
		String message = readLine();	
		try {
			evaluate(message);
		}
		catch (Exception e) {
			printErrorMessage(e);
		}
	}

	private void printErrorMessage(Exception e) {
		System.out.println("Message error " + e.getMessage());
	}
	

	private void evaluate(String message) {
		StringBuilder result = new StringBuilder();
		char[] messageCharacters = message.toCharArray();
		  
		if (Character.isDigit(messageCharacters[0]) || Character.isLetter(messageCharacters[0])) {
			result.append(encoder.encodeMessage(message));	
		} else {
			result.append(decoder.decodeMessage(message));
		}
        

		if (message != null) {
			printStream.println(result);
		}
	}
	

	private String readLine() {
		return scanner.nextLine();
	}

}



