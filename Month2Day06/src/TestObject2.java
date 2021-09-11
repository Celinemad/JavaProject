/*
 * 1. 제목: java.lang.Object 클래스가 갖고 있는 toString() 메서드를 사용하기 + 재정의도 가능
 */
//2. 2차원 평면에서 어떤 객체의 점(point) 정보를 관리하는 Point 클래스를 정의
class Point {
	private int m_x;
	private int m_y;
	public Point() {
		m_x = m_y = 0;
	}
	public Point(int x, int y) {
		m_x = x;
		m_y = y;
	}
	public void show() {
		System.out.println("x좌표 값은 "+m_x+ ", y좌표 값은 "+m_y);
	}
	public int getX() {
		return m_x;
	}
	public int getY() {
		return m_y;
	}
	public void setX(int x) {
		m_x = x;
	}
	public void setY(int y) {
		m_y = y;
	}
	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}
	
	// 이 곳은 Point 클래스 내부 영역
	/*
	 * Object 클래스가 갖고 있는 toString() 메서드의 명령어를 수정하기
	 * 	-> 형식: 멤버 변수가 갖고 있는 모든 값들을 하나로 연결해서 문자열로 반환
	 * 		-> String 변수명 = 멤버변수명 + "," + 멤버변수명2 + ... + "," + 멤버변수명n;
	 * 		-> return 변수명; 
	 */
	@Override // 재정의 
	public String toString() {
		String result = getX() + "," + getY();
		return result;
	}
}
public class TestObject2 {

	public static void main(String[] args) {
		
		Point a = new Point();
		a.show();
		a.setX(a.getX()+10);
		a.show();
		a.setY(a.getY()-5);
		a.show();
		int value = a.getY();
		System.out.println("멤버변수 m_y의 값은 "+ value);
		
		Point b = new Point(10,20);
		b.show();
		
		// toString() 메소드를 호출
		String value2 = a.toString();
		System.out.println("참조 변수 a로 접근할 수 있는 toString() 메소드의 반환값은 "+value2);
	}

}
