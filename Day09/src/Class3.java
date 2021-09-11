/*
 * 1. 제목: 배열(Array)의 필요성을 위한 예제
 * 1) 5명 학생의 국어 점수들을 변수를 사용해서 메모리에 보관하기
 * 2) 5명 학생의 국어 점수들을 배열을 사용해서 메모리에 보관하기
 */
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("프로그램이 시작됩니다.");
		
		/*
		 * 1. 변수를 사용해서 5개의 국어 점수들을 보관
		 * 	-> 갯수 만큼 서로 다른 이름을 갖는 변수가 필요(선언)
		 */
		int kor01 = 0;
		int kor02 = 0;
		int kor03 = 0;
		int kor04 = 0;
		int kor05 = 0;
		/*
		 * 위의 형식을 간소화할 수 있는 형식:
		 * 	데이터타입 변수명1 = 값1, 변수명2 = 값2, 변수명3 = 값3, 변수명4 = 값4, 변수명5 = 값5;
		 */
		int ikor01=0, ikor02=0, ikor03=0, ikor04=0, ikor05=0;
		
		// 사용자로부터 첫 번째 학생의 국어 점수를 입력 받기
		System.out.print("첫 번째 학생의 국어 점수를 입력하세요: ");
		kor01=scanner.nextInt();
		System.out.println("사용자가 입력한 첫 번째 학생의 국어 점수는 "+kor01);
		
		System.out.print("두 번째 학생의 국어 점수를 입력하세요: ");
		kor02=scanner.nextInt();
		System.out.println("사용자가 입력한 두 번째 학생의 국어 점수는 "+kor02);
		
		System.out.print("세 번째 학생의 국어 점수를 입력하세요: ");
		kor03=scanner.nextInt();
		System.out.println("사용자가 입력한 세 번째 학생의 국어 점수는 "+kor03);
		
		System.out.print("네 번째 학생의 국어 점수를 입력하세요: ");
		kor04=scanner.nextInt();
		System.out.println("사용자가 입력한 네 번째 학생의 국어 점수는 "+kor04);
		
		System.out.print("다섯 번째 학생의 국어 점수를 입력하세요: ");
		kor05=scanner.nextInt();
		System.out.println("사용자가 입력한 다섯 번째 학생의 국어 점수는 "+kor05);
		
		/*
		 * 최대 5명 학생의 국어 점수를 정수로 보관할 배열을 생성해서 사용하기
		 * 1. 변수 선언: 데이터타입[] 변수명;
		 * 2. 공간(변수들을) 생성: 변수명 = new 데이터타입[개수];
		 * 3. 배열 안에서 만들어진 변수들에 값을 보관: 변수명[인덱스]=값;
		 */
		int[] akor;
		akor = new int[5];
		// -> 2개의 명령어를 하나로 합치기: 데이터타입[] 변수명 = new 데이터타입[개수];
		int[] akor2 = new int[5];
		
		//첫 번째 학생의 국어 점수를 사용자로부터 입력 받아서 배열 내의 첫 번재 변수인 변수명[0]에 보관
		System.out.print("첫 번째 학생의 국어 점수를 정수로 입력하세요: ");
		akor[0]=scanner.nextInt();
		System.out.println("사용자가 입력한 국어 점수는 "+akor[0]);
		
		/*
		 * 배열과 반복문을 함께 사용하는 형식
		 * 1. for 반복문과 함께 사용
		 * 	- for(int 인덱스변수명=0; 인덱스변수명<개수; 인덱스변수명++) {
		 * 		문장;
		 * 	}
		 * 2. while 반복문과 함께 사용
		 * 3. 컴파일러가 배열의 크기 값을 보관하는 임시 변수인 length를 생성
		 * 	예) int[] 변수명 = new int[5];
		 * 		- length 변수는 5를 자동으로 보관
		 * 		- length 변수를 사용하는 형식: 변수명 + 점(.) + length
		 */
		System.out.println("임시변수인 length의 값은 "+akor.length);
		for(int i=0; i<akor.length; i++) {
			System.out.print((i+1)+"번째 학생의 국어 점수를 정수로 입력하세요: ");
			akor[i] = scanner.nextInt();
			System.out.println("사용자가 입력한 국어 점수는 "+akor[i]);
		}
		
		
		
		scanner.close();
		System.out.println("프로그램이 종료됩니다.");
	}

}
