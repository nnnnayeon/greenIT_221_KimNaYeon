package atm;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
	private Random ran = new Random();
	
	public static AccountManager instance = new AccountManager();
	private AccountManager() {}
	
	private ArrayList<Account> accs = new ArrayList<Account>();
	
	public boolean createAcc(int userIndex) {
		// userCode를 통해 -> 해당 회원의 보유 계좌 수를 -> 검증
		int accCnt = UserManager.instance.getUsersAccCnt(userIndex);
		int userCode = UserManager.instance.getUserCode(userIndex);
		if(accCnt < 3) {
			Account newAcc = new Account(userCode, createAccCode());
			this.accs.add(newAcc);	// 중앙 데이터 리스트에 추가
			
			// 사용자의 바로가기 리스트에 추가
			UserManager.instance.getUsersAccList(userIndex).add(newAcc);
			UserManager.instance.setUsersAccCnt(userCode, accCnt +1);
			return true;
		}
		else {
			System.out.println("계좌개설은 3개까지만 가능합니다.");
			return false;
		}
	}
	
	private int createAccCode() {
		while(true) {
			int rNum = ran.nextInt(8999) + 1000;
			boolean check = true;
			for(Account newAcc : this.accs) {
				if (rNum == newAcc.getAccNum())
					check = false;
			}
			if(check) {
				return rNum;
			}
		}
//		boolean check = false;
//		int accCnt = UserManager.instance.getUsersAccCnt(userIndex);
//		for(int i=0; i<accCnt; i++) {
//			
//		}
	}
	
	public boolean deleteAcc(int userIndex, int delAccIdx) {
		ArrayList<Account> list = UserManager.instance.getUsersAccList(userIndex);
		Account delAcc = list.get(delAccIdx);
		
		try {
			list.remove(delAcc);
			this.accs.remove(delAcc);
			UserManager.instance.setUsersAccCnt(userIndex, list.size());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
