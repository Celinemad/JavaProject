package myjava3;
/*
 * 1. ����: �ѱ� ���� ���ϱ�
 */
import java.util.Calendar;

public class TestAge {

	public static void main(String[] args) {
		
		// 2. ���� ��¥ ���ϱ� 
		Calendar curCal = Calendar.getInstance();
		
		// 3. ���� ��¥ ���ϱ�
		Calendar birCal = Calendar.getInstance();
		
		// 4. set() �޼ҵ带 �����ؼ� ���� ��¥�� ���Ϸ� ��ȯ
		birCal.set(1999, 6, 22);
		
		// 5. ���� ������ ���� ���ϱ�
		int curYear = curCal.get(Calendar.YEAR);
		
		// 6. ������ ���� ���ϱ�
		int birYear = birCal.get(Calendar.YEAR);
		
		// 7. ���� ���� ���ϱ�: ���� ��¥�� ���� - ���� ��¥�� ���� + 1
		int age = curYear - birYear + 1;
		
		// 8. ���� ���̸� ���
		System.out.println("���� ���̴� "+ age);
		
		// 9. �� ���� ���ϱ�
		// 	1) ���� ������ ���� ���� ��ġ��: int ������ = �� * 100 + ��;
		int curMD = (curCal.get(Calendar.MONTH)+1)*100 + curCal.get(Calendar.DAY_OF_MONTH);
		System.out.println("���� ��¥�� ���� ���� ��ģ ����� " + curMD);
		
		//  2) ���� ��¥�� ���� ���� ��ġ��: 
		int birMD = (birCal.get(Calendar.MONTH)+1)*100 + birCal.get(Calendar.DAY_OF_MONTH);
		System.out.println("���� ��¥�� ���� ���� ��ģ ����� " + birMD );
		
		if(birMD >= curMD) {
			age = age - 2;
			System.out.println("������ �� ���̴� "+ age);
		} else {
			age = age - 1;
			System.out.println("������ �� ���̴� "+ age);
		}
		
	}

}
