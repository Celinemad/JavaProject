/*
 * 1. ����: ����ڷκ��� ���� �ܰ� �� ���� �Է� �޾Ƽ� ���� �ܿ��� �� �ܿ� �ִ� ��� �ܵ��� ����ؼ� ���
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		//1. ���� ���� ������ ���� start ����
		int start;
		//2. �� ���� ������ ���� end ����
		int end; 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� ���� ������ �Է��ϼ���: ");
		start = scanner.nextInt();
		System.out.print("�� ���� ������ �Է��ϼ���: ");
		end = scanner.nextInt();
		
		System.out.println("\n���� ���� "+start+", �� ���� "+end);
		
//		//����ڰ� ������ �Է��� ���
//		if (start<0) {
//			start *= -1;
//			if (end<0) {
//				end *= -1;
//			} 
//			else {
//				;
//			}
//		}
		
		if (start<=end) {
			for(int dan = start; dan<=end; dan++) {
				System.out.printf("\n***%d��***\n", dan);
				for(int num = 1; num<=9; num++) {
					System.out.printf("%d * %d = %d\n", dan, num, dan*num);
				}
			}
		}
		else {
			for(int dan = end; dan<=start; dan++) {
				System.out.printf("\n***%d��***\n", dan);
				for(int num = 1; num<=9; num++) {
					System.out.printf("%d * %d = %d\n", dan, num, dan*num);
				}
			}
		}
		
		
		
	}

}
