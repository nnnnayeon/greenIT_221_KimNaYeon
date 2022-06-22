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
	
	public Unit(String name, int level, int hp, int maxHp, int att, int def, int exp) {
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
		System.out.printf("[이름: %s]", this.name);
		System.out.printf("[레벨: %d]", this.level);
		
	}
	
}
