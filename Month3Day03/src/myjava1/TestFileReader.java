package myjava1;
/*
 * 1. 제목: java.io.FileReader 클래스를 사용해서 텍스트 파일에서 파일의 내용을 읽어와서 화면에 출력하는 예제를 작성
 * 1) 전제 사항: 내 컴퓨터에 c드라이브에 여러분이 사용하고 있는 영문으로 된 폴더 내부에 텍스트 파일을 만들고 시작하기
 * 		예) c:\\폴더명1\\텍스트파일명.txt
 *      폴더명1: celinetxt
 *      텍스트파일명: text.txt
 */
import java.io.*;
public class TestFileReader {

	public static void main(String[] args) {
		// 2. 필요한 참조변수들을 선언
		// 1) FileReader 클래스를 사용한 참조변수를 선언 (try~catch 안에 하면 안됨)
		FileReader fileReader = null;
		
		// 3. try~catch~catch~finally 블럭을 작성해서 예외상황에 대비하기
		try {
			// 3-1. FileReader 객체를 생성 + 파일명(절대경로: "c:\\폴더명\\test.txt")
			fileReader = new FileReader("C:\\celinetxt\\test.txt");
			
			System.out.println("파일을 다룰 때 사용할 객체를 만들었습니다.");
			
			// 4. test.txt 파일의 내용을 읽어와서 화면에 출력
			int ch;
			while(true) {
				ch = fileReader.read();
				if(ch == -1) {
					System.out.println();
					System.out.println("파일의 내용이 없습니다.");
					break;
				} else {
					System.out.print((char)ch);
				}
			}
		} catch(FileNotFoundException e1) {
			System.out.println("test.txt 텍스트 파일이 없습니다.");
		} catch(IOException e2) {
			System.out.println("파일에서 데이터를 가져올 때 예외상황이 발생하였습니다.");
			e2.printStackTrace();
		} finally {
			// close() 메소드를 실행해서 파일을 닫기: IOException 예외상황에 대비하기
			try {
				if(fileReader != null) {
					fileReader.close();
					System.out.println("test.txt 파일을 닫았습니다.");
				}
			} catch(IOException e3){
				System.out.println("test.txt 파일을 닫을 때 예외상황이 발생");
				e3.printStackTrace();
			}
		}
		// 텍스트 파일 내용이 깨져서 나올 때는 텍스트 파일의 인코딩을 UTF-8에서 ANSI로 교체 (다른이름으로 저장에서)
		
		
	}

}
// Text file encoding 확인하는 방법: alt + Enter (커서를 밖에 두고)