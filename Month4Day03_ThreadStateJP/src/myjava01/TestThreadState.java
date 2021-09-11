package myjava01;
/*
 * 1. ���� ���� ���� ������ ���¸� ����ϴ� ����
 * 	1) ���� ��� �������� ���� ���¸� JTextArea ������Ʈ�� ���
 * 	2) ���� ��� �������� ���� ���¸� JTextArea ������Ʈ�� ���
 */
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

import javax.swing.*;
import javax.swing.event.*;

// ���� ����� �����ϴ� ������ Ŭ���� ����
class MyAdderThread extends Thread {
	// run() �޼ҵ带 ������
	@Override 
	public void run() {
		java.math.BigInteger sum = new java.math.BigInteger("0");
		for(int i=1; i<=100; i++) {
			sum = sum.add(new BigInteger(i+""));
		}
	}
}

// ���� ����� �����ϴ� ������ Ŭ���� ����
class MyMulerThread extends Thread {
	// run() �޼ҵ带 ������
	@Override 
	public void run() {
		java.math.BigInteger result = new java.math.BigInteger("1");
		for(int i=1; i<=100; i++) {
			result = result.multiply(new BigInteger(i+""));
		}
	}
}

// ������ ���¸� ����ϴ� ������ Ŭ���� ����
class MyStateThread extends Thread {
	// ��������� �����ϱ�
	// ���� ���� �����ϰ� �մ� ������ ��ü�� �ּҸ� ������ ���� ������ ����
	private MyAdderThread m_add;
	// �������� �����ϰ� �ִ� ������ ��ü�� �ּҸ� ������ ���� ������ ����
	private MyMulerThread m_mul;
	
	// ���� ��� ������ ���¸� ����� �� ����� JLabel ��ü�� �ּҸ� ������ ���� ������ ���� 
	private JLabel m_addl;
	
	// ���� ��� ������ ���¸� ����� �� ����� JLabel ��ü�� �ּҸ� ������ ���������� ����
	private JLabel m_mull;
	
	// �����ڸ� �����ؼ� Ŭ���� �ܺο��� ����, ���� ������ ��ü�� �ּҸ� �޾ƿ���
	public MyStateThread(MyAdderThread add, MyMulerThread mul, JLabel addl, JLabel mull) {
		m_add = add;
		m_mul = mul;
		m_addl = addl;
		m_mull = mull;
	}
	// ���� ���� �����ϰ� �ִ� ������ ��ü�� ���¸� ȭ�鿡 ����ϱ� -> ���� �̵��ؼ� JLabel ���������� ������ �ּ���
	// ���� ���� �����ϰ� �ִ� ������ ��ü�� ���¸� ȭ�鿡 ����ϱ� 
	@Override public void run() {
		/* 
		 * 1. while �ݺ����� ����ؼ� ���� �ݺ����� �ۼ�
		 * -> ��������: �� ������ ��ü�� ���� ������ ��ü�� ��� TERMINATED ������ ���
		 */
		// ���� ������ ��ü�� ���� ���� ���� ������ ������ ����
		Thread.State adds = m_add.getState();
		// ���� ������ ��ü�� ���� ���� ���� ������ ������ ����
		Thread.State muls = m_mul.getState();
		// 2. ���� �ݺ����� �ۼ�
		while(true) {
			// ���� ��� �������� ���� ���¸� ȭ�鿡 ���
			m_addl.setText(adds.toString());
			// 1�� ���� CPU�� ���ڰ� �ϱ�
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				// return ��ɾ ����ؼ� run() �޼ҵ带 �����ϱ�
				e.printStackTrace();
				return;
			}
			// ���� ��� �������� ���� ���¸� ȭ�鿡 ��� 
			m_mull.setText(muls.toString());
			
			// ���� ���� ��� �������� ���� ���°� TERMINATED �Ǿ��ٸ� ���� ����� �ߴ��ϱ�
			if(adds == Thread.State.TERMINATED) {
				break;
			}
			
			// ���� ���� ��� �������� ���� ���°� TERMINATED �Ǿ��ٸ� ��������� �ߴ��ϱ�
			if(muls == Thread.State.TERMINATED) {
				break;
			}
			
			// ���� ��� �������� ���� ���� ���� ��������
			adds = m_add.getState();
			// ���� ��� �������� ���� ���� ���� ��������
			muls = m_mul.getState();
		}
	}
}

// ȭ�鿡 �����츦 ����ϴ� Ŭ���� ����
class MyWindow extends JFrame {
	/*
	 * JPanel Ŭ������ ����ؼ� ������ ȭ���� 2���� �����ϱ�
	 * -> private JPanel ���������� = new JPanel(new GridLayout(1, 2));
	 */
	private JPanel m_panel = new JPanel(new GridLayout(1, 2));
	// ���� ��� �������� ���� ���¸� ������ JLabel ��ü�� ����
	private JLabel m_addlbl = new JLabel();
	// ���� ��� �������� ���� ���¸� ������ JLabel ��ü�� ����
	private JLabel m_mullbl = new JLabel();
	// ���� ��� ������ ��ü�� ����
	private MyAdderThread m_addt = new MyAdderThread();
	// ���� ��� ������ ��ü�� ����
	private MyMulerThread m_mult = new MyMulerThread();
	// ������ ��ü�� ���¸� ����� �� ������ ��ü�� ����
	private MyStateThread m_st = new MyStateThread(m_addt, m_mult, m_addlbl, m_mullbl);
	// �����̳� ��ü�� �ּҸ� ������ ���� ������ ����
	private Container m_container = null;
	// �����ڸ� ����
	public MyWindow(String title) {
		// ������ ���� ���ڿ� ��� 
		super(title);
		// �����̳� ��ü�� �ּҸ� ��������
		m_container = getContentPane();
		// �ǳ� ��ü�� ���� �� ��ü�� �ֱ�
		m_panel.add(m_addlbl);
		// �ǳ� ��ü�� ���� �� ��ü�� �ֱ�
		m_panel.add(m_mullbl);
		// �ǳ� ��ü�� BorderLayout�� ��� ��ġ�� �ֱ�
		m_container.add(m_panel, BorderLayout.CENTER);
		// ������ ���� �̺�Ʈ ó���ϱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������ ũ��� ȭ�� ��ü ũ��� ����
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// ������ ũ�� ����
		setResizable(false);
		// �����츦 ȭ�鿡 ���
		setVisible(true);
		// ������ ��ü�� ������ ������ ���¸� ������ִ� m_st(MyStateThread Ŭ����)
		// + ���� �����带 �����ؾ� �ٸ� ������ ��ü���� ���� ���߿� �����.
		// -> start() �޼ҵ带 ȣ���ϱ� ���� setDaemon()�� ȣ�� -> ������ ����������.setDaemont(true);
		m_st.setDaemon(true);
		m_st.start();
		// sleep() �Լ��� ȣ���ؼ� ������Ű��(����: CPU�� ���� �ӵ��� �ʹ� ������ ����)
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		// ���� ��� ������ ��ü�� ���� ������ ���·� �����
		m_addt.start();
		// ���� ��� ������ ��ü�� ���� ������ ���·� �����
		m_mult.start();
	}
}

public class TestThreadState {

	public static void main(String[] args) {
		
		MyWindow window = new MyWindow("show thread state");
		
	}

}
