//1. ����: ����ڰ� ���� �޴��� ���� ����
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		/*
		 * 1. ��ĳ�� ������ ����
		 * 2. ����ڿ��� ���� �޴��� �����ֱ�
		 * 3. ����ڰ� ���� �޴��� ����: �޴� ��ȣ(1~3) �߿��� �ϳ��� �Է�
		 * 4. ���α׷����� ���� if���� ����ؼ� ����ڰ� �� �޴� ��ȣ�� ���� �޴����� ���
		 * 5. ���α׷� ����: ��ĳ�� ������ ���� �ִ� close() ���� �Լ��� ���
		 */
		
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("1.������ 2.�ָԹ� 3.Ƣ��");
		System.out.print("���ϴ� �޴��� ��ȣ(1~3)�� ������ �Է��ϼ���: ");
		int a = scanner.nextInt();
		if(a==1) {
			System.out.println("������");
		}
		else if(a == 2) {
			System.out.println("�ָԹ�");
		}
		else if(a == 3){
			System.out.println("Ƣ��");
		}
		else {
			System.out.println("�޴��� ���� ������ �Է�");
		}
		*/
		
		/*
		System.out.println("1.��� 2.�߽� 3.�ѽ� 4.�н�");
		System.out.print("���ϴ� �޴��� ��ȣ(1~3)�� ������ �Է��ϼ���: ");
		int a = scanner.nextInt();
		if(a==1) {
			System.out.println("��Ŀ� ���õ� �޴������ ���");
			System.out.println("1.�Ľ�Ÿ 2.���� 3.������");
			System.out.print("�ٽ� �޴� ��ȣ�� ������ �Է��ϼ���: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("�Ľ�Ÿ");
			}
			else if(b==2) {
				System.out.println("����");
			}
			else {
				System.out.println("������");
			}
		}
		else if(a == 2) {
			System.out.println("�߽Ŀ� ���õ� �޴������ ���");
			System.out.println("1.¥��� 2.��ٷο� 3.���Ｑ");
			System.out.print("�ٽ� �޴� ��ȣ�� ������ �Է��ϼ���: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("¥���");
			}
			else if(b==2) {
				System.out.println("��ٷο�");
			}
			else {
				System.out.println("���Ｑ");
			}
			
		}
		else if(a == 3){
			System.out.println("�ѽĿ� ���õ� �޴������ ���");
			System.out.println("1.������ 2.��ä 3.������");
			System.out.print("�ٽ� �޴� ��ȣ�� ������ �Է��ϼ���: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("������");
			}
			else if(b==2) {
				System.out.println("��ä");
			}
			else {
				System.out.println("������");
			}
		}
		else if(a == 4) {
			System.out.println("�нĿ� ���õ� �޴������ ���");
			System.out.println("1.������ 2.�Ź� 3.Ƣ��");
			System.out.print("�ٽ� �޴� ��ȣ�� ������ �Է��ϼ���: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("������");
			}
			else if(b==2) {
				System.out.println("�Ź�");
			}
			else {
				System.out.println("Ƣ��");
			}
			
		}
		else {
			System.out.println("�޴��� ���� ������ �Է�");
		}
		*/
		
		/*
		 * switch~case ���� ����ؼ� ���� if ���� ����ȭ�ϱ�
		 */
		//1) ����ڿ��� ���� �޴��� �����ֱ�
		System.out.println("1.������ 2.�Ź� 3.Ƣ��");
		System.out.print("�޴� ��ȣ(1~3)�� ������ �Է��ϼ���: ");
		int a = scanner.nextInt();
		switch(a) {
		case 1:
			System.out.println("������");
		    break;
		    
		case 2:
			System.out.println("�Ź�");
			break;
			
		case 3:
			System.out.println("Ƣ��");
			break;
		
		default:
			System.out.println("�޴��� ���� ��ȣ�� �Է�");
		
		}
		scanner.close();
		System.out.println("���α׷��� ����");
		
		
	}

}
