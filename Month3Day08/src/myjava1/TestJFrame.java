package myjava1;
/*
 * 1. ����: Swing GUI ���̺귯���� ����ؼ� ȭ�鿡 �����츦 ���
 *	1) import java. awt.*;
 * 	   import java.awt.event.*;
 * 	   import javax.swing.*;
 * 	   import javax.swing.event.*;
 * 
 * 	2) JFrame Ŭ������ ��ӹ޴� MyJFrame �̸��� ���� �ڽ� Ŭ������ ����
 * 	3) ��ư�� BorderLayout ���̾ƿ� �������� ��� ������ ���
 * 		- Container ������;
 * 		- ������ = getContentPane();
 * 		- JButton Ŭ������ ����ؼ� ��ư ��ü�� ����
 * 			- JButton ������2 = new JButton("�ؽ�Ʈ(��) ���ڿ�");
 * 		- ȭ�鿡 ��ư�� ���: ������.add(������2);
 * 
 * 	4) ������ ���� �̺�Ʈ ó�� ���
 * 		��. WindowListenner �������̽��� �����ؼ� 7���� �߻� �޼ҵ���� ������
 * 		�Ǵ�, JFrame Ŭ������ ���� �ִ� setDefaultCloseOperation() �޼ҵ带 ȣ��
 * 		- ��� ����: MyJFrame Ŭ������ ������ �޼ҵ� ���ο� �Ʒ� ��ɾ �߰�
 * 			- setDefaultCloseOperation(��);
 * 				- ��: JFrame.EXIT_ON_CLOSE
 * 					- CLOSE: �����츦 ���, EXIT: ���α׷��� ����(main() �޼ҵ带 ����)
 * 
 * 	5) ����ڰ� ��ư�� Ŭ������ �� ������ �� �ִ� ��ɾ �ۼ��ϴ� ���
 * 		- ActionListener �������̽��� ����
 * 			- actionPerformed() �޼ҵ带 ������
 * 		- setActionCommand() �޼ҵ带 ���: ��ư�� �߰��� �׼� �̺�Ʈ�� �߻����� �� ����� �� �ִ� ��Ť��� ���ڿ��� ����
 * 			- ����: ��ư����������.setActionCommand("������_���_���ڿ�");
 * 		- getActionCommand() �޼ҵ带 ����ؼ� �׼� �̺�Ʈ�� �߻��� ��ư�� ��� ���ڿ��� ��������
 * 			- actionPerformed() �޼ҵ� ���ο��� �ۼ�
 * 				- ��) JButton ������ = (JButton) �׼��̺�Ʈ_����������.getSource();
 * 				- String ������2 = ������.getActionCommand();
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// ȭ�鿡 ������ â�� ������ִ� MyJFrame Ŭ������ ����
class MyJFrame extends JFrame implements ActionListener{
	
	// ȭ�鿡 ����� ��ư ��ü�� ����
	private JButton m_button = new JButton("button");
	
	// ���ο� ��ư ��ü���� �� 4�� �����ϱ�
	// 1) 4���� ��ư�� ����� ���ڿ����� �̸� ����
		// final �� ���� �빮�ڷ� ������ ����
	public static final String [] ARR_BUTTONS_LABEL = {"2","3","4","5"};
	// 2) ��ư �迭 ��ü�� ����
	private JButton [] m_arr_buttons = new JButton[ARR_BUTTONS_LABEL.length];
	
	
	// ��ư�� ��µ� ����Ʈ �� ������ ���� �ּҸ� ������ ������ ����(���⼱ ����!)
	private Container m_container;
	
	// ��ư�� ��� ������ �迭�� �����ϱ�
	public static final String[] ARR_BUTTONS_ORI = {
			BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.WEST, BorderLayout.EAST
	};
	
	// �������� ����
	public MyJFrame(String title) {
		// ������ ������ ����
		super(title);
		// getContentPane() �޼ҵ带 ȣ���ؼ� ����Ʈ �� ������ ���� �ּҸ� �����ͼ� m_container ������ ����
		m_container = getContentPane();
		// ��ư�� ��� ���ڿ��� ����
		m_button.setActionCommand("1");
		// ��ư�� actionPerformed() �޼ҵ带 ����(���)
		m_button.addActionListener(this);
		// ��ư�� ǳ�� ���� ����� �߰��ϱ�: JButton Ŭ������ ���� �ִ� setToolTipText() �޼ҵ带 ���
		// -> ����: setToolTipText("ȭ�鿡����ҳ����� �ۼ�");
		m_button.setToolTipText("ǳ������");
		
		// �ݺ����� ����ؼ� 4���� ��ư ��ü���� ����(JButton Ŭ������ �����ڸ� ���)
		for(int i=0; i<m_arr_buttons.length; i++) {
			m_arr_buttons[i] = new JButton(ARR_BUTTONS_LABEL[i]);
			// setActionCommand() �޼ҵ带 ȣ��
			m_arr_buttons[i].setActionCommand(ARR_BUTTONS_LABEL[i]);
			// addActionListener() �޼ҵ带 ȣ��
			m_arr_buttons[i].addActionListener(this);
			// setToolTipText() �޼ҵ带 ȣ��
			m_arr_buttons[i].setToolTipText(ARR_BUTTONS_LABEL[i]);
			// actionPerformed() �޼ҵ� ���η� �̵��ؼ� �̺�Ʈ ó�� ��ɾ���� �߰��ϱ�
			
			// ��ɾ �� �Է��� �������� ���α׷� ���� -> ��� Ȯ��
		}
		
		// ��ư�� ����Ʈ �� ������ �ֱ�: add() �޼ҵ带 ȣ��
		m_container.add(m_button);
//		m_container.add(m_arr_buttons[0], BorderLayout.NORTH);
//		m_container.add(m_arr_buttons[1], BorderLayout.SOUTH);
//		m_container.add(m_arr_buttons[2], BorderLayout.WEST);
//		m_container.add(m_arr_buttons[3], BorderLayout.EAST);
		for(int i=0; i<4; i++) {
			m_container.add(m_arr_buttons[i], ARR_BUTTONS_ORI[i]);
		}
		// ������ ���� �̺�Ʈ ó���� ���� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������ ���� ũ��� ���� ũ�⸦ �����ϱ�: JFrame Ŭ������ setSize() �޼ҵ带 ���
		setSize(500, 500);
		// �����츦 ȭ�鿡 ����ϱ�
		setVisible(true);
	}
	
	// actionPerformed() �޼ҵ带 ������
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// ����ڰ� ��ư�� Ŭ������ �� JOptionPane Ŭ������ ����ؼ� �޽��� â�� ����ϱ�
		JButton clickedButton = (JButton)actionEvent.getSource();
		String actionCommand = clickedButton.getActionCommand();
		if(actionCommand.equals("1")) {
			JOptionPane.showMessageDialog(null, "����ڰ� 1�� ��ư�� Ŭ��");
			clickedButton.setBackground(Color.MAGENTA);
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("2")) {
			JOptionPane.showMessageDialog(null, "����ڰ� 2�� ��ư�� Ŭ��");
			clickedButton.setBackground(new Color(255, 102, 51));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("3")) {
			JOptionPane.showMessageDialog(null, "����ڰ� 3�� ��ư�� Ŭ��");
			clickedButton.setBackground(new Color(255, 102, 153));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("4")) {
			JOptionPane.showMessageDialog(null, "����ڰ� 4�� ��ư�� Ŭ��");
			clickedButton.setBackground(new Color(000, 102, 153));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("5")) {
			JOptionPane.showMessageDialog(null, "����ڰ� 5�� ��ư�� Ŭ��");
			clickedButton.setBackground(new Color(102, 255, 153));
			clickedButton.setOpaque(true);
		}
	}
}
public class TestJFrame {

	public static void main(String[] args) {
		// MyJFrame Ŭ������ ����ؼ� ��ü�� ����
		MyJFrame frame = new MyJFrame("test jframe");
		
		
	}

}
