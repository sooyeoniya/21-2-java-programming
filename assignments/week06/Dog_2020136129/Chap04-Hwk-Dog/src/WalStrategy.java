/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file WalStrategy.java
 */
/*
 * WalStrategy 클래스는 BarkStrategy interface를 구현하여
 * doBark 메소드 실행 시 "이름: 왈왈!!" 이 출력되도록 함.
 */
public class WalStrategy implements BarkStrategy{
	public void doBark() {
		System.out.printf("%s: 왈왈!!%n", Dog.name);
	}

}