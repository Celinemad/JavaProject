/*
 * 1. ����: ���� ��Ȳ�� �߻����� �� ��������(����)�� ��� ��ɾ�� ���ܰ� �߻��ߴ����� ���
 */
import java.util.Scanner;
public class Class1 {

	public static void main(String[] args) {
		
		//1. try~catch~catch~...~finally
		//	finally �ۼ��� ����
		try {
			System.out.println(5/0);
			System.out.println("���ܰ� �߻����� ����");
		} catch (java.lang.ArithmeticException e1) {
			System.out.println("��� ���� �߻�");
		} catch (java.lang.Exception e2) {
			System.out.println("�ٸ� ������ ���� �߻�");
		} finally {
			System.out.println("���� �������� ������ ����");
		}
		
		
		
//		try {
//			//1. ���� 5�� 0���� ������: 0���� ���� �� ���� ���� ��Ȳ�� �߻�
//			System.out.println("5�� 0���� ���� ����� " + (5/0));
//		} catch(Exception e) {
//			System.out.println("���ܻ�Ȳ�� �߻�");
//			System.out.println("���������� " + e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
//		//1. try~catch �� ���� �迭�� ���� + ����
//		int[] arr1 = new int[5];
//		//2. try~catch ���� �ۼ��ؼ� ���� ��Ȳ�� ����ϱ�(Ʈ��: trap)
//		try {
//			arr1[0] = 1;
//			System.out.println("ù ��° ������ ���� "+arr1[0]);
//			arr1[5] = 2;
//			System.out.println("���� ���� ������ ���� "+arr1[5]);
//		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
//		//1. ���� ���� catch ���� �ۼ�: �� ���� ���� ���� ���ܵ��� ó���� �� �ִ� ����
//		int[] arr1 = {1,2,3,4};
//		
//		//try+ Ctrl + Space: �ڵ��ϼ�
//		try {
//			//System.out.println("5�� 0���� ���� ����� "+(5/0));
//			System.out.println("�迭 arr1�� ���� ��° ������ ���� "+arr1[5]);
//			System.out.println("���ܰ� �߻����� ����");
//		} catch (java.lang.ArithmeticException e1) {
//			System.out.println("��� ���� �߻�");
//			e1.printStackTrace();
//		} catch(java.lang.ArrayIndexOutOfBoundsException e2) {
//			System.out.println("�迭�� �ε��� ���� �߻�");
//			e2.printStackTrace();
//		} catch(Exception e3) {
//			//������ �ۼ��� ���� catch ������ ���ܸ� ó������ ���� ��쿡 ������ ��ɾ�
//			//	-> ���� �߻��� ���ܰ� ��� ���ܵ� �ƴϰ� �迭�� �ε��� ���ܵ� �ƴ� ��� (���� if������ else�� ����)
//			System.out.println("�ٸ� ������ ���ܰ� �߻�");
//			e3.printStackTrace();
//		}
		
		
//		Scanner scanner = new Scanner(System.in);
//		
//		//1. NumberFormatException: ���� ���� ����
//		//��) java.lang.Integer.parseInt("����");
//		try {
//			System.out.println("Integer Ŭ������ parseInt() �Լ��� ȣ���ϱ�");
//			int a = java.lang.Integer.parseInt("100");
//			//System.out.println("���ڿ� 100�� ������ ��ȯ�ϸ� "+a);
//			//a = java.lang.Integer.parseInt("abc");
//			//System.out.println("���ڿ� abc�� ������ ��ȯ�ϸ� "+a);
//			//nextInt() �Լ��� �����ϱ�
//			System.out.print("������ �Է��ϼ���: ");
//			a = scanner.nextInt();
//			System.out.println("����ڰ� �Է��� ������ "+a);
//			System.out.println("���ܰ� �߻����� ����");
//		} catch (java.lang.NumberFormatException e1) {
//			System.out.println("���� ���� ����");
//			e1.printStackTrace();
//		} catch (java.util.InputMismatchException e3) {
//			System.out.println("�Է� ���� ����(������ ���ڷ� �Է��� ���)");
//			e3.printStackTrace();
//		}
//		//Exception ���� Ÿ���� ���� catch�� �� ���� �������� �־�� ��
//		catch(Exception e2) {
//			System.out.println("�ٸ� ������ ���� ��Ȳ�� �߻�");
//			e2.printStackTrace();
//		}
		
		
		
	}

}
