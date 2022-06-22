package shop;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class UserManager {
	private Random ran = new Random();
	private Scanner scan = new Scanner(System.in);
	
	Vector<User> userList = new Vector<User>();
	int userLog = -1;
	
	public UserManager() {
		init();
	}
	
	public void init() {
		String[] a = { "��", "��", "��", "��", "��", "��" };
		String[] b = { "ö", "��", "��", "��", "��", "��" };
		String[] c = { "��", "��", "��", "��", "��", "��" };
		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			User temp = new User(name, ran.nextInt(5000));
			userList.add(temp);
		}
	}
	
	public void join() {
		System.out.println("[����] id �� �Է��ϼ���.");
		String id = scan.next();
		User temp = new User(id, 0);
		this.userList.add(temp);
		System.out.println("[�޼���]" + temp.id + "�� ������ �����մϴ�.");
	}
	
	public boolean logIn() {
		userLog = -1;
		System.out.println("[�α���] id �� �Է��ϼ���.");
		String id = scan.next();
		for(int i=0; i<this.userList.size(); i++) {
			if(id.equals(this.userList.get(i).id)) {
				userLog = i;
				break;
			}
		}
		if(userLog == -1) {
			System.out.println("[�޼���] ���� id �Դϴ�.");
		} else {
			System.out.println("[�޼���]" + this.userList.get(userLog).id + "�� �α���.");
			return true;
		}
		return false;
	}
	
	public void logOut() {
		if(userLog != -1) {
			System.out.println("[�޼���]" + this.userList.get(userLog).id + "�� �α׾ƿ�.");
		}
		this.userLog = -1;
	}
	
	public void printUser() {
		for(int i=0; i<this.userList.size(); i++) {
			System.out.println("[" + i + "] ");
			this.userList.get(i).print();
		}
	}
	
	
}
