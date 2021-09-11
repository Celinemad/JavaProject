package myjava2;
/*
 * 1. ����: LinkedList Ŭ������ ����ؼ� �л��� �̸����� �����ϱ�
 */
import java.util.*;
public class TestLinkedList {

	public static void main(String[] args) {
		// 2. Scanner ��ü�� ����
		Scanner scanner = new Scanner(System.in);
		
		// 3. LinkedList ��ü�� ����(���ڿ� ����)
		LinkedList<String> nameLinkedList = new LinkedList<String>();
		
		// 4. while �ݺ����� ����ؼ� �ݺ������� �л��� �̸����� ����ڷκ��� �Է� �ޱ�
		while(true) {
			//5. �л��� �̸��� �Է¹ޱ�
			System.out.print("�л��� �̸��� �Է��ϼ���: ");
			String inputName = scanner.nextLine();
			while(inputName.isEmpty()) {
				System.out.print("��! �л��� �̸��� �Է��ϼ���: ");
				inputName = scanner.nextLine();
			}
			
			System.out.println("����ڰ� �Է��� �л� �̸��� " + inputName);
			
			nameLinkedList.add(inputName);
			
			// 6. ����ڿ��� ����ؼ� �л� �̸��� �Է����� ���θ� �����
			System.out.print("�Է��� �ߴ��Ͻ÷��� no�� �Է�: ");
			String yes_no  = scanner.nextLine();
			while(yes_no.isEmpty()) {
				System.out.println("��! no�� �Է��ϼ���: ");
				yes_no = scanner.nextLine();
			}
			if(yes_no.equals("no")) {
				System.out.println("�л� �̸� �Է��� �ߴ��մϴ�...");
				break;
			}
			else if(yes_no.equals("yes")) {
				System.out.println("�ٽ� ���ο� �л��� �̸��� �Է� �޽��ϴ�...");
				continue;
			}
		}
		
		
	}

}
