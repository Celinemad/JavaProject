/*
 * 1. 제목: 객체의 치환 예제
 */
// Circle 클래스 정의: 도형 중에서 원을 추상화(단순화)
class Circle {
	// 1. 멤버 변수 선언: 원의 반지름을 보관할 변수 radius를 선언(정수)
	private int radius;
	
	// 2. 기본 생성자를 먼저 정의: 다른 클래스로부터 값을 받지 않는 생성자
	public Circle() {
		System.out.println("기본 생성자가 실행");
		radius = 3; // 3은 개발자가 정한 임의의 값
	}
	
	// 3. 매개 변수를 갖는 생성자를 정의: 다른 클래스로부터 값을 하나만 받는 생성자 -> 원의 반지름 값을 받음
	public Circle(int radius) {
		System.out.println("다른 클래스로부터 원의 반지름을 받는 생성자");
		this.radius = radius;
	}
	
	// 4. 원의 넓이를 구하는 메소드를 정의: 원의 넓이를 구하는 공식은 3.14*반지름*반지름
	public double getArea() {
		System.out.println("원의 넓이를 구합니다.");
		double result = 3.14*radius*radius;
		return result;
	}
	
	// 5. 원의 반지름과 원의 넓이를 화면에 보여주는 show() 메소드를 정의
	public void show() {
		System.out.println("원의 반지름은 "+radius+", 원의 넓이는 "+getArea());
	}
}
public class TestCircle {

	public static void main(String[] args) {
		// 1. 2개의 객체를 생성하기
		Circle ob1 = new Circle(2);
		Circle ob2 = new Circle(3);
		
		// 2. show() 메소드를 호출
		ob1.show();
		ob2.show();
		
		// 첫 번재 객체의 주소를 보관할 back_ob1 참조 변수를 선언 + 첫 번째 객체의 주소를 대입
		Circle back_ob1 = ob1;
		back_ob1.show();
		
		// 3. 객체를 치환
		ob1 = ob2; // ob1이 원래 가리키던 객체는 "가비지"가 됨: 더 이상 참조할 수 없는 (미아)객체
		ob1.show();
		ob2.show();
		back_ob1.show();
	}

}
