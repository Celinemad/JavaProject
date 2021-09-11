// 1. 사람 클래스를 정의
// 	-> 다양한 종류의 여러 사람 객체들의 공통점을 하나로 갖고 있는 클래스
// 		1) 모든 사람 객체들의 행위인 음식을 먹다를 정의한 메소드를 정의
//		2) 모든 사람 객체들의 행위인 잠을 자다를 정의한 메소드를 정의
public class Person {
	public void eat() {
		System.out.println("사람이 음식을 먹고 있습니다.");
	}
	public void sleep() {
		System.out.println("사람이 잠을 잡니다.");
	}
}
