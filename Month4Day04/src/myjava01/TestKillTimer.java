package myjava01;
/*
 * 1. 제목: 현재 실행 중인 타이머를 사용자가 강제로 종료시키는 프로그램을 작성
 * 
 * 1) 화면 구성(설계)
 *     가. 화면에 숫자 0 -> 1 -> 2 -> ...(무한대)를 출력하는 객체를 생성: JLabel m_label = new JLabel();
 *     나. 사용자가 마우스로 누를 수 있는 버튼 객체를 생성: JButton m_button = new JButton("kill timer");
 *     다. Layout Manager 클래스는 FlowLayout: 객체를 생성하기 FlowLayout m_fl = new FlowLayout();
 *     라. 컨테이너 객체의 주소를 보관할 참조 변수를 선언: Container m_c = null;
 *         - 생성자를 정의한 후에 내부에서 m_c = getContentPane();
 *         - 현재 레이아웃 매니저 클래스인 BorderLayout을 FlowLayout으로 바꾸기: m_c.setLayout(m_fl);
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// +) restart 버튼을 위한 MyTimerThread2 
class MyTimerThread2 extends Thread {
	private JLabel m_label;
	private int m_num;
	public MyTimerThread2 (JLabel label, int num) {
		m_label = label;
		m_num = num;
	}
	// +) run() 메소드를 재정의하기
	@Override 
	public void run() {
		while(true) {
			m_label.setText(m_num + "");
			m_num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

// JLabel에 숫자를 출력해주는 MyTimerThread 클래스를 정의
class MyTimerThread extends Thread {
	// JLabel 객체의 주소를 보관할 참조 변수를 선언
        // 하나의 클래스에서 하면 메모리가 올라감(class를 많이 정의하는게 좋음)
	private JLabel m_label;
	
	// +) flag 변수
	private boolean m_flag = false;
	
	private int m_num;
	private MyTimerThread2 m_th2 = null;
	// 생성자를 정의해서 다른 클래스로부터 JLabel 객체의 주소를 가져오기
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	// +) finish() 메소드 정의
	public void finish() {
		m_flag = true;
	}
	// run() 메소드를 재정의하기
	@Override
	public void run() {
		// 화면에 출력할 숫자를 임시로 보관할 변수를 선언 + 초기화
		m_num = 0;
		// while 반복문을 사용해서 무한 반복문을 작성
		while(true) {
			// JLabel의 setText() 메소드를 호출해서 숫자 0을 화면에 출력하기
			m_label.setText(m_num + "");
			// 다음에 출력할 숫자를 만들기
			m_num++;
			// sleep() 메소드를 호출해서 1초 동안 스레드를 중지하기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("스레드가 강제로 종료됨");
				e.printStackTrace();
//				return;
				// +)
				finish();
				m_th2 = new MyTimerThread2(m_label, m_num);
				m_th2.start();
			}
		}
	}
}

// 화면에 윈도우를 출력해주는 클래스를 정의
class MyWindow extends JFrame {
	// 숫자가 출력될 JLabel 객체를 생성
	private JLabel m_label = new JLabel();
	// 버튼 객체를 생성
	private JButton m_button = new JButton("kill timer");
	// +) restart 버튼 객체를 생성
	private JButton m_button2 = new JButton("restart");
	// FlowLayout 객체를 생성
	private FlowLayout m_fl = new FlowLayout();
	// 컨테이너 객체의 주소를 보관할 참조 변수를 선언
	private Container m_c = null;
	// MyTimerThread 클래스를 사용하기 위한 참조 변수를 선언
	private MyTimerThread m_th = null;
	// 생성자를 정의
	public MyWindow(String title) {
		// 윈도우 제목 출력
		super(title);
		// 컨테이너 객체의 주소를 가져오기
		m_c = getContentPane();
		// 레이아웃 관리자 클래스를 바꾸기
		m_c.setLayout(m_fl);
		// 화면에 JLabel 객체를 출력
		m_c.add(m_label);
		// JLabel 옆에 버튼 객체를 출력
		m_c.add(m_button);
		// +) "kill timer" 버튼 옆에 "restart" 버튼 객체를 출력
		m_c.add(m_button2);
		//윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 사용자가 버튼을 클릭했을 때 수행할 명령어들을 작성
		m_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// interrupt() 메소드를 호출
				m_th.interrupt();
				// 버튼을 사용자가 누르지 못하도록 비활성화 상태로 전환: setEnabled(false) 메소드를 호출
				m_button.setEnabled(false);
			}
			
		});
		// 타이머 객체를 생성
		m_th = new MyTimerThread(m_label);
		// 윈도우 크기를 설정
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 윈도우 크기를 고정
		setResizable(false);
		// 윈도우를 화면에 출력
		setVisible(true);
		// 타이머 객체를 실행 가능한 상태로 전환시키기: start() 메소드를 호출
		m_th.start();
	}
	
}

public class TestKillTimer {

	public static void main(String[] args) {
		
		MyWindow window = new MyWindow("test fill timer");
		
	}

}
