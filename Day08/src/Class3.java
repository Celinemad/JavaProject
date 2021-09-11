/*
 * 1. 제목: java.lang.Math 클래스의 random() 함수를 사용해서 0.0~1.0 미만의 임의의 실수를 생성해서 출력
 * 
 * 2. 1~6 사이에 있는 임의의 정수를 출력
 * 
 * 3. 랜덤한 숫자를 사용해서 가위/바위/보 게임을 구현하기
 */
import java.util.Random;

public class Class3 {

	public static void main(String[] args) {
	
		//1. java.lang.Math.random() 함수를 사용해서 0.0~1.0 미만에 있는 임의의 실수를 생성해서 변수 a에 보관
		double a = java.lang.Math.random();
		//2. println() 함수를 사용해서 실수 난수를 출력
		System.out.println("새로 생성한 실수 난수는 " + a);
		//3. 총 10번 임의의 실수를 만들어서 화면에 출력: for 반복문을 사용
		for(int cnt=1; cnt<=10; cnt++) {
			a = Math.random();
			System.out.println(cnt + ") 새로 생성한 실수 난수는 " + a);
		}
		/*
		 * random() 함수에서 만든 실수 난수를 정수 난수로 변환하기
		 * 1. 방법: 강제 형 변환 연산자인 (자료형)를 사용
		 * 2. 형식: int 변수명 = (int)Math.random();
		 */
		int b = (int)Math.random();
		System.out.println("새로 생성한 정수 난수는 " + b);
		//for 반복문을 사용해서 총 30개의 정수 난수를 만들기
		for(int cnt=1; cnt<=30; cnt++) {
			b = (int)(Math.random()*10);
			System.out.println(cnt + ". 새로 생성한 정수 난수는 "+ b);
		}
		/*
		 * 현재 정수 실수의 출력 내용
		 * : 새로 생성한 정수 난수는 모두 0으로 출력됨.
		 */
		
		Random random = new Random();
		int c = random.nextInt();
		System.out.println(c);
		
		c = random.nextInt(6);
		System.out.println(c);
		
		//for 반복문을 사용해서 30번 반복
		for (int cnt=1; cnt<=30; cnt++) {
			c = random.nextInt();
			System.out.println(c);
			c = random.nextInt(6)+1;
			System.out.println(c);
		}
		
		
		
	}

}
