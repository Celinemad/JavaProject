/*
 * 1.����: �迭�� ����ؼ� ���� ������ �����͵�(������)�� �ϳ��� ���� �̸����� ����
 */
import java.util.Scanner;
import java.util.Random;

public class Class1 {

	public static void main(String[] args) {
		//1. �迭 ���� + ���� ���� ��ɾ �и�
		int[] arr1;
		arr1 = new int[5]; //5-> �����ڰ� ũ�⸦ �����Ҽ���, ����ڿ��� ������ ���� �޾ƿͼ� �迭�� ũ�⸦ �����Ҽ��� ����.
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		//2. �迭 ���� + �ʱ�ȭ ��ɾ�: ���� ������ ������ ������� ���� ����
		int[] arr2 = {1,2,3,4,5};
		int[] arr3 = {0,1,2,3,4,5};
		//������ �� �ٲ�
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		//3. �迪 arr3�� ��� ������ ���
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		
		//1. Scanner ������ ����
		Scanner scanner = new Scanner(System.in);
		//2. �迭 ����
		int[] arr4;
		//3. ����ڿ��� �迭�� ũ�⸦ ������ �Է� ��û�ϱ�
		System.out.print("�迭�� ũ�⸦ ������ �Է��ϼ���(0���� ū ����): ");
		//4. nextInt() �޼ҵ带 �����ϱ�
		int arr_size = scanner.nextInt();
		//5. if ���ǹ��� �ۼ��ϱ�
		if(arr_size > 0) {
			System.out.println("����ڰ� �Է��� ������ 0���� ŭ");
			//6. new �����ڸ� ����ؼ� ����ڰ� �Է��� ������ŭ ũ�⸦ ���� �迭�� ����
			arr4 = new int[arr_size];
			//7. �迭 ���� ���� �޽����� ���
			System.out.println("�迭�� ����!");
			//8. �迭�� ũ�⸦ ���
			System.out.println("�迭�� ũ��� "+ arr4.length);
			//9. �迭�� ũ�⸸ŭ ����ڷκ��� ������ �Է� �޴� for�ݺ����� �ۼ�
			for(int i=0; i<arr4.length; i++) {
				System.out.print((i+1)+"��° ������ �Է��ϼ���: ");
				arr4[i] = scanner.nextInt();
				System.out.println("����ڰ� �Է��� ������ "+arr4[i]);
			}
			System.out.println(arr4);
		} else {
			System.out.println("����ڰ� �Է��� ������ 0���� ���ų� ����");
			System.out.println("�迭�� ������ �� �����ϴ�!");
			System.exit(-1);
		}
		
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
	}

}
