package myjava1;
/*
 * 1. 파일 응용 예제 구현: 교재 488의 11번 문제
 * 
 * 실행결과
 * 프로젝트 폴더의 words.txt 파일을 읽었습니다. 
 * 찾을 단어를 입력>>lov
 * love
 * lovebird
 * lovelorn
 * 찾을 단어를 입력>>kitt
 * ++
 */
import java.io.*;
import java.util.*;

public class WordSearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<String> vector = new Vector<String>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null; // try 블럭 바깥에 써야 함
		
		try {
			fileReader = new FileReader("words.txt");
			// 1. while() 반복문을 사용해서 words.txt 파일에서 한글자씩 읽어오기
			// -> 한 줄씩 읽어오기 위해서는 BufferedReader 클래스를 사용
			bufferedReader = new BufferedReader(fileReader);
			
			// 2. 파일에서 읽어온 한 줄 문자열을 보관할 변수를 선언
			String line = "";
			while(true) {
				line = bufferedReader.readLine();
				if(line == null) {   // 주소 값이 없음
					System.out.println("더 이상 파일에서 읽어올 내용이 없습니다.(주소가 없습니다.)");
					break;
				} else {
					if(line.isEmpty()) {   // 내용이 없음
						System.out.println("한 줄에서 값이 없습니다.");
					} else {
						vector.add(line);
//						System.out.println("벡터에 단어를 저장함");
					}
				}
			}
			// while 반복문을 종료한 후에 벡터에 저장된 모든 단어들을 가져와서 출력하기
			Iterator<String> iterator = vector.iterator(); // Iterator: 반복자로, 인덱스 없이 접근하는 방식
//			while(iterator.hasNext() == true) {
//				String word = iterator.next();
//				System.out.println("벡터에서 가져온 단어는 "+word);
//			}
			
			// 단어의 갯수를 출력하기
//			System.out.println("단어의 갯수는 "+ vector.size());
			
			// while 반복문을 사용해서 사용자가 "그만"을 입력하기 전까지 계속해서 
			// 사용자로부터 검색할 단어를 입력받아서 결과를 출력
			while(true) {
				
				System.out.print("검색할 단어를 입력(중단하시려면 그만)>> ");
				String findWord = scanner.nextLine();
				while(findWord.isEmpty()) {
					System.out.print("꼭! 단어 또는 그만을 입력하세요: ");
					findWord = scanner.nextLine();
				}
				System.out.println("사용자가 입력한 찾을 단어는 " + findWord);
				
				/*
				 * 사용자가 입력한 단어가 벡터에 저장되어 있는지를 찾아보는 반복문을 입력
				 */
				
				// 사용자가 그만을 입력하면 반복문을 종료
				if(findWord.equals("그만")) {
					System.out.println("검색을 중단합니다.");
					break;
				} else {
					iterator = vector.iterator();
					boolean find = false;
					while(iterator.hasNext()) {
						String word = iterator.next();
						if(word.startsWith(findWord)) {
							System.out.println(word);
							find = true;
						} else if(word.startsWith(findWord) == false) {
							continue;
						}
					}
					if(find == false) {
						System.out.println("찾으시는 단어가 없습니다.");
					}
				}
			}
			
		} catch(FileNotFoundException e1){
			e1.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
		}finally {
			try {
				if(bufferedReader != null) {
					bufferedReader.close();  // bufferedReader 클로즈 하면 연쇄적으로 (내부적으로 연결되어 있는) fileReader도 종료됨
				}
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
		
		
	}
}
