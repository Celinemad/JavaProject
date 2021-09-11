package myjava2;
/*
 * 1. 제목: 앨범 형식으로 여러 이미지들을 화면에 출력
 * 	- 레이아웃 관리자는 GridLayout을 사용
 * 		- 형식) GridLayout 변수명 = new GridLayout(행, 열);
 * 			- 행: 세로 선의 갯수, 열: 가로 선의 갯수
 * 		- 예) GridLayout 변수명 = new GridLayout(3, 3);
 * 	- Container m_container;
 * 	  m_container = getContentPane();
 * 	  m_container.setLayout(변수명);
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// JFrame 클래스를 상속 받는 MyJFrame 클래스를 정의
class MyJFrame extends JFrame implements ActionListener {
	
	// 총 9개의 이미지 파일을 사용하기
	// 총 9개의 파일 이름들을 문자열로 보관(배열)
	public static final String[] IMG_FILE_NAMES = {"apple.png","bread.png","burger.png","chicken-leg.png","chocolate.png","donut.png","ice-cream.png","pizza.png","sandwich.png"};
	// 총 9개의 이미지 파일들을 사용할 ImageIcon 배열을 선언
	private ImageIcon[] m_imgs = new ImageIcon[IMG_FILE_NAMES.length];
	// 총 9개의 버튼 객체들을 보관할 JButton 배열을 선언
	private JButton[] m_buttons = new JButton[IMG_FILE_NAMES.length];
	// GridLayout 클래스를 사용해서 객체를 생성
	private GridLayout m_gl = new GridLayout(3,3);
	// Container 클래스를 사용해서 객체를 생성
	private Container m_container = null;
	
	// 생성자를 정의
	public MyJFrame(String title) {
		super(title);
		m_container = getContentPane();
		m_container.setLayout(m_gl);
		
		for(int i=0; i<m_imgs.length; i++) {
			m_imgs[i] = new ImageIcon(IMG_FILE_NAMES[i]);
			
		}
		
		for(int i=0; i< m_buttons.length; i++) {
			m_buttons[i] = new JButton(m_imgs[i]);
			m_buttons[i].setActionCommand(IMG_FILE_NAMES[i]);
			m_buttons[i].addActionListener(this);
		}
		
		// 9개의 버튼들을 화면에 출력하기
		for(int i=0; i< m_buttons.length; i++) {
			m_container.add(m_buttons[i]);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton clickedButton = (JButton)actionEvent.getSource();
		String actionCommand = clickedButton.getActionCommand();
		if(actionCommand.equals("apple.png")) {
			JOptionPane.showMessageDialog(m_buttons[0], "사용자가 사과 아이콘을 선택");
		} else if(actionCommand.equals("bread.png")) {
			JOptionPane.showMessageDialog(m_buttons[1], "사용자가 빵 아이콘을 선택");
		} else if(actionCommand.equals("burger.png")) {
			JOptionPane.showMessageDialog(m_buttons[2], "사용자가 버거 아이콘을 선택");
		} else if(actionCommand.equals("chicken-leg.png")) {
			JOptionPane.showMessageDialog(m_buttons[3], "사용자가 치킨 아이콘을 선택");
		} else if(actionCommand.equals("chocolate.png")) {
			JOptionPane.showMessageDialog(m_buttons[4], "사용자가 쵸콜릿 아이콘을 선택");
		} else if(actionCommand.equals("donut.png")) {
			JOptionPane.showMessageDialog(m_buttons[5], "사용자가 도넛 아이콘을 선택");
		} else if(actionCommand.equals("ice-cream.png")) {
			JOptionPane.showMessageDialog(m_buttons[6], "사용자가 아이스크림 아이콘을 선택");
		} else if(actionCommand.equals("pizza.png")) {
			JOptionPane.showMessageDialog(m_buttons[7], "사용자가 피자 아이콘을 선택");
		} else if(actionCommand.equals("sandwich.png")) {
			JOptionPane.showMessageDialog(m_buttons[8], "사용자가 샌드위치 아이콘을 선택");
		}
	}
}
public class TestAlbum {

	public static void main(String[] args) {
		MyJFrame myJFrame = new MyJFrame("TestAlbum");
		
		
	}

}
