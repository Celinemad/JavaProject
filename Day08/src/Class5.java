/*
 * 1. ����: ��ǻ�Ϳ� ��� ���� ����/����/�� ���� ����
 */
import java.util.Random;
import java.util.Scanner;
public class Class5 {

	public static void main(String[] args) {
		
		//2. Scanner ���� ����
		Scanner scanner = new Scanner(System.in);
		//3. Random ���� ����
		Random random = new Random();
		//4. ���� ����� ����/����/�� �߿��� �ϳ��� ���ϴ�.(����� �Է�)
		System.out.print("����/����/�� �߿��� �ϳ��� ���ڿ��� �Է��ϼ���: ");
		String human = scanner.nextLine();
		//5. ��ǻ�ʹ� ������ ����ؼ� ����/����/���� �Ӥ����Ƿ� �����
		int computer = random.nextInt(3)+1;
		String scomputer;
		if(computer==1) {
			scomputer = "����";
		}
		else if(computer==2) {
			scomputer = "����";
		}
		else if(computer==3){
			scomputer = "��";
		}
		else {
			scomputer = "��";
			//������ main() �Լ��� �����Ͻø� exit() �Լ��� ���
			//	-> ����: System.exit();
			//		-> ������ �ǹ�: �ü������ ��ȯ�ϴ� ��
			//			-> ���� ����ÿ��� 0�� ���. ���α׷����� ������ ������ ���ܻ�Ȳ���� ������ ��� �Ǵ� 1
			System.exit(-1);		
		}
		
		//����/����/���ºθ� �����ϱ�
		if(scomputer.equals(human)) {
			// ����ڿ� ��ǻ�� ���� ���� ���� �� ���
			System.out.println("���º�");
		}
		else {
			//����ڴ� ������ ���� ��ǻ�ʹ� ������ �� ���
			if(human.equals("����") && scomputer.equals("����")) {
				System.out.println("��ǻ�Ͱ� ����");
			}
			//����ڴ� ������ ���� ��ǻ�ʹ� ���� �� ���
			else if(human.equals("����") && scomputer.equals("��")) {
				System.out.println("����ڰ� ����");
			}
			//����ڴ� ������ ���� ��ǻ�ʹ� ���� �� ���
			else if(human.equals("����") && scomputer.equals("��")) {
				System.out.println("��ǻ�Ͱ� ����");
			}
			//����ڴ� ������ ���� ��ǻ�ʹ� ������ �� ���
			else if(human.equals("����") && scomputer.equals("����")) {
				System.out.println("����ڰ� ����");
			}
			//����ڴ� ���� ���� ��ǻ�ʹ� ������ �� ���
			else if(human.equals("��") && scomputer.equals("����")) {
				System.out.println("��ǻ�Ͱ� ����");
			}
			//����ڴ� ���� ���� ��ǻ�ʹ� �ָ��� �� ���
			else if(human.equals("��") && scomputer.equals("�ָ�")) {
				System.out.println("����ڰ� ����");
			}
		}
		scanner.close();
		System.out.println("����/����/�� ������ �����մϴ�...");
	}

}
