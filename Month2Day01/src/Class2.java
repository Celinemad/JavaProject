/*
 * 1. 제목: 생성자에 오버로딩 개념을 적용하기
 * 	1) 기본 생성자를 먼저 정의
 * 	2) 다른 클래스로부터 값을 받는 생성자들을 추가로 정의
 */

// 새로운 클래스를 정의: 이름은 MethodOverload
class MethodOverload{
	// 1. 생성자를 정의
	public MethodOverload() {
		System.out.println("기본 생성자가 호출됨");
	}
	// 2. 다른 클래스로부터 하나의 정수를 입력받는 생성자(오버로딩이 적용됨)
	public MethodOverload(int a) {
		System.out.println("하나의 정수를 입력 받는 생성자가 호출됨");
	}
	// 3. 다른 클래스로부터 2개의 정수를 입력받는 생성자(오버로딩)
	public MethodOverload(int a, int b) {
		System.out.println("2개의 정수를 입력 받는 생성자가 호출됨");
	}
	// 4. 다른 클래스로부터 하나의 문자열을 입력받는 생성자(오버로딩)
	public MethodOverload(String a) {
		System.out.println("하나의 문자열을 입력 받는 생성자가 호출됨");
	}
	// 5. 다른 클래스로부터 하나의 실수를 입력 받는 생성자(오버로딩)
	public MethodOverload(double a) {
		System.out.println("하나의 실수를 입력 받는 생성자가 호출됨");
	}
}

public class Class2 {

	public static void main(String[] args) {
		
		// 1. 위에서 정의한 MethodOverload 클래스를 사용하기
		// 	1) 생성자에 맞게 객체를 생성
		//		가. 개본 생성자를 호출하는 명령어
		MethodOverload a = new MethodOverload();
		//		나. 하나의 정수를 입력 받는 생성자를 호출
		MethodOverload b = new MethodOverload(10);
		//		다. 2개의 정수를 입력 받는 생성자를 호출
		MethodOverload c = new MethodOverload(10, 20);
		//		라. 하나의 실수를 입력 받는 생성자를 호출
		MethodOverload d = new MethodOverload(3.4);
		//		마. 하나의 문자열을 입력 받는 생성자를 호출
		MethodOverload e = new MethodOverload("문자열");
	}

}
