// 5. main() �޼ҵ常�� ���� �ִ� Main Ŭ������ ����
public class Main {
	public static void main(String[] args) {
		
		// ���� ������ Point Ŭ������ �ٷ� ���
		Point point = new Point();
		point.showPoint();
		
		Point point2 = new Point(10,20);
		point2.showPoint();
		
		// ��� ���� ColorPoint Ŭ������ ���
		ColorPoint colorPoint = new ColorPoint();
		colorPoint.showColorPoint();
		// ��� ���� showPoint() �޼ҵ常 ���������� ȣ�� ����
		colorPoint.showPoint();
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		
		
		
		
		// ���� ������ Person Ŭ������ �ٷ� ���
		Person person = new Person();
		person.eat();
		person.sleep();
		
		// ��� ���迡 �ִ� Student2 Ŭ������ ���
		Student2 student2 = new Student2();
		student2.showStudentInfo();
		// ��� �޴� eat() �޼ҵ带 �ܵ����� ȣ��(���) ����
		student2.eat();
		// ��� �޴� sleep() �޼ҵ带 ���������� ���
		student2.sleep();
		
		System.out.println("===================================");
		
		
		
		// 1) Student Ŭ������ ����ϱ� ���� ��ü�� ����
		Student student = new Student();
		// 2) StudentWorker Ŭ������ ����ϱ� ���� ��ü�� ����
		StudentWorker studentWorker = new StudentWorker();
		// 3) Teacher Ŭ������ ����ϱ� ���� ��ü�� ����
		Teacher teacher = new Teacher();
		// 4) Professor Ŭ������ ����ϱ� ���� ��ü�� ����
		Professor professor = new Professor();
		
		// 5) Student Ŭ�������� ������ eat() �޼ҵ带 ȣ��
		student.eat();
		// 6) Student Ŭ�������� ������ sleep() �޼ҵ带 ȣ��
		student.sleep();
		
		studentWorker.eat();
		studentWorker.sleep();
		
		teacher.eat();
		teacher.sleep();
		
		professor.eat();
		professor.sleep();
		
	}
}
