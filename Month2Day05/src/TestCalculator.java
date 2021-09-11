/*
 * 1. 추상 클래스인 Calculator를 사용해서 GoodCalc 자식 클래스를 정의
 */

// 2. Calculator 클래스를 추상 클래스로 정의
abstract class Calculator {
	// 3. 2개의 정수를 덧셈하는 add() 추상 메서드의 선언
	public abstract int add(int a, int b);
	// 4. 2개의 정수를 뺄셈하는 sub() 추상 메서드의 선언
	public abstract int sub(int a, int b);
	// 5. 여러 정수값들을 갖는 정수형 배열을 입력으로 받는 avg() 추상 메서드의 선언
	public abstract double avg(int[] arr1);
	// 추가: 여러 정수값 중에서 가장 큰 정수를 반환하는 max() 추상 메서드의 선언
	public abstract int max(int[] arr1);
}

// 6. Calculator 추상클래스를 상속 받는 GoodCalc 자식 클래스를 정의
class GoodCalc extends Calculator {
	
	// 상단에 Source -> Override/Implement Methods ... : 오버라이드 항목들 다 자동으로 추가됨 
	// 	단축키: Alt + Shift + S -> 팝업창이 출력 -> Override/Implement Methods...
	@Override
	public int max(int[] arr1) {
		int b = Integer.MIN_VALUE;
		for(int a=0; a<arr1.length; a++) {
			if(arr1[a] > b)
				b = arr1[a];
		}
		return b;
	}

	@Override
	public int add(int a, int b) {
		System.out.println("재정의한 add(int a, int b) 메서드가 호출됨");
		int c = a + b;
		return c;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("재정의한 sub(int a, int b) 메서드가 호출됨");
		int c = a - b;
		return c;
	}

	@Override
	public double avg(int[] arr1) {
		// 평균을 구하는 공식: 배열 arr1의 모든 요소들의 값을 다 더한 값 / 배열 arr1의 요소의 갯수
		int sum  = 0;
		for(int a = 0; a<arr1.length; a++) {
			sum += arr1[a];
		}
		double c = sum / arr1.length;
		return c;
	}
	// 7. 3개의 메서드들의 재정의
	// -> 메서드가 많은 경우에는 메뉴를 사용해서 자동으로 명령어가 생성
	// -> Source 메뉴를 선택 -> 팝업 창이 출력 -> Override/Implement Methods... 항목을 선택
	// -> 클래스와 메서드를 선택하는 창이 출력 -> 클래스와 재정의할 메서드를 선택 
	
}
public class TestCalculator {

	public static void main(String[] args) {
		// 새로 정의한 GoodCalc 클래스를 사용해서 새로운 객체를 생성
		GoodCalc a = new GoodCalc();
		// 재정의한 add() 메서드를 호출: 2개의 정수 값을 전달
		int result = a.add(10, 20);
		// 10과 20을 더한 결과를 화면에 출력
		System.out.printf("%d + %d = %d\n", 10, 20, result);
		// 재정의한 sub()메서드를 호출: 2개의 정수값을 전달
		result = a.sub(20, 10);
		// 20-10을 한 결과를 출력
		System.out.printf("%d - %d = %d\n", 20, 10, result);
		// 재정의한 avg() 메서드를 호출: 정수형 배열을 전달
		int[] arr1 = {1,2,3,4,5};
		double result2 = a.avg(arr1);
		System.out.println("배열 arr1의 모든 값들의 평균은 "+result2);
		// 책에 있는 방식으로 new 연산자를 사용해서 동적으로 배열을 생성하기: new 자료형[]{값1, 값2, 값3, ..., 값n}
		result2 = a.avg(new int[] {1,2,3,4,5});
		System.out.println("배열 int[]{1,2,3,4,5}의 평균은 "+ result2);
		
		int result3 = a.max(new int[] {1,2,3,4,5});
		System.out.println("배열 int[]{1,2,3,4,5}의 최대값은 "+ result3);
	}

}
