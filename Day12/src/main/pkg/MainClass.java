package main.pkg;

/*
 * 다른 패키지에 있는 클래스를 사용하기 위해서는 import 명령어를 사용하거나 클래스명을 사용할 때마다 패키지명.클래스명
 * 1) import 패키지명.클래스명;
 * 2) 패키지명.클래스명 객체명;
 */
// myjava1 패키지에 있는 Class1 클래스명을 사용하기
import myjava1.Class1;
import myjava2.Class2;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 객체를 생성하기 위한 명령어의 형식
		 * 	1) 참조 변수를 선언: 객체에 접근할 때 사용할 변수
		 * 		- 형식: 클래스명 변수명;
		 */
		Class1 a;
		/*
		 * 2) new 연산자를 사용해서 메모리에 Class1 클래스 내부에 있는 변수들을 생성
		 * 		- 형식: 참조변수명 = new 클래스명();
		 */
		a = new Class1();
		/*
		 * 3) 메모리에 생성된 멤버 변수들인 id와 pwd에  접근하기(사용하기
		 * 		-형식: 참조변수명 + 점 + 멤버변수명
		 */
		System.out.println(a.id);
		
		/*
		 * 새로운 객체를 생성하기 형식
		 * 1+2번을 하나로 합친 형식) 클래스명 참조변수명 = new 클래스명();
		 */
		Class1 b = new Class1();
		// 새로 생성한 객체가 갖고 있는 멤버 변수인 id에 접근(사용)
		System.out.println(b.id);
		
		a.fnc1();
		
		a.fnc2("celineinny");
		
		/*
		 * import 명령어 없이 다른 패키지에 있는 클래스를 사용하기
		 */
		myjava2.Class2 c = new myjava2.Class2();
		// 새로운 참조 변수 d를 선언하고 새로운 객체를 생성하기
		myjava2.Class2 d = new myjava2.Class2();
		
		//Class2에서 새로 만든 생성자인 public Class2(String a)를 호출하기 위한 형식: new 클래스명("문자열");
		myjava2.Class2 e = new myjava2.Class2("홍길동");
		myjava2.Class2 f = new myjava2.Class2("김길동");
		myjava2.Class2 g = new myjava2.Class2("세종대왕");
		
		
		myjava.shape.Circle circle = new myjava.shape.Circle(7);
	}

}
