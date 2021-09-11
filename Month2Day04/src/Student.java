// 2. 학생 클래스의 정의: 상속 관계
public class Student extends Person {
	private String m_sname;
	public Student() {
		this("학교이름없음");
	}
	public Student(String sname) {
		m_sname = sname;
	}
	public void showStudentInfo() {
		System.out.println("학교 이름은 "+ m_sname);
	}
}
