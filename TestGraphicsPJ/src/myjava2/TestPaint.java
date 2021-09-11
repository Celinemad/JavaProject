package myjava2;
/*
 * 1. ����: ��������� �������ִ� �׸���(paint)�� ����ϰ� ������ ���α׷�
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 2. �����츦 ������ִ� Ŭ������ ����
 */
class MyWindow extends JFrame implements ActionListener {
	
	// 1) ����ڰ� ������ ��ư�� ���� ���� �ٸ� ���� ���� ���� ��� ������ ����
	// ��. ����ڰ� �� �׷��ֱ� ��ư�� ������ �� ����� ���� 0�� ���������� ������ ����� ����
	public static final int DRAW_LINE = 0;
	// ��. ����ڰ� �簢�� �׷��ֱ� ��ư�� ������ �� ����� ���� 1�� ���������� ������ ����� ����
	public static final int DRAW_RECT = 1;
	// ��. ����ڰ� �ﰢ�� �׷��ֱ� ��ư�� ������ �� ����� ���� 2�� ���������� ������ ����� ����
	public static final int DRAW_TRI = 2;
	// ��. �� �׷��ֱ� ��ư ���� �� ���
	public static final int DRAW_CIRCLE = 3;
	// ��. ����ڰ� Ŭ���� ��ư�� ���� ���� ������ ���� ����
	private int m_selectedShape = DRAW_LINE;
	
	// 2) ���� ��ü�� �����ϱ�
	private JToolBar m_tb = new JToolBar("shape toolbar");
	
	// 3) �� �׷��ֱ� ��ư ��ü�� ����
	private JButton m_drawLineBtn = new JButton("��");
	
	// 4) �簢�� �׷��ֱ� ��ư ��ü�� ����
	private JButton m_drawRectBtn = new JButton("�簢��");
	
	// 5) �ﰢ�� �׷��ֱ� ��ư ��ü�� ����
	private JButton m_drawTriBtn = new JButton("�ﰢ��");
	
	// 6) �� �׷��ֱ� ��ư ��ü�� ����
	private JButton m_drawCirBtn = new JButton("��");
	
	// 7) �����̳� ��ü�� �ּҸ� ������ ���� ������ ����
	private Container m_container = null;
	
	// 8) ��ư ������ ���� ���ڿ� �迭
	public static final String[] BTN_ACTION_COMMAND = {"LINE", "RECT", "TRI", "CIR"};
	
	/*
	 * 3. actionPerformed() �޼ҵ带 ������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	/*
	 * 4. �������� ������ ����ϴ� ������ ����
	 */
	public MyWindow(String title) {
		super(title);
		// 5. �����̳� ��ü�� �ּҸ� �о�ͼ� m_container ���� ������ ����
		m_container = getContentPane();
		
		// 6. ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * ���� ���� ����
		 * 
		 * 1. ������ ��ư ����
		 * 1) ��ư�� ũ�⸦ ����: setPreferredSize() �޼ҵ带 ���
		 *     - ��: setSize() �޼ҵ�
		 *     - ����: ��ư����������.setPreferredSize(����ũ��, ����ũ��);
		 *       �Ǵ�
		 *       Dimension Ŭ������ ��� -> ����: Dimension ���������� = new Dimension(����ũ��, ����ũ��);
		 *       �Ǵ� ��ư����������.setPreferredSize(new Dimension(����ũ��, ����ũ��);
		 *       
		 * 2) Ŭ�� �̺�Ʈ �غ�: ��ư����������.addActionListener(ActionListener_�������̽��� ������_Ŭ�����ǰ�ü);
		 * 
		 * 3) ��ư���� Ŭ�� �̺�Ʈ�� �߻��� �� ����� ���ڿ��� �����ϱ�: ��ư����������.setActionCommand("���ڿ�");
		 *     - ������ ��: ��ư���� ���� �ٸ� ���ڿ� ���� ����ؾ� ��.
		 *         -> ���� ���ڿ� �迭�� �����ؼ� ����ϱ�
		 *             -> public static final String[] BTN_ACTION_COMMAND = {"��1", "��2", "��3", "��4"};
		 *             
		 * 4) ���ٿ� ��ư�� �����ϱ�: ������ JToolBar Ŭ������ add() �޼ҵ带 ȣ��
		 *     -> m_tb.add(��ư����������);
		 */
		
		// 7. ������ ũ�� ����(ȭ�� �ִ�ȭ)
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// 8. ������ ũ�⸦ �ٲ��� ���ϵ��� ����
		setResizable(false);
		
		// 9. ȭ�鿡 �����츦 ����ϱ�
		setVisible(true);
	}
}

/*
 * 3. ������ ȭ�鿡 �׷��ִ� JPanel Ŭ������ ��� �޴� MyCanvas Ŭ������ ����
 */
class MyCanvas extends JPanel {
	// 4. paintComponent() �޼ҵ带 ������
	@Override 
	public void paintComponent(Graphics g) {
		// 5. ��! super.paintComponent() �޼ҵ带 ȣ���ϼ���
		super.paintComponent(g);
	}
}
public class TestPaint {

	public static void main(String[] args) {
		
	}

}
