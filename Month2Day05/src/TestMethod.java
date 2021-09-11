/*
 * 1. ����: ���ο� �޼��带 ������ �� �Ű������� ������Ÿ������ �߻� Ŭ������ �������̽��� ��� ����
 */

// 2. �߻� Ŭ������ ����
abstract class AbsClass1 {
	// 3. �߻� �޼��带 ����
	public abstract void absMethod1();
}

// 4. �������̽��� ����
interface Int1 {
	// 5. �߻� �޼��带 ����
	public abstract void absMethod2();
}

// 6. �Ϲ� Ŭ������ ����
class GeneralClass1 {
	// 7. ���ο� method1()�� ���� + �Ű������� Ÿ������ �߻� Ŭ������ ���
	public void method1(AbsClass1 a) {
		System.out.println("method1(AbsClass1) �޼��尡 ȣ��");
	}
	
	// 8. ���ο� method2()�� ���� + �Ű������� Ÿ������ �������̽��� ���
	public void method2(Int1 a) {
		System.out.println("method2(Int1) �޼��尡 ȣ��");
	}
}

// 9. ������ ������ �߻� Ŭ������ �������̽��� ��� ��� �޴� �ڽ� Ŭ������ ����: Ŭ���� �̸��� ConcreteClass1
class ConcreteClass1 extends AbsClass1 implements Int1 {

	@Override
	public void absMethod2() {
		System.out.println("�������� absMethod2() �޼ҵ尡 ȣ���");
	}

	@Override
	public void absMethod1() {
		System.out.println("�������� absMethod1() �޼ҵ尡 ȣ���");
	}
	
}


public class TestMethod {

	public static void main(String[] args) {
		ConcreteClass1 a = new ConcreteClass1();
		a.absMethod1();
		a.absMethod2();
		
		GeneralClass1 b = new GeneralClass1();
		b.method1(new ConcreteClass1());
		b.method2(new ConcreteClass1());
	}

}
