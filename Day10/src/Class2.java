/*
 * 1. 제목: 사용자로부터 5개의 양수를 입력받아서 정수형 배열에 저장 + 가장 큰 수를 찾아서 출력
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("배열에서 가장 큰 정수를 찾는 프로그램을 시작합니다...");
		
		int[] arr1 = new int[5];
		int max_num = Integer.MIN_VALUE;
		
		//1. for 반복문을 사용해서 사용자로부터 5개의 정수를 입력받기
		//	-> 단, 사용자가 양수를 입력한 경우에만 배열 arr1에 저장하기
		//		-> for 반복문 안에서 if 조건문을 작성해야 합니다.
		for(int i=0; i<arr1.length; i++) {
			System.out.print((i+1)+"번째 정수를 입력하세요:");
			arr1[i] = scanner.nextInt();
			if (arr1[i] > 0) {
				System.out.println("사용자가 입력한 정수는 "+ arr1[i]);
			} else {
				System.out.println("사용자가 입력한 정수는 0보다 작거나 같음");
				System.out.println("배열을 생성할 수 없습니다!");
				System.exit(-1);
			}
		}
		//2. 가장 큰 수를 출력
		for(int i=0; i<arr1.length; i++) {
			if (max_num < arr1[i]) {
				max_num = arr1[i];
			}
		}
		System.out.println("배열에서 가장 큰 정수는 " + max_num);
		
		System.out.println();
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
		scanner.close();
		
		System.out.println("프로그램을 종료합니다.");
	}

}
