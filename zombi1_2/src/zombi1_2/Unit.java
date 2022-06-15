package zombi1_2;

import java.util.*;

abstract public class Unit {
	private int pos;
	private int hp;
	
	int max;
	Random ran;
	
	public Unit(int pos, int hp, int max) {
		this.pos = pos;
		this.hp = hp;
		this.max = max;
		ran = new Random();
	}
	
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getPos() {
		return this.pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getMax() {
		return this.max;
	}
	
	public void move() {
		if(pos <= 10) pos ++;
		System.out.println("오른쪽으로 이동 >> 현재 위치 :" + this.pos);
	}
	
	abstract void attack(Unit unit);

}
