package myjava3;
/*
 * 1. 제목: 사용자로부터 학생의 이름, 학과, 주소를 입력 받는 프로그램
 * 	1) 화면 설계(Design)
 * 		가. 레이아웃 관리자 클래스: FlowLayout
 * 		나. 학생의 이름은 JLabel과 JTextField 클래스를 사용해서 표현
 * 			- JLabel: "이름 입력:" 텍스트를 출력
 * 			- JTextField: 기본 학생 이름인 "홍길동" 텍스트를 출력
 * 		다. 학생의 학과 역시 JLabel, JTextField 클래스를 사용해서 표현
 * 			- JLabel: "학과 입력:" 텍스트를 출력
 * 			- JTextField: 기본 학과인 "프랑스어학부" 텍스트를 출력
 * 		라. 학생의 집 주소
 * 			- JLabel: "주소 입력:" 텍스트를 출력
 * 			- JTextField: 기본 주소인 "" 텍스트를 출력
 * 		마. 입력 완료 버튼을 출력
 * 			- JButton 변수명 = new JButton("입력완료");
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MyJFrame 클래스를 정의
class MyJFrame extends JFrame implements ActionListener {
	
	// 학생 이름을 표현할 때 사용할 객체들을 생성
	private JLabel m_nameLabel = new JLabel("이름 입력:");
	private JTextField m_nameTF = new JTextField("홍길동", 5);
	
	// 학과를 표현할 때 사용할 객체들을 생성
	private JLabel m_majorLabel = new JLabel("학과 입력:");
	private JTextField m_majorTF = new JTextField("프랑스어학부", 10);
	
	// 주소를 표현할 때 사용할 객체들을 생성
	private JLabel m_addrLabel = new JLabel("주소 입력:");
	private JTextField m_addrTF = new JTextField("", 30);
	
	// 입력 완료 버튼 객체를 생성
	private JButton m_okButton = new JButton("입력완료");
	
	// 레이아웃 관리자 객체를 생성
	private FlowLayout m_fl = new FlowLayout();
	
	// 컨텐트 팬 영역에 접근할 때 사용할 객체 선언
	private Container m_c = null;
	
	// 생성자를 정의
	public MyJFrame(String title) {
		super(title);
		m_c = getContentPane();
		m_c.setLayout(m_fl);
		
		/*
		 * m_okButton 버튼을 사용자가 클릭했을 때 처리할 명령어를 위한 함수 등록(이벤트 처리 등록)
		 */
		m_okButton.addActionListener(this);
		
		/*
		 * 모든 컴포넌트들을 차례대로 컨텐트 팬 영역에 넣기
		 * 1) 순서: 학생의 이름 라벨, 텍스트필드 -> 학과 라벨과 텍스트필드 -> 주소 라벨과 텍스트필드
		 * 		-> 입력완료 버튼
		 */
		m_c.add(m_nameLabel);
		m_c.add(m_nameTF);
		
		m_c.add(m_majorLabel);
		m_c.add(m_majorTF);
		
		m_c.add(m_addrLabel);
		m_c.add(m_addrTF);
		
		m_c.add(m_okButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 사용자가 입력완료 버튼을 클릭했을 때 수행할 명령어들을 작성
		// 1. 사용자가 클릭한 버튼을 구분하기
		JButton clickedButton = (JButton)e.getSource();
		if(clickedButton == m_okButton) {
			System.out.println("사용자가 입력완료 버튼을 클릭함");
			// 2. 사용자가 입력한 이름을 가져오기
			String tempName = m_nameTF.getText();
			// 3. 사용자가 하나도 입력하지 않으면 입력 요청 메시지 창을 띄우기
			if(tempName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "꼭! 이름을 입력하세요!");
				// 마우스 커서의 위치를 사용자가 이름을 입력할 수 있는 입력창으로 자동 이동
				m_nameTF.setFocusable(true);
				m_nameTF.requestFocus();
				return;
			} else {
				// 사용자가 이름을 입력했으면 콘솔 창에 출력
				System.out.println("사용자가 입력한 이름은 "+ tempName);
			}
			// 4. 사용자가 입력한 학과를 가져오기
			String tempMajor = m_majorTF.getText();
			if(tempMajor.isEmpty()) {
				JOptionPane.showMessageDialog(null, "꼭! 학과를 입력하세요!");
				m_majorTF.setFocusable(true);
				m_majorTF.requestFocus();
				return;
			} else {
				System.out.println("사용자가 입력한 학과는 "+ tempMajor);
			}
			// 5. 사용자가 입력한 주소를 가져오기
			String tempAddr = m_addrTF.getText();
			if(tempAddr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "꼭! 주소를 입력하세요!");
				m_addrTF.setFocusable(true);
				m_addrTF.requestFocus();
				return;
			} else {
				System.out.println("사용자가 입력한 주소는 " + tempAddr);
			}
		}
	}
}
public class TestStudent {

	public static void main(String[] args) {
		MyJFrame myJFrame = new MyJFrame("학생 정보 입력");
		
		
	}

}
