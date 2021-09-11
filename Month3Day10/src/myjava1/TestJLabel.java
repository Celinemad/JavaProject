package myjava1;
/*
 * 1. 제목: JLabel 클래스를 사용해서 텍스트만 출력, 이미지만 출력, 텍스트와 이미지를 모두 출력
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 2. JFrame 클래스를 상속 받는 MyJFrame 클래스를 정의
class MyJFrame extends JFrame{
	// 3. ImageIcon 클래스를 사용해서 라벨에 출력할 이미지 객체를 생성
	private ImageIcon m_img = new ImageIcon("cake.png");
	// 4. 첫 번째 라벨 객체를 생성: 텍스트만 출력
	private JLabel m_label01 = new JLabel("Hello");
	// 5. 두 번째 라벨 객체를 생성: 이미지만 출력
	private JLabel m_label02 = new JLabel(m_img);
	// 6. 세 번째 라벨 객체를 생성: 텍스트와 이미지 모두를 출력
	private JLabel m_label03 = new JLabel("Hello", m_img, JLabel.CENTER);
	// 7. 컨테이너 팬의 주소를 보관할 변수 선언
	private Container m_container;
	// 8. FlowLayout 레이아웃 관리자 객체를 생성
	private FlowLayout m_flowLayout = new FlowLayout();
	// 9. 다른 클래스로부터 윈도우 제목 문자열을 받는 생성자를 정의
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		
		// 현재 JFrame 클래스의 레이아웃 관리자 클래스를 BorderLayout에서 FlowLayout으로 변경
		m_container.setLayout(m_flowLayout);
		// 첫 번재에는 텍스트 라벨을 출력
		m_container.add(m_label01);
		// 두 번째 항목에는 이미지 라벨을 출력
		m_container.add(m_label02);
		// 세 번재 출력 항목에는 텍스트와 이미지 모두를 갖는 라벨을 출력
		m_container.add(m_label03);
		// 윈도우 종료 이벤트 처리를 위한 명령어
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize);
		setResizable(false);
		setVisible(true);
	}
	
}

public class TestJLabel {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jlabel");
		
		
	}

}
