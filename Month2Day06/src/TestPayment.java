/*
 * 1. 제목: 인터넷 쇼핑몰에서 실제 사용되고 있는 결제방식을 선택할 때 사용하는 인터페이스를 설계하고 사용
 * 2. 필요한 인터페이스와 클래스들을 설계
 * 	1) 인터페이스
 * 	interface 인터페이스명 {
 * 		// 결제 방식들을 문자열 상수에 보관
 * 		public static final String CARD = "카드결제";
 * 		public static final String CASH = "현금결제";
 * 		public static final STring QR = "QR결제";
 * 		// 실제로 재정의할 추상 메서드를 선언
 * 		public abstract void payment();
 * 	}
 * 	2) 자식 클래스들을 정의: 인터페이스를 구현
 * 		가. 카드 결제 시에 사용할 클래스를 정의
 *  	class 클래스명 implements 인터페이스명 {
 *  		@Override
 *  		public void payment(){
 *  			// 명령어를 작성
 *  		}
 *  	}
 *  	나. 현금 결제 시에 사용할 클래스를 정의 
 *  	class 클래스명2 implements 인터페이스명 {
 *  		@Override
 *  		public void payment(){
 *  			// 명령어를 작성
 *  		}
 *  	}
 *  	다. QR코드 결제 시에 사용할 클래스를 정의
 *  	class 클래스명3 implements 인터페이스명 {
 *  		@Override
 *  		public void payment(){
 *  			// 명령어를 작성
 *  		}
 *  	}
 *  	라. 서비스 클래스를 작성: 사용자가 실제 결제 방식을 정하는 클래스
 *  	class 클래스명4 {
 *  		// 다형성을 적용한 멤버 변수를 선언
 *  		private 인터페이스명 m_payment;
 *  		// 실제 실행될 메소드를 정의: 다른 클래스로부터 결제 방식 문자열을 입력 받습니다.
 *  		public void process(String option) {
 *  			// 매개변수 option의 값에 따라서 새로운 결제 방식의 객체를 생성
 *  			// 1. 사용자가 카드결제를 선택한 경우
 *  			if(oprion.equals(인터페이스명.CARD)) {
 *  				// 클래스명 클래스를 사용해서 새로운 객체를 생성 
 *  				m_payment = new 클래스명();
 *  			}
 *  			// 2. 사용자가 현금결제를 선택한 경우
 *  			else if(oprion.equals(인터페이스명.CASH)) {
 *  				// 클래스명 클래스를 사용해서 새로운 객체를 생성 
 *  				m_payment = new 클래스명();
 *  			}
 *  			// 3. 사용자가 QR결제를 선택한 경우
 *  			else if(oprion.equals(인터페이스명.QR)) {
 *  				// 클래스명 클래스를 사용해서 새로운 객체를 생성 
 *  				m_payment = new 클래스명();
 *  			}
 *  			// 4. 처리할 수 있는 결제 방식이 아닌 경우에는 오류 메시지를 출력 + 프로그램을 종료
 *  			else {
 *  				System.out.println("처리할 수 없는 결제 방식입니다. 데스크로 문의 바랍니다...");
 *  				System.exit(1);
 *  			}
 *  			// 5. 정상적인 결제 방식인 경우에는 각각의 클래스에서 재정의한 payment() 메서드를 실행
 *  			m_payment.payment();
 *  		}
 *  	}
 */

// 사용자로부터 메뉴 번호 입력 또는 결제 방식 문자열을 입력 받을 때 사용할 Scanner 클래스를 사용하기
import java.util.Scanner;
// IPayment 인터페이스를 정의(선언)
interface IPayment{
	// 결제 방식 문자열을 상수로 고정시키기
	public static final String CARD  = "카드결제";
	public static final String CASH  = "현금결제";
	public static final String QR    = "QR결제";
	public static final String Kakao = "Kakao페이 결제";
	// 추상 메서드를 전언
	public abstract void payment();
}
// 실제 사용할 자식 클래스들을 정의
class CardPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("카드로 결제를 합니다...");
	}
}
class CashPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("현금 결제를 합니다...");
		
	}
	
}
class QRPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("QR코드로 결제를 합니다...");
		
	}
	
}
class KakaoPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("KakaoPay로 결제를 합니다...");
	}
	
}

class PayService {
	private IPayment m_payment;
	public void process(String option) {
		if(option.equals(IPayment.CARD)) {
			m_payment = new CardPay();
		}
		else if(option.equals(IPayment.CASH)) {
			m_payment = new CashPay();
		}
		else if(option.equals(IPayment.QR)) {
			m_payment = new QRPay();
		}
		else if(option.equals(IPayment.Kakao)) {
			m_payment = new KakaoPay();
		}
		else {
			System.out.println("처리할 수 없는 결제 방식입니다... 데스크로 문의 바랍니다...");
			System.exit(1);
		}
		m_payment.payment();
	}
}

public class TestPayment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("*** 인터넷 쇼핑몰 결제 방식 예제 ***");
//		System.out.println("1. 카드결제 2. 현금결제  3. QR코드 결제  4. 종료");
//		System.out.print("메뉴 번호를 정수로 입력하세요: ");
//		int menu = scanner.nextInt();
//		PayService payservice = new PayService();
//		// 사용자가 입력한 메뉴 번호를 문자열로 변환하기
//		String result = "";
		do {
			System.out.println("*** 인터넷 쇼핑몰 결제 방식 예제 ***");
			System.out.println("1. 카드결제 2. 현금결제  3. QR코드 결제  4. Kakao페이 결제  5. 종료");
			System.out.print("메뉴를 문자로 입력하세요: ");
			String menu = scanner.nextLine();
			PayService payservice = new PayService();
			// 사용자가 입력한 메뉴 번호를 문자열로 변환하기
			String result = "";
			if(menu.equals("카드결제")) result = IPayment.CARD;
			else if(menu.equals("현금결제")) result = IPayment.CASH;
			else if(menu.equals("QR코드 결제")) result = IPayment.QR;
			else if(menu.equals("Kakao페이 결제")) result = IPayment.Kakao;
			else if(menu.equals("종료")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			else {
				System.out.println("메뉴에 없는 항목을 입력해서 처리할 수 없습니다...");
				System.out.println("다시 입력하세요.");
				continue;
			}
			payservice.process(result);
		} while (true);
		
		scanner.close();
		
	}

}
