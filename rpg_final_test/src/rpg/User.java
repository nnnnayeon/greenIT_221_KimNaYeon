package rpg;

public class User {
	private String id;
	private String pw;
	private String name;
	private Player player;
	
//	public static int money;
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.player = new Player();
		this.player.money = 100000;
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
	public Player getPlayer() {
		return this.player;
	}
	
	
}
