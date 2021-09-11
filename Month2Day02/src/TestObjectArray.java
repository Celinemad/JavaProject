/*
 * 1. 제목: 객체 배열을 생성하고 사용하는 예제
 */
// 사용자로부터 배열의 크기를 입력 받을 때 사용할 Scanner 클래스를 import
import java.util.Scanner;

// 새로운 ObjectArray 클래스를 생성
class ObjectArray{
	
	// 실무에서는 변수명 앞에 접두사 m_를 많이 사용: member의 m
	private int m_a;
	
	// 기본 생성자
	public ObjectArray() {
		m_a = 10; // 기본값이 0이기 때문에 0만 아닌 값 주면 됨
	}
	
	// 다른 클래스로부터 하나의 정수를 받는 생성자
	public ObjectArray(int a) {
		m_a = a;
	}
	
	// show() 메소드
	public void show() {
		System.out.println("멤버 변수인 m_a의 값은 "+m_a);
	}
}

public class TestObjectArray {

	public static void main(String[] args) {
		// 1. ObjectArray 클래스를 최대 3개의 객체를 저장할 수 있는 배열을 생성
		ObjectArray[] a = new ObjectArray[3];
		
		// 2. for 반복문을 사용해서 실제 객체를 3개 생성
		for(int i=0; i<a.length; i++) {
			a[i] = new ObjectArray(i);
		}
		
		// 3. 새로운 for 반복문을 사용해서 show() 메소드를 호출
		for(int i=0; i<a.length; i++) {
			a[i].show();
		}
		
		// 2. Scanner 클래스를 사용하기 위한 객체를 생성
		Scanner scanner = new Scanner(System.in);
		
		// 5. 사용자로부터 배열의 크기를 정수로 입력 받기
		System.out.print("배열의 크기를 정수로 입력하세요(0보다 큰 정수): ");
		
		// 6. nextInt() 메소드를 실행
		int size = scanner.nextInt();
		
		// 7. if 조건문을 사용해서 사용자가 입력한 정수가 0보다 큰지를 검사
		if(size>0) {
			System.out.println("배열의 크기가 0보다 크므로 배열을 생성합니다!");
			ObjectArray[] b = new ObjectArray[size];
			for(int i=0; i<b.length; i++) {
				b[i] = new ObjectArray(i);
				b[i].show();
			}
		} else {
			System.out.println("배열의 크기가 0 이하이므로 배열을 만들 수 없습니다!");
		}
		
		scanner.close();
	}

}
