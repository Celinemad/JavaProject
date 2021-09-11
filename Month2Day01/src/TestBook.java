/*
 * 1. 제목: 책을 추상화시킨 클래스를 사용하기
 */

// 2. 새로운 책 클래스를 정의
class Book {
	String title;
	String author;
	public Book() {
		System.out.println("기본 생성자가 호출됨");
		title = "정의란 무엇인가";
		author = "마이클 센델";
	}
	public Book(String title) {
		// 위에서 정의한 기본 생성자를 호출: this()
		this();
		this.title = title;
		System.out.println("책 제목을 입력으로 받는 생성자가 호출됨");
	}
	public Book(String title, String author) {
		// 위에서 정의한 Book(String) 생성자를 호출: this("책제목");
		System.out.println("책 제목과 저자 모두를 입력으로 받는 생성자가 호출");
		this.title = title;
		this.author = author;
	}
	public void show() {
		System.out.println("책 제목은 "+title+", 저자는 "+author);
	}
}

public class TestBook {

	public static void main(String[] args) {
		
		// 1. Book 클래스를 사용해서 새로운 객체를 만들기
		Book a = new Book();
		Book b = new Book("책제목1");
		Book c = new Book("책제목2", "저자이름");
		// 2. show() 함수를 호출하기
		a.show();
		b.show();
		c.show();
		
	}

}
