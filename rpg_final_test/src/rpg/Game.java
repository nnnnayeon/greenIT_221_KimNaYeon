package rpg;

import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Game{
	
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	
	public void run() {
		PlayerController pc = new PlayerController();
		
		while(true) {
			System.out.println("[1.�α���] [2.ȸ������]");
			System.out.println("[3.ȸ����ü���]");
			int sel = scan.nextInt();
			
			if(sel == 1) {pc.loginUser();}
			else if(sel == 2) {pc.joinUser();}
			else if(sel == 3) {pc.printAllPlayer();}
		}
	}
	
	public void GameStart() { 
		
		while(true) {
			
			System.out.println("[1.��������] [2.������]");
			System.out.println("[3.����] [4.â�����]");
			System.out.println("[5.��������] [6.����]");
			System.out.println("[7.����] [8.�ε�] [0.����]");
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

