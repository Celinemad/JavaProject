package myjava2;

import java.io.*;
public class TestFileCopy {

	public static void main(String[] args) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			fileReader = new FileReader("C:\\celinetxt\\test2.txt");
			fileWriter = new FileWriter("C:\\celinetxt\\copy_test.txt");
			
			System.out.println("파일을 복사할 때 사용할 객체를 만들었습니다.");
			
			int ch;
			while(true) {
				ch = fileReader.read();
				if(ch == -1) {
					System.out.println();
					System.out.println("파일의 내용이 없습니다.");
					break;
				} else {
					System.out.print((char)ch);
					fileWriter.write((char)ch);
				}
			}
			
		} catch(FileNotFoundException e1) {
			System.out.println("test.txt 텍스트 파일이 없습니다.");
		} catch(IOException e2) {
			System.out.println("파일에서 데이터를 가져올 때 예외상황이 발생하였습니다.");
			e2.printStackTrace();
		} finally {
			try {
				if(fileReader != null) {
					fileReader.close();
					System.out.println("test.txt 파일을 닫았습니다.");
				}
				if(fileWriter != null) {
					fileWriter.close(); //fileWriter.close() 안하면 저장 안됨
				}
			} catch(IOException e3){
				System.out.println("test.txt 파일을 닫을 때 예외상황이 발생");
				e3.printStackTrace();
			}
		}
		
		
	}

}
