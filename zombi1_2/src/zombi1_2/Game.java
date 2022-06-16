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
			System.out.println("���� ��ġ = " + pos);
			
			System.out.println("[1]������ �̵��ϱ�   [2]�����ϱ�");
			int move = scan.nextInt();
			
			if(move == 1) {
				pos ++;
				hero.setPos(pos);
				
				if(hero.getPos() == 5) {
					System.out.println("���� �������ϴ�. ���ݸ��� �ٲ�ϴ�.");
					
					while(true) {
						System.out.println("(1)�����ϱ�   (2)���Ǹ��ñ�");
						int d = scan.nextInt();
						
						if(d == 1) {
							zom.attack(hero);
							hero.attack(zom);
						}
						else if(d == 2) {
							hero.recovery();
						}
						
						if(hero.getHp() <= 0) {
							System.out.println("Hero�� �׾����ϴ�. ���ӿ��� �����ϴ�");
							break;
						}
						if(zom.getHp() <= 0) {
							System.out.println("����/������ �̰���ϴ�. �̵��� �� �ֽ��ϴ�");
							break;
						}
					}
				}
				
				if(hero.getPos() == 9) {
					System.out.println("������ �������ϴ�. ���ݸ��� �ٲ�ϴ�.");
					
					while(true) {
						System.out.println("(1)�����ϱ�   (2)���Ǹ��ñ�");
						int d = scan.nextInt();
						
						if(d == 1) {
							boss.attack(hero);
							hero.attack(boss);
						}
						else if(d == 2) {
							hero.recovery();
						}
						
						if(hero.getHp() <= 0) {
							System.out.println("Hero�� �׾����ϴ�. ���ӿ��� �����ϴ�.");
							break;
						}
						if(boss.getHp() <= 0) {
							System.out.println("������ �̰���ϴ�.");
						}
					}
					if(hero.getHp() <= 0)
						break;
				}
				if(hero.getPos() == 10) {
					System.out.println("���ӿ��� �¸��߽��ϴ�. �����մϴ�.");
					break;
				}
			}
			else if(move == 2) {
				System.out.println("������ �����մϴ�.");
				break;
			}
		}
	}

}
