package myjava1;
/*
 * 1. 제목: 기본 형식으로 이벤트 처리를 담당할 클래스를 정의해서 사용하고
 *         이름이 없는 특수형식으로 이벤트 처리를 담당할 클래스와 객체를 한번에 정의해서 사용하기
 *         
 * 	1) 기본형식: 5개의 버튼 객체들을 생성해서 사용하기
 * 	2) 특수형식: 1개의 버튼 객체를 생성해서 사용하기
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 2. JFrame 클래스를 상속 받는 MyJFrame 클래스를 정의 + ActionListener 인터페이스를 구현
class MyJFrame extends JFrame implements ActionListener {
	
	// 4. 5개의 JButton 클래스를 사용하는 객체들을 생성
	// 1) 버튼에 사용할 텍스트(라벨)를 보관할 String 배열 생성
	public static final String[] ARR_BUTTON_TEXT = {"1", "2", "3", "4", "5"};
	// 2) JButton 클래스를 사용해서 5개의 버튼 객체의 주소를 보관할 수 있는 배열을 생성
	private JButton[] m_arr_button = new JButton[ARR_BUTTON_TEXT.length];
	// 3) 컨테이너 변수를 선언
	private Container m_container = null;
	
	// 5. 생성자를 정의
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		
		// 6. 5개의 버튼 객체들을 생성하는 for 반복문
		for(int i=0; i<m_arr_button.length; i++) {
			m_arr_button[i] = new JButton(ARR_BUTTON_TEXT[i]);
			m_arr_button[i].setActionCommand(ARR_BUTTON_TEXT[i]);
			m_arr_button[i].addActionListener(this);
		}
		
		// 5개의 버튼 객체들을 컨테이너에 넣기
		// BorderLayout 레이아웃 관리자를 사용
		// 1. 윗쪽에는 숫자 1을 가진 버튼을 넣기
		m_container.add(m_arr_button[0], BorderLayout.NORTH);
		// 2. 아랫쪽에는 숫자 2를 가진 버튼을 넣기
		m_container.add(m_arr_button[1], BorderLayout.SOUTH);
		// 3. 가운데에는 숫자 3를 가진 버튼을 넣기
		m_container.add(m_arr_button[2], BorderLayout.CENTER);
		// 4. 왼쪽에는 숫자 4를 가진 버튼을 넣기
		m_container.add(m_arr_button[3], BorderLayout.WEST);
		// 5. 오른쪽에는 숫자 5를 가진 버튼을 넣기
		m_container.add(m_arr_button[4], BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
	
	// 3. actionPerformed() 메소드를 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		String command = clickedButton.getActionCommand();
		if(command.equals("1")) {
			JOptionPane.showMessageDialog(null, "숫자1 버튼을 클릭");
		} else if(command.equals("2")) {
			JOptionPane.showMessageDialog(null, "숫자2 버튼을 클릭");
		} else if(command.equals("3")) {
			JOptionPane.showMessageDialog(null, "숫자3 버튼을 클릭");
		} else if(command.equals("4")) {
			JOptionPane.showMessageDialog(null, "숫자4 버튼을 클릭");
		} else if(command.equals("5")) {
			JOptionPane.showMessageDialog(null, "숫자5 버튼을 클릭");
		}
	}
}
public class TestJButtonEventHandler {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jbutton");
		
	}

}
