/*
 * 1. ����: java.util ��Ű���� �ִ� StringTokenizer Ŭ������ ����ؼ�
 *  	   �ϳ��� ���ڿ� �ȿ� �ִ� ���� ���ڿ����� �и�(���� �Ǵ� �̱�)
 */
import java.util.StringTokenizer;

public class TestStringToken {

	public static void main(String[] args) {
		// 2. �ϳ��� ���ڿ� ���� ������ �� �ִ� StringTokenizer(String) �����ڸ� ����ϱ�
		StringTokenizer a = new StringTokenizer("ȫ�浿 ��浿 ���浿 �ٱ浿");
		
		// 3. while() �ݺ����� ����ϱ�: hasMoreTokens() �޼ҵ带 ���ǽĿ� ����� �� �ֱ� ������
		while(a.hasMoreTokens()==true) {
			// 4. nextToken() �޼ҵ带 ����
			String token = a.nextToken();
			// 5. ��ū�� ���
			System.out.println("���ڿ����� �о� �� ��ū�� "+ token);
		}
		
		// 4. ���ڿ� ���ο� �ִ� ���� ���ڿ�(�κ� ���ڿ�)�� ����: Ű=��
		// ��) name=kitae(�ѱ�)
		String string = "name=����&addr=��⵵ �ǿս� ���յ�&age=23";
		// 5. StringTokenizer(String, String) �����ڸ� ���
		StringTokenizer b = new StringTokenizer(string, "&");
		// 6. while �ݺ���
		while(b.hasMoreTokens()) {
			String token = b.nextToken();
			System.out.println("���ڿ����� �о� �� ��ū�� "+ token);
		}
		
		b = new StringTokenizer(string, "&");
		System.out.println(b.countTokens());
		int count = b.countTokens();
		for(int i=0; i<count; i++) {
			String token = b.nextToken();
//			System.out.println(token);
			if(token.equals("name=����")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 5, "�̸�: ");
				System.out.println(sb);
			} if(token.equals("addr=��⵵ �ǿս� ���յ�")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 5, "�ּ�: ");
				System.out.println(sb);
			} if(token.equals("age=23")) {
				StringBuffer sb = new StringBuffer(token);
				sb.replace(0, 4, "����: ");
				System.out.println(sb);
			}
		}
		
	}

}
