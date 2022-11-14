package hangedman;

import java.util.Scanner;

public class HangedManGame {
	public static Scanner scan = new Scanner(System.in);
	
	private Giver giver;
	private Guesser guesser;
	private SecretWord secretWord;
	
	public HangedManGame() {
		giver = new Giver();
		guesser = new Guesser();
		secretWord = new SecretWord();
	}

	public void initGame() {
		giver.init(secretWord);
		guesser.init();
	}
	
	public void printMenu() {
		System.out.println("1. Attemp to guess a character.");
		System.out.println("2. Attemp to guess a word.");
	}
	
	public void showResult() {
		if(secretWord.hasWon()) {
			System.out.println("Well done " + guesser + " =D you guessed the word");
			System.out.println("Giver " + giver + " has lost :(");
		}
		if(secretWord.hasLost()) {
			System.out.println("You lost " + guesser + ". good luck for the next time");
			System.out.println("Giver " + giver + " made it impossible");
		}
	}
	
	public void showInformation() {
		System.out.print("Word status: ");
		secretWord.printWord();
		System.out.println("");
	}
	
	public void printLines() {
		System.out.printf("\n\n\n\n\n\n\n\n\n\n");
	}
		
	public void execute() {
		initGame();
		boolean isPlaying = true;
		int input = 0;
		do {
			// if(secretWord.isWinner()) isPlaying = false;
			printMenu();
			input = Terminal.scan.nextInt();
			switch(input) {
				case 1:
					guesser.attempAChar(secretWord);
					break;
				case 2:
					guesser.attempAWord(secretWord);
					break;
				default:
					System.out.println("Selecciona una opcion valida");
			}
			// if(secretWord.hasWon() || secretWord.hasLost()) {
			if(secretWord.hasLost()) {
				showResult();
				isPlaying = false;
			}
		} while(isPlaying);
	}

}
