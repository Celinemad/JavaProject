package myjava1;
/*
 * 1. ����: Vector �÷��� Ŭ������ ����ϱ�
 */
import java.util.*;
public class TestVector {

	public static void main(String[] args) {
		/*
		 * 2. ����ڿ��� �޴��� �����ֱ�
		 * 	1) ������ ���: ***Vector Ŭ���� ����***
		 * 	2) �Ʒ� �ٿ���: 1. ��ü �Է�(����)  2. ��ü �˻�(ã��)  3. ��ü ����  4. ��ü ���  5. ����
		 */
		Scanner scanner = new Scanner(System.in);
		// 3. ���� ��ü�� ����
		Vector<String> vector = new Vector<String> ();
		// 4. while �ݺ����� ����ؼ� ���� �ݺ����� �����
		while(true) {
			// 5. �޴��� ���
			System.out.println("1. ��ü �Է�(����)  2. ��ü �˻�(ã��)  3. ��ü ����  4. ��ü ���  5. ����");
			// 6. ����ڷκ��� �޴� ��ȣ�� �Է� �ޱ�
			int menu = Integer.parseInt(scanner.nextLine());
			// 7. ����ڰ� 5�� �Է��ϸ� ���α׷��� ����
			if (menu==5) {
				System.out.println("���α׷��� �����մϴ�...");
				break;
			}
			// 8. ����ڰ� 1�� �Է��ϸ� ���ο� ���ڿ� ��ü�� �����ؼ� �÷��ǿ� �߰�
			else if(menu == 1) {
				System.out.println("���ο� ���ڿ� ��ü�� �Է� �޽��ϴ�...");
				System.out.print("����� �̸��� �Է��ϼ���: ");
				String inputName = scanner.nextLine();
				while(inputName.isEmpty()) {
					// ����ڰ� �̸��� �Է����� �ʰ� ����Ű�� ���� ���
					System.out.println("�̸��� �Է����� �ʾҽ��ϴ�. ��! �Է��ϼ���: ");
					inputName = scanner.nextLine();
				}
				System.out.println("�ݺ����� ������ �ڿ��� ����ڰ� �Է��� �̸��� ���");
				System.out.println("����ڰ� �Է��� �̸��� "+ inputName);
				vector.add(inputName);
				System.out.println("����ڰ� �Է��� �̸��� ���Ϳ� �߰��߽��ϴ�.");
				System.out.println("������ ���� ũ��� "+ vector.size());
				System.out.println("������ ���� �迭 ũ��� "+ vector.capacity());
			}
			
			// 9. ����ڰ� 2�� �Է��ϸ� ��ü �˻��ϱ�
			else if(menu == 2) {
				System.out.println("�÷��ǿ� ����� ��ü�� ã���ϴ�...");
				// 10. ���� �÷��ǿ� ��ü�� �ִ����� Ȯ���ϱ�
				if(vector.isEmpty()) {
					System.out.println("���� �Էµ� ��ü�� �ϳ��� �����ϴ�...");
				} else {
					// 11. ã�� ��� �̸��� �Է� �ޱ�
					System.out.print("ã�� ��� �̸��� �Է��ϼ���: ");
					String findName = scanner.nextLine();
					while(findName.isEmpty()) {
						System.out.print("�ٽ� ã�� ��� �̸��� �Է��ϼ���: ");
						findName = scanner.nextLine();
					}
					System.out.println("ã�� ��� �̸��� " + findName);
					// 12. for �ݺ����� ����ؼ� �÷��ǿ��� ����ڰ� �Է��� �̸��� ã��
					for(int i=0; i < vector.size(); i++) {
						String value = vector.get(i);
						if(value.equals(findName)) {
							System.out.println("ã�ҽ��ϴ�!!");
						}
					}
					// 13. contains() �޼ҵ带 ����ؼ� �̸� �˻�
					boolean resultFind = vector.contains(findName);
					if(resultFind == true) {
						System.out.println("ã�ҽ��ϴ�!!");
					} else {
						System.out.println("ã�� ���߽��ϴ�!!");
					}
				} // if(vector.isEmpty())�� else ���� ��
			} // else if(menu==2) ���� ��
			// ����ڰ� �޴� ��ȣ 3�� �Է��� ���
			else if(menu == 3) {
				System.out.println("��ü�� ã�Ƽ� �����մϴ�...");
				if(vector.isEmpty()) {
					System.out.println("������ ��ü�� �ϳ��� �����ϴ�...");
				} else {
					System.out.println("������ ��ü�� �����մϴ�");
					System.out.print("������ ��� �̸��� �Է��ϼ���:");
					String delName = scanner.nextLine();
					while (delName.isEmpty()) {
						System.out.print("��! ������ ��� �̸��� �Է��ϼ���: ");
						delName = scanner.nextLine();
					}
					System.out.println("������ ��� �̸��� "+ delName);
					boolean resultDel = vector.remove(delName);
					if (resultDel == true) {
						System.out.println("���� ����!!");
					} else {
						System.out.println("���� ����!!");
					}
					System.out.println("���� �迭�� ����� ��ü�� ������ "+ vector.size());
				}
			}
			// ����ڰ� �޴� ��ȣ 4�� �Է��� ���
			else if(menu == 4) {
				System.out.println("�÷����� ���� �ִ� ��� ��ü���� ����մϴ�...");
				if(vector.isEmpty()) {
					System.out.println("�Էµ� ��ü�� �ϳ��� �����ϴ�...");
				}else {
					System.out.println("�Էµ� ��ü�� ������ "+ vector.size());
					for(int i=0; i<vector.size(); i++) {
						String value = vector.get(i);
						System.out.println("�ε��� ��ȣ�� "+ i + ", �̸��� "+ value);
					}
					Iterator<String> iterator = vector.iterator();
					while(iterator.hasNext() == true) {
						String value = iterator.next();
						System.out.println("�̸��� " + value);
					}
					System.out.println("���� ��ü�� ���� �迭�� �뷮�� "+ vector.capacity());
				}
			}
			
		}  // while(true) ���� ��
		// while �ݺ����� ������ �ڿ��� ��ĳ�� Ŭ������ �����ϱ�
		scanner.close();
		
	}

}
