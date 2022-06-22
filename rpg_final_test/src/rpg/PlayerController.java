package rpg;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PlayerController {
	static Scanner scan = new Scanner(System.in);
	
	public static int log = -1;
	public boolean loginCheck = false;
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	// 아이디 중복확인
	public boolean addUser(Player player) {
		boolean check = true;
		for(Player p : this.players) {
			if(p.getID().equals(player.getID())) {
				check = false;
			}
		}
		if(check) {
			Player newPlayer = new Player(player.getID(), player.getPW(), player.getName());
			this.players.add(newPlayer);
			return true;
		}
		return false;
	}
	
	public int checkLog(Player player) {
		for(int i=0; i<this.players.size(); i++) {
			Player p = this.players.get(i);
			if(p.getID().equals(player.getID()) && p.getPW().equals(player.getPW()))
				return i;
		}
		return -1;
	}
	
	// 로그인
//	public void loginUser() {
//		System.out.print("ID: ");
//		String id = scan.next();
//		System.out.print("PW: ");
//		String pw = scan.next();
//		
//		log = checkLog(new Player(id, pw));
//		
//		if(log == -1)
//			System.err.println("회원정보를 확인하세요.");
//		else {
//			System.out.printf("%s 님 로그인 성공\n", players.get(log).getName());
//		}
//	}
	
	// 회원가입
	public void joinUser() {
		System.out.print("ID: ");
		String id = scan.next();
		System.out.print("PW: ");
		String pw = scan.next();
		System.out.print("NAME: ");
		String name = scan.next();
		
		Player player = new Player(id, pw, name);
		
		boolean check = addUser(player);
		if(check)
			System.out.println("회원가입 완료");
		else
			System.err.println("중복된 아이디 입니다.");
	}
	
	// 회원전체출력
	public void printAllPlayer() {
		System.out.println("---------------------------");
		for(int i=0; i<this.players.size(); i++) {
			System.out.printf("[%d] (%s / %s / %s) \n", i+1, players.get(i).getID(), players.get(i).getPW(), players.get(i).getName());
		}
		System.out.println("---------------------------");
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}

}
