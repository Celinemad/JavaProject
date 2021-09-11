/*
 * 1. 제목: for 반복문을 사용해서 무한 반복문(Infinite Loop) 구조 만들기
 * 	1) 계속해서 안녕하세요? 메시지를 사용자에게 보여주는 예제를 작성
 */
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {
		
		//2. 무한 반복문 구조를 작성
//		for(;true;) {
//			System.out.println("안녕하세요?");
//		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("프로그램이 실행 중...");
		//2. 사용자에게 y 또는 n 한 글자 입력을 요청하기
		System.out.print("y 또는 n 한 글자만을 입력하세요: ");
		char ch = scanner.nextLine().charAt(0);
		//3. 사용자가 입력한 문자를 출력
		System.out.println("사용자가 입력한 한 글자는 "+ch);
		
		//4. 사용자에게 yes 또는 no 여러 문자열들을 입력 요청하기
		System.out.print("yes 또는 no 중에서 하나를 입력하세요: ");
		String line = scanner.nextLine();
		System.out.println(line);
		
		/*
		 * 5. for 반복문을 사용해서 무한 반복문 구조를 만들기
		 * 	1) for(;true;) {
		 * 		계속해서_실행할_문장;
		 * 	   }
		 */
		for (;true;) {
			System.out.println("안녕하세요?");
			// 사용자에게 y 또는 n 한 글자를 입력 요청하기
			System.out.print("y 또는 n 중에서 하나를 입력하세요: ");
			char yn = scanner.nextLine().charAt(0);
			//if~else 조건문을 사용해서 만약 사용자가 y를 입력하면
			// 또(다시) 안녕하세요? 메시지를 보여주기 위해서 위로 이동하기: continue 명령어를 사용해서 해결
			// -> 형식) if (조건식) {continue; } // 실행 흐름은 위로 이동해서 for 반복문의 변화식으로 이동 -> 조건식 -> ...
			if (yn=='y') {
				System.out.println("사용자가 y를 입력");
				continue;
			}
			else if(yn=='n') {
				System.out.println("사용자가 n을 입력");
				break;
			}
			// 만약 사용자가 대문자 y를 입력하면 continue 명령어를 실행
			else if(yn=='Y') {
				System.out.println("사용자가 Y를 입력");
				continue;
			}
			else if(yn=='N') {
				System.out.println("사용자가 N을 입력");
				break;
			}
			else {
				System.out.println("사용자가 y/Y/n/N 도 아닌 다른 문자를 입력");
			}
		}
		
		/*
		 * for 반복문을 사용해서 무한 반복문 구조를 작성
		 */
		for(;true;) {
			System.out.println("안녕하세요!");
			System.out.print("yes 또는 no 중에서 하나를 입력하세요: ");
			line = scanner.nextLine();
			//사용자가 yes를 입력했는지 판단하기
			boolean result2 = line.equals("yes");
			if(result2 == true) {
				System.out.println("사용자가 yes를 입력!");
				continue;
			}
			else if(result2 == false) {
				if (result2 = line.equals("no")){
					System.out.println("사용자가 no를 입력!");
					break;
				}
				else {
					System.out.println("다시 제대로 입력해주세요.");
					continue;
				}
			}
		}
		
		
		
		scanner.close();
		System.out.println("프로그램이 종료");
		
	}

}
