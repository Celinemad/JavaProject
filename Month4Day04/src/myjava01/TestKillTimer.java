package myjava01;
/*
 * 1. ����: ���� ���� ���� Ÿ�̸Ӹ� ����ڰ� ������ �����Ű�� ���α׷��� �ۼ�
 * 
 * 1) ȭ�� ����(����)
 *     ��. ȭ�鿡 ���� 0 -> 1 -> 2 -> ...(���Ѵ�)�� ����ϴ� ��ü�� ����: JLabel m_label = new JLabel();
 *     ��. ����ڰ� ���콺�� ���� �� �ִ� ��ư ��ü�� ����: JButton m_button = new JButton("kill timer");
 *     ��. Layout Manager Ŭ������ FlowLayout: ��ü�� �����ϱ� FlowLayout m_fl = new FlowLayout();
 *     ��. �����̳� ��ü�� �ּҸ� ������ ���� ������ ����: Container m_c = null;
 *         - �����ڸ� ������ �Ŀ� ���ο��� m_c = getContentPane();
 *         - ���� ���̾ƿ� �Ŵ��� Ŭ������ BorderLayout�� FlowLayout���� �ٲٱ�: m_c.setLayout(m_fl);
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// +) restart ��ư�� ���� MyTimerThread2 
class MyTimerThread2 extends Thread {
	private JLabel m_label;
	private int m_num;
	public MyTimerThread2 (JLabel label, int num) {
		m_label = label;
		m_num = num;
	}
	// +) run() �޼ҵ带 �������ϱ�
	@Override 
	public void run() {
		while(true) {
			m_label.setText(m_num + "");
			m_num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

// JLabel�� ���ڸ� ������ִ� MyTimerThread Ŭ������ ����
class MyTimerThread extends Thread {
	// JLabel ��ü�� �ּҸ� ������ ���� ������ ����
        // �ϳ��� Ŭ�������� �ϸ� �޸𸮰� �ö�(class�� ���� �����ϴ°� ����)
	private JLabel m_label;
	
	// +) flag ����
	private boolean m_flag = false;
	
	private int m_num;
	private MyTimerThread2 m_th2 = null;
	// �����ڸ� �����ؼ� �ٸ� Ŭ�����κ��� JLabel ��ü�� �ּҸ� ��������
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	// +) finish() �޼ҵ� ����
	public void finish() {
		m_flag = true;
	}
	// run() �޼ҵ带 �������ϱ�
	@Override
	public void run() {
		// ȭ�鿡 ����� ���ڸ� �ӽ÷� ������ ������ ���� + �ʱ�ȭ
		m_num = 0;
		// while �ݺ����� ����ؼ� ���� �ݺ����� �ۼ�
		while(true) {
			// JLabel�� setText() �޼ҵ带 ȣ���ؼ� ���� 0�� ȭ�鿡 ����ϱ�
			m_label.setText(m_num + "");
			// ������ ����� ���ڸ� �����
			m_num++;
			// sleep() �޼ҵ带 ȣ���ؼ� 1�� ���� �����带 �����ϱ�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("�����尡 ������ �����");
				e.printStackTrace();
//				return;
				// +)
				finish();
				m_th2 = new MyTimerThread2(m_label, m_num);
				m_th2.start();
			}
		}
	}
}

// ȭ�鿡 �����츦 ������ִ� Ŭ������ ����
class MyWindow extends JFrame {
	// ���ڰ� ��µ� JLabel ��ü�� ����
	private JLabel m_label = new JLabel();
	// ��ư ��ü�� ����
	private JButton m_button = new JButton("kill timer");
	// +) restart ��ư ��ü�� ����
	private JButton m_button2 = new JButton("restart");
	// FlowLayout ��ü�� ����
	private FlowLayout m_fl = new FlowLayout();
	// �����̳� ��ü�� �ּҸ� ������ ���� ������ ����
	private Container m_c = null;
	// MyTimerThread Ŭ������ ����ϱ� ���� ���� ������ ����
	private MyTimerThread m_th = null;
	// �����ڸ� ����
	public MyWindow(String title) {
		// ������ ���� ���
		super(title);
		// �����̳� ��ü�� �ּҸ� ��������
		m_c = getContentPane();
		// ���̾ƿ� ������ Ŭ������ �ٲٱ�
		m_c.setLayout(m_fl);
		// ȭ�鿡 JLabel ��ü�� ���
		m_c.add(m_label);
		// JLabel ���� ��ư ��ü�� ���
		m_c.add(m_button);
		// +) "kill timer" ��ư ���� "restart" ��ư ��ü�� ���
		m_c.add(m_button2);
		//������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����ڰ� ��ư�� Ŭ������ �� ������ ��ɾ���� �ۼ�
		m_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// interrupt() �޼ҵ带 ȣ��
				m_th.interrupt();
				// ��ư�� ����ڰ� ������ ���ϵ��� ��Ȱ��ȭ ���·� ��ȯ: setEnabled(false) �޼ҵ带 ȣ��
				m_button.setEnabled(false);
			}
			
		});
		// Ÿ�̸� ��ü�� ����
		m_th = new MyTimerThread(m_label);
		// ������ ũ�⸦ ����
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// ������ ũ�⸦ ����
		setResizable(false);
		// �����츦 ȭ�鿡 ���
		setVisible(true);
		// Ÿ�̸� ��ü�� ���� ������ ���·� ��ȯ��Ű��: start() �޼ҵ带 ȣ��
		m_th.start();
	}
	
}

public class TestKillTimer {

	public static void main(String[] args) {
		
		MyWindow window = new MyWindow("test fill timer");
		
	}

}
