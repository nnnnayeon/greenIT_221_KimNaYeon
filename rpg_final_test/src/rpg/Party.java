package rpg;

import java.util.ArrayList;

public class Party {
	
	private ArrayList<Unit> partyList = new ArrayList<>();	///////////////////////// 
//	Guild guild = new Guild();
	
	public void partyMenu(User u) {
		while(true) {
			System.out.println("----------파티관리---------");
			System.out.println("1)파티원추가 2)파티원삭제 3)파티원교체");
			System.out.println("4)파티원목록 0)뒤로가기");
			int sel = Game.scan.nextInt();
			
			if(sel == 1) {addParty(u);}
			else if(sel == 2) {deleteParty(u);}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 0) {break;}
		}
	}
	
	public void addParty(User u) {
		while(true) {
			if(u.getMyGuildList() == null) {
				System.err.println("파티에 참가할 길드원이 없습니다.");
				break;
			} 
			while(true) {
				if(u.getPartyList().size() > 4) {
					System.out.println("파티참가 최대 인원은 4명입니다.");
				}
//				guild.printMyGuild(u);/////////////////////////////////////
				System.out.print("파티에 참가할 길드원 입력 [0.뒤로가기] : ");
				int sel = Game.scan.nextInt() -1;
				
				if(sel == -1)
					break;
				if(sel >= 0 && sel < u.getMyGuildList().size()) {
					u.getPartyList().add(u.getMyGuildList().get(sel));
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
	}
	
	public void deleteParty(User u) {
		
	}

}
