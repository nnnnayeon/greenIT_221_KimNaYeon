package atm;

public class User {
	String id = "";
	String pw = "";
	
	Account[] acc = new Account[UserManager.ACC_MAX_CNT];
	int accCnt = 0;

}
