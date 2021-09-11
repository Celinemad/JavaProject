// 1. 사람 클래스의 정의
public class Person {
	private String m_name;
	public Person() {
		this("이름없음(무명)");
	}
	public Person(String name) {
		m_name = name;
	}
	public void showPersonInfo() {
		System.out.println("사람 이름은 " + m_name);
	}
}
