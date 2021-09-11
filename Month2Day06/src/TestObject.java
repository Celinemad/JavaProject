/*
 * 1. 제목: 기본 패키지인 java.lang을 사용하고, 최상위 클래스인 Object를 사용
 */
class MyClass extends java.lang.Object {
	private int m_a;
	public MyClass() {
		m_a = 10; // 임의의 값 안 주면 0
	}
	public MyClass(int a) {
		m_a = a;
	}
	public void show() {
		System.out.println("멤버 변수인 m_a의 현재 값은 " + m_a);
	}
	// 현재 m_a의 값을 반환하는 메소드를 정의: 형식은 public 반환형 메소드명() {return 멤버변수명;}
	public int getA() {
		// get은 접두사(관습적인 명명법)
		return m_a;
	}
	// 현재 m_a의 값을 다른 값으로 바꾸는 메소드를 정의: 형식은 public void 메소드명 (int 매개변수명) { 멤버변수명 = 매개변수명; }
	public void setA(int a) {
		m_a = a;
	}
}

public class TestObject {

	public static void main(String[] args) {
		
		MyClass a = new MyClass();
		a.show();
		a.setA(a.getA()+10);
		a.show();
		
		MyClass b = new MyClass(100);
		b.show();
		b.setA(b.getA()-10);
		b.show();
		int value = b.getA();
		System.out.println("참조변수 b로 접근할 수 있는 멤버변수 m_a의 값은 " + value);
		System.out.println(b.getA());
	}

}
