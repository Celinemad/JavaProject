package myjava;
// DataInputStream 클래스를 사용해서 기본 자료형의 값을 클라이언트로부터 받을 때 사용
// -> 문자열 값을 받을 때는 readUTF() 함수를 사용
//     -> UTF란? 전 세계에 있는 모든 글자를 표현할 때 사용하는 형식
// DataOutputStream 클래스: 클라이언트로 기본 자료형의 값을 보낼 때 사용
// -> 문자열 값을 보낼 때는 writeUTF() 함수를 사용: 메시지를 보낼 때 사용
import java.io.*;
/*
 * ServerSocket 클래스: 서버 프로그램용 포켓
 * Socket 클래스: 클라이언트 프로그램용 소켓
 */
import java.net.*;
/*
 * 난수를 만들 때 사용할 Random 클래스
 */
import java.util.*;

public class MyServer {
	
	/*
	 * 1. 필요한 멤버 변수들을 선언
	 */
	// 1) ServerSocket 클래스를 사용한 참조 변수
	private ServerSocket m_ss = null;
	
	// 2) 난수를 생성할 때 사용할 Random 클래스를 사용한 참조변수
		// static 함수 내에서는 static 멤버 변수만 사용 가능
	private static Random m_random = new Random();
	
	// 3) 난수를 사용해서 서버에서 사용할 수 있는 포트 번호를 반환하는 함수를 정의
	// - 주의할 점: 동기화 기능을 사용해야 합니다. (다수의 클라이언트 컴퓨터에서 사용하기 때문에 시간을 서로 맞춰야 함)
	public static synchronized int getServerPort() {
		// 4) 포트번호를 보관할 변수를 선언 + 초기화
		int port = -1; // 값은 -1: 0 ~ 65535 범위 바깥의 값으로 결정 -> 이유: 나중에 비교하기 위함
		// 5) 플래그(flag: 깃발) 변수를 선언
		// -> 처음 값을 false, 사용할 포트 번호를 발견하면 true로 변경할 예정
		boolean isFound = false;
		// 6) while 반복문을 사용해서 깃발 변수인 isFound가 false일 동안 계속해서 반복적으로
		// 서버에서 사용할 포트 번호를 검색합니다.
		//     - 만약 사용할 포트번호를 찾았으면 반복을 중단하기: break; 또는 return 찾은포트번호;
		while(isFound == false) {
			// 7) m_random 참조 변수를 사용
			// -> 난수 생성 범위: 1024 ~ 65535 -> 공식은 nextInt(최대값 - 최소값 + 1) + 최소값
			// -> 예) 20 ~ 30 -> nextInt(30 - 20 + 1) + 20 -> nextInt(11)+20 -> (0~10)+20 -> 20 ~ 30
			port = m_random.nextInt(65535 - 1024 + 1);
			// 8) Socket 클래스를 사용해서 포트 번호를 사용할 수 있는지 여부를 판단하기
			try {
				Socket socket = new Socket("localhost", port);
				socket.close();
			} catch(UnknownHostException e1) {
				// "localhost" 문자열 내용이 잘못된 경우에 UnknownHostException이 발생
			} catch(IOException e2) {
				// 만약 포트 번호를 다른 프로그램에서 사용하고 있지 않은 경우에는 IOException이 발생
				System.out.println("서버 소켓에서 사용할 수 있는 포트 번호를 바견함, 포트 번호는 " + port);
				isFound = true;
				return port; // 함수 전체를 벗어남
			}
		}
		return port;
	}
	
	public static void main(String[] args) {
		
		// MyServer 클래스를 사용해서 새로운 객체를 생성
		MyServer server = new MyServer();
		
		/*
		 * 1. 위에서 정의한 getServerPort() 함수를 호출해서 포트 번호를 가져와서 임시 변수인 int tempPortNo에 저장
		 */
		int tempPortNo = getServerPort();
		
		/*
		 * 2. 정상적으로 포트 번호가 얻어졌는지를 판단하기: -1과 비교
		 *     - -1이 아니면 정상적으로 포트 번호를 얻은 경우
		 *     - 만약 -1이면 포트 번호 얻기 실패
		 */
		if(tempPortNo == -1) {
			System.out.println("포트 번호 얻기 실패");
			System.exit(-1);
		} else {
			System.out.println("포트 번호 얻기 성공");
			System.out.println("얻은 포트 번호는 " + tempPortNo);
			// MyServer 클래스에서 선언한 ServerSocket 참조 변수인 m_ss를 사용해서 클라이언트를 기다리는 객체를 생성
			try {
				server.m_ss = new ServerSocket(tempPortNo);
				System.out.println("여러 클라이언트 컴퓨터들의 접속(연결)을 기다리고 있습니다...");
				// ServerSocket 클래스의 accept() 메소드를 호출해서 대기 상태에 돌입하기
				// -> 주의할 점: while 반복문을 사용해서 무한 반복문 내부에 작성 (-> 무한 반복문 내부여야 여러 클라이언트의 입력을 받음)
				while(true) {
					Socket clientSocket = server.m_ss.accept();
					// 어떤 임의의 클라이언트와 서버가 연결되면 실행할 명령어를 작성
					System.out.println("임의의 클라이언트 컴퓨터와 서로 연결됨");
					// 클라이언트 컴퓨터의 정보를 출력하기
					InetAddress clientInfo = clientSocket.getInetAddress();
					// 콘솔 화면에 클라이언트의 호스트 이름과 ip 주소를 출력
					System.out.println("서버와 연결된 클라이언트 컴퓨터의 호스트 이름과 ip 주소는 " + clientInfo);
					// 방금 전에 만든 스레드 클래스를 사용해서 개게를 생성
					MyClientThread clientThread = new MyClientThread(clientSocket);
					// start() 메소드를 호출해서 스레드 객체를 실행 가능한 상태로 전환
					clientThread.start();
				}
			} catch(IOException e) {
				System.out.println("서버 소켓 생성 오류");
				e.printStackTrace();
			}
		}
	}
}
/*
 * 여러 클라이언트 들을 연결시켜주는 스레드 클래스를 정의
 * 
 * 1. 이름: MyClientThread
 * 2. 멤버 변수들을 선언
 * 1) Socket 객체의 주소를 보관할 참조 변수 : private Socket m_clientSocket = null;
 * 2) Socket 클래스가 갖고 있는 InputStream 객체의 주소를 보관할 참조 변수: private InputStream m_clientInputStream = null;
 *     - 용도: 클라이언트에서 서버로 보낸 메시지를 받을 때 사용
 * 3) Socket 클래스가 갖고 있는 OutputStream 객체의 주소를 보관할 참조 변수: private OutputStream m_clientOutputStream = null;
 *     - 용도: 서버에서 클라이언트로 메시지를 보낼 때 사용
 * 4) 비영어권 글자를 입력과 출력에 사용할 객체를 생성
 *     가. 입력: DataInputStream 클래스를 사용
 *     나. 출력: DataOutputStream 클래스를 사용 
 */
class MyClientThread extends Thread {
	// 1. 멤버 변수들을 선언
	private Socket m_clientSocket = null;
	private InputStream m_clientInputStream = null;
	private OutputStream m_clientOutputStream = null;
	private DataInputStream m_clientDIS = null;
	private DataOutputStream m_clientDOS = null;
	// 2. 생성자를 정의 -> 다른 클래스로부터 Socket 객체의 주소를 받아오기(이유: 메시지를 주고 받을 때 사용하기 위함)
	public MyClientThread(Socket clientSocket) {
		// 3. try ~ catch 블럭을 작성
		try {
			// 4. 다른 클래스로부터 받은 소켓 객체의 주소를 멤버변수인 m_clientSocket에 저장
			m_clientSocket = clientSocket;
			System.out.println("스레드 클래스에 클라이언트 소켓을 저장");
			// 5. 클라이언트로부터 전달 받을 메시지를 받을 때 사용할 객체를 생성
			m_clientInputStream =  m_clientSocket.getInputStream();
			// 6. 서버에서 클라이언트로 메시지를 보낼 때 사용할 객체를 생성
			m_clientOutputStream = m_clientSocket.getOutputStream();
			// 7. 비영어권 글자를 클라이언트로 보낼 때 사용할 객체를 생성
			m_clientDOS = new DataOutputStream(m_clientOutputStream);
			// 8. 비영어권 글자를 클라이언트로부터 받을 때 사용할 객체를 생성
			m_clientDIS = new DataInputStream(m_clientInputStream);
			// 9. 클라이언트에서 보낸 메시지를 받아서 콘솔 화면에 출력하기
			// -> DataInputStream 클래스의 readUTF() 함수를 사용
			String inputMessage = m_clientDIS.readUTF();
			System.out.println("클라이언트로부터 받은 메시지는 " + inputMessage);
			// 10. 클라이언트로 메시지를 잘 받았다고 답신 메시지를 보내기
			// -> DataOutputStream 클래스의 writeUTF() 함수를 사용
			m_clientDOS.writeUTF("메시지를 잘 받았습니다.[서버가 보낸 메시지]");
			// 11. 주의할 점: DataOutputStream 클래스에 있는 flush() 함수를 호출해서 메시지가 클라이언트 컴퓨터로 전송됨
			m_clientDOS.flush();
			System.out.println("클라이언트로 메시지를 전송함[서버가 보낸 메시지]");
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end of MyClientThread() 생성자를 정의
	
	/*
	 * 모든 클라이언트 스레드 객체들이 함께 실행하는 run() 함수를 재정의
	 */
	@Override
	public void run() {
		try {
			/*
			 * 주의할 점: 클라이언트에서 프로그램을 강제로 종료하는 경우가 발생 가능
			 *     - 제대로 처리하지 않으면 예외상황이 발생
			 *     - if 조건문을 사용해서 클라이언트로부터 메시지를 받을 수 있는지 여불ㄹ 확인하기
			 *         - while 반복문을 사용해서 무한 반복문 구조 속에 작성
			 */
			while(true) {
				
				/*
				 * if 조건문을 사용해서 클라이언트로부터 메시지를 받을 수 있는지 여부를 확인
				 *     -> m_clientSocket == null
				 *     -> m_clientInputStream == null
				 *     -> m_clientDIS == null
				 */
				if(m_clientDIS == null || m_clientInputStream == null || 
				   m_clientSocket == null || m_clientSocket.isClosed() == true) {
					System.out.println("클라이언트 소켓이 종료됨");
					// 무한 반복문을 탈출(종료)
					break;
				} 
				// 클라이언트로부터 전달받은 메시지를 콘솔 화면에 출력하기
				String id = m_clientDIS.readUTF();
				String msg = m_clientDIS.readUTF();
				System.out.println("클라이언트(ID:" + id + ")로부터 전달받은 메시지는 " + msg + "[서버에서 작성]");
				// sleep() 함수를 호출해서 0.5초 동안 스레드 객체를 쉬게 하기
				Thread.sleep(500);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


