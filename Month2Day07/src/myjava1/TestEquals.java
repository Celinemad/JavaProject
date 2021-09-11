package myjava1;
/*
 * 1. 제목: Object 클래스에서 제공해주는 boolean equals(Object obj) 메소드의 기본 기능을 먼저 익히고,
 *         두 개의 값이 같은지를 비교하는 명령어를 작성(재정의)
 *         
 * 2. 새로운 클래스인 MyClass1을 정의
 * 3. 정수를 보관할 수 있는 멤버 변수 private int m_a; 를 선언
 * 4. 기본 생성자를 정의: public 클래스명() { m_a = 10;}
 * 5. 다른 클래스로부터 하나의 정수를 받는 생성자를 정의: public 클래스명(int a) { m_a = a; }
 * 6. 멤버 변수 m_a의 값을 읽는 메소드를 정의: public int getA() { return m_a; }
 * 7. 멤버 변수 m_a의 값을 수정하는 메소드를 정의: public void setA(int newA) { m_a = newA; }
 * 8. 멤버 변수 m_a의 값을 출력하는 메소드를 정의: public void show() { // 명령어를 추가; }
 * 9. Object 클래스에서 상속 받은 toString() 메소드를 재정의:
 *    @Override ...
 */
class MyClass1 {
	private int m_a;
	public MyClass1() {
		m_a = 10;
	}
	public MyClass1(int a) {
		m_a = a;
	}
	public int getA() {
		return m_a;
	}
	public void setA(int newA) {
		m_a = newA;
	}
	public void show() {
		System.out.println("멤버 변수인 m_a의 현재 값은 "+ getA());
	}
	@Override
	public String toString() {
		String result = m_a + ""; // +를 할 때, 하나라도 문자열이 있으면 문자열로 바뀜, m_a가 int라서 ""더해서 String으로 변환
		return result;
	}
	// public boolean equals(Object obj) 메소드를 재정의
	@Override
	public boolean equals(Object obj) {
		int value = getA();
		MyClass1 newRef = (MyClass1)obj;
		int value2 = newRef.getA();
		boolean result;
		if(value == value2) result = true;
		else result = false;
		return result;
	}
}
public class TestEquals {

	public static void main(String[] args) {
		
		// 새로운 참조 변수 c와 d를 선언: 값을 동일(30)
		MyClass1 c = new MyClass1(30);
		MyClass1 d = new MyClass1(30);
		boolean result2 = c.equals(d);
		if(result2 == true) {
			System.out.println("참조 변수 c와 d가 참조하고 있는 멤버 변수 m_a의 값이 동일");
		} else {
			System.out.println("값이 다름");
		}
		
	
		/*
		 * 새로운 참조 변수 e와 f를 선언: 값을 다르게
		 */
		MyClass1 e = new MyClass1(20);
		MyClass1 f = new MyClass1(30);
		boolean result3 = e.equals(f);
		if(result3 == true) {
			System.out.println("참조 변수 e와 f가 참조하고 있는 멤버 변수 m_a의 값이 동일");
		} else {
			System.out.println("값이 다름");
		}
		
		
		//1. MyClass1클래스를 사용해서 새로운 객체를 생성
		MyClass1 a = new MyClass1(10);
		// 2. MyClass1 클래스를 사용해서 두 번째 객체를 생성
		MyClass1 b = new MyClass1(10);
		// 3. equals() 메소드를 호출
		boolean result = a.equals(b);
		// 4. if 조건문을 사용해서 equals() 메소드의 반환 값을 검사하기
		if(result == true) {
			System.out.println("두 개의 객체가 주소가 동일");
		} else {
			System.out.println("두 개의 객체가 주소가 다름");
		}
		
		a = b;
		result = a.equals(b);
		// 4. if 조건문을 사용해서 equals() 메소드의 반환 값을 검사하기
		if(result == true) {
			System.out.println("두 개의 객체가 주소가 동일");
		} else {
			System.out.println("두 개의 객체가 주소가 다름");
		}
	}

}
