/*
 * 1. 제목: 절차 지향 프로그래밍 방법을 사용해서 새로운 회원의 아이디와 비밀번호를 입력 받기
 * 
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***회원 정보 입력 예제");
		
		String id = "Celine";
		String pwd = "celineinparis";
				
		System.out.print("아이디를 입력하세요: ");
		id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하세요: ");
		pwd = scanner.nextLine();
		
		System.out.println("아이디는 "+ id + ", 비밀번호는 "+pwd);
		scanner.close();
		System.out.println("프로그램을 종료합니다");
	}

}
