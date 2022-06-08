package Shop1_1;

import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);
	
	private Vector<Item> itemList = new Vector<Item>();
	private Vector<String> category = new Vector<String>();
	private Vector<Cart> jangList = new Vector<Cart>();
	
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
	
	public void printjang() {
		for(int i=0; i<this.jangList.size(); i++) {
			this.jangList.get(i).print();
		}
	}
	
	public void printjang(User u) {
		for(int i=0; i<this.jangList.size(); i++) {
			if(u.getId().equals(jangList.get(i).getUserId())) {
				this.jangList.get(i).print();
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
		printItemList();
		System.out.print("index: ");
		int idx = scan.nextInt();
		
		if(idx >= 0 && idx < this.itemList.size()) {
			this.itemList.remove(idx);
			System.out.println("아이템 삭제 완료");
		}
		else
			System.out.println("입력 오류");
	}
	
	public void addCategory() {
		System.out.print("CATEGORY: ");
		String name = scan.next();
		
		this.category.add(name);
	}
	
	public void removeCategory() {
		printCategory();
		System.out.print("index: ");
		int idx = scan.nextInt();
		
		if(idx >= 0 && idx < this.category.size()) {
			this.category.remove(idx);
			System.out.println("카테고리 삭제 완료");
		}
		else
			System.out.println("입력 오류");
	}

	public void addCart(String usID, int cateNum, int itemNum) {
		int n = 0;
		Cart cart = new Cart();
		cart.setUserId(usID);
		
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(cateNum).equals(this.itemList.get(i).getCategory())) {
				if(itemNum == n) {
					cart.setItemName(this.itemList.get(i).getName());
				}
				n++;
			}
		}
		this.jangList.add(cart);
	}
	
	public void removeJang() {
		printjang();
		System.out.print("입력(index): ");
		int idx = scan.nextInt();
		if(idx >= 0 && idx < this.jangList.size()) {
			this.jangList.remove(idx);
			System.out.println("삭제 완료");
		}
		else
			System.out.println("입력 오류");
	}
	
	
	
}
