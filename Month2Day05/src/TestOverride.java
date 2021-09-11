/*
 * 1. ����: ��� ���迡�� �ڽ� Ŭ��������, �θ� Ŭ�������� ������ �޼��带 ������
 */

class Parent {
	// parentMethod() �޼��带 ����
	public void parentMethod() {
		System.out.println("parentMethod() �޼��尡 ȣ�� in Parent");
	}
	
	// ���ο� �޼��带 ����: �̸��� parentMethod2()
	public void parentMethod2() {
		System.out.println("parentMethod2() �޼��尡 ȣ�� in Parent");
	}
	// Child Ŭ������ �̵��Ͻ� �Ŀ� @Override �ֳ����̼� ��ɾ ����ؼ�
	// parentMethod2() �޼��带 �������ϱ� ->main() �޼��忡��
	// parentMethod2() �޼��带 ȣ���ϱ� -> a.parentMethod2();
}

// Parent Ŭ������ ��� �޴� Child �ڽ� Ŭ������ ����
class Child extends Parent {
	//parentmethod() ���ο� �޼��带 ����(�����ǰ� �ƴ�)
	@Override
	public void parentMethod() {
		System.out.println("parentMethod() �޼��尡 ȣ�� in Child");
	}
	@Override
	public void parentMethod2() {
		System.out.println("parentMethod2() �޼��尡 ȣ�� in Child");
	}
}

public class TestOverride {
	public static void main(String[] args) {
		Child a = new Child();
//		a.parentmethod();
		a.parentMethod();
		
		a.parentMethod2();
	}

}
