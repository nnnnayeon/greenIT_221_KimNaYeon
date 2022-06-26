package rpg;

import java.util.ArrayList;

public class Inventory {
	
	UserController instance = UserController.getInstance();
	
	public void inventoryMenu(User u) {
		String[] menu = {"착용", "판매"};
		while(true) {
			System.out.println("-----------인벤메뉴-----------");
			Shop.printMenu(menu);
			System.out.println("0) 뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 0) {break;}
			else if(sel == 1) {equipMenu(u);}
			else if(sel == 2) {sellMenu(u);}
			
		}
	}
	
	public void printItemList(User u) {
		
		System.out.println(">>>>> 아이템리스트");
		for(int i=0; i<u.getItemList().size(); i++) {
			System.out.printf("%d)", i+1);
			System.out.printf("[이름: %s] ", u.getItemList().get(i).name);
			System.out.printf("[능력: %d] ", u.getItemList().get(i).power);
			System.out.printf("[가격: %d]", u.getItemList().get(i).price);
			System.out.println();
		}
		
	}
	
	public void equipMenu(User u) {
		u.printMyGuild(u);
		System.out.println("아이템 착용할 길드원 선택: ");
		int sel = Game.scan.nextInt();
		
		while(true) {
			u.getPartyList().get(sel).printStatus();
			printItemList(u);
			System.out.println("착용할 아이템 번호 입력 [0.뒤로가기] : ");
			int num = Game.scan.nextInt();
			
			if(num == 0)
				break;
			num --;
			if(u.getItemList().get(num).kind == Item.WEAPON) {
				
			}
			else if(u.getItemList().get(num).kind == Item.ARMOR) {
				
			}
			else if(u.getItemList().get(num).kind == Item.RING) {
				
			}
		}
		
	}
	
	public void sellMenu(User u) {
		while(true) {
			printItemList(u);
			System.out.printf("[골드 : %d]\n", u.getMoney());
			System.out.print("판매할 아이템 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				break;
			if(sel >= 0 && sel < u.getItemList().size()) {
				u.getItemList().remove(sel);
				System.out.printf("[%s] 를 판매합니다.\n", u.getItemList().get(sel).name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		}
	}
	
}
