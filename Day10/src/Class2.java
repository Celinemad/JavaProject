/*
 * 1. ����: ����ڷκ��� 5���� ����� �Է¹޾Ƽ� ������ �迭�� ���� + ���� ū ���� ã�Ƽ� ���
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�迭���� ���� ū ������ ã�� ���α׷��� �����մϴ�...");
		
		int[] arr1 = new int[5];
		int max_num = Integer.MIN_VALUE;
		
		//1. for �ݺ����� ����ؼ� ����ڷκ��� 5���� ������ �Է¹ޱ�
		//	-> ��, ����ڰ� ����� �Է��� ��쿡�� �迭 arr1�� �����ϱ�
		//		-> for �ݺ��� �ȿ��� if ���ǹ��� �ۼ��ؾ� �մϴ�.
		for(int i=0; i<arr1.length; i++) {
			System.out.print((i+1)+"��° ������ �Է��ϼ���:");
			arr1[i] = scanner.nextInt();
			if (arr1[i] > 0) {
				System.out.println("����ڰ� �Է��� ������ "+ arr1[i]);
			} else {
				System.out.println("����ڰ� �Է��� ������ 0���� �۰ų� ����");
				System.out.println("�迭�� ������ �� �����ϴ�!");
				System.exit(-1);
			}
		}
		//2. ���� ū ���� ���
		for(int i=0; i<arr1.length; i++) {
			if (max_num < arr1[i]) {
				max_num = arr1[i];
			}
		}
		System.out.println("�迭���� ���� ū ������ " + max_num);
		
		System.out.println();
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
		scanner.close();
		
		System.out.println("���α׷��� �����մϴ�.");
	}

}
