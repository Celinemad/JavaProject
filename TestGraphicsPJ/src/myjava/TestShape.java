package myjava;
/*
 * 1. 제목: 도형을 그리는 예제를 작성
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * 2. 화면에 윈도우를 출력해주는 클래스를 정의: JFrame 클래스를 상속 받음
 */
class MyWindow extends JFrame {
	
	/*
	 * 7. 아래에서 만든 MyCanvas 클래스를 사용하기 위한 객체를 생성
	 */
	private MyCanvas m_canvas = new MyCanvas();
	/*
	 * 8. 컨테이너 객체의 주소를 보관할 참조 변수 선언
	 */
	private Container m_container = null;
	/*
	 * 9. 생성자 정의
	 */
	public MyWindow(String title) {
		super(title);
		m_container = getContentPane();
		// 10. 윈도우의 가운데 영역에 사각형을 그리기
		m_container.add(m_canvas);
		// 11. 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 12. 윈도우의 크기를 설정
		setSize(500, 500);
		// 13. 윈도우를 화면에 출력
		setVisible(true);
	}
}

/*
 * 3. 캔버스 역할을 해주는 새로운 클래스를 정의: JPanel 컨테이너 클래스를 상속 받음
 */
class MyCanvas extends JPanel {
	/*
	 * 4. paintComponent() 메소드를 꼭 재정의
	 * -> 역할: 특정 컴포넌트 또는 컨테이너 역시 출력
	 */
	@Override
	public void paintComponent(Graphics g) {
		// 5. 꼭! 작성할 명령어는 현재 컨테이너를 화면에 출력해주는 명령어인 super.paintComponent()를 작성
		super.paintComponent(g);
		// 6. 화면에 출력할 사각형의 선 색상 또는 내부 색상을 설정하기
		// 1) 색상은 Color 클래스를 사용해서 새로운 색상 객체를 생성한 후에 사용
		Color color = new Color(255, 0, 0);
		// 2) drawRect() 메소드 또는 fillRect() 메소드를 사용
		g.setColor(color);
		g.drawRect(0, 0, 100, 100);
		g.fillRect(0, 0, 100, 100);
	}
}

public class TestShape {

	public static void main(String[] args) {
		MyWindow window = new MyWindow("test shape");
	}

}
