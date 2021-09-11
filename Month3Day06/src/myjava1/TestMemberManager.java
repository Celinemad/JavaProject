package myjava1;
/*
 * 1. 제목: 회원 관리 프로그램을 구현
 * 
 * 1) 먼저 Frame 클래스의 기본 레이아웃 관리자인 BorderLayout의 윗쪽(북쪽)에 프로그램 제목을 출력
 * 	가. Label에 출력할 텍스트의 크기를 수정하는 방법
 * 		- java.awt 패키지의 Font 클래스를 사용
 * 			- 형식) import java.awt.*;
 * 				   import java.awt.event.*;
 * 
 * Font 클래스를 사용해서 객체를 생성: 
 * 	Font 변수명 = new Font("글꼴(글자모양)", 글자스타일(볼드 또는 이탤릭) 정수 상수면, 글자크기를 픽셀 단위로 지정(정수));
 * 	예) Font myFont = new Font("궁서체", Font.BOLD, 30); 
 * 
 * 2) Frame 컨테이너 클래스를 사용하는 형식
 * 	가. Frame 변수명 = new Frame("윈도우제목문자열");
 * 	   또는
 * 	   Frame 클래스를 상속 받아서 새로운 자식 클래스를 만든 다음에 코드를 작성
 *	-> 형식) class 새로운클래스명 extends Frame implements WindowListener, ActionListener {
 *			
 *		    }
 *	-> WindowListener 인터페이스의 용도: 사용자가 윈도우 종료 버튼을 눌렀을 때 실행할 명령어를 작성
 *	-> ActionListener 인터페이스의 용도: 사용자가 버튼 또는 TextField에서 액션 이벤트를 발생시킬 때 사용
 *		- 버튼에서의 액션 이벤트: 마우스 왼쪽 버튼을호 클릭
 *		- TestField에서의 액션 이벤트: 엔터키를 누름
 *
 * 3) 프레임 윈도우 창의 가운데 위치에 아래와 같은 컴포넌트들을 만들어서 출력하기
 * 	0. 격자 모양을 갖고 있는 GridLayout 클래스를 사용해서 새로운 객체를 생성
 * 		-> 형식) private GridLayout 변수명 = new GridLayout(행, 열);
 * 	가. 컨테이너인 판넬 클래스를 사용해서 새로운 객체를 생성
 * 		-> 형식) private Panel 변수명2 = new Panel(변수명);
 * 	나. "아이디:" 텍스트를 화면에 보여줄 때 사용할 Label 객체를 생성
 * 		-> 형식) private Label 변수명3 = new Label("아이디:", Label.RIGHT);
 * 	다. 사용자가 아이디를 실제로 입력할 수 있는 입력 창을 만들기
 * 		-> 한줄 입력 -> TextField 클래스를 사용하기
 * 		-> 형식) private TextField 변수명4 = new TextField("", 화면에보여줄글자수);
 * 	라. "비밀번호:" 텍스트를 화면에 보여줄 때 사용할 Label 객체를 생성
 * 		-> 형식) private Label 변수명5 = new Label("비밀번호:", Label.RIGHT);
 * 	마. 실제 비밀번호를 입력할 수 있는 입력창 만들기
 * 		-> 형식) private TextField 변수명6 = new TextField("");
 *  바. 위에서 만든 4개의 컴포넌트들을 판넬에 넣기
 *  	-> 형식) 판넬객체참조변수명(변수명2).add(컴포넌트객체참조변수명);
 *  사. 판넬 객체를 프레임 컴테이너의 가운데 위치에 넣기
 *  	-> 형식) add(판넬객체참조변수명, BorderLayout.CENTER); 
 *  
 * 4) 3개의 버튼들을 BorderLayout 배치 관리자의 제일 아래 영역(BorderLayout.SOUTH)에 출력
 * 	가. FlowLayout 변수명 = new FlowLayout();
 * 	나. Button 변수명2 = new Button("로그인");
 * 	다. Button 변수명3 = new Button("회원가입");
 * 	라. Button 변수명4 = new Button("종료");
 * 	마. FlowLayout 객체를 사용할 컨테이너를 생성
 * 		-> Panel 변수명5 = new Panel(변수명);
 * 	바. 판넬 객체에 3개의 버튼들을 넣기
 * 		-> 변수명5.add(변수명2);
 * 		-> 변수명5.add(변수명3);
 * 		-> 변수명5.add(변수명4);
 * 	사. 판넬 객체를 프레임 윈도우의 제일 아래 위치에 넣기:
 * 		-> add(변수명5, BorderLayout.SOUTH);
 */
import java.awt.*;
import java.awt.event.*;
// 파일 관련 클래스와 인터페이스를 사용(로그인과 회원가입 시에 사용)
import java.io.*;
// 메시지 창을 띄울 때 사용할 클래스(JOptionPane)
import javax.swing.*;

/*
 * WindowAdapter: 추상 클래스
 * 	-> 필요한 메소드만 재정의하면 됨.
 */
class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

// MyFrame 클래스를 정의
class MyFrame extends Frame implements ActionListener {
	
	// 위에서 정의한 MyWindowAdapter 클래스를 사용하기 위한 객체를 생성
	private MyWindowAdapter m_wa = new MyWindowAdapter();
	// 	-> m_wa 참조 변수를 MyFrame 클래스에 연결
	// 		-> Frame 클래스가 갖고 있는 addWindowListener(m_wa);
	// 			-> 생성자 메소드 내부로 이동한 후에 추가
	
	// 추상 메소드들을 재정의
	
	// Font 클래스를 사용해서 새로운 객체를 생성: 용도는 Label에 출력할 텍스트의 글자 크기를 조정(변경)
	private Font m_font = new Font("궁서체", Font.BOLD, 30);
	
	// Label 클래스를 사용해서 프로그램의 제목을 출력할 객체를 생성
	private Label m_titleLabel = new Label("*** 회원 관리 예제(버전 1.0) ***", Label.CENTER);
	// 프로그램 실행 후에 결과를 확인하고 Label.CENTER 값을 Label.LEFT 또는 Label.RIGHT로 수정한 후 다시 실행
	
	// 2행 2열 구조를 갖는 GridLayout 객체를 생성
	private GridLayout m_gridLayout = new GridLayout(2,2);
	
	// 판넬 객체를 생성
	private Panel m_panel  = new Panel(m_gridLayout);
	
	// "아이디:" 텍스트를 출력할 라벨 객체를 생성
	private Label m_idLabel = new Label("아이디:", Label.RIGHT);
	
	// 아이디 입력 창 만들기
	private TextField m_idTextField = new TextField("");
	
	// "비밀번호:" 텍스트를 출력할 라벨 객체를 생성
	private Label m_pwdLabel = new Label("비밀번호:", Label.RIGHT);
	
	// 비밀번호 입력 창 만들기
	private TextField m_pwdTextField = new TextField("");
	
	// 총 3개의 버튼들을 만들어서 아래 방향에 출력
	private FlowLayout m_flowLayout = new FlowLayout();
	private Panel m_panel2 			= new Panel(m_flowLayout);
	private Button m_loginButton 	= new Button("로그인");
	private Button m_registerButton	= new Button("회원가입");
	private Button m_exitButton 	= new Button("종료");
	
	/*
	 * 새로운 static 함수를 정의
	 * 1) 기능은 사용자가 입력한 아이디 또는 비밀번호의 입력 유무를 판단
	 */
	public static int checkStringValue(String value, int sortValue) {
		if(sortValue == 1) {
			if(value.isEmpty()) return 1;
			else return 3;
		}
		if(sortValue == 2) {
			if(value.isEmpty()) return 2;
			else return 4;
		}
		
		return 5;
	}
	
	
	
	// 다른 클래스로부터 윈도우 제목 문자열을 받는 생성자를 정의
	public MyFrame(String title) {
		// super() 명령어: 부모 클래스인 Frame에 정의되어 있는 생성자를 호출 -> public Frame(String) 생성자를 호출
		// -> 이유: 윈도우 제목 문자열의 관리를 부모 클래스에 위탁하기 위함
		super(title);
		
		// 폰트 객체를 라벨 객체에 적용하기: setFont() 메소드를 호출
		m_titleLabel.setFont(m_font);
		
		m_idLabel.setFont(m_font);
		m_pwdLabel.setFont(m_font);
		
		m_idTextField.setFont(m_font);
		m_pwdTextField.setFont(m_font);
		
		// 3개의 버튼에 폰트 객체를 사용하기
		m_loginButton.setFont(m_font);
		m_registerButton.setFont(m_font);
		m_exitButton.setFont(m_font);
		
		// 사용자가 비밀번호 입력 창에서 입력한 문자 또는 숫자를 지워주는 문자를 설정
		// (디스플레이만 도형으로, 메모리에는 실제 입력한 값이 저장)
		m_pwdTextField.setEchoChar('●');
		
		// 버튼마다 새롭게 구분해 주는 문자열 값을 지정(버튼에서 클릭 이벤트가 발생했을 때 사용)
		m_loginButton.setActionCommand("1");
		m_registerButton.setActionCommand("2");
		m_exitButton.setActionCommand("3");
		
		// add() 메소드를 호출하기 전에 모든 set으로 시작하는 메소드를 호출
		
		
		// 판넬 객체에 3개의 버튼들을 넣기
		m_panel2.add(m_loginButton);
		m_panel2.add(m_registerButton);
		m_panel2.add(m_exitButton);
		
		// 판넬 객체에 총 4개의 컴포넌트들을 추가하기 
		m_panel.add(m_idLabel);
		m_panel.add(m_idTextField);
		
		m_panel.add(m_pwdLabel);
		m_panel.add(m_pwdTextField);
		
		
		/*
		 * 현재 화면의 해상도 크기를 읽어와서 출력하기
		 */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		System.out.println("현재 화면의 해상도 크기를 출력");
		System.out.println("가로 크기는 " + width + ", 세로 크기는 " + height);
		
		
		// 두 번째 판넬 객체를 프레임 윈도우의 아래 영역에 넣기
		add(m_panel2, BorderLayout.SOUTH);
		
		// 판넬을 프레임 윈도우에 넣기
		add(m_panel, BorderLayout.CENTER);
		
		// 위쪽(북쪽)에 라벨 객체를 출력: BorderLayout.NORTH
		add(m_titleLabel, BorderLayout.NORTH);
		
		
		// 윈도우의 종료 이벤트의 처리를 위한 준비
		addWindowListener(m_wa);
		// this -> 구현한 WindowListener 인터페이스
		
		// 버튼의 클릭 이벤트의 처리를 위한 준비
		m_loginButton.addActionListener(this);
		// this -> 구현한 ActionListener 인터페이스
		
		m_registerButton.addActionListener(this);
		m_exitButton.addActionListener(this);
		
		// 윈도우의 크기를 설정하기
		setSize(500, 500);
		
		pack();
		
		/*
		 * setLocation() 메소드를 실행해서 윈도우를 가운데 위치로 이동
		 */
		int x = width/2 - getWidth()/2;
		int y = height/2 - getHeight()/2;
		setLocation(x,y);
		
		// setResizable() 메소드를 실행하기
		setResizable(false);
		
		// 윈도우를 화면에 출력하기
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button clickedButton = (Button)e.getSource();
		
		// 생성자에서 버튼마다 새롭게 지정한 문자열 값을 가져와서 화면에 출력
		String str = clickedButton.getActionCommand();
		System.out.println("버튼 구분 문자열 값은 " + str);
		
		if(clickedButton == m_loginButton) {
			System.out.println("사용자가 로그인 버튼을 클릭함");
			
			// 사용자가 입력한 아이디 값을 가져와서 임시 변수에 대입
			String tempID = m_idTextField.getText();
			
			// 방금 전에 새로 작성한 함수를 실행해서 반환값을 가져오기
			int retValue = checkStringValue(tempID, 1);
			// 값이 입력되지 않았으면 메세지 창을 출력하기
			if(retValue == 1) {
				JOptionPane.showMessageDialog(null, "아이디를 꼭 입력하세요!");
				return;
			}
			else {
				System.out.println("사용자가 입력한 아이디는 " + tempID);
			}
			
			// 사용자가 비밀번호를 입력 유무를 새로 정의한 함수를 통해서 검사하기
			String tempPwd = m_pwdTextField.getText();
			retValue = checkStringValue(tempPwd, 2);
			if(retValue == 2) {
				JOptionPane.showMessageDialog(null, "비밀번호를 꼭 입력하세요!");
				return;
			}
			else {
				System.out.println("사용자가 입력한 비밀번호는 " + tempPwd);
			}
			
			// 사용자가 입력한 아이디로 파일이 있는지를 검사하기
			File file = new File(tempID + ".txt");
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				// File 클래스의 exists() 메소드를 실행하기
				boolean tempExists = file.exists();
				if(tempExists == true) {
					System.out.println("회원으로 가입된 상태");
					// 파일에서 비밀번호를 가져오기
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					// while 반복문을 사용해서 파일에서 비밀번호를 읽어와서 임시변수인 tempCmpPwd에 저장
					String tempCmpPwd = "";
					
					// 비밀번호 일치 여부 판별 위한 변수 선언 + 초기값 지정
					boolean flag = false;
					
					while((tempCmpPwd = br.readLine()) != null) {
						if(tempCmpPwd.equals(tempPwd)) {
							flag = true;
							break;
						} 	
					}
					
					if(flag == true) {
						JOptionPane.showMessageDialog(null, "로그인 성공!");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호 불일치!");
					}
					
					
					/*
					 * 구현할 기능: 비밀번호가 일치하지 않은 경우 
					 * 	-> 화면에 비밀번호 불일치 오류 메시지를 출력하기
					 * 		-> JOptionPane.showMessageDialog(null, "로그인 성공!");
					 */
				} else {
					JOptionPane.showMessageDialog(null, "아직 회원이 아님");
					return;
				}
				
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			} catch(IOException e2) {
				e2.printStackTrace();
			} catch(Exception e3) {
				e3.printStackTrace();
			} finally {
				try {
					if(fr != null) fr.close();
					if(br != null) br.close();
				} catch (IOException e4) {
					e4.printStackTrace();
				}
			}
			
		} else if(clickedButton == m_registerButton) {
			System.out.println("사용자가 회원가입 버튼을 클릭함");
			
			String idv = m_idTextField.getText();
			File file = new File(idv + ".txt");
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				if(file.exists() == true) {
					JOptionPane.showMessageDialog(null, "이미 회원으로 가입되어 있음");
					return;
				} else {
					System.out.println(idv + ".txt 이름을 갖는 파일을 만듭니다.");
					boolean chk = file.createNewFile();
					if(chk == true) {
						System.out.println("파일이 정상적으로 생성됨");
						// 새로 만든 파일에 사용자가 입력한 비밀번호를 저장하기
						String pwdv = m_pwdTextField.getText();
						fw = new FileWriter(file);
						bw = new BufferedWriter(fw);
						bw.write(pwdv);
						JOptionPane.showMessageDialog(null, "회원가입 완료");
					} else {
						System.out.println("파일 생성 실패");
						return;
					}
				}
			} catch(IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(bw != null)
						bw.close();
				} catch(IOException e2) {
					e2.printStackTrace();
				}
			}
			
		} else if(clickedButton == m_exitButton) {
			System.out.println("사용자가 종료버튼을 클릭함");
			System.exit(0);
		}
	}
	
}
public class TestMemberManager {

	public static void main(String[] args) {
		// MyFrame 클래스를 사용하기 위한 객체를 생성
		MyFrame frame = new MyFrame("member manager");
		
		
	}

}
