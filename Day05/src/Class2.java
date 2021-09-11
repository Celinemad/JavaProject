/*
 * 1. 제목: Scanner 입력 클래스를 사용해서 사용자로부터 2개의 정수를 각각 입력 받기
 * 2. Scanner 입력 클래스를 사용하는 방법
 * 1) import 명령어: 형식은 import java.util.Scanner;
 * 2) 변수 만들기: 형식은 Scanner 변수명 = new Scanner(System.in);
 * 3) nextInt() 함수를 사용해서 정수 입력 받기: 형식은 int 변수명2 = 변수명.nextInt();
 * 4) 논리 곱 연산자인 &&를 사용하기: boolean 변수명3 = 비교식1 && 비교식2;
 * 5) 결과를 출력하기: System.out.println(변수명3);
 * 6) 더 이상 Scanner 클래스 사용을 하지 않으려면 close() 함수를 사용: 변수명.close();
 */

import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.print("국어 점수를 정수로 입력하세요(0 이상 100 이하): ");
		 int kor = scanner.nextInt();
		 // 사용자가 입력한 국어 점수가 0 이상이고 100 이하(유효한 범위) 검사하기 
		 boolean result = kor >= 0 && kor <= 100;
		 System.out.println(result);
		 
		 // 사용자로부터 영어 점수를 정수로 입력 받기 
		 System.out.print("영어 점수를 정수로 입력하세요(0이상 100이하): ");
		 int eng = scanner.nextInt();
		 boolean result2 = eng < 0 || eng > 100;
		 System.out.println(result2);
		 
		 
		 /*
		 System.out.print("첫 번째 정수를 입력하세요: ");
		 int a = scanner.nextInt();
		 System.out.print("두 번째 정수를 입력하세요: ");
		 int b = scanner.nextInt();
		 
		 // 비교식1, 비교식2를 구상
		 // 사용자로부터 입력 받는 값에 따라서 참이 되는 경우와 거짓이 되는 경우를 정리
		 boolean result1 = a>=b && a<=b;
		 System.out.println(result1);
		 
		 boolean result2 = a>b || a<b;
		 System.out.println(result2);
		 */
		 scanner.close();
	}

}
