package myjava1;
/*
 * 1. ����: Ŭ������ ���׸�(�Ϲ�ȭ)�� �����ϱ�
 * 		-> ���� �������� ���� �ִ� ���� Ŭ�������� �ϳ��� ��ġ�� ���(���)
 */
// 2. ���ο� Ŭ�������� ����
class MyString{
	private String m_name;
	public MyString(String name) {
		m_name = name;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String newName) {
		m_name = newName;
	}
	public void showName() {
		System.out.println("����� �̸��� " + m_name);
	}
}
class MyAge {
	private int m_age;
	public MyAge(int age) {
		m_age = age;
	}
	public void setAge(int newAge) {
		m_age = newAge;
	}
	public int getAge() {
		return m_age;
	}
	public void showAge() {
		System.out.println("����� ���̴� " + m_age);
	}
}
class MyHeight {
	private double m_height;
	public MyHeight(double height) {
		m_height = height;
	}
	public void setHeight(double newHeight) {
		m_height = newHeight;
	}
	public double getHeight() {
		return m_height;
	}
	public void showHeight() {
		System.out.println("����� Ű�� " + m_height);
	}
}

// ���׸� Ŭ������ ����
class MyGeneric<T>{
	// 1. ��� ���� �ϳ��� ����
	private T m_a;
	// 2. �޼ҵ���� ����
	public T get() {
		return m_a;
	}
	public void set(T newA) {
		m_a = newA;
	}
	public void show() {
		System.out.println(m_a);
	}
}

// ���ο� ���׸� �޼ҵ带 ������ Ŭ������ ����
class MyGeneric2 {
	// static �����ڸ� ����ؼ� ���׸� �޼ҵ带 ����
	public static <T> void show(T a) {
		System.out.println("��� ������ �����͸� �޾Ƽ� ȭ�鿡 ����ϱ�");
		System.out.println(a);
	}
}

public class TestGeneric {

	public static void main(String[] args) {
		// MyGeneric2 Ŭ�������� ������ ���׸� �޼ҵ��� show()�� ȣ��
		MyGeneric2.show(100);
		MyGeneric2.show("��浿");
		MyGeneric2.show(3.14);
		MyGeneric2.show(true);
		
		// 1. ������ ������ 3���� Ŭ������ ����ϱ� ���� 3���� ��ü�� ����
		MyString a = new MyString("ȫ�浿");
		MyAge b = new MyAge(20);
		MyHeight c = new MyHeight(170);
		
		// 2. ������ Ŭ�������� ������ show�� �����ϴ� �޼ҵ带 ȣ���ؼ� ��������� ���� �����ͼ� ����ϱ�
		a.showName();
		b.showAge();
		c.showHeight();
		
		// 3. ���׸� Ŭ������ ����ؼ� ���ο� ��ü�� ����
		MyGeneric<String> d = new MyGeneric<String>();
		d.set("ȫ�浿");
		String value = d.get();
		System.out.println("���׸� Ŭ�����κ��� ������ ��� �̸��� " + value);
		
		// 4. ���׸� Ŭ������ ����ؼ� �������� ������ �� �ִ� ��ü�� ����
		MyGeneric<Integer> e = new MyGeneric<Integer>();
		e.set(100);
		Integer value2 = e.get();
		System.out.println("���׸� Ŭ�����κ��� ������ ������ " + value2);
		
		// 5. ���׸� Ŭ������ ����ؼ� �Ǽ����� ������ �� �ִ� ��ü�� ����
		MyGeneric<Double> f = new MyGeneric<Double>();
		f.set(3.14);
		Double value3 = f.get();
		System.out.println("���׸� Ŭ�����κ��� ������ �Ǽ��� " + value3);
		
		// 6. ���׸� Ŭ������ ����ؼ� ������ ������ �� �ִ� ��ü�� ����
		MyGeneric<Boolean> g = new MyGeneric<Boolean>();
		g.set(true);
		Boolean value4 = g.get();
		System.out.println("���׸� Ŭ�����κ��� ������ ������ " + value4);
		
		
	}

}
