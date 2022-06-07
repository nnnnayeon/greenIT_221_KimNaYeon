package Shop1_1;

import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	
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
			else if(sel == 2) {um.remove();}
			else if(sel == 3) {if(um.login()) loginMenu();}
			else if(sel == 4) {um.logout();}
			else if(sel == 0) {break;}
			else if(sel == 100) {managerMenu();}
		}
	}
	
	public void loginMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 쇼핑");
			System.out.println("[2] 장바구니목록");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {shopMenu();}
			else if(sel == 2) {cartMenu();}
			else if(sel == 0) {break;}
			
		}
	}
	
	public void shopMenu() {
		boolean isRun = true;
		while(isRun) {
			im.printCategory();
			System.out.print("입력: ");
			int cateNum = scan.nextInt();
			im.printItemList(cateNum);
			int itemNum = scan.nextInt();
			///////////////////////////////////////
			im.addCart(um.getUserList().get(um.getLog()).getId(), cateNum, itemNum);
		}
	}
	
	public void cartMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 내 장바구니");
			System.out.println("[2] 삭제");
			System.out.println("[3] 구입");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {im.printjang(um.getUserList().get(um.getLog()));}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 0) {break;}
		}
	}
	
	public void managerMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 아이템 관리");
			System.out.println("[2] 카테고리 관리");
			System.out.println("[3] 장바구니 관리");
			System.out.println("[4] 회원 관리");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {itemMenu();}
			else if(sel == 2) {categoryMenu();}
			else if(sel == 3) {}
			else if(sel == 4) {userMenu();}
			else if(sel == 0) {break;}
		}
	}
	
	public void itemMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 전체 아이템 출력");
			System.out.println("[2] 아이템 추가");
			System.out.println("[3] 아이템 삭제");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {im.printItemList();}
			else if(sel == 2) {im.addItem();}
			else if(sel == 3) {im.removeItem();}
			else if(sel == 0) {break;}
		}
	}
	
	public void categoryMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 전체 카테고리 출력");
			System.out.println("[2] 카테고리 추가");
			System.out.println("[3] 카테고리 삭제");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {im.printCategory();}
			else if(sel == 2) {im.addCategory();}
			else if(sel == 3) {im.removeCategory();}
			else if(sel == 0) {break;}
		}
	}
	
	public void userMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] 전체회원 출력");
			System.out.println("[2] 회원 추가");
			System.out.println("[3] 회원 삭제");
			System.out.println("[0] 뒤로가기");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {um.printUser();}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {break;}
		}
	}

}
