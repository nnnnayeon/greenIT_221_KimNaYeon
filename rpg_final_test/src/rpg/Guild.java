package rpg;

import java.util.ArrayList;

public class Guild {
	ArrayList<Unit> guildList = new ArrayList<>();
	
	public void setGuild() {
		Unit temp = new Unit("È£¶ûÀÌ", 1, 100, 10, 5, 0);
		this.guildList.add(temp);
		temp = new Unit("°­¾ÆÁö", 1, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("»ç½¿", 1, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("µÎ´õÁö", 1, 70, 5, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("µÅÁö", 1, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("À±¼±ÁÖ", 1, 120, 11, 7, 0);
		this.guildList.add(temp);
		
	}

}
