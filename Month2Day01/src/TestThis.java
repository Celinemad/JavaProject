/*
 * 1. 제목: this 레퍼런스 예약어를 사용하기
 * 	1) 멤버변수명과 메소드에서 선언한 지역변수명이 같은 경우에 사용
 * 	2) 같은 클래스에 있는 다른 메소드로부터 객체의 주소를 입력받고 싶은 경우에 사용
 * 	3) 다른 클래스로 객체의 주소를 반환하고 싶은 경우에 사용
 */

// 새로운 This 클래스를 정의
class This {
	private int a;
	public This() {
		System.out.println("기본 생성자가 호출됨");
		a = 10; // 대입 명령어를 작성하지 않으면 기본 값은 0이 대입
	}
	public void method1() {
		System.out.println("일반 method1() 메소드가 호출됨");
		// method2() 메소드를 호출하면서 method2() 메소드의 This refa 매개변수에 객체의 주소를 전달
		method2(this);
	}
	// 새로 정의할 method2는 method1으로부터 객체의 주소를 받을 예정 -> 클래스명 변수명
	public void method2(This refa) {
		System.out.println("method2(This) 메소드가 호출됨");
		System.out.println("멤버변수인 a의 값은 "+refa.a);
	}
	// 새로 정의할 method3는 반환값으로 객체의 주소 -> 반환형을 클래스명으로 작성
	public This getThis() {
		System.out.println("객체의 주소를 반환하는 getThis() 메소드가 호출됨");
		return this;
	}
}

public class TestThis {

	public static void main(String[] args) {
		
		//1. This 클래스를 사용하기 위한 객체를 생성: 기본 생성자를 호출: new This();
		This a = new This();
//		System.out.println("");
		//2. This 클래스에서 정의한 method1() 메소드를 호출
		a.method1();
//		System.out.println("");
		//3. This 클래스에서 정의한 getThis() 메소드를 호출 
		// -> 장점: This 클래스에서 만든 모든 멤버변수와 멤버함수 이름들을 사용가능
		// -> private 접근 제한자를 갖는 멤버변수와 멤버함수들 제외
		This b = a.getThis();
//		System.out.println("");
		//4. 새로 만든 참조변수 b를 사용해서 This 클래스에 있는 method1() 메소드를 호출
		b.method1();
		
	}

}
