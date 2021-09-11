package myjava2;
/*
 * 1. ����: ������ ����ؼ� ��� �̸��� �Ųٷ� �����ϱ�
 */
import java.util.*;

public class TestStack {
	public static void main(String[] args) {
		// 2. scanner ��ü�� ����
		Scanner scanner = new Scanner(System.in);
		
		// 3. Stack ��ü�� ����
		Stack<String> nameStack = new Stack<String>();
		
		//4. ���� �ݺ����� �ۼ�: ����ڷκ��� ��� �̸��� �Է� �ޱ�(����ڰ� quit�� �Է��ϸ� ����)
		while(true) {
			// 5. ��� �̸��� ���ڿ��� �Է� �ޱ�
			System.out.print("��� �̸��� �Է��ϼ���: ");
			String inputName = scanner.nextLine();
			while(inputName.isEmpty()) {
				System.out.print("��! ��� �̸��� �Է��ϼ���: ");
				inputName = scanner.nextLine();
			}
			System.out.println("����ڰ� �Է��� �̸��� " + inputName);
			// 6. push() �޼ҵ带 ����ؼ� ���ÿ�  ��� �̸��� �����ϱ�
			nameStack.push(inputName);
			System.out.println("���ÿ� ��� �̸��� �����߽��ϴ�...");
			// 7. ��� ���θ� ����ڿ��� �����
			System.out.print("�ߴ��Ϸ��� quit�� �Է��ϼ���: ");
			String inputQuit = scanner.nextLine();
			while(inputQuit.isEmpty()) {
				System.out.print("��! quit�� �Է��ϼ���: ");
				inputQuit = scanner.nextLine();
			}
			if(inputQuit.equals("quit")) {
				System.out.println("�����մϴ�...");
				break;
			}
			System.out.println("size() �Լ��� ������ ����� " + nameStack.size());
		}
		System.out.println("�ݺ����� �����߽��ϴ�...");
		
		/*
		 * ���� ��ü�� ���� �ִ� ��� �̸����� ���������� pop() �޼ҵ带 ����
		 * 1) ����: String ������ = ���ð�ü��.pop();
		 * 2) pop() �޼ҵ带 �����ϱ� ���� isEmpty() �޼ҵ带 �����ؼ� ���ÿ��� ������ ��� �̸��� �ִ����� ���� �Ǵ��ϱ�
		 *    -> �������� ���α׷��� �����ϱ� ����
		 *    -> ����) boolean ������ = ���ð�ü��.isEmpty();
		 *            if(������ == true) // ���ÿ��� ������ �̸��� ���� ���
		 *            else // ���ÿ��� ������ �̸��� �ִ� ��� -> pop() �޼ҵ带 ȣ��
		 */
		while(nameStack.isEmpty()==false) {
			String value = nameStack.pop();
			System.out.println("���ÿ��� ������ ��� �̸��� " + value);
		}
	}

}
