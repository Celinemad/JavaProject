package myjava01;
/*
 * 1. 현재 실행 중인 스레드 상태를 출력하는 예제
 * 	1) 덧셈 계산 스레드의 현재 상태를 JTextArea 컴포넌트에 출력
 * 	2) 곱셈 계산 스레드의 현재 상태를 JTextArea 컴포넌트에 출력
 */
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

import javax.swing.*;
import javax.swing.event.*;

// 덧셈 계산을 수행하는 스레드 클래스 정의
class MyAdderThread extends Thread {
	// run() 메소드를 재정의
	@Override 
	public void run() {
		java.math.BigInteger sum = new java.math.BigInteger("0");
		for(int i=1; i<=100; i++) {
			sum = sum.add(new BigInteger(i+""));
		}
	}
}

// 곱셈 계산을 수행하는 스레드 클래스 정의
class MyMulerThread extends Thread {
	// run() 메소드를 재정의
	@Override 
	public void run() {
		java.math.BigInteger result = new java.math.BigInteger("1");
		for(int i=1; i<=100; i++) {
			result = result.multiply(new BigInteger(i+""));
		}
	}
}

// 스레드 상태를 출력하는 스레드 클래스 정의
class MyStateThread extends Thread {
	// 멤버변수를 선언하기
	// 덧셈 일을 수행하고 잇는 스레드 객체의 주소를 보관할 참조 변수를 선언
	private MyAdderThread m_add;
	// 곱셈일을 수행하고 있는 스레드 객체의 주소를 보관할 참조 변수를 선언
	private MyMulerThread m_mul;
	
	// 덧셈 계산 스레드 상태를 출력할 때 사용할 JLabel 객체의 주소를 보관할 참조 변수를 선언 
	private JLabel m_addl;
	
	// 곱셈 계산 스레드 상태를 출력할 때 사용할 JLabel 객체의 주소를 보관할 참조변수를 선언
	private JLabel m_mull;
	
	// 생성자를 정의해서 클래스 외부에서 덧셈, 곱셈 스레드 객체의 주소를 받아오기
	public MyStateThread(MyAdderThread add, MyMulerThread mul, JLabel addl, JLabel mull) {
		m_add = add;
		m_mul = mul;
		m_addl = addl;
		m_mull = mull;
	}
	// 덧셈 일을 수행하고 있는 스레드 객체의 상태를 화면에 출력하기 -> 위로 이동해서 JLabel 참조변수를 선언해 주세요
	// 곱셈 일을 수행하고 있는 스레드 객체의 상태를 화면에 출력하기 
	@Override public void run() {
		/* 
		 * 1. while 반복문을 사용해서 무한 반복문을 작성
		 * -> 종료조건: 덧 스레드 객체와 곱셈 스레드 객체가 모두 TERMINATED 상태인 경우
		 */
		// 덧셈 스레드 객체의 현재 상태 값을 보관할 변수를 선언
		Thread.State adds = m_add.getState();
		// 곱셈 스레드 객체의 현재 상태 값을 보관할 변수를 선언
		Thread.State muls = m_mul.getState();
		// 2. 무한 반복문을 작성
		while(true) {
			// 덧셈 계산 스레드의 현재 상태를 화면에 출력
			m_addl.setText(adds.toString());
			// 1초 동안 CPU를 잠자게 하기
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				// return 명령어를 사용해서 run() 메소드를 종료하기
				e.printStackTrace();
				return;
			}
			// 곱셈 계산 스레드의 현재 상태를 화면에 출력 
			m_mull.setText(muls.toString());
			
			// 만약 덧셈 계산 스레드의 현재 상태가 TERMINATED 되었다면 상태 출력을 중단하기
			if(adds == Thread.State.TERMINATED) {
				break;
			}
			
			// 만약 곱셈 계산 스레드의 현재 상태가 TERMINATED 되었다면 상태출력을 중단하기
			if(muls == Thread.State.TERMINATED) {
				break;
			}
			
			// 덧셈 계산 스레드의 현재 상태 값을 가져오기
			adds = m_add.getState();
			// 곱셈 계산 스레드의 현재 상태 값을 가져오기
			muls = m_mul.getState();
		}
	}
}

// 화면에 윈도우를 출력하는 클래스 정의
class MyWindow extends JFrame {
	/*
	 * JPanel 클래스를 사용해서 윈도우 화면을 2개로 분할하기
	 * -> private JPanel 참조변수명 = new JPanel(new GridLayout(1, 2));
	 */
	private JPanel m_panel = new JPanel(new GridLayout(1, 2));
	// 덧셈 계산 스레드의 현재 상태를 보여줄 JLabel 객체를 생성
	private JLabel m_addlbl = new JLabel();
	// 곱셈 계산 스레드의 현재 상태를 보여줄 JLabel 객체를 생성
	private JLabel m_mullbl = new JLabel();
	// 덧셈 계산 스레드 객체를 생성
	private MyAdderThread m_addt = new MyAdderThread();
	// 곱셈 계산 스레드 객체를 생성
	private MyMulerThread m_mult = new MyMulerThread();
	// 스레드 객체의 상태를 출력해 줄 스레드 객체를 생성
	private MyStateThread m_st = new MyStateThread(m_addt, m_mult, m_addlbl, m_mullbl);
	// 컨테이너 객체의 주소를 보관할 참조 변수를 선언
	private Container m_container = null;
	// 생성자를 정의
	public MyWindow(String title) {
		// 윈도우 제목 문자열 출력 
		super(title);
		// 컨테이너 객체의 주소를 가져오기
		m_container = getContentPane();
		// 판넬 객체에 덧셈 라벨 객체를 넣기
		m_panel.add(m_addlbl);
		// 판넬 객체에 곱셈 라벨 객체를 넣기
		m_panel.add(m_mullbl);
		// 판넬 객체를 BorderLayout의 가운데 위치에 넣기
		m_container.add(m_panel, BorderLayout.CENTER);
		// 윈도우 종료 이벤트 처리하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우 크기는 화면 전체 크기로 설정
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 윈도우 크기 교정
		setResizable(false);
		// 윈도우를 화면에 출력
		setVisible(true);
		// 스레드 객체의 시작은 스레드 상태를 출력해주는 m_st(MyStateThread 클래스)
		// + 데몬 스레드를 설정해야 다른 스레드 객체보다 제일 나중에 종료됨.
		// -> start() 메소드를 호출하기 전에 setDaemon()를 호출 -> 형식은 참조변수명.setDaemont(true);
		m_st.setDaemon(true);
		m_st.start();
		// sleep() 함수를 호출해서 지연시키기(이유: CPU의 실행 속도가 너무 빠르기 때문)
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		// 덧셈 계산 스레드 객체를 실행 가능한 상태로 만들기
		m_addt.start();
		// 곱셈 계산 스레드 객체를 실행 가능한 상태로 만들기
		m_mult.start();
	}
}

public class TestThreadState {

	public static void main(String[] args) {
		
		MyWindow window = new MyWindow("show thread state");
		
	}

}
