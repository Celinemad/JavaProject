package myjava1;
import java.util.Scanner; 

/*
 * 1. 방금 전에 작성한 도형 그리기 예제를 추상 클래스와 추상 메소드를 사용해서 구현(메소드의 선언과 구현내용을 분리)
 * 		-> 다른 클래스를 작성할 때 도움을 주는 도우미 클래스를 정의
 */
// 2. Shape 클래스를 도우미 클래스로 정의
abstract class Shape{
	// 3. draw() 메소드를 추상 메소드로 선언
	public abstract void draw();
}
//4. Line 클래스를 정의 + Shape 클래스를 상속 + draw() 추상 메소드를 재정의
class Line extends Shape {
	public void draw() {
		System.out.println("선을 화면에 그려줍니다.");
	}
}
// 5. Rect 클래스를 정의 + Shape 클래스를 상속 + draw() 추상 케소드를 재정의
class Rect extends Shape {
	public void draw() {
		System.out.println("사각형을 화면에 그려줍니다.");
	}
}
// 6. Circle 클래스를 정의 + Shape 클래스를 상속 + draw() 추상 메소드를 재정의
class Circle extends Shape {
	 public void draw() {
		 System.out.println("원을 화면에 그려줍니다.");
	 }
}

public class TestAbstractClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. 선 그리기 2. 사각형 그리기 3. 원 그리기 4. 기타");
		
		int menu = scanner.nextInt();
		
		if(menu == 1) {
			Line line = new Line();
			line.draw();
		}
		else if(menu == 2) {
			Rect rect = new Rect();
			rect.draw();
		}
		else if(menu == 3) {
			Circle circle = new Circle();
			circle.draw();
		}
		else {
			System.out.println("메뉴에 없는 번호를 입력해서 도형을 그릴 수 없습니다.");
		}
		
	}

}
