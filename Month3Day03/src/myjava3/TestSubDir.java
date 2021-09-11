package myjava3;
/*
 * 1. 제목: 서브 디렉토리의 모든 내용을 출력하는 예제
 */
import java.io.*;
public class TestSubDir {

	public static void main(String[] args) {
		
		// 2. 파일 참조 변수들을 선언
		// 1) File 클래스를 사용해서 파일 또는 디렉토리에 접근할 때 사용
		File file = new File("C:\\celinetxt");
		// 2) celinetxt 폴더 안에 있는 모든 파일(디렉토리)들을 읽어와서 File[] 배열 객체로 반환
		// -> File 클래스에 있는 listFiles() 메소드를 사용
		// -> 형식) File[] 배열명 = file.listFiles();
		File[] arrFile = file.listFiles();
		
		// 3. try~catch 블럭만 작성(finally에 close() 메소드 안써도 됨)
		//		: 이유는 File 클래스에서는 close() 메소드를 지원하지 않음(finally는 작성하지 않음)
		try {
			// 4. if 조건문을 사용해서 파일(디렉토리)의 갯수를 검사하기
			if(arrFile.length == 0) {
				System.out.println("celinetxt 폴더 안에는 파일이 하나도 없습니다.");
			} else {
				System.out.println("celinetxt 폴더 안에 있는 파일(폴더)의 갯수는 " + arrFile.length);
				// for 반복문을 사용해서 파일과 디렉토리에 접근해서 이름과 파일의 크기(용량)을 출력하기
				for(int i=0; i<arrFile.length; i++) {
					String name = arrFile[i].getName();
					System.out.println("파일(디렉토리)의 이름은 " + name);
					long size = arrFile[i].length();
					System.out.println("파일(디렉토리)의 크기(바이트수)는 " + size + "바이트");
					// 파일인지 검사하기
					boolean chkFile = arrFile[i].isFile();
					if(chkFile == true) {
						System.out.println("파일입니다.");
					}
					// 디렉토리인지 검사하기
					boolean chkDir = arrFile[i].isDirectory();
					if(chkDir == true) {
						System.out.println("디렉토리입니다.");
					}
				}
				// createNewFile() 메소드를 사용해서 celinetxt 폴더 안에 특정 파일이 있는지 검사하고 
				// 없으면 파일을 만들기
				// -> 파일의 유무를 판단하기 위해서는 exists() 메소드를 사용
				//		-> 형식) boolean 변수명 = 파일참조변수명.exists();
				File newFile = new File("C:\\celinetxt\\test3.txt");
				boolean chkFile = newFile.exists();
				if(chkFile == true) {
					System.out.println("test3.txt 파일이 존재합니다.");
				} else {
					boolean result = newFile.createNewFile();
					if(result == true) {
						System.out.println("test3.txt 파일이 없어서 새로 만듬");
					} else {
						System.out.println("test3.txt 파일 생성 실패");
					}
				}
			}
			
		} catch(IOException e) {
			System.out.println("예외상황이 발생");
			e.printStackTrace();
		}
		
		
	}

}
