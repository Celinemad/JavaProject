/*
 * 1. 제목: 1+2+...+사용자가_입력한_정수
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		//1. Scanner 변수를 생성
		Scanner scanner = new Scanner (System.in);
		
		//2. 사용자로부터 입력받을 마지막 정수를 보관할 변수 end 선언
		int end;
		
		//3. 사용자로부터 마지막 정수를 입력 요청하기
		System.out.print("마지막 정수를 입력하세요: ");
		end = scanner.nextInt();
		System.out.println("사용자가 입력한 마지막 정수는 "+ end);
		
		if (end<0)
			end*=(-1);
		
		int sum;
		int a;
		for(a=1, sum=0; a<=end; sum+=a, a++) 
			;
		System.out.println("1부터 사용자가 입력한 마지막 정수까지의 합은 "+sum);
		
		//제일 마지막(더 이상 사용자로부터 값을 입력할 필요가 없는 경우)에는 close() 함수를 사용
		scanner.close();
		System.out.println("프로그램이 종료됩니다.");
	}

}
