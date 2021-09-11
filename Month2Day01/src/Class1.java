/*
 * 1. ����: �����ε�(�Լ��� �ߺ�: Overloading)
 * 	- �ϳ��� Ŭ�������� �̸��� ���� �Լ��� ���� �� �ۼ�
 * 	- ��, �ܺ� �Է�(�Ű����� �Ǵ� ����(Argument)) �κ��� �޶�� �մϴ�.
 * 	- ���� ������ �ȵǰ�, ��ü ���⸸ ������ ���
 */

// ���� Ŭ������ ����
class MyCalculator {
	// 2���� ���� ���� �޼ҵ� ����
	public int add(int a, int b) {
		int c;
		System.out.println("2���� ������ ���ϴ� add(int, int) �޼ҵ尡 ȣ���");
		c = a+b;
		return c;
	}
	// �����ε� ������ �̿��ؼ� add �Լ����� �ٽ� ���
	public int add(int a, int b, int c) {
		int d;
		System.out.println("3���� ������ ���ϴ� add(int, int, int) �޼ҵ尡 ȣ���");
		d = a+b+c;
		return d;
	}
	// �Ǽ� 2���� ���� ���� �Լ� ����: �����ε��� ����ؼ� add �̸��� �ٽ� ��� ����
	public double add(double a, double b) {
		double c;
		System.out.println("2���� �Ǽ��� ���ϴ� add(double, double) �޼ҵ尡 ȣ���");
		c = a + b;
		return c;
	}
	public int times(int a, int b) {
		int c;
		System.out.println("2���� ������ ���ϴ� times(int, int) �޼ҵ尡 ȣ���");
		c = a * b;
		return c;
	}
	public int times(int a, int b, int c) {
		int d;
		System.out.println("3���� ������ ���ϴ� times(int, int, int) �޼ҵ尡 ȣ���");
		d = a * b * c;
		return d;
	}
	public double times(double a, double b) {
		double c;
		System.out.println("2���� �Ǽ��� ���ϴ� times(double, double) �޼ҵ尡 ȣ���");
		c = a * b;
		return c;
	}
}

public class Class1 {
	public static void main(String[] args) {
		
		//1. MyCalculator Ŭ������ ����ϱ� ���� ���� ������ ���� + new �����ڸ� ����ؼ� ��ü�� ����
		MyCalculator a = new MyCalculator();
		//2. ���� ���� �Ի��� �����ϱ�
		int result = a.add(10, 20);
		//3. ���� ���� ����� ���
		System.out.println("10 ���ϱ� 20�� "+ result);
		//4. 3���� ���� ���� ����� �����ϱ�: add()�޼ҵ� �̸��� ���
		result = a.add(10, 20, 30);
		//5. ��� ���
		System.out.println("10 ���ϱ� 20 ���ϱ� 30�� "+result);
		//6. 2���� �Ǽ� ���� ���: add() �޼ҵ� �̸��� ���
		double dresult = a.add(3.2, 2.5);
		//7. ��� ���
		System.out.println("3.2 ���ϱ� 2.5�� "+dresult);
		
		int tresult = a.times(10, 20);
		System.out.println("10 ���ϱ� 20�� "+tresult);
		tresult = a.times(10, 20, 30);
		System.out.println("10 ���ϱ� 20 ���ϱ� 30�� "+tresult);
		double dtresult = a.times(1.5, 2.5);
		System.out.println("1.5 ���ϱ� 2.5�� "+dtresult);
		
	}

}
