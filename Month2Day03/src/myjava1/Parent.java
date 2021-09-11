package myjava1;
// 1. 부모 클래스를 정의
public class Parent {
	// 2. protected 멤버 변수를 선언
	protected int m_a;
	// 3. 기본 생성자
	public Parent() {
		m_a = 10;
	}
	// 4. 외부 입력 생성자
	public Parent(int a) {
		m_a = a;
	}
	// 5. show() 메소드 정의
	public void show() {
		System.out.println("protected 멤버변수인 m_a의 값은 "+ m_a);
	}
}
