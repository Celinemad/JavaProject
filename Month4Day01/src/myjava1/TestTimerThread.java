package myjava1;
/*
 * ����: ���ڰ� ���� JLabel�� ��µǰ� 1�� ���� ���߾��ٰ� �ٽ� ���ڸ� JLabel�� ���
 * 	-> ���ڴ� 0���� �����ؼ� 1�� ����
 * 
 * ����� Ŭ���� ���
 * 1. Thread Ŭ������ ��� �޴� �ڽ� Ŭ������ ����: MyTimerThread
 * 2. ȭ�鿡 �����츦 ������ִ� MyWindow Ŭ������ ����
 * 3. main() �޼ҵ带 ���� �ִ� TestTimerThread Ŭ������ ����
 * 
 * Ŭ������ �����ϱ� ���� import ��ɾ �ۼ�
 * 1. import java.awt.*;
 * 2. import java.awt.event.*;
 * 3. import javax.swing.*;
 * 4. import javax.swing.event.*;
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * Ŭ������ ������ ����� ����
 * -> �޸� ������ ���� ����Ͽ� ���α׷��� �����ϱ� ����
 */

// MyTimerThread Ŭ������ ����
/*
 * �ϴ� ��:
 * JLabel ��ü�� �����ؼ� ���ڸ� ��� + 1�� ���� ����(Thread.sleep())
 * 	-> sleep()�� static �޼ҵ��̱� ������ ��ü�� �������� ����. ��ü ���� �ٷ� Ŭ���� �̸����� ���� ����
 * 
 * JLabel ��ü�� �����ϴ� ���
 * 1) �����ڸ� ����: public Ŭ������(JLabel �Ű�������) { ��������� = �Ű�������; }
 * 2) �Ϲ� �޼ҵ带 ����: public void set + ���������(JLabel �Ű�������) { ��������� = �Ű�������; }
 * 	-> 1���� 2���� �����ϱ� ���� JLabel Ŭ������ ����ϴ� ���� ������ �����ؾ� �մϴ�.
 * 		-> ����) private JLabel ������ = null; // ��ü �ʿ� �����Ƿ� new ���� �ʰ� null
 */
class MyTimerThread extends Thread{
	
	// 3) JLabel ��ü�� �ּҸ� ������ ���������� ����
	private JLabel m_label = null;
	
	// 4) �����ڸ� �����ؼ� �ܺ� Ŭ�����κ��� JLabel ��ü�� �ּҸ� �Ű������� �����ɴϴ�.
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	
	// 5) set + ��������� �̸��� ���� ���ο� �Լ��� �����ؼ� �ܺ� Ŭ�����κ��� JLabel ��ü�� �ּҸ� �Ű������� ��������
	public void setLabel(JLabel label) {
		m_label = label;
	}
	
	// ��! run() �޼ҵ带 �������ؾ� �մϴ�.
	@Override
	public void run() {
		/*
		 * 1. JLabel ��ü�� ����� ���ڸ� ������ ������ ���� + �ʱ�ȭ(0)
		 */
		int num = 0;
		
		/*
		 * 2. while �ݺ����� ����ؼ� ������� �ʴ� ���� �ݺ����� �ۼ�
		 * 1) JLabel Ŭ������ setText() �޼ҵ带 ����ؼ� ���ڸ� �󺧿� ���
		 * 	-> m_label.setText(num+"");
		 *  �Ǵ� 
		 *  m_label.setText(Integer.toString(num));
		 * 2) ���ڸ� �ϳ��� ������Ű��: num++;
		 * 3) 1�� ���� CPU�� ���ڰ� �ϱ�:
		 * 	try {
		 * 		Thread.sleep(1000);
		 * 	} catch(InterruptedException ����ó��������) {
		 * 		�ٸ� �����忡 ���ؼ� ���ڰ� �ִ� �����尡 �ῡ�� ��� ����� ó���� �ۼ�
		 * 		return;
		 * 	}
		 */
		while(true) {
			m_label.setText(num+"");
			num++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

class MyTimerThread2 extends Thread{
	
	// 3) JLabel ��ü�� �ּҸ� ������ ���������� ����
	private JLabel m_label = null;
	
	// 4) �����ڸ� �����ؼ� �ܺ� Ŭ�����κ��� JLabel ��ü�� �ּҸ� �Ű������� �����ɴϴ�.
	public MyTimerThread2(JLabel label) {
		m_label = label;
	}
	
	// 5) set + ��������� �̸��� ���� ���ο� �Լ��� �����ؼ� �ܺ� Ŭ�����κ��� JLabel ��ü�� �ּҸ� �Ű������� ��������
	public void setLabel(JLabel label) {
		m_label = label;
	}
	
	// ��! run() �޼ҵ带 �������ؾ� �մϴ�.
	@Override
	public void run() {
		/*
		 * 1. JLabel ��ü�� ����� ���ڸ� ������ ������ ���� + �ʱ�ȭ(0)
		 */
		int num = 0;
		
		/*
		 * 2. while �ݺ����� ����ؼ� ������� �ʴ� ���� �ݺ����� �ۼ�
		 * 1) JLabel Ŭ������ setText() �޼ҵ带 ����ؼ� ���ڸ� �󺧿� ���
		 * 	-> m_label.setText(num+"");
		 *  �Ǵ� 
		 *  m_label.setText(Integer.toString(num));
		 * 2) ���ڸ� �ϳ��� ������Ű��: num++;
		 * 3) 1�� ���� CPU�� ���ڰ� �ϱ�:
		 * 	try {
		 * 		Thread.sleep(1000);
		 * 	} catch(InterruptedException ����ó��������) {
		 * 		�ٸ� �����忡 ���ؼ� ���ڰ� �ִ� �����尡 �ῡ�� ��� ����� ó���� �ۼ�
		 * 		return;
		 * 	}
		 */
		while(true) {
			m_label.setText(num+"");
			num++;
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

// MyWindow Ŭ������ ����: JFrame Ŭ������ ���
/*
 * 1. ȭ�� ����(����)
 * 	-> BorderLayout�� ��� ��ġ�� JLabel ��ü�� ���
 */
class MyWindow extends JFrame {
	// �߰�) JPanel ��ü ����
	private JPanel m_panel = new JPanel(new GridLayout(1,2));
	// �߰�) ���ο� JLabel ��ü ����
	private JLabel new_label = new JLabel("");
	// 1) JLabel ��ü�� ����
	private JLabel m_label = new JLabel("");
	// 2) Container ��ü�� �ּҸ� ������ ���� ������ ����
	private Container m_container = null;
	// 3) ȭ�鿡 ����� ������ ��Ʈ ũ�⸦ �ٲ� �� ����� Font ��ü�� ����
	private Font m_font = new Font("�ü�ü", Font.BOLD, 30);
	// 4) ������ ����: �ٸ� Ŭ�����κ��� ������ ���� ��ܿ� ����� �ؽ�Ʈ�� �Է� ����: String title
	
		// �߰��ϱ�: MyTimerThread
	private MyTimerThread m_thread = null;
	
	// �߰�)
	private MyTimerThread2 m_new_thead = null;
	
	public MyWindow(String title) {
		super(title);
		// 5) Container ��ü �����ϱ�
		m_container = getContentPane();
		// 6) Font ��ü�� �󺧿� ����ϱ�
		m_label.setFont(m_font);
			// �߰�)
		new_label.setFont(m_font);
		// 7) ȭ���� ��� ��ġ�� ���� ���
//		m_container.add(m_label);
		
			// �߰�: ���ο� ������ ��ü�� ����
		m_thread = new MyTimerThread(m_label);
			// �߰�)
		m_new_thead = new MyTimerThread2(new_label);
		
		// �߰�)
		m_panel.add(m_label);
		m_panel.add(new_label);
		
		// �߰�) JPanel ��ü�� �������� ��� ��ġ�� �ֱ�
		m_container.add(m_panel, BorderLayout.CENTER);
		
		// 8) ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 9) ������ ũ�⸦ ȭ���� ũ��� �ִ�ȭ
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 10) ������ ũ�⸦ ������Ű��
		setResizable(false);
		// 11) ������ ���
		setVisible(true);
		
			// �߰��ϱ�: ������ ��ü�� �����Ű��: start() �޼ҵ带 ȣ��
		m_thread.start();
			// �߰�)
		m_new_thead.start();
	}
	
}

public class TestTimerThread {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test timer thread");
	}

}
