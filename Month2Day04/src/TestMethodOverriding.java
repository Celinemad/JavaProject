/*
 * 1. 제목: 메소드 오버라이딩 예제를 작성
 * 	1) 실제 실무에서 사용하고 있는 코드를 작성
 * 	2) 도형을 화면에 그려주는 예제
 * 		가. 먼저 사용자에게 메뉴를 보여주기
 * 		나. 메뉴 내용은 1. 선 그리기 2. 사각형 그리기 3. 원 그리기 4. 기타
 * 		다. 사용자가 1을 입력하면 선을 그려줍니다. 메시지를 출력
 * 		라. 사용자가 2를 입력하면 사각형을 그려줍니다. 메시지를 출력
 * 		마. 사용자가 3을 입력하면 원을 그려줍니다. 메시지를 출력
 * 		바. 사용자가 4를 입력하면 그려줄 도형이 없습니다. 메시지를 출력
 */
import java.util.Scanner;
// 2. 최상위 클래스인 Shape를 정의(Shape클래스는 public이면 안됨. 
// 파일 이름에 대응하는 public class가 1:1로 하나만 존재해야 하기 때문)
// ex) TestMethodOverriding.java -> public class TestMethodOverriding
class Shape {
	// 3. 상속받는 모든 자식 클래스에서 함게 사용할 수 있는 draw() 메소드를 정의
	public void draw() {
		System.out.println("그려줍니다.");
	}
}
// 4. Line 클래스를 정의: Shape 클래스를 상속
class Line extends Shape {
	// 4. 상속 받은 draw() 메소드의 명령어를 바꾸기 (재정의: 메소드 오버라이딩)
	public void draw() {
		System.out.println("선을 그려줍니다.");
	}
}
// 6. Rect 클래스를 정의: Shape 클래스를 상속: 사각형 클래스
class Rect extends Shape {
	//  7. draw() 메소드를 재정의
	public void draw() {
		System.out.println("사각형을 그려줍니다.");
	}
}
// 8. Circle 클래스를 정의: Shape 클래스를 상속
class Circle extends Shape {
	// 9. draw() 메소드를 재정의
	public void draw() {
		System.out.println("원을 그려줍니다.");
	}
}
class Tri extends Shape {
	public void draw() {
		System.out.println("삼각형을 그려줍니다.");
	}
}

public class TestMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10. Scanner 객체를 생성
		Scanner scanner = new Scanner(System.in);
		// 11. 사용자가 도형을 선택할 수 있도록 메뉴를 출력
		System.out.println("1. 선 그리기 2. 사각형 그리기 3. 원 그리기 4. 삼각형 그리기 5. 기타");
		// 12. 사용자로부터 메뉴 번호를 정수로 입력 받기
		int menu = scanner.nextInt();
		// 13. 사용자가 1을 입력한 경우의 처리를 작성
		if(menu == 1) {
			Line line = new Line();
			line.draw();
		}
		// 14. 사용자가 2를 입력한 경우의 처리를 작성
		else if (menu == 2) {
			Rect rect = new Rect();
			rect.draw();
		}
		// 15. 사용자가 3을 입력한 경우의 처리를 작성
		else if(menu == 3) {
			Circle circle = new Circle();
			circle.draw();
		}
		else if(menu == 4) {
			Tri tri = new Tri();
			tri.draw();
		}
		// 16. 사용자가 메뉴에 없는 번호를 입력한 경우의 처리를 작성
		else {
			System.out.println("메뉴에 없는 번호를 입력해서 도형을 그릴 수 없습니다.");
		}
	}

}
