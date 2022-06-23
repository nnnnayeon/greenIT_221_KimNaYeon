package rpg;

public class Unit {
	String name;
	int level;
	int hp;
	int maxHp;
	int att;
	int def;
	int exp;
	boolean party;
	Item weapon;
	Item armor;
	Item ring;
	
	public Unit(String name, int level, int maxHp, int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		hp = maxHp;
		
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public Unit(String name, int level, int hp, int maxHp, int att, int def, int exp, boolean party) {
		this.name = name;
		this.level = level;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		hp = maxHp;
		this.party = party;
		
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}
	
	public void printStatus() {
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + level + "]");
		if (ring != null) {
			System.out.print(" [체력 : " + hp + " + " + ring.power);
		} else {
			System.out.print(" [체력 : " + hp);
		}
		if (ring != null) {
			System.out.println(" / " + maxHp + " + " + ring.power + "]");
		} else {
			System.out.println(" / " + maxHp + "]");
		}
		if (weapon != null) {
			System.out.print("[공격력 : " + att + " + " + weapon.power + "]");
		} else {
			System.out.print("[공격력 : " + att + "]");
		}
		if (armor != null) {
			System.out.print(" [방어력 : " + def + " + " + armor.power + "]");
		} else {
			System.out.print(" [방어력 : " + def + "]");
		}
		System.out.println(" [파티중 : " + party + "]");
	}
	
	public void printEquitedItem() {
		if(this.weapon == null)
			System.out.println("[무기 : 없음]");
		else
			System.out.printf("[무기 : %s]\n", this.weapon.name);
		if(this.armor == null)
			System.out.println("[방어구 : 없음]");
		else
			System.out.printf("[방어구 : %s]\n", this.armor.name);
		if(this.ring == null)
			System.out.println("[반지 : 없음]");
		else
			System.out.printf("[반지 : %s]\n", this.ring.name);
	}
	
	
	
}
