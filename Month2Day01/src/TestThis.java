/*
 * 1. ����: this ���۷��� ���� ����ϱ�
 * 	1) ���������� �޼ҵ忡�� ������ ������������ ���� ��쿡 ���
 * 	2) ���� Ŭ������ �ִ� �ٸ� �޼ҵ�κ��� ��ü�� �ּҸ� �Է¹ް� ���� ��쿡 ���
 * 	3) �ٸ� Ŭ������ ��ü�� �ּҸ� ��ȯ�ϰ� ���� ��쿡 ���
 */

// ���ο� This Ŭ������ ����
class This {
	private int a;
	public This() {
		System.out.println("�⺻ �����ڰ� ȣ���");
		a = 10; // ���� ��ɾ �ۼ����� ������ �⺻ ���� 0�� ����
	}
	public void method1() {
		System.out.println("�Ϲ� method1() �޼ҵ尡 ȣ���");
		// method2() �޼ҵ带 ȣ���ϸ鼭 method2() �޼ҵ��� This refa �Ű������� ��ü�� �ּҸ� ����
		method2(this);
	}
	// ���� ������ method2�� method1���κ��� ��ü�� �ּҸ� ���� ���� -> Ŭ������ ������
	public void method2(This refa) {
		System.out.println("method2(This) �޼ҵ尡 ȣ���");
		System.out.println("��������� a�� ���� "+refa.a);
	}
	// ���� ������ method3�� ��ȯ������ ��ü�� �ּ� -> ��ȯ���� Ŭ���������� �ۼ�
	public This getThis() {
		System.out.println("��ü�� �ּҸ� ��ȯ�ϴ� getThis() �޼ҵ尡 ȣ���");
		return this;
	}
}

public class TestThis {

	public static void main(String[] args) {
		
		//1. This Ŭ������ ����ϱ� ���� ��ü�� ����: �⺻ �����ڸ� ȣ��: new This();
		This a = new This();
//		System.out.println("");
		//2. This Ŭ�������� ������ method1() �޼ҵ带 ȣ��
		a.method1();
//		System.out.println("");
		//3. This Ŭ�������� ������ getThis() �޼ҵ带 ȣ�� 
		// -> ����: This Ŭ�������� ���� ��� ��������� ����Լ� �̸����� ��밡��
		// -> private ���� �����ڸ� ���� ��������� ����Լ��� ����
		This b = a.getThis();
//		System.out.println("");
		//4. ���� ���� �������� b�� ����ؼ� This Ŭ������ �ִ� method1() �޼ҵ带 ȣ��
		b.method1();
		
	}

}
