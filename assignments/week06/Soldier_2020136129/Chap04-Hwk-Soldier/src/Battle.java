
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file Battle.java
 * 두 명의 군인이 전투
 */
public class Battle {
	// 라운드마다 각자 공격을 함
	// 공격 후 죽지 않았으면 회복 가능
	public static void battle(Soldier a, Soldier b) {
		int round = 1;
		while(true) {
			a.defend(b.attack());
			b.defend(a.attack());
			System.out.printf("Attack Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			if(!a.isLive() || !b.isLive()) break;
			a.heal();
			b.heal();
			System.out.printf("Healing Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			++round;
		}
		if(!a.isLive() && !b.isLive()) System.out.println("DRAW");
		else if(!a.isLive()) System.out.println("B win");
		else System.out.println("A win");
	}
	//MedicSoldier의 경우 Soldier와 상속이 아닌 포함관계이므로 아래와 같이 따로 추가해주어야함
	public static void battle(Soldier a, MedicSoldier b) {
		int round = 1;
		while(true) {
			a.defend(b.attack());
			b.defend(a.attack());
			System.out.printf("Attack Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			if(!a.isLive() || !b.isLive()) break;
			a.heal();
			b.heal();
			System.out.printf("Healing Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			++round;
		}
		if(!a.isLive() && !b.isLive()) System.out.println("DRAW");
		else if(!a.isLive()) System.out.println("B win");
		else System.out.println("A win");
	}
	
	public static void main(String[] args) {
		//SpecialSoldier VS Soldier
		Soldier alice = new SpecialSoldier();
		Soldier bob = new Soldier();
		battle(alice, bob);
		//Soldier VS MedicSoldier
		Soldier kelly = new Soldier();
		MedicSoldier mark = new MedicSoldier();
		battle(kelly, mark);
		//SpecialSoldier VS MedicSoldier
		Soldier penny = new SpecialSoldier();
		MedicSoldier jhon = new MedicSoldier();
		battle(penny, jhon);
		//Soldier VS SpecialSoldier
		battle(new Soldier(), new SpecialSoldier());
		//Soldier VS MedicSoldier
		battle(new Soldier(), new MedicSoldier());
	}

}
