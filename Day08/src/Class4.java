/*
 * 1. ����: �ֻ��� ������ ����
 */
import java.util.Random;
public class Class4 {

	public static void main(String[] args) {
		
		//1. Random ���� ����
		Random random = new Random();
		int compcnt = 0;
		int hmncnt = 0;
		int same = 0;
		
		//2. ���� ���� �� 5��
		for(int cnt=1; cnt<=5; cnt++) {
			//3. 1~2 ���̿� �ִ� ������ ������ ���� ������ ���� ����
			int choice = random.nextInt(2)+1;
			//4. ���� ������ ������ ���� 1�� ������ ��ǻ�Ͱ� ���� �ֻ����� ������
			if(choice==1) {
				System.out.println("��ǻ�Ͱ� ���� �ֻ����� �����ϴ�...");
				int computer = random.nextInt(6)+1;
				System.out.println("����� �ֻ����� �����ϴ�...");
				int human = random.nextInt(6)+1;
				
				if(computer > human) {
					System.out.println("���ڴ� ��ǻ��");
					compcnt +=1;
				} 
				else if(human > computer) {
					System.out.println("���ڴ� ���");
					hmncnt +=1;
				}
				else {
					System.out.println("���º�");
					same +=1;
				}
			}
			else if(choice==2){
				System.out.println("����� ���� �ֻ����� �����ϴ�...");
				int human = random.nextInt(6)+1;
				System.out.println("��ǻ�Ͱ� �ֻ����� �����ϴ�...");
				int computer = random.nextInt(6)+1;
				
				if(computer > human) {
					System.out.println("���ڴ� ��ǻ��");
					compcnt +=1;
				} 
				else if(human > computer) {
					System.out.println("���ڴ� ���");
					hmncnt +=1;
				}
				else {
					System.out.println("���º�");
					same +=1;
				}
			}
		}
		System.out.printf("%d�� %d�� %d��", hmncnt, same, compcnt);
		
	}
		
		
		
}


