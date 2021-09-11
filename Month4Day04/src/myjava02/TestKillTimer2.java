package myjava02;
/*
 * 1. 제목: 사용자가 버튼을 클릭하면 MyTimerThread 클래스의 finish() 메소드를 호출해서
 * 		   깃발 변수인 m_flag의 값을 true로 변경(수정)해서 강제로 스레드를 종료
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MyTimerThread 클래스를 정의: 화면에 숫자를 출력
class MyTimerThread extends Thread {
	// JLabel 객체의 주소를 보관할 참조 변수 선언
	private JLabel m_label = null;
	// 화면에 출력할 숫자를 정수로 보관할 변수 선언(0으로 설정 안해도 0이지만 가독성 높이기 위해)
	private int m_num = 0;
	// 깃발 변수를 선언 + 초기화(false로 설정 안해도 false이지만 가독성 높이기 위해)
	private boolean m_flag = false;
	// 생성자를 정의
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	// finish() 메소드 정의
	public void finish() {
		m_flag = true;
	}
	// run() 메소드 재정의
	@Override
	public void run() {
		while (true) {
			m_label.setText(m_num + "");
			m_num++;
			// 깃발 변수의 값을 검사해서 true 이면 run() 메소드를 강제로 종료하기
			if(m_flag == true) {
				return;
			}
			// 1초 동안 스레드를 중지시키기
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 윈도우를 화면에 출력해주는 클래스의 정의
class MyWindow extends JFrame {
	// 숫자를 출력해주는 JLabel 객체를 생성
	private JLabel m_label = new JLabel();
	// 버튼을 출력해주는 JButton 객체를 생성
	private JButton m_btn = new JButton("kill timer");
	// 컨테이너 객체의 주소를 보관할 참조 변수 선언
	private Container m_c = null;
	// FlowLayout 객체를 생성
	private FlowLayout m_fl = new FlowLayout();
	// MyTimerThread 클래스를 사용하기 위한 참조 변수를 선언
	private MyTimerThread m_th = null;
	// 생성자를 정의
	public MyWindow(String title) {
		super(title);
		// 컨테이너 객체의 주소를 가져오기
		m_c = getContentPane();
		// 레이아웃 관리자 클래스를 바꾸기
		m_c.setLayout(m_fl);
		// 라벨을 화면에 출력
		m_c.add(m_label);
		// 버튼을 화면에 출력
		m_c.add(m_btn);
		// 타이머 스레드 객체를 생성
		m_th = new MyTimerThread(m_label);
		// 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 사용자가 버튼을 클릭했을 때 수행한 명령어들을 작성
		m_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// finish() 메소드를 호출
				m_th.finish();
				// 버튼을 비활성화하기
				m_btn.setEnabled(false);
			}
			
		});
		// 윈도우 크기 설정하기
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 윈도우 고정
		setResizable(false);
		// 윈도우 출력
		setVisible(true);
		// 타이머 스레드 객체를 실행 상태로 전환
		m_th.start();
	}
}

public class TestKillTimer2 {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test kill timer2");
	}

}
