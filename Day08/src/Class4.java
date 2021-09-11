/*
 * 1. 제목: 주사위 던지기 예제
 */
import java.util.Random;
public class Class4 {

	public static void main(String[] args) {
		
		//1. Random 변수 선언
		Random random = new Random();
		int compcnt = 0;
		int hmncnt = 0;
		int same = 0;
		
		//2. 게임 수는 총 5번
		for(int cnt=1; cnt<=5; cnt++) {
			//3. 1~2 사이에 있는 임의의 정수를 만들어서 임의의 변숭 저장
			int choice = random.nextInt(2)+1;
			//4. 만약 위에서 임의의 정수 1이 나오면 컴퓨터가 먼저 주사위를 던지기
			if(choice==1) {
				System.out.println("컴퓨터가 먼저 주사위를 던집니다...");
				int computer = random.nextInt(6)+1;
				System.out.println("사람이 주사위를 던집니다...");
				int human = random.nextInt(6)+1;
				
				if(computer > human) {
					System.out.println("승자는 컴퓨터");
					compcnt +=1;
				} 
				else if(human > computer) {
					System.out.println("승자는 사람");
					hmncnt +=1;
				}
				else {
					System.out.println("무승부");
					same +=1;
				}
			}
			else if(choice==2){
				System.out.println("사람이 먼저 주사위를 던집니다...");
				int human = random.nextInt(6)+1;
				System.out.println("컴퓨터가 주사위를 던집니다...");
				int computer = random.nextInt(6)+1;
				
				if(computer > human) {
					System.out.println("승자는 컴퓨터");
					compcnt +=1;
				} 
				else if(human > computer) {
					System.out.println("승자는 사람");
					hmncnt +=1;
				}
				else {
					System.out.println("무승부");
					same +=1;
				}
			}
		}
		System.out.printf("%d승 %d무 %d패", hmncnt, same, compcnt);
		
	}
		
		
		
}


