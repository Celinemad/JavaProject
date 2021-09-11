package myjava1;
/*
 * 1. 제목: Swing GUI 라이브러리를 사용해서 화면에 윈도우를 출력
 *	1) import java. awt.*;
 * 	   import java.awt.event.*;
 * 	   import javax.swing.*;
 * 	   import javax.swing.event.*;
 * 
 * 	2) JFrame 클래스를 상속받는 MyJFrame 이름을 갖는 자식 클래스를 정의
 * 	3) 버튼을 BorderLayout 레이아웃 관리자의 가운데 영역에 출력
 * 		- Container 변수명;
 * 		- 변수명 = getContentPane();
 * 		- JButton 클래스를 사용해서 버튼 객체를 생성
 * 			- JButton 변수명2 = new JButton("텍스트(라벨) 문자열");
 * 		- 화면에 버튼을 출력: 변수명.add(변수명2);
 * 
 * 	4) 윈도우 종료 이벤트 처리 방법
 * 		가. WindowListenner 인터페이스를 구현해서 7개의 추상 메소드들을 재정의
 * 		또는, JFrame 클래스가 갖고 있는 setDefaultCloseOperation() 메소드를 호출
 * 		- 사용 형식: MyJFrame 클래스의 생성자 메소드 내부에 아래 명령어를 추가
 * 			- setDefaultCloseOperation(값);
 * 				- 값: JFrame.EXIT_ON_CLOSE
 * 					- CLOSE: 윈도우를 닺기, EXIT: 프로그램을 종료(main() 메소드를 종료)
 * 
 * 	5) 사용자가 버튼을 클릭했을 때 수행할 수 있는 명령어를 작성하는 방법
 * 		- ActionListener 인터페이스를 구현
 * 			- actionPerformed() 메소드를 재정의
 * 		- setActionCommand() 메소드를 사용: 버튼에 추가로 액션 이벤트가 발생했을 때 사용할 수 있는 며ㅕㅇ령 문자열을 지정
 * 			- 형식: 버튼참조변수명.setActionCommand("유일한_명령_문자열");
 * 		- getActionCommand() 메소드를 사용해서 액션 이벤트가 발생한 버튼의 명령 문자열을 가져오기
 * 			- actionPerformed() 메소드 내부에서 작성
 * 				- 예) JButton 변수명 = (JButton) 액션이벤트_참조변수명.getSource();
 * 				- String 변수명2 = 변수명.getActionCommand();
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 화면에 윈도우 창을 출력해주는 MyJFrame 클래스를 정의
class MyJFrame extends JFrame implements ActionListener{
	
	// 화면에 출력할 버튼 객체를 생성
	private JButton m_button = new JButton("button");
	
	// 새로운 버튼 객체들을 총 4개 생성하기
	// 1) 4개의 버튼에 사용할 문자열들을 미리 선언
		// final 들어간 것은 대문자로 변수명 생성
	public static final String [] ARR_BUTTONS_LABEL = {"2","3","4","5"};
	// 2) 버튼 배열 객체를 생성
	private JButton [] m_arr_buttons = new JButton[ARR_BUTTONS_LABEL.length];
	
	
	// 버튼이 출력될 컨텐트 팬 영역의 시작 주소를 보관할 변수를 선언(여기선 선언만!)
	private Container m_container;
	
	// 버튼의 출력 방향을 배열에 선언하기
	public static final String[] ARR_BUTTONS_ORI = {
			BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.WEST, BorderLayout.EAST
	};
	
	// 생성자의 정의
	public MyJFrame(String title) {
		// 윈도우 제목을 생성
		super(title);
		// getContentPane() 메소드를 호출해서 컨텐트 팬 영역의 시작 주소를 가져와서 m_container 변수에 대입
		m_container = getContentPane();
		// 버튼에 명령 문자열을 지정
		m_button.setActionCommand("1");
		// 버튼과 actionPerformed() 메소드를 연결(등록)
		m_button.addActionListener(this);
		// 버튼에 풍선 도움만 기능을 추가하기: JButton 클래스가 갖고 있는 setToolTipText() 메소드를 사용
		// -> 형식: setToolTipText("화면에출력할내용을 작성");
		m_button.setToolTipText("풍선도움말");
		
		// 반복문을 사용해서 4개의 버튼 객체들을 생성(JButton 클래스의 생성자를 사용)
		for(int i=0; i<m_arr_buttons.length; i++) {
			m_arr_buttons[i] = new JButton(ARR_BUTTONS_LABEL[i]);
			// setActionCommand() 메소드를 호출
			m_arr_buttons[i].setActionCommand(ARR_BUTTONS_LABEL[i]);
			// addActionListener() 메소드를 호출
			m_arr_buttons[i].addActionListener(this);
			// setToolTipText() 메소드를 호출
			m_arr_buttons[i].setToolTipText(ARR_BUTTONS_LABEL[i]);
			// actionPerformed() 메소드 내부로 이동해서 이벤트 처리 명령어들을 추가하기
			
			// 명령어를 다 입력한 다음에는 프로그램 실행 -> 결과 확인
		}
		
		// 버튼을 컨텐트 팬 영역에 넣기: add() 메소드를 호출
		m_container.add(m_button);
//		m_container.add(m_arr_buttons[0], BorderLayout.NORTH);
//		m_container.add(m_arr_buttons[1], BorderLayout.SOUTH);
//		m_container.add(m_arr_buttons[2], BorderLayout.WEST);
//		m_container.add(m_arr_buttons[3], BorderLayout.EAST);
		for(int i=0; i<4; i++) {
			m_container.add(m_arr_buttons[i], ARR_BUTTONS_ORI[i]);
		}
		// 윈도우 종료 이벤트 처리를 위한 등록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우 가로 크기와 세로 크기를 지정하기: JFrame 클래스의 setSize() 메소드를 사용
		setSize(500, 500);
		// 윈도우를 화면에 출력하기
		setVisible(true);
	}
	
	// actionPerformed() 메소드를 재정의
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// 사용자가 버튼을 클릭했을 때 JOptionPane 클래스를 사용해서 메시지 창을 출력하기
		JButton clickedButton = (JButton)actionEvent.getSource();
		String actionCommand = clickedButton.getActionCommand();
		if(actionCommand.equals("1")) {
			JOptionPane.showMessageDialog(null, "사용자가 1번 버튼을 클릭");
			clickedButton.setBackground(Color.MAGENTA);
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("2")) {
			JOptionPane.showMessageDialog(null, "사용자가 2번 버튼을 클릭");
			clickedButton.setBackground(new Color(255, 102, 51));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("3")) {
			JOptionPane.showMessageDialog(null, "사용자가 3번 버튼을 클릭");
			clickedButton.setBackground(new Color(255, 102, 153));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("4")) {
			JOptionPane.showMessageDialog(null, "사용자가 4번 버튼을 클릭");
			clickedButton.setBackground(new Color(000, 102, 153));
			clickedButton.setOpaque(true);
		} else if(actionCommand.equals("5")) {
			JOptionPane.showMessageDialog(null, "사용자가 5번 버튼을 클릭");
			clickedButton.setBackground(new Color(102, 255, 153));
			clickedButton.setOpaque(true);
		}
	}
}
public class TestJFrame {

	public static void main(String[] args) {
		// MyJFrame 클래스를 사용해서 객체를 생성
		MyJFrame frame = new MyJFrame("test jframe");
		
		
	}

}
