package myjava1;
/*
 * 1. ����: �⺻ �������� �̺�Ʈ ó���� ����� Ŭ������ �����ؼ� ����ϰ�
 *         �̸��� ���� Ư���������� �̺�Ʈ ó���� ����� Ŭ������ ��ü�� �ѹ��� �����ؼ� ����ϱ�
 *         
 * 	1) �⺻����: 5���� ��ư ��ü���� �����ؼ� ����ϱ�
 * 	2) Ư������: 1���� ��ư ��ü�� �����ؼ� ����ϱ�
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 2. JFrame Ŭ������ ��� �޴� MyJFrame Ŭ������ ���� + ActionListener �������̽��� ����
class MyJFrame extends JFrame implements ActionListener {
	
	// 4. 5���� JButton Ŭ������ ����ϴ� ��ü���� ����
	// 1) ��ư�� ����� �ؽ�Ʈ(��)�� ������ String �迭 ����
	public static final String[] ARR_BUTTON_TEXT = {"1", "2", "3", "4", "5"};
	// 2) JButton Ŭ������ ����ؼ� 5���� ��ư ��ü�� �ּҸ� ������ �� �ִ� �迭�� ����
	private JButton[] m_arr_button = new JButton[ARR_BUTTON_TEXT.length];
	// 3) �����̳� ������ ����
	private Container m_container = null;
	
	// 5. �����ڸ� ����
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		
		// 6. 5���� ��ư ��ü���� �����ϴ� for �ݺ���
		for(int i=0; i<m_arr_button.length; i++) {
			m_arr_button[i] = new JButton(ARR_BUTTON_TEXT[i]);
			m_arr_button[i].setActionCommand(ARR_BUTTON_TEXT[i]);
			m_arr_button[i].addActionListener(this);
		}
		
		// 5���� ��ư ��ü���� �����̳ʿ� �ֱ�
		// BorderLayout ���̾ƿ� �����ڸ� ���
		// 1. ���ʿ��� ���� 1�� ���� ��ư�� �ֱ�
		m_container.add(m_arr_button[0], BorderLayout.NORTH);
		// 2. �Ʒ��ʿ��� ���� 2�� ���� ��ư�� �ֱ�
		m_container.add(m_arr_button[1], BorderLayout.SOUTH);
		// 3. ������� ���� 3�� ���� ��ư�� �ֱ�
		m_container.add(m_arr_button[2], BorderLayout.CENTER);
		// 4. ���ʿ��� ���� 4�� ���� ��ư�� �ֱ�
		m_container.add(m_arr_button[3], BorderLayout.WEST);
		// 5. �����ʿ��� ���� 5�� ���� ��ư�� �ֱ�
		m_container.add(m_arr_button[4], BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
	
	// 3. actionPerformed() �޼ҵ带 ������
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		String command = clickedButton.getActionCommand();
		if(command.equals("1")) {
			JOptionPane.showMessageDialog(null, "����1 ��ư�� Ŭ��");
		} else if(command.equals("2")) {
			JOptionPane.showMessageDialog(null, "����2 ��ư�� Ŭ��");
		} else if(command.equals("3")) {
			JOptionPane.showMessageDialog(null, "����3 ��ư�� Ŭ��");
		} else if(command.equals("4")) {
			JOptionPane.showMessageDialog(null, "����4 ��ư�� Ŭ��");
		} else if(command.equals("5")) {
			JOptionPane.showMessageDialog(null, "����5 ��ư�� Ŭ��");
		}
	}
}
public class TestJButtonEventHandler {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jbutton");
		
	}

}
