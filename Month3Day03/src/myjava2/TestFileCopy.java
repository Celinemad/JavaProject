package myjava2;

import java.io.*;
public class TestFileCopy {

	public static void main(String[] args) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			fileReader = new FileReader("C:\\celinetxt\\test2.txt");
			fileWriter = new FileWriter("C:\\celinetxt\\copy_test.txt");
			
			System.out.println("������ ������ �� ����� ��ü�� ��������ϴ�.");
			
			int ch;
			while(true) {
				ch = fileReader.read();
				if(ch == -1) {
					System.out.println();
					System.out.println("������ ������ �����ϴ�.");
					break;
				} else {
					System.out.print((char)ch);
					fileWriter.write((char)ch);
				}
			}
			
		} catch(FileNotFoundException e1) {
			System.out.println("test.txt �ؽ�Ʈ ������ �����ϴ�.");
		} catch(IOException e2) {
			System.out.println("���Ͽ��� �����͸� ������ �� ���ܻ�Ȳ�� �߻��Ͽ����ϴ�.");
			e2.printStackTrace();
		} finally {
			try {
				if(fileReader != null) {
					fileReader.close();
					System.out.println("test.txt ������ �ݾҽ��ϴ�.");
				}
				if(fileWriter != null) {
					fileWriter.close(); //fileWriter.close() ���ϸ� ���� �ȵ�
				}
			} catch(IOException e3){
				System.out.println("test.txt ������ ���� �� ���ܻ�Ȳ�� �߻�");
				e3.printStackTrace();
			}
		}
		
		
	}

}
