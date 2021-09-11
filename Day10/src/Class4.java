/*
 * 1. ������ �迭: 2���� �迭 �̻��� �迭
 * 1) 2���� �迭: 1���� �迭 ���� ���� �ϳ��� ����
 * 2) 3���� �迭: 2���� �迭 ���� ���� �ϳ��� ����
 * ...
 * n���� �迭���� ���� ����
 * -> �ǹ������� 1����, 2���� �迭�� ���� ���� ���
 */
import java.util.Random;
import java.util.Scanner;
public class Class4 {

	public static void main(String[] args) {
		/*
		 * 1. 1���� �迭�� ����ؼ� 3�� 5���� ǥ��
		 * 	-> �ϳ��� ������ �迭�� ���� ����
		 */
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int[] arr3 = new int[5];
		Scanner scanner = new Scanner(System.in);
		//2. ����ڷκ��� 5���� ����(����, 0, ���)�� �Է¹޴� for �ݺ���
		for(int i=0; i<arr1.length; i++) {
			System.out.print((i+1)+"��° ������ �Է��ϼ���: ");
			arr1[i]=scanner.nextInt();
			System.out.println("����ڰ� �Է��� ������ "+arr1[i]);
		}
		
		/*
		 * 3. ������ ������ 3���� 1���� �迭�� �ϳ��� ����: 2���� �迭�� ����
		 * 1) ����: ������Ÿ��[][] ���� ������ = new ������Ÿ��[��][��];
		 * 	-> ���� 1���� �迭�� ����, ���� 1���� �迭�� ũ��
		 */
		int[][] arr4 = new int[3][5];
		//4. ��ø for�ݺ����� ����ؼ� ����ڷκ��� ������ �Է� �޾Ƽ� 2���� �迭�� ����
		System.out.println("2���� �迭 arr4�� ���� ������ "+arr4.length);
		System.out.println("2���� �迭 arr4�� ù ��° ���� ���� ������ "+ arr4[0].length);
		System.out.println("2���� �迭 arr4�� �� ��° ���� ���� ������ "+ arr4[1].length);
		System.out.println("2���� �迭 arr4�� �� ��° ���� ���� ������ "+ arr4[2].length);
		for(int i=0; i<arr4.length;i++) {
			for(int j=0; j<arr4.length;j++) {
				System.out.print("���� "+i+" ���� "+j+" ���� "+arr4[i][j]+" ");
			}
			System.out.println();
		}
		
	
		/*
		 * 5. ����ڷκ��� 2���� �迭�� ���� ������ ���� ������ �Է¹ޱ�
		 */
		int[][] arr5;
		System.out.print("2���� �迭�� ���� ������ �Է��ϼ���: ");
		int row_size = scanner.nextInt();
		System.out.print("2���� �迭�� ���� ������ �Է��ϼ���: ");
		int col_size = scanner.nextInt();
		arr5 = new int[row_size][col_size];
		for(int i=0; i<arr5.length;i++) {
			for(int j=0;j<arr5.length;j++) {
				System.out.print("������ �Է��ϼ���: ");
				arr5[i][j] = scanner.nextInt();
				System.out.println("����ڰ� �Է��� ������ "+arr5[i][j]);
				
			}
		}
		/*
		 * 6. 3���� �迭�� ����
		 * 1) 3���� �迭�� 2���� �迭�� ���� �� ���� �� �ϳ��� ���� ���
		 * 2) ����: ������Ÿ��[][][] ������;
		 * 		- ù ��° ���ȣ ������: ��(ǥ �������� �ϳ��� ����)
		 * 		- �� ��° ���ȣ ������: ��
		 * 		- �� ��° ���ȣ ������: ��
		 * 	3) ����: int[][][] arr6;
		 */
		int[][][] arr6 = new int[2][3][4];
		//3���� for �ݺ����� ���
		//1. ù��° for �ݺ���: ���� ����(2��:0~1)
		for (int i=0; i<arr6.length; i++) {
			for(int j=0; j<arr6[i].length; j++) {
				for(int k=0; k<arr6[i][j].length; k++) {
					System.out.print(arr6[i][j][k]+" ");
				}System.out.println();
			}System.out.println();
		}
		scanner.close();
	}
}
