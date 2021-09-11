package myjava2;
/*
 * 1. 제목: 이미지 파일을 복사해서 새로운 이미지 파일을 만들기
 * 	1) 소스 파일: 방금 다운로드 한 파일: 이름은 joy.jpg
 * 	2) 목적(새로 만들 파일): 이름은 copy_joy.jpg (+ png가 가장 java에 적합한 이미지 확장자)
 */
import java.io.*;
public class ImageFileCopy {

	public static void main(String[] args) {
		// 2. 소스 파일 이름을 상수화(읽기 용도)
		final String SRC_FINAL_NAME = "joy.jpg";
		// 3. 새로 만들 파일 이름을 상수화
		final String DST_FILE_NAME = "copy_joy.jpg";
		
		// 4. 소스 파일에 접근할 때 사용할 참조 변수를 선언
		FileInputStream fileInputStream = null;
		
		// 5. 새로운 이미지 파일을 만들 때 사용할 참조 변수를 선언
		FileOutputStream fileOutputStream = null;
		
		// 새로 추가(입출력 성능을 개선)
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 6. try~catch~finally 블럭을 작성해서 예외상황에 대비하기
		try {
			// 7. 파일 입력 객체를 생성
			fileInputStream = new FileInputStream(SRC_FINAL_NAME);
			// 8. 파일 출력 객체를 생성
			fileOutputStream = new FileOutputStream(DST_FILE_NAME);
			// 9. 파일에서 가져올 문자를 보관할 변수를 선언
			int data;
			
			// 새로 추가
			bis = new BufferedInputStream(fileInputStream);
			bos = new BufferedOutputStream(fileOutputStream);
			
			// 실제 데이터를 바이트 단위로 보관할 배열을 선언
			byte[] buff = new byte[200]; // 고정방식
			// 가변 방식: 파일에서 데이터를 가져오는 시점에 배열을 결정
			// -> BufferedInputStream 클래스의 available() 메소드를 사용
			//		-> 역할: 현재 파일에서 가녀올 수 있는 데이터의 크기를 바이트 수로 반환
			//			-> 만약 1000을 반환하면 우리가 파일에서 1000바이트 크기의 데이터를 읽어올 수 있음 +
			byte[] buff2 = null; // 현재 크기가 안 만들어짐 -> 동적: 반복문 내에서 파일을 가져옴에 따라 크기 설정 (더 효율적, 낭비X)
			
			// 일 하기 전의 현재 시간을 밀리세컨드 단위로 구하기
			long start = System.currentTimeMillis();
			System.out.println("일을 수행하기 전의 현재 시간은 " + start);
			
			// 10. while 반복문을 사용
			while(true) {
				// 새로 추가된 내용: available() 메소드를 실행해서 파일에서 가져올 수 있는 데이터의 크기를 계산하기
				int size = bis.available();
				if(size == 0) {
					System.out.println();
					break;
				} else {
					System.out.println("파일에서 가져올 수 있는 데이터의 크기는 " + size + "바이트");
					/*
					 * read() 메소드를 호출해서 파일에서 데이터를 가져와서 buff2 배열에 저장
					 */
					buff2 = new byte[size];
					/*
					 * read() 메소드를 반환값으로 실제 파일에서 읽어온 데이터를 바이트수로 돌려줌
					 */
					int real_size = bis.read(buff2);
					System.out.println("파일에서 실제 가져온 데이터의 바이트수는 " + real_size);
					
					/* 
					 * 파일에서 가져온 데이터를 write() 메소드를 사용해서
					 * BufferedOutputStream 객체에 쓰기 
					 */
					bos.write(buff2);
					System.out.println("새로 만들 파일에 데이터를 씀(출력 또는 저장)");
				}
				
//				data = fileInputStream.read();
//				// 11. 파일에서 읽어온 내용이 -1이면 종료
//				if(data == -1) {
//					break;
//				} else {
//					// 12. 파일에서 가져온 데이터를 파일 출력 스트림에 쓰기(저장)
//					fileOutputStream.write(data);
//				}
			}
			System.out.println("이미지 파일 복사 완료");
			
			// 일을 수행한 후의 현재 시간을 밀리세컨드 단위로 구하기
			long end = System.currentTimeMillis();
			System.out.println("일을 수행한 후의 현재 시간은 " + end);
			
			long diff = end - start;
			
			double result = diff / 1000.;
			
			System.out.printf("이미지 파일 복사에 소요된 시간은 %.15f초\n", result);
			
		} catch(FileNotFoundException e1) {
			e1.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				// 종료 순서: 입력 스트림 -> 출력 스트림
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
