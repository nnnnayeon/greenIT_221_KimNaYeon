package atm;

import java.util.ArrayList;

public class User {
	private int code, accCnt;
	private String id, pw;
	private String name;
	
	private ArrayList<Account> accs;
	
	// �α� ���� �뵵
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// ����ڸ� ���� �Է¹��� ������ -> �� ��ü ���� �뵵
	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	// ������ �Ϸ�� ��ü�� ���Ͽ� -> �� ������ȭ�ϴ� �뵵
	public User(int code, String id, String pw, String name) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
		
		accs = new ArrayList<Account>();
	}
	
	// getter & setter
	public int getCode() {
		return code;
	}
	
	public int getAccCnt() {
		return accCnt;
	}
	
	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Account> getAccs(){
		return this.accs;
	}
	
	
}
