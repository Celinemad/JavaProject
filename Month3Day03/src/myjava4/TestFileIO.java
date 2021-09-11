package myjava4;
/*
 * 제목: 방금 만든 test3.txt 파일에 안녕하세요? 메시지를 저장하고 읽어와서 출력
 */
import java.io.*;
public class TestFileIO {

	public static void main(String[] args) {
		// 1. test3.txt 파일에 안녕하세요? 메시지를 저장할 때 사용할 참조 변수
		FileWriter fileWriter = null;
		// 2. test3.txt 파일에 안녕하세요? 메시지를 읽어올 때 사용할 참조 변수
		FileReader fileReader = null;
	
		try {
			
			File file = new File("C:\\celinetxt\\test3.txt");
			boolean chk = file.exists();
			if(chk == true) {
				System.out.println("test3.txt 파일이 존재");
				long length = file.length();
				if(length == 0) {
					System.out.println("파일의 현재 내용이 없습니다.");
					// true 값은 "파일명.txt" 파일을 추가(append) 모드로 사용
					// -> 만약 파일이 있으면 파일을 새로 만들지 않음
					fileWriter = new FileWriter("C:\\celinetxt\\test3.txt", true);
					fileWriter.write("안녕하세요");
					fileWriter.close();
				} else {
					fileWriter = new FileWriter("C:\\celinetxt\\test3.txt");
					fileWriter.write("안녕하세요?");
					fileWriter.close();
				}
				// 현재 파일의 내용이 있으면 파일의 내용을 읽어와서 모니터 화면에 출력하는 while 반복문을 작성하기
				fileReader = new FileReader("C:\\celinetxt\\test3.txt");
				int ch;
				while(true) {
					ch = fileReader.read();
					if(ch == -1) break;
					else System.out.print((char)ch);
				}
			} else {
				System.out.println("test3.txt 파일이 없습니다");
			}
			
		}catch(FileNotFoundException e1) {
			System.out.println("test.txt 텍스트 파일이 없습니다.");
		}catch(IOException e2) {
			System.out.println("파일에서 데이터를 가져올 때 예외상황이 발생하였습니다.");
			e2.printStackTrace();
		}finally {
			try {
				if(fileReader != null) fileReader.close();
			} catch(IOException e3) {
				System.out.println("파일 종료 시에 예외가 발생");
				e3.printStackTrace();
			}
		}
	}

}
