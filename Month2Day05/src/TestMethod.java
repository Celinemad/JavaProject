/*
 * 1. 제목: 새로운 메서드를 정의할 때 매개변수의 데이터타입으로 추상 클래스와 인터페이스를 사용 가능
 */

// 2. 추상 클래스를 정의
abstract class AbsClass1 {
	// 3. 추상 메서드를 선언
	public abstract void absMethod1();
}

// 4. 인터페이스를 정의
interface Int1 {
	// 5. 추상 메서드를 선언
	public abstract void absMethod2();
}

// 6. 일반 클래스를 정의
class GeneralClass1 {
	// 7. 새로운 method1()을 정의 + 매개변수의 타입으로 추상 클래스를 사용
	public void method1(AbsClass1 a) {
		System.out.println("method1(AbsClass1) 메서드가 호출");
	}
	
	// 8. 새로운 method2()를 정의 + 매개변수의 타입으로 인터페이스를 사용
	public void method2(Int1 a) {
		System.out.println("method2(Int1) 메서드가 호출");
	}
}

// 9. 위에서 정의한 추상 클래스와 인터페이스를 모두 상속 받는 자식 클래스를 정의: 클래스 이름은 ConcreteClass1
class ConcreteClass1 extends AbsClass1 implements Int1 {

	@Override
	public void absMethod2() {
		System.out.println("재정의한 absMethod2() 메소드가 호출됨");
	}

	@Override
	public void absMethod1() {
		System.out.println("재정의한 absMethod1() 메소드가 호출됨");
	}
	
}


public class TestMethod {

	public static void main(String[] args) {
		ConcreteClass1 a = new ConcreteClass1();
		a.absMethod1();
		a.absMethod2();
		
		GeneralClass1 b = new GeneralClass1();
		b.method1(new ConcreteClass1());
		b.method2(new ConcreteClass1());
	}

}
