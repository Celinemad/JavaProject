/*
 * 1. ����: 1+2+...+����ڰ�_�Է���_����
 */
import java.util.Scanner;
public class Class2 {

	public static void main(String[] args) {
		
		//1. Scanner ������ ����
		Scanner scanner = new Scanner (System.in);
		
		//2. ����ڷκ��� �Է¹��� ������ ������ ������ ���� end ����
		int end;
		
		//3. ����ڷκ��� ������ ������ �Է� ��û�ϱ�
		System.out.print("������ ������ �Է��ϼ���: ");
		end = scanner.nextInt();
		System.out.println("����ڰ� �Է��� ������ ������ "+ end);
		
		if (end<0)
			end*=(-1);
		
		int sum;
		int a;
		for(a=1, sum=0; a<=end; sum+=a, a++) 
			;
		System.out.println("1���� ����ڰ� �Է��� ������ ���������� ���� "+sum);
		
		//���� ������(�� �̻� ����ڷκ��� ���� �Է��� �ʿ䰡 ���� ���)���� close() �Լ��� ���
		scanner.close();
		System.out.println("���α׷��� ����˴ϴ�.");
	}

}
