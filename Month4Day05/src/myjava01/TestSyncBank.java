package myjava01;
/*
 * 1. ����: ���� ������ ��ü�� ����ؼ� ���� ������ �����ϴ� ���α׷�
 */
// 1. ���� ������ ǥ���ϴ� Ŭ������ ����
class MyBankAccount {
	// 1) �����ָ� ���ڿ��� ������ ��������� ����
	private String m_name;
	// 2) ������� ���ڿ��� ������ ��������� ����
	private String m_bname;
	// 3) ���� �ܾ��� ������ ������ ��������� ����
	private int m_balance;
	// 4) ���¹�ȣ�� ���ڿ��� ������ ��������� ����
	private String m_acctno;
	// 5) �����ڸ� �����ؼ� �ٸ� Ŭ�����κ��� ������, �����, �ܾ�, ���¹�ȣ�� �޾ƿ��� ���� ����
	public MyBankAccount(String name, String bname, int balance, String acctno) {
		m_name = name;
		m_bname = bname;
		m_balance = balance;
		m_acctno = acctno;
	}
	// 6) ������ ������ ������ ��������� ���� �аų� ���� ���� �����ϴ� �޼ҵ带 ����(�ʼ� �޼ҵ�)
	//     -> ����: �ٸ� Ŭ�������� ��������� ������ �� ����� �޼ҵ�
	// ��. �����ָ� ��ȯ�ϴ� �޼ҵ� ����(�б� �޼ҵ�)
	public String readName() {
		return m_name;
	}
	// ��. �����ָ� �ٲٴ� �޼ҵ� ����(���� �޼ҵ�)
	public void changeName(String newName) {
		m_name = newName;
	}
	
	// ��. ������� ��ȯ�ϴ� �޼ҵ�
	public String readBName() {
		return m_bname;
	}
	
	// ��. ������� �ٲٴ� �޼ҵ� 
	public void changeBName(String newBName) {
		m_bname = newBName;
	}
	
	// ��. ���� �ܾ��� ��ȯ�ϴ� �޼ҵ�(�ٸ� �����忡�� ����ϱ� ������ synchronized)
	public synchronized int readBalance() {
		return m_balance;
	}
	
	// ��. ���� �ܾ��� �ٲٴ� �޼ҵ�
	public synchronized void changeBalance(int newBalance) {
		m_balance = newBalance;
	}
	
	// ��. ���¹�ȣ�� ��ȯ�ϴ� �޼ҵ�
	public String readAcctNo() {
		return m_acctno;
	}
	
	// ��. ���� ���¹�ȣ�� �ٲٴ� �޼ҵ�
	public void changeAcctNo(String newAcctNo) {
		m_acctno = newAcctNo;
	}
	
	// ��. �Ա� ������ ������ �� ȣ��Ǵ� �޼ҵ�: ����ȭ �޼ҵ�� �� �����ϼ���!
	public synchronized int deposit(String userName, int money) {
		// �ܺ� Ŭ�����κ��� �Ű����� money�� ���޵Ǵ� ���� �˻��ϱ�
		if(money > 0) {
			System.out.println(userName + "�Ա� ������ �����մϴ�...");
			m_balance += money;
			System.out.println(userName + "�Ա� ������ �����մϴ�...");
		} else {
			System.out.println("�Աݾ� ������ ���Ͽ� �Ա� ������ �������� �ʽ��ϴ�...");
			return m_balance;
			/*
			 * �Ǵ� wait() �޼ҵ带 ȣ�� ����
			 * try {
			 *     wait();
			 * } catch(InterruptedException e) {
			 *     e.printStackTrace();
			 *     return m_balance;
			 * }
			 */
		}
		
		// �ٸ� �����忡�� deposit() �޼ҵ带 ȣ���� �� �ֵ��� notify() �޼ҵ带 ȣ��
		notify();
		return m_balance;
	}
	
	/*
	 * ��. ��� ������ �����ϴ� ����ȭ �޼ҵ带 ����
	 * 
	 * - �˰����� �ۼ�
	 * 1) �ٸ� Ŭ�����κ��� ���� ���� ��ݾ��� �Ǵ�(����)�ϱ�
	 *     - ���� �ܾװ� ��ݾ��� ���ؼ� �ܾ��� ���ų� ū ��쿡�� ��� ������ �����մϴ�.
	 *         - ���� ���� ��쿡�� ��� ������ ������ �� �����ϴ�. 
	 */
	public synchronized int withdraw(String userName, int money) {
		// 2) ��ݾװ� �ܾ��� ��
		if(m_balance >= money) {
			System.out.println(userName + "��ݾ����� �����մϴ�...");
			m_balance -= money;
			System.out.println(userName + "��ݾ����� �����մϴ�...");
			notify(); // ���ϸ� �� �ɸ�
		} else {
			System.out.println("���� �ܾ��� �����ؼ� ����� �� �����ϴ�...");
			// wait() �޼ҵ带 ȣ���ؼ� ���� �����ϰ� �ִ� �����带 ��� ���·� ��ȯ
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
 * ���� �Ա� ������ ������ ������ Ŭ������ ��� ������ ������ ������ Ŭ������ ����
 * 
 * 1. ���� �и�
 * 2. ��ħ
 */
// ���� �и�: ���� �������� ������ Ŭ������ ����
/*
 * 1. �Ա� ������ ������ ������ Ŭ������ ����
 * 1) �̸�: MyDepositThread
 * 2) ��� �������� ����
 *     ��. MyBankAccount Ŭ������ ����ؼ� ���� ������ ����: ���� ���忡 ������ �� ����� ����
 *     ��. ���� ���� ���忡 ����(���)�ϰ� �ִ� ����� �̸��� ������ ������ ����
 * 3) �޼ҵ���� ����
 *     ��. �����ڸ� ����
 *     ��. run() �޼ҵ带 ����
 */
class MyDepositThread extends Thread {
	private MyBankAccount m_ba;
	public String m_userName;
	private Object m_object = new Object();
	// �����ڸ� ����
	public MyDepositThread(String userName, MyBankAccount ba) {
		m_userName = userName;
		m_ba = ba;
	}
	// run() �޼ҵ带 ������
	@Override 
	public void run() {
		// �ѹ��� �Ա� ������ �����ϱ�
		// -> MyBankAccount Ŭ������ deposit() �޼ҵ带 ȣ��: �޼ҵ忡 ������ �ݾ��� ó���ϴ� ���
		// 1) ����ڷκ��� �ݾ��� �Է¹ޱ� 2) ������ �����ؼ� �ݾ����� ����ϱ�
		// 2�� ����� ���: Random Ŭ������ ��� -> ������ java.util.Random ������ = new java.util.Random();
		synchronized(m_ba) {
			java.util.Random random = new java.util.Random();
			// ������ ����: �� -21�� ~ +21��
//			int inputMoney = random.nextInt(5000);
//			System.out.println("�Աݾ��� " + inputMoney);
			// 2) deposit() �޼ҵ带 ȣ���ϰ� ���� �ܾ��� �޾ƿ���
//			int currentBalance = m_ba.deposit(inputMoney);
			// 3) ���� �ܾ��� ȭ�鿡 ����ϱ� 
//			System.out.println("���� �ܾ��� " + currentBalance);
			/*
			 * �� 3���� �Ա� ���� ���� �����ϴ� for �ݺ����� �ۼ��ϱ�
			 * for(int cnt=1; cnt<=3; cnt++) {
			 *     int inputMoney = random.nextInt();
			 *     int currentBalance = m_ba.deposit(inputMoney);
			 *     System.out.println("���� �ܾ��� " + currentBalance);
			 * }
			 */
			// +) for������ 3�� �ݺ�
			for(int cnt=1; cnt<=3; cnt++) {
				int inputMoney = random.nextInt(5000);
				System.out.println(m_userName + " �Աݾ��� " + inputMoney);
				int currentBalance = m_ba.deposit(m_userName, inputMoney);
				System.out.println(m_userName + " ���� �ܾ��� " + currentBalance);
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
 * ���� ��� ������ �����ϴ� ������ Ŭ������ ����
 * 1. �̸�: MyWithdrawThread
 * 2. ��� �������� ����:
 * 1) ���� ���忡 ������ �� ����� ���� ����: private MyBankAccount m_ba;
 * 2) ���� ������ ����ϰ� �ִ� ����� �̸��� ������ ����: private String m_userName;
 * 3. �޼ҵ���� ����
 * 1) ������
 * 2) run() �޼ҵ�
 */
class MyWithdrawThread extends Thread {
	private MyBankAccount m_ba2;
	private String m_userName2;
	private Object m_object = new Object();
	// �����ڸ� ����
	public MyWithdrawThread(String userName2, MyBankAccount ba2) {
		m_userName2 = userName2;
		m_ba2 = ba2;
	}
	// run() �޼ҵ带 ������
	@Override
	public void run() {
		/*
		 * 1. �ѹ��� ��� ������ �����ϱ�
		 * 2. ������ ��� ������ �����ϱ�
		 */
		synchronized(m_ba2) {
			java.util.Random random2 = new java.util.Random();
//			int inputMoney2 = random2.nextInt(5000);
//			System.out.println("��ݾ��� " + inputMoney2);
			// MyBankAccount Ŭ������ withdraw() �޼ҵ带 ȣ��
//			int currentBalance2 = m_ba2.withdraw(inputMoney2);
			// +) for������ 3�� �ݺ�
			for(int cnt=1; cnt<=3; cnt++) {
				int inputMoney2 = random2.nextInt(5000);
				System.out.println(m_userName2 + "��ݾ��� " + inputMoney2);
				int currentBalance2 = m_ba2.withdraw(m_userName2, inputMoney2);
				System.out.println(m_userName2 +"���� �ܾ��� " + currentBalance2);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// ��� ������ ������ ���� ���� �ܾ��� Ȯ���ϱ� ���ؼ� ȭ�鿡 ���
//		System.out.println("��� ���� ������ ���� ���� �ܾ��� " + currentBalance2 + " ���� ������ ����ϰ� �ִ� ����� �̸��� " + m_userName2);
//		try {
//			Thread.sleep(1000);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}

public class TestSyncBank {

	public static void main(String[] args) {
		MyBankAccount ba3 = new MyBankAccount("ȫ�浿", "����", 5000, "1234-56-78");
		// �Ա� ������ ������ ������ ��ü�� ����
		MyDepositThread dth = new MyDepositThread("��浿", ba3);
		// ��� ������ ������ ������ ��ü�� ����
		MyWithdrawThread wth = new MyWithdrawThread("���浿", ba3);
		// �Ա� ������ ��ü�� ���� ���·� ��ȯ
		dth.start();
		// ��� ������ ��ü�� ���� ���·� ��ȯ
		wth.start();
		
		
	}

}
