package rpg;

import java.util.ArrayList;

public class Guild {
	ArrayList<Unit> guildList = new ArrayList<>();
	final int PARTY_SIZE = 4;
//	Unit[] partyList;
	
//	UserController instance = UserController.getInstance();
	
	public void setGuild(User u) {
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
		temp = new Unit("윤선주", 1, 120, 11, 7, 0);
		this.guildList.add(temp);

	}
	
	public void guildMenu(User u) {
		while(true) {
			System.out.println("----------길드관리---------");
			System.out.println("1)길드목록 2)길드원추가 3)길드원삭제");
			System.out.println("4)파티원교체 5)정렬 0)뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 1) {
				printAllGuild(u);}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 5) {}
			else if(sel == 0) {break;}
			
		}
	}
	
	public void printAllGuild(User u) {
		System.out.println("-----------------------------");
		System.out.println(this.guildList.size());
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

}
