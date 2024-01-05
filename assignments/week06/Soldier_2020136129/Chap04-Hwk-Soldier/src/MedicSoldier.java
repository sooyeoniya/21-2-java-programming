
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file MedicSoldier.java
 */

/*
 * MedicSoldier 클래스는 Soldier 클래스를 포함하므로
 * MedicSoldier 생성자에서 Soldier 객체를 받는 형태로 유지하고
 * 부모 클래스인 Soldier의 메소드들의 코드를 그대로 옮긴 후 객체를 통해 호출하는 형식으로 함.
 * 이때 수정할 사항만 변경하고 부모 클래스와 같은 코드들은 부모클래스로부터 호출함.
 * MedicSoldier 클래스에서는 Soldier 클래스의 heal 메소드를 두번 호출하는 것과 같으므로
 * 해당 부분에 for문을 사용하여 heal 메소드가 두 번 반복되도록 수정함. 
 */

public class MedicSoldier {
	private Soldier soldier = new Soldier();
	public int attack() {
		return soldier.attack();
	}
	public void defend(int hitPower) {
		soldier.defend(hitPower);
	}
	public void heal() {
		for(int i = 0; i < 2; i++) {
			soldier.heal();
		}
	}
	public boolean isLive() {
		return soldier.isLive();
	}
	public int getHealth() {
		return soldier.getHealth();
	}

}

/*
 * <포함 관계의 이점>
 * 상속은 정적관계이고 포함은 동적관계이기 때문에 
 * 부모 클래스로부터 수정이 많이 필요한 경우
 * 포함을 사용하는 것이 더 유연한 방법일 수 있음.
 * 
 * 상속은 다중상속시 복잡해지기 때문에 현재 단일상속만 가능한데
 * 포함관계를 사용하여 여러 클래스 간의 관계를 설정하면
 * 단일상속보다 좀 더 편하고 간결하게 사용할 수 있음.
 */