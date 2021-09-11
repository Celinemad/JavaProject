/*
 * 1. 제목: 10진수 x를 2진수로 변환하기
 * 	1) 자바에서 제공해주는 Integer.toBinaryString() 함수를 사용
 * 	2) 배열과 반복문을 사용해서 새로운 명령어 형식을 만들기
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {

		//1. 변수 선언은 try 블럭 외부에 뽑아내야 함
		Scanner scanner = new Scanner(System.in);
		//2. try~catch~finally 블럭을 작성해서 예외에 대비하기
		try {
			//3. 사용자로부터 10진수를 정수로 입력 받기
			System.out.print("10진수를 정수로 입력하세요: ");
			int a = scanner.nextInt();
			//4. Integer.toBinaryString() 함수를 실행해서 10진수를 2진수로 변환하기
			String b = Integer.toBinaryString(a);
			System.out.println("사용자가 입력한 10진수는 "+a+", 변환된 2진수는 "+b);
		} catch(Exception e1) {
			System.out.println("예외가 발생");
			e1.printStackTrace();
		} finally {
			System.out.println("예외에 상관없이 무조건 마지막에 실행");
		}
		
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
		
	}

}
