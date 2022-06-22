package rpg;

import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Game {

	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	public static int log = -1;
	public static boolean run = true;

//	UserController uc = new UserController();
	Inventory iv = new Inventory();
	Shop shop = new Shop();

	public void run() {

		while (run) {
			System.out.println("[1.로그인] [2.회원가입]");
			System.out.println("[3.회원전체출력]");
			int sel = scan.nextInt();

			if (sel == 1) {
				System.out.print("ID: ");
				String id = scan.next();
				System.out.print("PW: ");
				String pw = scan.next();
				
//				log = uc.loginUser(id, pw);
				
				if(log == -1)
					System.err.println("회원정보를 확인하세요.");
				else {
//					System.out.printf("%s 님 로그인 성공\n", uc.getUsers().get(log).getName());
					GameStart(log);
				}
			} else if (sel == 2) {
//				uc.joinUser();
			} else if (sel == 3) {
//				uc.printAllPlayer();
			}
		}
	}

	public void GameStart(int log) {

		while (run) {

			System.out.println("[1.길드관리]");
			System.out.println("[2.상점] [3.창고관리]");
			System.out.println("[4.전투]");
			System.out.println("[5.저장] [6.로드] [0.종료]");
			System.out.print("입력: ");
			int sel = scan.nextInt();

			if (sel == 1) {} 
			else if (sel == 2) {shop.printShop(log);} 
			else if (sel == 3) {iv.inventoryMenu();} 
			else if (sel == 4) {} 
			else if (sel == 5) {} 
			else if (sel == 6) {} 
			else if (sel == 7) {} 
			else if (sel == 8) {} 
			else if (sel == 0) {
				this.run = false;
			}

		}
	}

}
