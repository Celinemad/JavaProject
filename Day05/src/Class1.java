
public class Class1 {

	public static void main(String[] args) {
		
		byte a=10;
		byte b=20;
		int c = a+b;
		System.out.println(c);
		
		// ������ ���� ������ �߻��� �� �ִ�. (byte����: -128~127, int����: -��21��~21��)
		byte d = (byte)(a+b);
		System.out.println(d);
		
		int aa=1;
		System.out.println(aa);
		// ���� ����: ++������;
		++aa; // a = a + 1; ��ɾ��� ���� ����� ����
		System.out.println(aa); // 2�� ���
		// ���� ����: ������++;
		aa++;
		System.out.println(aa); // 3�� ���
		
		// --�����ڸ� ����ؼ� ���� aa�� ���� �ϳ��� ����
		--aa;
		System.out.println(aa); // 2
		aa--;
		System.out.println(aa); // 1
		aa=aa-1;
		System.out.println(aa); // 0
		aa=aa+1;
		System.out.println(aa); // 1
		
		/*
		 * ���� ���� �������� ++�� ���� �������� =�� �Բ� ���
		 * 1. int bb = ++aa; // �������� -> ���� ���� aa�� ���� ������Ű�� �� ����� ���� bb�� ����
		 * 2. System.out.println("���� aa�� ���� " + aa +", ���� bb�� ���� " + bb);
		 * 
		 * 
		 */
		
		int bb = ++aa;
		System.out.println("���� aa�� ���� "+aa+"���� bb�� ���� "+bb);
		
		/*
		 * ���� ���� �������� ++�� ���� �������� =�� �Բ� ���
		 * 1. int cc=aa++;
		 *     -> ���� ����: ���� ���� aa�� ���� ���� cc�� ����. �� ������ ���� aa�� ���� �ϳ� ����
		 *         -> ���: ���� aa�� ���� ���� cc�� ������ 1��ŭ �� Ů�ϴ�.
		 */
		
		int cc=aa++;
		System.out.println("���� aa�� ���� "+aa+"���� cc�� ���� "+cc);
		
		/*
		 * --�����ڿ� =���� �����ڸ� �Բ� ���
		 * 1. ���� ���� ��ɾ� ����: ������Ÿ�� ������2 =--������;
		 *     -> System.out.println(������2 + "," + ������);
		 * 2. ���� ���� ��ɾ� ����: ������Ÿ�� ������ = ������--;
		 *     -> System.out.println(������2 + "," + ������);
		 */
		
		int num = 1;
		int num1 = -- num;
		System.out.println(num1+","+num);
		
		num1 = num--;
		System.out.println(num1+","+num);
		
		/*
		 * ���� ���� �����ڸ� ����ؼ� �ѹ��� ���� ��� + ���� ������ �����ϱ�
		 * 1. int ������ = ��;
		 * ��) int dd = 10;
		 * dd+=5;
		 * System.out.println(dd);
		 */
		
		int dd = 10;
		// ��� ���� ���� ���� dd ���� ���: ������ ���߿� �Ի� �Ŀ� �ùٸ� ��� ���θ� Ȯ���� �� ���
		System.out.println(dd);
		// += ���� ���� �����ڸ� ����ؼ� 10+5 ��������� �����ϰ� ����� 15�� �ٽ� ���� dd�� ����
		dd+=5;
		System.out.println(dd);
		
		int numb1 = 5;
		
		numb1 = numb1 + 1;
		System.out.println(numb1);
		// numb2 = numb1 + 1;
		// System.out.println(numb1);
		
		/*
		 * 1. �� �����ڵ��� ��뤾�� ���� ũ�⸦ ���ϱ�
		 * 1) > (ũ��)
		 * 2) < (�۴�)
		 * 3) >= (Ŀ�� ��, ���Ƶ� ��)
		 * 4) <= (�۾Ƶ� ��, ���Ƶ� ��)
		 * 5) == (���ƾ� ��)
		 * 6) != (�޶�� ��)
		 */
		int g = 10;
		int h = 20;
		
		boolean result = g>h;
		System.out.println(result);
		
		result = g<h;
		System.out.println(result);
		
		g = 10;
		h = 5;
		result = g>=h;
		System.out.println(result);
		
		h=g;
		result = g>=h;
		System.out.println(result);
		
		g=5;
		h=g;
		result = g!=h;
		System.out.println(result);
		
		// ���� ��: ���� ������ �� ���ڸ� ��: '���ĺ�����' �񱳿����� '���ĺ�����'
		// ��) 'A' == 'B'
		char ch1 = 'A';
		char ch2 = 'B';
		result = ch1==ch2;
		System.out.println(result);
		
		ch2 = ch1;
		result = ch1==ch2;
		System.out.println(result);
	}	
	

}
