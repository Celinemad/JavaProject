/*
 * 1.제목: 배열을 사용해서 같은 종류의 데이터들(변수들)을 하나의 같은 이름으로 묶기
 */
import java.util.Scanner;
import java.util.Random;

public class Class1 {

	public static void main(String[] args) {
		//1. 배열 선언 + 변수 생성 명령어를 분리
		int[] arr1;
		arr1 = new int[5]; //5-> 개발자가 크기를 지정할수도, 사용자에게 임의의 값을 받아와서 배열의 크기를 지정할수도 있음.
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		//2. 배열 선언 + 초기화 명령어: 값의 갯수는 개발자 마음대로 설정 가능
		int[] arr2 = {1,2,3,4,5};
		int[] arr3 = {0,1,2,3,4,5};
		//강제로 줄 바꿈
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		//3. 배역 arr3의 모든 값들을 출력
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		
		//1. Scanner 변수를 생성
		Scanner scanner = new Scanner(System.in);
		//2. 배열 선언
		int[] arr4;
		//3. 사용자에게 배열의 크기를 정수로 입력 요청하기
		System.out.print("배열의 크기를 정수로 입력하세요(0보다 큰 정수): ");
		//4. nextInt() 메소드를 실행하기
		int arr_size = scanner.nextInt();
		//5. if 조건문을 작성하기
		if(arr_size > 0) {
			System.out.println("사용자가 입력한 정수는 0보다 큼");
			//6. new 연산자를 사용해서 사용자가 입력한 정수만큼 크기를 갖는 배열을 생성
			arr4 = new int[arr_size];
			//7. 배열 생성 성공 메시지를 출력
			System.out.println("배열을 생성!");
			//8. 배열의 크기를 출력
			System.out.println("배열의 크기는 "+ arr4.length);
			//9. 배열의 크기만큼 사용자로부터 정수를 입력 받는 for반복문을 작성
			for(int i=0; i<arr4.length; i++) {
				System.out.print((i+1)+"번째 정수를 입력하세요: ");
				arr4[i] = scanner.nextInt();
				System.out.println("사용자가 입력한 정수는 "+arr4[i]);
			}
			System.out.println(arr4);
		} else {
			System.out.println("사용자가 입력한 정수는 0보다 같거나 작음");
			System.out.println("배열을 생성할 수 없습니다!");
			System.exit(-1);
		}
		
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}

}
