/*
 * 1. ����: for �ݺ����� ����ؼ� ���� �ݺ���(Infinite Loop) ���� �����
 * 	1) ����ؼ� �ȳ��ϼ���? �޽����� ����ڿ��� �����ִ� ������ �ۼ�
 */
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {
		
		//2. ���� �ݺ��� ������ �ۼ�
//		for(;true;) {
//			System.out.println("�ȳ��ϼ���?");
//		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���α׷��� ���� ��...");
		//2. ����ڿ��� y �Ǵ� n �� ���� �Է��� ��û�ϱ�
		System.out.print("y �Ǵ� n �� ���ڸ��� �Է��ϼ���: ");
		char ch = scanner.nextLine().charAt(0);
		//3. ����ڰ� �Է��� ���ڸ� ���
		System.out.println("����ڰ� �Է��� �� ���ڴ� "+ch);
		
		//4. ����ڿ��� yes �Ǵ� no ���� ���ڿ����� �Է� ��û�ϱ�
		System.out.print("yes �Ǵ� no �߿��� �ϳ��� �Է��ϼ���: ");
		String line = scanner.nextLine();
		System.out.println(line);
		
		/*
		 * 5. for �ݺ����� ����ؼ� ���� �ݺ��� ������ �����
		 * 	1) for(;true;) {
		 * 		����ؼ�_������_����;
		 * 	   }
		 */
		for (;true;) {
			System.out.println("�ȳ��ϼ���?");
			// ����ڿ��� y �Ǵ� n �� ���ڸ� �Է� ��û�ϱ�
			System.out.print("y �Ǵ� n �߿��� �ϳ��� �Է��ϼ���: ");
			char yn = scanner.nextLine().charAt(0);
			//if~else ���ǹ��� ����ؼ� ���� ����ڰ� y�� �Է��ϸ�
			// ��(�ٽ�) �ȳ��ϼ���? �޽����� �����ֱ� ���ؼ� ���� �̵��ϱ�: continue ��ɾ ����ؼ� �ذ�
			// -> ����) if (���ǽ�) {continue; } // ���� �帧�� ���� �̵��ؼ� for �ݺ����� ��ȭ������ �̵� -> ���ǽ� -> ...
			if (yn=='y') {
				System.out.println("����ڰ� y�� �Է�");
				continue;
			}
			else if(yn=='n') {
				System.out.println("����ڰ� n�� �Է�");
				break;
			}
			// ���� ����ڰ� �빮�� y�� �Է��ϸ� continue ��ɾ ����
			else if(yn=='Y') {
				System.out.println("����ڰ� Y�� �Է�");
				continue;
			}
			else if(yn=='N') {
				System.out.println("����ڰ� N�� �Է�");
				break;
			}
			else {
				System.out.println("����ڰ� y/Y/n/N �� �ƴ� �ٸ� ���ڸ� �Է�");
			}
		}
		
		/*
		 * for �ݺ����� ����ؼ� ���� �ݺ��� ������ �ۼ�
		 */
		for(;true;) {
			System.out.println("�ȳ��ϼ���!");
			System.out.print("yes �Ǵ� no �߿��� �ϳ��� �Է��ϼ���: ");
			line = scanner.nextLine();
			//����ڰ� yes�� �Է��ߴ��� �Ǵ��ϱ�
			boolean result2 = line.equals("yes");
			if(result2 == true) {
				System.out.println("����ڰ� yes�� �Է�!");
				continue;
			}
			else if(result2 == false) {
				if (result2 = line.equals("no")){
					System.out.println("����ڰ� no�� �Է�!");
					break;
				}
				else {
					System.out.println("�ٽ� ����� �Է����ּ���.");
					continue;
				}
			}
		}
		
		
		
		scanner.close();
		System.out.println("���α׷��� ����");
		
	}

}
