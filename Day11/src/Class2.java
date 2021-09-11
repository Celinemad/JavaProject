/*
 * 1. ����: 10���� x�� 2������ ��ȯ�ϱ�
 * 	1) �ڹٿ��� �������ִ� Integer.toBinaryString() �Լ��� ���
 * 	2) �迭�� �ݺ����� ����ؼ� ���ο� ��ɾ� ������ �����
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {

		//1. ���� ������ try �� �ܺο� �̾Ƴ��� ��
		Scanner scanner = new Scanner(System.in);
		//2. try~catch~finally ���� �ۼ��ؼ� ���ܿ� ����ϱ�
		try {
			//3. ����ڷκ��� 10������ ������ �Է� �ޱ�
			System.out.print("10������ ������ �Է��ϼ���: ");
			int a = scanner.nextInt();
			//4. Integer.toBinaryString() �Լ��� �����ؼ� 10������ 2������ ��ȯ�ϱ�
			String b = Integer.toBinaryString(a);
			System.out.println("����ڰ� �Է��� 10������ "+a+", ��ȯ�� 2������ "+b);
		} catch(Exception e1) {
			System.out.println("���ܰ� �߻�");
			e1.printStackTrace();
		} finally {
			System.out.println("���ܿ� ������� ������ �������� ����");
		}
		
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
		
	}

}
