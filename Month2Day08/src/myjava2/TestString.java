package myjava2;
/*
 * 1. 제목: String 클래스가 갖고 있는 concat() 메소드를 사용해서 서로 분리되어 있는 문자열을 하나로 합치기
 * 	-> 이유: 메모리 공간을 효율적으로 사용하기 위함
 */
public class TestString {

	public static void main(String[] args) {
		
		String a = new String("서울시");
		String b = new String("마포구");
		String c = new String("합정동");
		String d = new String("00아파트");
		String e = new String("0동");
		String f = new String("0호");
		
		System.out.println("시는 " + a);
		System.out.println("구는 " + b);
		System.out.println("동는 " + c);
		System.out.println("아파트 이름은 " + d);
		System.out.println("아파트 동은 " + e);
		System.out.println("아파트 호수는 " + f);
		
		// 1. concat() 함수를 사용해서 "서울시" + " " + "마포구" -> "서울시 마포구"
		String result1 = a.concat(" ");
		String result2 = result1.concat(b);
		System.out.println(result2);
		
		// 2. 위에서 "서울시 마포구" 문자열을 생성
		// 3. 아래에 concat() 함수를 사용해서 "서울시 마포구 합정동 00아파트 0동 0호"
		String result3 = result2.concat(" ");
		String result4 = result3.concat(c);
		String result5 = result4.concat(" ");
		String result6 = result5.concat(d);
		String result7 = result6.concat(" ");
		String result8 = result7.concat(e);
		String result9 = result8.concat(" ");
		String result10 = result9.concat(f);
		System.out.println(result10);
		
		
	}

}
