/*
 * 1. 제목: 삼항(조건) 연산자인 조건식 ? 참 : 거짓; 
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		//1. 문자열 데이터 형식과 삼항 연산자를 함께 사용
		String a = 10 == 10 ? "조건식이 참" : "조건식 거짓" ;
		System.out.println(a);
		
		int first = 10;
		int second = 20;
		
		String b = first == second ? "조건식이 참" : "조건식이 거짓";
		System.out.println(b);
		
		//2. 정수형 데이터 형식과 삼항 연산자를 함께 사용
		int c = 10 == 10 ? 10 : 20;
		System.out.println(c);
		
		c = first == second ? first : second;
		System.out.println(c);
		
		//3. 실수형 데이터 형식과 삼항 연산자를 함께 사용
		double d = 10 == 10? 3.5 : 4.5;
		System.out.println(d);
		
		double d1 = 3.5;
		double d2 = 4.5;
		d = d1 == d2 ? d1 : d2;
		System.out.println(d);
		
		/*
		 * 1. if~else 조건문을 사용해서 임의의 정수가 짝수이면 "짝수"를 화면에 출력.
		 *    홀수이면 "홀수"(문자열)를 화면에 출력
		 */
		int num = 10;
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		/*
		 * 2. 삼항(조건) 연산자를 사용해서 위의 if~else 조건문을 간소화하기
		 * 	1) 화면에 출력할 값은 "짝수" 또는 "홀수"이므로 String 변수명;
		 */
		String msg;
		//	2) 삼항 연산자를 사용해서 num%2 == 0
		msg = num % 2 == 0 ? "짝수" : "홀수";
		//	3) 변수 msg의 값을 출력
		System.out.println(msg);
		
		//	4) 변수를 사용하지 않고 출력 함수인 print() 안에 삼항 연산ㄴ자를 작성
		System.out.println(num%2==0? "짝수":"홀수");
		
		//	5) for 반복문을 사용해서 모니터 화면에 1, 2, 3, 4, 5, 를 출력
		for(int i = 1; i<=5 ; i++) {
			if(i>=1&&i<=4)
				System.out.print(i+",");
			//else
				//System.out.println(i);
		}
		
		//	6) for 반복문을 사용해서 무한 반복문을 구성하기: 끝나지 않는 반복문
		for(int i=5; i>=1; --i) {
			System.out.print(i+",");
		}
		System.out.println("\nfor 반복문이 종료되었나요?");
		//	7) 1+2+...+100까지 더하는 예제
		//		1) 변수 j를 선언: 1->2->...->100
		//		2) 변수 sum 을 선언: 0->1->3->...
		int sum;
		int j;
		for(j=1, sum=0; j<=100; sum+=j, j++)
			;
		System.out.println("1+2+...+100까지의 합은 "+sum);
		
	}

}
