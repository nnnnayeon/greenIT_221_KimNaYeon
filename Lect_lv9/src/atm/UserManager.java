package atm;

import java.util.ArrayList;
import java.util.Random;

public class UserManager {
	private Random ran = new Random();
	
	public static UserManager instance = new UserManager();
	
	////////////
	private UserManager() {
		
	}

	private static ArrayList<User> users = new ArrayList<User>();
	
	public boolean addUser(User user) {
		// 중복검사 -> user.add()
		boolean check = true;
		for(User u : this.users) {
			if(u.getId().equals(user.getId())) {
				check = false;
			}
		}
		if(check) { // 검증완료됨
			User newUser = new User(createCode(), user.getId(), user.getPw(), user.getName());
			
			this.users.add(newUser);
			return true;
		}
		return false;
	}
	
	private int createCode() {
//		while(true) {
//			int rNum = ran.nextInt(8999) + 1000;
//			boolean check = true;
//			for(User newAcc : this.users) {
//				if(rNum == newAcc.getAccCnt())
//					check = false;
//			}
//			if(check) {
//				return rNum;
//			}
//		}
		return 0;
	}
	
	public int checkLog(User user) {
		for(int i=0; i<this.users.size(); i++) {
			User u = this.users.get(i);
			if(u.getId().equals(user.getId()) && u.getPw().equals(user.getPw())) {
				return i;
			}
		}
		return -1;
	}
	
	public int getUserIndex(int userCode) {
		for(int i=0; i<this.users.size(); i++) {
			User u = this.users.get(i);
			if(u.getCode() == userCode)
				return i;
		}
		return -1;
	}
	
	public int getUserCode(int index) {
		return this.users.get(index).getCode();
	}
	
	public void deleteUser(int index) {
		this.users.remove(index);
	}
	
	public int getUsersAccCnt(int index) {
		User u = this.users.get(index);
		return u.getAccCnt();
	}
	
	public void setUsersAccCnt(int index, int accCnt) {
		User u = this.users.get(index);
		u.setAccCnt(accCnt);
	}
	
	public ArrayList<Account> getUsersAccList(int index) {
		return this.users.get(index).getAccs();
	}
	
	////////////////
	public void setUsersAccList(int index) {
		
	}
	
	public void printAllUsersAccList(int index) {
		ArrayList<Account> list = getUsersAccList(index);
		for(int i=0; i<list.size(); i++) {
			System.out.printf("[%d] %s\n", (i+1), list.get(i));
		}
	}
}
