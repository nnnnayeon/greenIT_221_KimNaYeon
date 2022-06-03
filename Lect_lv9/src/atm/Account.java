package atm;

public class Account {
	private int userCode;
	private int accNum;
	private int money;
	
	public Account(int userCode, int accNum) {
		this.userCode = userCode;
		this.accNum = accNum;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %d : %d won", this.userCode, this.accNum, this.money);
	}
	
	public int getUserCode() {
		return userCode;
	}
	public int getAccNum() {
		return accNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
