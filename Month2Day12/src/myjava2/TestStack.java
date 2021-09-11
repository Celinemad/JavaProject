package myjava2;
/*
 * 1. 제목: 스택을 사용해서 사람 이름을 거꾸로 보관하기
 */
import java.util.*;

public class TestStack {
	public static void main(String[] args) {
		// 2. scanner 객체를 생성
		Scanner scanner = new Scanner(System.in);
		
		// 3. Stack 객체를 생성
		Stack<String> nameStack = new Stack<String>();
		
		//4. 무한 반복문을 작성: 사용자로부터 사람 이름을 입력 받기(사용자가 quit를 입력하면 종료)
		while(true) {
			// 5. 사람 이름을 문자열로 입력 받기
			System.out.print("사람 이름을 입력하세요: ");
			String inputName = scanner.nextLine();
			while(inputName.isEmpty()) {
				System.out.print("꼭! 사람 이름을 입력하세요: ");
				inputName = scanner.nextLine();
			}
			System.out.println("사용자가 입력한 이름은 " + inputName);
			// 6. push() 메소드를 사용해서 스택에  사람 이름을 저장하기
			nameStack.push(inputName);
			System.out.println("스택에 사람 이름을 저장했습니다...");
			// 7. 계속 여부를 사용자에게 물어보기
			System.out.print("중단하려면 quit를 입력하세요: ");
			String inputQuit = scanner.nextLine();
			while(inputQuit.isEmpty()) {
				System.out.print("꼭! quit를 입력하세요: ");
				inputQuit = scanner.nextLine();
			}
			if(inputQuit.equals("quit")) {
				System.out.println("종료합니다...");
				break;
			}
			System.out.println("size() 함수를 실행한 결과는 " + nameStack.size());
		}
		System.out.println("반복문을 종료했습니다...");
		
		/*
		 * 스택 객체가 갖고 있는 사람 이름들을 꺼내오려면 pop() 메소드를 실행
		 * 1) 형식: String 변수명 = 스택객체명.pop();
		 * 2) pop() 메소드를 실행하기 전에 isEmpty() 메소드를 실행해서 스택에서 꺼내올 사람 이름이 있는지를 먼저 판단하기
		 *    -> 안정적인 프로그램을 구현하기 위함
		 *    -> 형식) boolean 변수명 = 스택객체명.isEmpty();
		 *            if(변수명 == true) // 스택에서 꺼내올 이름이 없는 경우
		 *            else // 스택에서 꺼내올 이름이 있는 경우 -> pop() 메소드를 호출
		 */
		while(nameStack.isEmpty()==false) {
			String value = nameStack.pop();
			System.out.println("스택에서 꺼내온 사람 이름은 " + value);
		}
	}

}
