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
		System.out.println("��� ������ m_a�� ���� "+m_a);
		System.out.println("��� ������ m_c�� ���� "+m_c);
	}
}
