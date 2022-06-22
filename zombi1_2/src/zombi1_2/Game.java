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
				System.out.println("현재 위치 = " + pos);
				
				System.out.println("[1] 앞으로 이동하기");
				System.out.println("[2] 종료하기");
				int move = scan.nextInt();
				
				if(move == 1) {
					pos ++;
					this.hero.setPos(this.pos);
					
					if(this.hero.getPos() == ZOMBIE) {
						System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다.");
						ZombieMenu();
					}
					else if(this.hero.getPos() == BOSS) {
						System.out.println("보스를 만났습니다. 공격모드로 바뀝니다");
						BossMenu();
					}
					end();
				}
				else if(move == 2) {
					System.out.println("게임 종료");
					break;
				}
			}
			
		}
		
		public void ZombieMenu() {
			while(true) {
				System.out.println("--------------------");
				System.out.println("(1) 공격하기 (2) 포션마시기");
				int num = scan.nextInt();
				
				if(num == 1) {
					this.zom.attack(this.hero);
					this.hero.attack(this.zom);
				}
				else if(num == 2) {
					this.hero.recovery();
				}
				
				if(this.hero.getHp() <= 0) {
					System.out.println("Hero가 죽었습니다");
					System.out.println("게임에서 졌습니다");
					break;
				}
				if(this.zom.getHp() <= 0) {
					System.out.println("Zombie를 이겼습니다!");
					System.out.println("이동할 수 있습니다");
					System.out.println("--------------------");
					break;
				}
			}
		}
		
		public void BossMenu() {
			while(true) {
				System.out.println("--------------------");
				System.out.println("(1) 공격하기 (2) 포션마시기");
				int num = scan.nextInt();
				
				if(num == 1) {
					this.boss.attack(this.hero);
					this.hero.attack(this.boss);
				}
				else if(num == 2) {
					this.hero.recovery();
				}
				
				if(this.hero.getHp() <= 0) {
					System.out.println("Hero가 죽었습니다");
					System.out.println("게임에서 졌습니다");
					break;
				}
				if(this.boss.getHp() <= 0) {
					System.out.println("Boss를 이겼습니다!");
					System.out.println("이동할 수 있습니다");
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
				System.out.println("게임에서 승리했습니다. 종료합니다.");
				this.isRun = true;
			}
		}

}