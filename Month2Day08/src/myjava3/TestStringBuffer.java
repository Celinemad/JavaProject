package myjava3;
/*
 * 1. 제목: 문자열 값을 수정할 수 있는 StringBuffer 클래스를 사용하기
 * 	1) append() 메소드를 사용
 * 	2) insert() 메소드
 * 	3) delete() 메소드
 *  4) replace() 메소드
 */
public class TestStringBuffer {

	public static void main(String[] args) {
		
		// 2. StringBuffer 객체를 생성
		StringBuffer a = new StringBuffer("시작");
		
		System.out.println(a);
		
		// 3. append() 메소드를 실행해서 "시작" 문자열 뒤에 "중간" 문자열을 추가(연결)
		a.append("중간");
		
		System.out.println("append() 메소드를 실행한 후의 문자열 값은 " + a);
		
		// 4. insert() 메소드를 실행: 특정위치(인덱스)에 새로운 문자열을 삽입
		a.insert(0, "새로운문자열 ");
		
		System.out.println("insert() 메소드를 실행한 후의 문자열 값은 "+ a);
		
		// 5. delete() 메소드를 실행: 특정 위치에 있는 문자열 값을 제거(지움)
		a.delete(0, a.length());
		
		System.out.println("전체 문자열을 지운 후의 문자열 값은 " + a);
		
		// 6. length() 메소드를 실행: 문자열 값의 문자 갯수를 반환
		int str_length = a.length();
		System.out.println("문자열 값의 문자 갯수는 " + str_length);
		
		// 7. 다시 append() 메소드를 실행: 새로운_문자열을 참조 변수 a에 추가
		a.append("새로운_문자열");
		
		System.out.println(a);
		System.out.println(a.length());
		
		// 8. replace() 메소드를 실행: 현재 있는 특정 문자열을 다른 문자열로 변경(수정)
		a.replace(0, 3, "수정");
		
		System.out.println(a);
	}

}
