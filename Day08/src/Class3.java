/*
 * 1. ����: java.lang.Math Ŭ������ random() �Լ��� ����ؼ� 0.0~1.0 �̸��� ������ �Ǽ��� �����ؼ� ���
 * 
 * 2. 1~6 ���̿� �ִ� ������ ������ ���
 * 
 * 3. ������ ���ڸ� ����ؼ� ����/����/�� ������ �����ϱ�
 */
import java.util.Random;

public class Class3 {

	public static void main(String[] args) {
	
		//1. java.lang.Math.random() �Լ��� ����ؼ� 0.0~1.0 �̸��� �ִ� ������ �Ǽ��� �����ؼ� ���� a�� ����
		double a = java.lang.Math.random();
		//2. println() �Լ��� ����ؼ� �Ǽ� ������ ���
		System.out.println("���� ������ �Ǽ� ������ " + a);
		//3. �� 10�� ������ �Ǽ��� ���� ȭ�鿡 ���: for �ݺ����� ���
		for(int cnt=1; cnt<=10; cnt++) {
			a = Math.random();
			System.out.println(cnt + ") ���� ������ �Ǽ� ������ " + a);
		}
		/*
		 * random() �Լ����� ���� �Ǽ� ������ ���� ������ ��ȯ�ϱ�
		 * 1. ���: ���� �� ��ȯ �������� (�ڷ���)�� ���
		 * 2. ����: int ������ = (int)Math.random();
		 */
		int b = (int)Math.random();
		System.out.println("���� ������ ���� ������ " + b);
		//for �ݺ����� ����ؼ� �� 30���� ���� ������ �����
		for(int cnt=1; cnt<=30; cnt++) {
			b = (int)(Math.random()*10);
			System.out.println(cnt + ". ���� ������ ���� ������ "+ b);
		}
		/*
		 * ���� ���� �Ǽ��� ��� ����
		 * : ���� ������ ���� ������ ��� 0���� ��µ�.
		 */
		
		Random random = new Random();
		int c = random.nextInt();
		System.out.println(c);
		
		c = random.nextInt(6);
		System.out.println(c);
		
		//for �ݺ����� ����ؼ� 30�� �ݺ�
		for (int cnt=1; cnt<=30; cnt++) {
			c = random.nextInt();
			System.out.println(c);
			c = random.nextInt(6)+1;
			System.out.println(c);
		}
		
		
		
	}

}
