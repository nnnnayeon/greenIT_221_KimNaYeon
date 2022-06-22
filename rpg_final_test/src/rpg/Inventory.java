package rpg;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<>();
	
	public void inventoryMenu() {
		String[] menu = {"착용", "판매"};
		while(true) {
			System.out.println("-----------인벤메뉴-----------");
			Shop.printMenu(menu);
			System.out.println("0) 뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 0) {break;}
			else if(sel == 1) {equipMenu();}
			else if(sel == 2) {}
			
		}
	}
	
	public void printItemList() {
		System.out.println(">>>>> 아이템리스트");
		for(int i=0; i<itemList.size(); i++) {
			System.out.printf("%d)", i+1);
			System.out.printf("[이름: %s] ", itemList.get(i).name);
			System.out.printf("[능력: %s] ", itemList.get(i).power);
			System.out.printf("[가격: %s]", itemList.get(i).price);
			System.out.println();
		}
		
	}
	
	public void equipMenu() {
		printItemList();
	}

}
