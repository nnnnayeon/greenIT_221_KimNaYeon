package shop;

public class Cart {
	private String userId;
	private String itemName;
	
	public String getUserId() {
		return this.userId;
	}
	public String getItemName() {
		return this.itemName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void print() {
		System.out.println("[" + userId + "]" + "æ∆¿Ã≈€: " + itemName);
	}

}
