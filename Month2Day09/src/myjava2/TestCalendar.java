package myjava2;
/*
 * 1. 제목: java.util.Calendar 클래스를 사용해서 날짜와 시간을 출력
 * 2. 응용 예제: 사용자의 나이를 구하기
 */
import java.util.Calendar;

public class TestCalendar {

	public static void main(String[] args) {
		
		// 오늘의 연도, 월, 일, 시간, 분, 초를 출력
		// 1. Calendar 클래스를 사용해서 객체를 생성하기: 형식은 Calendar 변수명 = Calendar.getInstance();
		// -> 주의할 점: new Calendar() 명령어를 사용할 수 없음
		Calendar a = Calendar.getInstance();
		
		// 2. 연도를 출력
		System.out.println("연도는 "+ a.get(Calendar.YEAR));
		// 3. 월을 출력
		System.out.println("월은 "+ (a.get(Calendar.MONTH)+1));
		// 4. 일을 출력
		System.out.println("일은 "+ a.get(Calendar.DAY_OF_MONTH));
		// 5. 시간을 출력
		System.out.println("시간은 "+ a.get(Calendar.HOUR));
		// 6. 분을 출력
		System.out.println("분은 " + a.get(Calendar.MINUTE));
		// 7. 초를 출력
		System.out.println("초는 " + a.get(Calendar.SECOND));
		// 8. 오전/오후: Calendar.AM_PM
		System.out.println("오전/오후 구분 값은 " + a.get(Calendar.AM_PM));
		
		
		
	}

}
