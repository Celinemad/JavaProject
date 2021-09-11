package myjava4;
/*
 * ����: ��� ���� test3.txt ���Ͽ� �ȳ��ϼ���? �޽����� �����ϰ� �о�ͼ� ���
 */
import java.io.*;
public class TestFileIO {

	public static void main(String[] args) {
		// 1. test3.txt ���Ͽ� �ȳ��ϼ���? �޽����� ������ �� ����� ���� ����
		FileWriter fileWriter = null;
		// 2. test3.txt ���Ͽ� �ȳ��ϼ���? �޽����� �о�� �� ����� ���� ����
		FileReader fileReader = null;
	
		try {
			
			File file = new File("C:\\celinetxt\\test3.txt");
			boolean chk = file.exists();
			if(chk == true) {
				System.out.println("test3.txt ������ ����");
				long length = file.length();
				if(length == 0) {
					System.out.println("������ ���� ������ �����ϴ�.");
					// true ���� "���ϸ�.txt" ������ �߰�(append) ���� ���
					// -> ���� ������ ������ ������ ���� ������ ����
					fileWriter = new FileWriter("C:\\celinetxt\\test3.txt", true);
					fileWriter.write("�ȳ��ϼ���");
					fileWriter.close();
				} else {
					fileWriter = new FileWriter("C:\\celinetxt\\test3.txt");
					fileWriter.write("�ȳ��ϼ���?");
					fileWriter.close();
				}
				// ���� ������ ������ ������ ������ ������ �о�ͼ� ����� ȭ�鿡 ����ϴ� while �ݺ����� �ۼ��ϱ�
				fileReader = new FileReader("C:\\celinetxt\\test3.txt");
				int ch;
				while(true) {
					ch = fileReader.read();
					if(ch == -1) break;
					else System.out.print((char)ch);
				}
			} else {
				System.out.println("test3.txt ������ �����ϴ�");
			}
			
		}catch(FileNotFoundException e1) {
			System.out.println("test.txt �ؽ�Ʈ ������ �����ϴ�.");
		}catch(IOException e2) {
			System.out.println("���Ͽ��� �����͸� ������ �� ���ܻ�Ȳ�� �߻��Ͽ����ϴ�.");
			e2.printStackTrace();
		}finally {
			try {
				if(fileReader != null) fileReader.close();
			} catch(IOException e3) {
				System.out.println("���� ���� �ÿ� ���ܰ� �߻�");
				e3.printStackTrace();
			}
		}
	}

}
