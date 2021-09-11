//1. 제목: 사용자가 점심 메뉴를 고르는 예제
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		/*
		 * 1. 스캐너 변수를 생성
		 * 2. 사용자에게 점심 메뉴를 보여주기
		 * 3. 사용자가 점심 메뉴를 고르기: 메뉴 번호(1~3) 중에서 하나를 입력
		 * 4. 프로그램에서 다중 if문을 사용해서 사용자가 고른 메뉴 번호에 따른 메뉴명을 출력
		 * 5. 프로그램 종료: 스캐너 변수가 갖고 있는 close() 전용 함수를 사용
		 */
		
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("1.떡볶이 2.주먹밥 3.튀김");
		System.out.print("원하는 메뉴의 번호(1~3)를 정수로 입력하세요: ");
		int a = scanner.nextInt();
		if(a==1) {
			System.out.println("떡볶이");
		}
		else if(a == 2) {
			System.out.println("주먹밥");
		}
		else if(a == 3){
			System.out.println("튀김");
		}
		else {
			System.out.println("메뉴에 없는 정수를 입력");
		}
		*/
		
		/*
		System.out.println("1.양식 2.중식 3.한식 4.분식");
		System.out.print("원하는 메뉴의 번호(1~3)를 정수로 입력하세요: ");
		int a = scanner.nextInt();
		if(a==1) {
			System.out.println("양식에 관련된 메뉴명들을 출력");
			System.out.println("1.파스타 2.피자 3.리조또");
			System.out.print("다시 메뉴 변호를 정수로 입력하세요: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("파스타");
			}
			else if(b==2) {
				System.out.println("피자");
			}
			else {
				System.out.println("리조또");
			}
		}
		else if(a == 2) {
			System.out.println("중식에 관련된 메뉴명들을 출력");
			System.out.println("1.짜장면 2.꿔바로우 3.지삼선");
			System.out.print("다시 메뉴 변호를 정수로 입력하세요: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("짜장면");
			}
			else if(b==2) {
				System.out.println("꿔바로우");
			}
			else {
				System.out.println("지삼선");
			}
			
		}
		else if(a == 3){
			System.out.println("한식에 관련된 메뉴명들을 출력");
			System.out.println("1.갈비찜 2.잡채 3.육개장");
			System.out.print("다시 메뉴 변호를 정수로 입력하세요: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("갈비찜");
			}
			else if(b==2) {
				System.out.println("잡채");
			}
			else {
				System.out.println("육개장");
			}
		}
		else if(a == 4) {
			System.out.println("분식에 관련된 메뉴명들을 출력");
			System.out.println("1.떡볶이 2.컵밥 3.튀김");
			System.out.print("다시 메뉴 변호를 정수로 입력하세요: ");
			int b = scanner.nextInt();
			if(b==1) {
				System.out.println("떡볶이");
			}
			else if(b==2) {
				System.out.println("컵밥");
			}
			else {
				System.out.println("튀김");
			}
			
		}
		else {
			System.out.println("메뉴에 없는 정수를 입력");
		}
		*/
		
		/*
		 * switch~case 문을 사용해서 다중 if 문을 간소화하기
		 */
		//1) 사용자에게 점심 메뉴를 보여주기
		System.out.println("1.떡볶이 2.컵밥 3.튀김");
		System.out.print("메뉴 번호(1~3)를 정수로 입력하세요: ");
		int a = scanner.nextInt();
		switch(a) {
		case 1:
			System.out.println("떡볶이");
		    break;
		    
		case 2:
			System.out.println("컵밥");
			break;
			
		case 3:
			System.out.println("튀김");
			break;
		
		default:
			System.out.println("메뉴에 없는 번호를 입력");
		
		}
		scanner.close();
		System.out.println("프로그램이 종료");
		
		
	}

}
