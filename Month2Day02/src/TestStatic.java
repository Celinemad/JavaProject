/*
 * 1. 제목: static 제한자(수정자)를 사용해서 멤버 변수와 메소드를 하나만 생성
 */
public class TestStatic {

	// 1) static 멤버 변수를 선언
	private static int m_sa;
	// 2) static 메소드를 생성
	public static void smethod() {
		System.out.println("smethod() 메소드가 실행됨");
		m_sa = 10;
	}
	// 3) 새로운 static 메소드를 생성해서 m_sa 멤버 변수에 값을 대입
	public static void smethod2(int a) {
		System.out.println("smethod2(int) 메소드가 실행됨");
		m_sa = a;
	}
	// 4) 새로운 static 메소드를 생성해서 m_sa 멤버 변수의 값을 출력
	public static void show() {
		System.out.println("show() 메소드가 실행됨");
		System.out.println("멤버 변수인 m_sa의 값은 "+m_sa);
	}
	// 멤버 변수가 static이면 메소드도 모두 static이 일반적
	
	public static void main(String[] args) {
		// static 메소드를 호출하는 형식: 클래스명 + 점(.) + 메소드명();
		TestStatic.smethod();
		// show() 메소드를 호출
		TestStatic.show();
		// smethod2(int)메소드를 호출
		TestStatic.smethod2(20);
		// show() 메소드를 호출
		TestStatic.show();
	}

}
