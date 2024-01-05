import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 과제8
 * @author 2020136129 최수연
 * 문제 A: 공통 문자 찾기
 */

/*
 * T,N을 받고, 2차원 배열 num과, String 배열 l을 생성한다.
 * for문을 통해 l에 인덱스 0~N-1만큼 각각 문자열을 받고,
 * toCharArray를 통해 문자열을 char형 배열로 바꿔 char 배열 ch에 넣어준다.
 * 다시 l에서 해당 인덱스 위치의 length값보다 작을 때까지 for문을 돌려,
 * ch 모든 문자 배열을 int형으로 변환한 후, 'a'를 뺀 값을 num 배열의 열에 넣는다.
 * 그러면 num에는 각 단어별로 a~z까지 각각 몇 개가 있는지 포함된다.
 * 다음 for문에서는 각 단어별 num에 있는 같은 알파벳들을 하나씩 빼고,
 * 세 개 모두 같은 알파벳일 때 sum에 1을 증가시킨다.
 * 만약 세 개의 모두 같은 알파벳의 인덱스 부분이 모두 0이 아니면,
 * j를 -1로 바꾸어 다시 for문을 돌린다.
 * 만약 num이 0이면 break를 하고 해당 for문 마지막에는
 * 내부 for문을 통해 해당 알파벳이 모든 단어에 존재할 경우 출력이 되도록 한다.
 */

public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; ++t){
            int N = in.nextInt();
            int [][] num = new int[N][26];
            String [] l = new String[N];
            for(int i = 0; i < N; ++i){
                l[i] = in.next();
                char [] ch = l[i].toCharArray();
                for(int j = 0; j < l[i].length(); ++j){
                    ++num[i][(int)ch[j]-'a'];
                }
            }
            for(int i = 0; i < 26; ++i){
                int sum = 0;
                for(int j = 0; j < N; ++j){
                    if(num[j][i] == 0) break;
                    --num[j][i];
                    if(j == N - 1){
                        j = -1;
                        ++sum;
                    }
                }
                for(int n = 0; n < sum; ++n){
                    System.out.print((char)(i + 'a'));
                }
            }
            System.out.println();
        }
        in.close();
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 과제8
 * @author 2020136129 최수연
 * 문제 B: 문자열 해독하기
 */
 
/*
 * T를 받고, String을 통해 문자열을 입력받는다.
 * for문을 통해 해당 인덱스의 두 번째 뒤의 값이 #과 일치할 경우,
 * lina1에 해당 인덱스의 값부터 바로 뒤의 값까지를 integer형으로 변환하여 j에 저장한 후,
 * j 값을 char형으로 변환하여 line1에 저장하고, 인덱스 i를 # 다음 인덱스로 넘겨준다.
 * 그렇지 않을 경우에는 그냥 해당 인덱스 값 하나만 변환하여 line1에 저장한다.
 */

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; ++t){
            String line = in.next();
            String line1 = "";
            for(int i = 0; i < line.length(); ++i){
                int j = 0;
                if(i < line.length() - 2 && line.substring(i + 2, i + 3).equals("#")){
                    j = Integer.parseInt(line.substring(i, i + 2)) + 96;
                    line1 += (char)j;
                    i += 2;
                }
                else {
                    j = Integer.parseInt(line.substring(i, i + 1)) + 96;
                    line1 += (char)j;
                }
            }
            System.out.println(line1);
        }
        in.close();
    }
}