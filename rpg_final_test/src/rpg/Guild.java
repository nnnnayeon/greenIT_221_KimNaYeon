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
				u.printMyGuild(u);}
			else if(sel == 2) {buyGuild(u);}
			else if(sel == 3) {removeUnit(u);}
			else if(sel == 4) {partyMenu(u);}
			else if(sel == 0) {break;}
			
		}
	}
	
	// 길드원 추가
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
	
	// 길드원 삭제
	public void removeUnit(User u) {
		if(u.getMyGuildList().size() == 0) {
			System.err.println("삭제할 길드원이 없습니다. ");
			return;
		}
		else {
			u.printMyGuild(u);
			System.out.println("삭제할 번호 입력 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				return;
			if(sel >= 0 && sel < u.getMyGuildList().size()) {
				
				if(u.getMyGuildList().get(sel).party == true) {
					System.out.println("파티 참가중인 멤버는 삭제할 수 없습니다.");
				}
				else {
					System.out.println("-----------------------------");
					System.out.printf("[이름 : %s] 길드원을 삭제합니다.\n", u.getMyGuildList().get(sel).name);
					System.out.println("-----------------------------");
					u.getMyGuildList().remove(sel);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			else
				System.err.println("잘못된 입력");
		}
	}
	
	// 파티 메뉴
	public void partyMenu(User u) {
		while(true) {
			System.out.println("----------파티관리---------");
			System.out.println("1)파티원추가 2)파티원삭제");
			System.out.println("3)파티원목록 0)뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 1) {addParty(u);}
			else if(sel == 2) {deleteParty(u);}
			else if(sel == 3) {u.printMyParty(u);}
			else if(sel == 0) {break;}
		}
	}
	
	// 파티원 추가
	public void addParty(User u) {
		if(u.getMyGuildList().size() == 0) {
			System.err.println("파티에 참가할 길드원이 없습니다.");
			return;
		}
		while(true) {
			if(u.getPartyList().size() >= 4) {
				System.err.println("파티참가 최대 인원은 4명입니다.");
				break;
			}
			u.printMyGuild(u);
			System.out.print("파티에 참가할 길드원 입력 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				break;
			if(sel >= 0 && sel < u.getMyGuildList().size()) {
				u.getMyGuildList().get(sel).party = true;
//				u.getPartyList().get(sel).party = true;
				u.getPartyList().add(u.getMyGuildList().get(sel));
				
//				u.getMyGuildList().remove(sel)
				
				System.out.printf("[%s] 가 파티에 참가했습니다.\n", u.getMyGuildList().get(sel).name);
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
	
	// 파티원 삭제
	public void deleteParty(User u) {
		if(u.getPartyList().size() == 0) {
			System.err.println("삭제할 파티원이 없습니다.");
			return;
		}
		else {
			u.printMyParty(u);
			System.out.print("삭제할 번호 입력 [0.뒤로가기] : ");
			int sel = Game.scan.nextInt() -1;
			
			if(sel == -1)
				return;
			if(sel >= 0 && sel < u.getPartyList().size()) {
				System.out.println("-----------------------------");
				System.out.printf("[이름 : %s] 파티원을 삭제합니다.\n", u.getPartyList().get(sel).name);
				System.out.println("-----------------------------");
				u.getPartyList().remove(sel);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			else
				System.err.println("잘못된 입력");
		}
	}
	
	//print
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
	
	public void printUnitStatus(int num) {
		guildList.get(num).printStatus();
	}
	
//	public void printMyGuild(User u) {
//		System.out.println("=============길드원=============");
//		for(int i=0; i<u.getMyGuildList().size(); i++) {
//			System.out.printf("%d번) ", i+1);
//			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", u.getMyGuildList().get(i).name, u.getMyGuildList().get(i).level, u.getMyGuildList().get(i).hp, u.getMyGuildList().get(i).maxHp);
//			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", u.getMyGuildList().get(i).att, u.getMyGuildList().get(i).def, u.getMyGuildList().get(i).party);
//			System.out.println();
//		}
//		System.out.println("==============================");
//	}
	
//	public void printMyParty(User u) {
//		System.out.println("-------------파티원------------");
//		for(int i=0; i<u.getPartyList().size(); i++) {
//			System.out.printf("%d번) ", i+1);
//			System.out.printf("[이름 : %s] [레벨 : %d] [체력 : %d / %d]\n", u.getPartyList().get(i).name, u.getPartyList().get(i).level, u.getPartyList().get(i).hp, u.getPartyList().get(i).maxHp);
//			System.out.printf("[공격력 : %d] [방어력 : %d] [파티중 : %b]\n", u.getPartyList().get(i).att, u.getPartyList().get(i).def, u.getPartyList().get(i).party);
//			System.out.println();
//		}
//		System.out.println("-----------------------------");
//	}

}
