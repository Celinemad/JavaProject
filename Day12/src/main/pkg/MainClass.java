package main.pkg;

/*
 * �ٸ� ��Ű���� �ִ� Ŭ������ ����ϱ� ���ؼ��� import ��ɾ ����ϰų� Ŭ�������� ����� ������ ��Ű����.Ŭ������
 * 1) import ��Ű����.Ŭ������;
 * 2) ��Ű����.Ŭ������ ��ü��;
 */
// myjava1 ��Ű���� �ִ� Class1 Ŭ�������� ����ϱ�
import myjava1.Class1;
import myjava2.Class2;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. ��ü�� �����ϱ� ���� ��ɾ��� ����
		 * 	1) ���� ������ ����: ��ü�� ������ �� ����� ����
		 * 		- ����: Ŭ������ ������;
		 */
		Class1 a;
		/*
		 * 2) new �����ڸ� ����ؼ� �޸𸮿� Class1 Ŭ���� ���ο� �ִ� �������� ����
		 * 		- ����: ���������� = new Ŭ������();
		 */
		a = new Class1();
		/*
		 * 3) �޸𸮿� ������ ��� �������� id�� pwd��  �����ϱ�(����ϱ�
		 * 		-����: ���������� + �� + ���������
		 */
		System.out.println(a.id);
		
		/*
		 * ���ο� ��ü�� �����ϱ� ����
		 * 1+2���� �ϳ��� ��ģ ����) Ŭ������ ���������� = new Ŭ������();
		 */
		Class1 b = new Class1();
		// ���� ������ ��ü�� ���� �ִ� ��� ������ id�� ����(���)
		System.out.println(b.id);
		
		a.fnc1();
		
		a.fnc2("celineinny");
		
		/*
		 * import ��ɾ� ���� �ٸ� ��Ű���� �ִ� Ŭ������ ����ϱ�
		 */
		myjava2.Class2 c = new myjava2.Class2();
		// ���ο� ���� ���� d�� �����ϰ� ���ο� ��ü�� �����ϱ�
		myjava2.Class2 d = new myjava2.Class2();
		
		//Class2���� ���� ���� �������� public Class2(String a)�� ȣ���ϱ� ���� ����: new Ŭ������("���ڿ�");
		myjava2.Class2 e = new myjava2.Class2("ȫ�浿");
		myjava2.Class2 f = new myjava2.Class2("��浿");
		myjava2.Class2 g = new myjava2.Class2("�������");
		
		
		myjava.shape.Circle circle = new myjava.shape.Circle(7);
	}

}
