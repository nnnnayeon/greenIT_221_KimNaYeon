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

	// 아이디 중복확인
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
	
	// 로그인
//	public boolean loginUser() {
//		System.out.print("ID: ");
//		String id = Game.scan.next();
//		System.out.print("PW: ");
//		String pw = Game.scan.next();
//		
//		log = checkLog(new User(id, pw));
//		
//		if(log == -1)
//			System.err.println("회원정보를 확인하세요.");
//		else {
//			System.out.printf("%s 님 로그인 성공\n", users.get(log).getName());
//			return true;
//		}
//		return false;
//	}
	
	// 회원가입
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
			System.out.println("회원가입 완료");
		else
			System.err.println("중복된 아이디 입니다.");
	}
	
	// 회원전체출력
	public void printAllPlayer() {
		System.out.println("---------------------------");
		for(int i=0; i<this.users.size(); i++) {
			System.out.printf("[%d] (%s / %s / %s) \n", i+1, users.get(i).getID(), users.get(i).getPW(), users.get(i).getName());
		}
		System.out.println("---------------------------");
	}
	
	

}
