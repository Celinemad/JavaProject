/*
 * 1. ����: �޸𸮿� ����Ǿ� �ִ� ��Ʈ���� ����ؼ� �� ������ ����
 * 	1) ��Ʈ �� �� ����: & ��ȣ�� ���, �����Ǵ� ��Ʈ�� ��� 1�� ��쿡�� 1
 * 	2) ��Ʈ �� �� ����: | ��ȣ�� ���, �����Ǵ� ��Ʈ�� �ϳ��� 1�� ������ 1
 * 	3) ��Ÿ�� �� �� ����: ^ ��ȣ�� ���, �����Ǵ� ��Ʈ�� �ٸ� ��쿡�� 1, ������ 0
 * 	4) ��Ʈ ���� ����: ~ ��ȣ�� ���, ���� �ݴ�Ǵ� ��Ʈ�� ��ȯ(0->1, 1->0)
 */
import java.util.Scanner;

public class Class4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a=0, b=0;
		try {
			System.out.print("ù ��° ������ �Է��ϼ���: ");
			a = scanner.nextInt();
			System.out.print("�� ���� ������ �Է��ϼ���: ");
			b = scanner.nextInt();
			int c = a & b;
			System.out.println("��Ʈ �� �� ������ ����� "+c+ ", 2������ "+Integer.toBinaryString(c));
			System.out.println("�Է��� ù ��° ������ "+a+", 2������ "+Integer.toBinaryString(a));
			System.out.println("�Է��� �� ��° ������ "+b+", 2������ "+Integer.toBinaryString(b));
			
			c = a | b;
			System.out.println("��Ʈ �� �� ������ ����� "+c);
			c = a ^ b;
			System.out.println("��Ÿ�� �� �� ������ ����� "+c);
			c = ~a;
			System.out.println("��Ʈ ���� ����(~a)�� ����� "+c);
		} catch (Exception e) {
			System.out.println("���ܰ� �߻�");
			e.printStackTrace();
		} finally {
			System.out.println("������ �������� ����");
			System.out.println("���α׷��� ����");
		}
		
		
		
	}

}
