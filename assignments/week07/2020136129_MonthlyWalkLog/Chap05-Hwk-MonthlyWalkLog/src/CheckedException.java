/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file CheckedException 클래스
 * checked 예외 발생 클래스, Exception 상속
 */
public class CheckedException extends Exception {
	private static final long serialVersionUID = 3572524678561213823L;
	public CheckedException() {
		super("Checked 예외 발생");
	}
	public CheckedException(String msg) {
		super(msg);
	}
}