package myjava2;
/*
 * 1. 제목: LinkedList 클래스를 사용해서 학생의 이름들을 저장하기
 */
import java.util.*;
public class TestLinkedList {

	public static void main(String[] args) {
		// 2. Scanner 객체를 생성
		Scanner scanner = new Scanner(System.in);
		
		// 3. LinkedList 객체를 생성(문자열 저장)
		LinkedList<String> nameLinkedList = new LinkedList<String>();
		
		// 4. while 반복문을 사용해서 반복적으로 학생의 이름들을 사용자로부터 입력 받기
		while(true) {
			//5. 학생의 이름을 입력받기
			System.out.print("학생의 이름을 입력하세요: ");
			String inputName = scanner.nextLine();
			while(inputName.isEmpty()) {
				System.out.print("꼭! 학생의 이름을 입력하세요: ");
				inputName = scanner.nextLine();
			}
			
			System.out.println("사용자가 입력한 학생 이름은 " + inputName);
			
			nameLinkedList.add(inputName);
			
			// 6. 사용자에게 계속해서 학생 이름을 입력할지 여부를 물어보기
			System.out.print("입력을 중단하시려면 no를 입력: ");
			String yes_no  = scanner.nextLine();
			while(yes_no.isEmpty()) {
				System.out.println("꼭! no를 입력하세요: ");
				yes_no = scanner.nextLine();
			}
			if(yes_no.equals("no")) {
				System.out.println("학생 이름 입력을 중단합니다...");
				break;
			}
			else if(yes_no.equals("yes")) {
				System.out.println("다시 새로운 학생의 이름을 입력 받습니다...");
				continue;
			}
		}
		
		
	}

}
