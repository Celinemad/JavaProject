package myjava3;
/*
 * 1. 제목: Object 클래스에서 자식 클래스로 상속해준 hashCode() 메소드를 사용해서 객체를 구별하기
 *     -> 객체를 구별하기: 서로 다른 정수값이 출력
 */
class MyClass1 {
	private int m_a;
	public MyClass1(int a) {
		m_a = a;
	}
	public void show() {
		System.out.println("멤버변수인 m_a의 값은 "+ m_a);
	}
	@Override 
	public String toString() {
		String result;
		result = m_a + "";
		return result;
	}
}
public class TestHashCode {

	public static void main(String[] args) {
		
		// 1. 첫 번째 객체를 생성하고 객체의 주소를 참조 변수 a에 대입
		MyClass1 a = new MyClass1(10);
		// 2. 두번째 객체를 생성하고 객체의 주소를 참조 변수 b에 대입
		MyClass1 b = new MyClass1(20);
		// 3. 참조 변수 a로 호출할 수 있는 hashCode() 함수를 사용
		int code = a.hashCode();
		// 4. 참조 변수 b로 호출할 수 있는 hashCode() 함수를 사용
		int code2 = b.hashCode();
		// 5. if 조건문을 사용해서 해시 코드 값이 같은지를 비교하기
		if(code == code2) {
			System.out.println("해시 코드 값이 같으므로 같은 객체");
		}else {
			System.out.println("해시 코드 값이 다르므로 다른 객체");
		}
		
		/*
		 * 퀴즈: 새로운 객체를 생성하고 객체의 주소를 참조 변수 c에 대입
		 * 1) 형식은 클래스명 참조변수명 = new 클래스명(정수값);
		 * 2) hashCode() 메소드를 호출: int code3 = 참조변수명.hashCode();
		 * 3) 위에서 변수 code2의 값과 code3의 값이 같은지를 비교
		 */
		MyClass1 c = new MyClass1(10);
		int code3 = c.hashCode();
		if(code2 == code3) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
		
	}

}
