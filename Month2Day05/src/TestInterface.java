/*
 * 1. ����: �������̽��� ����ϴ� ����
 * 	1) ���� ����� ����
 * 	2) ���� ��ӵ� ����
 * 	3) Ŭ������ �Բ� ��� ����
 * 		-> ����: ���������� class �ڽ�Ŭ������ extends �θ�Ŭ������ implements �������̽��� { ... }
 * 			-> ������ ��: implements ��ɾ ���� �ۼ��� �� ����
 * 				-> Ʋ�� ������ ��) ���������� class �ڽ�Ŭ������ implements �������̽���1 extends �θ�Ŭ������ { ... }
 */

// 1. ���� ����� ������ �ۼ�
/*
 * 2. 2���� �������̽��� ����
 * 	1) interface MyInterface1 { ... }
 * 	2) interface MyInterface2 { ... }
 * 
 * 3. ������ ������ 2���� �������̽��� �����ϴ� �ڽ� Ŭ������ ����
 * 	1) class Child implements MyInterface1, MyInterface2 { ... }
 */

import java.util.Scanner;

interface MyInterface1 {
	// 2���� ���� ���� �Լ��� �߻� �޼���� ����
	public abstract int iadd(int a, int b);
	// 2���� ���� ���� �Լ��� �߻� �޼���� ����(�߰�)
	public abstract int isub(int a, int b);
}

interface MyInterface2 {
	// 2���� �Ǽ� ���� �Լ��� �߻� �޼���� ����
	public abstract double dadd(double a, double b);
	// 2���� �Ǽ� ���� �Լ��� �߻� �޼���� ����(�߰�)
	public abstract double dsub(double a, double b);
}

class Child2 implements MyInterface1, MyInterface2{
	
	@Override
	public double dsub(double a, double b) {
		System.out.println("dsub(double, double) �޼��尡 ȣ��");
		double c = a - b;
		return c;
	}

	@Override
	public int isub(int a, int b) {
		System.out.println("isub(int, int) �޼��尡 ȣ��");
		int c = a - b;
		return c;
	}

	@Override
	public double dadd(double a, double b) {
		System.out.println("dadd(double, double) �޼��尡 ȣ��");
		double c = a + b;
		return c;
	}

	@Override
	public int iadd(int a, int b) {
		System.out.println("iadd(int, int) �޼��尡 ȣ��");
		int c = a + b;
		return c;
	}
	
}

public class TestInterface {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Child2 Ŭ������ ����ϱ�
		Child2 a = new Child2();
		// iadd() �޼��带 ȣ���ؼ� 2���� ������ ���ϱ�
		int iresult = a.iadd(10, 20);
		System.out.printf("%d + %d = %d\n", 10, 20, iresult);
		// dadd() �޼��带 ȣ���ؼ� 2���� �Ǽ��� ���ϱ�
		double dresult = a.dadd(3.2, 2.5);
		System.out.printf("%.2f + %.2f = %.2f\n", 3.2, 2.5, dresult);
		
		System.out.print("ù��° ������ �Է��ϼ���: ");
		int num1 = scanner.nextInt();
		System.out.print("�ι�° ������ �Է��ϼ���: ");
		int num2 = scanner.nextInt();
		
		int isubresult = a.isub(num1, num2);
		System.out.printf("%d - %d = %d\n", num1, num2, isubresult);
		
		System.out.print("ù��° �Ǽ��� �Է��ϼ���: ");
		double num3 = scanner.nextDouble();
		System.out.print("�ι�° �Ǽ��� �Է��ϼ���: ");
		double num4 = scanner.nextDouble();
		
		double dsubresult = a.dsub(num3, num4);
		System.out.printf("%.2f - %.2f = %.2f\n", num3, num4, dsubresult);
		
		
		scanner.close();
		
	}

}
