package myjava1;
// 1. �θ� Ŭ������ ����
public class Parent {
	// 2. protected ��� ������ ����
	protected int m_a;
	// 3. �⺻ ������
	public Parent() {
		m_a = 10;
	}
	// 4. �ܺ� �Է� ������
	public Parent(int a) {
		m_a = a;
	}
	// 5. show() �޼ҵ� ����
	public void show() {
		System.out.println("protected ��������� m_a�� ���� "+ m_a);
	}
}
