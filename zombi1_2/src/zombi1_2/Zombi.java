package zombi1_2;

public class Zombi extends Unit{
	int power;

	public Zombi(int pos, int hp, int max) {
		super(pos, hp, max);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Unit hero) {
		power = ran.nextInt(max) + 1;
		
		hero.setHp(hero.getHp() - power);
		if(hero.getHp() <= 0)
			hero.setHp(0);
		
		this.setHp(this.getHp() + power/2);
		
		System.out.printf("-- ���� %d�� ���ݷ����� ����!\n", power);
		System.out.printf(" �� ���� Hero HP : %d	 ���� ü�� ȸ�� : %d\n", hero.getHp(), this.getHp());
	}

}
