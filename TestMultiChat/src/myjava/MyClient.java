package myjava;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 1. ����: Ŭ���̾�Ʈ ��ǻ�Ϳ��� ����� ���α׷��� �ۼ�(����)
 * 
 * 2. �����츦 �����ϱ�
 *     - ����ڰ� JTextField�� ����� �Է� â���� �Է��� �޽����� ������ �����ϱ�
 *         -> ������ ���۽����ִ� ���� �ϱ� ���ؼ� JButton Ŭ������ ���
 */
// ȭ�鿡 �����츦 ������ִ� Ŭ������ ����
class MyWindow extends JFrame implements ActionListener {
	
	/*
	 * ȭ�� ����
	 * 1. ù ��° �� ��ܿ��� ���α׷� ������ ����ϴ� JLabel ��ü�� ����: BorderLayout ��ġ������ Ŭ������ NORTH
	 * 2. �Ʒ� �ٿ��� JTextField ��ü�� JButton ��ü�� ����: BorderLayout ��ġ ������ Ŭ������ SOUTH
	 */
	private JLabel m_title = new JLabel("***��Ƽê Ŭ���̾�Ʈ ���α׷�***");
	// +) id �Է� �ޱ�
	private JTextField m_idMsg = new JTextField("���̵� �Է��ϰ� ��ư�� Ŭ���ϼ���...");
	private JTextField m_inputMsg = new JTextField("�޽����� �Է��ϰ� ��ư�� Ŭ���ϼ���...");
	private JButton m_sendBtn = new JButton("�޽��� ����");
	
	/*
	 * ������ �޽����� ���� �� Socket ��ü�� ����
	 */
	private Socket m_socket = null;
	/*
	 * �������� Ŭ���̾�Ʈ�� ���� �޽����� �ӽ÷� ������ ��ü���� ����
	 */
	private InputStream m_is = null;
	private DataInputStream m_dis = null;
	/*
	 * ������ ��: �������� ����� Ŭ������ ���� ¦�� �ǵ��� Ŭ������ ����
	 */
	/*
	 * ������ �޽����� ���� �� ����� ��ü���� ����
	 */
	private OutputStream m_os = null;
	private DataOutputStream m_dos = null;
	
	/*
	 * �����̳� ��ü�� �ּҸ� ������ ���� ������ ����
	 */
	private Container m_c = null;
	
	/*
	 * �ǳ� ��ü�� ����: �뵵�� �޽��� �Է� â�� �޽��� ���� ��ư�� �� �ٷ� ���
	 */
	private JPanel m_p = new JPanel();
	
	// actionPerformed() �޼ҵ带 ������
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// ����ڰ� �޽����� �Է��ϰ� ��ư�� ���� ��쿡 ������ ��ɾ �ۼ��ϱ�
		// 1. ����ڰ� �Է��� �޽����� ��������
		String id = m_idMsg.getText();
		String msg = m_inputMsg.getText();
		// 2. ����ڰ� �޽����� �Է����� ������ �Է� ��û �޽��� â�� ����ϱ�
		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "���̵� �� �Է��ϼ���!");
			m_idMsg.setFocusable(true);
			m_idMsg.requestFocus();
			return;
		}
		if(msg.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�޽����� �� �Է��ϼ���!");
			m_inputMsg.setFocusable(true);
			m_inputMsg.requestFocus();
			return;
		}
		// 3. ����ڰ� �Է��� �޽����� �ֿܼ� ����ϱ�
		System.out.println("������� ���̵�� " + id);
		System.out.println("����ڰ� �Է��� �޽����� " + msg);
		// 4. ������ �޽����� ������
		try {
			if(m_dos != null) {
				m_dos.writeUTF(id);
				m_dos.writeUTF(msg);
				m_dos.flush();
				System.out.println("������ �޽����� ������[Ŭ���̾�Ʈ]");
			}
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	// �����ڸ� ����
	public MyWindow(String title) {
		super(title);
		// �����̳� ��ü�� �ּҸ� �����ͼ� m_c ��� ������ ����
		m_c = getContentPane();
		
		/*
		 * 1. ���α׷� ������ ȭ�鿡 ����ϱ�: BorderLayout.NORTH
		 *     -> m_c.add(m_title, BorderLayout.NORTH);
		 * 2. �޽��� �Է� â�� ȭ�鿡 ����ϱ�: �ǳڿ� ����
		 *     -> m_p.add(m_inputMsg);
		 *     
		 * 3. ��ư�� �ǳڿ� ����: m_p.add(m_sendBtn);
		 * 
		 * 4. �ǳ��� �Ʒ� ���⿡ ����: m_c.add(m_p, BorderLayout.SOUTH);
		 */
		m_c.add(m_title, BorderLayout.NORTH);
		m_p.add(m_idMsg);
		m_p.add(m_inputMsg);
		m_p.add(m_sendBtn);
		m_c.add(m_p, BorderLayout.CENTER);
		
		// ������ ���� �̺�Ʈ ó�� ��ɾ�: ���� ���� ��ɾ �߰��ϱ�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				/*
				 * ���� �����ϱ�: Socket Ŭ������ ���� �ִ� close() �Լ��� ȣ��
				 */
				try {
					if(m_socket != null) m_socket.close();
				} catch(Exception e2) {
					System.out.println("���� ���� �ÿ� ������ �߻�. ������ " + e2.getMessage());
				}
				System.exit(0);
			}
		});
		
		// ����ڰ� ��ư�� ������ �� �̺�Ʈ ó��
		m_sendBtn.addActionListener(this);
		
		// ������ ũ�� �����ϱ�
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// ������ ũ�⸦ �ٲ��� ���ϵ��� �����ϱ�
		setResizable(false);
		// �����츦 ȭ�鿡 ����ϱ�
		setVisible(true);
		
		m_idMsg.setFocusable(true);
		m_idMsg.requestFocus();
		m_idMsg.selectAll();
		m_inputMsg.setFocusable(true);
		m_inputMsg.requestFocus();
		m_inputMsg.selectAll();
		
		// ���߿� �Է��ϱ�
		// socket �� ���� try~catch�� ��� ��
		try {
			// ������ ������ �õ��ϱ�
			m_socket = new Socket("localhost", 50825);
			// ���� ������ ������ �Ǹ� ������ ��ɾ �ۼ��ϱ�
			System.out.println("���� ��ǻ�Ϳ� ���� ����Ǿ����ϴ�...");
			// ���� ��ǻ�ͷ� �޽����� ���� �� ����� ��ü�� ����
			m_is = m_socket.getInputStream();
			m_dis = new DataInputStream(m_is);
			// ���� ��ǻ�ͷ� �޽����� ���� �� ����� ��ü�� ����
			m_os = m_socket.getOutputStream();
			m_dos = new DataOutputStream(m_os);
			System.out.println("��� ��ü�� ����");
			// ���� ��ǻ�ͷ� �ȳ��ϼ���? �޽����� �����ϱ�
			m_dos.writeUTF("�ȳ��ϼ���?");
			// flush() �Լ��� ȣ���ؼ� �޽����� ���� ������
			m_dos.flush();
			System.out.println("������ �޽����� ������");
			// �������� ���� ��� �޽����� �ޱ�
			String inputMsgFromServer = m_dis.readUTF();
			System.out.println("�����κ��� ���� �޽����� " + inputMsgFromServer);
		} catch(UnknownHostException e1) {
			System.out.println("ȣ��Ʈ�� ������ �߻�");
			e1.printStackTrace();
		} catch(IOException e2) {
			System.out.println("�Է°� ��¿��� ������ �߻�");
			e2.printStackTrace();
		} catch(Exception e3) {
			System.out.println("�׹��� ������ �߻�");
			e3.printStackTrace();
		}
	}
}
public class MyClient {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("client window");
	}

}
