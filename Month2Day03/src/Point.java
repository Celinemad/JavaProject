// 1. 2���� ��鿡�� ��ü�� ��ġ�� ǥ���� �� ����ϴ� Ŭ����
// 2. ��ġ ǥ��: x�� y��ǥ�� �ʿ�(����)
public class Point {
	int m_x;
	int m_y;
	// �⺻ �����ڸ� �����ؼ� ��� ���� m_x�� m_y�� 0�� ����
	public Point() {
		System.out.println("Point Ŭ������ �⺻ ������");
		m_x = m_y = 0;
	}
	// �ٸ� Ŭ�����κ��� x�� y ��ǥ ��θ� �Է� �޴� ������
	public Point(int x, int y) {
		System.out.println("Point Ŭ������ �Է� �Ű������� ���� ������");
		m_x = x;
		m_y = y;
	}
	// x�� y ��ǥ�� ����ϴ� �޼ҵ�
	public void showPoint() {
		System.out.println("x��ǥ ���� "+m_x+", y��ǥ ���� "+m_y);
	}
}

