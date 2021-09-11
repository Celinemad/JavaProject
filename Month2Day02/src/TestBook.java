import java.util.Scanner;

class Book{
	private String m_title;
	private String m_author;
	
	public Book() {
		m_title = "";
		m_author = "";
	}
	public Book(String title) {
		this.m_title = title;
	}
	public Book(String title, String author) {
		this.m_title = title;
		this.m_author = author;
	}
	public void show() {
		System.out.println("å ������ "+m_title+", å ���ڴ� "+m_author);
	}
}

public class TestBook {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�迭�� ũ��(å�� ����)�� �Է��ϼ���: ");
		int size = Integer.parseInt(scanner.nextLine());
		
		if(size>0) {
			Book[] a = new Book[size];
			for(int i=0; i<a.length; i++) {
				String title;
				String author;
				System.out.print("å�� ������ �Է��ϼ���: ");
				title = scanner.nextLine();
				System.out.print("å�� ���ڸ� �Է��ϼ���: ");
				author = scanner.nextLine();
			
				a[i] = new Book(title, author);
				a[i].show();
			}
			for(int i=0; i<a.length; i++)
				a[i].show();
		} else {
			System.out.println("�迭�� ũ�Ⱑ 0 ���������� ������ �� �����ϴ�!");
		}
	}

}
