/*
 * 1. ����: ��ü �迭�� �����ϰ� ����ϴ� ����
 */
// ����ڷκ��� �迭�� ũ�⸦ �Է� ���� �� ����� Scanner Ŭ������ import
import java.util.Scanner;

// ���ο� ObjectArray Ŭ������ ����
class ObjectArray{
	
	// �ǹ������� ������ �տ� ���λ� m_�� ���� ���: member�� m
	private int m_a;
	
	// �⺻ ������
	public ObjectArray() {
		m_a = 10; // �⺻���� 0�̱� ������ 0�� �ƴ� �� �ָ� ��
	}
	
	// �ٸ� Ŭ�����κ��� �ϳ��� ������ �޴� ������
	public ObjectArray(int a) {
		m_a = a;
	}
	
	// show() �޼ҵ�
	public void show() {
		System.out.println("��� ������ m_a�� ���� "+m_a);
	}
}

public class TestObjectArray {

	public static void main(String[] args) {
		// 1. ObjectArray Ŭ������ �ִ� 3���� ��ü�� ������ �� �ִ� �迭�� ����
		ObjectArray[] a = new ObjectArray[3];
		
		// 2. for �ݺ����� ����ؼ� ���� ��ü�� 3�� ����
		for(int i=0; i<a.length; i++) {
			a[i] = new ObjectArray(i);
		}
		
		// 3. ���ο� for �ݺ����� ����ؼ� show() �޼ҵ带 ȣ��
		for(int i=0; i<a.length; i++) {
			a[i].show();
		}
		
		// 2. Scanner Ŭ������ ����ϱ� ���� ��ü�� ����
		Scanner scanner = new Scanner(System.in);
		
		// 5. ����ڷκ��� �迭�� ũ�⸦ ������ �Է� �ޱ�
		System.out.print("�迭�� ũ�⸦ ������ �Է��ϼ���(0���� ū ����): ");
		
		// 6. nextInt() �޼ҵ带 ����
		int size = scanner.nextInt();
		
		// 7. if ���ǹ��� ����ؼ� ����ڰ� �Է��� ������ 0���� ū���� �˻�
		if(size>0) {
			System.out.println("�迭�� ũ�Ⱑ 0���� ũ�Ƿ� �迭�� �����մϴ�!");
			ObjectArray[] b = new ObjectArray[size];
			for(int i=0; i<b.length; i++) {
				b[i] = new ObjectArray(i);
				b[i].show();
			}
		} else {
			System.out.println("�迭�� ũ�Ⱑ 0 �����̹Ƿ� �迭�� ���� �� �����ϴ�!");
		}
		
		scanner.close();
	}

}
