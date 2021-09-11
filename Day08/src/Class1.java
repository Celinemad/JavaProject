/*
 * 1. 제목(주제 또는 목적): 중첩 for 반복문을 사용해서 구구단을 화면에 출력
 * 
 * 2. 구구단 출력 형식
 * ***2단***
 * 2*1=2
 * 2*2=4
 * 2*3=6
 * 2*4=8
 * 2*5=10
 * 2*6=12
 * 2*7=14
 * 2*8=16
 * 2*9=18
 * ***3단***
 * ...
 * ***9단***
 * ...
 * 프로그램을 종료합니다.
 * 
 */
public class Class1 {

	public static void main(String[] args) {
		
		//1. for 반복문을 사용해서 중첩 구조를 작성
		for(int dan=2; dan<=9; dan++) {
			
			//2. 단마다 제목을 출력
			System.out.printf("\n***%d***\n", dan);
			
			for(int num=1; num<=9; num++) {
				//3. 각 단마다 1~9까지 곱해서 결과를 출력
				//	-> 형식: 2*1=2
				System.out.printf("%d * %d = %d\n", dan, num, dan*num);
				
				
			}
		}
		//바깥쪽 for 반복문을 벗어난 위치에서 프로그램을 종료합니다. 메시지를 한번만 출력
		System.out.println("프로그램을 종료합니다.");
	}

}
