package myjava2;

public class Class2 {
	// 사람의 이름을 보관할 멤버 변수를 선언
	private String name;
	//	-> 위처럼 String 멤버변수를 선언하면 자동으로 null 값이 대입
	
	// 생성자를 새로 정의해서 멤버 변수인 name에 임의의 문자열 값을 대입
	public Class2() {
		System.out.println("Class2 클래스에서 새로 정의한 생성자 멤버 함수가 호출");
		name = "Celine";
		System.out.println("멤버 변수인 name의 값은 "+name);
	}
	// 생성자를 호출하기 윟서는 다른 클래스에서 클래스명 참조변수명 = new 클래스명();
	// -> MainClass 클래스로 이동 -> main() 메서드 안에서 아래 명령어를 입력하고 실행하세요 
	// -> myjava2.Class2 참조 변수명 = new myjava2.Class2();
	
	/*
	 * 두 번재 새로운 생성자를 정의: 목적은 다른 클래스로부터 하나의 문자열 값을 입력 받습니다. -> 입력 변수를 꼭 선언해야 합니다.
	 * 	-> (String 변수명)
	 * 	-> 전체 형식:
	 * public 클래스명(입력변수를 선언) {
	 * 		멤버변수명 = 입력변수명;
	 * }
	 */
	public Class2(String a) {
		// 입력 변수명은 멤버 변수명과 다르게 주세요!
		System.out.println("새롭게 정의한 두 번재 생성자가 호출");
		System.out.println("입력 값은 "+a);
		name = a;
		System.out.println("바뀐 멤버 변수 name의 값은 "+name);
	}
	
	
}
