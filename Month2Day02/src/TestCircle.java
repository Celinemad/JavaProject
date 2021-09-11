/*
 * 1. ����: ��ü�� ġȯ ����
 */
// Circle Ŭ���� ����: ���� �߿��� ���� �߻�ȭ(�ܼ�ȭ)
class Circle {
	// 1. ��� ���� ����: ���� �������� ������ ���� radius�� ����(����)
	private int radius;
	
	// 2. �⺻ �����ڸ� ���� ����: �ٸ� Ŭ�����κ��� ���� ���� �ʴ� ������
	public Circle() {
		System.out.println("�⺻ �����ڰ� ����");
		radius = 3; // 3�� �����ڰ� ���� ������ ��
	}
	
	// 3. �Ű� ������ ���� �����ڸ� ����: �ٸ� Ŭ�����κ��� ���� �ϳ��� �޴� ������ -> ���� ������ ���� ����
	public Circle(int radius) {
		System.out.println("�ٸ� Ŭ�����κ��� ���� �������� �޴� ������");
		this.radius = radius;
	}
	
	// 4. ���� ���̸� ���ϴ� �޼ҵ带 ����: ���� ���̸� ���ϴ� ������ 3.14*������*������
	public double getArea() {
		System.out.println("���� ���̸� ���մϴ�.");
		double result = 3.14*radius*radius;
		return result;
	}
	
	// 5. ���� �������� ���� ���̸� ȭ�鿡 �����ִ� show() �޼ҵ带 ����
	public void show() {
		System.out.println("���� �������� "+radius+", ���� ���̴� "+getArea());
	}
}
public class TestCircle {

	public static void main(String[] args) {
		// 1. 2���� ��ü�� �����ϱ�
		Circle ob1 = new Circle(2);
		Circle ob2 = new Circle(3);
		
		// 2. show() �޼ҵ带 ȣ��
		ob1.show();
		ob2.show();
		
		// ù ���� ��ü�� �ּҸ� ������ back_ob1 ���� ������ ���� + ù ��° ��ü�� �ּҸ� ����
		Circle back_ob1 = ob1;
		back_ob1.show();
		
		// 3. ��ü�� ġȯ
		ob1 = ob2; // ob1�� ���� ����Ű�� ��ü�� "������"�� ��: �� �̻� ������ �� ���� (�̾�)��ü
		ob1.show();
		ob2.show();
		back_ob1.show();
	}

}
