// 5. main() 메소드만을 갖고 있는 Main 클래스의 정의
public class Main {
	public static void main(String[] args) {
		
		// 새로 정의한 Point 클래스를 바로 사용
		Point point = new Point();
		point.showPoint();
		
		Point point2 = new Point(10,20);
		point2.showPoint();
		
		// 상속 받은 ColorPoint 클래스를 사용
		ColorPoint colorPoint = new ColorPoint();
		colorPoint.showColorPoint();
		// 상속 받은 showPoint() 메소드만 개별적으로 호출 가능
		colorPoint.showPoint();
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		
		
		
		
		// 새로 정의한 Person 클래스를 바로 사용
		Person person = new Person();
		person.eat();
		person.sleep();
		
		// 상속 관계에 있는 Student2 클래스를 사용
		Student2 student2 = new Student2();
		student2.showStudentInfo();
		// 상속 받는 eat() 메소드를 단독으로 호출(사용) 가능
		student2.eat();
		// 상속 받는 sleep() 메소드를 개별적으로 사용
		student2.sleep();
		
		System.out.println("===================================");
		
		
		
		// 1) Student 클래스를 사용하기 위한 객체를 생성
		Student student = new Student();
		// 2) StudentWorker 클래스를 사용하기 위한 객체를 생성
		StudentWorker studentWorker = new StudentWorker();
		// 3) Teacher 클래스를 사용하기 위한 객체를 생성
		Teacher teacher = new Teacher();
		// 4) Professor 클래스를 사용하기 위한 객체를 생성
		Professor professor = new Professor();
		
		// 5) Student 클래스에서 정의한 eat() 메소드를 호출
		student.eat();
		// 6) Student 클래스에서 정의한 sleep() 메소드를 호출
		student.sleep();
		
		studentWorker.eat();
		studentWorker.sleep();
		
		teacher.eat();
		teacher.sleep();
		
		professor.eat();
		professor.sleep();
		
	}
}
