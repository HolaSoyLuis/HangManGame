package hangedman;

public class Guesser extends Player{
	public Guesser(String name) {
		super(name);
	}
	
	public Guesser() {}
	
	public void attempAWord(SecretWord secretWord) {
		System.out.println("Enter your word:");
		String word = Terminal.scan.next();
		secretWord.wordAttemp(word);
	}
	
	public void attempAChar(SecretWord secretWord) {
		System.out.println("Enter your character:");
		String character = Terminal.scan.next();
		secretWord.charAttemp(character.charAt(0));
	}
	
	public void init() {
		System.out.println("Guesser enter your name");
		setName(Terminal.scan.nextLine());
	}

}
