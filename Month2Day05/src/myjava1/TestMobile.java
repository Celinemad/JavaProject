package myjava1;
/*
 * 1. 제목: 스마트 폰 기능을 인터페이스에 선언 + 상속 받는 업체 클래스에서 다양한 방법을 정의(다형성)
 */

// 2. 인터페이스를 선언
interface MobilePhoneInterface {
	// 3. 전화 거는 기능을 담당할 sendCall() 추상 메서드를 선언
	public abstract void sendCall();
	// 추가: 인터넷 기능을 담당할 internet() 추상 메서드를 선언
	public abstract void internet();
}
// 4. 삼성 클래스를 정의 + 인터페이스를 구현
class SamsungPhoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("삼성 휴대폰에서 인터넷을 하고 있습니다...");
	}

	@Override
	public void sendCall() {
		System.out.println("삼성 휴대폰에서 전화를 걸고 있습니다...");
	}
	
}

// 5. 아이폰 클래스를 정의 + 인터페이스를 구현
class IphoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("아이폰에서 인터넷을 하고 있습니다...");
	}

	@Override
	public void sendCall() {
		System.out.println("아이폰에서 전화를 걸고 있습니다...");
	}
	
}

// 6. LG 클래스를 정의 + 인터페이스를 구현
class LgPhoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("LG 휴대폰에서 인터넷을 하고 있습니다...");
	}

	@Override
	public void sendCall() {
		System.out.println("LG 휴대폰에서 전화를 걸고 있습니다...");
	}
	
}

public class TestMobile {

	public static void main(String[] args) {
		
		SamsungPhoneInterface samsung = new SamsungPhoneInterface();
		IphoneInterface iphone = new IphoneInterface();
		LgPhoneInterface lg = new LgPhoneInterface();
		
		// 모든 클래스에서 재정의한 sendCall() 메서드를 호출
		samsung.sendCall();
		iphone.sendCall();
		lg.sendCall();
		
		// 모든 클래스에서 재정의한 internet() 메서드를 호출
		samsung.internet();
		iphone.internet();
		lg.internet();
	}

}
