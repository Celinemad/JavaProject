/*
 * 1. while �ݺ����� ����ؼ� ���� �ݺ��� ������ �ۼ��ϰ� ����ؼ� �ȳ��ϼ���? �޽����� ���
 */

import java.util.Scanner;

public class Class1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���α׷��� �����մϴ�.");
		
		while(true) {
			System.out.println("�ȳ��ϼ���?");
			System.out.print("yes �Ǵ� no �߿��� �ϳ��� �Է��ϼ���: ");
			String line = scanner.nextLine();
			if(line.equals("")|| line.isEmpty()) {
				System.out.println("�ϳ��� �Է����� �����̽��ϴ�!");
				System.out.println("��! yes �Ǵ� no �߿��� �ϳ��� �Է��ϼ���!");
				continue;
			}
			else {
				System.out.println("����ڰ� �Է��� ���ڿ��� "+line);
				if(line.equals("yes")) {
					System.out.println("����ڰ� yes�� �Է�!");
					System.out.println("�ٽ� �ȳ��ϼ���? �޽����� ���");
					continue;
				}
				else if(line.equals("no")) {
					System.out.println("����ڰ� no�� �Է�!");
					System.out.println("�޽��� ����� �ߴ�!");
					break;
				}
				else {
					//����ڰ� yes�� �ƴϰ� no�� �ƴ� ���ڿ��� �Է��� ����� ó��
					/*
					 * 1. ���� �޽����� ȭ�鿡 ����ϰ� �ݺ����� ����
					 * 2. ���ο� while �ݺ����� �ۼ��ؼ� �ٽ� �� ���ο� yes �Ǵ� no ���ڿ��� �Է� ��û�ϱ�
					 */
//					System.out.println("������ �߻��߽��ϴ�!");
//					System.out.println("�ý����� �����մϴ�.");
//					break;
					
					System.out.println("yes �Ǵ� no �߿��� �Է����ּ���. �ٽ� �����մϴ�.");
					continue;
				}
			}
		}
		
		
		/*
		 * while �ݺ����� ����ؼ� 5���� �ȳ��ϼ���? �޽����� ���
		 */
		int cnt = 1;
		while(cnt<=5) {
			System.out.println("�ȳ��ϼ���?");
			cnt++;
		}
		
		/*
		 * 1. while(false)
		 * 2. for(;false;)
		 * 3. do~while(false)
		 */
//		while(false) {
//			System.out.println("�ȳ��ϼ���?");
//		}
		
//		for(;false;) {
//			System.out.println("�ȳ��ϼ���?");
//		}
		
		do {
			System.out.println("�ȳ��ϼ���?");
		} while(false);
		
		/*
		 * do~while �ݺ����� ����ؼ� ������ ���� ����ڷκ��� yes �Ǵ� no ���ڿ��� �Է� �ޱ�
		 */
		String yesno = "yes";
		do {
			System.out.print("yes �Ǵ� no �߿��� �Է��ϼ���: ");
			yesno = scanner.nextLine();
			if (yesno.isEmpty()) {
				continue;
			}
			else if(yesno.equals("yes")) {
				continue;
			}
			else if(yesno.equals("no")) {
				break;
			}
			else {
				System.out.println("�Է¿���!");
				break;
			}
		} while(true);
		
		
		
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
		
	}

}
