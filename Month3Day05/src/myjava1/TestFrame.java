package myjava1;
/*
 * 1. ����: Frame Ŭ������ ����ؼ� ������ â�� �����, Button Ŭ������ ����ؼ� ��ư�� ����
 * 		   ��ư�� Frame �����̳��� �⺻ ���̾ƿ� �Ŵ����� BorderLayout�� ��� ��ġ�� �ֱ�(���)
 * 
 * 2. BorderLayout ���̾ƿ� �Ŵ��� Ŭ������ 5���� ����
 * 	1) ���: BorderLayout.CENTER ��������� ����
 * 	2) ����: BorderLayout.WEST ��������� ����
 * 	3) ������: BorderLayout.EAST ��������� ����
 * 	4) �Ʒ���: BorderLayout.SOUTH ��������� ����
 * 	5) ����: BorderLayout.NORTH ��������� ����
 */
import java.awt.*;
import java.awt.event.WindowEvent;

/*
 * ��ư���� �߻��� �׼� �̺�Ʈ�� ó�����ִ� Ŭ������ ����
 */
class MyButtonListener implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("����ڰ� ��ư�� Ŭ����");
	}
}

class MyButtonListenerNorth implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("����ڰ� north ��ư�� Ŭ����");
	}
}

class MyButtonListenerSouth implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("����ڰ� south ��ư�� Ŭ����");
	}
}


class MyButtonListenerWest implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("����ڰ� west ��ư�� Ŭ����");
	}
}

class MyButtonListenerEast implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("����ڰ� east ��ư�� Ŭ����");
	}
}


/*
 * ������ â���� �߻��� ������ �̺�Ʈ�� ó�����ִ� �Ѥ������� ����
 * 1. �̺�Ʈ �ҽ�: Frame
 * 2. �̺�Ʈ ����: Window
 * 3. ����� ������ �������̽�: WindowListener
 * 4. �������� �߻� �޼ҵ�(7��)
 */
class MyFrameListener implements java.awt.event.WindowListener{
	// Alt + Shift + s
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("����ڰ� x��ư ����");
		System.exit(0);  // 0�� ��������, 1�� ����������
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class TestFrame {
	public static void main(String[] args) {
		// MyFrameListener Ŭ������ ����ؼ� ���ο� ��ü�� �����
		MyFrameListener frameListener = new MyFrameListener();
		
		// MyButtonListener Ŭ������ ����ؼ� ���ο� ��ü�� �����
		MyButtonListener buttonListener = new MyButtonListener();
		
		// ���ο� ��ɾ���� �ۼ�
		MyButtonListenerNorth buttonListenerNorth = new MyButtonListenerNorth();
		MyButtonListenerSouth buttonListenerSouth = new MyButtonListenerSouth();
		MyButtonListenerWest buttonListenerWest = new MyButtonListenerWest();
		MyButtonListenerEast buttonListenerEast = new MyButtonListenerEast();
		
		// 1. ������ ��ü�� ����
		Frame frame = new Frame("window");
		// 2. ��ư ��ü�� ����
		Button button = new Button("center");
		
		/*
		 * ������ 4�� ������ 4���� ��ư�� ���� �ֱ�
		 */
		// 1. ���� ������ ������ ��ư ��ü ����
		Button northButton = new Button("north");
		// 2. �Ʒ��� ������ ������ ��ư ��ü ����
		Button southButton = new Button("south");
		// 3. ���� ������ ������ ��ư ��ü ����
		Button westButton = new Button("west");
		// 4. ������ ������ ������ ��ư ��ü ����
		Button eastButton = new Button("east");
		
		
		// ��ư ��ü�� actionPerformed() �޼ҵ带 ����
		button.addActionListener(buttonListener);
		
		// ���ο� ��ɾ���� �ۼ�
		northButton.addActionListener(buttonListenerNorth);
		southButton.addActionListener(buttonListenerSouth);
		westButton.addActionListener(buttonListenerWest);
		eastButton.addActionListener(buttonListenerEast);
		
		// ������ â�� windowClosing() �޼ҵ带 ����(������ 6�� �޼ҵ嵵 �ڵ� ����)
		frame.addWindowListener(frameListener);
		
		// 3. ��ư ��ü�� ������ �ȿ� ��� ��ġ�� �ֱ�
		frame.add(button);
		
		// ���ο� ��ɾ���� �ۼ��ϱ�(setSize()�޼ҵ庸�� ���� �ۼ�)
		frame.add(northButton, BorderLayout.NORTH);
		frame.add(southButton, BorderLayout.SOUTH);
		frame.add(westButton, BorderLayout.WEST);
		frame.add(eastButton, BorderLayout.EAST);
		
		// 4. ������ â�� ����ũ��� ����ũ�⸦ �����ϱ�
		frame.setSize(300, 300);
		
		// 5. ������ â�� ȭ�鿡 ��Ÿ���� �ϱ�
		frame.setVisible(true);
		
	}

}
