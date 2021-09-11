package myjava1;
/*
 * 1. ����: Object Ŭ�������� �������ִ� boolean equals(Object obj) �޼ҵ��� �⺻ ����� ���� ������,
 *         �� ���� ���� �������� ���ϴ� ��ɾ �ۼ�(������)
 *         
 * 2. ���ο� Ŭ������ MyClass1�� ����
 * 3. ������ ������ �� �ִ� ��� ���� private int m_a; �� ����
 * 4. �⺻ �����ڸ� ����: public Ŭ������() { m_a = 10;}
 * 5. �ٸ� Ŭ�����κ��� �ϳ��� ������ �޴� �����ڸ� ����: public Ŭ������(int a) { m_a = a; }
 * 6. ��� ���� m_a�� ���� �д� �޼ҵ带 ����: public int getA() { return m_a; }
 * 7. ��� ���� m_a�� ���� �����ϴ� �޼ҵ带 ����: public void setA(int newA) { m_a = newA; }
 * 8. ��� ���� m_a�� ���� ����ϴ� �޼ҵ带 ����: public void show() { // ��ɾ �߰�; }
 * 9. Object Ŭ�������� ��� ���� toString() �޼ҵ带 ������:
 *    @Override ...
 */
class MyClass1 {
	private int m_a;
	public MyClass1() {
		m_a = 10;
	}
	public MyClass1(int a) {
		m_a = a;
	}
	public int getA() {
		return m_a;
	}
	public void setA(int newA) {
		m_a = newA;
	}
	public void show() {
		System.out.println("��� ������ m_a�� ���� ���� "+ getA());
	}
	@Override
	public String toString() {
		String result = m_a + ""; // +�� �� ��, �ϳ��� ���ڿ��� ������ ���ڿ��� �ٲ�, m_a�� int�� ""���ؼ� String���� ��ȯ
		return result;
	}
	// public boolean equals(Object obj) �޼ҵ带 ������
	@Override
	public boolean equals(Object obj) {
		int value = getA();
		MyClass1 newRef = (MyClass1)obj;
		int value2 = newRef.getA();
		boolean result;
		if(value == value2) result = true;
		else result = false;
		return result;
	}
}
public class TestEquals {

	public static void main(String[] args) {
		
		// ���ο� ���� ���� c�� d�� ����: ���� ����(30)
		MyClass1 c = new MyClass1(30);
		MyClass1 d = new MyClass1(30);
		boolean result2 = c.equals(d);
		if(result2 == true) {
			System.out.println("���� ���� c�� d�� �����ϰ� �ִ� ��� ���� m_a�� ���� ����");
		} else {
			System.out.println("���� �ٸ�");
		}
		
	
		/*
		 * ���ο� ���� ���� e�� f�� ����: ���� �ٸ���
		 */
		MyClass1 e = new MyClass1(20);
		MyClass1 f = new MyClass1(30);
		boolean result3 = e.equals(f);
		if(result3 == true) {
			System.out.println("���� ���� e�� f�� �����ϰ� �ִ� ��� ���� m_a�� ���� ����");
		} else {
			System.out.println("���� �ٸ�");
		}
		
		
		//1. MyClass1Ŭ������ ����ؼ� ���ο� ��ü�� ����
		MyClass1 a = new MyClass1(10);
		// 2. MyClass1 Ŭ������ ����ؼ� �� ��° ��ü�� ����
		MyClass1 b = new MyClass1(10);
		// 3. equals() �޼ҵ带 ȣ��
		boolean result = a.equals(b);
		// 4. if ���ǹ��� ����ؼ� equals() �޼ҵ��� ��ȯ ���� �˻��ϱ�
		if(result == true) {
			System.out.println("�� ���� ��ü�� �ּҰ� ����");
		} else {
			System.out.println("�� ���� ��ü�� �ּҰ� �ٸ�");
		}
		
		a = b;
		result = a.equals(b);
		// 4. if ���ǹ��� ����ؼ� equals() �޼ҵ��� ��ȯ ���� �˻��ϱ�
		if(result == true) {
			System.out.println("�� ���� ��ü�� �ּҰ� ����");
		} else {
			System.out.println("�� ���� ��ü�� �ּҰ� �ٸ�");
		}
	}

}
