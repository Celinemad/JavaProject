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
		System.out.println("멤버변수 m_b의 값은 "+m_b);
	}
	public void showABC() {
		System.out.println("새로 정의한 showABC()");
		super.show();
		
	}
}
