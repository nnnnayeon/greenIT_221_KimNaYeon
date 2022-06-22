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
			System.out.println("[1.로그인] [2.회원가입]");
			System.out.println("[3.회원전체출력]");
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
			System.err.println("회원정보를 확인하세요.");
		else {
			System.out.printf("%s 님 로그인 성공\n", pc.getPlayers().get(log).getName());
			GameStart();
		}
	}
	
	public void GameStart() { 
		
		while(true) {
			
			System.out.println("[1.길드관리]");
			System.out.println("[2.상점] [3.창고관리]");
			System.out.println("[4.스테이지] [5.전투]");
			System.out.println("[6.저장] [7.로드] [0.종료]");
			System.out.print("입력: ");
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
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			
		}
	}
	
}

