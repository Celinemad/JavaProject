/*
 * 1. ����: ���� ���� ���α׷��� ����� ����ؼ� ���ο� ȸ���� ���̵�� ��й�ȣ�� �Է� �ޱ�
 * 
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***ȸ�� ���� �Է� ����");
		
		String id = "Celine";
		String pwd = "celineinparis";
				
		System.out.print("���̵� �Է��ϼ���: ");
		id = scanner.nextLine();
		
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		pwd = scanner.nextLine();
		
		System.out.println("���̵�� "+ id + ", ��й�ȣ�� "+pwd);
		scanner.close();
		System.out.println("���α׷��� �����մϴ�");
	}

}
