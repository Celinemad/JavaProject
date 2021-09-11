/*
 * 1. ����: ��� ���迡�� Ŭ���� ���� �� ��ȯ(ĳ����)
 * 	1) ��ĳ����: �ڽ� Ŭ���� Ÿ�� -> �θ� Ŭ���� Ÿ��(�ڵ� �� ��ȯ)
 * 	2) �ٿ�ĳ����: �θ� Ŭ���� Ÿ�� -> �ڽ� Ŭ���� Ÿ��(�����ڰ� ��������� �� ��ȯ �����ڸ� �ۼ�)
 * 		- ����) �ڽ�Ŭ������ ���������� = (�ڽ�Ŭ������) new �θ�Ŭ������();
 */
public class Main {
	
	/*
	 * 1. print() �޼ҵ带 ����: static ������(������)�� ����ؼ� ��� ��ü�� �Բ� ����� �� �ִ� ���� ��ɾ�
	 */

	public static void print(Person a) {
		// 2. �Ű� ������ Person a�� ���޵Ǿ��� ��ü�� �����ϱ� ���ؼ��� instanceof �����ڸ� ���
		if(a instanceof Person) {
			System.out.println("���� ���� a�� ����ų �� �ִ� Ŭ���� Ÿ���� Person");
		}
		if(a instanceof Student) {
			System.out.println("���� ���� a�� ����ų �� �ִ� Ŭ���� Ÿ���� Student");
		}
//		else {
//			System.out.println("���� ���� a�� ����ų �� �ִ� Ŭ���� Ÿ���� ��");
//		}
	}
	
	public static void main(String[] args) {
		// 1. Person Ŭ����: �θ� Ŭ����
		// 2. Student Ŭ����: �ڽ� Ŭ����
		
		// 3. ��ĳ���� ������ ����
		Person a = new Student();
		a.showPersonInfo();
		
		Student b = new Student();
		b.showPersonInfo();
		b.showStudentInfo();
		
		Student c = new Student("������б�");
		c.showStudentInfo();
		
		// print() static �޼ҵ带 ȣ��: ���������� a�� Person a�� �����ϱ�
		print(a);
		
		print(b);
		
		// 4. �ٿ�ĳ���� ������ ����
//		Student b = (Student)new Person();
		// ������ �߻��ϴ� ����: �޼ҵ� ������ ���� -> ����� �޼ҵ��� ��ɾ ���ۼ�
		
		
	}

}
