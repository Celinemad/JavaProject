import java.util.Scanner;
public class Class {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] aeng = new int[5];
		int i = 0;
		while (i<aeng.length) {
			System.out.print((i+1)+"��° �л��� ���� ������ ������ �Է�: ");
			aeng[i] = scanner.nextInt();
			System.out.println("����ڰ� �Է��� ���� ������ "+aeng[i]);
			i++;
		}
		
		scanner.close();
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

}
