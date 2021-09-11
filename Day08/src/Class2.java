/*
 * 1. 제목: 사용자로부터 시작 단과 끝 단을 입력 받아서 시작 단에서 끝 단에 있는 모든 단들을 계산해서 출력
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		//1. 시작 단을 보관할 변수 start 선언
		int start;
		//2. 끝 단을 보관할 변수 end 선언
		int end; 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("시작 단을 정수로 입력하세요: ");
		start = scanner.nextInt();
		System.out.print("끝 단을 정수로 입력하세요: ");
		end = scanner.nextInt();
		
		System.out.println("\n시작 단은 "+start+", 끝 단은 "+end);
		
//		//사용자가 음수를 입력한 경우
//		if (start<0) {
//			start *= -1;
//			if (end<0) {
//				end *= -1;
//			} 
//			else {
//				;
//			}
//		}
		
		if (start<=end) {
			for(int dan = start; dan<=end; dan++) {
				System.out.printf("\n***%d단***\n", dan);
				for(int num = 1; num<=9; num++) {
					System.out.printf("%d * %d = %d\n", dan, num, dan*num);
				}
			}
		}
		else {
			for(int dan = end; dan<=start; dan++) {
				System.out.printf("\n***%d단***\n", dan);
				for(int num = 1; num<=9; num++) {
					System.out.printf("%d * %d = %d\n", dan, num, dan*num);
				}
			}
		}
		
		
		
	}

}
