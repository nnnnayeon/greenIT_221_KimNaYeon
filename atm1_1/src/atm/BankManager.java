package atm;

import java.util.Scanner;

public class BankManager {
	
	private Scanner scan = new Scanner(System.in);
	
	static BankManager instance = new BankManager();
	
	private Bank bank = Bank.instance;
	
	public void printMenu() {
		System.out.println("[" + bank.name + " ATM]");
		System.out.println("[1] 로그인");
		System.out.println("[2] 회원가입");
		System.out.println("[0] 종료");
	}
	
	public void play() {
//		FileManager.instance.load();
	}
	
	
	
}
