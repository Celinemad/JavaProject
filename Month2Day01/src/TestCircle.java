/*
 * 1. ����: �� ������ �߻�ȭ ��Ų Circle Ŭ������ ����
 * 2. Circle Ŭ������ ���� ����
 * 	1) �������: �������� ������ ���� ����: private double radius;
 * 	2) �⺻ ������: public Ŭ������() { radius = ��; }
 * 	3) �ٸ� Ŭ�����κ��� �ϳ��� �Ǽ����� �޴� ������: public Ŭ������(double radius) { radius = radius; }
 */
class Circle {
	private double radius;
	public Circle() {
		radius = 1.52;
	}
	public Circle(double radius) {
		// radius = radius;
		this.radius = radius;
	}
	public void show() {
		System.out.println("�� ������ �������� "+radius);
	}
}

public class TestCircle {

	public static void main(String[] args) {
		
		// 1. Circle Ŭ������ ����ϱ� ���� ��ü ����
		Circle a = new Circle();
		// 2. show() �Լ��� ȣ���ϱ� -> 1.2�� ���
		a.show();
		// 3. �ϳ��� �Ǽ����� �޴� �����ڸ� ȣ��
		Circle b = new Circle(3.2);
		b.show();
		
	}

}
