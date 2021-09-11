/*
 * 1. 제목: 인터페이스를 사용하는 예제
 * 	1) 다중 상속을 지원
 * 	2) 단일 상속도 지원
 * 	3) 클래스와 함께 사용 가능
 * 		-> 형식: 접근제한자 class 자식클래스명 extends 부모클래스명 implements 인터페이스명 { ... }
 * 			-> 주의할 점: implements 명령어를 먼저 작성할 수 없음
 * 				-> 틀린 형식의 예) 접근제한자 class 자식클래스명 implements 인터페이스명1 extends 부모클래스명 { ... }
 */

// 1. 다중 상속을 예제로 작성
/*
 * 2. 2개의 인터페이스를 정의
 * 	1) interface MyInterface1 { ... }
 * 	2) interface MyInterface2 { ... }
 * 
 * 3. 위에서 정의한 2개의 인터페이스를 구현하는 자식 클래스를 정의
 * 	1) class Child implements MyInterface1, MyInterface2 { ... }
 */

import java.util.Scanner;

interface MyInterface1 {
	// 2개의 정수 덧셈 함수를 추상 메서드로 선언
	public abstract int iadd(int a, int b);
	// 2개의 정수 뺄셈 함수를 추상 메서드로 선언(추가)
	public abstract int isub(int a, int b);
}

interface MyInterface2 {
	// 2개의 실수 덧셈 함수를 추상 메서드로 선언
	public abstract double dadd(double a, double b);
	// 2개의 실수 뺄셈 함수를 추상 메서드로 선언(추가)
	public abstract double dsub(double a, double b);
}

class Child2 implements MyInterface1, MyInterface2{
	
	@Override
	public double dsub(double a, double b) {
		System.out.println("dsub(double, double) 메서드가 호출");
		double c = a - b;
		return c;
	}

	@Override
	public int isub(int a, int b) {
		System.out.println("isub(int, int) 메서드가 호출");
		int c = a - b;
		return c;
	}

	@Override
	public double dadd(double a, double b) {
		System.out.println("dadd(double, double) 메서드가 호출");
		double c = a + b;
		return c;
	}

	@Override
	public int iadd(int a, int b) {
		System.out.println("iadd(int, int) 메서드가 호출");
		int c = a + b;
		return c;
	}
	
}

public class TestInterface {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Child2 클래스를 사용하기
		Child2 a = new Child2();
		// iadd() 메서드를 호출해서 2개의 정수를 더하기
		int iresult = a.iadd(10, 20);
		System.out.printf("%d + %d = %d\n", 10, 20, iresult);
		// dadd() 메서드를 호출해서 2개의 실수를 더하기
		double dresult = a.dadd(3.2, 2.5);
		System.out.printf("%.2f + %.2f = %.2f\n", 3.2, 2.5, dresult);
		
		System.out.print("첫번째 정수를 입력하세요: ");
		int num1 = scanner.nextInt();
		System.out.print("두번째 정수를 입력하세요: ");
		int num2 = scanner.nextInt();
		
		int isubresult = a.isub(num1, num2);
		System.out.printf("%d - %d = %d\n", num1, num2, isubresult);
		
		System.out.print("첫번째 실수를 입력하세요: ");
		double num3 = scanner.nextDouble();
		System.out.print("두번째 실수를 입력하세요: ");
		double num4 = scanner.nextDouble();
		
		double dsubresult = a.dsub(num3, num4);
		System.out.printf("%.2f - %.2f = %.2f\n", num3, num4, dsubresult);
		
		
		scanner.close();
		
	}

}
