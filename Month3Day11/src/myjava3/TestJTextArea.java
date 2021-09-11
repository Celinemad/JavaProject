package myjava3;
/*
 * 1. ����: JLabel, JTextFiel, JTextArea, JScrollPane Ŭ������ ���
 * 	1) ����: JLabel���� ���α׷� ��ü ������ ���(***�ؽ�Ʈ �Է°� ��� ����***)
 *  2) ���̾ƿ� ������: FlowLayout
 *  3) �̺�Ʈ ó��: JTextField �Է� â���� ����ڰ� �ؽ�Ʈ�� �Է��ϰ� ����Ű�� ���� ���
 *  	-> ����ڰ� �Է��� �ؽ�Ʈ ��ü�� �����ͼ� JTextArea �Է�â�� ���� �߰�
 *  	-> ActionListener �������̽��� ���� + actionPerformed() �߻� �޼ҵ带 ������
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyJFrame extends JFrame {
	// ��ư ��ü�� ����
	private JButton m_button = new JButton("���");
	
	// 2. ������ ������ִ� JLabel ��ü�� ����
	private JLabel m_titleLabel = new JLabel("***�ؽ�Ʈ �Է°� ��� ����***");
	// 3. ����ڰ� �� ���� �ؽ�Ʈ �Է¿� ����� JTextField ��ü�� ����
	private JTextField m_tf = new JTextField("�ؽ�Ʈ�� �Է��ϼ���...", 30);
	// 4. �ؽ�Ʈ�� ȭ�鿡 ���� �� ������ִ� JTextArea ��ü�� ����
	private JTextArea m_ta = new JTextArea("", 30, 20);
	// 5. ��ũ�ѹٸ� ������ִ� JScrollPane ��ü�� ����
	private JScrollPane m_sp = new JScrollPane(m_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 6. Container ���� ������ ����
	private Container m_container = null;
	// 7. FlowLayout ��ü�� ����
	private FlowLayout m_f = new FlowLayout();
	// 8. ������ ����
	public MyJFrame(String title) {

		super(title);
		m_container = getContentPane();
		m_container.setLayout(m_f);
		
		// ����ڰ� �ؽ�Ʈ �ʵ� �Է� â���� ����Ű�� ������ �� ������ ��ɾ �ۼ�
		m_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ڰ� �ؽ�Ʈ�� �Է��ϰ� ����Ű�� ���� ��쿡
				String inputText = m_tf.getText();
				if(inputText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�ؽ�Ʈ�� �� �Է��ϼ���!");
					return;
				} else {
					m_ta.append(inputText + "\n");
				}
				
			}
		});
		
		// ��ư
		m_button.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputText = m_ta.getText();
				JOptionPane.showMessageDialog(null, "�ܼ� â�� ��µ˴ϴ�.");
				if(inputText.isEmpty()) {
					System.out.println("�ۼ��� �ؽ�Ʈ�� �����ϴ�.");
				} else {
					System.out.println(inputText);	
				}
			}
		});
		
		// ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_container.add(m_titleLabel);
		m_container.add(m_tf);
		m_container.add(m_sp);
		// ��ư
		m_container.add(m_button);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
}
public class TestJTextArea {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jtextfield jtextarea");
		
		
	}

}
