package myjava1;
/*
 * 1. ����: �����ڰ� ���� ������ Ŭ������ ����ؼ� ���� ����� �����ϱ�
 */
import java.util.*;

// 2. �л� ������ �������ִ� �л� Ŭ������ ���� + java.lang.Comparable �������̽��� �����ϱ�
class Student implements java.lang.Comparable<Student>{
	
	// 3. �л� ��ȣ�� ������ �� �ִ� ��� ������ ����
	int m_no;
	// 4. �л� �̸��� ������ �� �ִ� ��� ������ ����
	String m_name;
	
	// 5. �����ڸ� ����
	public Student(int no, String name) {
		m_no = no;
		m_name = name;
	}
	
	// �������� ���� Ŀ���� ��ȣ �ȿ� �ְ� Ctrl + spacebar
	@Override
	public int compareTo(Student o) {
		/// 6. �л� ��ȣ�� �������� �������� �����ϱ�
//		if(m_no > o.m_no) {
//			return 1;
//		} else if(m_no < o.m_no) {
//			return -1;
//		} else {
//			return 0;
//		}
		
//		int c = m_no - o.m_no; // ��������
//		return c;

		
		// ����: �л� �̸�(��������/��������)
		// 	-> ���ڿ� -> "���ڿ�1" == "���ڿ�2"(�ּҸ� ��: �츮�� ���� ���ؾ� ��)
		// 1) equals() �޼ҵ�: ����� ���ڿ� ���� ��� ���ڰ� �� ���ƾ� true, �ƴϸ� false(����� ���� 2������ �ƴϹǷ� X)
		// 2) String Ŭ������ ���� �ִ� compareTo() �޼ҵ带 ��� -> ��ȯ���� int
//		if(m_name.compareTo(o.m_name) > 0) {
//			return 1;
//		} else if(m_name.compareTo(o.m_name) < 0) {
//			return -1;
//		} else {
//			return 0;
//		}
		
		// compareTo() �޼ҵ嵵 ��ȯ���� int�̹Ƿ� return m_name.compareTo(o.m_name); ���� �ۼ� ����
		int c = m_name.compareTo(o.m_name);
		return c;
	}
	
	@Override
	public String toString() {
		return "�л���ȣ�� " + m_no + ", �л� �̸��� " + m_name;
	}
}


/*
 * 1. ���ο� ���� ��Ģ�� ���ϱ�: java.util.Comparator �������̽��� ����
 * 	  -> compare() �޼ҵ带 ������
 * 
 * 1) ������ Comparable �������̽��� compareTo() �޼ҵ��� ��ɾ�� ����
 *    -> �л� �̸����� �������� ����
 *    
 * 2) �л� �̸����� �������� ���� ����� ������ Ŭ���� ����: StudentComparator2
 * 3) �л� ��ȣ�� �������� ���� ����� ������ Ŭ���� ����: StudentComparator3
 * 4) �л� ��ȣ�� �������� ���� ����� ������ Ŭ���� ����: StudentComparator4
 */
class StudentComparator2 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// �л� �̸����� �������� ���� ����� ����
		int c = o2.compareTo(o1);
		return c;
	}
}
class StudentComparator3 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// �л� ��ȣ�� �������� ���� ����� ����
		if((o1.m_no - o2.m_no) > 0) {
			return 1;
		} else if((o1.m_no - o2.m_no) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
class StudentComparator4 implements java.util.Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// �л� ��ȣ�� �������� ���� ����� ����
		int c = o2.m_no-o1.m_no;
		return c;
	}
}

public class TestComparable {
	public static void main(String[] args) {
		// 6. 3���� ���� �ٸ� �л� ��ü�� ����: ��ȣ�� �̸� ��� �ٸ��� �����ؾ� �մϴ�.
		Student a = new Student(6, "ȫ�浿");
		Student b = new Student(2, "�ٱ浿");
		Student c = new Student(10, "���浿");
		
		// 7. ������ ������ 3���� ��ü�� �ٷ�� ���ϰ� �ϱ� ���ؼ� ArrayList �÷��� Ŭ������ �����ϱ�
		ArrayList<Student> list = new ArrayList<Student>();
		
		// 8. add() �޼ҵ带 �����ؼ� 3���� ��ü���� ArrayList Ŭ������ ����
		list.add(a);
		list.add(b);
		list.add(c);
		
		// 9. �����ϱ� ���� ��� �л� ��ü���� ���� �ִ� �л� ��ȣ�� �̸����� ���
		System.out.println(list);
		
		// 10. ArrayList Ŭ������ �ִ� 3���� ��ü���� �����ϱ� ���ؼ� Collections Ŭ������ sort() �޼ҵ带 ����
		Collections.sort(list); 
		// Collections�� �ִ� sort() �޼ҵ尡 java.lang.Comparable�� �ִ� compareTo()�� �ҷ���
		
		// 11. ���� ����� ȭ�鿡 ���
		System.out.println(list);
		
		// 12. ������ ���� StudentComparator2 Ŭ������ ����ϱ� ���ؼ��� ���ο� ��ü�� ���� (Comparable�� ��ü ����X & sort() �޼ҵ� ����)
		StudentComparator2 comp2 = new StudentComparator2();
		
		// 13. ������ ���� StudentComparator3 Ŭ������ ����ϱ� ���ؼ��� ���ο� ��ü�� ����
		StudentComparator3 comp3 = new StudentComparator3();
		
		// 14. ������ ���� StudentComparator4 Ŭ������ ����ϱ� ���ؼ��� ���ο� ��ü�� ����
		StudentComparator4 comp4 = new StudentComparator4();
		
		// 15. �л� �̸����� �������� ���� ����� ����
		Collections.sort(list, comp2);
		System.out.println(list);
		
		// 16. comp3 ��ü ���� ������ ���
		Collections.sort(list, comp3);
		System.out.println(list);
		
		// 17. comp4 ��ü ���� ������ ���
		Collections.sort(list, comp4);
		System.out.println(list);
	}

}
