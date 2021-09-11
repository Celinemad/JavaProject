package myjava1;
/*
 * 1. ����: java.io.FileReader Ŭ������ ����ؼ� �ؽ�Ʈ ���Ͽ��� ������ ������ �о�ͼ� ȭ�鿡 ����ϴ� ������ �ۼ�
 * 1) ���� ����: �� ��ǻ�Ϳ� c����̺꿡 �������� ����ϰ� �ִ� �������� �� ���� ���ο� �ؽ�Ʈ ������ ����� �����ϱ�
 * 		��) c:\\������1\\�ؽ�Ʈ���ϸ�.txt
 *      ������1: celinetxt
 *      �ؽ�Ʈ���ϸ�: text.txt
 */
import java.io.*;
public class TestFileReader {

	public static void main(String[] args) {
		// 2. �ʿ��� ������������ ����
		// 1) FileReader Ŭ������ ����� ���������� ���� (try~catch �ȿ� �ϸ� �ȵ�)
		FileReader fileReader = null;
		
		// 3. try~catch~catch~finally ���� �ۼ��ؼ� ���ܻ�Ȳ�� ����ϱ�
		try {
			// 3-1. FileReader ��ü�� ���� + ���ϸ�(������: "c:\\������\\test.txt")
			fileReader = new FileReader("C:\\celinetxt\\test.txt");
			
			System.out.println("������ �ٷ� �� ����� ��ü�� ��������ϴ�.");
			
			// 4. test.txt ������ ������ �о�ͼ� ȭ�鿡 ���
			int ch;
			while(true) {
				ch = fileReader.read();
				if(ch == -1) {
					System.out.println();
					System.out.println("������ ������ �����ϴ�.");
					break;
				} else {
					System.out.print((char)ch);
				}
			}
		} catch(FileNotFoundException e1) {
			System.out.println("test.txt �ؽ�Ʈ ������ �����ϴ�.");
		} catch(IOException e2) {
			System.out.println("���Ͽ��� �����͸� ������ �� ���ܻ�Ȳ�� �߻��Ͽ����ϴ�.");
			e2.printStackTrace();
		} finally {
			// close() �޼ҵ带 �����ؼ� ������ �ݱ�: IOException ���ܻ�Ȳ�� ����ϱ�
			try {
				if(fileReader != null) {
					fileReader.close();
					System.out.println("test.txt ������ �ݾҽ��ϴ�.");
				}
			} catch(IOException e3){
				System.out.println("test.txt ������ ���� �� ���ܻ�Ȳ�� �߻�");
				e3.printStackTrace();
			}
		}
		// �ؽ�Ʈ ���� ������ ������ ���� ���� �ؽ�Ʈ ������ ���ڵ��� UTF-8���� ANSI�� ��ü (�ٸ��̸����� ���忡��)
		
		
	}

}
// Text file encoding Ȯ���ϴ� ���: alt + Enter (Ŀ���� �ۿ� �ΰ�)