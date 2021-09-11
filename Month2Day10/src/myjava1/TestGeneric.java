package myjava1;
/*
 * 1. 제목: 클래스의 제네릭(일반화)을 구현하기
 * 		-> 서로 공통점을 갖고 있는 여러 클래스들을 하나로 합치는 기술(기법)
 */
// 2. 새로운 클래스들을 정의
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
		System.out.println("당신의 이름은 " + m_name);
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
		System.out.println("당신의 나이는 " + m_age);
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
		System.out.println("당신의 키는 " + m_height);
	}
}

// 제네릭 클래스를 정의
class MyGeneric<T>{
	// 1. 멤버 변수 하나를 선언
	private T m_a;
	// 2. 메소드들을 정의
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

// 새로운 제네릭 메소드를 정의한 클래스를 정의
class MyGeneric2 {
	// static 제한자를 사용해서 제네릭 메소드를 정의
	public static <T> void show(T a) {
		System.out.println("모든 종류의 데이터를 받아서 화면에 출력하기");
		System.out.println(a);
	}
}

public class TestGeneric {

	public static void main(String[] args) {
		// MyGeneric2 클래스에서 정의한 제네릭 메소드인 show()를 호출
		MyGeneric2.show(100);
		MyGeneric2.show("김길동");
		MyGeneric2.show(3.14);
		MyGeneric2.show(true);
		
		// 1. 위에서 정의한 3개의 클래스를 사용하기 위한 3개의 객체를 생성
		MyString a = new MyString("홍길동");
		MyAge b = new MyAge(20);
		MyHeight c = new MyHeight(170);
		
		// 2. 각각의 클래스에서 정의한 show로 시작하는 메소드를 호출해서 멤버변수의 값을 꺼내와서 출력하기
		a.showName();
		b.showAge();
		c.showHeight();
		
		// 3. 제네릭 클래스를 사용해서 새로운 객체를 생성
		MyGeneric<String> d = new MyGeneric<String>();
		d.set("홍길동");
		String value = d.get();
		System.out.println("제네릭 클래스로부터 가져온 사람 이름은 " + value);
		
		// 4. 제네릭 클래스를 사용해서 정수만을 보관할 수 있는 객체를 생성
		MyGeneric<Integer> e = new MyGeneric<Integer>();
		e.set(100);
		Integer value2 = e.get();
		System.out.println("제네릭 클래스로부터 가져온 정수는 " + value2);
		
		// 5. 제네릭 클래스를 사용해서 실수만을 보관할 수 있는 객체를 생성
		MyGeneric<Double> f = new MyGeneric<Double>();
		f.set(3.14);
		Double value3 = f.get();
		System.out.println("제네릭 클래스로부터 가져온 실수는 " + value3);
		
		// 6. 제네릭 클래스를 사용해서 논리값을 보관할 수 있는 객체를 생성
		MyGeneric<Boolean> g = new MyGeneric<Boolean>();
		g.set(true);
		Boolean value4 = g.get();
		System.out.println("제네릭 클래스로부터 가져온 논리값은 " + value4);
		
		
	}

}
