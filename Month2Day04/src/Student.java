// 2. �л� Ŭ������ ����: ��� ����
public class Student extends Person {
	private String m_sname;
	public Student() {
		this("�б��̸�����");
	}
	public Student(String sname) {
		m_sname = sname;
	}
	public void showStudentInfo() {
		System.out.println("�б� �̸��� "+ m_sname);
	}
}
