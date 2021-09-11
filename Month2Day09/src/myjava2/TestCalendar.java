package myjava2;
/*
 * 1. ����: java.util.Calendar Ŭ������ ����ؼ� ��¥�� �ð��� ���
 * 2. ���� ����: ������� ���̸� ���ϱ�
 */
import java.util.Calendar;

public class TestCalendar {

	public static void main(String[] args) {
		
		// ������ ����, ��, ��, �ð�, ��, �ʸ� ���
		// 1. Calendar Ŭ������ ����ؼ� ��ü�� �����ϱ�: ������ Calendar ������ = Calendar.getInstance();
		// -> ������ ��: new Calendar() ��ɾ ����� �� ����
		Calendar a = Calendar.getInstance();
		
		// 2. ������ ���
		System.out.println("������ "+ a.get(Calendar.YEAR));
		// 3. ���� ���
		System.out.println("���� "+ (a.get(Calendar.MONTH)+1));
		// 4. ���� ���
		System.out.println("���� "+ a.get(Calendar.DAY_OF_MONTH));
		// 5. �ð��� ���
		System.out.println("�ð��� "+ a.get(Calendar.HOUR));
		// 6. ���� ���
		System.out.println("���� " + a.get(Calendar.MINUTE));
		// 7. �ʸ� ���
		System.out.println("�ʴ� " + a.get(Calendar.SECOND));
		// 8. ����/����: Calendar.AM_PM
		System.out.println("����/���� ���� ���� " + a.get(Calendar.AM_PM));
		
		
		
	}

}
