// 1. ���ο� Ŭ������ Student2�� ����(����)
// 2. ������ ������� �ִ� Person Ŭ������ �θ� Ŭ������ ����
// 3. �θ� Ŭ�������� ������ ��� ������ �޼ҵ� ���� ��ɾ �ڵ����� ����
// 	-> ���ܵǴ� ��������� �޼ҵ�: private ���� ������
//	-> ������ �޼ҵ�
public class Student2 extends Person {
	// 4. ���ο� �޼ҵ��� showStudentInfo()�� ����
	//	1) Person Ŭ�����κ��� ��ӹ��� eat(), sleep() �޼ҵ带 �ٷ� ����ϱ�
	public void showStudentInfo() {
		System.out.println("Student2 Ŭ�������� ���� �߰��� �޼ҵ�");
		System.out.println("Person Ŭ�����κ��� ��� ���� eat(), sleep() �޼ҵ带 �ٷ� ���");
		eat();
		sleep();
	}
}
