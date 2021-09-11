package myjava2;
/*
 * 1. 제목: 제네릭 타입 매개 변수를 사용해서 사용할 클래스명 또는 인터페이스명을 제한하기
 */
class MyParent {
	
}

class MyChild2 extends MyParent {
	
}

class MyChild3 extends MyParent {
	
}

class MyChild<T extends MyParent>{
	
}

public class TestGeneric2 {

	public static void main(String[] args) {
		MyChild<MyParent> a = new MyChild<MyParent>();
		MyChild<MyChild2> b = new MyChild<MyChild2>();
		// MyParent 클래스와 상속 관계가 없는 MyChild3 클래스를 사용
		MyChild<MyChild3> c = new MyChild<MyChild3>();
//		MyChild<MyChild> d = new MyChild<MyChild>();
		
		
	}

}
