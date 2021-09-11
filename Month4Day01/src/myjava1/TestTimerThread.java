package myjava1;
/*
 * 제목: 숫자가 먼저 JLabel에 출력되고 1초 동안 멈추었다가 다시 숫자를 JLabel에 출력
 * 	-> 숫자는 0에서 시작해서 1씩 증가
 * 
 * 만드실 클래스 목록
 * 1. Thread 클래스를 상속 받는 자식 클래스를 정의: MyTimerThread
 * 2. 화면에 윈도우를 출력해주는 MyWindow 클래스를 정의
 * 3. main() 메소드를 갖고 있는 TestTimerThread 클래스를 정의
 * 
 * 클래스를 정의하기 전에 import 명령어를 작성
 * 1. import java.awt.*;
 * 2. import java.awt.event.*;
 * 3. import javax.swing.*;
 * 4. import javax.swing.event.*;
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 클래스를 여러개 만드는 이유
 * -> 메모리 공간을 적게 사용하여 프로그램을 빨리하기 위해
 */

// MyTimerThread 클래스를 정의
/*
 * 하는 일:
 * JLabel 객체에 접근해서 숫자를 출력 + 1초 동안 쉬기(Thread.sleep())
 * 	-> sleep()이 static 메소드이기 때문에 객체를 생성하지 않음. 객체 없이 바로 클래스 이름으로 접근 가능
 * 
 * JLabel 객체에 접근하는 방법
 * 1) 생성자를 정의: public 클래스명(JLabel 매개변수명) { 멤버변수명 = 매개변수명; }
 * 2) 일반 메소드를 정의: public void set + 멤버변수명(JLabel 매개변수명) { 멤버변수명 = 매개변수명; }
 * 	-> 1번과 2번을 정의하기 전에 JLabel 클래스를 사용하는 참조 변수를 선언해야 합니다.
 * 		-> 형식) private JLabel 변수명 = null; // 객체 필요 없으므로 new 하지 않고 null
 */
class MyTimerThread extends Thread{
	
	// 3) JLabel 객체의 주소를 저장할 참조변수를 선언
	private JLabel m_label = null;
	
	// 4) 생성자를 정의해서 외부 클래스로부터 JLabel 객체의 주소를 매개변수로 가져옵니다.
	public MyTimerThread(JLabel label) {
		m_label = label;
	}
	
	// 5) set + 멤버변수명 이름을 갖는 새로운 함수를 정의해서 외부 클래스로부터 JLabel 객체의 주소를 매개변수로 가져오기
	public void setLabel(JLabel label) {
		m_label = label;
	}
	
	// 꼭! run() 메소드를 재정의해야 합니다.
	@Override
	public void run() {
		/*
		 * 1. JLabel 객체에 출력할 숫자를 보관할 변수를 선언 + 초기화(0)
		 */
		int num = 0;
		
		/*
		 * 2. while 반복문을 사용해서 종료되지 않는 무한 반복문을 작성
		 * 1) JLabel 클래스의 setText() 메소드를 사용해서 숫자를 라벨에 출력
		 * 	-> m_label.setText(num+"");
		 *  또는 
		 *  m_label.setText(Integer.toString(num));
		 * 2) 숫자를 하나만 증가시키기: num++;
		 * 3) 1초 동안 CPU를 잠자게 하기:
		 * 	try {
		 * 		Thread.sleep(1000);
		 * 	} catch(InterruptedException 예외처리변수명) {
		 * 		다른 스레드에 의해서 잠자고 있는 스레드가 잠에서 깨어난 경우의 처리를 작성
		 * 		return;
		 * 	}
		 */
		while(true) {
			m_label.setText(num+"");
			num++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

class MyTimerThread2 extends Thread{
	
	// 3) JLabel 객체의 주소를 저장할 참조변수를 선언
	private JLabel m_label = null;
	
	// 4) 생성자를 정의해서 외부 클래스로부터 JLabel 객체의 주소를 매개변수로 가져옵니다.
	public MyTimerThread2(JLabel label) {
		m_label = label;
	}
	
	// 5) set + 멤버변수명 이름을 갖는 새로운 함수를 정의해서 외부 클래스로부터 JLabel 객체의 주소를 매개변수로 가져오기
	public void setLabel(JLabel label) {
		m_label = label;
	}
	
	// 꼭! run() 메소드를 재정의해야 합니다.
	@Override
	public void run() {
		/*
		 * 1. JLabel 객체에 출력할 숫자를 보관할 변수를 선언 + 초기화(0)
		 */
		int num = 0;
		
		/*
		 * 2. while 반복문을 사용해서 종료되지 않는 무한 반복문을 작성
		 * 1) JLabel 클래스의 setText() 메소드를 사용해서 숫자를 라벨에 출력
		 * 	-> m_label.setText(num+"");
		 *  또는 
		 *  m_label.setText(Integer.toString(num));
		 * 2) 숫자를 하나만 증가시키기: num++;
		 * 3) 1초 동안 CPU를 잠자게 하기:
		 * 	try {
		 * 		Thread.sleep(1000);
		 * 	} catch(InterruptedException 예외처리변수명) {
		 * 		다른 스레드에 의해서 잠자고 있는 스레드가 잠에서 깨어난 경우의 처리를 작성
		 * 		return;
		 * 	}
		 */
		while(true) {
			m_label.setText(num+"");
			num++;
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

// MyWindow 클래스를 정의: JFrame 클래스를 상속
/*
 * 1. 화면 구성(설계)
 * 	-> BorderLayout의 가운데 위치에 JLabel 객체를 출력
 */
class MyWindow extends JFrame {
	// 추가) JPanel 객체 생성
	private JPanel m_panel = new JPanel(new GridLayout(1,2));
	// 추가) 새로운 JLabel 객체 생성
	private JLabel new_label = new JLabel("");
	// 1) JLabel 객체를 생성
	private JLabel m_label = new JLabel("");
	// 2) Container 객체의 주소를 보관할 참조 변수를 선언
	private Container m_container = null;
	// 3) 화면에 출력할 숫자의 폰트 크기를 바꿀 때 사용할 Font 객체를 생성
	private Font m_font = new Font("궁서체", Font.BOLD, 30);
	// 4) 생성자 정의: 다른 클래스로부터 윈도우 왼쪽 상단에 출력할 텍스트를 입력 받음: String title
	
		// 추가하기: MyTimerThread
	private MyTimerThread m_thread = null;
	
	// 추가)
	private MyTimerThread2 m_new_thead = null;
	
	public MyWindow(String title) {
		super(title);
		// 5) Container 객체 접근하기
		m_container = getContentPane();
		// 6) Font 객체를 라벨에 사용하기
		m_label.setFont(m_font);
			// 추가)
		new_label.setFont(m_font);
		// 7) 화면의 가운데 위치에 라벨을 출력
//		m_container.add(m_label);
		
			// 추가: 새로운 스레드 객체를 생성
		m_thread = new MyTimerThread(m_label);
			// 추가)
		m_new_thead = new MyTimerThread2(new_label);
		
		// 추가)
		m_panel.add(m_label);
		m_panel.add(new_label);
		
		// 추가) JPanel 객체를 윈도우의 가운데 위치에 넣기
		m_container.add(m_panel, BorderLayout.CENTER);
		
		// 8) 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 9) 윈도우 크기를 화면의 크기로 최대화
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 10) 윈도우 크기를 고정시키기
		setResizable(false);
		// 11) 윈도우 출력
		setVisible(true);
		
			// 추가하기: 스레드 객체를 실행시키기: start() 메소드를 호출
		m_thread.start();
			// 추가)
		m_new_thead.start();
	}
	
}

public class TestTimerThread {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test timer thread");
	}

}
