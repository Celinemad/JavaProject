/*
 * 1. ����: �޼ҵ� �������̵� ������ �ۼ�
 * 	1) ���� �ǹ����� ����ϰ� �ִ� �ڵ带 �ۼ�
 * 	2) ������ ȭ�鿡 �׷��ִ� ����
 * 		��. ���� ����ڿ��� �޴��� �����ֱ�
 * 		��. �޴� ������ 1. �� �׸��� 2. �簢�� �׸��� 3. �� �׸��� 4. ��Ÿ
 * 		��. ����ڰ� 1�� �Է��ϸ� ���� �׷��ݴϴ�. �޽����� ���
 * 		��. ����ڰ� 2�� �Է��ϸ� �簢���� �׷��ݴϴ�. �޽����� ���
 * 		��. ����ڰ� 3�� �Է��ϸ� ���� �׷��ݴϴ�. �޽����� ���
 * 		��. ����ڰ� 4�� �Է��ϸ� �׷��� ������ �����ϴ�. �޽����� ���
 */
import java.util.Scanner;
// 2. �ֻ��� Ŭ������ Shape�� ����(ShapeŬ������ public�̸� �ȵ�. 
// ���� �̸��� �����ϴ� public class�� 1:1�� �ϳ��� �����ؾ� �ϱ� ����)
// ex) TestMethodOverriding.java -> public class TestMethodOverriding
class Shape {
	// 3. ��ӹ޴� ��� �ڽ� Ŭ�������� �԰� ����� �� �ִ� draw() �޼ҵ带 ����
	public void draw() {
		System.out.println("�׷��ݴϴ�.");
	}
}
// 4. Line Ŭ������ ����: Shape Ŭ������ ���
class Line extends Shape {
	// 4. ��� ���� draw() �޼ҵ��� ��ɾ �ٲٱ� (������: �޼ҵ� �������̵�)
	public void draw() {
		System.out.println("���� �׷��ݴϴ�.");
	}
}
// 6. Rect Ŭ������ ����: Shape Ŭ������ ���: �簢�� Ŭ����
class Rect extends Shape {
	//  7. draw() �޼ҵ带 ������
	public void draw() {
		System.out.println("�簢���� �׷��ݴϴ�.");
	}
}
// 8. Circle Ŭ������ ����: Shape Ŭ������ ���
class Circle extends Shape {
	// 9. draw() �޼ҵ带 ������
	public void draw() {
		System.out.println("���� �׷��ݴϴ�.");
	}
}
class Tri extends Shape {
	public void draw() {
		System.out.println("�ﰢ���� �׷��ݴϴ�.");
	}
}

public class TestMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10. Scanner ��ü�� ����
		Scanner scanner = new Scanner(System.in);
		// 11. ����ڰ� ������ ������ �� �ֵ��� �޴��� ���
		System.out.println("1. �� �׸��� 2. �簢�� �׸��� 3. �� �׸��� 4. �ﰢ�� �׸��� 5. ��Ÿ");
		// 12. ����ڷκ��� �޴� ��ȣ�� ������ �Է� �ޱ�
		int menu = scanner.nextInt();
		// 13. ����ڰ� 1�� �Է��� ����� ó���� �ۼ�
		if(menu == 1) {
			Line line = new Line();
			line.draw();
		}
		// 14. ����ڰ� 2�� �Է��� ����� ó���� �ۼ�
		else if (menu == 2) {
			Rect rect = new Rect();
			rect.draw();
		}
		// 15. ����ڰ� 3�� �Է��� ����� ó���� �ۼ�
		else if(menu == 3) {
			Circle circle = new Circle();
			circle.draw();
		}
		else if(menu == 4) {
			Tri tri = new Tri();
			tri.draw();
		}
		// 16. ����ڰ� �޴��� ���� ��ȣ�� �Է��� ����� ó���� �ۼ�
		else {
			System.out.println("�޴��� ���� ��ȣ�� �Է��ؼ� ������ �׸� �� �����ϴ�.");
		}
	}

}
