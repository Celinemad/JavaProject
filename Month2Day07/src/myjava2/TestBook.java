package myjava2;

import java.util.Scanner;

class Book extends Object {
	private String m_title;
	private String m_author;
	//1. �⺻ �����ڸ� ����
	//2. �ٸ� Ŭ�����κ��� å ����� å ���ڸ� ���ڿ��� �Է� �޴� �����ڸ� ����
	//3. setTitle(String �Ű�������) �޼ҵ带 �����ؼ� å ������ �����ϱ�
	//4. getTitle() �޼ҵ带 �����ؼ� å ������ ��ȯ�ϱ�
	//5. setAuthor(String �Ű�������) �޼ҵ带 �����ؼ� å ���ڸ� �����ϱ�
	//6. getAuthor() �޼ҵ带 �����ؼ� å ���ڸ� ��ȯ�ϱ�
	//7. show(): å ����� å ���ڸ� ���
	//8. toString(): å ����� å ���ڸ� �ϳ��� ��ģ ������ ���ڿ��� ��ȯ�ϱ�
	//9. equals(): å ����� å ���ڰ� ��� ���� ��쿡�� true�� ��ȯ�ϱ�
	public Book() {
		m_title =  "���� ����";
		m_author = "���ڹ̻�";
	}
	public Book(String title, String author) {
		m_title = title;
		m_author = author;
	}
	public void setTitle(String title) {
		m_title = title;
	}
	public String getTitle() {
		return m_title;
	}
	public void setAuthor(String author) {
		m_author = author;
	}
	public String getAuthor() {
		return m_author;
	}
	public void show() {
		System.out.println("å ������ "+getTitle()+ ", ���ڴ� "+ getAuthor());
	}
	@Override
	public String toString() {
		String result;
		result = getTitle()+ ", " + getAuthor();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result;
		//1. equals() �޼ҵ带 ȣ���� ��ü�� ���� �ִ� å ����� å ���� ���� ��������
		String title = getTitle();
		String author = getAuthor();
		//2. �ٸ� Ŭ�����κ��� ���� ���� ��ü�� ���� �ִ� å ����� å ���� ���� ��������
		//1) �Ű������� obj�� ������Ÿ���� Object���� Book���� ��ȯ
		Book newRef = (Book)obj;
		//2) newRef ���������� ����ؼ� getTitle() �޼ҵ带 ȣ��
		String title2 = newRef.getTitle();
		//3) newRef ���� ������ ����ؼ� getAuthor() �޼ҵ带 ȣ��
		String author2 = newRef.getAuthor();
		//4) title ������ ���� �ִ� ���ڿ��� title2 ������ ���� �ִ� ���ڿ��� �������� ��
		boolean check = title.equals(title2);
		boolean check2 = author.equals(author2);
		//6) å ����� å ���ڰ� ��� ���� ��쿡�� true�� ��ȯ
		if(check == true && check2 == true) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
public class TestBook {

	public static void main(String[] args) {
		
		Book a = new Book("java", "Ȳ����");
		Book b = new Book("java", "Ȳ����");
		boolean result = a.equals(b);
		if(result == true) System.out.println("å ����� å ���ڰ� ����");
		else System.out.println("å ���� �Ǵ� å ���� �߿��� �ٸ� ���� ����");
		
		Book c = new Book("java", "Ȳ����");
		Book d = new Book("programming", "��ȿ��");
		boolean result2 = c.equals(d);
		if(result == true) System.out.println("å ����� å ���ڰ� ����");
		else System.out.println("å ���� �Ǵ� å ���� �߿��� �ٸ� ���� ����");
		
		
	}

}
