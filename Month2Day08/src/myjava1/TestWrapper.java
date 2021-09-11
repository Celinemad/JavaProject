package myjava1;
/*
 * 1. 제목: 포장 클래스인 Wrapper를 사용해서 기본 타입의 값을 객체화 하기(Wrapper 클래스의 멤버 변수에 값을 보관)
 */
public class TestWrapper {

	public static void main(String[] args) {
		
		// 2. Wrapper 클래스에 기본 값을 저장하기: valueOf() 메소드를 사용
		Integer a = Integer.valueOf(100);
		// 추가: intValue() 메소드를 호출해서 100을 꺼내오기
		int value = a.intValue();
		System.out.println("기본 값 100을 꺼내온 결과는 " + value);
		
		float value2 = a.floatValue();
		System.out.println("기본 값 100을 float 타이브로 바꾼 결과는 " + value2);
		
		
		// 3. valueOf(기본값: 정수 또는 "정수")
		Integer b = Integer.valueOf("100");
		
		Double c = Double.valueOf(3.14);
		Double d = Double.valueOf("3.14");
		double value3 = c.doubleValue();
		System.out.println("실수 3.14를 꺼내온 결과는 "+ value3);
		
		Boolean e  = Boolean.valueOf(true);
		Boolean f = Boolean.valueOf("true");
		boolean value4 = e.booleanValue();
		System.out.println("논리값 true를 꺼내온 결과는 " + value4);
		
		Character g = Character.valueOf('a');
		// 주의할 점: Character 클래스가 갖고 있는 valueOf() 메소드는 한가지: valueOf('하나의 문자')
		char value5 = g.charValue();
		System.out.println("하나의 문자인 a를 꺼내온 결과는 "+ value5);
		
		/* 
		 * 10진수를 2진수로 변환: Integer 클래스의 toBinaryString() 메소드를 사용
		 * 	1) 형식) String 변수명 = Integer.toBinaryString(10진_ 정수);
		 */
		String binaryString = Integer.toBinaryString(10);
		System.out.println("10진수 10을 2진수로 변환한 결과는 "+ binaryString);
		
		// 2) 10진수 8진수로 변환(결과는 문자열)
		String octalString = Integer.toOctalString(10);
		System.out.println("10진수 10을 8진수로 변환한 결과는 " + octalString);
		
		// 3) 10진수를 16진수로 변환
		String hexString = Integer.toHexString(10);
		System.out.println("10진수 10을 16진수로 변환한 결과는 " + hexString);
		
		// 4) toUpperCase(), toLowerCaser() 메소드를 실행
		char ch_a = Character.toLowerCase('A');
		char ch_b = Character.toUpperCase('a');
		System.out.println("알파벳 A를 소문자로 변환한 결과는 " + ch_a);
		System.out.println("알파벳 a를 대문자로 변환한 결과는 " + ch_b);
		
		// 5) isDigit() 메소드를 실행
		boolean b_a = Character.isDigit('5');
		System.out.println("5는 숫자인가요? 결과는 "+ b_a);
		
		boolean b_b = Character.isDigit('a');
		System.out.println("a는 숫자인가요? 결과는 " + b_b);
		
		// 6) isAlphabetic() 메소드를 실행
		boolean b_c = Character.isAlphabetic('a');
		System.out.println(b_c);  
		
		boolean b_d = Character.isAlphabetic('A');
		System.out.println(b_d);
		
		boolean b_e = Character.isAlphabetic('5');
		System.out.println(b_e);
		
		/*
		 * JDK 1.5부터 지원되는 자동 박싱과 자동 언박싱 기능을 사용하기
		 */
		// 1. 자동 박싱
		Integer intObject = 10;  // ==  Integer intObject = Integer.valueOf(10);
		// 2. 자동 언박싱
		int i_a = intObject;  // ==  int i_a = intObject.intValue();
		System.out.println(i_a);
		
		
		
		
		
	}

}
