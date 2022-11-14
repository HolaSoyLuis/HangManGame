package hangedman;

public class Giver extends Player{
	public Giver(String name) {
		super(name);
	}
	
	public Giver() {}
	
	public void init(SecretWord secretWord) {
		System.out.println("Giver enter your name");
		String ename = Terminal.scan.nextLine();
		setName(ename);
		
		System.out.println("Set the secret word");
		String eword = Terminal.scan.nextLine();
		secretWord.setWord(eword);
		
		System.out.println("Attemps number?");
		int eattemps = Terminal.scan.nextInt();
		secretWord.setMaxAttemps(eattemps);
		
	}

}
