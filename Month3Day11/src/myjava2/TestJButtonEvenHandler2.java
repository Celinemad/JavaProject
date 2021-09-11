package myjava2;
/*
 * 1. 제목: 특수한 형식을 사용해서 오직 하나의 버튼만을 이벤트 처리해주는 예제
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyJFrame extends JFrame {
	// 2. 버튼 객체를 생성
	private JButton m_button = new JButton("1");
	private Container m_container = null;
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		m_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오직 하나의 버튼에서 클릭 이벤트를 처리");
			}
		});
		m_container.add(m_button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
}
public class TestJButtonEvenHandler2 {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jbutton event");
	}

}
