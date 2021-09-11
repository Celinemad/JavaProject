package myjava2;
/*
 * 1. 제목: 스레드 응용 예제를 작성
 * 	- 무한대를 지원하는 정수 덧셈 계산과 곱셈 계산을 동시에 수행하는 프로그램
 * 	- 계산 후에는 결과값이 출력, 계산하는데에 소요된 시간을 초 단위로 출력하기
 * 	- 1~10 까지의 덧셈 계산, 1~10까지의 곱셈 계산
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// java.math.BigInteger 클래스를 사용하기 위한 명령어를 꼭 작성하세요
import java.math.BigInteger;

//스레드 상태를 출력하는 스레드 클래스 정의
class MyStateThread extends Thread {
	// 멤버변수를 선언하기
	// 덧셈 일을 수행하고 잇는 스레드 객체의 주소를 보관할 참조 변수를 선언
	private MyAdderThread m_add;
	// 곱셈일을 수행하고 있는 스레드 객체의 주소를 보관할 참조 변수를 선언
	private MyMulerThread m_mul;
	
	// 덧셈 계산 스레드 상태를 출력할 때 사용할 JLabel 객체의 주소를 보관할 참조 변수를 선언 
	private JTextArea m_addl;
	
	// 곱셈 계산 스레드 상태를 출력할 때 사용할 JLabel 객체의 주소를 보관할 참조변수를 선언
	private JTextArea m_mull;
	
	// 생성자를 정의해서 클래스 외부에서 덧셈, 곱셈 스레드 객체의 주소를 받아오기
	public MyStateThread(MyAdderThread add, MyMulerThread mul, JTextArea addl, JTextArea mull) {
		m_add = add;
		m_mul = mul;
		m_addl = addl;
		m_mull = mull;
	}
	// 덧셈 일을 수행하고 있는 스레드 객체의 상태를 화면에 출력하기 -> 위로 이동해서 JLabel 참조변수를 선언해 주세요
	// 곱셈 일을 수행하고 있는 스레드 객체의 상태를 화면에 출력하기 
	@Override 
	public void run() {
		/* 
		 * 1. while 반복문을 사용해서 무한 반복문을 작성
		 * -> 종료조건: 덧셈 스레드 객체와 곱셈 스레드 객체가 모두 TERMINATED 상태인 경우
		 */
		// 덧셈 스레드 객체의 현재 상태 값을 보관할 변수를 선언
		Thread.State adds = m_add.getState();
		// 곱셈 스레드 객체의 현재 상태 값을 보관할 변수를 선언
		Thread.State muls = m_mul.getState();
		// 2. 무한 반복문을 작성
		while(true) {
			// 덧셈 계산 스레드의 현재 상태를 화면에 출력
			m_addl.append(adds.toString()+"\n");
			System.out.println(adds.toString());
			// 1초 동안 CPU를 잠자게 하기
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				// return 명령어를 사용해서 run() 메소드를 종료하기
				e.printStackTrace();
				return;
			}
			// 곱셈 계산 스레드의 현재 상태를 화면에 출력 
			m_mull.append(muls.toString()+"\n");
			System.out.println(muls.toString());
			
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

// 1~10 까지의 것셈 계산을 수행하는 스레드 클래스를 정의
class MyAdderThread extends Thread {
	
	/*
	 * 1. 덧셈 계산 과정과 결과를 보여주는 JTextArea 객체의 주소를 가져오기
	 * 1) MyWindow 클래스에서 정의(다른클래스에 정의)
	 * 		가. 생성자를 정의: public 클래스명(JTextArea 매개변수명) { }
	 * 		나. 일반 메소드를 정의: public void 메소드명(JTextArea 매개변수명) { }
	 * 		-> 멤버변수를 먼저 선언: private JTextArea 멤버변수명 = null;
	 */
	private JTextArea m_ta = null;
	
	// 2. 생성자
	public MyAdderThread(JTextArea ta) {
		m_ta = ta;
	}
	
	// 3. 일반 메소드
	public void setTA(JTextArea ta) {
		m_ta = ta;
	}
	
	// run() 메소드를 꼭 재정의하기
	@Override
	public void run() {
		/*
		 * 1~10까지의 덧셈 계산을 수행하고 중간 과정과 최종 결과를 모두 출력
		 * 출력 결과)
		 * 1+
		 * 2+
		 * 3+
		 * ...
		 * 10 = 최종결과
		 * 
		 * 또는
		 * 1+2+3+...+10 = 최종결과
		 * 
		 *  무한대 정수 덧셈 계산: 최대값이 정해져 있지 않은 계산
		 *  -> BigInteger 클래스를 사용
		 *  	-> 원리: 숫자를 문자열로 변환 -> 문자렬을 바로 사용해서 계산을 수행
		 *  -> BigInteger 클래스를 사용해서 정수 덧셈 계간의 중간 과정 값과 최종 결과를 보관할 벼수 sum 또는 total
		 *     객체를 생성
		 *     -> 형식) BigInteger 변수명 = new BigInteger("숫자");
		 *     -> 예) BigInteger sum = new BigInteger("0");
		 */
		BigInteger sum = new BigInteger("0");
		// sum = sum + 1; -> 불가능(오류) -> add() 메소드를 사용해야 합니다.
		// -> 형식) sum = sum.add(new BigInteger("더할값));
		// 예) sum = sum.add(new BigInteger(1+""));
		
		// 일을 수행하기 전의 현재 시간을 구하기
//		long start = System.currentTimeMillis();
		// 일을 다 수행한 후의 시간을 보관할 변수를 선언 
//		long end = 0L;
		
		// for 반복문을 사용해서 1+2+3+...+10까지의 덧셈 계산을 수행하기 + 화면에 출력하기
		for(int i=1; i<=10; i++) {
			sum = sum.add(new BigInteger(i+""));
			// 변수 i 값을 화면에 출력
			// -> JTextArea 클래스의 append() 메소드를 사용
//			m_ta.append(i+"");
//			// if 조건문을 사용해서 변수 i 값이 마지막 값인 10이 아니면 연산자 +와 줄바꿈 기호를 출력
//			if(i != 10)
//				m_ta.append("+\n");
		}
		// 모든 계산을 다 마친 후에는 = 기호와 최종 결과를 화면에 출력
//		m_ta.append("="+sum+"\n");
		
		// 일을 다 마친 후의 시간을 구하기
//		end = System.currentTimeMillis();
		// 소요시간을 정수로 구하고 임시 변수는 diff에 저장
//		long diff = end - start;
		// 화면에 소요 시간을 출력하기
//		m_ta.append("소요 시간은 " + diff + "[단위는 밀리세컨드]\n");
	}
}

// 1~10 까지의 곱셈 계산을 수행하는 스레드 클래스를 정의
class MyMulerThread extends Thread{
	private JTextArea m_ta = null;
	
	// 2. 생성자
	public MyMulerThread(JTextArea ta) {
		m_ta = ta;
	}
	
	// 3. 일반 메소드
	public void setTA(JTextArea ta) {
		m_ta = ta;
	}
	
	// run() 메소드 재정의
	@Override 
	public void run() {
		BigInteger mul = new BigInteger("1");
		
		// 일을 수행하기 전의 현재 시간을 구하기
//		long start = System.currentTimeMillis();
		// 일을 다 수행한 후의 시간을 보관할 변수를 선언 
//		long end = 0L;
		
		for(int i=1; i<=10; i++) {
			mul = mul.multiply(new BigInteger(i+""));
//			m_ta.append(i+"");
//			if(i != 10)
//				m_ta.append("*\n");
		}
//		m_ta.append("="+mul+"\n");
		
		// 일을 다 마친 후의 시간을 구하기
//		end = System.currentTimeMillis();
		// 소요시간을 정수로 구하고 임시 변수는 diff에 저장
//		long diff = end - start;
		// 화면에 소요 시간을 출력하기
//		m_ta.append("소요 시간은 " + diff + "[단위는 밀리세컨드]\n");
	}
}

class CompDiff extends Thread {
	// MyAdderThread 클래스의 run() 메소드에서 사용했던 long diff 변수의 값을 따로 보관할 멤버변수를 선언
	private long m_diff01 = 0L;
	// MyMulerThread 클래스의 run() 메소드에서 사용했던 long diff 변수의 값을 따로 보관할 멤버변수를 선언
	private long m_diff02 = 0L;
	// 일반 메소드를 새로 정의하기
	public void setdiff01(long diff01) {
		m_diff01 = diff01;
	}
	public void setdiff02(long diff02) {
		m_diff02 = diff02;
	}
	
	@Override 
	public void run() {
		if(m_diff01 > m_diff02) 
			JOptionPane.showMessageDialog(null, "덧셈 결과가 더 빨리 나옴");
		else if(m_diff01 < m_diff02) 
			JOptionPane.showMessageDialog(null, "곱셈 결과가 더 빨리 나옴");
		else
			JOptionPane.showMessageDialog(null, "동일");
	}
}



// 윈도우를 출력하는 클래스 정의
/*
 * 1. 제목: JPanel 클래스를 사용해서 화면을 2개로 분리하기
 * 	1) private JPanel 변수명 = new JPanel(new GridLayout(1,2));
 * 	2) 덧셈 계산 과정과 결과를 출력할 객체를 생성: JTextArea 클래스를 사용해서 객체를 생성
 * 		- private JTextArea 변수명2 = new JTextArea();
 * 	3) 곱셈 계산 과정과 결과를 출력할 객체를 생성:
 * 		- private JTextArea 변수명3 = new JTextArea();
 * 	4) 스크롤바를 출력해줄 객체를 생성: 덧셈 계산 과정을 출력해주는 JTextArea 객체와 함께 사용
 * 		- private JScrollPane 변수명4 = new JScrollPane(변수명2);
 * 	5) 곱셈 계산 과정을 출력해주는 JTextArea 객체와 함께 사용할 스크롤바를 출력해줄 객체를 생성
 * 		- private JScrollPane 변수명5 = new JScrollPane(변수명3);
 * 	6) 컨테이너 객체의 주소를 보관할 변수를 선언
 * 		- private Container 변수명6 = null;
 * 	7) MyAdderThread 클래스를 사용하기 위한 객체를 생성
 * 		- private MyAdderThread 변수명7 = new MyAdderThread(변수명2);
 * 	8) MyMulerThread 클래스를 사용하기 위한 객체를 생성
 * 		- private MyMulerThread 변수명8 = new MyMulerThread(변수명3);
 */
class MyWindow extends JFrame {
	// JPanel 클래스를 사용해서 객체를 생성: 화면 분할에 사용
	private JPanel m_panel = new JPanel(new GridLayout(1,2));
	// new JPanel(new GridLayout(2, 1));
	
	// Container 객체의 주소를 보관할 참조 변수를 선언: 화면에 컴포넌트를 출력
	private Container m_container = null;
	
	// 덧셈 계산 과정과 결과를 보여줄 JTextArea 객체를 생성: 여러 줄 여러 칸 내용을 출력
	private JTextArea m_addta = new JTextArea();
	
	// JScrollPane 클래스를 사용해서 스크롤 바를 출력
	private JScrollPane m_addsp = new JScrollPane(m_addta);
	
	// 곱셈 계산 과정과 결과를 보여줄 JTextArea 객체를 생성
	private JTextArea m_multa = new JTextArea();
	private JScrollPane m_mulsp = new JScrollPane(m_multa);
	
	// 글자의 글꼴, 스타일, 크기를 바꿀 때 사용할 폰트 객체를 생성
	public static final Font MY_FONT = new Font("궁서체", Font.BOLD + Font.ITALIC, 30);
	
	// 추가: MyAdderThread 클래스를 사용하기 위한 참조 변수를 선언
	private MyAdderThread m_adderth = new MyAdderThread(m_addta);
	
	// 추가: MyMulerThread 클래스를 사용하기 위한 참조 변수를 선언
	private MyMulerThread m_mulerth = new MyMulerThread(m_multa);
	
	private MyStateThread m_st = new MyStateThread(m_adderth, m_mulerth, m_addta, m_multa);

	
	
	// 생성자를 정의
	public MyWindow(String title) {
		// JFrame 클래스의 생성자를 호출
		super(title);
		
		// 컨테이너 객체에 접근해서 객체의 주소를 읽어와서 m_container 멤버변수에 대입
		m_container = getContentPane();
		
		// 덧셈 계산 결과를 보여줄 JScrollPane 객체를 판넬에 넣기
		m_panel.add(m_addsp);
		
		// 곱셈 계산 결과를 보여줄 JScrollPane 객체를 판넬에 넣기
		m_panel.add(m_mulsp);
		
		// 컨테이너에 판넬 넣기
		m_container.add(m_panel);
		
		// 덧셈 계산 결과를 보여줄 JTextArea의 글자 속성을 바꾸기
		m_addta.setFont(MY_FONT);
		
		// 곱셈 계산 결과를 보여줄 JTextArea의 글자 속성을 바꾸기
		m_multa.setFont(MY_FONT);
		
		// 추가: 덧셈 계산을 수행하는 스레드 객체를 생성
//		m_adderth = new MyAdderThread(m_addta);
		
		// 추가: 곱셈 계산을 수행하는 스레드 객체를 생성
//		m_mulerth = new MyMulerThread(m_multa);
		
		// 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 윈도우 크기는 화면에 꽉차게 하기
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// 윈도우 화면의 크기를 사용자가 바꾸지 못하도록 하기
		setResizable(false);
		
		// 윈도우를 출력
		setVisible(true);
		
		m_st.setDaemon(true);
		m_st.start();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// 추가: 덧셈 계산을 수행하기
		m_adderth.start();
		
		// 추가: 곱셈 계산을 수행하기
		m_mulerth.start();
	}
}
public class TestCalcThread {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test calc thread");
		
		
	}

}
