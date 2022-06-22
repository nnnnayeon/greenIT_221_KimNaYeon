package rpg;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PlayerController {
	static Scanner scan = new Scanner(System.in);
	
	public static int log = -1;
	public boolean loginCheck = false;
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	// ���̵� �ߺ�Ȯ��
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
	
	// �α���
//	public void loginUser() {
//		System.out.print("ID: ");
//		String id = scan.next();
//		System.out.print("PW: ");
//		String pw = scan.next();
//		
//		log = checkLog(new Player(id, pw));
//		
//		if(log == -1)
//			System.err.println("ȸ�������� Ȯ���ϼ���.");
//		else {
//			System.out.printf("%s �� �α��� ����\n", players.get(log).getName());
//		}
//	}
	
	// ȸ������
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
			System.out.println("ȸ������ �Ϸ�");
		else
			System.err.println("�ߺ��� ���̵� �Դϴ�.");
	}
	
	// ȸ����ü���
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
