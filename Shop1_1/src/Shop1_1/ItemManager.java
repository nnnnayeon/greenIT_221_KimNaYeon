package Shop1_1;

import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);
	
	private Vector<Item> itemList = new Vector<Item>();
	private Vector<String> category = new Vector<String>();
	
	public void printCategory() {
		System.out.println("-------------------");
		for(int i=0; i<this.category.size(); i++) {
			System.out.println("[" + i + "]" + this.category.get(i));
		}
		System.out.println("-------------------");
	}
	
	public void printItemList() {
		for(int i=0; i<this.itemList.size(); i++) {
			System.out.print("[" + i + "]");
			this.itemList.get(i).print();
		}
	}
	
	public void printItemList(int cateNum) {
		int n = 0;
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(cateNum).equals(itemList.get(i).getCategory())) {
				System.out.print("[" + n + "]");
				this.itemList.get(i).print();
				n++;
			}
		}
	}
	
	public void addItem() {
		printCategory();
		System.out.print("CATEGORY: ");
		int num = scan.nextInt();
		System.out.print("ITEM: ");
		String name = scan.next();
		System.out.print("PRICE: ");
		int price = scan.nextInt();
		
		Item temp = new Item(name, price, category.get(num));
		this.itemList.add(temp);
	}
	
	public void removeItem() {
		
	}
	
	public void addCategory() {
		System.out.print("CATEGORY: ");
		String name = scan.next();
		
		this.category.add(name);
	}
	
	public void removeCategory() {
		
	}

	public void addCart(String usID, int cateNum, int itemNum) {
		int n = 0;
		Cart cart = new Cart();
//		cart.getUserId() = usID;
//		cart.setUserId(usID);
	}
	
	
	
}
