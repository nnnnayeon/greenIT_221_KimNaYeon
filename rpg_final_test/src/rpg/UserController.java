package rpg;

import java.util.ArrayList;
import java.util.Map;

public class UserController {
	
	public static int log = -1;
	public boolean loginCheck = false;
	
	private static ArrayList<User> users = new ArrayList<User>();
	
	private static UserController instance = new UserController();
	private UserController() {}
	
	public static UserController getInstance() {
		return instance;
	}
	
	
	
	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		UserController.users = users;
	}

	// ���̵� �ߺ�Ȯ��
	public boolean addUser(User user) {
		boolean check = true;
		for(User p : this.users) {
			if(p.getID().equals(user.getID())) {
				check = false;
			}
		}
		if(check) {
			User newUser = new User(user.getID(), user.getPW(), user.getName());
			this.users.add(newUser);
			return true;
		}
		return false;
	}
	
//	public int checkLog(User user) {
//		for(int i=0; i<this.users.size(); i++) {
//			User u = this.users.get(i);
//			if(u.getID().equals(user.getID()) && u.getPW().equals(user.getPW()))
//				return i;
//		}
//		return -1;
//	}
	
	public int loginUser(String id, String pw) {
		
		int log = -1;
		for(int i=0; i<this.users.size(); i++) {
			User u = this.users.get(i);
			if(u.getID().equals(id) && u.getPW().equals(pw))
				log = i;
		}
		return log;
	}
	
	// �α���
//	public boolean loginUser() {
//		System.out.print("ID: ");
//		String id = Game.scan.next();
//		System.out.print("PW: ");
//		String pw = Game.scan.next();
//		
//		log = checkLog(new User(id, pw));
//		
//		if(log == -1)
//			System.err.println("ȸ�������� Ȯ���ϼ���.");
//		else {
//			System.out.printf("%s �� �α��� ����\n", users.get(log).getName());
//			return true;
//		}
//		return false;
//	}
	
	// ȸ������
	public void joinUser() {
		System.out.print("ID: ");
		String id = Game.scan.next();
		System.out.print("PW: ");
		String pw = Game.scan.next();
		System.out.print("NAME: ");
		String name = Game.scan.next();
		
		User user = new User(id, pw, name);
		
		boolean check = addUser(user);
		if(check)
			System.out.println("ȸ������ �Ϸ�");
		else
			System.err.println("�ߺ��� ���̵� �Դϴ�.");
	}
	
	// ȸ����ü���
	public void printAllPlayer() {
		System.out.println("---------------------------");
		for(int i=0; i<this.users.size(); i++) {
			System.out.printf("[%d] (%s / %s / %s) \n", i+1, users.get(i).getID(), users.get(i).getPW(), users.get(i).getName());
		}
		System.out.println("---------------------------");
	}
	
	

}
