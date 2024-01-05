/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file MonthlyWalkLog
 * 월별 걸음 거리 기록 테스트 프로그램
 */
public class MonthlyWalkLogTest {
	/*
	 * try catch를 사용하여 try에 기본 메인에서 실행할 함수들을 넣고,
	 * 만약 try에서 CheckedException 예외가 발생하면 catch 실행
	 */
	public static void main(String[] args) {
		try {
			MonthlyWalkLog log = new MonthlyWalkLog();
			log.recordDistance(3, -1);
			log.print();
		}
		catch (CheckedException e) {
			System.out.println(e.getMessage());
		}
	}
}