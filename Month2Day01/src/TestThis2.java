/*
 * 1. ����: this ���� ��� -> ���� �ٸ� Ŭ�������� ��ü�� �Է����� �ޱ�
 */
class This3 {
	//method1() �޼ҵ带 ����: �Է����δ� This2 Ŭ������ ���� �ּҸ� �ޱ�
	public void method1(This2 refa) {
		System.out.println("�ٸ� Ŭ������ ���� �ּҸ� �ޱ�");
		refa.show();
		refa.a = 100;
		refa.show();
	}
}
class This2 {
	int a;
	public This2() {
		a  = 10;
	}
	public This2(int a) {
		this.a = a;
	}
	public void show() {
		System.out.println("��������� a�� ���� "+a);
	}
}
public class TestThis2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. This3 Ŭ������ ����ؼ� ���ο� ��ü�� �����
		This3 a = new This3();
		// 2. This2 Ŭ������ ����ؼ� ���ο� ��ü�� �����
		This2 b = new This2();
		// 3. This2 Ŭ�������� ������ show() �޼ҵ带 ȣ��
		b.show();
		// 4. This3 Ŭ�������� ������ method1() �޼ҵ带 ȣ�� + This2Ŭ������ ���� �ּҸ� ����
		a.method1(b);
	}

}
