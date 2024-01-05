import java.util.Scanner;

public class Done {													// Done 클래스로 done 메소드 포함
	static boolean done(Scanner in) {                  				// boolean 자료형으로 done 메소드 선언, Scanner 클래스의 in 사용을 위한 매개변수 선언
		System.out.printf("새 게임(y/n)? ");                     	// 한 번의 게임이 끝났을 때, 새 게임을 진행할지 안할지 여부 조사 메시지 화면에 출력
		String s = in.next();										// 문자열 s를 키보드를 통해 입력받음
		s = s.toLowerCase();                            			// 문자열 s를 소문자로 바꿈
		if(s.equals("n")) return true;							// 문자열 s가 "n"이면 true,
		else return false;										// 아니면 false 반환
	}

}
