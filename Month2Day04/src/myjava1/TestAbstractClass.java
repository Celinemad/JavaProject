package myjava1;
import java.util.Scanner; 

/*
 * 1. ��� ���� �ۼ��� ���� �׸��� ������ �߻� Ŭ������ �߻� �޼ҵ带 ����ؼ� ����(�޼ҵ��� ����� ���������� �и�)
 * 		-> �ٸ� Ŭ������ �ۼ��� �� ������ �ִ� ����� Ŭ������ ����
 */
// 2. Shape Ŭ������ ����� Ŭ������ ����
abstract class Shape{
	// 3. draw() �޼ҵ带 �߻� �޼ҵ�� ����
	public abstract void draw();
}
//4. Line Ŭ������ ���� + Shape Ŭ������ ��� + draw() �߻� �޼ҵ带 ������
class Line extends Shape {
	public void draw() {
		System.out.println("���� ȭ�鿡 �׷��ݴϴ�.");
	}
}
// 5. Rect Ŭ������ ���� + Shape Ŭ������ ��� + draw() �߻� �ɼҵ带 ������
class Rect extends Shape {
	public void draw() {
		System.out.println("�簢���� ȭ�鿡 �׷��ݴϴ�.");
	}
}
// 6. Circle Ŭ������ ���� + Shape Ŭ������ ��� + draw() �߻� �޼ҵ带 ������
class Circle extends Shape {
	 public void draw() {
		 System.out.println("���� ȭ�鿡 �׷��ݴϴ�.");
	 }
}

public class TestAbstractClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. �� �׸��� 2. �簢�� �׸��� 3. �� �׸��� 4. ��Ÿ");
		
		int menu = scanner.nextInt();
		
		if(menu == 1) {
			Line line = new Line();
			line.draw();
		}
		else if(menu == 2) {
			Rect rect = new Rect();
			rect.draw();
		}
		else if(menu == 3) {
			Circle circle = new Circle();
			circle.draw();
		}
		else {
			System.out.println("�޴��� ���� ��ȣ�� �Է��ؼ� ������ �׸� �� �����ϴ�.");
		}
		
	}

}
