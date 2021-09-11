package myjava4;
/*
 * 1. 제목: Object 클래스에서 자식 클래스로 상속해준 getClass() 메소드를 사용해서 클래스의 이름을 읽어와서 출력
 */
//2. MyClass1 이름을 갖는 클래스의 정의
class MyClass1 extends Object{
	public MyClass1() {
		System.out.println("MyClass1() 기본 생성자가 호출됨");
	}
	public void show() {
		System.out.println("show() 메소드가 실행됨");
	}
}


public class TestClass {

	public static void main(String[] args) {
		
		// 1. MyClass1 클래스를 사용해서 객체를 생성
		MyClass1 a = new MyClass1();
		// 2. getClass() 멧소드를 호출해서 클래스의 정보를 반환
		Class b = a.getClass();
		// 3. Class 클래스가 갖고 있는 getName() 메소드를 호출해서 클래스의 이름을 출력
		String name = b.getName();
		System.out.println("클래스 이름은 "+name);
		
		// 4. getSimpleName() 메소드를 호출해서 패키지는 제외하고 클래스 이름만을 출력
		String name2 = b.getSimpleName();
		System.out.println("클래스 이름은 "+name2);
	}

}
