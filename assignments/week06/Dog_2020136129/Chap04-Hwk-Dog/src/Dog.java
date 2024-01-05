/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file Dog.java
 * 강아지 클래스
 */
/*
 * 전략 객체를 유지하기 위해 멤버 변수 BarkStrategy를 추가하여 짖기 전략을 사용할 수 있도록 함.
 * 또 이 객체를 설정하기 위해 void setBarkStrategy(BarkStrategy barkStrategy)를 public으로 추가함.
 * 그리고 bark 메소드는 짖기 전략을 사용하여 메인에서 bark 메소드를 부를 경우
 * 해당 짖기 전략을 사용하여 메인에서 지정된 각 짖기 종류에 맞춰 짖기를 실행하도록 함.
 */
public class Dog implements Barkable{
	static String name;
	private BarkStrategy barkStrategy;
	public Dog(String name) {
		Dog.name = name;
	}
	public void setBarkStrategy(BarkStrategy barkStrategy) {
		this.barkStrategy = barkStrategy;
	}
	public void bark() {
		barkStrategy.doBark();
	}
}
