import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 과제7
 * @author 2020136129 최수연
 * 문제 A: 행렬에서 값이 홀수인 셀의 개수
 */

/*
 * T,M,N,K를 입력받고, 숫자를 더하는 num 배열, 행배열, 열배열 총 세개의 배열을 생성한다.
 * 이중 for문을 사용하여 행배열, 열배열을 이용하여 각각 num 배열에 숫자를 1씩 증가한다.
 * if문을 사용하여 홍수일 경우 정수형 변수 number에 1씩 더하도록 한다.
 */

public class Main{
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int T = in.nextInt();
      for(int t = 0; t < T; ++t) {
         int number = 0;
         int M = in.nextInt();
         int N = in.nextInt();
         int K = in.nextInt();
         int [][] num = new int[M][N];
         int [] krow = new int[K];
         int [] kcol = new int[K];
         for(int i = 0; i < K; ++i) {
            krow[i]= in.nextInt();
            kcol[i]= in.nextInt();
         }
         for(int i = 0; i < K; ++i) {
            for(int j = 0; j < N; ++j) {
               ++num[krow[i]][j];
            }
         }
         for(int i = 0; i < K; ++i) {
            for(int j = 0; j < M; ++j) {
               ++num[j][kcol[i]];
            }
         }
         for(int i = 0; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
               if(num[i][j] % 2 == 1) ++number;
            }
         }
           System.out.println(number);
      }
      in.close();
   }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 과제7
 * @author 2020136129 최수연
 * 문제 B: 전체 배열 요소 곱의 부호
 */

/*
 * T,N을 입력받고, 숫자를 받아 저장할 배열 A를 생성하여 초기화한다.
 * for문을 통해 A배열에 인덱스 0에서 N-1번까지 숫자를 받아 정수형 변수 num에 곱한다.
 * if문을 사용하여 num이 0보다 크면 1, 0이면 0, 0보다 작으면 -1을 반환하도록 한다.
 */

public class Main {
   
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int T = in.nextInt();
       for(int t = 0; t < T; ++t){
           int num = 1;
           int N = in.nextInt();
           int [] A = new int[N];
           for(int n = 0; n < N; ++n){
        	   A[n] = in.nextInt();
               num *= A[n];
           }
           if(num > 0) System.out.println(1);
           else if(num == 0) System.out.println(0);
           else System.out.println(-1);
       }
       in.close();
   }
    
}