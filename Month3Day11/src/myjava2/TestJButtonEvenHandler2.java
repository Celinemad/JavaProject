package myjava2;
/*
 * 1. ����: Ư���� ������ ����ؼ� ���� �ϳ��� ��ư���� �̺�Ʈ ó�����ִ� ����
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyJFrame extends JFrame {
	// 2. ��ư ��ü�� ����
	private JButton m_button = new JButton("1");
	private Container m_container = null;
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		m_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���� �ϳ��� ��ư���� Ŭ�� �̺�Ʈ�� ó��");
			}
		});
		m_container.add(m_button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
}
public class TestJButtonEvenHandler2 {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jbutton event");
	}

}
