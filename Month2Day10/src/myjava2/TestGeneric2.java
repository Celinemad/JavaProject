package myjava2;
/*
 * 1. ����: ���׸� Ÿ�� �Ű� ������ ����ؼ� ����� Ŭ������ �Ǵ� �������̽����� �����ϱ�
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
		// MyParent Ŭ������ ��� ���谡 ���� MyChild3 Ŭ������ ���
		MyChild<MyChild3> c = new MyChild<MyChild3>();
//		MyChild<MyChild> d = new MyChild<MyChild>();
		
		
	}

}
