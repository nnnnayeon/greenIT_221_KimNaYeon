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
	
	
	// 내 길드원 print
	public void printMyGuild(User u) {
		System.out.println("=============길드원=============");
		for(int i=0; i<getMyGuildList().size(); i++) {
			System.out.printf("%d번) ", i+1);
			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", getMyGuildList().get(i).name, getMyGuildList().get(i).level, getMyGuildList().get(i).hp, getMyGuildList().get(i).maxHp);
			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", getMyGuildList().get(i).att, getMyGuildList().get(i).def, getMyGuildList().get(i).party);
			System.out.println();
		}
		System.out.println("==============================");
	}
	
	// 파티원 print
	public void printMyParty(User u) {
		System.out.println("-------------파티원------------");
		for(int i=0; i<getPartyList().size(); i++) {
			System.out.printf("%d번) ", i+1);
			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", getPartyList().get(i).name, getPartyList().get(i).level, getPartyList().get(i).hp, getPartyList().get(i).maxHp);
			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", getPartyList().get(i).att, getPartyList().get(i).def, getPartyList().get(i).party);
			System.out.println();
		}
		System.out.println("-----------------------------");
	}
	
}
