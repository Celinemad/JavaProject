package myjava1;
/*
 * 1. ����: ����Ʈ �� ����� �������̽��� ���� + ��� �޴� ��ü Ŭ�������� �پ��� ����� ����(������)
 */

// 2. �������̽��� ����
interface MobilePhoneInterface {
	// 3. ��ȭ �Ŵ� ����� ����� sendCall() �߻� �޼��带 ����
	public abstract void sendCall();
	// �߰�: ���ͳ� ����� ����� internet() �߻� �޼��带 ����
	public abstract void internet();
}
// 4. �Ｚ Ŭ������ ���� + �������̽��� ����
class SamsungPhoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("�Ｚ �޴������� ���ͳ��� �ϰ� �ֽ��ϴ�...");
	}

	@Override
	public void sendCall() {
		System.out.println("�Ｚ �޴������� ��ȭ�� �ɰ� �ֽ��ϴ�...");
	}
	
}

// 5. ������ Ŭ������ ���� + �������̽��� ����
class IphoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("���������� ���ͳ��� �ϰ� �ֽ��ϴ�...");
	}

	@Override
	public void sendCall() {
		System.out.println("���������� ��ȭ�� �ɰ� �ֽ��ϴ�...");
	}
	
}

// 6. LG Ŭ������ ���� + �������̽��� ����
class LgPhoneInterface implements MobilePhoneInterface {

	@Override
	public void internet() {
		System.out.println("LG �޴������� ���ͳ��� �ϰ� �ֽ��ϴ�...");
	}

	@Override
	public void sendCall() {
		System.out.println("LG �޴������� ��ȭ�� �ɰ� �ֽ��ϴ�...");
	}
	
}

public class TestMobile {

	public static void main(String[] args) {
		
		SamsungPhoneInterface samsung = new SamsungPhoneInterface();
		IphoneInterface iphone = new IphoneInterface();
		LgPhoneInterface lg = new LgPhoneInterface();
		
		// ��� Ŭ�������� �������� sendCall() �޼��带 ȣ��
		samsung.sendCall();
		iphone.sendCall();
		lg.sendCall();
		
		// ��� Ŭ�������� �������� internet() �޼��带 ȣ��
		samsung.internet();
		iphone.internet();
		lg.internet();
	}

}
