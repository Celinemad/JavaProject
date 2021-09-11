package myjava4;

public class Main {

	public static void main(String[] args) {
		Parent parent = new Parent();
		Parent parent2 = new Parent(100);
		Child child = new Child();
		Child child2 = new Child(200);
		Child child3 = new Child(10, 20, 30);
		parent.show();
		parent2.show();
		child.show();
		child2.show();
		child3.showABC();
	}

}
