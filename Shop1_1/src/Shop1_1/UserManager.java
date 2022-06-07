package Shop1_1;

import java.util.Scanner;
import java.util.Vector;

public class UserManager {
	private Scanner scan = new Scanner(System.in);
	
	private int log = -1;
	private Vector<User> userList = new Vector<User>();
	
	public void join() {
		System.out.print("[join] ID: ");
		String id = scan.next();
		System.out.print("[join] PW: ");
		String pw = scan.next();
		
		boolean check = true;
		for(int i=0; i<this.userList.size(); i++) {
			if(id.equals(this.userList.get(i).getId())) {
				check = false;
			}
		}
		if(check) {
			User temp = new User(id, pw, 0);
			this.userList.add(temp);
			System.out.println("회원가입 완료");
		}
		else
			System.out.println("중복된 아이디입니다.");
	}
	
	public void remove() {
		System.out.print("[remove] ID: ");
		String id = scan.next();
		System.out.print("[remove] PW: ");
		String pw = scan.next();
		
		User delTemp = null;
		for(int i=0; i<this.userList.size(); i++) {
			if(id.equals(this.userList.get(i).getId()) && pw.equals(this.userList.get(i).getPw())) {
//				delTemp = this.userList;
			}
		}
//		if(this.log != -1) {
//			System.out.println("[remove] PW: ");
//			String pw = scan.next();
//			
//			User delTemp = null;
//			if(pw.equals(this.userList.get(log).getPw())) {
//				
//			}
//		}
	}
	
	public boolean login() {
		System.out.print("[login] ID: ");
		String id = scan.next();
		System.out.print("[login] PW: ");
		String pw = scan.next();
		
		for(int i=0; i<this.userList.size(); i++) {
			if(id.equals(this.userList.get(i).getId()) && pw.equals(this.userList.get(i).getPw())) {
				this.log = i;
				break;
			}
		}
		
		if(this.log == -1)
			System.out.println("회원정보를 확인하세요.");
		else {
			System.out.println(this.userList.get(log).getId() + "님 로그인");
			return true;
		}
		return false;
	}
	
	public void logout() {
		if(this.log != -1) {
			System.out.println(this.userList.get(log).getId() + "님 로그아웃");
			
			this.log = -1;
		}
	}
	
	public void printUser() {
		for(int i=0; i<this.userList.size(); i++) {
			System.out.print("[" + i + "]");
			this.userList.get(i).print();
		}
	}
	
}
