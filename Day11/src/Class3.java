/*
 * 1. ����: 10������ 2������ ��ȯ�ϱ�
 * 	1) Integer.toBinaryString() �Լ��� �˰��� �䳻����
 * 	2) �ݺ������� ������ ��ɾ�: ������ ��� �Ŀ� ��� �������� ���ϱ�,
 * 		�������� �ٸ� ������ ����
 * 		-> ����� �� �������� �������� ���(�������� ���� �������� ���� ���)
 */
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("10������ ������ �Է��ϼ���: ");
		int num = scanner.nextInt();
		int arr1[] = new int[32];
		int i = 0;
		while(num>=2) {
			// a+=num%2;
			arr1[i] = num % 2;
			num = num/2;
			i++;
			System.out.println(arr1[i]);
		}
		arr1[i] = num % 2;
		for(i= arr1.length-1; i>=0; i--) {
			System.out.print(arr1[i]);
		}
		
		
		
//		//1. left shift �������� <<�� ����ؼ� 2���� ���� ����� ����
//		//��) 2<<2 -> 2*2�� 2���� -> ����� 8
//		int a = 2<<2;
//		System.out.println("2 << 2 ���� ��Ʈ �̵� ����� "+ a);
//		//2. ��ǥ �������� *�� ����ؼ� ���� ����� ����
//		a = 2 * 4;
//		System.out.println(a);
//		a = 2 * 2 * 2;
//		System.out.println(a);
//		
//		//3. right shift �������� >>�� ����ϱ�: 2���� ������ ����� �����ϰ� ���� ��ȯ
//		System.out.println("���� ���� a�� ���� "+ a);
//		//4. 8 >> 2  ->  8 / 2�� 2����  ->  8 / 4  ->  2
//		a = a >> 2;
//		System.out.println(a);
//		//5. / ��ȣ�� ����ؼ� 2���� ������ ����� �����ϱ�
//		a = 8 / 4;
//		System.out.println(a);
	}

}
