package myjava3;
/*
 * 1. ����: ���� ���� �Ǵ� �޼ҵ��� �Ű� ������ Ÿ���� �����ϱ�
 */
class MyParent {
	
}
class MyChild extends MyParent {
	
}
// �Ϲ�ȭ Ŭ������ ����
class MyChild2<T>{
	
}

public class TestGeneric3 {

	public static void main(String[] args) {
		// 1. MyChild2 Ŭ������ ����ؼ� ���� ������ ����
		MyChild2<? extends Integer> a = new MyChild2<Integer>();
		MyChild2<? extends MyParent> b = new MyChild2<MyParent>();
		MyChild2<? extends MyParent> c = new MyChild2<MyChild>();
		
		
	}

}
