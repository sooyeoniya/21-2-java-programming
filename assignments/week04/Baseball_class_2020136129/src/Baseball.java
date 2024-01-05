/**
 * @version 2021년도 2학기 3주차 과제
 * @author 2020136129 최수연
 * 과제 3. 숫자 야구 게임을 객체 지향으로
 */

import java.util.Scanner;

public class Baseball {												// Baseball 클래스로 메인 함수를 포함
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);						// Scanner 객체 생성, Scanner를 main 함수에서 한번만 생성하고 각 playGame, done 함수에 in 전달
		do {														// do while문
			PlayGame.playGame(in);											// PlayGame 클래스의 playGame 메소드 계속 진행
		} while(!Done.done(in));											// false일 경우 게임 종료
		in.close();													// System.in을 닫아줌
		System.exit(0);												// 해당 코드는 C 소스의 return EXIT_SUCCESS, 에러 없이 정상적으로 종료되었을 때 0을 반환함
	}																// java의 main은 반환값이 void형이기 때문에 return으로 반환 불가능함

}
