import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file SpecialSoldier.java
 */

/*
 * SpecialSoldier 클래스는 Soldier 클래스를 상속하므로
 * 부모클래스인 Soldier의 메소드들을 물려받아 그대로 사용하고
 * 해당 SpecialSoldier 클래스에서 Soldier 클래스의 변경 부분만 수정해주면 됨.
 * SpecialSoldier은 Soldier와 다르게 최소 2의 피해는 주도록 해야하므로
 * 난수 발생 시 2~4까지의 난수 중 하나의 값을 반환하도록 변경함.
 */

public class SpecialSoldier extends Soldier {
	public int attack() {
		return ThreadLocalRandom.current().nextInt(2, 5);
	}

}