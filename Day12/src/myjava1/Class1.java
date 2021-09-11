package myjava1;

public class Class1 {
	// 회원의 아이디를 보관할 멤버 벼수 또는 필드 선언
	public String id = "Celine";
	// 회원의 비밀번호를 보관할 멤버 변수 또는 필드 선언
	private String pwd = "celineinparis";
	// MainClass.java소스 파일로 이동해서 Class1을 사용하는 명령어를 입력
	
	// 새로운 멤버 함수인 메서드를 정의: 클래스 외부에서 사용할 함수(인터페이스 함수)
	public void fnc1() {
//		System.out.println("안녕하세요?");
		System.out.println("비밀번호는 "+pwd);
		return;
	}
	
	// 새로운 멤버 함수인 fnc2를 정의: 다른 클래스로부터 값을 입력 받기 위해서 입력 변수를 선언
	public void fnc2 (String a) {
		System.out.println("다른 클래스에서 fnc2 함수를 호출");
		System.out.println("입력 값은 "+a);
		pwd = a;
		System.out.println("수정된 멤버 변수 pwd의 값은 "+pwd);
	}
	
}
