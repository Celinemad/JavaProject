package myjava1;
/*
 * 1. ����: ����� ������ �� �ִ� ������ ��ǻ�Ͱ� ������ �� �ִ� �������� ��ȯ�ϴ� ����
 * 	1) �������� ���������� ��ȯ
 * 	2) ������ ���İ� ������ ������ ���
 */
import java.util.*;

public class TestOperatorStack {
	
	/*
	 * ������ �ϳ��� ���� �켱������ ������ ��ȯ�ϴ� �Լ��� ����
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
		// 2. ���Ƚ� ������ ��� ���ڿ��� ������Ű��
		final String INFIX_NOTATION = "3+4";
		final String INFIX_NOTATION2 = "3+4*5";
		final String INFIX_NOTATION3 = "(3+4)*5";
		
		// �����ڵ��� ����� ���� ��ü�� ����
		Stack<Character> operatorStack = new Stack<Character>();
		
		/*
		 * 3. while �ݺ����� ����ؼ� INFIX_NOTATION ���ڿ����� �ϳ��� ���ڸ� �о����
		 * 	-> 1) �ʿ��� �������� ����:
		 * 	   -> ������ ��ġ�� ������ ����: int index;
		 *     -> ���ڸ� �ӽ÷� ������ ����: char ch;
		 *     -> ������ �� ������ ������ ����: int ������;
		 */
		int index = 0;
		int length = INFIX_NOTATION.length();
		while(index < length) {
			char ch = INFIX_NOTATION.charAt(index);
			// 4. �о�� ���ڰ� �����̸� ȭ�鿡 �ٷ� ���
			if(Character.isDigit(ch)) {
				System.out.print(ch);
				index++;
			}
			// 5. �о�� ���ڰ� �������̸�...
			else if(ch == '*' || ch == '/' || ch == '+' || ch == '-') {
				operatorStack.push(ch);
				index++;
				if(getPrecedence(ch)<=getPrecedence(operatorStack.peek())){
					operatorStack.pop();
				}
			}
			// 6. �о�� ���ڰ� ���� �Ұ�ȣ '('�̸� ���ÿ� ����
			else if(ch == '(') {
				operatorStack.push(ch);
				index++;
			}
			// 7. �о�� ���ڰ� �ݴ� �Ұ�ȣ ')'�̸�..
			else if(ch == ')') {
			
			}
		}
	}

}
