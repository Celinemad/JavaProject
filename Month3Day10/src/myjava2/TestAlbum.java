package myjava2;
/*
 * 1. ����: �ٹ� �������� ���� �̹������� ȭ�鿡 ���
 * 	- ���̾ƿ� �����ڴ� GridLayout�� ���
 * 		- ����) GridLayout ������ = new GridLayout(��, ��);
 * 			- ��: ���� ���� ����, ��: ���� ���� ����
 * 		- ��) GridLayout ������ = new GridLayout(3, 3);
 * 	- Container m_container;
 * 	  m_container = getContentPane();
 * 	  m_container.setLayout(������);
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// JFrame Ŭ������ ��� �޴� MyJFrame Ŭ������ ����
class MyJFrame extends JFrame implements ActionListener {
	
	// �� 9���� �̹��� ������ ����ϱ�
	// �� 9���� ���� �̸����� ���ڿ��� ����(�迭)
	public static final String[] IMG_FILE_NAMES = {"apple.png","bread.png","burger.png","chicken-leg.png","chocolate.png","donut.png","ice-cream.png","pizza.png","sandwich.png"};
	// �� 9���� �̹��� ���ϵ��� ����� ImageIcon �迭�� ����
	private ImageIcon[] m_imgs = new ImageIcon[IMG_FILE_NAMES.length];
	// �� 9���� ��ư ��ü���� ������ JButton �迭�� ����
	private JButton[] m_buttons = new JButton[IMG_FILE_NAMES.length];
	// GridLayout Ŭ������ ����ؼ� ��ü�� ����
	private GridLayout m_gl = new GridLayout(3,3);
	// Container Ŭ������ ����ؼ� ��ü�� ����
	private Container m_container = null;
	
	// �����ڸ� ����
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		m_container.setLayout(m_gl);
		
		for(int i=0; i<m_imgs.length; i++) {
			m_imgs[i] = new ImageIcon(IMG_FILE_NAMES[i]);
			
		}
		
		for(int i=0; i< m_buttons.length; i++) {
			m_buttons[i] = new JButton(m_imgs[i]);
			m_buttons[i].setActionCommand(IMG_FILE_NAMES[i]);
			m_buttons[i].addActionListener(this);
		}
		
		// 9���� ��ư���� ȭ�鿡 ����ϱ�
		for(int i=0; i< m_buttons.length; i++) {
			m_container.add(m_buttons[i]);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton clickedButton = (JButton)actionEvent.getSource();
		String actionCommand = clickedButton.getActionCommand();
		if(actionCommand.equals("apple.png")) {
			JOptionPane.showMessageDialog(m_buttons[0], "����ڰ� ��� �������� ����");
		} else if(actionCommand.equals("bread.png")) {
			JOptionPane.showMessageDialog(m_buttons[1], "����ڰ� �� �������� ����");
		} else if(actionCommand.equals("burger.png")) {
			JOptionPane.showMessageDialog(m_buttons[2], "����ڰ� ���� �������� ����");
		} else if(actionCommand.equals("chicken-leg.png")) {
			JOptionPane.showMessageDialog(m_buttons[3], "����ڰ� ġŲ �������� ����");
		} else if(actionCommand.equals("chocolate.png")) {
			JOptionPane.showMessageDialog(m_buttons[4], "����ڰ� ���ݸ� �������� ����");
		} else if(actionCommand.equals("donut.png")) {
			JOptionPane.showMessageDialog(m_buttons[5], "����ڰ� ���� �������� ����");
		} else if(actionCommand.equals("ice-cream.png")) {
			JOptionPane.showMessageDialog(m_buttons[6], "����ڰ� ���̽�ũ�� �������� ����");
		} else if(actionCommand.equals("pizza.png")) {
			JOptionPane.showMessageDialog(m_buttons[7], "����ڰ� ���� �������� ����");
		} else if(actionCommand.equals("sandwich.png")) {
			JOptionPane.showMessageDialog(m_buttons[8], "����ڰ� ������ġ �������� ����");
		}
	}
}
public class TestAlbum {

	public static void main(String[] args) {
		MyJFrame myJFrame = new MyJFrame("TestAlbum");
		
		
	}

}
