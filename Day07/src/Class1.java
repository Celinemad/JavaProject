/*
 * 1. ����: ����(����) �������� ���ǽ� ? �� : ����; 
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		//1. ���ڿ� ������ ���İ� ���� �����ڸ� �Բ� ���
		String a = 10 == 10 ? "���ǽ��� ��" : "���ǽ� ����" ;
		System.out.println(a);
		
		int first = 10;
		int second = 20;
		
		String b = first == second ? "���ǽ��� ��" : "���ǽ��� ����";
		System.out.println(b);
		
		//2. ������ ������ ���İ� ���� �����ڸ� �Բ� ���
		int c = 10 == 10 ? 10 : 20;
		System.out.println(c);
		
		c = first == second ? first : second;
		System.out.println(c);
		
		//3. �Ǽ��� ������ ���İ� ���� �����ڸ� �Բ� ���
		double d = 10 == 10? 3.5 : 4.5;
		System.out.println(d);
		
		double d1 = 3.5;
		double d2 = 4.5;
		d = d1 == d2 ? d1 : d2;
		System.out.println(d);
		
		/*
		 * 1. if~else ���ǹ��� ����ؼ� ������ ������ ¦���̸� "¦��"�� ȭ�鿡 ���.
		 *    Ȧ���̸� "Ȧ��"(���ڿ�)�� ȭ�鿡 ���
		 */
		int num = 10;
		if (num % 2 == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}
		
		/*
		 * 2. ����(����) �����ڸ� ����ؼ� ���� if~else ���ǹ��� ����ȭ�ϱ�
		 * 	1) ȭ�鿡 ����� ���� "¦��" �Ǵ� "Ȧ��"�̹Ƿ� String ������;
		 */
		String msg;
		//	2) ���� �����ڸ� ����ؼ� num%2 == 0
		msg = num % 2 == 0 ? "¦��" : "Ȧ��";
		//	3) ���� msg�� ���� ���
		System.out.println(msg);
		
		//	4) ������ ������� �ʰ� ��� �Լ��� print() �ȿ� ���� ���ꤤ�ڸ� �ۼ�
		System.out.println(num%2==0? "¦��":"Ȧ��");
		
		//	5) for �ݺ����� ����ؼ� ����� ȭ�鿡 1, 2, 3, 4, 5, �� ���
		for(int i = 1; i<=5 ; i++) {
			if(i>=1&&i<=4)
				System.out.print(i+",");
			//else
				//System.out.println(i);
		}
		
		//	6) for �ݺ����� ����ؼ� ���� �ݺ����� �����ϱ�: ������ �ʴ� �ݺ���
		for(int i=5; i>=1; --i) {
			System.out.print(i+",");
		}
		System.out.println("\nfor �ݺ����� ����Ǿ�����?");
		//	7) 1+2+...+100���� ���ϴ� ����
		//		1) ���� j�� ����: 1->2->...->100
		//		2) ���� sum �� ����: 0->1->3->...
		int sum;
		int j;
		for(j=1, sum=0; j<=100; sum+=j, j++)
			;
		System.out.println("1+2+...+100������ ���� "+sum);
		
	}

}
