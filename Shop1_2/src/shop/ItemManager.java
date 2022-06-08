package shop;

import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);
	
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>();
	Vector<Cart> jangList = new Vector<Cart>();
	
	public ItemManager() {
		init();
	}
	
	public void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
	}
	
	public void printJang() {
		for(int i=0; i<this.jangList.size(); i++) {
			this.jangList.get(i).print();
		}
	}
	public void printJang(User u) {
		for(int i=0; i<this.jangList.size(); i++) {
			if(u.id.equals(this.jangList.get(i).getUserId()))
				this.jangList.get(i).print();
		}
	}
	
	public void printCategory() {
		for(int i=0; i<this.category.size(); i++) {
			System.out.println("[" + i + "]" + this.category.get(i));
		}
	}
	public void printItemList() {
		for(int i=0; i<this.itemList.size(); i++) {
			System.out.print("[" + i + "]");
			this.itemList.get(i).print();
		}
	}
	
	public void printItemList(int caID) {
		int n = 0;
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(caID).equals(this.itemList.get(i).getCategory())) {
				System.out.print("[" + n + "]");
				this.itemList.get(i).print();
				n ++;
			}
		}
	}
	
	public void addItem() {
		System.out.println("[아이템추가] 아이템 이름을 입력하세요.");
		String name = scan.next();
		System.out.println("[아이템추가] 가격을 입력하세요.");
		int price = scan.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요.");
		int sel = scan.nextInt();
		Item temp = new Item(name, price, this.category.get(sel));
		this.itemList.add(temp);
	}
	
	public void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요.");
		String name = scan.next();
		this.category.add(name);
	}
	
	public void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.setUserId(usID);
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(caID).equals(this.itemList.get(i).getCategory())) {
				if(itemID == n) {
					temp.setItemName(this.itemList.get(i).getName());
				}
				n ++;
			}
		}
		this.jangList.add(temp);
	}
	
	public void removeItem() {
		printItemList();
		System.out.println("index: ");
		int idx = scan.nextInt();
		
		if(idx >= 0 && idx < this.itemList.size()) {
			this.itemList.remove(idx);
			System.out.println("아이템 삭제 완료.");
		}
		else
			System.out.println("입력 오류");
	}
	
	public void removeCategory() {
		printCategory();
		System.out.println("index: ");
		int idx = scan.nextInt();
		
		if(idx >= 0 && idx < this.category.size()) {
			this.category.remove(idx);
			System.out.println("카테고리 삭제 완료");
		}
		else
			System.out.println("입력 오류");
	}
	
	
	
}
