package atm;

import java.util.ArrayList;

public class AccountManager {
	
	public static AccountManager instance = new AccountManager();
	private AccountManager() {}
	
	private ArrayList<Account> accs = new ArrayList<Account>();
	
	public boolean createAcc(int userIndex) {
		// userCode�� ���� -> �ش� ȸ���� ���� ���� ���� -> ����
		int accCnt = UserManager.instance.getUsersAccCnt(userIndex);
		int userCode = UserManager.instance.getUserCode(userIndex);
		if(accCnt < 3) {
			Account newAcc = new Account(userCode, createAccCode());
			this.accs.add(newAcc);	// �߾� ������ ����Ʈ�� �߰�
			
			// ������� �ٷΰ��� ����Ʈ�� �߰�
			UserManager.instance.getUsersAccList(userIndex).add(newAcc);
			UserManager.instance.setUsersAccCnt(userCode, accCnt +1);
			return true;
		}
		return false;
	}
	
	private int createAccCode() {
		return 0;
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
