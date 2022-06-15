package zombi1_2;

import java.util.Random;

public class Boss extends Zombi{
	
	Random ran = new Random();
	
	private int shield;
	
	public int getShield() {
		return this.shield;
	}
	public void setShield(int value) {
		this.shield = value;
	}

	public Boss(int pos, int hp, int max, int shield) {
		super(pos, hp, max);
		this.shield = shield;
	}
	
	public void attack(Unit hero) {
		
		int a = ran.nextInt(4) + 1;
		if(a == 1) {
			System.out.println("> 보스 필살기 발동! 2배의 공격력!");
			int power = (ran.nextInt(max) + 1) * 2;
			
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.printf("-- 보스가 %d의 공격력으로 공격!\n", power);
			System.out.printf(" ㄴ 현재 Hero HP : %d\n", hero.getHp());
		}
		else {
			System.out.println("> 보스의 일반 공격");
			int power = ran.nextInt(max) + 1;
			
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.printf("-- 보스가 %d의 공격력으로 공격!\n", power);
			System.out.printf(" ㄴ 현재 Hero HP : %d\n", hero.getHp());
		}
	}

}
