package zombi1_2;

public class Hero extends Unit{
	int power;
	int count;
	
	public Hero(int pos, int hp, int max, int count) {
		super(pos, hp, max);
		this.count = count;
	}
	
	public void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss)enemy;
			power = ran.nextInt(max) + 1;
			
			if(boss.getShield() > 0) {
				int r = boss.getShield() - power;
				if(r >= 0)
					boss.setShield(boss.getShield() - power);
				else {
					boss.setShield(0);
					boss.setHp(boss.getHp() - r);
				}
			}
			else
				boss.setHp(boss.getHp() - power);
			
			if(boss.getHp() <= 0)
				boss.setHp(0);
			
			System.out.printf("-- ����ΰ� %d�� ���ݷ����� ����!\n", power);
			System.out.printf(" �� ���� Boss HP : %d   ���� Boss SHIELD : %d\n", boss.getHp(), boss.getShield());
		}
		else {
			power = ran.nextInt(max) + 1;
			enemy.setHp(enemy.getHp() - power);
			
			if(enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.printf("-- ����� %d�� ���ݷ����� ����!\n", power);
			System.out.printf(" �� ���� Zombie HP : %d\n", enemy.getHp());
		}
	}
	
	public void recovery() {
		if(count > 0) {
			setHp(getHp() + 100);
			System.out.printf("-- ü�� ȸ���ؼ� %d�� �Ǿ����ϴ�\n", getHp());
			count --;
		}
		else if(count == 0) {
			System.out.println("��� ����߽��ϴ�");
		}
	}

}
