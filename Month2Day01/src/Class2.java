/*
 * 1. ����: �����ڿ� �����ε� ������ �����ϱ�
 * 	1) �⺻ �����ڸ� ���� ����
 * 	2) �ٸ� Ŭ�����κ��� ���� �޴� �����ڵ��� �߰��� ����
 */

// ���ο� Ŭ������ ����: �̸��� MethodOverload
class MethodOverload{
	// 1. �����ڸ� ����
	public MethodOverload() {
		System.out.println("�⺻ �����ڰ� ȣ���");
	}
	// 2. �ٸ� Ŭ�����κ��� �ϳ��� ������ �Է¹޴� ������(�����ε��� �����)
	public MethodOverload(int a) {
		System.out.println("�ϳ��� ������ �Է� �޴� �����ڰ� ȣ���");
	}
	// 3. �ٸ� Ŭ�����κ��� 2���� ������ �Է¹޴� ������(�����ε�)
	public MethodOverload(int a, int b) {
		System.out.println("2���� ������ �Է� �޴� �����ڰ� ȣ���");
	}
	// 4. �ٸ� Ŭ�����κ��� �ϳ��� ���ڿ��� �Է¹޴� ������(�����ε�)
	public MethodOverload(String a) {
		System.out.println("�ϳ��� ���ڿ��� �Է� �޴� �����ڰ� ȣ���");
	}
	// 5. �ٸ� Ŭ�����κ��� �ϳ��� �Ǽ��� �Է� �޴� ������(�����ε�)
	public MethodOverload(double a) {
		System.out.println("�ϳ��� �Ǽ��� �Է� �޴� �����ڰ� ȣ���");
	}
}

public class Class2 {

	public static void main(String[] args) {
		
		// 1. ������ ������ MethodOverload Ŭ������ ����ϱ�
		// 	1) �����ڿ� �°� ��ü�� ����
		//		��. ���� �����ڸ� ȣ���ϴ� ��ɾ�
		MethodOverload a = new MethodOverload();
		//		��. �ϳ��� ������ �Է� �޴� �����ڸ� ȣ��
		MethodOverload b = new MethodOverload(10);
		//		��. 2���� ������ �Է� �޴� �����ڸ� ȣ��
		MethodOverload c = new MethodOverload(10, 20);
		//		��. �ϳ��� �Ǽ��� �Է� �޴� �����ڸ� ȣ��
		MethodOverload d = new MethodOverload(3.4);
		//		��. �ϳ��� ���ڿ��� �Է� �޴� �����ڸ� ȣ��
		MethodOverload e = new MethodOverload("���ڿ�");
	}

}
