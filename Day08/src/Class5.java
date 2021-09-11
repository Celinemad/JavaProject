/*
 * 1. 제목: 컴퓨터와 사람 간의 가위/바위/보 게임 구현
 */
import java.util.Random;
import java.util.Scanner;
public class Class5 {

	public static void main(String[] args) {
		
		//2. Scanner 변수 생성
		Scanner scanner = new Scanner(System.in);
		//3. Random 변수 생성
		Random random = new Random();
		//4. 먼저 사람이 가위/바위/보 중에서 하나를 냅니다.(사용자 입력)
		System.out.print("가위/바위/보 중에서 하나를 문자열로 입력하세요: ");
		String human = scanner.nextLine();
		//5. 컴퓨터는 난수를 사용해서 가위/바위/보를 ㅣㅇㅁ의로 만들기
		int computer = random.nextInt(3)+1;
		String scomputer;
		if(computer==1) {
			scomputer = "가위";
		}
		else if(computer==2) {
			scomputer = "바위";
		}
		else if(computer==3){
			scomputer = "보";
		}
		else {
			scomputer = "보";
			//강제로 main() 함수를 종료하시면 exit() 함수를 사용
			//	-> 형식: System.exit();
			//		-> 정수의 의미: 운영체제에게 반환하는 값
			//			-> 정상 종료시에는 0을 사용. 프로그램에서 논리적인 오류나 예외상황에는 음수를 사용 또는 1
			System.exit(-1);		
		}
		
		//승자/패자/무승부를 결정하기
		if(scomputer.equals(human)) {
			// 사용자와 컴퓨터 간에 같은 것을 낸 경우
			System.out.println("무승부");
		}
		else {
			//사용자는 가위를 내고 컴퓨터는 바위를 낸 경우
			if(human.equals("가위") && scomputer.equals("바위")) {
				System.out.println("컴퓨터가 승자");
			}
			//사용자는 가위를 내고 컴퓨터는 보를 낸 경우
			else if(human.equals("가위") && scomputer.equals("보")) {
				System.out.println("사용자가 승자");
			}
			//사용자는 바위를 내고 컴퓨터는 보를 낸 경우
			else if(human.equals("바위") && scomputer.equals("보")) {
				System.out.println("컴퓨터가 승자");
			}
			//사용자는 바위를 내고 컴퓨터는 가위를 낸 경우
			else if(human.equals("바위") && scomputer.equals("가위")) {
				System.out.println("사용자가 승자");
			}
			//사용자는 보를 내고 컴퓨터는 가위를 낸 경우
			else if(human.equals("보") && scomputer.equals("가위")) {
				System.out.println("컴퓨터가 승자");
			}
			//사용자는 보를 내고 컴퓨터는 주먹을 낸 경우
			else if(human.equals("보") && scomputer.equals("주먹")) {
				System.out.println("사용자가 승자");
			}
		}
		scanner.close();
		System.out.println("가위/바위/보 게임을 종료합니다...");
	}

}
