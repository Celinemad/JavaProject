package myjava4;

public class Child extends Parent {
	private int m_b;
	public Child() {
		super();
		m_b = 20;
	}
	public Child(int b) {
		super(b);
		m_b = b;
	}
	public Child(int a, int b, int c) {
		super(a, c);
		m_b = b;
	}
	public void show() {
		super.show();
		System.out.println("������� m_b�� ���� "+m_b);
	}
	public void showABC() {
		System.out.println("���� ������ showABC()");
		super.show();
		
	}
}
