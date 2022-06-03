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
		System.out.println("[1] �α���");
		System.out.println("[2] ȸ������");
		System.out.println("[3] ȸ��Ż��");
		System.out.println("[4] ���»���");
		System.out.println("[5] ����öȸ");
		System.out.println("[0] �α׾ƿ�");
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
			System.out.println("ȸ�������� Ȯ���ϼ���");
		else
			System.out.println("�α��� �Ϸ�");
	}
	
	private void removeUser() {
		System.out.print("id: ");
		String id = scan.next();
		System.out.print("pw: ");
		String pw = scan.next();
		
		int index = UserManager.instance.checkLog(new User(id, pw));
		
		if(log == -1)
			System.out.println("ȸ�������� Ȯ���ϼ���");
		else {
			UserManager.instance.deleteUser(index);
			System.out.println("ȸ��Ż�� �Ϸ�");
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
			System.out.println("ȸ������ �Ϸ�");
		else
			System.out.println("ȸ������ ����");
	}
	
	private void createAcc() {
//		AccountManager.instance.createAcc(log);
	}
	
	private void deleteAcc() {
		
	}

	public static void main(String[] args) {
		
		

	}

}
