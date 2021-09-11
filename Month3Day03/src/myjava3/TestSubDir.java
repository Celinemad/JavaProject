package myjava3;
/*
 * 1. ����: ���� ���丮�� ��� ������ ����ϴ� ����
 */
import java.io.*;
public class TestSubDir {

	public static void main(String[] args) {
		
		// 2. ���� ���� �������� ����
		// 1) File Ŭ������ ����ؼ� ���� �Ǵ� ���丮�� ������ �� ���
		File file = new File("C:\\celinetxt");
		// 2) celinetxt ���� �ȿ� �ִ� ��� ����(���丮)���� �о�ͼ� File[] �迭 ��ü�� ��ȯ
		// -> File Ŭ������ �ִ� listFiles() �޼ҵ带 ���
		// -> ����) File[] �迭�� = file.listFiles();
		File[] arrFile = file.listFiles();
		
		// 3. try~catch ���� �ۼ�(finally�� close() �޼ҵ� �Ƚᵵ ��)
		//		: ������ File Ŭ���������� close() �޼ҵ带 �������� ����(finally�� �ۼ����� ����)
		try {
			// 4. if ���ǹ��� ����ؼ� ����(���丮)�� ������ �˻��ϱ�
			if(arrFile.length == 0) {
				System.out.println("celinetxt ���� �ȿ��� ������ �ϳ��� �����ϴ�.");
			} else {
				System.out.println("celinetxt ���� �ȿ� �ִ� ����(����)�� ������ " + arrFile.length);
				// for �ݺ����� ����ؼ� ���ϰ� ���丮�� �����ؼ� �̸��� ������ ũ��(�뷮)�� ����ϱ�
				for(int i=0; i<arrFile.length; i++) {
					String name = arrFile[i].getName();
					System.out.println("����(���丮)�� �̸��� " + name);
					long size = arrFile[i].length();
					System.out.println("����(���丮)�� ũ��(����Ʈ��)�� " + size + "����Ʈ");
					// �������� �˻��ϱ�
					boolean chkFile = arrFile[i].isFile();
					if(chkFile == true) {
						System.out.println("�����Դϴ�.");
					}
					// ���丮���� �˻��ϱ�
					boolean chkDir = arrFile[i].isDirectory();
					if(chkDir == true) {
						System.out.println("���丮�Դϴ�.");
					}
				}
				// createNewFile() �޼ҵ带 ����ؼ� celinetxt ���� �ȿ� Ư�� ������ �ִ��� �˻��ϰ� 
				// ������ ������ �����
				// -> ������ ������ �Ǵ��ϱ� ���ؼ��� exists() �޼ҵ带 ���
				//		-> ����) boolean ������ = ��������������.exists();
				File newFile = new File("C:\\celinetxt\\test3.txt");
				boolean chkFile = newFile.exists();
				if(chkFile == true) {
					System.out.println("test3.txt ������ �����մϴ�.");
				} else {
					boolean result = newFile.createNewFile();
					if(result == true) {
						System.out.println("test3.txt ������ ��� ���� ����");
					} else {
						System.out.println("test3.txt ���� ���� ����");
					}
				}
			}
			
		} catch(IOException e) {
			System.out.println("���ܻ�Ȳ�� �߻�");
			e.printStackTrace();
		}
		
		
	}

}
