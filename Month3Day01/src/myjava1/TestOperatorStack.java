package myjava1;
/*
 * 1. 제목: 사람이 이해할 수 있는 수식을 컴퓨터가 이해할 수 있는 수식으로 변환하는 예제
 * 	1) 중위법을 후위법으로 변환
 * 	2) 중위법 수식과 후위법 수식을 출력
 */
import java.util.*;

public class TestOperatorStack {
	
	/*
	 * 연산자 하나에 대한 우선순위를 정수로 반환하는 함수를 정의
	 */
	public static int getPrecedence(char op) {
		if(op == '(') {
			return 1;
		} else if (op == '+' || op == '-') {
			return 2;
		} else if (op == '*' || op == '/' || op == '%') {
			return 3;
		} else {
			return 4;
		}
	}
	public static void main(String[] args) {
		// 2. 인픽스 수식을 상수 문자열로 고정시키기
		final String INFIX_NOTATION = "3+4";
		final String INFIX_NOTATION2 = "3+4*5";
		final String INFIX_NOTATION3 = "(3+4)*5";
		
		// 연산자들이 저장될 스택 객체를 생성
		Stack<Character> operatorStack = new Stack<Character>();
		
		/*
		 * 3. while 반복문을 사용해서 INFIX_NOTATION 문자열에서 하나씩 문자를 읽어오기
		 * 	-> 1) 필요한 변수들을 선언:
		 * 	   -> 문자의 위치를 제어할 변수: int index;
		 *     -> 문자를 임시로 저장할 변수: char ch;
		 *     -> 문자의 총 갯수를 저장할 변수: int 변수명;
		 */
		int index = 0;
		int length = INFIX_NOTATION.length();
		while(index < length) {
			char ch = INFIX_NOTATION.charAt(index);
			// 4. 읽어온 문자가 숫자이면 화면에 바로 출력
			if(Character.isDigit(ch)) {
				System.out.print(ch);
				index++;
			}
			// 5. 읽어온 문자가 연산자이면...
			else if(ch == '*' || ch == '/' || ch == '+' || ch == '-') {
				operatorStack.push(ch);
				index++;
				if(getPrecedence(ch)<=getPrecedence(operatorStack.peek())){
					operatorStack.pop();
				}
			}
			// 6. 읽어온 문자가 여는 소괄호 '('이면 스택에 저장
			else if(ch == '(') {
				operatorStack.push(ch);
				index++;
			}
			// 7. 읽어온 문자가 닫는 소괄호 ')'이면..
			else if(ch == ')') {
			
			}
		}
	}

}
