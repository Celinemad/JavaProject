/*
 * 1. ����: ���� ������ ó���ϱ�
 */
import java.util.Scanner;

public class Class5 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("������ �Է��ϼ���: ");
//		int num = scanner.nextInt();
//		int result = num / 0;
//		System.out.println("�� �޽����� ���̳���?"); // �Ⱥ��̰� ���� ��
//		System.out.println("����ڰ� �Է��� ������ 0���� ���� ����� "+result);
//		scanner.close();
		
		try {
			int result  = 5 / 0;
			System.out.println("������� �ʽ��ϴ�!");
		} catch(Exception e) {
			System.out.println("�����ؾ� �մϴ�!");
		}
	}

}
