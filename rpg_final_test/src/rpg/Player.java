package rpg;

public class Player {
	private String id;
	private String pw;
	private String name;
	
	public Player(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public Player(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getID() {
		return this.id;
	}
	public String getPW() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	
	
	
}
