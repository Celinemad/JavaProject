package myjava2;
/*
 * 1. ����: ������ ���� ������ �ۼ�
 * 	- ���Ѵ븦 �����ϴ� ���� ���� ���� ���� ����� ���ÿ� �����ϴ� ���α׷�
 * 	- ��� �Ŀ��� ������� ���, ����ϴµ��� �ҿ�� �ð��� �� ������ ����ϱ�
 * 	- 1~10 ������ ���� ���, 1~10������ ���� ���
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// java.math.BigInteger Ŭ������ ����ϱ� ���� ��ɾ �� �ۼ��ϼ���
import java.math.BigInteger;

//������ ���¸� ����ϴ� ������ Ŭ���� ����
class MyStateThread extends Thread {
	// ��������� �����ϱ�
	// ���� ���� �����ϰ� �մ� ������ ��ü�� �ּҸ� ������ ���� ������ ����
	private MyAdderThread m_add;
	// �������� �����ϰ� �ִ� ������ ��ü�� �ּҸ� ������ ���� ������ ����
	private MyMulerThread m_mul;
	
	// ���� ��� ������ ���¸� ����� �� ����� JLabel ��ü�� �ּҸ� ������ ���� ������ ���� 
	private JTextArea m_addl;
	
	// ���� ��� ������ ���¸� ����� �� ����� JLabel ��ü�� �ּҸ� ������ ���������� ����
	private JTextArea m_mull;
	
	// �����ڸ� �����ؼ� Ŭ���� �ܺο��� ����, ���� ������ ��ü�� �ּҸ� �޾ƿ���
	public MyStateThread(MyAdderThread add, MyMulerThread mul, JTextArea addl, JTextArea mull) {
		m_add = add;
		m_mul = mul;
		m_addl = addl;
		m_mull = mull;
	}
	// ���� ���� �����ϰ� �ִ� ������ ��ü�� ���¸� ȭ�鿡 ����ϱ� -> ���� �̵��ؼ� JLabel ���������� ������ �ּ���
	// ���� ���� �����ϰ� �ִ� ������ ��ü�� ���¸� ȭ�鿡 ����ϱ� 
	@Override 
	public void run() {
		/* 
		 * 1. while �ݺ����� ����ؼ� ���� �ݺ����� �ۼ�
		 * -> ��������: ���� ������ ��ü�� ���� ������ ��ü�� ��� TERMINATED ������ ���
		 */
		// ���� ������ ��ü�� ���� ���� ���� ������ ������ ����
		Thread.State adds = m_add.getState();
		// ���� ������ ��ü�� ���� ���� ���� ������ ������ ����
		Thread.State muls = m_mul.getState();
		// 2. ���� �ݺ����� �ۼ�
		while(true) {
			// ���� ��� �������� ���� ���¸� ȭ�鿡 ���
			m_addl.append(adds.toString()+"\n");
			System.out.println(adds.toString());
			// 1�� ���� CPU�� ���ڰ� �ϱ�
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				// return ��ɾ ����ؼ� run() �޼ҵ带 �����ϱ�
				e.printStackTrace();
				return;
			}
			// ���� ��� �������� ���� ���¸� ȭ�鿡 ��� 
			m_mull.append(muls.toString()+"\n");
			System.out.println(muls.toString());
			
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

// 1~10 ������ �ͼ� ����� �����ϴ� ������ Ŭ������ ����
class MyAdderThread extends Thread {
	
	/*
	 * 1. ���� ��� ������ ����� �����ִ� JTextArea ��ü�� �ּҸ� ��������
	 * 1) MyWindow Ŭ�������� ����(�ٸ�Ŭ������ ����)
	 * 		��. �����ڸ� ����: public Ŭ������(JTextArea �Ű�������) { }
	 * 		��. �Ϲ� �޼ҵ带 ����: public void �޼ҵ��(JTextArea �Ű�������) { }
	 * 		-> ��������� ���� ����: private JTextArea ��������� = null;
	 */
	private JTextArea m_ta = null;
	
	// 2. ������
	public MyAdderThread(JTextArea ta) {
		m_ta = ta;
	}
	
	// 3. �Ϲ� �޼ҵ�
	public void setTA(JTextArea ta) {
		m_ta = ta;
	}
	
	// run() �޼ҵ带 �� �������ϱ�
	@Override
	public void run() {
		/*
		 * 1~10������ ���� ����� �����ϰ� �߰� ������ ���� ����� ��� ���
		 * ��� ���)
		 * 1+
		 * 2+
		 * 3+
		 * ...
		 * 10 = �������
		 * 
		 * �Ǵ�
		 * 1+2+3+...+10 = �������
		 * 
		 *  ���Ѵ� ���� ���� ���: �ִ밪�� ������ ���� ���� ���
		 *  -> BigInteger Ŭ������ ���
		 *  	-> ����: ���ڸ� ���ڿ��� ��ȯ -> ���ڷ��� �ٷ� ����ؼ� ����� ����
		 *  -> BigInteger Ŭ������ ����ؼ� ���� ���� �谣�� �߰� ���� ���� ���� ����� ������ ���� sum �Ǵ� total
		 *     ��ü�� ����
		 *     -> ����) BigInteger ������ = new BigInteger("����");
		 *     -> ��) BigInteger sum = new BigInteger("0");
		 */
		BigInteger sum = new BigInteger("0");
		// sum = sum + 1; -> �Ұ���(����) -> add() �޼ҵ带 ����ؾ� �մϴ�.
		// -> ����) sum = sum.add(new BigInteger("���Ұ�));
		// ��) sum = sum.add(new BigInteger(1+""));
		
		// ���� �����ϱ� ���� ���� �ð��� ���ϱ�
//		long start = System.currentTimeMillis();
		// ���� �� ������ ���� �ð��� ������ ������ ���� 
//		long end = 0L;
		
		// for �ݺ����� ����ؼ� 1+2+3+...+10������ ���� ����� �����ϱ� + ȭ�鿡 ����ϱ�
		for(int i=1; i<=10; i++) {
			sum = sum.add(new BigInteger(i+""));
			// ���� i ���� ȭ�鿡 ���
			// -> JTextArea Ŭ������ append() �޼ҵ带 ���
//			m_ta.append(i+"");
//			// if ���ǹ��� ����ؼ� ���� i ���� ������ ���� 10�� �ƴϸ� ������ +�� �ٹٲ� ��ȣ�� ���
//			if(i != 10)
//				m_ta.append("+\n");
		}
		// ��� ����� �� ��ģ �Ŀ��� = ��ȣ�� ���� ����� ȭ�鿡 ���
//		m_ta.append("="+sum+"\n");
		
		// ���� �� ��ģ ���� �ð��� ���ϱ�
//		end = System.currentTimeMillis();
		// �ҿ�ð��� ������ ���ϰ� �ӽ� ������ diff�� ����
//		long diff = end - start;
		// ȭ�鿡 �ҿ� �ð��� ����ϱ�
//		m_ta.append("�ҿ� �ð��� " + diff + "[������ �и�������]\n");
	}
}

// 1~10 ������ ���� ����� �����ϴ� ������ Ŭ������ ����
class MyMulerThread extends Thread{
	private JTextArea m_ta = null;
	
	// 2. ������
	public MyMulerThread(JTextArea ta) {
		m_ta = ta;
	}
	
	// 3. �Ϲ� �޼ҵ�
	public void setTA(JTextArea ta) {
		m_ta = ta;
	}
	
	// run() �޼ҵ� ������
	@Override 
	public void run() {
		BigInteger mul = new BigInteger("1");
		
		// ���� �����ϱ� ���� ���� �ð��� ���ϱ�
//		long start = System.currentTimeMillis();
		// ���� �� ������ ���� �ð��� ������ ������ ���� 
//		long end = 0L;
		
		for(int i=1; i<=10; i++) {
			mul = mul.multiply(new BigInteger(i+""));
//			m_ta.append(i+"");
//			if(i != 10)
//				m_ta.append("*\n");
		}
//		m_ta.append("="+mul+"\n");
		
		// ���� �� ��ģ ���� �ð��� ���ϱ�
//		end = System.currentTimeMillis();
		// �ҿ�ð��� ������ ���ϰ� �ӽ� ������ diff�� ����
//		long diff = end - start;
		// ȭ�鿡 �ҿ� �ð��� ����ϱ�
//		m_ta.append("�ҿ� �ð��� " + diff + "[������ �и�������]\n");
	}
}

class CompDiff extends Thread {
	// MyAdderThread Ŭ������ run() �޼ҵ忡�� ����ߴ� long diff ������ ���� ���� ������ ��������� ����
	private long m_diff01 = 0L;
	// MyMulerThread Ŭ������ run() �޼ҵ忡�� ����ߴ� long diff ������ ���� ���� ������ ��������� ����
	private long m_diff02 = 0L;
	// �Ϲ� �޼ҵ带 ���� �����ϱ�
	public void setdiff01(long diff01) {
		m_diff01 = diff01;
	}
	public void setdiff02(long diff02) {
		m_diff02 = diff02;
	}
	
	@Override 
	public void run() {
		if(m_diff01 > m_diff02) 
			JOptionPane.showMessageDialog(null, "���� ����� �� ���� ����");
		else if(m_diff01 < m_diff02) 
			JOptionPane.showMessageDialog(null, "���� ����� �� ���� ����");
		else
			JOptionPane.showMessageDialog(null, "����");
	}
}



// �����츦 ����ϴ� Ŭ���� ����
/*
 * 1. ����: JPanel Ŭ������ ����ؼ� ȭ���� 2���� �и��ϱ�
 * 	1) private JPanel ������ = new JPanel(new GridLayout(1,2));
 * 	2) ���� ��� ������ ����� ����� ��ü�� ����: JTextArea Ŭ������ ����ؼ� ��ü�� ����
 * 		- private JTextArea ������2 = new JTextArea();
 * 	3) ���� ��� ������ ����� ����� ��ü�� ����:
 * 		- private JTextArea ������3 = new JTextArea();
 * 	4) ��ũ�ѹٸ� ������� ��ü�� ����: ���� ��� ������ ������ִ� JTextArea ��ü�� �Բ� ���
 * 		- private JScrollPane ������4 = new JScrollPane(������2);
 * 	5) ���� ��� ������ ������ִ� JTextArea ��ü�� �Բ� ����� ��ũ�ѹٸ� ������� ��ü�� ����
 * 		- private JScrollPane ������5 = new JScrollPane(������3);
 * 	6) �����̳� ��ü�� �ּҸ� ������ ������ ����
 * 		- private Container ������6 = null;
 * 	7) MyAdderThread Ŭ������ ����ϱ� ���� ��ü�� ����
 * 		- private MyAdderThread ������7 = new MyAdderThread(������2);
 * 	8) MyMulerThread Ŭ������ ����ϱ� ���� ��ü�� ����
 * 		- private MyMulerThread ������8 = new MyMulerThread(������3);
 */
class MyWindow extends JFrame {
	// JPanel Ŭ������ ����ؼ� ��ü�� ����: ȭ�� ���ҿ� ���
	private JPanel m_panel = new JPanel(new GridLayout(1,2));
	// new JPanel(new GridLayout(2, 1));
	
	// Container ��ü�� �ּҸ� ������ ���� ������ ����: ȭ�鿡 ������Ʈ�� ���
	private Container m_container = null;
	
	// ���� ��� ������ ����� ������ JTextArea ��ü�� ����: ���� �� ���� ĭ ������ ���
	private JTextArea m_addta = new JTextArea();
	
	// JScrollPane Ŭ������ ����ؼ� ��ũ�� �ٸ� ���
	private JScrollPane m_addsp = new JScrollPane(m_addta);
	
	// ���� ��� ������ ����� ������ JTextArea ��ü�� ����
	private JTextArea m_multa = new JTextArea();
	private JScrollPane m_mulsp = new JScrollPane(m_multa);
	
	// ������ �۲�, ��Ÿ��, ũ�⸦ �ٲ� �� ����� ��Ʈ ��ü�� ����
	public static final Font MY_FONT = new Font("�ü�ü", Font.BOLD + Font.ITALIC, 30);
	
	// �߰�: MyAdderThread Ŭ������ ����ϱ� ���� ���� ������ ����
	private MyAdderThread m_adderth = new MyAdderThread(m_addta);
	
	// �߰�: MyMulerThread Ŭ������ ����ϱ� ���� ���� ������ ����
	private MyMulerThread m_mulerth = new MyMulerThread(m_multa);
	
	private MyStateThread m_st = new MyStateThread(m_adderth, m_mulerth, m_addta, m_multa);

	
	
	// �����ڸ� ����
	public MyWindow(String title) {
		// JFrame Ŭ������ �����ڸ� ȣ��
		super(title);
		
		// �����̳� ��ü�� �����ؼ� ��ü�� �ּҸ� �о�ͼ� m_container ��������� ����
		m_container = getContentPane();
		
		// ���� ��� ����� ������ JScrollPane ��ü�� �ǳڿ� �ֱ�
		m_panel.add(m_addsp);
		
		// ���� ��� ����� ������ JScrollPane ��ü�� �ǳڿ� �ֱ�
		m_panel.add(m_mulsp);
		
		// �����̳ʿ� �ǳ� �ֱ�
		m_container.add(m_panel);
		
		// ���� ��� ����� ������ JTextArea�� ���� �Ӽ��� �ٲٱ�
		m_addta.setFont(MY_FONT);
		
		// ���� ��� ����� ������ JTextArea�� ���� �Ӽ��� �ٲٱ�
		m_multa.setFont(MY_FONT);
		
		// �߰�: ���� ����� �����ϴ� ������ ��ü�� ����
//		m_adderth = new MyAdderThread(m_addta);
		
		// �߰�: ���� ����� �����ϴ� ������ ��ü�� ����
//		m_mulerth = new MyMulerThread(m_multa);
		
		// ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������ ũ��� ȭ�鿡 ������ �ϱ�
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// ������ ȭ���� ũ�⸦ ����ڰ� �ٲ��� ���ϵ��� �ϱ�
		setResizable(false);
		
		// �����츦 ���
		setVisible(true);
		
		m_st.setDaemon(true);
		m_st.start();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// �߰�: ���� ����� �����ϱ�
		m_adderth.start();
		
		// �߰�: ���� ����� �����ϱ�
		m_mulerth.start();
	}
}
public class TestCalcThread {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test calc thread");
		
		
	}

}
