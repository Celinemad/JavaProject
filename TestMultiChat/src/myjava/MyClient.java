package myjava;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 1. 제목: 클라이언트 컴퓨터에서 실행될 프로그램을 작성(구현)
 * 
 * 2. 윈도우를 생성하기
 *     - 사용자가 JTextField를 사용한 입력 창에서 입력한 메시지를 서버로 전송하기
 *         -> 서버로 전송시켜주는 일을 하기 위해서 JButton 클래스를 사용
 */
// 화면에 윈도우를 출력해주는 클래스를 정의
class MyWindow extends JFrame implements ActionListener {
	
	/*
	 * 화면 구성
	 * 1. 첫 번째 줄 상단에는 프로그램 제목을 출력하는 JLabel 객체를 생성: BorderLayout 배치관리자 클래스의 NORTH
	 * 2. 아래 줄에는 JTextField 객체와 JButton 객체를 생성: BorderLayout 배치 관리자 클래스의 SOUTH
	 */
	private JLabel m_title = new JLabel("***멀티챗 클라이언트 프로그램***");
	// +) id 입력 받기
	private JTextField m_idMsg = new JTextField("아이디를 입력하고 버튼을 클릭하세요...");
	private JTextField m_inputMsg = new JTextField("메시지를 입력하고 버튼을 클릭하세요...");
	private JButton m_sendBtn = new JButton("메시지 전송");
	
	/*
	 * 서버에 메시지를 보낼 때 Socket 객체를 선언
	 */
	private Socket m_socket = null;
	/*
	 * 서버에서 클라이언트로 보낸 메시지를 임시로 보관할 객체들을 선언
	 */
	private InputStream m_is = null;
	private DataInputStream m_dis = null;
	/*
	 * 주의할 점: 서버에서 사용할 클래스와 서로 짝이 되도록 클래스를 선택
	 */
	/*
	 * 서버로 메시지를 보낼 때 사용할 객체들을 선언
	 */
	private OutputStream m_os = null;
	private DataOutputStream m_dos = null;
	
	/*
	 * 컨테이너 객체의 주소를 보관할 참조 변수를 선언
	 */
	private Container m_c = null;
	
	/*
	 * 판넬 객체를 선언: 용도는 메시지 입력 창과 메시지 전송 버튼을 한 줄로 출력
	 */
	private JPanel m_p = new JPanel();
	
	// actionPerformed() 메소드를 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 사용자가 메시지를 입력하고 버튼을 누른 경우에 수행할 명령어를 작성하기
		// 1. 사용자가 입력한 메시지를 가져오기
		String id = m_idMsg.getText();
		String msg = m_inputMsg.getText();
		// 2. 사용자가 메시지를 입력하지 않으면 입력 요청 메시지 창을 출력하기
		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 꼭 입력하세요!");
			m_idMsg.setFocusable(true);
			m_idMsg.requestFocus();
			return;
		}
		if(msg.isEmpty()) {
			JOptionPane.showMessageDialog(null, "메시지를 꼭 입력하세요!");
			m_inputMsg.setFocusable(true);
			m_inputMsg.requestFocus();
			return;
		}
		// 3. 사용자가 입력한 메시지를 콘솔에 출력하기
		System.out.println("사용자의 아이디는 " + id);
		System.out.println("사용자가 입력한 메시지는 " + msg);
		// 4. 서버에 메시지를 보내기
		try {
			if(m_dos != null) {
				m_dos.writeUTF(id);
				m_dos.writeUTF(msg);
				m_dos.flush();
				System.out.println("서버로 메시지를 전송함[클라이언트]");
			}
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	// 생성자를 정의
	public MyWindow(String title) {
		super(title);
		// 컨테이너 객체의 주소를 가져와서 m_c 멤버 변수에 저장
		m_c = getContentPane();
		
		/*
		 * 1. 프로그램 제목을 화면에 출력하기: BorderLayout.NORTH
		 *     -> m_c.add(m_title, BorderLayout.NORTH);
		 * 2. 메시지 입력 창을 화면에 출력하기: 판넬에 저장
		 *     -> m_p.add(m_inputMsg);
		 *     
		 * 3. 버튼도 판넬에 저장: m_p.add(m_sendBtn);
		 * 
		 * 4. 판넬을 아래 방향에 저장: m_c.add(m_p, BorderLayout.SOUTH);
		 */
		m_c.add(m_title, BorderLayout.NORTH);
		m_p.add(m_idMsg);
		m_p.add(m_inputMsg);
		m_p.add(m_sendBtn);
		m_c.add(m_p, BorderLayout.CENTER);
		
		// 윈도우 종료 이벤트 처리 명령어: 소켓 종료 명령어를 추가하기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				/*
				 * 소켓 종료하기: Socket 클래스가 갖고 있는 close() 함수를 호출
				 */
				try {
					if(m_socket != null) m_socket.close();
				} catch(Exception e2) {
					System.out.println("소켓 종료 시에 오류가 발생. 원인은 " + e2.getMessage());
				}
				System.exit(0);
			}
		});
		
		// 사용자가 버튼을 눌렀을 때 이벤트 처리
		m_sendBtn.addActionListener(this);
		
		// 윈도우 크기 설정하기
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 윈도우 크기를 바꾸지 못하도록 설정하기
		setResizable(false);
		// 윈도우를 화면에 출력하기
		setVisible(true);
		
		m_idMsg.setFocusable(true);
		m_idMsg.requestFocus();
		m_idMsg.selectAll();
		m_inputMsg.setFocusable(true);
		m_inputMsg.requestFocus();
		m_inputMsg.selectAll();
		
		// 나중에 입력하기
		// socket 쓸 때는 try~catch를 써야 함
		try {
			// 서버에 접속을 시도하기
			m_socket = new Socket("localhost", 50825);
			// 만약 서버와 연결이 되면 실행할 명령어를 작성하기
			System.out.println("서버 컴퓨터와 서로 연결되었습니다...");
			// 서버 컴퓨터로 메시지를 보낼 때 사용할 객체를 생성
			m_is = m_socket.getInputStream();
			m_dis = new DataInputStream(m_is);
			// 서버 컴퓨터로 메시지를 보낼 때 사용할 객체를 생성
			m_os = m_socket.getOutputStream();
			m_dos = new DataOutputStream(m_os);
			System.out.println("모든 객체를 생성");
			// 서버 컴퓨터로 안녕하세요? 메시지를 전송하기
			m_dos.writeUTF("안녕하세요?");
			// flush() 함수를 호출해서 메시지를 지금 보내기
			m_dos.flush();
			System.out.println("서버로 메시지를 전송함");
			// 서버에서 보낸 답신 메시지를 받기
			String inputMsgFromServer = m_dis.readUTF();
			System.out.println("서버로부터 받은 메시지는 " + inputMsgFromServer);
		} catch(UnknownHostException e1) {
			System.out.println("호스트명 오류가 발생");
			e1.printStackTrace();
		} catch(IOException e2) {
			System.out.println("입력과 출력에서 오류가 발생");
			e2.printStackTrace();
		} catch(Exception e3) {
			System.out.println("그밖의 오류가 발생");
			e3.printStackTrace();
		}
	}
}
public class MyClient {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("client window");
	}

}
