// 1. ��� Ŭ������ ����
public class Person {
	private String m_name;
	public Person() {
		this("�̸�����(����)");
	}
	public Person(String name) {
		m_name = name;
	}
	public void showPersonInfo() {
		System.out.println("��� �̸��� " + m_name);
	}
}
