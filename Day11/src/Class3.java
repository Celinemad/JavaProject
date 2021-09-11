/*
 * 1. 제목: 10진수를 2진수로 변환하기
 * 	1) Integer.toBinaryString() 함수의 알고리즘 흉내내기
 * 	2) 반복적으로 수행할 명령어: 나눗셈 계산 후에 몫과 나머지를 구하기,
 * 		나머지는 다른 변수에 저장
 * 		-> 출력할 때 나머지를 역순으로 사용(마지막에 구한 나머지를 먼저 출력)
 */
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("10진수를 정수로 입력하세요: ");
		int num = scanner.nextInt();
		int arr1[] = new int[32];
		int i = 0;
		while(num>=2) {
			// a+=num%2;
			arr1[i] = num % 2;
			num = num/2;
			i++;
			System.out.println(arr1[i]);
		}
		arr1[i] = num % 2;
		for(i= arr1.length-1; i>=0; i--) {
			System.out.print(arr1[i]);
		}
		
		
		
//		//1. left shift 연산자인 <<를 사용해서 2진수 곱셈 계산을 수행
//		//예) 2<<2 -> 2*2의 2제곱 -> 결과는 8
//		int a = 2<<2;
//		System.out.println("2 << 2 왼쪽 비트 이동 결과는 "+ a);
//		//2. 별표 연산자인 *를 사용해서 곱셈 계산을 수행
//		a = 2 * 4;
//		System.out.println(a);
//		a = 2 * 2 * 2;
//		System.out.println(a);
//		
//		//3. right shift 연산자인 >>를 사용하기: 2진수 나눗셈 계산을 수행하고 몫을 반환
//		System.out.println("현재 변수 a의 값은 "+ a);
//		//4. 8 >> 2  ->  8 / 2의 2제곱  ->  8 / 4  ->  2
//		a = a >> 2;
//		System.out.println(a);
//		//5. / 기호를 사용해서 2진수 나눗셈 계산을 수행하기
//		a = 8 / 4;
//		System.out.println(a);
	}

}
