package myjava1;
/*
 * 1. 제목: Frame 클래스를 사용해서 윈도우 창을 만들고, Button 클래스를 사용해서 버튼을 만들어서
 * 		   버튼을 Frame 컨테이너의 기본 레이아웃 매니저인 BorderLayout의 가운데 위치에 넣기(출력)
 * 
 * 2. BorderLayout 레이아웃 매니저 클래스의 5가지 영역
 * 	1) 가운데: BorderLayout.CENTER 상수명으로 접근
 * 	2) 왼쪽: BorderLayout.WEST 상수명으로 접근
 * 	3) 오른쪽: BorderLayout.EAST 상수명으로 접근
 * 	4) 아래쪽: BorderLayout.SOUTH 상수명으로 접근
 * 	5) 위쪽: BorderLayout.NORTH 상수명으로 접근
 */
import java.awt.*;
import java.awt.event.WindowEvent;

/*
 * 버튼에서 발생할 액션 이벤트를 처리해주는 클래스를 생성
 */
class MyButtonListener implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("사용자가 버튼을 클릭함");
	}
}

class MyButtonListenerNorth implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("사용자가 north 버튼을 클릭함");
	}
}

class MyButtonListenerSouth implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("사용자가 south 버튼을 클릭함");
	}
}


class MyButtonListenerWest implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("사용자가 west 버튼을 클릭함");
	}
}

class MyButtonListenerEast implements java.awt.event.ActionListener{
	@Override
	public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
		System.out.println("사용자가 east 버튼을 클릭함");
	}
}


/*
 * 윈도우 창에서 발생할 윈도우 이벤트를 처리해주는 ㅡㄹ래스를 생성
 * 1. 이벤트 소스: Frame
 * 2. 이벤트 종류: Window
 * 3. 사용할 리스너 인터페이스: WindowListener
 * 4. 재정의할 추상 메소드(7개)
 */
class MyFrameListener implements java.awt.event.WindowListener{
	// Alt + Shift + s
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("사용자가 x버튼 누름");
		System.exit(0);  // 0은 정상종료, 1은 비정상종료
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class TestFrame {
	public static void main(String[] args) {
		// MyFrameListener 클래스를 사용해서 새로운 객체를 만들기
		MyFrameListener frameListener = new MyFrameListener();
		
		// MyButtonListener 클래스를 사용해서 새로운 객체를 만들기
		MyButtonListener buttonListener = new MyButtonListener();
		
		// 새로운 명령어들을 작성
		MyButtonListenerNorth buttonListenerNorth = new MyButtonListenerNorth();
		MyButtonListenerSouth buttonListenerSouth = new MyButtonListenerSouth();
		MyButtonListenerWest buttonListenerWest = new MyButtonListenerWest();
		MyButtonListenerEast buttonListenerEast = new MyButtonListenerEast();
		
		// 1. 윈도우 객체를 생성
		Frame frame = new Frame("window");
		// 2. 버튼 객체를 생성
		Button button = new Button("center");
		
		/*
		 * 나머지 4개 영역에 4개의 버튼을 만들어서 넣기
		 */
		// 1. 위쪽 영역에 보여질 버튼 객체 생성
		Button northButton = new Button("north");
		// 2. 아래쪽 영역에 보여질 버튼 객체 생성
		Button southButton = new Button("south");
		// 3. 왼쪽 영역에 보여질 버튼 객체 생성
		Button westButton = new Button("west");
		// 4. 오른쪽 영역에 보여질 버튼 객체 생성
		Button eastButton = new Button("east");
		
		
		// 버튼 객체와 actionPerformed() 메소드를 연결
		button.addActionListener(buttonListener);
		
		// 새로운 명령어들을 작성
		northButton.addActionListener(buttonListenerNorth);
		southButton.addActionListener(buttonListenerSouth);
		westButton.addActionListener(buttonListenerWest);
		eastButton.addActionListener(buttonListenerEast);
		
		// 윈도우 창과 windowClosing() 메소드를 연결(나머지 6개 메소드도 자동 연결)
		frame.addWindowListener(frameListener);
		
		// 3. 버튼 객체를 윈도우 안에 가운데 위치에 넣기
		frame.add(button);
		
		// 새로운 명령어들을 작성하기(setSize()메소드보다 위에 작성)
		frame.add(northButton, BorderLayout.NORTH);
		frame.add(southButton, BorderLayout.SOUTH);
		frame.add(westButton, BorderLayout.WEST);
		frame.add(eastButton, BorderLayout.EAST);
		
		// 4. 윈도우 창의 가로크기와 세로크기를 설정하기
		frame.setSize(300, 300);
		
		// 5. 윈도우 창을 화면에 나타나게 하기
		frame.setVisible(true);
		
	}

}
