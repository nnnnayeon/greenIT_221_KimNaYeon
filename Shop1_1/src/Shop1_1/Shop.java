package Shop1_1;

import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	
	UserManager um = new UserManager();
	
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
			System.out.println("[1] ����");
			System.out.println("[2] ��ٱ��ϸ��");
			System.out.println("[0] �ڷΰ���");
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
