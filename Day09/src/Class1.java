/*
 * 1. while 반복문을 사용해서 문한 반복문 구조를 작성하고 계속해서 안녕하세요? 메시지를 출력
 */

import java.util.Scanner;

public class Class1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("프로그램을 시작합니다.");
		
		while(true) {
			System.out.println("안녕하세요?");
			System.out.print("yes 또는 no 중에서 하나를 입력하세요: ");
			String line = scanner.nextLine();
			if(line.equals("")|| line.isEmpty()) {
				System.out.println("하나도 입력하지 않으셨습니다!");
				System.out.println("꼭! yes 또는 no 중에서 하나를 입력하세요!");
				continue;
			}
			else {
				System.out.println("사용자가 입력한 문자열은 "+line);
				if(line.equals("yes")) {
					System.out.println("사용자가 yes를 입력!");
					System.out.println("다시 안녕하세요? 메시지를 출력");
					continue;
				}
				else if(line.equals("no")) {
					System.out.println("사용자가 no를 입력!");
					System.out.println("메시지 출력을 중단!");
					break;
				}
				else {
					//사용자가 yes도 아니고 no도 아닌 문자열을 입력한 경우의 처리
					/*
					 * 1. 오류 메시지를 화면에 출력하고 반복문을 종료
					 * 2. 새로운 while 반복문을 작성해서 다시 또 새로운 yes 또는 no 문자열을 입력 요청하기
					 */
//					System.out.println("오류가 발생했습니다!");
//					System.out.println("시스템을 종료합니다.");
//					break;
					
					System.out.println("yes 또는 no 중에서 입력해주세요. 다시 실행합니다.");
					continue;
				}
			}
		}
		
		
		/*
		 * while 반복문을 사용해서 5번만 안녕하세요? 메시지를 출력
		 */
		int cnt = 1;
		while(cnt<=5) {
			System.out.println("안녕하세요?");
			cnt++;
		}
		
		/*
		 * 1. while(false)
		 * 2. for(;false;)
		 * 3. do~while(false)
		 */
//		while(false) {
//			System.out.println("안녕하세요?");
//		}
		
//		for(;false;) {
//			System.out.println("안녕하세요?");
//		}
		
		do {
			System.out.println("안녕하세요?");
		} while(false);
		
		/*
		 * do~while 반복문을 사용해서 무조건 먼저 사용자로부터 yes 또는 no 문자열을 입력 받기
		 */
		String yesno = "yes";
		do {
			System.out.print("yes 또는 no 중에서 입력하세요: ");
			yesno = scanner.nextLine();
			if (yesno.isEmpty()) {
				continue;
			}
			else if(yesno.equals("yes")) {
				continue;
			}
			else if(yesno.equals("no")) {
				break;
			}
			else {
				System.out.println("입력오류!");
				break;
			}
		} while(true);
		
		
		
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
		
	}

}
