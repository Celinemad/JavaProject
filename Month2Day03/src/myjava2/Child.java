package myjava2;

import myjava1.Parent;
// 1. 자식 클래스를 정의
// 2. Parent 클래스에서 선언한 protected int m_a를 바로 사용하기
public class Child extends Parent {
	// 3. int m_a를 바로 사용하는 useMa()
	public void useMa() {
		System.out.println("useMa() 메소드가 호출됨");
		m_a = 100;
		System.out.println("상속 받은 m_a의 값은 "+m_a);
	}
}
