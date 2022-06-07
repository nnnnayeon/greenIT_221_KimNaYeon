package Shop1_1;

import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	
	public void mainMenu() {
		boolean isRun = true;
		while(isRun) {
			System.out.println("[1] ����");
			System.out.println("[2] Ż��");
			System.out.println("[3] �α���");
			System.out.println("[4] �α׾ƿ�");
			System.out.println("[0] ����");
			System.out.println("[100] ������");
			System.out.print("�Է�: ");
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
			System.out.println("[1] ����");
			System.out.println("[2] ��ٱ��ϸ��");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
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
			System.out.print("�Է�: ");
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
			System.out.println("[1] �� ��ٱ���");
			System.out.println("[2] ����");
			System.out.println("[3] ����");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
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
			System.out.println("[1] ������ ����");
			System.out.println("[2] ī�װ� ����");
			System.out.println("[3] ��ٱ��� ����");
			System.out.println("[4] ȸ�� ����");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
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
			System.out.println("[1] ��ü ������ ���");
			System.out.println("[2] ������ �߰�");
			System.out.println("[3] ������ ����");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
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
			System.out.println("[1] ��ü ī�װ� ���");
			System.out.println("[2] ī�װ� �߰�");
			System.out.println("[3] ī�װ� ����");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
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
			System.out.println("[1] ��üȸ�� ���");
			System.out.println("[2] ȸ�� �߰�");
			System.out.println("[3] ȸ�� ����");
			System.out.println("[0] �ڷΰ���");
			System.out.print("�Է�: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {um.printUser();}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {break;}
		}
	}

}
