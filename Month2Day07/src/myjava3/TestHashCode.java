package myjava3;
/*
 * 1. ����: Object Ŭ�������� �ڽ� Ŭ������ ������� hashCode() �޼ҵ带 ����ؼ� ��ü�� �����ϱ�
 *     -> ��ü�� �����ϱ�: ���� �ٸ� �������� ���
 */
class MyClass1 {
	private int m_a;
	public MyClass1(int a) {
		m_a = a;
	}
	public void show() {
		System.out.println("��������� m_a�� ���� "+ m_a);
	}
	@Override 
	public String toString() {
		String result;
		result = m_a + "";
		return result;
	}
}
public class TestHashCode {

	public static void main(String[] args) {
		
		// 1. ù ��° ��ü�� �����ϰ� ��ü�� �ּҸ� ���� ���� a�� ����
		MyClass1 a = new MyClass1(10);
		// 2. �ι�° ��ü�� �����ϰ� ��ü�� �ּҸ� ���� ���� b�� ����
		MyClass1 b = new MyClass1(20);
		// 3. ���� ���� a�� ȣ���� �� �ִ� hashCode() �Լ��� ���
		int code = a.hashCode();
		// 4. ���� ���� b�� ȣ���� �� �ִ� hashCode() �Լ��� ���
		int code2 = b.hashCode();
		// 5. if ���ǹ��� ����ؼ� �ؽ� �ڵ� ���� �������� ���ϱ�
		if(code == code2) {
			System.out.println("�ؽ� �ڵ� ���� �����Ƿ� ���� ��ü");
		}else {
			System.out.println("�ؽ� �ڵ� ���� �ٸ��Ƿ� �ٸ� ��ü");
		}
		
		/*
		 * ����: ���ο� ��ü�� �����ϰ� ��ü�� �ּҸ� ���� ���� c�� ����
		 * 1) ������ Ŭ������ ���������� = new Ŭ������(������);
		 * 2) hashCode() �޼ҵ带 ȣ��: int code3 = ����������.hashCode();
		 * 3) ������ ���� code2�� ���� code3�� ���� �������� ��
		 */
		MyClass1 c = new MyClass1(10);
		int code3 = c.hashCode();
		if(code2 == code3) {
			System.out.println("���� ��ü");
		}else {
			System.out.println("�ٸ� ��ü");
		}
		
	}

}
