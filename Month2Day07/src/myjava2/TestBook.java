package myjava2;

import java.util.Scanner;

class Book extends Object {
	private String m_title;
	private String m_author;
	//1. 기본 생성자를 정의
	//2. 다른 클래스로부터 책 제목과 책 저자를 문자열로 입력 받는 생성자를 정의
	//3. setTitle(String 매개변수명) 메소드를 정의해서 책 제목을 수정하기
	//4. getTitle() 메소드를 정의해서 책 제목을 반환하기
	//5. setAuthor(String 매개변수명) 메소드를 정의해서 책 저자를 수정하기
	//6. getAuthor() 메소드를 정의해서 책 저자를 반환하기
	//7. show(): 책 제목과 책 저자를 출력
	//8. toString(): 책 제목과 책 저자를 하나로 합친 다음에 문자열로 반환하기
	//9. equals(): 책 제목과 책 저자가 모두 같은 경우에만 true를 반환하기
	public Book() {
		m_title =  "제목 없음";
		m_author = "작자미상";
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
		System.out.println("책 제목은 "+getTitle()+ ", 저자는 "+ getAuthor());
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
		//1. equals() 메소드를 호출한 객체가 갖고 있는 책 제목과 책 저자 값을 가져오기
		String title = getTitle();
		String author = getAuthor();
		//2. 다른 클래스로부터 전달 받은 객체가 갖고 있는 책 제목과 책 저자 값을 가져오기
		//1) 매개변수인 obj의 데이터타입을 Object에서 Book으로 변환
		Book newRef = (Book)obj;
		//2) newRef 참조변수를 사용해서 getTitle() 메소드를 호출
		String title2 = newRef.getTitle();
		//3) newRef 참조 변수를 사용해서 getAuthor() 메소드를 호출
		String author2 = newRef.getAuthor();
		//4) title 변수가 갖고 있는 문자열과 title2 변수가 갖고 있는 문자열이 같은지를 비교
		boolean check = title.equals(title2);
		boolean check2 = author.equals(author2);
		//6) 책 제목과 책 저자가 모두 같은 경우에만 true를 반환
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
		
		Book a = new Book("java", "황기태");
		Book b = new Book("java", "황기태");
		boolean result = a.equals(b);
		if(result == true) System.out.println("책 제목과 책 저자가 동일");
		else System.out.println("책 제목 또는 책 저자 중에서 다른 것이 존재");
		
		Book c = new Book("java", "황기태");
		Book d = new Book("programming", "김효수");
		boolean result2 = c.equals(d);
		if(result == true) System.out.println("책 제목과 책 저자가 동일");
		else System.out.println("책 제목 또는 책 저자 중에서 다른 것이 존재");
		
		
	}

}
