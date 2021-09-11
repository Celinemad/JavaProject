/*
 * 1.제목: JDK 1.5부터 추가된 for-each반복문을 사용하기
 * 	-> for(int 변수명=0; 변수명<배열_참조_변수명.length; 변수명++) 형식을 간소화(간결화)
 * 		-> 이유: 개발자의 실수로 무한 반복문 또는 오류가 발생 가능
 */
import java.util.Scanner;
import java.util.Random;

public class Class3 {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		Random random = new Random();
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = random.nextInt(6)+1;
		}
		System.out.println();
		for(int a: arr1) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		//개발자가 실수할 수 있는 아래와 같은 경우를 예방
//		for(int i=0;i<arr1.length;) {
//			System.out.print(arr1[i]+" ");
//		}
//		System.out.println();
	}

}
