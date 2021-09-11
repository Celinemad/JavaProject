package myjava3;
/*
 * 1. 제목: JLabel, JTextFiel, JTextArea, JScrollPane 클래스를 사용
 * 	1) 개요: JLabel에는 프로그램 전체 제목을 출력(***텍스트 입력과 출력 예제***)
 *  2) 레이아웃 관리자: FlowLayout
 *  3) 이벤트 처리: JTextField 입력 창에서 사용자가 텍스트를 입력하고 엔터키를 누른 경우
 *  	-> 사용자가 입력한 텍스트 전체를 가져와서 JTextArea 입력창의 끝에 추가
 *  	-> ActionListener 인터페이스를 구현 + actionPerformed() 추상 메소드를 재정의
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MyJFrame extends JFrame {
	// 버튼 객체를 생성
	private JButton m_button = new JButton("출력");
	
	// 2. 제목을 출력해주는 JLabel 객체를 생성
	private JLabel m_titleLabel = new JLabel("***텍스트 입력과 출력 예제***");
	// 3. 사용자가 한 줄의 텍스트 입력에 사용할 JTextField 객체를 생성
	private JTextField m_tf = new JTextField("텍스트를 입력하세요...", 30);
	// 4. 텍스트를 화면에 여러 줄 출력해주는 JTextArea 객체를 생성
	private JTextArea m_ta = new JTextArea("", 30, 20);
	// 5. 스크롤바를 출력해주는 JScrollPane 객체를 생성
	private JScrollPane m_sp = new JScrollPane(m_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	// 6. Container 참조 변수를 선언
	private Container m_container = null;
	// 7. FlowLayout 객체를 생성
	private FlowLayout m_f = new FlowLayout();
	// 8. 생성자 정의
	public MyJFrame(String title) {

		super(title);
		m_container = getContentPane();
		m_container.setLayout(m_f);
		
		// 사용자가 텍스트 필드 입력 창에서 엔터키를 눌렀을 때 수행할 명령어를 작성
		m_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 텍스트를 입력하고 엔터키를 누른 경우에
				String inputText = m_tf.getText();
				if(inputText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "텍스트를 꼭 입력하세요!");
					return;
				} else {
					m_ta.append(inputText + "\n");
				}
				
			}
		});
		
		// 버튼
		m_button.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputText = m_ta.getText();
				JOptionPane.showMessageDialog(null, "콘솔 창에 출력됩니다.");
				if(inputText.isEmpty()) {
					System.out.println("작성된 텍스트가 없습니다.");
				} else {
					System.out.println(inputText);	
				}
			}
		});
		
		// 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_container.add(m_titleLabel);
		m_container.add(m_tf);
		m_container.add(m_sp);
		// 버튼
		m_container.add(m_button);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
}
public class TestJTextArea {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame("test jtextfield jtextarea");
		
		
	}

}
