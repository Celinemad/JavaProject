// 1. 2차원 평면에서 객체의 위치를 표현할 때 사용하는 클래스
// 2. 위치 표현: x와 y좌표가 필요(정수)
public class Point {
	int m_x;
	int m_y;
	// 기본 생성자를 정의해서 멤버 변수 m_x와 m_y에 0을 대입
	public Point() {
		System.out.println("Point 클래스의 기본 생성자");
		m_x = m_y = 0;
	}
	// 다른 클래스로부터 x와 y 좌표 모두를 입력 받는 생성자
	public Point(int x, int y) {
		System.out.println("Point 클래스의 입력 매개변수를 갖는 생성자");
		m_x = x;
		m_y = y;
	}
	// x와 y 좌표를 출력하는 메소드
	public void showPoint() {
		System.out.println("x좌표 값은 "+m_x+", y좌표 값은 "+m_y);
	}
}

