package rpg;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<>();
	
	public void inventoryMenu() {
		String[] menu = {"����", "�Ǹ�"};
		while(true) {
			System.out.println("-----------�κ��޴�-----------");
			Shop.printMenu(menu);
			System.out.println("0) �ڷΰ���");
			int sel = Game.scan.nextInt();
			
			if(sel == 0) {break;}
			else if(sel == 1) {equipMenu();}
			else if(sel == 2) {}
			
		}
	}
	
	public void printItemList() {
		System.out.println(">>>>> �����۸���Ʈ");
		for(int i=0; i<itemList.size(); i++) {
			System.out.printf("%d)", i+1);
			System.out.printf("[�̸�: %s] ", itemList.get(i).name);
			System.out.printf("[�ɷ�: %s] ", itemList.get(i).power);
			System.out.printf("[����: %s]", itemList.get(i).price);
			System.out.println();
		}
		
	}
	
	public void equipMenu() {
		printItemList();
	}

}
