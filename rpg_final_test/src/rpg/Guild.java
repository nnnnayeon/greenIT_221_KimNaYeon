package rpg;

import java.util.ArrayList;

public class Guild {
	ArrayList<Unit> guildList = new ArrayList<>();
	
//	UserController instance = UserController.getInstance();
	
	public Guild() {
		Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0);
		this.guildList.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("사슴", 1, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("돼지", 1, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("윤선주", 1, 120, 18, 7, 0);
		this.guildList.add(temp);

	}
	
	public void guildMenu(User u) {
		while(true) {
			System.out.println("----------길드관리---------");
			System.out.println("1)길드목록 2)길드원추가 3)길드원삭제");
			System.out.println("4)파티원관리 0)뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 1) {
				printMyGuild(u);}
			else if(sel == 2) {buyGuild(u);}
			else if(sel == 3) {removeUnit(u);}
			else if(sel == 4) {}
			else if(sel == 0) {break;}
			
		}
	}
	
	public void buyGuild(User u) {
		while(true) {
			if(u.getMoney() < 5000) {
				System.err.println("골드가 부족합니다.");
				return;
			}
			printAllGuild(u);
			System.out.print("추가할 길드원 입력 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				break;
			if(sel >= 0 && sel < guildList.size()) {
				u.getMyGuildList().add(this.guildList.get(sel));
				u.setMoney(u.getMoney() - 5000);
				System.out.printf("[%s] 길드원을 추가합니다.\n", this.guildList.get(sel).name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			else
				System.err.println("잘못된 입력입니다.");
		}
	}
	
	public void removeUnit(User u) {
		if(u.getMyGuildList() == null) {
			System.err.println("삭제할 길드원이 없습니다. ");
			return;
		}
		else {
			printMyGuild(u);
			System.out.println("삭제할 번호 입력 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				return;
			if(sel >= 0 && sel < u.getMyGuildList().size()) {
				
			}
			
		}
		
	}
	
	public void printAllGuild(User u) {
		System.out.println("-----------------------------");
		System.out.printf("[골드 : %d]\n", u.getMoney());
		System.out.println("-------------길드원------------");
		for(int i=0; i<this.guildList.size(); i++) {
			System.out.printf("%d번) ", i+1);
			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", guildList.get(i).name, guildList.get(i).level, guildList.get(i).hp, guildList.get(i).maxHp);
			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", guildList.get(i).att, guildList.get(i).def, guildList.get(i).party);
			System.out.println();
		}
		System.out.println("-----------------------------");
	}
	
	public void printMyGuild(User u) {
		System.out.println("=============길드원=============");
		for(int i=0; i<u.getMyGuildList().size(); i++) {
			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", u.getMyGuildList().get(i).name, u.getMyGuildList().get(i).level, u.getMyGuildList().get(i).hp, u.getMyGuildList().get(i).maxHp);
			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", u.getMyGuildList().get(i).att, u.getMyGuildList().get(i).def, u.getMyGuildList().get(i).party);
			System.out.println();
		}
		System.out.println("==============================");
	}

}
