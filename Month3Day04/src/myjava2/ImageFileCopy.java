package myjava2;
/*
 * 1. ����: �̹��� ������ �����ؼ� ���ο� �̹��� ������ �����
 * 	1) �ҽ� ����: ��� �ٿ�ε� �� ����: �̸��� joy.jpg
 * 	2) ����(���� ���� ����): �̸��� copy_joy.jpg (+ png�� ���� java�� ������ �̹��� Ȯ����)
 */
import java.io.*;
public class ImageFileCopy {

	public static void main(String[] args) {
		// 2. �ҽ� ���� �̸��� ���ȭ(�б� �뵵)
		final String SRC_FINAL_NAME = "joy.jpg";
		// 3. ���� ���� ���� �̸��� ���ȭ
		final String DST_FILE_NAME = "copy_joy.jpg";
		
		// 4. �ҽ� ���Ͽ� ������ �� ����� ���� ������ ����
		FileInputStream fileInputStream = null;
		
		// 5. ���ο� �̹��� ������ ���� �� ����� ���� ������ ����
		FileOutputStream fileOutputStream = null;
		
		// ���� �߰�(����� ������ ����)
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 6. try~catch~finally ���� �ۼ��ؼ� ���ܻ�Ȳ�� ����ϱ�
		try {
			// 7. ���� �Է� ��ü�� ����
			fileInputStream = new FileInputStream(SRC_FINAL_NAME);
			// 8. ���� ��� ��ü�� ����
			fileOutputStream = new FileOutputStream(DST_FILE_NAME);
			// 9. ���Ͽ��� ������ ���ڸ� ������ ������ ����
			int data;
			
			// ���� �߰�
			bis = new BufferedInputStream(fileInputStream);
			bos = new BufferedOutputStream(fileOutputStream);
			
			// ���� �����͸� ����Ʈ ������ ������ �迭�� ����
			byte[] buff = new byte[200]; // �������
			// ���� ���: ���Ͽ��� �����͸� �������� ������ �迭�� ����
			// -> BufferedInputStream Ŭ������ available() �޼ҵ带 ���
			//		-> ����: ���� ���Ͽ��� ����� �� �ִ� �������� ũ�⸦ ����Ʈ ���� ��ȯ
			//			-> ���� 1000�� ��ȯ�ϸ� �츮�� ���Ͽ��� 1000����Ʈ ũ���� �����͸� �о�� �� ���� +
			byte[] buff2 = null; // ���� ũ�Ⱑ �� ������� -> ����: �ݺ��� ������ ������ �����ȿ� ���� ũ�� ���� (�� ȿ����, ����X)
			
			// �� �ϱ� ���� ���� �ð��� �и������� ������ ���ϱ�
			long start = System.currentTimeMillis();
			System.out.println("���� �����ϱ� ���� ���� �ð��� " + start);
			
			// 10. while �ݺ����� ���
			while(true) {
				// ���� �߰��� ����: available() �޼ҵ带 �����ؼ� ���Ͽ��� ������ �� �ִ� �������� ũ�⸦ ����ϱ�
				int size = bis.available();
				if(size == 0) {
					System.out.println();
					break;
				} else {
					System.out.println("���Ͽ��� ������ �� �ִ� �������� ũ��� " + size + "����Ʈ");
					/*
					 * read() �޼ҵ带 ȣ���ؼ� ���Ͽ��� �����͸� �����ͼ� buff2 �迭�� ����
					 */
					buff2 = new byte[size];
					/*
					 * read() �޼ҵ带 ��ȯ������ ���� ���Ͽ��� �о�� �����͸� ����Ʈ���� ������
					 */
					int real_size = bis.read(buff2);
					System.out.println("���Ͽ��� ���� ������ �������� ����Ʈ���� " + real_size);
					
					/* 
					 * ���Ͽ��� ������ �����͸� write() �޼ҵ带 ����ؼ�
					 * BufferedOutputStream ��ü�� ���� 
					 */
					bos.write(buff2);
					System.out.println("���� ���� ���Ͽ� �����͸� ��(��� �Ǵ� ����)");
				}
				
//				data = fileInputStream.read();
//				// 11. ���Ͽ��� �о�� ������ -1�̸� ����
//				if(data == -1) {
//					break;
//				} else {
//					// 12. ���Ͽ��� ������ �����͸� ���� ��� ��Ʈ���� ����(����)
//					fileOutputStream.write(data);
//				}
			}
			System.out.println("�̹��� ���� ���� �Ϸ�");
			
			// ���� ������ ���� ���� �ð��� �и������� ������ ���ϱ�
			long end = System.currentTimeMillis();
			System.out.println("���� ������ ���� ���� �ð��� " + end);
			
			long diff = end - start;
			
			double result = diff / 1000.;
			
			System.out.printf("�̹��� ���� ���翡 �ҿ�� �ð��� %.15f��\n", result);
			
		} catch(FileNotFoundException e1) {
			e1.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				// ���� ����: �Է� ��Ʈ�� -> ��� ��Ʈ��
//				if(fileInputStream != null) {
//					fileInputStream.close();
//				}
//				if(fileOutputStream != null) {
//					fileInputStream.close();
//				}
				if(bis != null) {
					bis.close();
				}
				if(bos != null) {
					bos.close();
				}
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
		
		
	}

}
