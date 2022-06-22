package rpg;

import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Game{
	
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	
	public static int log = -1;
	
	PlayerController pc = new PlayerController();
	public void run() {
		
		while(true) {
			System.out.println("[1.�α���] [2.ȸ������]");
			System.out.println("[3.ȸ����ü���]");
			int sel = scan.nextInt();
			
			if(sel == 1) {login();}
			else if(sel == 2) {pc.joinUser();}
			else if(sel == 3) {pc.printAllPlayer();}
		}
	}
	
	public void login() {
		System.out.print("ID: ");
		String id = scan.next();
		System.out.print("PW: ");
		String pw = scan.next();
		
		log = pc.checkLog(new Player(id, pw));
		
		if(log == -1)
			System.err.println("ȸ�������� Ȯ���ϼ���.");
		else {
			System.out.printf("%s �� �α��� ����\n", pc.getPlayers().get(log).getName());
			GameStart();
		}
	}
	
	public void GameStart() { 
		
		while(true) {
			
			System.out.println("[1.������]");
			System.out.println("[2.����] [3.â�����]");
			System.out.println("[4.��������] [5.����]");
			System.out.println("[6.����] [7.�ε�] [0.����]");
			System.out.print("�Է�: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 5) {}
			else if(sel == 6) {}
			else if(sel == 7) {}
			else if(sel == 8) {}
			else if(sel == 0) {
				System.out.println("������ �����մϴ�.");
				break;
			}
			
			
		}
	}
	
}

