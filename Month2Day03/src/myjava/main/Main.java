package myjava.main;
/*
 * 1. ��� ���� ������ Parent, Child Ŭ������ ����ϱ�
 * 	1) myjava1 ��Ű���� �ִ� Parent Ŭ������ ����ϱ�: import myjava1.Parent;
 * 	2) myjava2 ��Ű���� �ִ� Child Ŭ������ ����ϱ�: import myjava2.Child;
 */
import myjava1.Parent;
import myjava2.Child;

public class Main {

	public static void main(String[] args) {
		// 1. Parent Ŭ������ ����ϱ�
		Parent parent = new Parent();
		parent.show();
		
		Parent parent2 = new Parent();
		parent.show();
		
		// 2. Child Ŭ������ ����ϱ�
		Child child = new Child();
		child.useMa();
	}

}
