package lmsMap;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lms {
	
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	
	private String name;
	private boolean isRun;
	
	private String[] menuList = {"등록", "수정", "삭제", "조회", "종료"};
	
	private StudentController sc;
	
	public void selectMenu() {
		System.out.print("입력: ");
		try {
			int sel = scan.nextInt();
			
			if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 5) {}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("번호를 입력해주세요.");
		}
	}
	
	public void run() {
		while(isRun) {
			System.out.printf("[%s (%d)]\n", this.name);
		}
		System.out.println("Shutting Down");
	}
	
	public static void printMenu(String[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.printf("%d) %s\n", i+1, list[i]);
		}
	}

}
