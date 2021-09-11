/*
 * 1. ����: ���ͳ� ���θ����� ���� ���ǰ� �ִ� ��������� ������ �� ����ϴ� �������̽��� �����ϰ� ���
 * 2. �ʿ��� �������̽��� Ŭ�������� ����
 * 	1) �������̽�
 * 	interface �������̽��� {
 * 		// ���� ��ĵ��� ���ڿ� ����� ����
 * 		public static final String CARD = "ī�����";
 * 		public static final String CASH = "���ݰ���";
 * 		public static final STring QR = "QR����";
 * 		// ������ �������� �߻� �޼��带 ����
 * 		public abstract void payment();
 * 	}
 * 	2) �ڽ� Ŭ�������� ����: �������̽��� ����
 * 		��. ī�� ���� �ÿ� ����� Ŭ������ ����
 *  	class Ŭ������ implements �������̽��� {
 *  		@Override
 *  		public void payment(){
 *  			// ��ɾ �ۼ�
 *  		}
 *  	}
 *  	��. ���� ���� �ÿ� ����� Ŭ������ ���� 
 *  	class Ŭ������2 implements �������̽��� {
 *  		@Override
 *  		public void payment(){
 *  			// ��ɾ �ۼ�
 *  		}
 *  	}
 *  	��. QR�ڵ� ���� �ÿ� ����� Ŭ������ ����
 *  	class Ŭ������3 implements �������̽��� {
 *  		@Override
 *  		public void payment(){
 *  			// ��ɾ �ۼ�
 *  		}
 *  	}
 *  	��. ���� Ŭ������ �ۼ�: ����ڰ� ���� ���� ����� ���ϴ� Ŭ����
 *  	class Ŭ������4 {
 *  		// �������� ������ ��� ������ ����
 *  		private �������̽��� m_payment;
 *  		// ���� ����� �޼ҵ带 ����: �ٸ� Ŭ�����κ��� ���� ��� ���ڿ��� �Է� �޽��ϴ�.
 *  		public void process(String option) {
 *  			// �Ű����� option�� ���� ���� ���ο� ���� ����� ��ü�� ����
 *  			// 1. ����ڰ� ī������� ������ ���
 *  			if(oprion.equals(�������̽���.CARD)) {
 *  				// Ŭ������ Ŭ������ ����ؼ� ���ο� ��ü�� ���� 
 *  				m_payment = new Ŭ������();
 *  			}
 *  			// 2. ����ڰ� ���ݰ����� ������ ���
 *  			else if(oprion.equals(�������̽���.CASH)) {
 *  				// Ŭ������ Ŭ������ ����ؼ� ���ο� ��ü�� ���� 
 *  				m_payment = new Ŭ������();
 *  			}
 *  			// 3. ����ڰ� QR������ ������ ���
 *  			else if(oprion.equals(�������̽���.QR)) {
 *  				// Ŭ������ Ŭ������ ����ؼ� ���ο� ��ü�� ���� 
 *  				m_payment = new Ŭ������();
 *  			}
 *  			// 4. ó���� �� �ִ� ���� ����� �ƴ� ��쿡�� ���� �޽����� ��� + ���α׷��� ����
 *  			else {
 *  				System.out.println("ó���� �� ���� ���� ����Դϴ�. ����ũ�� ���� �ٶ��ϴ�...");
 *  				System.exit(1);
 *  			}
 *  			// 5. �������� ���� ����� ��쿡�� ������ Ŭ�������� �������� payment() �޼��带 ����
 *  			m_payment.payment();
 *  		}
 *  	}
 */

// ����ڷκ��� �޴� ��ȣ �Է� �Ǵ� ���� ��� ���ڿ��� �Է� ���� �� ����� Scanner Ŭ������ ����ϱ�
import java.util.Scanner;
// IPayment �������̽��� ����(����)
interface IPayment{
	// ���� ��� ���ڿ��� ����� ������Ű��
	public static final String CARD  = "ī�����";
	public static final String CASH  = "���ݰ���";
	public static final String QR    = "QR����";
	public static final String Kakao = "Kakao���� ����";
	// �߻� �޼��带 ����
	public abstract void payment();
}
// ���� ����� �ڽ� Ŭ�������� ����
class CardPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("ī��� ������ �մϴ�...");
	}
}
class CashPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("���� ������ �մϴ�...");
		
	}
	
}
class QRPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("QR�ڵ�� ������ �մϴ�...");
		
	}
	
}
class KakaoPay implements IPayment{

	@Override
	public void payment() {
		System.out.println("KakaoPay�� ������ �մϴ�...");
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
			System.out.println("ó���� �� ���� ���� ����Դϴ�... ����ũ�� ���� �ٶ��ϴ�...");
			System.exit(1);
		}
		m_payment.payment();
	}
}

public class TestPayment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("*** ���ͳ� ���θ� ���� ��� ���� ***");
//		System.out.println("1. ī����� 2. ���ݰ���  3. QR�ڵ� ����  4. ����");
//		System.out.print("�޴� ��ȣ�� ������ �Է��ϼ���: ");
//		int menu = scanner.nextInt();
//		PayService payservice = new PayService();
//		// ����ڰ� �Է��� �޴� ��ȣ�� ���ڿ��� ��ȯ�ϱ�
//		String result = "";
		do {
			System.out.println("*** ���ͳ� ���θ� ���� ��� ���� ***");
			System.out.println("1. ī����� 2. ���ݰ���  3. QR�ڵ� ����  4. Kakao���� ����  5. ����");
			System.out.print("�޴��� ���ڷ� �Է��ϼ���: ");
			String menu = scanner.nextLine();
			PayService payservice = new PayService();
			// ����ڰ� �Է��� �޴� ��ȣ�� ���ڿ��� ��ȯ�ϱ�
			String result = "";
			if(menu.equals("ī�����")) result = IPayment.CARD;
			else if(menu.equals("���ݰ���")) result = IPayment.CASH;
			else if(menu.equals("QR�ڵ� ����")) result = IPayment.QR;
			else if(menu.equals("Kakao���� ����")) result = IPayment.Kakao;
			else if(menu.equals("����")) {
				System.out.println("���α׷��� �����մϴ�...");
				break;
			}
			else {
				System.out.println("�޴��� ���� �׸��� �Է��ؼ� ó���� �� �����ϴ�...");
				System.out.println("�ٽ� �Է��ϼ���.");
				continue;
			}
			payservice.process(result);
		} while (true);
		
		scanner.close();
		
	}

}
