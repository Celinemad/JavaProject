package myjava1;
/*
 * 1. ����: java.lang.Math Ŭ������ ����ϱ�
 */
import java.util.Scanner;
public class TestMath {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// ���� �ݺ��� ������ ����ؼ� ����ڷκ��� �޴� ��ȣ�� �Է� �޾Ƽ� �޴��� �ش��ϴ� �޼ҵ带 �����ϰ� ����� ���
		while(true) {
			System.out.println("*** java.lang.Math Ŭ������ ��� ���� ***");
			System.out.println("1. PI(������)  2. ceil()  3. floor()  4. sqrt()  5. ����");
			System.out.println("�޴� ��ȣ�� ������ �Է��ϼ���: ");
			int menu = scanner.nextInt();
			if(menu == 5) {
				System.out.println("���α׷��� ����");
				break;
			}
			else if(menu == 1) {
				System.out.println("������ ���� ����ϸ� "+ Math.PI);
			}
			else if(menu == 2) {
				System.out.println("ceil() ���� ���ϱ�");
				System.out.print("�ϳ��� �Ǽ� ���� �Է��ϼ���: ");
				double number = scanner.nextDouble();
				double result = Math.ceil(number);
				System.out.println("����ڰ� �Է��� �Ǽ� "+ number + "�� ceil() �Լ� ����� "+ result);
			}
			else if(menu == 3) {
				System.out.println("floor() ���� ���ϱ�");
				System.out.print("�ϳ��� �Ǽ� ���� �Է��ϼ���: ");
				double number = scanner.nextDouble();
				double result = Math.floor(number);
				System.out.println("����ڰ� �Է��� �Ǽ� "+ number + "�� floor() �Լ� ����� "+ result);
			}
			else if(menu == 4) {
				System.out.println("sqrt() ���� ���ϱ�");
				System.out.print("�Ǽ� ���� �Է��ϼ���: ");
				double number = scanner.nextDouble();
				double result = Math.sqrt(number);
				System.out.println("����ڰ� �Է��� �Ǽ� "+ number + "�� sqrt() �Լ� ����� "+ result);
			}
		}
		
		scanner.close();
		
	}

}
