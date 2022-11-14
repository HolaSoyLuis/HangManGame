package hangedman;

public abstract class Player {
	private String name;
	
	public Player(String name) {}
	public Player() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
