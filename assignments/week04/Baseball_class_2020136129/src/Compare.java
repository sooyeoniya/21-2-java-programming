
public class Compare {												// Compare 클래스로 compare 메소드 포함
	static int compare(int[] ball, int[] bat) {						// 정수 반환값이 있으므로 int로 선언, 정수형 배열 매개변수 ball, bat 선언
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

}
