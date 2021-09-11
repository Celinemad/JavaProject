package myjava2;
/*
 * 1. ����: HashSet Ŭ������ ����ؼ� �ߺ��� ���� �ζ� ��ȣ���� 6�� �����
 * 		1) ������ ����: java.util.Random Ŭ������ ���(����)
 */
import java.util.*;
public class TestHashSet {

	public static void main(String[] args) {
		// 2. �ζ� ��ȣ�� ������ �� ����� ��ü�� ����
		Random random = new Random();
		
		// 3. �ߺ� ���� 6���� �ζ� ��ȣ�� ������ HashSet ��ü�� ����
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		// 4. while �ݺ����� ����ؼ� �� 6���� �ζ� ��ȣ�� ����� hashSet ��ü�� �����ϱ�
		while(hashSet.size() != 6) {
			
			// 5. �ζ� ��ȣ�� �����ϱ�: 1 ~ 45 ���̿� �ִ� ������ ������ �����ؼ� int �ڷ����� �����ϱ�
			int no = random.nextInt(45) + 1;
			
			// 6. HashSet Ŭ������ ���� �ִ� add() �޼ҵ带 �����ؼ� ������ �Է�
			// 		-> �ߺ� �˻縦 ���ؼ� if ���ǹ��� ���
			boolean result = hashSet.add(no);
			if(result == true) {
				System.out.println("���ο� ������ �ؽü�Ʈ ��ü�� �����");
			} else {
				System.out.println("�ߺ��Ǿ� ������� ����");
			}
			System.out.println("������� �ؽü�Ʈ�� ����� �ζ� ��ȣ�� ������ " + hashSet.size());
		}
		// while �ݺ����� ��� ��ġ���� 6���� �ζ� ��ȣ���� ���
		Object[] lottoNo = hashSet.toArray();
		String str = Arrays.toString(lottoNo);
		System.out.println("�� 6���� �ζ� ��ȣ���� "+ str);
		
		
		/*
		 * HashSet Ŭ������ �ִ� 6���� �ζ� ��ȣ���� �����ϱ�
		 * 1) TreeSet Ŭ������ �����ڸ� ����ϱ�: TreeSet(Collection) 
		 * 	-> ��ü ���� ����: TreeSet<������Ÿ��> ���������� = new TreeSet<������Ÿ��>(�ؽü�Ʈ����������);
		 */
		TreeSet<Integer> treeSet = new TreeSet<Integer>(hashSet);
		System.out.println(treeSet);
	}

}
