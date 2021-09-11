/*
 * 1. 다차원 배열: 2차원 배열 이상의 배열
 * 1) 2차원 배열: 1차원 배열 여러 개를 하나로 묶음
 * 2) 3차원 배열: 2차원 배열 여러 개를 하나로 묶음
 * ...
 * n차원 배열까지 선언 가능
 * -> 실무에서는 1차원, 2차원 배열이 가자 많이 사용
 */
import java.util.Random;
import java.util.Scanner;
public class Class4 {

	public static void main(String[] args) {
		/*
		 * 1. 1차원 배열을 사용해서 3행 5열을 표현
		 * 	-> 하나의 일차원 배열은 행을 뜻함
		 */
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int[] arr3 = new int[5];
		Scanner scanner = new Scanner(System.in);
		//2. 사용자로부터 5개의 정수(음수, 0, 양수)를 입력받는 for 반복문
		for(int i=0; i<arr1.length; i++) {
			System.out.print((i+1)+"번째 정수를 입력하세요: ");
			arr1[i]=scanner.nextInt();
			System.out.println("사용자가 입력한 정수는 "+arr1[i]);
		}
		
		/*
		 * 3. 위에서 선언한 3개의 1차원 배열을 하나로 묶기: 2차원 배열을 선언
		 * 1) 형식: 데이터타입[][] 참조 변수명 = new 데이터타입[행][열];
		 * 	-> 행은 1차원 배열의 갯수, 열은 1차원 배열의 크기
		 */
		int[][] arr4 = new int[3][5];
		//4. 중첩 for반복문을 사용해서 사용자로부터 정수를 입력 받아서 2차원 배열에 저장
		System.out.println("2차원 배열 arr4의 행의 갯수는 "+arr4.length);
		System.out.println("2차원 배열 arr4의 첫 번째 행의 열의 갯수는 "+ arr4[0].length);
		System.out.println("2차원 배열 arr4의 두 번째 행의 열의 갯수는 "+ arr4[1].length);
		System.out.println("2차원 배열 arr4의 세 번째 행의 열의 갯수는 "+ arr4[2].length);
		for(int i=0; i<arr4.length;i++) {
			for(int j=0; j<arr4.length;j++) {
				System.out.print("행은 "+i+" 열은 "+j+" 값은 "+arr4[i][j]+" ");
			}
			System.out.println();
		}
		
	
		/*
		 * 5. 사용자로부터 2차원 배열의 행의 갯수와 열의 갯수를 입력받기
		 */
		int[][] arr5;
		System.out.print("2차원 배열의 행의 갯수를 입력하세요: ");
		int row_size = scanner.nextInt();
		System.out.print("2차원 배열의 열의 갯수를 입력하세요: ");
		int col_size = scanner.nextInt();
		arr5 = new int[row_size][col_size];
		for(int i=0; i<arr5.length;i++) {
			for(int j=0;j<arr5.length;j++) {
				System.out.print("정수를 입력하세요: ");
				arr5[i][j] = scanner.nextInt();
				System.out.println("사용자가 입력한 정수는 "+arr5[i][j]);
				
			}
		}
		/*
		 * 6. 3차원 배열을 선언
		 * 1) 3차원 배열은 2차원 배열이 여러 개 있을 때 하나로 묶는 방법
		 * 2) 형식: 데이터타입[][][] 변수명;
		 * 		- 첫 번째 대괄호 연산자: 면(표 여러개를 하나로 묶음)
		 * 		- 두 번째 대괄호 연산자: 행
		 * 		- 세 번째 대괄호 연산자: 열
		 * 	3) 예제: int[][][] arr6;
		 */
		int[][][] arr6 = new int[2][3][4];
		//3개의 for 반복문을 사용
		//1. 첫번째 for 반복문: 면을 제어(2개:0~1)
		for (int i=0; i<arr6.length; i++) {
			for(int j=0; j<arr6[i].length; j++) {
				for(int k=0; k<arr6[i][j].length; k++) {
					System.out.print(arr6[i][j][k]+" ");
				}System.out.println();
			}System.out.println();
		}
		scanner.close();
	}
}
