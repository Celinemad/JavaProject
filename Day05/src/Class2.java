/*
 * 1. ����: Scanner �Է� Ŭ������ ����ؼ� ����ڷκ��� 2���� ������ ���� �Է� �ޱ�
 * 2. Scanner �Է� Ŭ������ ����ϴ� ���
 * 1) import ��ɾ�: ������ import java.util.Scanner;
 * 2) ���� �����: ������ Scanner ������ = new Scanner(System.in);
 * 3) nextInt() �Լ��� ����ؼ� ���� �Է� �ޱ�: ������ int ������2 = ������.nextInt();
 * 4) �� �� �������� &&�� ����ϱ�: boolean ������3 = �񱳽�1 && �񱳽�2;
 * 5) ����� ����ϱ�: System.out.println(������3);
 * 6) �� �̻� Scanner Ŭ���� ����� ���� �������� close() �Լ��� ���: ������.close();
 */

import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.print("���� ������ ������ �Է��ϼ���(0 �̻� 100 ����): ");
		 int kor = scanner.nextInt();
		 // ����ڰ� �Է��� ���� ������ 0 �̻��̰� 100 ����(��ȿ�� ����) �˻��ϱ� 
		 boolean result = kor >= 0 && kor <= 100;
		 System.out.println(result);
		 
		 // ����ڷκ��� ���� ������ ������ �Է� �ޱ� 
		 System.out.print("���� ������ ������ �Է��ϼ���(0�̻� 100����): ");
		 int eng = scanner.nextInt();
		 boolean result2 = eng < 0 || eng > 100;
		 System.out.println(result2);
		 
		 
		 /*
		 System.out.print("ù ��° ������ �Է��ϼ���: ");
		 int a = scanner.nextInt();
		 System.out.print("�� ��° ������ �Է��ϼ���: ");
		 int b = scanner.nextInt();
		 
		 // �񱳽�1, �񱳽�2�� ����
		 // ����ڷκ��� �Է� �޴� ���� ���� ���� �Ǵ� ���� ������ �Ǵ� ��츦 ����
		 boolean result1 = a>=b && a<=b;
		 System.out.println(result1);
		 
		 boolean result2 = a>b || a<b;
		 System.out.println(result2);
		 */
		 scanner.close();
	}

}
