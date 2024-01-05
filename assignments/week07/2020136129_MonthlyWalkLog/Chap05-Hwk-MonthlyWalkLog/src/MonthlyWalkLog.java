import java.time.LocalDate;
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연
 * @file MonthlyWalkLog
 * 월별 걸음 거리 기록
 */
public class MonthlyWalkLog {
	private double[] dailyDistance = null;
	public final int year;
	public final int month;
	private LocalDate logDate;
	public MonthlyWalkLog() {
		logDate = LocalDate.now();
		this.year = logDate.getYear();
		this.month = logDate.getMonthValue();
		dailyDistance = new double[logDate.lengthOfMonth()];
	}
	/*
	 * MonthlyWalkLog 함수에서 CheckedException 공표 처리
	 * 만약 year가 음수 또는 0이거나 month가 음수 또는 0이면 예외 처리
	 * 아니면 그대로 실행
	 */
	public MonthlyWalkLog(int year, int month) throws CheckedException {
		LocalDate today = LocalDate.now();
		if(year <= 0 || month <= 0) {
			throw new CheckedException("음수/0");
		}
		else {
			this.year = (year>=2000)? year: today.getYear();
			this.month = (month>=1&&month<=12)? month: today.getMonthValue();
			logDate = LocalDate.of(this.year, this.month, 1);
			dailyDistance = new double[logDate.lengthOfMonth()];
		}
	}
	/*
	 * recordDistance 함수에서 CheckedException 공표 처리
	 * 만약 day가 음수 또는 0 이거나 day가 해당 month의 일수보다 크거나 distance가 음수거나 0이면 예외 처리
	 * 아니면 그대로 실행
	 */
	public void recordDistance(int day, double distance) throws CheckedException {
		if(day <= 0 || day > logDate.lengthOfMonth() || distance <= 0)
			throw new CheckedException("음수/0 또는 오버플로우");
		else
			dailyDistance[day-1] = distance;
	}
	/*
	 * getDistance 함수에서 CheckedException 공표 처리
	 * 만약 day가 음수 또는 0 이면 예외 처리
	 * 아니면 그대로 실행
	 */
	public double getDistance(int day) throws CheckedException {
		if(day <= 0)
			throw new CheckedException("음수/0");
		else
			return dailyDistance[day-1];
	}
	public void print() {
		String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		System.out.printf("%d년 %d월%n", year, month);
		for(var weekday: weekdays)
			System.out.printf("%10s ", weekday);
		System.out.println();
		int w = logDate.getDayOfWeek().ordinal();
		System.out.print(" ".repeat((w+1)*11));
		int day=0;
		while(day<logDate.lengthOfMonth()) {
			System.out.printf("%10.2f ", dailyDistance[day]);
			++day;
			w = (w+1)%7;
			if(w==6) System.out.println();
		}
	}
}