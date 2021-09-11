import java.util.Scanner;
public class Class {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] aeng = new int[5];
		int i = 0;
		while (i<aeng.length) {
			System.out.print((i+1)+"번째 학생의 영어 점수를 정수로 입력: ");
			aeng[i] = scanner.nextInt();
			System.out.println("사용자가 입력한 영어 점수는 "+aeng[i]);
			i++;
		}
		
		scanner.close();
		System.out.println("프로그램이 종료되었습니다.");
	}

}
