/*
 * 1. 제목: 메모리에 저장되어 있는 비트들을 사용해서 논리 연산을 수행
 * 	1) 비트 논리 곱 연산: & 기호를 사용, 대응되는 비트가 모두 1인 경우에만 1
 * 	2) 비트 논리 합 연산: | 기호를 사용, 대응되는 비트가 하나라도 1이 있으면 1
 * 	3) 배타적 논리 합 연산: ^ 기호를 사용, 대응되는 비트가 다른 경우에만 1, 같으면 0
 * 	4) 비트 부정 연산: ~ 기호를 사용, 서로 반대되는 비트로 변환(0->1, 1->0)
 */
import java.util.Scanner;

public class Class4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a=0, b=0;
		try {
			System.out.print("첫 번째 정수를 입력하세요: ");
			a = scanner.nextInt();
			System.out.print("두 번재 정수를 입력하세요: ");
			b = scanner.nextInt();
			int c = a & b;
			System.out.println("비트 논리 곱 연산의 결과는 "+c+ ", 2진수는 "+Integer.toBinaryString(c));
			System.out.println("입력한 첫 번째 정수는 "+a+", 2진수는 "+Integer.toBinaryString(a));
			System.out.println("입력한 두 번째 정수는 "+b+", 2진수는 "+Integer.toBinaryString(b));
			
			c = a | b;
			System.out.println("비트 논리 합 연산의 결과는 "+c);
			c = a ^ b;
			System.out.println("배타적 논리 합 연산의 결과는 "+c);
			c = ~a;
			System.out.println("비트 부정 연산(~a)의 결과는 "+c);
		} catch (Exception e) {
			System.out.println("예외가 발생");
			e.printStackTrace();
		} finally {
			System.out.println("무조건 마지막에 실행");
			System.out.println("프로그램이 종료");
		}
		
		
		
	}

}
