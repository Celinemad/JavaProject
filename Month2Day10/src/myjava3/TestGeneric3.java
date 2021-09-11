package myjava3;
/*
 * 1. 제목: 참조 변수 또는 메소드의 매개 변수의 타입을 제한하기
 */
class MyParent {
	
}
class MyChild extends MyParent {
	
}
// 일반화 클래스를 정의
class MyChild2<T>{
	
}

public class TestGeneric3 {

	public static void main(String[] args) {
		// 1. MyChild2 클래스를 사용해서 참조 변수를 선언
		MyChild2<? extends Integer> a = new MyChild2<Integer>();
		MyChild2<? extends MyParent> b = new MyChild2<MyParent>();
		MyChild2<? extends MyParent> c = new MyChild2<MyChild>();
		
		
	}

}
