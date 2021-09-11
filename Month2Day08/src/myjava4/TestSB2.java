package myjava4;

public class TestSB2 {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("서울시");
		
		a.append("마포구");
		a.insert(3, " ");
		System.out.println(a);
	}

}
