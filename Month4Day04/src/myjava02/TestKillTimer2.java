package myjava02;
/*
 * 1. ����: ����ڰ� ��ư�� Ŭ���ϸ� MyTimerThread Ŭ������ finish() �޼ҵ带 ȣ���ؼ�
 * 		   ��� ������ m_flag�� ���� true�� ����(����)�ؼ� ������ �����带 ����
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MyTimerThread Ŭ������ ����: ȭ�鿡 ���ڸ� ���
class MyTimerThread extends Thread {
	// JLabel ��ü�� �ּҸ� ������ ���� ���� ����
	private JLabel m_label = null;
	// ȭ�鿡 ����� ���ڸ� ������ ������ ���� ����(0���� ���� ���ص� 0������ ������ ���̱� ����)
	private int m_num = 0;
	// ��� ������ ���� + �ʱ�ȭ(false�� ���� ���ص� false������ ������ ���̱� ����)
	private boolean m_flag = false;
	// �����ڸ� ����
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	// finish() �޼ҵ� ����
	public void finish() {
		m_flag = true;
	}
	// run() �޼ҵ� ������
	@Override
	public void run() {
		while (true) {
			m_label.setText(m_num + "");
			m_num++;
			// ��� ������ ���� �˻��ؼ� true �̸� run() �޼ҵ带 ������ �����ϱ�
			if(m_flag == true) {
				return;
			}
			// 1�� ���� �����带 ������Ű��
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// �����츦 ȭ�鿡 ������ִ� Ŭ������ ����
class MyWindow extends JFrame {
	// ���ڸ� ������ִ� JLabel ��ü�� ����
	private JLabel m_label = new JLabel();
	// ��ư�� ������ִ� JButton ��ü�� ����
	private JButton m_btn = new JButton("kill timer");
	// �����̳� ��ü�� �ּҸ� ������ ���� ���� ����
	private Container m_c = null;
	// FlowLayout ��ü�� ����
	private FlowLayout m_fl = new FlowLayout();
	// MyTimerThread Ŭ������ ����ϱ� ���� ���� ������ ����
	private MyTimerThread m_th = null;
	// �����ڸ� ����
	public MyWindow(String title) {
		super(title);
		// �����̳� ��ü�� �ּҸ� ��������
		m_c = getContentPane();
		// ���̾ƿ� ������ Ŭ������ �ٲٱ�
		m_c.setLayout(m_fl);
		// ���� ȭ�鿡 ���
		m_c.add(m_label);
		// ��ư�� ȭ�鿡 ���
		m_c.add(m_btn);
		// Ÿ�̸� ������ ��ü�� ����
		m_th = new MyTimerThread(m_label);
		// ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����ڰ� ��ư�� Ŭ������ �� ������ ��ɾ���� �ۼ�
		m_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// finish() �޼ҵ带 ȣ��
				m_th.finish();
				// ��ư�� ��Ȱ��ȭ�ϱ�
				m_btn.setEnabled(false);
			}
			
		});
		// ������ ũ�� �����ϱ�
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// ������ ����
		setResizable(false);
		// ������ ���
		setVisible(true);
		// Ÿ�̸� ������ ��ü�� ���� ���·� ��ȯ
		m_th.start();
	}
}

public class TestKillTimer2 {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test kill timer2");
	}

}
