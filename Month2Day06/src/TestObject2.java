/*
 * 1. ����: java.lang.Object Ŭ������ ���� �ִ� toString() �޼��带 ����ϱ� + �����ǵ� ����
 */
//2. 2���� ��鿡�� � ��ü�� ��(point) ������ �����ϴ� Point Ŭ������ ����
class Point {
	private int m_x;
	private int m_y;
	public Point() {
		m_x = m_y = 0;
	}
	public Point(int x, int y) {
		m_x = x;
		m_y = y;
	}
	public void show() {
		System.out.println("x��ǥ ���� "+m_x+ ", y��ǥ ���� "+m_y);
	}
	public int getX() {
		return m_x;
	}
	public int getY() {
		return m_y;
	}
	public void setX(int x) {
		m_x = x;
	}
	public void setY(int y) {
		m_y = y;
	}
	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}
	
	// �� ���� Point Ŭ���� ���� ����
	/*
	 * Object Ŭ������ ���� �ִ� toString() �޼����� ��ɾ �����ϱ�
	 * 	-> ����: ��� ������ ���� �ִ� ��� ������ �ϳ��� �����ؼ� ���ڿ��� ��ȯ
	 * 		-> String ������ = ��������� + "," + ���������2 + ... + "," + ���������n;
	 * 		-> return ������; 
	 */
	@Override // ������ 
	public String toString() {
		String result = getX() + "," + getY();
		return result;
	}
}
public class TestObject2 {

	public static void main(String[] args) {
		
		Point a = new Point();
		a.show();
		a.setX(a.getX()+10);
		a.show();
		a.setY(a.getY()-5);
		a.show();
		int value = a.getY();
		System.out.println("������� m_y�� ���� "+ value);
		
		Point b = new Point(10,20);
		b.show();
		
		// toString() �޼ҵ带 ȣ��
		String value2 = a.toString();
		System.out.println("���� ���� a�� ������ �� �ִ� toString() �޼ҵ��� ��ȯ���� "+value2);
	}

}
