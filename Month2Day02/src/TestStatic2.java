/*
 * 1. ����: static �޼ҵ带 ���� ����ϴ� ���: java.lang.Math Ŭ������ ���
 */

public class TestStatic2 {
	
	/*
	 * java.lang.Math.max() �޼ҵ带 �䳻����
	 * 1. static �����ڸ� ����ؼ� �޼ҵ带 ����
	 */

	public static int max(int a, int b) {
		if (a>b) {
			return a;
		} 
		else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		// 1. max() �Լ��� ����ؼ� 2���� �� �߿��� ū ���� ���ϱ�
		int max_number = java.lang.Math.max(2, 3);
		System.out.println("2�� 3 �߿��� ū ������ "+ max_number);
		
		// 2. min() �Լ��� ����ؼ� 2���� �� �߿��� ���� ���� ���ϱ�
		int min_number = java.lang.Math.min(2, 3);
		System.out.println("2�� 3 �߿��� ���� ������ "+ min_number);
		
		// 3. pow() �Լ��� ����ؼ� ���� ���̸� ���ϱ�
		double circle_area = 3.14 * Math.pow(2, 2);
		System.out.println("���� ���̴� "+ circle_area);
		
		// 4. abs() �Լ��� ����ؼ� ���밪�� ���ϱ�: absolute(���밪)�� ���
		double abs_number = Math.abs(-3.5);
		System.out.println("���� -3.5�� ���밪�� "+ abs_number);
		
		// ��� static���� �̷���� �ֱ� ������ new�� ������� ����
		
		// 5. ������ ������ max() �Լ��� ȣ��
		max_number = TestStatic2.max(2, 3);
		System.out.println("2�� 3 �߿��� ū ������ "+ max_number);
	}

}
