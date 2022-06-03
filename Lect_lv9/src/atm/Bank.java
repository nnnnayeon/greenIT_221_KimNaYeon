package atm;

import java.util.Scanner;

public class Bank {
	private Scanner scan = new Scanner(System.in);
	
	private static String name;
	public static int log = -1;
	
	public static Bank instance = new Bank();
	
	private Bank() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void run() {
		while(true) {
			printMenu();
			selectMenu();
		}
	}
	
	private void printMenu() {
		System.out.println("[1] 로그인");
		System.out.println("[2] 회원가입");
		System.out.println("[3] 회원탈퇴");
		System.out.println("[4] 계좌생성");
		System.out.println("[5] 계좌철회");
		System.out.println("[0] 로그아웃");
	}
	
	private void selectMenu() {
		System.out.print("sel: ");
		int sel = scan.nextInt();
		
		if(sel == 1) loginUser();
		else if(sel == 2) joinUser();
		else if(sel == 3) removeUser();
		else if(sel == 4 && log != -1) createAcc();
		else if(sel == 5 && log != -1) deleteAcc();
		else if(sel == 0)
			log = -1;
	}
	
	private void loginUser() {
		System.out.print("id: ");
		String id = scan.next();
		System.out.print("pw: ");
		String pw = scan.next();
		
		log = UserManager.instance.checkLog(new User(id, pw));
		
		if(log == -1)
			System.out.println("회원정보를 확인하세요");
		else
			System.out.println("로그인 완료");
	}
	
	private void removeUser() {
		System.out.print("id: ");
		String id = scan.next();
		System.out.print("pw: ");
		String pw = scan.next();
		
		int index = UserManager.instance.checkLog(new User(id, pw));
		
		if(log == -1)
			System.out.println("회원정보를 확인하세요");
		else {
			UserManager.instance.deleteUser(index);
			System.out.println("회원탈퇴 완료");
		}
	}
	
	private void joinUser() {
		System.out.print("id: ");
		String id = scan.next();
		System.out.print("pw: ");
		String pw = scan.next();
		System.out.print("name: ");
		String name = scan.next();
		
		User user = new User(id, pw, name);
		
		boolean success = UserManager.instance.addUser(user);
		if(success)
			System.out.println("회원가입 완료");
		else
			System.out.println("회원가입 실패");
	}
	
	private void createAcc() {
//		AccountManager.instance.createAcc(log);
	}
	
	private void deleteAcc() {
		
	}

	public static void main(String[] args) {
		
		

	}

}
