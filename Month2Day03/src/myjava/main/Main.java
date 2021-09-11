package myjava.main;
/*
 * 1. 방근 전에 정의한 Parent, Child 클래스를 사용하기
 * 	1) myjava1 패키지에 있는 Parent 클래스를 사용하기: import myjava1.Parent;
 * 	2) myjava2 패키지에 있는 Child 클래스를 사용하기: import myjava2.Child;
 */
import myjava1.Parent;
import myjava2.Child;

public class Main {

	public static void main(String[] args) {
		// 1. Parent 클래스를 사용하기
		Parent parent = new Parent();
		parent.show();
		
		Parent parent2 = new Parent();
		parent.show();
		
		// 2. Child 클래스를 사용하기
		Child child = new Child();
		child.useMa();
	}

}
