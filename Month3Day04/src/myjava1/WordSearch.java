package myjava1;
/*
 * 1. ���� ���� ���� ����: ���� 488�� 11�� ����
 * 
 * ������
 * ������Ʈ ������ words.txt ������ �о����ϴ�. 
 * ã�� �ܾ �Է�>>lov
 * love
 * lovebird
 * lovelorn
 * ã�� �ܾ �Է�>>kitt
 * ++
 */
import java.io.*;
import java.util.*;

public class WordSearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<String> vector = new Vector<String>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null; // try �� �ٱ��� ��� ��
		
		try {
			fileReader = new FileReader("words.txt");
			// 1. while() �ݺ����� ����ؼ� words.txt ���Ͽ��� �ѱ��ھ� �о����
			// -> �� �پ� �о���� ���ؼ��� BufferedReader Ŭ������ ���
			bufferedReader = new BufferedReader(fileReader);
			
			// 2. ���Ͽ��� �о�� �� �� ���ڿ��� ������ ������ ����
			String line = "";
			while(true) {
				line = bufferedReader.readLine();
				if(line == null) {   // �ּ� ���� ����
					System.out.println("�� �̻� ���Ͽ��� �о�� ������ �����ϴ�.(�ּҰ� �����ϴ�.)");
					break;
				} else {
					if(line.isEmpty()) {   // ������ ����
						System.out.println("�� �ٿ��� ���� �����ϴ�.");
					} else {
						vector.add(line);
//						System.out.println("���Ϳ� �ܾ ������");
					}
				}
			}
			// while �ݺ����� ������ �Ŀ� ���Ϳ� ����� ��� �ܾ���� �����ͼ� ����ϱ�
			Iterator<String> iterator = vector.iterator(); // Iterator: �ݺ��ڷ�, �ε��� ���� �����ϴ� ���
//			while(iterator.hasNext() == true) {
//				String word = iterator.next();
//				System.out.println("���Ϳ��� ������ �ܾ�� "+word);
//			}
			
			// �ܾ��� ������ ����ϱ�
//			System.out.println("�ܾ��� ������ "+ vector.size());
			
			// while �ݺ����� ����ؼ� ����ڰ� "�׸�"�� �Է��ϱ� ������ ����ؼ� 
			// ����ڷκ��� �˻��� �ܾ �Է¹޾Ƽ� ����� ���
			while(true) {
				
				System.out.print("�˻��� �ܾ �Է�(�ߴ��Ͻ÷��� �׸�)>> ");
				String findWord = scanner.nextLine();
				while(findWord.isEmpty()) {
					System.out.print("��! �ܾ� �Ǵ� �׸��� �Է��ϼ���: ");
					findWord = scanner.nextLine();
				}
				System.out.println("����ڰ� �Է��� ã�� �ܾ�� " + findWord);
				
				/*
				 * ����ڰ� �Է��� �ܾ ���Ϳ� ����Ǿ� �ִ����� ã�ƺ��� �ݺ����� �Է�
				 */
				
				// ����ڰ� �׸��� �Է��ϸ� �ݺ����� ����
				if(findWord.equals("�׸�")) {
					System.out.println("�˻��� �ߴ��մϴ�.");
					break;
				} else {
					iterator = vector.iterator();
					boolean find = false;
					while(iterator.hasNext()) {
						String word = iterator.next();
						if(word.startsWith(findWord)) {
							System.out.println(word);
							find = true;
						} else if(word.startsWith(findWord) == false) {
							continue;
						}
					}
					if(find == false) {
						System.out.println("ã���ô� �ܾ �����ϴ�.");
					}
				}
			}
			
		} catch(FileNotFoundException e1){
			e1.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
		}finally {
			try {
				if(bufferedReader != null) {
					bufferedReader.close();  // bufferedReader Ŭ���� �ϸ� ���������� (���������� ����Ǿ� �ִ�) fileReader�� �����
				}
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
		
		
	}
}
