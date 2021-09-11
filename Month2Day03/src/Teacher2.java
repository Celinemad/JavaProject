// 1. Person 클래스를 부모 클래스로 하는 새로운 Teacher2 클래스를 정의
public class Teacher2 extends Person {
	public void showTeacher2Info() {
		System.out.println("새로 정의한 메소드");
		eat();
		sleep();
	}
}
