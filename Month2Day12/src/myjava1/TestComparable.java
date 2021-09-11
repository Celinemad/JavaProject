package myjava1;
/*
 * 1. 제목: 개발자가 새로 정의한 클래스를 사용해서 정렬 기능을 수행하기
 */
import java.util.*;

// 2. 학생 정보를 관리해주는 학생 클래스를 정의 + java.lang.Comparable 인터페이스를 구현하기
class Student implements java.lang.Comparable<Student>{
	
	// 3. 학생 번호를 보관할 수 있는 멤버 변수를 선언
	int m_no;
	// 4. 학생 이름을 보관할 수 있는 멤버 변수를 선언
	String m_name;
	
	// 5. 생성자를 정의
	public Student(int no, String name) {
		m_no = no;
		m_name = name;
	}
	
	// 재정의할 때는 커서를 괄호 안에 넣고 Ctrl + spacebar
	@Override
	public int compareTo(Student o) {
		/// 6. 학생 번호를 기준으로 오름차순 정렬하기
//		if(m_no > o.m_no) {
//			return 1;
//		} else if(m_no < o.m_no) {
//			return -1;
//		} else {
//			return 0;
//		}
		
//		int c = m_no - o.m_no; // 오름차순
//		return c;

		
		// 기준: 학생 이름(오름차순/내림차순)
		// 	-> 문자열 -> "문자열1" == "문자열2"(주소를 비교: 우리는 값을 비교해야 함)
		// 1) equals() 메소드: 기능은 문자열 내의 모든 글자가 다 같아야 true, 아니면 false(경우의 수가 2가지가 아니므로 X)
		// 2) String 클래스가 갖고 있는 compareTo() 메소드를 사용 -> 반환형이 int
//		if(m_name.compareTo(o.m_name) > 0) {
//			return 1;
//		} else if(m_name.compareTo(o.m_name) < 0) {
//			return -1;
//		} else {
//			return 0;
//		}
		
		// compareTo() 메소드도 반환형이 int이므로 return m_name.compareTo(o.m_name); 으로 작성 가능
		int c = m_name.compareTo(o.m_name);
		return c;
	}
	
	@Override
	public String toString() {
		return "학생번호는 " + m_no + ", 학생 이름은 " + m_name;
	}
}


/*
 * 1. 새로운 정렬 규칙을 정하기: java.util.Comparator 인터페이스를 구현
 * 	  -> compare() 메소드를 재정의
 * 
 * 1) 위에서 Comparable 인터페이스의 compareTo() 메소드의 명령어는 제외
 *    -> 학생 이름으로 오름차순 정렬
 *    
 * 2) 학생 이름으로 내림차순 정렬 기능을 구현할 클래스 정의: StudentComparator2
 * 3) 학생 번호로 오름차순 정렬 기능을 구현할 클래스 정의: StudentComparator3
 * 4) 학생 번호로 내림차순 정렬 기능을 구현할 클래스 정의: StudentComparator4
 */
class StudentComparator2 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// 학생 이름으로 내림차순 정렬 기능을 구현
		int c = o2.compareTo(o1);
		return c;
	}
}
class StudentComparator3 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// 학생 번호로 오름차순 정렬 기능을 구현
		if((o1.m_no - o2.m_no) > 0) {
			return 1;
		} else if((o1.m_no - o2.m_no) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
class StudentComparator4 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// 학생 번호로 내림차순 정렬 기능을 구현
		int c = o2.m_no-o1.m_no;
		return c;
	}
}

public class TestComparable {
	public static void main(String[] args) {
		// 6. 3개의 서로 다른 학생 객체를 생성: 번호와 이름 모두 다르게 지정해야 합니다.
		Student a = new Student(6, "홍길동");
		Student b = new Student(2, "다길동");
		Student c = new Student(10, "마길동");
		
		// 7. 위에서 생성한 3개의 객체를 다루기 편하게 하기 위해서 ArrayList 컬렉션 클래스에 저장하기
		ArrayList<Student> list = new ArrayList<Student>();
		
		// 8. add() 메소드를 실행해서 3개의 객체들을 ArrayList 클래스에 저장
		list.add(a);
		list.add(b);
		list.add(c);
		
		// 9. 정렬하기 전에 모든 학생 객체들이 갖고 있는 학생 번호와 이름들을 출력
		System.out.println(list);
		
		// 10. ArrayList 클래스에 있는 3개의 객체들을 정렬하기 위해서 Collections 클래스의 sort() 메소드를 실행
		Collections.sort(list); 
		// Collections에 있는 sort() 메소드가 java.lang.Comparable에 있는 compareTo()를 불러옴
		
		// 11. 정렬 결과를 화면에 출력
		System.out.println(list);
		
		// 12. 위에서 만든 StudentComparator2 클래스를 사용하기 위해서는 새로운 객체를 생성 (Comparable은 객체 생성X & sort() 메소드 실행)
		StudentComparator2 comp2 = new StudentComparator2();
		
		// 13. 위에서 만든 StudentComparator3 클래스를 사용하기 위해서는 새로운 객체를 생성
		StudentComparator3 comp3 = new StudentComparator3();
		
		// 14. 위에서 만든 StudentComparator4 클래스를 사용하기 위해서는 새로운 객체를 생성
		StudentComparator4 comp4 = new StudentComparator4();
		
		// 15. 학생 이름으로 내림차순 정렬 기능을 구현
		Collections.sort(list, comp2);
		System.out.println(list);
		
		// 16. comp3 객체 참조 변수를 사용
		Collections.sort(list, comp3);
		System.out.println(list);
		
		// 17. comp4 객체 참조 변수를 사용
		Collections.sort(list, comp4);
		System.out.println(list);
	}

}
