package myjava3;
/*
 * 1. ����: ���ڿ� ���� ������ �� �ִ� StringBuffer Ŭ������ ����ϱ�
 * 	1) append() �޼ҵ带 ���
 * 	2) insert() �޼ҵ�
 * 	3) delete() �޼ҵ�
 *  4) replace() �޼ҵ�
 */
public class TestStringBuffer {

	public static void main(String[] args) {
		
		// 2. StringBuffer ��ü�� ����
		StringBuffer a = new StringBuffer("����");
		
		System.out.println(a);
		
		// 3. append() �޼ҵ带 �����ؼ� "����" ���ڿ� �ڿ� "�߰�" ���ڿ��� �߰�(����)
		a.append("�߰�");
		
		System.out.println("append() �޼ҵ带 ������ ���� ���ڿ� ���� " + a);
		
		// 4. insert() �޼ҵ带 ����: Ư����ġ(�ε���)�� ���ο� ���ڿ��� ����
		a.insert(0, "���ο�ڿ� ");
		
		System.out.println("insert() �޼ҵ带 ������ ���� ���ڿ� ���� "+ a);
		
		// 5. delete() �޼ҵ带 ����: Ư�� ��ġ�� �ִ� ���ڿ� ���� ����(����)
		a.delete(0, a.length());
		
		System.out.println("��ü ���ڿ��� ���� ���� ���ڿ� ���� " + a);
		
		// 6. length() �޼ҵ带 ����: ���ڿ� ���� ���� ������ ��ȯ
		int str_length = a.length();
		System.out.println("���ڿ� ���� ���� ������ " + str_length);
		
		// 7. �ٽ� append() �޼ҵ带 ����: ���ο�_���ڿ��� ���� ���� a�� �߰�
		a.append("���ο�_���ڿ�");
		
		System.out.println(a);
		System.out.println(a.length());
		
		// 8. replace() �޼ҵ带 ����: ���� �ִ� Ư�� ���ڿ��� �ٸ� ���ڿ��� ����(����)
		a.replace(0, 3, "����");
		
		System.out.println(a);
	}

}
