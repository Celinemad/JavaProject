/*
 * 1. �߻� Ŭ������ Calculator�� ����ؼ� GoodCalc �ڽ� Ŭ������ ����
 */

// 2. Calculator Ŭ������ �߻� Ŭ������ ����
abstract class Calculator {
	// 3. 2���� ������ �����ϴ� add() �߻� �޼����� ����
	public abstract int add(int a, int b);
	// 4. 2���� ������ �����ϴ� sub() �߻� �޼����� ����
	public abstract int sub(int a, int b);
	// 5. ���� ���������� ���� ������ �迭�� �Է����� �޴� avg() �߻� �޼����� ����
	public abstract double avg(int[] arr1);
	// �߰�: ���� ������ �߿��� ���� ū ������ ��ȯ�ϴ� max() �߻� �޼����� ����
	public abstract int max(int[] arr1);
}

// 6. Calculator �߻�Ŭ������ ��� �޴� GoodCalc �ڽ� Ŭ������ ����
class GoodCalc extends Calculator {
	
	// ��ܿ� Source -> Override/Implement Methods ... : �������̵� �׸�� �� �ڵ����� �߰��� 
	// 	����Ű: Alt + Shift + S -> �˾�â�� ��� -> Override/Implement Methods...
	@Override
	public int max(int[] arr1) {
		int b = Integer.MIN_VALUE;
		for(int a=0; a<arr1.length; a++) {
			if(arr1[a] > b)
				b = arr1[a];
		}
		return b;
	}

	@Override
	public int add(int a, int b) {
		System.out.println("�������� add(int a, int b) �޼��尡 ȣ���");
		int c = a + b;
		return c;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("�������� sub(int a, int b) �޼��尡 ȣ���");
		int c = a - b;
		return c;
	}

	@Override
	public double avg(int[] arr1) {
		// ����� ���ϴ� ����: �迭 arr1�� ��� ��ҵ��� ���� �� ���� �� / �迭 arr1�� ����� ����
		int sum  = 0;
		for(int a = 0; a<arr1.length; a++) {
			sum += arr1[a];
		}
		double c = sum / arr1.length;
		return c;
	}
	// 7. 3���� �޼������ ������
	// -> �޼��尡 ���� ��쿡�� �޴��� ����ؼ� �ڵ����� ��ɾ ����
	// -> Source �޴��� ���� -> �˾� â�� ��� -> Override/Implement Methods... �׸��� ����
	// -> Ŭ������ �޼��带 �����ϴ� â�� ��� -> Ŭ������ �������� �޼��带 ���� 
	
}
public class TestCalculator {

	public static void main(String[] args) {
		// ���� ������ GoodCalc Ŭ������ ����ؼ� ���ο� ��ü�� ����
		GoodCalc a = new GoodCalc();
		// �������� add() �޼��带 ȣ��: 2���� ���� ���� ����
		int result = a.add(10, 20);
		// 10�� 20�� ���� ����� ȭ�鿡 ���
		System.out.printf("%d + %d = %d\n", 10, 20, result);
		// �������� sub()�޼��带 ȣ��: 2���� �������� ����
		result = a.sub(20, 10);
		// 20-10�� �� ����� ���
		System.out.printf("%d - %d = %d\n", 20, 10, result);
		// �������� avg() �޼��带 ȣ��: ������ �迭�� ����
		int[] arr1 = {1,2,3,4,5};
		double result2 = a.avg(arr1);
		System.out.println("�迭 arr1�� ��� ������ ����� "+result2);
		// å�� �ִ� ������� new �����ڸ� ����ؼ� �������� �迭�� �����ϱ�: new �ڷ���[]{��1, ��2, ��3, ..., ��n}
		result2 = a.avg(new int[] {1,2,3,4,5});
		System.out.println("�迭 int[]{1,2,3,4,5}�� ����� "+ result2);
		
		int result3 = a.max(new int[] {1,2,3,4,5});
		System.out.println("�迭 int[]{1,2,3,4,5}�� �ִ밪�� "+ result3);
	}

}
