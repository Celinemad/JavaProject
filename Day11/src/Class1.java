/*
 * 1. 제목: 예외 상황이 발생했을 때 예외정보(원인)와 어느 명령어에서 예외가 발생했는지를 출력
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		//1. try~catch~catch~...~finally
		//	finally 작성은 선택
		try {
			System.out.println(5/0);
			System.out.println("예외가 발생하지 않음");
		} catch (java.lang.ArithmeticException e1) {
			System.out.println("산술 예외 발생");
		} catch (java.lang.Exception e2) {
			System.out.println("다른 종류의 예외 발생");
		} finally {
			System.out.println("가장 마지막에 무조건 실행");
		}
		
		
		
//		try {
//			//1. 정수 5를 0으로 나누기: 0으로 나눌 수 없는 예외 상황이 발생
//			System.out.println("5를 0으로 나눈 결과는 " + (5/0));
//		} catch(Exception e) {
//			System.out.println("예외상황이 발생");
//			System.out.println("예외정보는 " + e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
//		//1. try~catch 블럭 위에 배열을 선언 + 생성
//		int[] arr1 = new int[5];
//		//2. try~catch 블럭을 작성해서 예외 상황에 대비하기(트랩: trap)
//		try {
//			arr1[0] = 1;
//			System.out.println("첫 번째 원소의 값은 "+arr1[0]);
//			arr1[5] = 2;
//			System.out.println("여섯 번재 원소의 값은 "+arr1[5]);
//		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
//		//1. 여러 개의 catch 블럭을 작성: 한 번에 여러 개의 예외들을 처리할 수 있는 구조
//		int[] arr1 = {1,2,3,4};
//		
//		//try+ Ctrl + Space: 자동완성
//		try {
//			//System.out.println("5를 0으로 나눈 결과는 "+(5/0));
//			System.out.println("배열 arr1의 여섯 번째 원소의 값은 "+arr1[5]);
//			System.out.println("예외가 발생하지 않음");
//		} catch (java.lang.ArithmeticException e1) {
//			System.out.println("산술 예외 발생");
//			e1.printStackTrace();
//		} catch(java.lang.ArrayIndexOutOfBoundsException e2) {
//			System.out.println("배열의 인덱스 예외 발생");
//			e2.printStackTrace();
//		} catch(Exception e3) {
//			//위에서 작성한 여러 catch 블럭에서 예외를 처리하지 못한 경우에 실행할 명령어
//			//	-> 새로 발생한 예외가 산술 예외도 아니고 배열의 인덱스 예외도 아닌 경우 (다중 if문에서 else의 느낌)
//			System.out.println("다른 종류의 예외가 발생");
//			e3.printStackTrace();
//		}
		
		
//		Scanner scanner = new Scanner(System.in);
//		
//		//1. NumberFormatException: 숫자 형식 예외
//		//예) java.lang.Integer.parseInt("문자");
//		try {
//			System.out.println("Integer 클래스의 parseInt() 함수를 호출하기");
//			int a = java.lang.Integer.parseInt("100");
//			//System.out.println("문자열 100를 정수로 변환하면 "+a);
//			//a = java.lang.Integer.parseInt("abc");
//			//System.out.println("문자열 abc를 정수로 변환하면 "+a);
//			//nextInt() 함수를 실행하기
//			System.out.print("정수를 입력하세요: ");
//			a = scanner.nextInt();
//			System.out.println("사용자가 입력한 정수는 "+a);
//			System.out.println("예외가 발생하지 않음");
//		} catch (java.lang.NumberFormatException e1) {
//			System.out.println("숫자 형식 예외");
//			e1.printStackTrace();
//		} catch (java.util.InputMismatchException e3) {
//			System.out.println("입력 형식 예외(정수를 문자로 입력한 경우)");
//			e3.printStackTrace();
//		}
//		//Exception 예외 타입은 여러 catch블럭 중 가장 마지막에 있어야 함
//		catch(Exception e2) {
//			System.out.println("다른 종류의 예외 상황이 발생");
//			e2.printStackTrace();
//		}
		
		
		
	}

}
