package rpg;

import java.util.ArrayList;

public class _Guild {
	ArrayList<Unit> guildList = new ArrayList<>();
	
	// 길드원 추가
		public void buyGuild(User u) {
			while(true) {
				if(u.getMoney() < 5000) {
					System.err.println("골드가 부족합니다.");
					return;
				}
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

}
