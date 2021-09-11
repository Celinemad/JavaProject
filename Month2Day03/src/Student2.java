// 1. 새로운 클래스인 Student2를 선언(정의)
// 2. 기존에 만들어져 있던 Person 클래스를 부모 클래스로 지정
// 3. 부모 클래스에서 선언한 멤버 변수와 메소드 관련 명령어가 자동으로 삽입
// 	-> 제외되는 멤버변수와 메소드: private 접근 제한자
//	-> 생성자 메소드
public class Student2 extends Person {
	// 4. 새로운 메소드인 showStudentInfo()를 정의
	//	1) Person 클래스로부터 상속받은 eat(), sleep() 메소드를 바로 사용하기
	public void showStudentInfo() {
		System.out.println("Student2 클래스에서 새로 추가한 메소드");
		System.out.println("Person 클래스로부터 상속 받은 eat(), sleep() 메소드를 바로 사용");
		eat();
		sleep();
	}
}
