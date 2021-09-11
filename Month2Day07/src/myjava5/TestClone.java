package myjava5;
/*
 * 1. ����: Object Ŭ�������� �ڽ� Ŭ������ ������� clone() �޼ҵ带 ����ؼ� �ҽ�(����) ��ü�� ���� �ִ� ��� �ʵ��� ������ ���ο� ��ü�� �����ϱ�
 */
public class TestClone implements java.lang.Cloneable {
	
	// 2. �⺻ Ÿ���� int�� ����ϴ� ��� ������ ����
	private int m_a;
	private int m_b;
	
	// 3. �����ڸ� �����ؼ� main() �޼ҵ�κ��� �ϳ��� ���� ���� �޾ƿ���
	public TestClone(int a, int b) {
		System.out.println("TestClone(int) �����ڰ� ����");
		m_a = a;
		m_b = b;
	}
	
	// 4. �ҽ�(����) ��ü�� ��� �ʵ� ���� ������ ���ο� ��ü�� �ּҸ� ��ȯ�ϴ� getClone() �޼ҵ带 ����
	public TestClone getClone() {
		//  5. ���� ���� ��ü�� �ּҸ� ������ ���� ���� a�� ����
		TestClone a = null;
		//  6. ���� ��Ȳ�� ����ϱ� ���� try~catch ���� �ۼ�
		try {
			a = (TestClone)clone();
			// clone() �޼ҵ带 ������� �ʴ� ���
			/*
			 * a = new TestClone();
			 * a.��������� = this.���������;
			 */
		} catch(java.lang.CloneNotSupportedException e) {
			// 7. ���� ��Ȳ�� �߻��� ��쿡�� �ڼ��� ���� ������ ȭ�鿡 ���
			e.printStackTrace();
		}
		// 8. ���� ���� ��ü�� �ּҸ� ��ȯ
		return a;
	}
	
	
	public static void main(String[] args) {
		
		// 1. ù ��° ��ü�� �����ϰ� ���������� a�� ����
		TestClone a = new TestClone(10, 20);
		// 2. getClone() �޼ҵ带 ȣ���ؼ� ������ �����մϴ�.
		TestClone b = a.getClone();
		// 3. �ҽ� ��ü�� ��� �ʵ�(��� ����)�� ���� ���
		System.out.println("�ҽ�(����) ��ü�� ��������� m_a�� ���� "+ a.m_a);
		// 4. ���� ������ ���� ��ü�� ��� �ʵ�(��� ����)�� ���� ���
		System.out.println("������ ��ü�� ��������� m_a�� ���� "+ b.m_a);
		System.out.println("�ҽ�(����) ��ü�� ��������� m_a�� ���� "+ a.m_b);
		System.out.println("������ ��ü�� ��������� m_a�� ���� "+ b.m_b);
	}

}
