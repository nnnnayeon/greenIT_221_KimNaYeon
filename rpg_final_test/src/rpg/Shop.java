package rpg;

import java.util.ArrayList;

public class Shop {
	
	ArrayList<Item> itemList = new ArrayList<>();
	
	public Shop() {
		 Item temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "������";
		 temp.power = 3;
		 temp.price = 1000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "ö��";
		 temp.power = 5;
		 temp.price = 2000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.WEAPON;
		 temp.name = "�����Ǿ�";
		 temp.power = 7;
		 temp.price = 2500;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "Ƽ����";
		 temp.power = 1;
		 temp.price = 300;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "���װ���";
		 temp.power = 4;
		 temp.price = 800;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.ARMOR;
		 temp.name = "��ö����";
		 temp.power = 7;
		 temp.price = 1500;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "������";
		 temp.power = 7;
		 temp.price = 3000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "�ݹ���";
		 temp.power = 17;
		 temp.price = 6000;
		 itemList.add(temp);
		 
		 temp = new Item();
		 temp.kind = Item.RING;
		 temp.name = "���̾ƹ���";
		 temp.power = 35;
		 temp.price = 20000;
		 itemList.add(temp);
	}
	
	public void printShop() {
		String[] menu = {"����", "����", "����"};
		while(true) {
			System.out.println("-----------����-----------");
			printMenu(menu);
			System.out.println("0) �ڷΰ���");
			int sel = Game.scan.nextInt();
			
			if(sel == 0)
				return;
			while(true) {
				if(sel == Item.WEAPON) {
					System.out.println(">>>>> ����");
				}
				else if(sel == Item.ARMOR) {
					System.out.println(">>>>> ��");
				}
				else if(sel == Item.RING) {
					System.out.println(">>>>> ����");
				}
				printItems(sel);
				
				System.out.printf("-> ������ ���: %d\n", Player.money);
				System.out.println("[0.�ڷΰ���]");
				System.out.print("������ ������: ");
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
			System.out.printf("[�̸�: %s] ", itemList.get(i).name);
			System.out.printf("[�ɷ�: %s] ", itemList.get(i).power);
			System.out.printf("[����: %s]", itemList.get(i).price);
			System.out.println();
			cnt ++;
		}
	}

}
