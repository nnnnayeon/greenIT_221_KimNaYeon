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
		
		System.out.printf("-- 좀비가 %d의 공격력으로 공격!\n", power);
		System.out.printf(" ㄴ 현재 Hero HP : %d	 좀비 체력 회복 : %d\n", hero.getHp(), this.getHp());
	}

}
