package rpg;

import java.util.ArrayList;

public class User {
	private String id;
	private String pw;
	private String name;
	private int money;
//	private Player player;
	
	private ArrayList<Player> players = new ArrayList<>();
	
	public static Inventory iven = new Inventory();
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
//		this.player = new Player();
		this.money = 100000;
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

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<Item> getItemList(){
		return iven.itemList;
	}
//	public Player getPlayer() {
//		return this.player;
//	}
	
	
}
