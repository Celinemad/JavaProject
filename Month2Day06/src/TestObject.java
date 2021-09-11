/*
 * 1. ����: �⺻ ��Ű���� java.lang�� ����ϰ�, �ֻ��� Ŭ������ Object�� ���
 */
class MyClass extends java.lang.Object {
	private int m_a;
	public MyClass() {
		m_a = 10; // ������ �� �� �ָ� 0
	}
	public MyClass(int a) {
		m_a = a;
	}
	public void show() {
		System.out.println("��� ������ m_a�� ���� ���� " + m_a);
	}
	// ���� m_a�� ���� ��ȯ�ϴ� �޼ҵ带 ����: ������ public ��ȯ�� �޼ҵ��() {return ���������;}
	public int getA() {
		// get�� ���λ�(�������� ����)
		return m_a;
	}
	// ���� m_a�� ���� �ٸ� ������ �ٲٴ� �޼ҵ带 ����: ������ public void �޼ҵ�� (int �Ű�������) { ��������� = �Ű�������; }
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
		System.out.println("�������� b�� ������ �� �ִ� ������� m_a�� ���� " + value);
		System.out.println(b.getA());
	}

}
