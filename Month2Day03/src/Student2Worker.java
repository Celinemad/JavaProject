// 2. Person 클래스를 상속받는 Student2Worker 클래스를 정의
public class Student2Worker extends Person {
	// 3. 새로운 메소드를 추가해서 상속 받은 eat(), sleep() 메소드를 호출
	public void showStudent2WorkerInfo() {
		System.out.println("새로 정의한 메소드");
		eat();
		sleep();
	}
}
