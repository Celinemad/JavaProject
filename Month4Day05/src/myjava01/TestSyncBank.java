package myjava01;
/*
 * 1. 제목: 여러 스레드 객체를 사용해서 은행 업무를 수행하는 프로그램
 */
// 1. 은행 통장을 표현하는 클래스를 정의
class MyBankAccount {
	// 1) 예금주를 문자열로 보관할 멤버변수를 선언
	private String m_name;
	// 2) 은행명을 문자열로 보관할 멤버변수를 선언
	private String m_bname;
	// 3) 현재 잔액을 정수로 보관할 멤버변수를 선언
	private int m_balance;
	// 4) 계좌번호를 문자열로 보관할 멤버변수를 선언
	private String m_acctno;
	// 5) 생성자를 정의해서 다른 클래스로부터 에금주, 은행명, 잔액, 계좌번호를 받아오는 일을 수행
	public MyBankAccount(String name, String bname, int balance, String acctno) {
		m_name = name;
		m_bname = bname;
		m_balance = balance;
		m_acctno = acctno;
	}
	// 6) 위에서 선언한 각각의 멤버변수의 값을 읽거나 쓰는 일을 수행하는 메소드를 정의(필수 메소드)
	//     -> 이유: 다른 클래스에서 멤버변수에 접근할 때 사용할 메소드
	// 가. 예금주를 반환하는 메소드 정의(읽기 메소드)
	public String readName() {
		return m_name;
	}
	// 나. 예금주를 바꾸는 메소드 정의(쓰기 메소드)
	public void changeName(String newName) {
		m_name = newName;
	}
	
	// 다. 은행명을 반환하는 메소드
	public String readBName() {
		return m_bname;
	}
	
	// 라. 은행명을 바꾸는 메소드 
	public void changeBName(String newBName) {
		m_bname = newBName;
	}
	
	// 마. 현재 잔액을 반환하는 메소드(다른 스레드에서 사용하기 때문에 synchronized)
	public synchronized int readBalance() {
		return m_balance;
	}
	
	// 바. 현재 잔액을 바꾸는 메소드
	public synchronized void changeBalance(int newBalance) {
		m_balance = newBalance;
	}
	
	// 사. 계좌번호를 반환하는 메소드
	public String readAcctNo() {
		return m_acctno;
	}
	
	// 아. 현재 계좌번호를 바꾸는 메소드
	public void changeAcctNo(String newAcctNo) {
		m_acctno = newAcctNo;
	}
	
	// 자. 입금 업무를 수행할 때 호출되는 메소드: 동기화 메소드로 꼭 정의하세요!
	public synchronized int deposit(String userName, int money) {
		// 외부 클래스로부터 매개변수 money로 전달되는 값을 검사하기
		if(money > 0) {
			System.out.println(userName + "입금 업무를 시작합니다...");
			m_balance += money;
			System.out.println(userName + "입금 업무를 종료합니다...");
		} else {
			System.out.println("입금액 오류로 인하여 입금 업무를 진행하지 않습니다...");
			return m_balance;
			/*
			 * 또는 wait() 메소드를 호출 가능
			 * try {
			 *     wait();
			 * } catch(InterruptedException e) {
			 *     e.printStackTrace();
			 *     return m_balance;
			 * }
			 */
		}
		
		// 다른 스레드에서 deposit() 메소드를 호출할 수 있도록 notify() 메소드를 호출
		notify();
		return m_balance;
	}
	
	/*
	 * 차. 출금 업무를 수행하는 동기화 메소드를 정의
	 * 
	 * - 알고리즘을 작성
	 * 1) 다른 클래스로부터 전달 받을 출금액을 판단(조사)하기
	 *     - 현재 잔액과 출금액을 비교해서 잔액이 같거나 큰 경우에만 출금 업무를 수행합니다.
	 *         - 만약 작은 경우에는 출금 업무를 진행할 수 없습니다. 
	 */
	public synchronized int withdraw(String userName, int money) {
		// 2) 출금액과 잔액을 비교
		if(m_balance >= money) {
			System.out.println(userName + "출금업무를 시작합니다...");
			m_balance -= money;
			System.out.println(userName + "출금업무를 종료합니다...");
			notify(); // 안하면 락 걸림
		} else {
			System.out.println("현재 잔액이 부족해서 출금할 수 없습니다...");
			// wait() 메소드를 호출해서 현재 실행하고 있는 스레드를 대기 상태로 전환
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
				return m_balance;
			}
		}
		return m_balance;
	}
}

/*
 * 실제 입금 업무를 수행할 스레드 클래스와 출금 업무를 수행할 스레드 클래스를 정의
 * 
 * 1. 서로 분리
 * 2. 합침
 */
// 서로 분리: 각각 독립적인 스레드 클래스를 정의
/*
 * 1. 입금 업무를 수행할 스레드 클래스를 정의
 * 1) 이름: MyDepositThread
 * 2) 멤버 변수들을 선언
 *     가. MyBankAccount 클래스를 사용해서 참조 변수를 선언: 은행 통장에 접근할 때 사용할 변수
 *     나. 현재 은행 통장에 접근(사용)하고 있는 사람의 이름을 보관할 변수를 선언
 * 3) 메소드들을 정의
 *     가. 생성자를 정의
 *     나. run() 메소드를 정의
 */
class MyDepositThread extends Thread {
	private MyBankAccount m_ba;
	public String m_userName;
	private Object m_object = new Object();
	// 생성자를 정의
	public MyDepositThread(String userName, MyBankAccount ba) {
		m_userName = userName;
		m_ba = ba;
	}
	// run() 메소드를 재정의
	@Override 
	public void run() {
		// 한번만 입금 업무를 수행하기
		// -> MyBankAccount 클래스의 deposit() 메소드를 호출: 메소드에 전달할 금액을 처리하는 방법
		// 1) 사용자로부터 금액을 입력받기 2) 난수를 생성해서 금액으로 사용하기
		// 2번 방식을 사용: Random 클래스를 사용 -> 형식은 java.util.Random 변수명 = new java.util.Random();
		synchronized(m_ba) {
			java.util.Random random = new java.util.Random();
			// 난수의 범위: 약 -21억 ~ +21억
//			int inputMoney = random.nextInt(5000);
//			System.out.println("입금액은 " + inputMoney);
			// 2) deposit() 메소드를 호출하고 현재 잔액을 받아오기
//			int currentBalance = m_ba.deposit(inputMoney);
			// 3) 현재 잔액을 화면에 출력하기 
//			System.out.println("현재 잔액은 " + currentBalance);
			/*
			 * 총 3번의 입금 업무 일을 수행하는 for 반복문을 작성하기
			 * for(int cnt=1; cnt<=3; cnt++) {
			 *     int inputMoney = random.nextInt();
			 *     int currentBalance = m_ba.deposit(inputMoney);
			 *     System.out.println("현재 잔액은 " + currentBalance);
			 * }
			 */
			// +) for문으로 3번 반복
			for(int cnt=1; cnt<=3; cnt++) {
				int inputMoney = random.nextInt(5000);
				System.out.println(m_userName + " 입금액은 " + inputMoney);
				int currentBalance = m_ba.deposit(m_userName, inputMoney);
				System.out.println(m_userName + " 현재 잔액은 " + currentBalance);
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

/*
 * 실제 출금 업무를 수행하는 스레드 클래스를 정의
 * 1. 이름: MyWithdrawThread
 * 2. 멤버 변수들을 선언:
 * 1) 은행 통장에 접근할 때 사용할 참조 변수: private MyBankAccount m_ba;
 * 2) 현재 통장을 사용하고 있는 사용자 이름을 보관할 변수: private String m_userName;
 * 3. 메소드들을 정의
 * 1) 생성자
 * 2) run() 메소드
 */
class MyWithdrawThread extends Thread {
	private MyBankAccount m_ba2;
	private String m_userName2;
	private Object m_object = new Object();
	// 생성자를 정의
	public MyWithdrawThread(String userName2, MyBankAccount ba2) {
		m_userName2 = userName2;
		m_ba2 = ba2;
	}
	// run() 메소드를 재정의
	@Override
	public void run() {
		/*
		 * 1. 한번만 출금 업무를 수행하기
		 * 2. 여러번 출금 업무를 수행하기
		 */
		synchronized(m_ba2) {
			java.util.Random random2 = new java.util.Random();
//			int inputMoney2 = random2.nextInt(5000);
//			System.out.println("출금액은 " + inputMoney2);
			// MyBankAccount 클래스의 withdraw() 메소드를 호출
//			int currentBalance2 = m_ba2.withdraw(inputMoney2);
			// +) for문으로 3번 반복
			for(int cnt=1; cnt<=3; cnt++) {
				int inputMoney2 = random2.nextInt(5000);
				System.out.println(m_userName2 + "출금액은 " + inputMoney2);
				int currentBalance2 = m_ba2.withdraw(m_userName2, inputMoney2);
				System.out.println(m_userName2 +"현재 잔액은 " + currentBalance2);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// 출금 업무를 수행한 후의 현재 잔액을 확인하기 위해서 화면에 출력
//		System.out.println("출금 일을 수행한 후의 현재 잔액은 " + currentBalance2 + " 현재 통장을 사용하고 있는 사용자 이름은 " + m_userName2);
//		try {
//			Thread.sleep(1000);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}

public class TestSyncBank {

	public static void main(String[] args) {
		MyBankAccount ba3 = new MyBankAccount("홍길동", "신협", 5000, "1234-56-78");
		// 입금 업무를 수행할 스레드 객체를 생성
		MyDepositThread dth = new MyDepositThread("김길동", ba3);
		// 출금 업무를 수행할 스레드 객체를 생성
		MyWithdrawThread wth = new MyWithdrawThread("나길동", ba3);
		// 입금 스레드 객체를 실행 상태로 전환
		dth.start();
		// 출금 스레드 객체를 실행 상태로 전환
		wth.start();
		
		
	}

}
