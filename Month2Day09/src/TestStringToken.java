/*
 * 1. 제목: java.util 패키지에 있는 StringTokenizer 클래스를 사용해서
 *  	   하나의 문자열 안에 있는 여러 문자열들을 분리(추출 또는 뽑기)
 */
import java.util.StringTokenizer;

public class TestStringToken {

	public static void main(String[] args) {
		// 2. 하나의 문자열 값을 지정할 수 있는 StringTokenizer(String) 생성자를 사용하기
		StringTokenizer a = new StringTokenizer("홍길동 김길동 나길동 다길동");
		
		// 3. while() 반복문을 사용하기: hasMoreTokens() 메소드를 조건식에 사용할 수 있기 때문에
		while(a.hasMoreTokens()==true) {
			// 4. nextToken() 메소드를 실행
			String token = a.nextToken();
			// 5. 토큰을 출력
			System.out.println("문자열에서 읽어 온 토큰은 "+ token);
		}
		
		// 4. 문자열 내부에 있는 서부 문자열(부분 문자열)의 구조: 키=값
		// 예) name=kitae(한글)
		String string = "name=가은&addr=경기도 의왕시 내손동&age=23";
		// 5. StringTokenizer(String, String) 생성자를 사용
		StringTokenizer b = new StringTokenizer(string, "&");
		// 6. while 반복문
		while(b.hasMoreTokens()) {
			String token = b.nextToken();
			System.out.println("문자열에서 읽어 온 토큰은 "+ token);
		}
		
		b = new StringTokenizer(string, "&");
		System.out.println(b.countTokens());
		int count = b.countTokens();
		for(int i=0; i<count; i++) {
			String token = b.nextToken();
//			System.out.println(token);
			if(token.equals("name=가은")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 5, "이름: ");
				System.out.println(sb);
			} if(token.equals("addr=경기도 의왕시 내손동")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 5, "주소: ");
				System.out.println(sb);
			} if(token.equals("age=23")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 4, "나이: ");
				System.out.println(sb);
			}
		}
		
	}

}
