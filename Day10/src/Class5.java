/*
 * 1. 제목: 실행 오류를 처리하기
 */
import java.util.Scanner;

public class Class5 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("정수를 입력하세요: ");
//		int num = scanner.nextInt();
//		int result = num / 0;
//		System.out.println("이 메시지가 보이나요?"); // 안보이고 에러 뜸
//		System.out.println("사용자가 입력한 정수를 0으로 나눈 결과는 "+result);
//		scanner.close();
		
		try {
			int result  = 5 / 0;
			System.out.println("실행되지 않습니다!");
		} catch(Exception e) {
			System.out.println("실행해야 합니다!");
		}
	}

}
