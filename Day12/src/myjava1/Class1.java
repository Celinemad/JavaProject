package myjava1;

public class Class1 {
	// ȸ���� ���̵� ������ ��� ���� �Ǵ� �ʵ� ����
	public String id = "Celine";
	// ȸ���� ��й�ȣ�� ������ ��� ���� �Ǵ� �ʵ� ����
	private String pwd = "celineinparis";
	// MainClass.java�ҽ� ���Ϸ� �̵��ؼ� Class1�� ����ϴ� ��ɾ �Է�
	
	// ���ο� ��� �Լ��� �޼��带 ����: Ŭ���� �ܺο��� ����� �Լ�(�������̽� �Լ�)
	public void fnc1() {
//		System.out.println("�ȳ��ϼ���?");
		System.out.println("��й�ȣ�� "+pwd);
		return;
	}
	
	// ���ο� ��� �Լ��� fnc2�� ����: �ٸ� Ŭ�����κ��� ���� �Է� �ޱ� ���ؼ� �Է� ������ ����
	public void fnc2 (String a) {
		System.out.println("�ٸ� Ŭ�������� fnc2 �Լ��� ȣ��");
		System.out.println("�Է� ���� "+a);
		pwd = a;
		System.out.println("������ ��� ���� pwd�� ���� "+pwd);
	}
	
}
