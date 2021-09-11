/*
 * 1. 제목: 추상 클래스와 인터페이스를 함께 사용해서 다중 상속을 구현
 */

// 2. 추상 클래스를 정의(선언)
abstract class Parent2 {
	// 3. 추상 메서드를 선언
	public abstract void method1();
}

// 4. 인터페이스를 정의
interface MyInterface3 {
	// 5. 추상 메서드를 선언
	public abstract void method2();
}

// 6. 다중 상속을 받는 Child3 클래스를 정의
class Child3 extends Parent2 implements MyInterface3 {
	
	// Alt + Shift + S 단축 키 -> Override/Implement Methods... 선택
	
	@Override
	public void method2() {
		System.out.println("재정의한 method2() 메서드가 호출");
	}

	@Override
	public void method1() {
		System.out.println("재정의한 method1() 메서드가 호출");
	}
	
}

public class TestInterface2 {

	public static void main(String[] args) {
		Child3 a = new Child3();
		a.method1();
		a.method2();
	}

}
