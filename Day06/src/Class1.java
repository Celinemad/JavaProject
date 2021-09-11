//1. 단순 if문을 배우기

public class Class1 {

	public static void main(String[] args) {
		
		//2. 변수를 사용하기
		boolean a=true;
		if(a) {
			System.out.println("조건식이 참입니다!");
		} 
		
		//변수를 사용하지 않은 if문
		if(true) {
			System.out.println("조건식이 참!");
		}
		
		//3. 비교 연산자를 사용해서 비교식을 조건식에 작성 가능: 예) 국어 점수가 70점 이상인지를 판단하기
		//-> if (국어점수>=70)
		int kor = 70; //임의의 값
		if (kor>=70) {
			System.out.println("국어 점수가 70점 이상!");
		}
		if (kor<70) {
			System.out.println("국어 점수가 70점 미만!");
		}
		//4. 조건식에 논리 연산자를 함께 사용하기
		//1) 논리 연산자의 종류: 논리 곱(&&), 논리 합(||), 논리 부정(!)
		//2) 논리 곱(&&) 연산자의 기능: 모든 논리 값이 참인 경우에만 참
		//3) 논리 합(||) 연산자의 기능: 하나라도 참이 있으면 참
		//4) 논리 부정(!) 연산자의 기능: 반대 논리값으로 바꿈(참이면 거짓, 거짓이면 참)
		//예제) 국어점수가 0 이상이고 100 이하인지를 판단하는 if 조건문을 작성
		if(kor >= 0 && kor <= 100) {
			System.out.println("국어 점수는 0~100");
		}
		//예제) 논리 합 연산자를 사용해서 국어점수가 0 미만이거나 100 초과인지를 판단하는 if 조건문을 작성
		kor = -10;
		if(kor < 0 || kor > 100) {
			System.out.println("국어 점수는 0보다 작거나 100 초과");
		}
		
		/*
		 * 두 번째 if 조건문의 구조: if(조건식) {
		 *     문장;
		 * }
		 * else {
		 *     // 조건식이 거짓인 경우에만 실행
		 *     문장 2;
		 *  }
		 */
		//어떤 임의의 정수가 짝수인지 홀수인지를 판단하기
		int n = 6;
		//식: 임의의점수 % 2 == 0 (짝수 조건식)
		//홀수 조건식: 임의의점수 % 2 != 0 또는 임의의점수 % 2 == 1
		if(n % 2 == 0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}
		// 홀수 조건식을 먼저 작성. 그러면 짝수 조건식을 작성하지 않아도 됩니다!
		if(n % 2 != 0) {
			System.out.println("홀수");
		}
		else {
			System.out.println("짝수");
		}
		
		/*
		 * 정리:
		 * 1. 경우의 수가 2가지인 경우에는 단순 if문,  if~else문을 사용
		 * 2. 경우의 수가 3가지 이상인 경우에는?
		 * 1) 단순 if문 또는 if~else문을 사용
		 * 2) 다중 if문을 사용
		 */
		//2. 경우의 수가 3가지인 경우를 만들기: 어떤 정수가 음수인지? 0인지? 양수인지? 판단하기
		//1) 단순 if문 또는 if~else문을 사용
		//가. 단순 if문을 사용
		/*
		 * if (정수 < 0) 음수 조건
		 * if (정수 == 0) 0 조건
		 * if (정수 > 0) 양수 조건
		 */
		if(n < 0) {
			System.out.println("임의의 정수는 음수");
		}
		if(n == 0){
			System.out.println("임의의 정수는 0");
		}
		if(n > 0) {
			System.out.println("임의의 정수는 양수");
		}
		/*
		 * if~else문을 사용해서 경우의 수가 3가지인 것을 구현하기
		 * if(정수 > 0){
		 *     문장1;
		 * }
		 * else {
		 *     if(정수 ==0){
		 *         문장2;
		 *     }
		 *     else {
		 *         문장3;
		 *     }
		 * }
		 */
		if(n > 0) {
			System.out.println("임의의 정수는 양수");
		}
		else {
			if(n == 0) {
				System.out.println("임의의 정수는 0");
			}
			else {
				System.out.println("임의의 정수는 음수");
			}
		}
		
		/*
		 * 다중 if문을 사용해서 3가지 경우를 처리하기
		 * 1. 임의의 정수가 0 보다 큰 경우에는 양수를 출력
		 * 2. 임의의 정수가 0 이면 0 을 출력
		 * 3. 임의의 정수가 0 보다 작은 경우에는 음수를 출력
		 */
		n = 5;
		if(n > 0) {
			System.out.println("양수");
		}
		else if(n == 0){
			System.out.println("0");
		}
		else {
			System.out.println("음수");
		}
		/*
		 * 첫 번재 조건식으로 0을 판단하기: if(n == 0)
		 */
		if(n == 0) {
			System.out.println("임의의 정수는 0");
		}
		else if(n < 0) {
			System.out.println("임의의 정수는 음수");
		}
		else {
			System.out.println("임의의 정수는 양수");
		}
	}

}
