/*
 * 1. 제목: 상속 관계에서 자식 클래스에서, 부모 클래스에서 정의한 메서드를 재정의
 */

class Parent {
	// parentMethod() 메서드를 정의
	public void parentMethod() {
		System.out.println("parentMethod() 메서드가 호출 in Parent");
	}
	
	// 새로운 메서드를 정의: 이름은 parentMethod2()
	public void parentMethod2() {
		System.out.println("parentMethod2() 메서드가 호출 in Parent");
	}
	// Child 클래스로 이동하신 후에 @Override 애너테이션 명령어를 사용해서
	// parentMethod2() 메서드를 재정의하기 ->main() 메서드에서
	// parentMethod2() 메서드를 호출하기 -> a.parentMethod2();
}

// Parent 클래스를 상속 받는 Child 자식 클래스를 정의
class Child extends Parent {
	//parentmethod() 새로운 메서드를 정의(재정의가 아님)
	@Override
	public void parentMethod() {
		System.out.println("parentMethod() 메서드가 호출 in Child");
	}
	@Override
	public void parentMethod2() {
		System.out.println("parentMethod2() 메서드가 호출 in Child");
	}
}

public class TestOverride {
	public static void main(String[] args) {
		Child a = new Child();
//		a.parentmethod();
		a.parentMethod();
		
		a.parentMethod2();
	}

}
