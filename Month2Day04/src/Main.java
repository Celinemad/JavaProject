/*
 * 1. 제목: 상속 관계에서 클래스 간에 형 변환(캐스팅)
 * 	1) 업캐스팅: 자식 클래스 타입 -> 부모 클래스 타입(자동 형 변환)
 * 	2) 다운캐스팅: 부모 클래스 타입 -> 자식 클래스 타입(개발자가 명시적으로 형 변환 연산자를 작성)
 * 		- 형식) 자식클래스명 참조변수명 = (자식클래스명) new 부모클래스명();
 */
public class Main {
	
	/*
	 * 1. print() 메소드를 정의: static 제한자(수정자)를 사용해서 모든 객체가 함께 사용할 수 있는 공유 명령어
	 */

	public static void print(Person a) {
		// 2. 매개 변수인 Person a로 전달되어진 객체를 구분하기 위해서는 instanceof 연산자를 사용
		if(a instanceof Person) {
			System.out.println("참조 변수 a로 가리킬 수 있는 클래스 타입은 Person");
		}
		if(a instanceof Student) {
			System.out.println("참조 변수 a로 가리킬 수 있는 클래스 타입은 Student");
		}
//		else {
//			System.out.println("참조 변수 a로 가리킬 수 있는 클래스 타입은 모름");
//		}
	}
	
	public static void main(String[] args) {
		// 1. Person 클래스: 부모 클래스
		// 2. Student 클래스: 자식 클래스
		
		// 3. 업캐스팅 연산을 수행
		Person a = new Student();
		a.showPersonInfo();
		
		Student b = new Student();
		b.showPersonInfo();
		b.showStudentInfo();
		
		Student c = new Student("서울대학교");
		c.showStudentInfo();
		
		// print() static 메소드를 호출: 참조변수인 a를 Person a에 전달하기
		print(a);
		
		print(b);
		
		// 4. 다운캐스팅 연산을 수행
//		Student b = (Student)new Person();
		// 오류가 발생하는 이유: 메소드 재정의 때문 -> 공통된 메소드의 명령어를 재작성
		
		
	}

}
