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
			System.out.println("> ���� �ʻ�� �ߵ�! 2���� ���ݷ�!");
			int power = (ran.nextInt(max) + 1) * 2;
			
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.printf("-- ������ %d�� ���ݷ����� ����!\n", power);
			System.out.printf(" �� ���� Hero HP : %d\n", hero.getHp());
		}
		else {
			System.out.println("> ������ �Ϲ� ����");
			int power = ran.nextInt(max) + 1;
			
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.printf("-- ������ %d�� ���ݷ����� ����!\n", power);
			System.out.printf(" �� ���� Hero HP : %d\n", hero.getHp());
		}
	}

}
