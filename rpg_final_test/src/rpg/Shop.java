package rpg;

import java.util.ArrayList;

public class Shop {
	
	ArrayList<Item> itemList = new ArrayList<>();
	
	public Shop() {
		 Item temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "나무검";
		 temp.power = 3;
		 temp.price = 1000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "철검";
		 temp.power = 5;
		 temp.price = 2000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "레이피어";
		 temp.power = 7;
		 temp.price = 2500;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "티셔츠";
		 temp.power = 1;
		 temp.price = 300;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "가죽갑옷";
		 temp.power = 4;
		 temp.price = 800;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "강철갑옷";
		 temp.power = 7;
		 temp.price = 1500;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "은반지";
		 temp.power = 7;
		 temp.price = 3000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "금반지";
		 temp.power = 17;
		 temp.price = 6000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "다이아반지";
		 temp.power = 35;
		 temp.price = 20000;
		 itemList.add(temp);
	}
	
	public void printShop() {
		String[] menu = {"무기", "갑옷", "반지"};
		while(true) {
			System.out.println("-----------상점-----------");
			printMenu(menu);
			System.out.println("0) 뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 0)
				return;
			while(true) {
				if(sel == Item.WEAPON) {
					System.out.println(">>>>> 무기");
				}
				else if(sel == Item.ARMOR) {
					System.out.println(">>>>> 방어구");
				}
				else if(sel == Item.RING) {
					System.out.println(">>>>> 반지");
				}
				printItems(sel);
				
				System.out.printf("-> 소유한 골드: %d\n", Player.money);
				System.out.println("[0.뒤로가기]");
				System.out.print("구입할 아이템: ");
				int num = Game.scan.nextInt();
				
				if(num == 0) {break;}
				int cnt = 0;
				for(int i=0; i<this.itemList.size(); i++) {
					if(this.itemList.get(i).kind == sel) {
						cnt ++;
						if(cnt == num) {
							
						}
					}
				}
				
			}
		}
	}
	
	// print
	public static void printMenu(String[] list) {
		for(int i=0 ; i<list.length; i++) {
			System.out.printf("%d) %s \t", i+1, list[i]);
		}
		System.out.println();
	}
	
	public void printItems(int sel) {
		int cnt = 0;
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).kind != sel)
				continue;
			System.out.printf("%d)", cnt + 1);
			System.out.printf("[이름: %s] ", itemList.get(i).name);
			System.out.printf("[능력: %s] ", itemList.get(i).power);
			System.out.printf("[가격: %s]", itemList.get(i).price);
			System.out.println();
			cnt ++;
		}
	}

}
