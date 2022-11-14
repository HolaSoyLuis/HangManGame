package hangedman;

public class SecretWord {
	private String word;
	private int maxAttemps;
	private int countAttemps;
	private String attempedWord = "";
	private String attempedCharacters = "";
	private String noRepeatCharacters = "";
	
	public SecretWord() {}
	
	public SecretWord(String word, int maxFails) {
		this.word = word;
		maxFails = word.length();
		// countAttemps = 0;
		noRepeatCharacters = "";
		attempedCharacters = "";
		initNoRepeatCharacters();
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getCountAttemps() {
		return countAttemps;
	}

	public void setCountAttemps(int countFails) {
		this.countAttemps = countFails;
	}

	public int getMaxAttemps() {
		return maxAttemps;
	}
	
	public void setMaxAttemps(int maxFails) {
		this.maxAttemps = maxFails;
	}
	
	public boolean isInSoloCharacters(char character) {
		if(word.indexOf(character) > -1) return true;
		return false;
	}
	
	public void initNoRepeatCharacters() {
		for(int i = 0; i < word.length(); i++) {
			// if(word.indexOf(word.charAt(i))) == -1)
			String schar = String.format("%c", word.charAt(i));
			if(noRepeatCharacters.indexOf(word.charAt(i)) > -1) noRepeatCharacters += schar;
		}
	}
	
	// Attemps
	public void charAttemp(char character) {
		if(attempedCharacters.indexOf(character) > -1) return;
		String schar = String.format("%c", character);
		if(word.indexOf(character) != -1) attempedCharacters += schar;
		else countAttemps++;
	}
	
	public void wordAttemp(String incomingWord) {
		if(this.word == incomingWord) attempedWord = incomingWord;
		else countAttemps++;
	}
	
	// Print
	public void printWord() {
		for(int i = 0; i < word.length(); i++) {
			if(attempedCharacters.charAt(word.charAt(i)) > -1) System.out.print(word.charAt(i));
			else System.out.print("_");
		}
	}
	
	public void printAttempedCharacters() {
		for(int i = 0; i < word.length(); i++) {
			System.out.println(attempedCharacters.charAt(i) + " ");
		}
	}
	
	// Check win/lost
	public boolean hasWon() {
		boolean charactersMatch = true;
		for(int i = 0; i < word.length(); i++) {
			// if(attempedCharacters.charAt(word.charAt(i)) > -1) charactersMatch = false;
			if(word.indexOf(attempedCharacters.charAt(i)) > -1) charactersMatch = false;
		}
		if(charactersMatch) return true;
		if(attempedWord == word) return true;
		return false;
	}
	
	public boolean hasLost() {
		if(countAttemps == maxAttemps) return true;
		return false;
	}

}
