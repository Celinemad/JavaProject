/*
 * 1. 제목: 원 도형을 추상화 시킨 Circle 클래스를 정의
 * 2. Circle 클래스의 내부 내용
 * 	1) 멤버변수: 반지름을 보관할 변수 선언: private double radius;
 * 	2) 기본 생성자: public 클래스명() { radius = 값; }
 * 	3) 다른 클래스로부터 하나의 실수값을 받는 생성자: public 클래스명(double radius) { radius = radius; }
 */
class Circle {
	private double radius;
	public Circle() {
		radius = 1.52;
	}
	public Circle(double radius) {
		// radius = radius;
		this.radius = radius;
	}
	public void show() {
		System.out.println("원 도형의 반지름은 "+radius);
	}
}

public class TestCircle {

	public static void main(String[] args) {
		
		// 1. Circle 클래스를 사용하기 위한 객체 생성
		Circle a = new Circle();
		// 2. show() 함수를 호출하기 -> 1.2가 출력
		a.show();
		// 3. 하나의 실수값을 받는 생성자를 호출
		Circle b = new Circle(3.2);
		b.show();
		
	}

}
