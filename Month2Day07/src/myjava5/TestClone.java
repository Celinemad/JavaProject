package myjava5;
/*
 * 1. 제목: Object 클래스에서 자식 클래스로 상속해준 clone() 메소드를 사용해서 소스(원본) 객체가 갖고 있는 모든 필드의 값들을 새로운 객체에 복사하기
 */
public class TestClone implements java.lang.Cloneable {
	
	// 2. 기본 타입인 int를 사용하는 멤버 변수를 선언
	private int m_a;
	private int m_b;
	
	// 3. 생성자를 정의해서 main() 메소드로부터 하나의 정수 값을 받아오기
	public TestClone(int a, int b) {
		System.out.println("TestClone(int) 생성자가 실행");
		m_a = a;
		m_b = b;
	}
	
	// 4. 소스(원본) 객체의 모든 필드 값을 복사한 새로운 객체의 주소를 반환하는 getClone() 메소드를 정의
	public TestClone getClone() {
		//  5. 새로 만든 객체의 주소를 보관할 참조 변수 a를 선언
		TestClone a = null;
		//  6. 예외 상황을 대비하기 위한 try~catch 블럭을 작성
		try {
			a = (TestClone)clone();
			// clone() 메소드를 사용하지 않는 경우
			/*
			 * a = new TestClone();
			 * a.멤버변수명 = this.멤버변수명;
			 */
		} catch(java.lang.CloneNotSupportedException e) {
			// 7. 예외 상황이 발생한 경우에는 자세한 예외 내용을 화면에 출력
			e.printStackTrace();
		}
		// 8. 새로 만든 객체의 주소를 반환
		return a;
	}
	
	
	public static void main(String[] args) {
		
		// 1. 첫 번째 객체를 생성하고 참조벼수인 a에 대입
		TestClone a = new TestClone(10, 20);
		// 2. getClone() 메소드를 호출해서 복제를 시작합니다.
		TestClone b = a.getClone();
		// 3. 소스 객체의 모든 필드(멤버 변수)의 값을 출력
		System.out.println("소스(원본) 객체의 멤버변수인 m_a의 값은 "+ a.m_a);
		// 4. 새로 생성한 복제 객체의 모든 필드(멤버 변수)의 값을 출력
		System.out.println("복제된 객체의 멤버변수인 m_a의 값은 "+ b.m_a);
		System.out.println("소스(원본) 객체의 멤버변수인 m_a의 값은 "+ a.m_b);
		System.out.println("복제된 객체의 멤버변수인 m_a의 값은 "+ b.m_b);
	}

}
