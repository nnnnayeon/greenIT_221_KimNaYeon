package zombi1_2;

import java.util.Scanner;
import java.util.Random;

public class Game {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int pos = 1;
		
		final int ZOMBIE = 5;
		final int BOSS = 9;
		
		Hero hero = new Hero(1, 200, 20, 2);
		Zombi zom = new Zombi(5, 100, 10);
		Boss boss = new Boss(9, 300, 20, 100);
		
		boolean isRun = false;
		public void run() {
			while(isRun != true) {
				System.out.println("���� ��ġ = " + pos);
				
				System.out.println("[1] ������ �̵��ϱ�");
				System.out.println("[2] �����ϱ�");
				int move = scan.nextInt();
				
				if(move == 1) {
					pos ++;
					this.hero.setPos(this.pos);
					
					if(this.hero.getPos() == ZOMBIE) {
						System.out.println("���� �������ϴ�. ���ݸ��� �ٲ�ϴ�.");
						ZombieMenu();
					}
					else if(this.hero.getPos() == BOSS) {
						System.out.println("������ �������ϴ�. ���ݸ��� �ٲ�ϴ�");
						BossMenu();
					}
					end();
				}
				else if(move == 2) {
					System.out.println("���� ����");
					break;
				}
			}
			
		}
		
		public void ZombieMenu() {
			while(true) {
				System.out.println("--------------------");
				System.out.println("(1) �����ϱ� (2) ���Ǹ��ñ�");
				int num = scan.nextInt();
				
				if(num == 1) {
					this.zom.attack(this.hero);
					this.hero.attack(this.zom);
				}
				else if(num == 2) {
					this.hero.recovery();
				}
				
				if(this.hero.getHp() <= 0) {
					System.out.println("Hero�� �׾����ϴ�");
					System.out.println("���ӿ��� �����ϴ�");
					break;
				}
				if(this.zom.getHp() <= 0) {
					System.out.println("Zombie�� �̰���ϴ�!");
					System.out.println("�̵��� �� �ֽ��ϴ�");
					System.out.println("--------------------");
					break;
				}
			}
		}
		
		public void BossMenu() {
			while(true) {
				System.out.println("--------------------");
				System.out.println("(1) �����ϱ� (2) ���Ǹ��ñ�");
				int num = scan.nextInt();
				
				if(num == 1) {
					this.boss.attack(this.hero);
					this.hero.attack(this.boss);
				}
				else if(num == 2) {
					this.hero.recovery();
				}
				
				if(this.hero.getHp() <= 0) {
					System.out.println("Hero�� �׾����ϴ�");
					System.out.println("���ӿ��� �����ϴ�");
					break;
				}
				if(this.boss.getHp() <= 0) {
					System.out.println("Boss�� �̰���ϴ�!");
					System.out.println("�̵��� �� �ֽ��ϴ�");
					System.out.println("--------------------");
					break;
				}
			}
		}
		
		public void end() {
			if(this.hero.getHp() <= 0) {
				this.isRun = true;
			}
			else if(this.hero.getPos() == 10) {
				System.out.println("���ӿ��� �¸��߽��ϴ�. �����մϴ�.");
				this.isRun = true;
			}
		}

}