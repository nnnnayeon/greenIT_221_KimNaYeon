package zombi1_2;

import java.util.*;

public class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		Hero hero = new Hero(1, 200, 20, 2);
		Zombi zom = new Zombi(5, 100, 10);
		Boss boss = new Boss(9, 300, 20, 100);
		
		int pos = 1;
		hero.setPos(pos);
		
		while(true) {
			System.out.println("현재 위치 = " + pos);
			
			System.out.println("[1]앞으로 이동하기   [2]종료하기");
			int move = scan.nextInt();
			
			if(move == 1) {
				pos ++;
				hero.setPos(pos);
				
				if(hero.getPos() == 5) {
					System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다.");
					
					while(true) {
						System.out.println("(1)공격하기   (2)포션마시기");
						int d = scan.nextInt();
						
						if(d == 1) {
							zom.attack(hero);
							hero.attack(zom);
						}
						else if(d == 2) {
							hero.recovery();
						}
						
						if(hero.getHp() <= 0) {
							System.out.println("Hero가 죽었습니다. 게임에서 졌습니다");
							break;
						}
						if(zom.getHp() <= 0) {
							System.out.println("좀비/보스를 이겼습니다. 이동할 수 있습니다");
							break;
						}
					}
				}
				
				if(hero.getPos() == 9) {
					System.out.println("보스를 만났습니다. 공격모드로 바뀝니다.");
					
					while(true) {
						System.out.println("(1)공격하기   (2)포션마시기");
						int d = scan.nextInt();
						
						if(d == 1) {
							boss.attack(hero);
							hero.attack(boss);
						}
						else if(d == 2) {
							hero.recovery();
						}
						
						if(hero.getHp() <= 0) {
							System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
							break;
						}
						if(boss.getHp() <= 0) {
							System.out.println("보스를 이겼습니다.");
						}
					}
					if(hero.getHp() <= 0)
						break;
				}
				if(hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}
			}
			else if(move == 2) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}

}
