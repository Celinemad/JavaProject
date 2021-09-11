package myjava1;
/*
 * 1. 프로그램 제목: FileDialog 클래스를 사용한 파일 열기와 파일 저장 예제
 * 	-> AWT GUI 라이브러리를 사용하기
 * 		-> import java.awt.*;
 * 		-> import java.awt.event.*;
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
//파일 관련된 클래스와 인터페이스를 사용
import java.io.*;

// 2. Frame 클래스를 상속 받는 MyFrame 클래스를 정의
class MyFrame extends Frame implements ActionListener {
	
	// 4. 프레임 윈도우에 출력에 사용할 객체들을 생성하기
	// 1) TextArea 클래스를 사용한 객체를 생성: 용도는 사용자가 파일에 저장할 여러 줄의 텍스트를 입력하거나
	// 	  파일의 내용을 화면에 출력
	private TextArea m_ta = new TextArea();
	
	// 2) ScrollPane 클래스를 사용한 객체를 생성: 용도는 TextArea에 오른쪽과 아랫쪽에 스크롤바를 출력
	private ScrollPane m_sp = new ScrollPane();
	
	// 3) 파일 열기 버튼에 사용할 Button 객체를 생성 (file open)
	private Button m_fo = new Button("파일 열기");
	
	// 4) 파일 저장 버튼에 사용할 Button 객체를 생성
	private Button m_fs = new Button("파일 저장");
	
	// 5) 레이아웃 관리자 역할을 수행할 GridLayout 클래스를 사용한 객체를 생성: 행의 갯수는 3, 열의 갯수는 1
	private GridLayout m_gl = new GridLayout(3,1);
	
	// awt는 컨테이너 필요 없이 그냥 add하면 됨.
	// 6) 생성자를 정의
	public MyFrame(String title) {
		// 7) 윈도우의 제목 문자열 설정
		super(title);
		// 8) 프레임 윈도우의 기본 레이아웃 관리자를 GridLayout으로 변경하기
		setLayout(m_gl);
		// 9) ScrollPane에 TextArea을 넣기
		m_sp.add(m_ta);
		// 10) ScrollPane 객체를 첫 번재 행에 넣기
		add(m_sp);
		
		// 버튼과 actionPerformed() 메소드를 연결하기
		m_fo.addActionListener(this);
		m_fs.addActionListener(this);
		
		// 11) 파일 열기 버튼 객체를 두 번째 행에 넣기
		add(m_fo);
		// 12) 파일 저장 버튼 객체를 세 번째 행에 넣기
		add(m_fs);
		// 13) 윈도우 종료 이벤트 처리 방법
		/*
		 * 1. WindowListener 인터페이스를 사용: 7개의 추상 메소드를 재정의해야 함
		 * 2. WindowAdpater 클래스를 사용: 필요한 메소드만 재정의하면 됨
		 * 	1) 외부에 새로운 클래스를 정의
		 * 		- 형식) class 클래스명 extends WindowAdapter {
		 * 			       // 사용자가 X 버튼을 눌렀을 때 실행할 windowClosing() 메소드를 재정의
		 * 			   }
		 *  		   클래스를 사용하기 위한 객체를 생성: private 클래스명 변수명 = new  클래스명();
		 *  		   addWindowListener(변수명);
		 *  
		 * 	2) 익명 객체를 생성(이름이 없는 클래스를 정의)
		 * 		- 형식) addWindowListener (
		 * 			       new WindowAdapter() {
		 * 				       @Override
		 * 				       public void windowClosing(WindowEvent 이벤트처리변수명) {
		 * 				       System.exit(0);
		 * 				       }
		 * 				   }
		 *             );
		 * 		- 특징: 윈도우에 바로 이벤트 처리 핸들러를 붙이는 방법(핸들러를 한번만 사용하는 방법)
		 */
		// 익명 객체(이름이 없는 객체)를 생성
		addWindowListener(new WindowAdapter() {
			// windowClosing() 메소드를 재정의
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("사용자가 윈도우의 X 버튼을 클릭함");
				System.out.println("프로그램을 종료함");
				System.exit(0);
			}
		});
		// setSize() 메소드를 사용해서 윈도우의 가로크기와 세로크기를 정하기
		setSize(500,500);
		// setResizable() 메소드를 사용해서 사용자가 윈도우의 크기를 바꾸지 못하도록 하기
		setResizable(false);
		// setVisible() 메소드를 사용해서 윈도우를 화면에 출력하기
		setVisible(true);
	}
	
	// 3. actionPerformed() 메소드를 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		// 사용자가 파일 저장 버튼을 클릭했을 때 수행할 명령어들을 작성하기
		Button clickedButton = (Button)e.getSource();
		
		if(clickedButton == m_fs) {
			System.out.println("사용자가 파일 저장 버튼을 클릭함");
			String tempString = m_ta.getText();
			if(tempString.isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "파일에 저장할 내용을 꼭! 입력하세요!");
				m_ta.setFocusable(true);
				m_ta.requestFocus();
				return;
			} else {
				FileDialog fd = new FileDialog(this, "파일 저장 창", FileDialog.SAVE);
				fd.setVisible(true);
				/*
				 * 사용자가 파일 저장 창에서 파일 이름을 입력하고 저장 버튼을 클릭한 경우의 이벤트 처리 방법
				 * 	1) 파일 이름은 확장자가 .txt인 파일: 예) myfile01.txt
				 * 	2) 프로그램에서 사용자가 입력한 파일에 접근하기
				 * 		-> 사용자가 저장 버튼을 누르지 않고 취소 버튼을 누를 경우의 이벤트 처리를 먼저 작성해야 함
				 * 			-> 필터 기능(필요 없는 기능들을 먼저 거르는 작업)을 다른 기능보다 먼저 작성해야 함
				 * 		-> FileDialog 클래스의 getFile() 메소드를 사용
				 * 			-> 형식) String 변수명 = fd.getFile();
				 * 			-> if(변수명 == null) {
				 * 			       // 사용자가 취소 버튼을 누른 경우에 수행할 명령어들을 작성
				 * 				   JOptionPane.showMessageDialog(null, "취소 버튼을 누름");
				 * 				   return;
				 * 			   } else {
				 * 				   // 사용자가 저장 버튼을 누른 경우에는 사용자가 입력한 파일의 이름과 파일이
				 * 				   // 저장될 폴더의 전체 경로를 읽어와야 합니다.
				 * 				   // 1) 파일의 폴더의 전체 경로: FileDialog 클래스의 getDirectory() 메소드를 사용
				 * 				   // -> 형식) String 변수명 = fd.getDirectory();
				 * 				   // 2) 사용자가 입력한 파일의 이름: FileDialog 클래스의 getFile() 메소드를 사용
				 * 				   // -> 형식) String 변수명 = fd.getFile();
				 * 				   // 3) File 클래스의 exists() 메소드를 사용해서 사용자가 입력한 파일이 있는지를 검사하기
				 * 				   // -> 형식) File 변수명3 = new File(변수명1+변수명2);
				 * 				   // 4) exists() 메소드를 실행하기
				 * 				   // -> 형식) boolean 변수명4 = 변수명3.exists();
				 * 				   // if(변수명4 == true) { // 파일이 있는 경우 }
				 * 				   // else { // 파일이 없는 경우 }		
				 * 			   }
				 */
				String selectedFile = fd.getFile();
				if(selectedFile == null) {
					JOptionPane.showMessageDialog(null, "사용자가 취소 버튼을 누름");
					return;
				} else {
					System.out.println("사용자가 저장 버튼을 누름");
					if(selectedFile.isEmpty()) {
						JOptionPane.showMessageDialog(null, "파일 이름을 입력하지 않음");
						return;
					} else {
						System.out.println("사용자가 입력한 파일 이름은 " + selectedFile);
						System.out.println("파일의 저장(폴더) 경로는 " + fd.getDirectory());
						
						// 사용자가 입력한 파일이 있는지를 검사하기
						File tempFile = new File(fd.getDirectory() + selectedFile);
						// exists() 메소드를 실행하기
						boolean chkFile = tempFile.exists();
						if(chkFile == true) {
							JOptionPane.showMessageDialog(null, "파일이 존재");
							return;
						} else {
							System.out.println(selectedFile + " 파일을 생성하기");
							// 파일 생성에 사용할 객체들을 선언
							FileWriter tempfw = null;
							BufferedWriter tempbw = null;
							// 예외상황을 준비하기 위한 try~catch~finally 블럭을 작성
							try {
								tempfw = new FileWriter(tempFile);
								tempbw = new BufferedWriter(tempfw);
								// 사용자가 입력한 텍스트들을 파일에 저장하기: BufferedWriter 클래스의
								// write() 메소드를 실행
								tempbw.write(tempString);
								System.out.println(selectedFile + " 파일을 생성하고 텍스트 저장 완료");
							} catch(IOException e1) {
								JOptionPane.showMessageDialog(null, "파일 저장 오류");
							} catch(Exception e2) {
								JOptionPane.showMessageDialog(null, "일반 오류");
							} finally {
								try {
									// 네트워크 오류로 BufferedReader만 닫기
//									if(tempfw != null) tempfw.close(); 
									if(tempbw != null) tempbw.close();
									System.out.println("파일 닫기 완료");
								} catch(IOException e3) {
									JOptionPane.showMessageDialog(null, "파일 닫기 오류");
									e3.printStackTrace();
								} // end of catch(IOException e3) {
							} // end of finally {
						} // end of if(chkFile == true) {
					} // end of if(selectedFile.isEmpty()) {
				} // end of if(selectedFile == null) {
			}
		}
			else if(clickedButton == m_fo) {
				/*
				 * 사용자가 파일 열기 버튼을 클릭한 경우의 처리할 명령어들을 작성하기
				 */
				FileDialog tempdf = new FileDialog(this, "파일 열기 창", FileDialog.LOAD);
				tempdf.setVisible(true);
				
				String tempfile = tempdf.getFile();
				if(tempfile == null || tempfile.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "파일 열기 실패");
					return;
				} else {
					System.out.println("사용자가 선택한 파일 이름은 " + tempfile);
					String tempdir = tempdf.getDirectory();
					if(tempdir == null || tempdir.isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "파일 경로 오류");
						return;
					} else {
						System.out.println("사용자가 선택한 파일의 전체 경로는 " + tempdir);
						FileReader tempfr = null;
						BufferedReader tempbr = null;
						try {
							tempfr = new FileReader(tempdir + tempfile);
							tempbr = new BufferedReader(tempfr);
							String inputLine = "";
							m_ta.setText("");
							while((inputLine = tempbr.readLine()) != null) {
								m_ta.append(inputLine + "\n");
							}
							System.out.println("파일의 내용을 읽어와서 TextArea에 추가 완료");
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(null, "파일이 없음");
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "파일 입력 오류");
						} catch (Exception e3) {
							JOptionPane.showMessageDialog(null, "일반 오류");
						} finally {
							try {
								if(tempbr != null) tempbr.close();
							} catch(IOException e4) {
								JOptionPane.showMessageDialog(null, "파일 닫기 오류");
							}
						}
					}
				}
			}
	}
}


public class TestFileDialog {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("test filedialog");
		
	}

}
