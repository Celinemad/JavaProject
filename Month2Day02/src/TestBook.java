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
		System.out.println("책 제목은 "+m_title+", 책 저자는 "+m_author);
	}
}

public class TestBook {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("배열의 크기(책의 개수)를 입력하세요: ");
		int size = Integer.parseInt(scanner.nextLine());
		
		if(size>0) {
			Book[] a = new Book[size];
			for(int i=0; i<a.length; i++) {
				String title;
				String author;
				System.out.print("책의 제목을 입력하세요: ");
				title = scanner.nextLine();
				System.out.print("책의 저자를 입력하세요: ");
				author = scanner.nextLine();
			
				a[i] = new Book(title, author);
				a[i].show();
			}
			for(int i=0; i<a.length; i++)
				a[i].show();
		} else {
			System.out.println("배열의 크기가 0 이하임으로 생성할 수 없습니다!");
		}
	}

}
