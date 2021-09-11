package myjava;
/*
 * 1. ����: ������ �׸��� ������ �ۼ�
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 2. ȭ�鿡 �����츦 ������ִ� Ŭ������ ����: JFrame Ŭ������ ��� ����
 */
class MyWindow extends JFrame {
	
	/*
	 * 7. �Ʒ����� ���� MyCanvas Ŭ������ ����ϱ� ���� ��ü�� ����
	 */
	private MyCanvas m_canvas = new MyCanvas();
	/*
	 * 8. �����̳� ��ü�� �ּҸ� ������ ���� ���� ����
	 */
	private Container m_container = null;
	/*
	 * 9. ������ ����
	 */
	public MyWindow(String title) {
		super(title);
		m_container = getContentPane();
		// 10. �������� ��� ������ �簢���� �׸���
		m_container.add(m_canvas);
		// 11. ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 12. �������� ũ�⸦ ����
		setSize(500, 500);
		// 13. �����츦 ȭ�鿡 ���
		setVisible(true);
	}
}

/*
 * 3. ĵ���� ������ ���ִ� ���ο� Ŭ������ ����: JPanel �����̳� Ŭ������ ��� ����
 */
class MyCanvas extends JPanel {
	/*
	 * 4. paintComponent() �޼ҵ带 �� ������
	 * -> ����: Ư�� ������Ʈ �Ǵ� �����̳� ���� ���
	 */
	@Override
	public void paintComponent(Graphics g) {
		// 5. ��! �ۼ��� ��ɾ�� ���� �����̳ʸ� ȭ�鿡 ������ִ� ��ɾ��� super.paintComponent()�� �ۼ�
		super.paintComponent(g);
		// 6. ȭ�鿡 ����� �簢���� �� ���� �Ǵ� ���� ������ �����ϱ�
		// 1) ������ Color Ŭ������ ����ؼ� ���ο� ���� ��ü�� ������ �Ŀ� ���
		Color color = new Color(255, 0, 0);
		// 2) drawRect() �޼ҵ� �Ǵ� fillRect() �޼ҵ带 ���
		g.setColor(color);
		g.drawRect(0, 0, 100, 100);
		g.fillRect(0, 0, 100, 100);
	}
}

public class TestShape {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test shape");
	}

}
