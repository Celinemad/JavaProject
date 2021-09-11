package myjava2;
/*
 * 1. 제목: 윈도우즈에서 제공해주는 그림판(paint)를 비슷하게 구현한 프로그램
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 2. 윈도우를 출력해주는 클래스를 정의
 */
class MyWindow extends JFrame implements ActionListener {
	
	// 1) 사용자가 선택한 버튼에 따라서 서로 다른 정수 값을 갖는 멤버 변수를 선언
	// 가. 사용자가 선 그려주기 버튼을 눌렀을 때 사용할 값인 0을 고정값으로 정의한 상수를 설정
	public static final int DRAW_LINE = 0;
	// 나. 사용자가 사각형 그려주기 버튼을 눌렀을 때 사용할 값인 1을 고정값으로 정의한 상수를 설정
	public static final int DRAW_RECT = 1;
	// 다. 사용자가 삼각형 그려주기 버튼을 눌렀을 때 사용할 값인 2를 고정값으로 정의한 상수를 설정
	public static final int DRAW_TRI = 2;
	// 라. 원 그려주기 버튼 구분 값 상수
	public static final int DRAW_CIRCLE = 3;
	// 마. 사용자가 클릭한 버튼의 구분 값을 저장할 변수 선언
	private int m_selectedShape = DRAW_LINE;
	
	// 2) 툴바 객체를 생성하기
	private JToolBar m_tb = new JToolBar("shape toolbar");
	
	// 3) 선 그려주기 버튼 객체를 생성
	private JButton m_drawLineBtn = new JButton("선");
	
	// 4) 사각형 그려주기 버튼 객체를 생성
	private JButton m_drawRectBtn = new JButton("사각형");
	
	// 5) 삼각형 그려주기 버튼 객체를 생성
	private JButton m_drawTriBtn = new JButton("삼각형");
	
	// 6) 원 그려주기 버튼 객체를 생성
	private JButton m_drawCirBtn = new JButton("원");
	
	// 7) 컨테이너 객체의 주소를 보관할 참조 변수를 선언
	private Container m_container = null;
	
	// 8) 버튼 구분을 위한 문자열 배열
	public static final String[] BTN_ACTION_COMMAND = {"LINE", "RECT", "TRI", "CIR"};
	
	/*
	 * 3. actionPerformed() 메소드를 재정의
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	/*
	 * 4. 윈도우의 제목을 출력하는 생성자 정의
	 */
	public MyWindow(String title) {
		super(title);
		// 5. 컨테이너 객체의 주소를 읽어와서 m_container 참조 변수에 대입
		m_container = getContentPane();
		
		// 6. 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * 툴바 관련 설정
		 * 
		 * 1. 각각의 버튼 설정
		 * 1) 버튼의 크기를 지정: setPreferredSize() 메소드를 사용
		 *     - 비교: setSize() 메소드
		 *     - 형식: 버튼참조변수명.setPreferredSize(가로크기, 세로크기);
		 *       또는
		 *       Dimension 클래스를 사용 -> 형식: Dimension 참조변수명 = new Dimension(가로크기, 세로크기);
		 *       또는 버튼참조변수명.setPreferredSize(new Dimension(가로크기, 세로크기);
		 *       
		 * 2) 클릭 이벤트 준비: 버튼참조변수명.addActionListener(ActionListener_인터페이스를 구현한_클래스의객체);
		 * 
		 * 3) 버튼에서 클릭 이벤트가 발생할 때 사용할 문자열을 지정하기: 버튼참조변수명.setActionCommand("문자열");
		 *     - 주의할 점: 버튼마다 서로 다른 문자열 값을 사용해야 함.
		 *         -> 위에 문자열 배열을 정의해서 사용하기
		 *             -> public static final String[] BTN_ACTION_COMMAND = {"값1", "값2", "값3", "값4"};
		 *             
		 * 4) 툴바에 버튼을 부착하기: 형식은 JToolBar 클래스의 add() 메소드를 호출
		 *     -> m_tb.add(버튼참조변수명);
		 */
		
		// 7. 윈도우 크기 설정(화면 최대화)
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// 8. 윈도우 크기를 바꾸지 못하도록 고정
		setResizable(false);
		
		// 9. 화면에 윈도우를 출력하기
		setVisible(true);
	}
}

/*
 * 3. 도형을 화면에 그려주는 JPanel 클래스를 상속 받는 MyCanvas 클래스를 정의
 */
class MyCanvas extends JPanel {
	// 4. paintComponent() 메소드를 재정의
	@Override 
	public void paintComponent(Graphics g) {
		// 5. 꼭! super.paintComponent() 메소드를 호출하세요
		super.paintComponent(g);
	}
}
public class TestPaint {

	public static void main(String[] args) {
		
	}

}
