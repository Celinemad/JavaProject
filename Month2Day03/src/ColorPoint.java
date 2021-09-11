// 2. Point 클래스를 부모 클래스로 하는 ColorPoint 클래스를 정의
// 3. Point 클래스에서 선언한 int m_x; int m_y; 멤버변수 선언 명령어가 자동으로 복사(삽입)
public class ColorPoint extends Point {
	public void showColorPoint() {
		System.out.println("showColorPoint() 메소드가 호출됨");
		System.out.println("상속 받은 m_x의 값은 "+m_x);
		System.out.println("상속 받은 m_y의 값은 "+m_y);
		System.out.println("상속 받은 showPoint() 메소드를 호출");
		showPoint();
	}
}
