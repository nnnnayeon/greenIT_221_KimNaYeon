package shop;

public class User {
	String id; 
	int money;
	
	public User(String id, int money) {
		this.id = id;
		this.money = money;
	}
	
	public void print(){
		System.out.println("[" + id + "]" + "�ݾ� : " + money);
	}

}
