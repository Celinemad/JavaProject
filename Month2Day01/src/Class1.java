/*
 * 1. 제목: 오버로딩(함수의 중복: Overloading)
 * 	- 하나의 클래스에서 이름이 같은 함수가 여러 개 작성
 * 	- 단, 외부 입력(매개변수 또는 인자(Argument)) 부분은 달라야 합니다.
 * 	- 절차 지향은 안되고, 객체 지향만 가능한 기능
 */

// 계산기 클래스를 정의
class MyCalculator {
	// 2개의 정수 덧셈 메소드 정의
	public int add(int a, int b) {
		int c;
		System.out.println("2개의 정수를 더하는 add(int, int) 메소드가 호출됨");
		c = a+b;
		return c;
	}
	// 오버로딩 성질을 이용해서 add 함수명을 다시 사용
	public int add(int a, int b, int c) {
		int d;
		System.out.println("3개의 정수를 더하는 add(int, int, int) 메소드가 호출됨");
		d = a+b+c;
		return d;
	}
	// 실수 2개의 덧셈 수행 함수 정의: 오버로딩을 사용해서 add 이름을 다시 사용 가능
	public double add(double a, double b) {
		double c;
		System.out.println("2개의 실수를 더하는 add(double, double) 메소드가 호출됨");
		c = a + b;
		return c;
	}
	public int times(int a, int b) {
		int c;
		System.out.println("2개의 정수를 곱하는 times(int, int) 메소드가 호출됨");
		c = a * b;
		return c;
	}
	public int times(int a, int b, int c) {
		int d;
		System.out.println("3개의 정수를 곱하는 times(int, int, int) 메소드가 호출됨");
		d = a * b * c;
		return d;
	}
	public double times(double a, double b) {
		double c;
		System.out.println("2개의 실수를 곱하는 times(double, double) 메소드가 호출됨");
		c = a * b;
		return c;
	}
}

public class Class1 {
	public static void main(String[] args) {
		
		//1. MyCalculator 클래스를 사용하기 위함 참조 변수를 선언 + new 연산자를 사용해서 객체를 생성
		MyCalculator a = new MyCalculator();
		//2. 정수 덧셈 게산을 수행하기
		int result = a.add(10, 20);
		//3. 정수 덧셈 결과를 출력
		System.out.println("10 더하기 20은 "+ result);
		//4. 3개의 정수 덧셈 계산을 수행하기: add()메소드 이름을 사용
		result = a.add(10, 20, 30);
		//5. 결과 출력
		System.out.println("10 더하기 20 더하기 30은 "+result);
		//6. 2개의 실수 덧셈 계산: add() 메소드 이름을 사용
		double dresult = a.add(3.2, 2.5);
		//7. 결과 출력
		System.out.println("3.2 더하기 2.5는 "+dresult);
		
		int tresult = a.times(10, 20);
		System.out.println("10 곱하기 20은 "+tresult);
		tresult = a.times(10, 20, 30);
		System.out.println("10 곱하기 20 곱하기 30은 "+tresult);
		double dtresult = a.times(1.5, 2.5);
		System.out.println("1.5 곱하기 2.5는 "+dtresult);
		
	}

}
