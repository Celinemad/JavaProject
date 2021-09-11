/*
 * 1. 제목: static 메소드를 실제 사용하는 경우: java.lang.Math 클래스를 사용
 */

public class TestStatic2 {
	
	/*
	 * java.lang.Math.max() 메소드를 흉내내기
	 * 1. static 제한자를 사용해서 메소드를 정의
	 */

	public static int max(int a, int b) {
		if (a>b) {
			return a;
		} 
		else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		// 1. max() 함수를 사용해서 2개의 값 중에서 큰 값을 구하기
		int max_number = java.lang.Math.max(2, 3);
		System.out.println("2와 3 중에서 큰 정수는 "+ max_number);
		
		// 2. min() 함수를 사용해서 2개의 값 중에서 작은 값을 구하기
		int min_number = java.lang.Math.min(2, 3);
		System.out.println("2와 3 중에서 작은 정수는 "+ min_number);
		
		// 3. pow() 함수를 사용해서 원의 넓이를 구하기
		double circle_area = 3.14 * Math.pow(2, 2);
		System.out.println("원의 넓이는 "+ circle_area);
		
		// 4. abs() 함수를 사용해서 절대값을 구하기: absolute(절대값)의 약어
		double abs_number = Math.abs(-3.5);
		System.out.println("음수 -3.5의 절대값은 "+ abs_number);
		
		// 모두 static으로 이루어져 있기 때문에 new는 사용하지 않음
		
		// 5. 위에서 정의한 max() 함수를 호출
		max_number = TestStatic2.max(2, 3);
		System.out.println("2와 3 중에서 큰 정수는 "+ max_number);
	}

}
