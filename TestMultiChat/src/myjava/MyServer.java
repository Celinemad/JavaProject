package myjava;
// DataInputStream Ŭ������ ����ؼ� �⺻ �ڷ����� ���� Ŭ���̾�Ʈ�κ��� ���� �� ���
// -> ���ڿ� ���� ���� ���� readUTF() �Լ��� ���
//     -> UTF��? �� ���迡 �ִ� ��� ���ڸ� ǥ���� �� ����ϴ� ����
// DataOutputStream Ŭ����: Ŭ���̾�Ʈ�� �⺻ �ڷ����� ���� ���� �� ���
// -> ���ڿ� ���� ���� ���� writeUTF() �Լ��� ���: �޽����� ���� �� ���
import java.io.*;
/*
 * ServerSocket Ŭ����: ���� ���α׷��� ����
 * Socket Ŭ����: Ŭ���̾�Ʈ ���α׷��� ����
 */
import java.net.*;
/*
 * ������ ���� �� ����� Random Ŭ����
 */
import java.util.*;

public class MyServer {
	
	/*
	 * 1. �ʿ��� ��� �������� ����
	 */
	// 1) ServerSocket Ŭ������ ����� ���� ����
	private ServerSocket m_ss = null;
	
	// 2) ������ ������ �� ����� Random Ŭ������ ����� ��������
		// static �Լ� �������� static ��� ������ ��� ����
	private static Random m_random = new Random();
	
	// 3) ������ ����ؼ� �������� ����� �� �ִ� ��Ʈ ��ȣ�� ��ȯ�ϴ� �Լ��� ����
	// - ������ ��: ����ȭ ����� ����ؾ� �մϴ�. (�ټ��� Ŭ���̾�Ʈ ��ǻ�Ϳ��� ����ϱ� ������ �ð��� ���� ����� ��)
	public static synchronized int getServerPort() {
		// 4) ��Ʈ��ȣ�� ������ ������ ���� + �ʱ�ȭ
		int port = -1; // ���� -1: 0 ~ 65535 ���� �ٱ��� ������ ���� -> ����: ���߿� ���ϱ� ����
		// 5) �÷���(flag: ���) ������ ����
		// -> ó�� ���� false, ����� ��Ʈ ��ȣ�� �߰��ϸ� true�� ������ ����
		boolean isFound = false;
		// 6) while �ݺ����� ����ؼ� ��� ������ isFound�� false�� ���� ����ؼ� �ݺ�������
		// �������� ����� ��Ʈ ��ȣ�� �˻��մϴ�.
		//     - ���� ����� ��Ʈ��ȣ�� ã������ �ݺ��� �ߴ��ϱ�: break; �Ǵ� return ã����Ʈ��ȣ;
		while(isFound == false) {
			// 7) m_random ���� ������ ���
			// -> ���� ���� ����: 1024 ~ 65535 -> ������ nextInt(�ִ밪 - �ּҰ� + 1) + �ּҰ�
			// -> ��) 20 ~ 30 -> nextInt(30 - 20 + 1) + 20 -> nextInt(11)+20 -> (0~10)+20 -> 20 ~ 30
			port = m_random.nextInt(65535 - 1024 + 1);
			// 8) Socket Ŭ������ ����ؼ� ��Ʈ ��ȣ�� ����� �� �ִ��� ���θ� �Ǵ��ϱ�
			try {
				Socket socket = new Socket("localhost", port);
				socket.close();
			} catch(UnknownHostException e1) {
				// "localhost" ���ڿ� ������ �߸��� ��쿡 UnknownHostException�� �߻�
			} catch(IOException e2) {
				// ���� ��Ʈ ��ȣ�� �ٸ� ���α׷����� ����ϰ� ���� ���� ��쿡�� IOException�� �߻�
				System.out.println("���� ���Ͽ��� ����� �� �ִ� ��Ʈ ��ȣ�� �ٰ���, ��Ʈ ��ȣ�� " + port);
				isFound = true;
				return port; // �Լ� ��ü�� ���
			}
		}
		return port;
	}
	
	public static void main(String[] args) {
		
		// MyServer Ŭ������ ����ؼ� ���ο� ��ü�� ����
		MyServer server = new MyServer();
		
		/*
		 * 1. ������ ������ getServerPort() �Լ��� ȣ���ؼ� ��Ʈ ��ȣ�� �����ͼ� �ӽ� ������ int tempPortNo�� ����
		 */
		int tempPortNo = getServerPort();
		
		/*
		 * 2. ���������� ��Ʈ ��ȣ�� ����������� �Ǵ��ϱ�: -1�� ��
		 *     - -1�� �ƴϸ� ���������� ��Ʈ ��ȣ�� ���� ���
		 *     - ���� -1�̸� ��Ʈ ��ȣ ��� ����
		 */
		if(tempPortNo == -1) {
			System.out.println("��Ʈ ��ȣ ��� ����");
			System.exit(-1);
		} else {
			System.out.println("��Ʈ ��ȣ ��� ����");
			System.out.println("���� ��Ʈ ��ȣ�� " + tempPortNo);
			// MyServer Ŭ�������� ������ ServerSocket ���� ������ m_ss�� ����ؼ� Ŭ���̾�Ʈ�� ��ٸ��� ��ü�� ����
			try {
				server.m_ss = new ServerSocket(tempPortNo);
				System.out.println("���� Ŭ���̾�Ʈ ��ǻ�͵��� ����(����)�� ��ٸ��� �ֽ��ϴ�...");
				// ServerSocket Ŭ������ accept() �޼ҵ带 ȣ���ؼ� ��� ���¿� �����ϱ�
				// -> ������ ��: while �ݺ����� ����ؼ� ���� �ݺ��� ���ο� �ۼ� (-> ���� �ݺ��� ���ο��� ���� Ŭ���̾�Ʈ�� �Է��� ����)
				while(true) {
					Socket clientSocket = server.m_ss.accept();
					// � ������ Ŭ���̾�Ʈ�� ������ ����Ǹ� ������ ��ɾ �ۼ�
					System.out.println("������ Ŭ���̾�Ʈ ��ǻ�Ϳ� ���� �����");
					// Ŭ���̾�Ʈ ��ǻ���� ������ ����ϱ�
					InetAddress clientInfo = clientSocket.getInetAddress();
					// �ܼ� ȭ�鿡 Ŭ���̾�Ʈ�� ȣ��Ʈ �̸��� ip �ּҸ� ���
					System.out.println("������ ����� Ŭ���̾�Ʈ ��ǻ���� ȣ��Ʈ �̸��� ip �ּҴ� " + clientInfo);
					// ��� ���� ���� ������ Ŭ������ ����ؼ� ���Ը� ����
					MyClientThread clientThread = new MyClientThread(clientSocket);
					// start() �޼ҵ带 ȣ���ؼ� ������ ��ü�� ���� ������ ���·� ��ȯ
					clientThread.start();
				}
			} catch(IOException e) {
				System.out.println("���� ���� ���� ����");
				e.printStackTrace();
			}
		}
	}
}
/*
 * ���� Ŭ���̾�Ʈ ���� ��������ִ� ������ Ŭ������ ����
 * 
 * 1. �̸�: MyClientThread
 * 2. ��� �������� ����
 * 1) Socket ��ü�� �ּҸ� ������ ���� ���� : private Socket m_clientSocket = null;
 * 2) Socket Ŭ������ ���� �ִ� InputStream ��ü�� �ּҸ� ������ ���� ����: private InputStream m_clientInputStream = null;
 *     - �뵵: Ŭ���̾�Ʈ���� ������ ���� �޽����� ���� �� ���
 * 3) Socket Ŭ������ ���� �ִ� OutputStream ��ü�� �ּҸ� ������ ���� ����: private OutputStream m_clientOutputStream = null;
 *     - �뵵: �������� Ŭ���̾�Ʈ�� �޽����� ���� �� ���
 * 4) �񿵾�� ���ڸ� �Է°� ��¿� ����� ��ü�� ����
 *     ��. �Է�: DataInputStream Ŭ������ ���
 *     ��. ���: DataOutputStream Ŭ������ ��� 
 */
class MyClientThread extends Thread {
	// 1. ��� �������� ����
	private Socket m_clientSocket = null;
	private InputStream m_clientInputStream = null;
	private OutputStream m_clientOutputStream = null;
	private DataInputStream m_clientDIS = null;
	private DataOutputStream m_clientDOS = null;
	// 2. �����ڸ� ���� -> �ٸ� Ŭ�����κ��� Socket ��ü�� �ּҸ� �޾ƿ���(����: �޽����� �ְ� ���� �� ����ϱ� ����)
	public MyClientThread(Socket clientSocket) {
		// 3. try ~ catch ���� �ۼ�
		try {
			// 4. �ٸ� Ŭ�����κ��� ���� ���� ��ü�� �ּҸ� ��������� m_clientSocket�� ����
			m_clientSocket = clientSocket;
			System.out.println("������ Ŭ������ Ŭ���̾�Ʈ ������ ����");
			// 5. Ŭ���̾�Ʈ�κ��� ���� ���� �޽����� ���� �� ����� ��ü�� ����
			m_clientInputStream =  m_clientSocket.getInputStream();
			// 6. �������� Ŭ���̾�Ʈ�� �޽����� ���� �� ����� ��ü�� ����
			m_clientOutputStream = m_clientSocket.getOutputStream();
			// 7. �񿵾�� ���ڸ� Ŭ���̾�Ʈ�� ���� �� ����� ��ü�� ����
			m_clientDOS = new DataOutputStream(m_clientOutputStream);
			// 8. �񿵾�� ���ڸ� Ŭ���̾�Ʈ�κ��� ���� �� ����� ��ü�� ����
			m_clientDIS = new DataInputStream(m_clientInputStream);
			// 9. Ŭ���̾�Ʈ���� ���� �޽����� �޾Ƽ� �ܼ� ȭ�鿡 ����ϱ�
			// -> DataInputStream Ŭ������ readUTF() �Լ��� ���
			String inputMessage = m_clientDIS.readUTF();
			System.out.println("Ŭ���̾�Ʈ�κ��� ���� �޽����� " + inputMessage);
			// 10. Ŭ���̾�Ʈ�� �޽����� �� �޾Ҵٰ� ��� �޽����� ������
			// -> DataOutputStream Ŭ������ writeUTF() �Լ��� ���
			m_clientDOS.writeUTF("�޽����� �� �޾ҽ��ϴ�.[������ ���� �޽���]");
			// 11. ������ ��: DataOutputStream Ŭ������ �ִ� flush() �Լ��� ȣ���ؼ� �޽����� Ŭ���̾�Ʈ ��ǻ�ͷ� ���۵�
			m_clientDOS.flush();
			System.out.println("Ŭ���̾�Ʈ�� �޽����� ������[������ ���� �޽���]");
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end of MyClientThread() �����ڸ� ����
	
	/*
	 * ��� Ŭ���̾�Ʈ ������ ��ü���� �Բ� �����ϴ� run() �Լ��� ������
	 */
	@Override
	public void run() {
		try {
			/*
			 * ������ ��: Ŭ���̾�Ʈ���� ���α׷��� ������ �����ϴ� ��찡 �߻� ����
			 *     - ����� ó������ ������ ���ܻ�Ȳ�� �߻�
			 *     - if ���ǹ��� ����ؼ� Ŭ���̾�Ʈ�κ��� �޽����� ���� �� �ִ��� ���Ҥ� Ȯ���ϱ�
			 *         - while �ݺ����� ����ؼ� ���� �ݺ��� ���� �ӿ� �ۼ�
			 */
			while(true) {
				
				/*
				 * if ���ǹ��� ����ؼ� Ŭ���̾�Ʈ�κ��� �޽����� ���� �� �ִ��� ���θ� Ȯ��
				 *     -> m_clientSocket == null
				 *     -> m_clientInputStream == null
				 *     -> m_clientDIS == null
				 */
				if(m_clientDIS == null || m_clientInputStream == null || 
				   m_clientSocket == null || m_clientSocket.isClosed() == true) {
					System.out.println("Ŭ���̾�Ʈ ������ �����");
					// ���� �ݺ����� Ż��(����)
					break;
				} 
				// Ŭ���̾�Ʈ�κ��� ���޹��� �޽����� �ܼ� ȭ�鿡 ����ϱ�
				String id = m_clientDIS.readUTF();
				String msg = m_clientDIS.readUTF();
				System.out.println("Ŭ���̾�Ʈ(ID:" + id + ")�κ��� ���޹��� �޽����� " + msg + "[�������� �ۼ�]");
				// sleep() �Լ��� ȣ���ؼ� 0.5�� ���� ������ ��ü�� ���� �ϱ�
				Thread.sleep(500);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


