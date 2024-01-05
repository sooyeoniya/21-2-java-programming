/*
 * ================================
 * 자바프로그래밍 1분반 2020136129 최수연
 *     [과제1. C소스를 자바로 바꾸기]
 * ================================
 *
 * 본 프로젝트는 Baseball 게임 하나를 만드는 것이므로 그냥 기본 package로 두었음
 * java.lang 외에 다른 java 패키지에 소속되어 있는 클래스들은 import로 불러와야함
 * 본 과제에서 Java 난수는 ThreadLocalRandom.current() 객체를 이용함
 * 또한 키보드 입력 처리를 위해 Scanner를 사용함
 * 따라서 다음과 같은 import 문이 두개가 필요함
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

// 아래와 같이 main 메소드 및 필요한 모든 메소드를 포함하는 Baseball 클래스를 하나 정의함
// main 메소드를 제외한 모든 메소드는 static으로 구현함
// 클래스 내부에서는 접근 제어 수준은 의미가 없지만, main 메소드 외의 모든 메소드는 클래스 내에서만 사용 가능하도록 private으로 통일함
public class Baseball {

	private static void pitch(int[] ball) {							// C소스와 마찬가지로 pitch 메소드는 반환값이 없으므로 void로 선언, 매개변수 ball 선언
		int[] flag = new int[10];									// 크기가 10인 정수 배열 flag 선언 및 초기화
		int i = 0;													// for문에 사용할 정수형 변수 i 선언 및 초기화
		for(i=0; i<3; i++) {										// i가 0~2까지 1씩 증가하며 for문을 반복함
			while(true) {											// 무한루프 반복문
				ball[i] = ThreadLocalRandom.current().nextInt(10);	// 0~9까지 중 정수 난수 생성하여 i에 맞게 배열 ball에 순서대로 삽입
				if(flag[ball[i]]==0) {								// 만약 flag[ball[i]]가 0일 때,
					flag[ball[i]] = 1;								// flag[ball[i]]에 1을 넣고,
					break;											// while문 빠져나감
				}
			}
		}

	}

	private static int compare(int[] ball, int[] bat) {				// 정수 반환값이 있으므로 int로 선언, 정수형 배열 매개변수 ball, bat 선언
		int[] flag = new int[10];									// 크기가 10인 정수 배열 flag 선언 및 초기화
		int scount = 0;												// 정수형 변수 scount 선언 및 초기화
		int bcount = 0;												// 정수형 변수 bcount 선언 및 초기화
		int i = 0;													// for문에 사용할 정수형 변수 i 선언 및 초기화
		for(i=0; i<3; i++) flag[ball[i]] = 1;						// i가 0, 1, 2일 때 배열 flag의 인덱스 위치 ball[i]에 각각 1을 넣음
		for(i=0; i<3; i++) {										// i가 0~2까지 1씩 증가할동안
			if(ball[i]==bat[i]) ++scount;							// 만약 ball[i]와 bat[i]가 같으면 scount 1 증가
			else if(flag[bat[i]]==1) ++bcount;						// 그렇지 않고 flag[bat[i]]가 1이면 bcount 1 증가
		}
		if(scount == 3)												// 만약 scount가 3이 되면,
			return 1;												// 1을 반환
		else if(scount == 0 && bcount == 0)							// 그렇지 않고, scount와 bcount가 모두 0이면,
			return -1;												// -1을 반환
		else {														// 그 외에는,
			System.out.printf("S: %d, B: %d%n", scount, bcount);	// scount와 bcount 화면에 출력하고,
			return 0;												// 0을 반환
		}

	}

	private static void playGame(Scanner in) { 						// 반환값이 없으므로 void로 선언, 키보드 입력을 위한 Scanner 클래스의 in을 사용하기 위해 매개변수 선언
		int[] bat = new int[3];										// 크기가 3인 정수형 배열 bat 선언 및 초기화
		int[] ball = new int[3];									// 크기가 3인 정수형 배열 ball 선언 및 초기화
		int result;													// 정수형 변수 result 선언
		int out = 0;												// 정수형 변수 out 선언 및 초기화
		pitch(ball);												// pitch 메소드 호출, 매개변수 ball 전달
		while(true) {												// 무한루프 반복문
			System.out.printf("[0-9]까지 숫자 3개를 입력하시오: ");		// 화면에 "[0-9]까지 숫자 3개를 입력하시오: " 출력
			for(int i=0; i<3; i++) bat[i] = in.nextInt();			// 입력받은 3개의 숫자를 i = 0, 1, 2일 때 각각 bat[i]에 넣음
			result = compare(ball, bat);							// compare 메소드를 호출하여 이를 통해 반환된 값을 result에 넣음, 이때 매개변수 ball, bat 전달
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

	private static boolean done(Scanner in) {                  		// boolean 자료형으로 done 메소드 선언, Scanner 클래스의 in 사용을 위한 매개변수 선언
		System.out.printf("새 게임(y/n)? ");                     	// 한 번의 게임이 끝났을 때, 새 게임을 진행할지 안할지 여부 조사 메시지 화면에 출력
		String s = in.next();										// 문자열 s를 키보드를 통해 입력받음
		s = s.toLowerCase();                            			// 문자열 s를 소문자로 바꿈
		if(s.equals("n")) return true;							// 문자열 s가 "n"이면 true,
		else return false;										// 아니면 false 반환
	}
	/*
	 * ※String s = in.next(); 이 코드에서 질문이 있습니다!※ => 과제 관련 질문이라 질의응답에 못올리고 주석에 적어봅니다.
	 * nextLine()을 했을 때는 s가 입력이 되지 않고 바로 다음으로 넘어갔는데, next()를 사용하니까 문자 입력이 됩니다.
	 * 이건 뭐 때문에 이렇게 되는 건가요? 제가 해당 코드를 잘못사용했다면 피드백 부탁드립니다.
	 * 그 외에도 본 프로젝트에서 제가 잘못 사용한 코드가 있다면 피드백해주시면 정말 감사하겠습니다!
	 */

	public static void main(String[] args) {						// main 메소드
		Scanner in = new Scanner(System.in);						// Scanner 객체 생성, Scanner를 main 함수에서 한번만 생성하고 각 playGame, done 함수에 in 전달
		do {														// do while문
			playGame(in);											// playGame 메소드 계속 진행
		} while(!done(in));											// false일 경우 게임 종료
		in.close();													// System.in을 닫아줌
		System.exit(0);												// 해당 코드는 C 소스의 return EXIT_SUCCESS, 에러 없이 정상적으로 종료되었을 때 0을 반환함
	}																// java의 main은 반환값이 void형이기 때문에 return으로 반환 불가능함
}