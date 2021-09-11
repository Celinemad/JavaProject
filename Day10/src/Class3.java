/*
 * 1.����: JDK 1.5���� �߰��� for-each�ݺ����� ����ϱ�
 * 	-> for(int ������=0; ������<�迭_����_������.length; ������++) ������ ����ȭ(����ȭ)
 * 		-> ����: �������� �Ǽ��� ���� �ݺ��� �Ǵ� ������ �߻� ����
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
		
		//�����ڰ� �Ǽ��� �� �ִ� �Ʒ��� ���� ��츦 ����
//		for(int i=0;i<arr1.length;) {
//			System.out.print(arr1[i]+" ");
//		}
//		System.out.println();
	}

}
