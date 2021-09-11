/*
 * 1. 제목: do~while 반복문을 사용해서 사용자로부터 국어 점수를 입력받기
 * 1) 프로그램에서 입력 받기를 원하는 국어 점수의 범위: 0~100
 * 	- 만약 사용자가 0 보다 작거나 100보다 큰 점수를 입력한 경우
 * 		- 오류 메시지를 출력하고 입력을 중단하기
 * 		  또는 다시 사용자에게 입력을 요청하기
 */
import java.util.Scanner;
public class Class2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("프로그램을 시작합니다.");
		
		// 사용자가 입력할 국어 점수를 보관할 변수 kor을 선언 + 초기화
		int kor = 0; // 일반적으로 초기값은 프로그램에서 사용할 값의 범위 내에서 정하시면 됩니다.
		
		do {
			System.out.print("국어 점수를 정수로 입력하세요: ");
			kor = scanner.nextInt();
		} while(kor<0 || kor>100);
		
		System.out.println("사용자가 입력한 국어 점수는 "+kor);
		
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}

}
