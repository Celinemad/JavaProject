package myjava2;
/*
 * 1. ����: String Ŭ������ ���� �ִ� concat() �޼ҵ带 ����ؼ� ���� �и��Ǿ� �ִ� ���ڿ��� �ϳ��� ��ġ��
 * 	-> ����: �޸� ������ ȿ�������� ����ϱ� ����
 */
public class TestString {

	public static void main(String[] args) {
		
		String a = new String("�����");
		String b = new String("������");
		String c = new String("������");
		String d = new String("00����Ʈ");
		String e = new String("0��");
		String f = new String("0ȣ");
		
		System.out.println("�ô� " + a);
		System.out.println("���� " + b);
		System.out.println("���� " + c);
		System.out.println("����Ʈ �̸��� " + d);
		System.out.println("����Ʈ ���� " + e);
		System.out.println("����Ʈ ȣ���� " + f);
		
		// 1. concat() �Լ��� ����ؼ� "�����" + " " + "������" -> "����� ������"
		String result1 = a.concat(" ");
		String result2 = result1.concat(b);
		System.out.println(result2);
		
		// 2. ������ "����� ������" ���ڿ��� ����
		// 3. �Ʒ��� concat() �Լ��� ����ؼ� "����� ������ ������ 00����Ʈ 0�� 0ȣ"
		String result3 = result2.concat(" ");
		String result4 = result3.concat(c);
		String result5 = result4.concat(" ");
		String result6 = result5.concat(d);
		String result7 = result6.concat(" ");
		String result8 = result7.concat(e);
		String result9 = result8.concat(" ");
		String result10 = result9.concat(f);
		System.out.println(result10);
		
		
	}

}
