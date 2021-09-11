
public class Class1 {

	public static void main(String[] args) {
		
		byte a=10;
		byte b=20;
		int c = a+b;
		System.out.println(c);
		
		// 데이터 유실 현상이 발생할 수 있다. (byte범위: -128~127, int범위: -약21억~21억)
		byte d = (byte)(a+b);
		System.out.println(d);
		
		int aa=1;
		System.out.println(aa);
		// 전위 증가: ++변수명;
		++aa; // a = a + 1; 명령어의 실행 결과와 동일
		System.out.println(aa); // 2가 출력
		// 후위 증가: 변수명++;
		aa++;
		System.out.println(aa); // 3이 출력
		
		// --연산자를 사용해서 변수 aa의 값을 하나만 감소
		--aa;
		System.out.println(aa); // 2
		aa--;
		System.out.println(aa); // 1
		aa=aa-1;
		System.out.println(aa); // 0
		aa=aa+1;
		System.out.println(aa); // 1
		
		/*
		 * 전위 증가 연산자인 ++가 대입 연산자인 =와 함께 사용
		 * 1. int bb = ++aa; // 전위증가 -> 먼저 변수 aa의 값을 증가시키고 그 결과를 변수 bb에 대입
		 * 2. System.out.println("변수 aa의 값은 " + aa +", 변수 bb의 값은 " + bb);
		 * 
		 * 
		 */
		
		int bb = ++aa;
		System.out.println("변수 aa의 값은 "+aa+"변수 bb의 값은 "+bb);
		
		/*
		 * 후위 증가 연산자인 ++가 대입 연산자인 =와 함께 사용
		 * 1. int cc=aa++;
		 *     -> 후위 증가: 먼저 변수 aa의 값을 변수 cc에 대입. 그 다음에 변수 aa의 값을 하나 증가
		 *         -> 결과: 변수 aa의 값이 변수 cc의 값보다 1만큼 더 큽니다.
		 */
		
		int cc=aa++;
		System.out.println("변수 aa의 값은 "+aa+"변수 cc의 값은 "+cc);
		
		/*
		 * --연산자와 =대입 연산자를 함께 사용
		 * 1. 전위 감소 명령어 형식: 데이터타입 변수명2 =--변수명;
		 *     -> System.out.println(변수명2 + "," + 변수명);
		 * 2. 후위 감소 명령어 형식: 데이터타입 변수명 = 변수명--;
		 *     -> System.out.println(변수명2 + "," + 변수명);
		 */
		
		int num = 1;
		int num1 = -- num;
		System.out.println(num1+","+num);
		
		num1 = num--;
		System.out.println(num1+","+num);
		
		/*
		 * 복합 대입 연산자를 사용해서 한번에 덧셈 계산 + 대입 연산을 수행하기
		 * 1. int 변수명 = 값;
		 * 예) int dd = 10;
		 * dd+=5;
		 * System.out.println(dd);
		 */
		
		int dd = 10;
		// 계산 전에 현재 변수 dd 값의 출력: 이유는 나중에 게산 후에 올바른 계산 여부를 확인할 때 사용
		System.out.println(dd);
		// += 복합 대입 연산자를 사용해서 10+5 덧셈계산을 수행하고 결과인 15를 다시 변수 dd에 대입
		dd+=5;
		System.out.println(dd);
		
		int numb1 = 5;
		
		numb1 = numb1 + 1;
		System.out.println(numb1);
		// numb2 = numb1 + 1;
		// System.out.println(numb1);
		
		/*
		 * 1. 비교 연산자들을 사용ㅎ서 값의 크기를 비교하기
		 * 1) > (크다)
		 * 2) < (작다)
		 * 3) >= (커도 참, 같아도 참)
		 * 4) <= (작아도 참, 같아도 참)
		 * 5) == (같아야 참)
		 * 6) != (달라야 참)
		 */
		int g = 10;
		int h = 20;
		
		boolean result = g>h;
		System.out.println(result);
		
		result = g<h;
		System.out.println(result);
		
		g = 10;
		h = 5;
		result = g>=h;
		System.out.println(result);
		
		h=g;
		result = g>=h;
		System.out.println(result);
		
		g=5;
		h=g;
		result = g!=h;
		System.out.println(result);
		
		// 문자 비교: 제한 사항은 한 글자만 비교: '알파벳문자' 비교연산자 '알파벳문자'
		// 예) 'A' == 'B'
		char ch1 = 'A';
		char ch2 = 'B';
		result = ch1==ch2;
		System.out.println(result);
		
		ch2 = ch1;
		result = ch1==ch2;
		System.out.println(result);
	}	
	

}
