/*
 * 1. ����: do~while �ݺ����� ����ؼ� ����ڷκ��� ���� ������ �Է¹ޱ�
 * 1) ���α׷����� �Է� �ޱ⸦ ���ϴ� ���� ������ ����: 0~100
 * 	- ���� ����ڰ� 0 ���� �۰ų� 100���� ū ������ �Է��� ���
 * 		- ���� �޽����� ����ϰ� �Է��� �ߴ��ϱ�
 * 		  �Ǵ� �ٽ� ����ڿ��� �Է��� ��û�ϱ�
 */
import java.util.Scanner;
public class Class2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���α׷��� �����մϴ�.");
		
		// ����ڰ� �Է��� ���� ������ ������ ���� kor�� ���� + �ʱ�ȭ
		int kor = 0; // �Ϲ������� �ʱⰪ�� ���α׷����� ����� ���� ���� ������ ���Ͻø� �˴ϴ�.
		
		do {
			System.out.print("���� ������ ������ �Է��ϼ���: ");
			kor = scanner.nextInt();
		} while(kor<0 || kor>100);
		
		System.out.println("����ڰ� �Է��� ���� ������ "+kor);
		
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
	}

}
