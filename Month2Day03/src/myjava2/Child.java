package myjava2;

import myjava1.Parent;
// 1. �ڽ� Ŭ������ ����
// 2. Parent Ŭ�������� ������ protected int m_a�� �ٷ� ����ϱ�
public class Child extends Parent {
	// 3. int m_a�� �ٷ� ����ϴ� useMa()
	public void useMa() {
		System.out.println("useMa() �޼ҵ尡 ȣ���");
		m_a = 100;
		System.out.println("��� ���� m_a�� ���� "+m_a);
	}
}
