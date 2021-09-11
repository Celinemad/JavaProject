package myjava4;
/*
 * 1. ����: Object Ŭ�������� �ڽ� Ŭ������ ������� getClass() �޼ҵ带 ����ؼ� Ŭ������ �̸��� �о�ͼ� ���
 */
//2. MyClass1 �̸��� ���� Ŭ������ ����
class MyClass1 extends Object{
	public MyClass1() {
		System.out.println("MyClass1() �⺻ �����ڰ� ȣ���");
	}
	public void show() {
		System.out.println("show() �޼ҵ尡 �����");
	}
}


public class TestClass {

	public static void main(String[] args) {
		
		// 1. MyClass1 Ŭ������ ����ؼ� ��ü�� ����
		MyClass1 a = new MyClass1();
		// 2. getClass() ��ҵ带 ȣ���ؼ� Ŭ������ ������ ��ȯ
		Class b = a.getClass();
		// 3. Class Ŭ������ ���� �ִ� getName() �޼ҵ带 ȣ���ؼ� Ŭ������ �̸��� ���
		String name = b.getName();
		System.out.println("Ŭ���� �̸��� "+name);
		
		// 4. getSimpleName() �޼ҵ带 ȣ���ؼ� ��Ű���� �����ϰ� Ŭ���� �̸����� ���
		String name2 = b.getSimpleName();
		System.out.println("Ŭ���� �̸��� "+name2);
	}

}
