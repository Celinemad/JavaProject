package myjava4;

public class Parent {
	private int m_a;
	private int m_c;
	public Parent() {
		m_a = 10;
	}
	public Parent(int a) {
		m_a = a;
	}
	public Parent(int a, int c) {
		m_a = a;
		m_c = c;
	}
	public void show() {
		System.out.println("멤버 변수인 m_a의 값은 "+m_a);
		System.out.println("멤버 변수인 m_c의 값은 "+m_c);
	}
}
