package myjava1;
/*
 * 1. ����: JLabel Ŭ������ ����ؼ� �ؽ�Ʈ�� ���, �̹����� ���, �ؽ�Ʈ�� �̹����� ��� ���
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 2. JFrame Ŭ������ ��� �޴� MyJFrame Ŭ������ ����
class MyJFrame extends JFrame{
	// 3. ImageIcon Ŭ������ ����ؼ� �󺧿� ����� �̹��� ��ü�� ����
	private ImageIcon m_img = new ImageIcon("cake.png");
	// 4. ù ��° �� ��ü�� ����: �ؽ�Ʈ�� ���
	private JLabel m_label01 = new JLabel("Hello");
	// 5. �� ��° �� ��ü�� ����: �̹����� ���
	private JLabel m_label02 = new JLabel(m_img);
	// 6. �� ��° �� ��ü�� ����: �ؽ�Ʈ�� �̹��� ��θ� ���
	private JLabel m_label03 = new JLabel("Hello", m_img, JLabel.CENTER);
	// 7. �����̳� ���� �ּҸ� ������ ���� ����
	private Container m_container;
	// 8. FlowLayout ���̾ƿ� ������ ��ü�� ����
	private FlowLayout m_flowLayout = new FlowLayout();
	// 9. �ٸ� Ŭ�����κ��� ������ ���� ���ڿ��� �޴� �����ڸ� ����
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		
		// ���� JFrame Ŭ������ ���̾ƿ� ������ Ŭ������ BorderLayout���� FlowLayout���� ����
		m_container.setLayout(m_flowLayout);
		// ù ���翡�� �ؽ�Ʈ ���� ���
		m_container.add(m_label01);
		// �� ��° �׸񿡴� �̹��� ���� ���
		m_container.add(m_label02);
		// �� ���� ��� �׸񿡴� �ؽ�Ʈ�� �̹��� ��θ� ���� ���� ���
		m_container.add(m_label03);
		// ������ ���� �̺�Ʈ ó���� ���� ��ɾ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize);
		setResizable(false);
		setVisible(true);
	}
	
}

public class TestJLabel {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jlabel");
		
		
	}

}
