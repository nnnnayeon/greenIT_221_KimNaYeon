package Shop1_1;

public class User {
	
	private String id;
	private String pw;
	private int money;
	
	public User(String id, String pw, int money) {
		this.id = id;
		this.pw = pw;
		this.money = money;
	}
	
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public int getMoney() {
		return this.money;
	}
	
	public void print() {
		System.out.println("[" + id + "]" + "ฑÝพื: " + money);
	}
}
