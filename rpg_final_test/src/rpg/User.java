package rpg;

import java.util.ArrayList;

public class User {
	private String id;
	private String pw;
	private String name;
	private int money;
//	private Player player;
	
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Item> itemList = new ArrayList<>();
	private ArrayList<Unit> partyList = new ArrayList<>();
//	private Party party = new Party(); ///////////////////////////////
	private ArrayList<Unit> myGuildList = new ArrayList<>();
	
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
		return itemList;
	}
	
	public ArrayList<Unit> getPartyList(){
		return partyList;
	}
	public void setPartyList(ArrayList<Unit> partyList) {
		this.partyList = partyList;
	}
	
	public ArrayList<Unit> getMyGuildList(){
		return myGuildList;
	}
	public void setMyGuildList(ArrayList<Unit> myGuildList) {
		this.myGuildList = myGuildList;
	}
	
	public int partyListSize() {
		return this.partyList.size();
	}
	
}
