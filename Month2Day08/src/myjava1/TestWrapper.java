package myjava1;
/*
 * 1. ����: ���� Ŭ������ Wrapper�� ����ؼ� �⺻ Ÿ���� ���� ��üȭ �ϱ�(Wrapper Ŭ������ ��� ������ ���� ����)
 */
public class TestWrapper {

	public static void main(String[] args) {
		
		// 2. Wrapper Ŭ������ �⺻ ���� �����ϱ�: valueOf() �޼ҵ带 ���
		Integer a = Integer.valueOf(100);
		// �߰�: intValue() �޼ҵ带 ȣ���ؼ� 100�� ��������
		int value = a.intValue();
		System.out.println("�⺻ �� 100�� ������ ����� " + value);
		
		float value2 = a.floatValue();
		System.out.println("�⺻ �� 100�� float Ÿ�̺�� �ٲ� ����� " + value2);
		
		
		// 3. valueOf(�⺻��: ���� �Ǵ� "����")
		Integer b = Integer.valueOf("100");
		
		Double c = Double.valueOf(3.14);
		Double d = Double.valueOf("3.14");
		double value3 = c.doubleValue();
		System.out.println("�Ǽ� 3.14�� ������ ����� "+ value3);
		
		Boolean e  = Boolean.valueOf(true);
		Boolean f = Boolean.valueOf("true");
		boolean value4 = e.booleanValue();
		System.out.println("���� true�� ������ ����� " + value4);
		
		Character g = Character.valueOf('a');
		// ������ ��: Character Ŭ������ ���� �ִ� valueOf() �޼ҵ�� �Ѱ���: valueOf('�ϳ��� ����')
		char value5 = g.charValue();
		System.out.println("�ϳ��� ������ a�� ������ ����� "+ value5);
		
		/* 
		 * 10������ 2������ ��ȯ: Integer Ŭ������ toBinaryString() �޼ҵ带 ���
		 * 	1) ����) String ������ = Integer.toBinaryString(10��_ ����);
		 */
		String binaryString = Integer.toBinaryString(10);
		System.out.println("10���� 10�� 2������ ��ȯ�� ����� "+ binaryString);
		
		// 2) 10���� 8������ ��ȯ(����� ���ڿ�)
		String octalString = Integer.toOctalString(10);
		System.out.println("10���� 10�� 8������ ��ȯ�� ����� " + octalString);
		
		// 3) 10������ 16������ ��ȯ
		String hexString = Integer.toHexString(10);
		System.out.println("10���� 10�� 16������ ��ȯ�� ����� " + hexString);
		
		// 4) toUpperCase(), toLowerCaser() �޼ҵ带 ����
		char ch_a = Character.toLowerCase('A');
		char ch_b = Character.toUpperCase('a');
		System.out.println("���ĺ� A�� �ҹ��ڷ� ��ȯ�� ����� " + ch_a);
		System.out.println("���ĺ� a�� �빮�ڷ� ��ȯ�� ����� " + ch_b);
		
		// 5) isDigit() �޼ҵ带 ����
		boolean b_a = Character.isDigit('5');
		System.out.println("5�� �����ΰ���? ����� "+ b_a);
		
		boolean b_b = Character.isDigit('a');
		System.out.println("a�� �����ΰ���? ����� " + b_b);
		
		// 6) isAlphabetic() �޼ҵ带 ����
		boolean b_c = Character.isAlphabetic('a');
		System.out.println(b_c);  
		
		boolean b_d = Character.isAlphabetic('A');
		System.out.println(b_d);
		
		boolean b_e = Character.isAlphabetic('5');
		System.out.println(b_e);
		
		/*
		 * JDK 1.5���� �����Ǵ� �ڵ� �ڽ̰� �ڵ� ��ڽ� ����� ����ϱ�
		 */
		// 1. �ڵ� �ڽ�
		Integer intObject = 10;  // ==  Integer intObject = Integer.valueOf(10);
		// 2. �ڵ� ��ڽ�
		int i_a = intObject;  // ==  int i_a = intObject.intValue();
		System.out.println(i_a);
		
		
		
		
		
	}

}
