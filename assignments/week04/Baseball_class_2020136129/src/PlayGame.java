import java.util.Scanner;

public class PlayGame {												// PlayGame 클래스로 playGame 메소드 포함
	static void playGame(Scanner in) { 								// 반환값이 없으므로 void로 선언, 키보드 입력을 위한 Scanner 클래스의 in을 사용하기 위해 매개변수 선언
		int[] bat = new int[3];										// 크기가 3인 정수형 배열 bat 선언 및 초기화
		int[] ball = new int[3];									// 크기가 3인 정수형 배열 ball 선언 및 초기화
		int result;													// 정수형 변수 result 선언
		int out = 0;												// 정수형 변수 out 선언 및 초기화
		Pitch.pitch(ball);												// pitch 메소드 호출, 매개변수 ball 전달
		while(true) {												// 무한루프 반복문
			System.out.printf("[0-9]까지 숫자 3개를 입력하시오: ");		// 화면에 "[0-9]까지 숫자 3개를 입력하시오: " 출력
			for(int i=0; i<3; i++) bat[i] = in.nextInt();			// 입력받은 3개의 숫자를 i = 0, 1, 2일 때 각각 bat[i]에 넣음
			result = Compare.compare(ball, bat);							// compare 메소드를 호출하여 이를 통해 반환된 값을 result에 넣음, 이때 매개변수 ball, bat 전달
			if(result == 1) {										// 만약 result가 1이면,
				System.out.println("사용자 승");						// 출력: 사용자 승
				break;												// while문 빠져나감

			}
			else if(result == -1) {									// 그렇지 않고 만약 result가 -1이면,
				++out;												// out에 1을 더함
				System.out.printf("OUT: %d%n", out);				// 현재 out 상태 출력
				if(out == 3) {										// 이때 만약 out이 3이 되면,
					System.out.println("컴퓨터 승");					// 출력: 컴퓨터 승
					break;											// while문 빠져나감
				}
			}
		}
	}

}
