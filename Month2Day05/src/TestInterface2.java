/*
 * 1. ����: �߻� Ŭ������ �������̽��� �Բ� ����ؼ� ���� ����� ����
 */

// 2. �߻� Ŭ������ ����(����)
abstract class Parent2 {
	// 3. �߻� �޼��带 ����
	public abstract void method1();
}

// 4. �������̽��� ����
interface MyInterface3 {
	// 5. �߻� �޼��带 ����
	public abstract void method2();
}

// 6. ���� ����� �޴� Child3 Ŭ������ ����
class Child3 extends Parent2 implements MyInterface3 {
	
	// Alt + Shift + S ���� Ű -> Override/Implement Methods... ����
	
	@Override
	public void method2() {
		System.out.println("�������� method2() �޼��尡 ȣ��");
	}

	@Override
	public void method1() {
		System.out.println("�������� method1() �޼��尡 ȣ��");
	}
	
}

public class TestInterface2 {

	public static void main(String[] args) {
		Child3 a = new Child3();
		a.method1();
		a.method2();
	}

}
