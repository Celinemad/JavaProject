package myjava4;

public class TestSB2 {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("�����");
		
		a.append("������");
		a.insert(3, " ");
		System.out.println(a);
	}

}
