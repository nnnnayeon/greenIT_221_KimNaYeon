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
			System.out.println("[1.로그인] [2.회원가입]");
			System.out.println("[3.회원전체출력]");
			int sel = scan.nextInt();
			
			if(sel == 1) {pc.loginUser();}
			else if(sel == 2) {pc.joinUser();}
			else if(sel == 3) {pc.printAllPlayer();}
		}
	}
	
	public void GameStart() { 
		
		while(true) {
			
			System.out.println("[1.유저관리] [2.길드관리]");
			System.out.println("[3.상점] [4.창고관리]");
			System.out.println("[5.스테이지] [6.전투]");
			System.out.println("[7.저장] [8.로드] [0.종료]");
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

