/*
 * 1. 제목: this 예약어를 사용 -> 서로 다른 클래스에서 객체를 입력으로 받기
 */
class This3 {
	//method1() 메소드를 정의: 입력으로는 This2 클래스의 시작 주소를 받기
	public void method1(This2 refa) {
		System.out.println("다른 클래스의 시작 주소를 받기");
		refa.show();
		refa.a = 100;
		refa.show();
	}
}
class This2 {
	int a;
	public This2() {
		a  = 10;
	}
	public This2(int a) {
		this.a = a;
	}
	public void show() {
		System.out.println("멤버변수인 a의 값은 "+a);
	}
}
public class TestThis2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. This3 클래스를 사용해서 새로운 객체를 만들기
		This3 a = new This3();
		// 2. This2 클래스를 사용해서 새로운 객체를 만들기
		This2 b = new This2();
		// 3. This2 클래스에서 정의한 show() 메소드를 호출
		b.show();
		// 4. This3 클래스에서 정의한 method1() 메소드를 호출 + This2클래스의 시작 주소를 전달
		a.method1(b);
	}

}
