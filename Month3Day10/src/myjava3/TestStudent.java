package myjava3;
/*
 * 1. ����: ����ڷκ��� �л��� �̸�, �а�, �ּҸ� �Է� �޴� ���α׷�
 * 	1) ȭ�� ����(Design)
 * 		��. ���̾ƿ� ������ Ŭ����: FlowLayout
 * 		��. �л��� �̸��� JLabel�� JTextField Ŭ������ ����ؼ� ǥ��
 * 			- JLabel: "�̸� �Է�:" �ؽ�Ʈ�� ���
 * 			- JTextField: �⺻ �л� �̸��� "ȫ�浿" �ؽ�Ʈ�� ���
 * 		��. �л��� �а� ���� JLabel, JTextField Ŭ������ ����ؼ� ǥ��
 * 			- JLabel: "�а� �Է�:" �ؽ�Ʈ�� ���
 * 			- JTextField: �⺻ �а��� "���������к�" �ؽ�Ʈ�� ���
 * 		��. �л��� �� �ּ�
 * 			- JLabel: "�ּ� �Է�:" �ؽ�Ʈ�� ���
 * 			- JTextField: �⺻ �ּ��� "" �ؽ�Ʈ�� ���
 * 		��. �Է� �Ϸ� ��ư�� ���
 * 			- JButton ������ = new JButton("�Է¿Ϸ�");
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MyJFrame Ŭ������ ����
class MyJFrame extends JFrame implements ActionListener {
	
	// �л� �̸��� ǥ���� �� ����� ��ü���� ����
	private JLabel m_nameLabel = new JLabel("�̸� �Է�:");
	private JTextField m_nameTF = new JTextField("ȫ�浿", 5);
	
	// �а��� ǥ���� �� ����� ��ü���� ����
	private JLabel m_majorLabel = new JLabel("�а� �Է�:");
	private JTextField m_majorTF = new JTextField("���������к�", 10);
	
	// �ּҸ� ǥ���� �� ����� ��ü���� ����
	private JLabel m_addrLabel = new JLabel("�ּ� �Է�:");
	private JTextField m_addrTF = new JTextField("", 30);
	
	// �Է� �Ϸ� ��ư ��ü�� ����
	private JButton m_okButton = new JButton("�Է¿Ϸ�");
	
	// ���̾ƿ� ������ ��ü�� ����
	private FlowLayout m_fl = new FlowLayout();
	
	// ����Ʈ �� ������ ������ �� ����� ��ü ����
	private Container m_c = null;
	
	// �����ڸ� ����
	public MyJFrame(String title) {
		super(title);
		m_c = getContentPane();
		m_c.setLayout(m_fl);
		
		/*
		 * m_okButton ��ư�� ����ڰ� Ŭ������ �� ó���� ��ɾ ���� �Լ� ���(�̺�Ʈ ó�� ���)
		 */
		m_okButton.addActionListener(this);
		
		/*
		 * ��� ������Ʈ���� ���ʴ�� ����Ʈ �� ������ �ֱ�
		 * 1) ����: �л��� �̸� ��, �ؽ�Ʈ�ʵ� -> �а� �󺧰� �ؽ�Ʈ�ʵ� -> �ּ� �󺧰� �ؽ�Ʈ�ʵ�
		 * 		-> �Է¿Ϸ� ��ư
		 */
		m_c.add(m_nameLabel);
		m_c.add(m_nameTF);
		
		m_c.add(m_majorLabel);
		m_c.add(m_majorTF);
		
		m_c.add(m_addrLabel);
		m_c.add(m_addrTF);
		
		m_c.add(m_okButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ڰ� �Է¿Ϸ� ��ư�� Ŭ������ �� ������ ��ɾ���� �ۼ�
		// 1. ����ڰ� Ŭ���� ��ư�� �����ϱ�
		JButton clickedButton = (JButton)e.getSource();
		if(clickedButton == m_okButton) {
			System.out.println("����ڰ� �Է¿Ϸ� ��ư�� Ŭ����");
			// 2. ����ڰ� �Է��� �̸��� ��������
			String tempName = m_nameTF.getText();
			// 3. ����ڰ� �ϳ��� �Է����� ������ �Է� ��û �޽��� â�� ����
			if(tempName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��! �̸��� �Է��ϼ���!");
				// ���콺 Ŀ���� ��ġ�� ����ڰ� �̸��� �Է��� �� �ִ� �Է�â���� �ڵ� �̵�
				m_nameTF.setFocusable(true);
				m_nameTF.requestFocus();
				return;
			} else {
				// ����ڰ� �̸��� �Է������� �ܼ� â�� ���
				System.out.println("����ڰ� �Է��� �̸��� "+ tempName);
			}
			// 4. ����ڰ� �Է��� �а��� ��������
			String tempMajor = m_majorTF.getText();
			if(tempMajor.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��! �а��� �Է��ϼ���!");
				m_majorTF.setFocusable(true);
				m_majorTF.requestFocus();
				return;
			} else {
				System.out.println("����ڰ� �Է��� �а��� "+ tempMajor);
			}
			// 5. ����ڰ� �Է��� �ּҸ� ��������
			String tempAddr = m_addrTF.getText();
			if(tempAddr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��! �ּҸ� �Է��ϼ���!");
				m_addrTF.setFocusable(true);
				m_addrTF.requestFocus();
				return;
			} else {
				System.out.println("����ڰ� �Է��� �ּҴ� " + tempAddr);
			}
		}
	}
}
public class TestStudent {

	public static void main(String[] args) {
		MyJFrame myJFrame = new MyJFrame("�л� ���� �Է�");
		
		
	}

}
