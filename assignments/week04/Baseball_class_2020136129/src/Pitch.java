import java.util.concurrent.ThreadLocalRandom;

public class Pitch {												// Pitch 클래스로 pitch 메소드 포함
	static void pitch(int[] ball) {									// C소스와 마찬가지로 pitch 메소드는 반환값이 없으므로 void로 선언, 매개변수 ball 선언
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
}
