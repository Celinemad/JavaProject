/*
 * 1. ����: å�� �߻�ȭ��Ų Ŭ������ ����ϱ�
 */

// 2. ���ο� å Ŭ������ ����
class Book {
	String title;
	String author;
	public Book() {
		System.out.println("�⺻ �����ڰ� ȣ���");
		title = "���Ƕ� �����ΰ�";
		author = "����Ŭ ����";
	}
	public Book(String title) {
		// ������ ������ �⺻ �����ڸ� ȣ��: this()
		this();
		this.title = title;
		System.out.println("å ������ �Է����� �޴� �����ڰ� ȣ���");
	}
	public Book(String title, String author) {
		// ������ ������ Book(String) �����ڸ� ȣ��: this("å����");
		System.out.println("å ����� ���� ��θ� �Է����� �޴� �����ڰ� ȣ��");
		this.title = title;
		this.author = author;
	}
	public void show() {
		System.out.println("å ������ "+title+", ���ڴ� "+author);
	}
}

public class TestBook {

	public static void main(String[] args) {
		
		// 1. Book Ŭ������ ����ؼ� ���ο� ��ü�� �����
		Book a = new Book();
		Book b = new Book("å����1");
		Book c = new Book("å����2", "�����̸�");
		// 2. show() �Լ��� ȣ���ϱ�
		a.show();
		b.show();
		c.show();
		
	}

}
