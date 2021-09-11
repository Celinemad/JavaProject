package myjava3;
/*
 * 1. 제목: 한국 나이 구하기
 */
import java.util.Calendar;

public class TestAge {

	public static void main(String[] args) {
		
		// 2. 현재 날짜 구하기 
		Calendar curCal = Calendar.getInstance();
		
		// 3. 생일 날짜 구하기
		Calendar birCal = Calendar.getInstance();
		
		// 4. set() 메소드를 실행해서 현재 날짜를 생일로 변환
		birCal.set(1999, 6, 22);
		
		// 5. 현재 날자의 연도 구하기
		int curYear = curCal.get(Calendar.YEAR);
		
		// 6. 생일의 연도 구하기
		int birYear = birCal.get(Calendar.YEAR);
		
		// 7. 실제 나이 구하기: 현재 날짜의 연도 - 생일 날짜의 연도 + 1
		int age = curYear - birYear + 1;
		
		// 8. 실제 나이를 출력
		System.out.println("실제 나이는 "+ age);
		
		// 9. 만 나이 구하기
		// 	1) 현재 날자의 월과 일을 합치기: int 변수명 = 월 * 100 + 일;
		int curMD = (curCal.get(Calendar.MONTH)+1)*100 + curCal.get(Calendar.DAY_OF_MONTH);
		System.out.println("현재 날짜의 월과 일을 합친 결과는 " + curMD);
		
		//  2) 생일 날짜의 월과 일을 합치기: 
		int birMD = (birCal.get(Calendar.MONTH)+1)*100 + birCal.get(Calendar.DAY_OF_MONTH);
		System.out.println("생일 날짜의 월과 일을 합친 결과는 " + birMD );
		
		if(birMD >= curMD) {
			age = age - 2;
			System.out.println("현재의 만 나이는 "+ age);
		} else {
			age = age - 1;
			System.out.println("현재의 만 나이는 "+ age);
		}
		
	}

}
