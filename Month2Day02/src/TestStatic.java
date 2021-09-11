/*
 * 1. ����: static ������(������)�� ����ؼ� ��� ������ �޼ҵ带 �ϳ��� ����
 */
public class TestStatic {

	// 1) static ��� ������ ����
	private static int m_sa;
	// 2) static �޼ҵ带 ����
	public static void smethod() {
		System.out.println("smethod() �޼ҵ尡 �����");
		m_sa = 10;
	}
	// 3) ���ο� static �޼ҵ带 �����ؼ� m_sa ��� ������ ���� ����
	public static void smethod2(int a) {
		System.out.println("smethod2(int) �޼ҵ尡 �����");
		m_sa = a;
	}
	// 4) ���ο� static �޼ҵ带 �����ؼ� m_sa ��� ������ ���� ���
	public static void show() {
		System.out.println("show() �޼ҵ尡 �����");
		System.out.println("��� ������ m_sa�� ���� "+m_sa);
	}
	// ��� ������ static�̸� �޼ҵ嵵 ��� static�� �Ϲ���
	
	public static void main(String[] args) {
		// static �޼ҵ带 ȣ���ϴ� ����: Ŭ������ + ��(.) + �޼ҵ��();
		TestStatic.smethod();
		// show() �޼ҵ带 ȣ��
		TestStatic.show();
		// smethod2(int)�޼ҵ带 ȣ��
		TestStatic.smethod2(20);
		// show() �޼ҵ带 ȣ��
		TestStatic.show();
	}

}
