package Shop1_1;

import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	
	UserManager um = new UserManager();
	
	public void mainMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 가입");
			System.out.println("[2] 탈퇴");
			System.out.println("[3] 로그인");
			System.out.println("[4] 로그아웃");
			System.out.println("[0] 종료");
			System.out.println("[100] 관리자");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {um.join();}
			else if(sel == 2) {}
			else if(sel == 3) {um.login();}
			else if(sel == 4) {um.logout();}
			else if(sel == 0) {break;}
			else if(sel == 100) {}
		}
	}
	
	public void loginMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 쇼핑");
			System.out.println("[2] 장바구니목록");
			System.out.println("[0] 뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 0) {break;}
			
		}
	}
	
	public void shopMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println();
		}
	}

}
