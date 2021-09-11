package myjava1;
/*
 * 1. 제목: java.lang.Math 클래스를 사용하기
 */
import java.util.Scanner;
public class TestMath {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 무한 반복문 구조를 사용해서 사용자로부터 메뉴 번호를 입력 받아서 메뉴에 해당하는 메소드를 실행하고 결과를 출력
		while(true) {
			System.out.println("*** java.lang.Math 클래스를 사용 예제 ***");
			System.out.println("1. PI(원주율)  2. ceil()  3. floor()  4. sqrt()  5. 종료");
			System.out.println("메뉴 번호를 정수로 입력하세요: ");
			int menu = scanner.nextInt();
			if(menu == 5) {
				System.out.println("프로그램을 종료");
				break;
			}
			else if(menu == 1) {
				System.out.println("원주율 값을 출력하면 "+ Math.PI);
			}
			else if(menu == 2) {
				System.out.println("ceil() 값을 구하기");
				System.out.print("하나의 실수 값을 입력하세요: ");
				double number = scanner.nextDouble();
				double result = Math.ceil(number);
				System.out.println("사용자가 입력한 실수 "+ number + "의 ceil() 함수 결과는 "+ result);
			}
			else if(menu == 3) {
				System.out.println("floor() 값을 구하기");
				System.out.print("하나의 실수 값을 입력하세요: ");
				double number = scanner.nextDouble();
				double result = Math.floor(number);
				System.out.println("사용자가 입력한 실수 "+ number + "의 floor() 함수 결과는 "+ result);
			}
			else if(menu == 4) {
				System.out.println("sqrt() 값을 구하기");
				System.out.print("실수 값을 입력하세요: ");
				double number = scanner.nextDouble();
				double result = Math.sqrt(number);
				System.out.println("사용자가 입력한 실수 "+ number + "의 sqrt() 함수 결과는 "+ result);
			}
		}
		
		scanner.close();
		
	}

}
