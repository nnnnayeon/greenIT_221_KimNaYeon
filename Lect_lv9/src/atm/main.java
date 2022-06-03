package atm;

public class main {
	public static void main(String[] args) {
		
		Bank.instance.setName("Green");
		Bank.instance.run();
	}

}
