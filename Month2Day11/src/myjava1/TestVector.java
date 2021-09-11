package myjava1;
/*
 * 1. 제목: Vector 컬렉션 클래스를 사용하기
 */
import java.util.*;
public class TestVector {

	public static void main(String[] args) {
		/*
		 * 2. 사용자에게 메뉴를 보여주기
		 * 	1) 제목을 출력: ***Vector 클래스 예제***
		 * 	2) 아래 줄에는: 1. 객체 입력(저장)  2. 객체 검색(찾기)  3. 객체 삭제  4. 객체 출력  5. 종료
		 */
		Scanner scanner = new Scanner(System.in);
		// 3. 벡터 객체를 생성
		Vector<String> vector = new Vector<String> ();
		// 4. while 반복문을 사용해서 무한 반복문을 만들기
		while(true) {
			// 5. 메뉴를 출력
			System.out.println("1. 객체 입력(저장)  2. 객체 검색(찾기)  3. 객체 삭제  4. 객체 출력  5. 종료");
			// 6. 사용자로부터 메뉴 번호를 입력 받기
			int menu = Integer.parseInt(scanner.nextLine());
			// 7. 사용자가 5를 입력하면 프로그램을 종료
			if (menu==5) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			// 8. 사용자가 1을 입력하면 새로운 문자열 객체를 생성해서 컬렉션에 추가
			else if(menu == 1) {
				System.out.println("새로운 문자열 객체를 입력 받습니다...");
				System.out.print("당신의 이름을 입력하세요: ");
				String inputName = scanner.nextLine();
				while(inputName.isEmpty()) {
					// 사용자가 이름을 입력하지 않고 엔터키를 누른 경우
					System.out.println("이름을 입력하지 않았습니다. 꼭! 입력하세요: ");
					inputName = scanner.nextLine();
				}
				System.out.println("반복문을 종료한 뒤에는 사용자가 입력한 이름을 출력");
				System.out.println("사용자가 입력한 이름은 "+ inputName);
				vector.add(inputName);
				System.out.println("사용자가 입력한 이름을 벡터에 추가했습니다.");
				System.out.println("벡터의 현재 크기는 "+ vector.size());
				System.out.println("벡터의 내부 배열 크기는 "+ vector.capacity());
			}
			
			// 9. 사용자가 2를 입력하면 객체 검색하기
			else if(menu == 2) {
				System.out.println("컬렉션에 저장된 객체를 찾습니다...");
				// 10. 먼저 컬렉션에 객체가 있는지를 확인하기
				if(vector.isEmpty()) {
					System.out.println("현재 입력된 객체가 하나도 없습니다...");
				} else {
					// 11. 찾을 사람 이름을 입력 받기
					System.out.print("찾을 사람 이름을 입력하세요: ");
					String findName = scanner.nextLine();
					while(findName.isEmpty()) {
						System.out.print("다시 찾을 사람 이름을 입력하세요: ");
						findName = scanner.nextLine();
					}
					System.out.println("찾을 사람 이름은 " + findName);
					// 12. for 반복문을 사용해서 컬렉션에서 사용자가 입력한 이름을 찾기
					for(int i=0; i < vector.size(); i++) {
						String value = vector.get(i);
						if(value.equals(findName)) {
							System.out.println("찾았습니다!!");
						}
					}
					// 13. contains() 메소드를 사용해서 이름 검색
					boolean resultFind = vector.contains(findName);
					if(resultFind == true) {
						System.out.println("찾았습니다!!");
					} else {
						System.out.println("찾지 못했습니다!!");
					}
				} // if(vector.isEmpty())의 else 블럭의 끝
			} // else if(menu==2) 블럭의 끝
			// 사용자가 메뉴 번호 3을 입력한 경우
			else if(menu == 3) {
				System.out.println("객체를 찾아서 삭제합니다...");
				if(vector.isEmpty()) {
					System.out.println("삭제할 객체가 하나도 없습니다...");
				} else {
					System.out.println("삭제할 객체가 존재합니다");
					System.out.print("삭제할 사람 이름을 입력하세요:");
					String delName = scanner.nextLine();
					while (delName.isEmpty()) {
						System.out.print("꼭! 삭제할 사람 이름을 입력하세요: ");
						delName = scanner.nextLine();
					}
					System.out.println("삭제할 사람 이름은 "+ delName);
					boolean resultDel = vector.remove(delName);
					if (resultDel == true) {
						System.out.println("삭제 성공!!");
					} else {
						System.out.println("삭제 실패!!");
					}
					System.out.println("내부 배열의 저장된 객체의 갯수는 "+ vector.size());
				}
			}
			// 사용자가 메뉴 번호 4를 입력한 경우
			else if(menu == 4) {
				System.out.println("컬렉션이 갖고 있는 모든 객체들을 출력합니다...");
				if(vector.isEmpty()) {
					System.out.println("입력된 객체가 하나도 없습니다...");
				}else {
					System.out.println("입력된 객체의 갯수는 "+ vector.size());
					for(int i=0; i<vector.size(); i++) {
						String value = vector.get(i);
						System.out.println("인덱스 번호는 "+ i + ", 이름은 "+ value);
					}
					Iterator<String> iterator = vector.iterator();
					while(iterator.hasNext() == true) {
						String value = iterator.next();
						System.out.println("이름은 " + value);
					}
					System.out.println("벡터 객체의 내부 배열의 용량은 "+ vector.capacity());
				}
			}
			
		}  // while(true) 블럭의 끝
		// while 반복문을 종료한 뒤에는 스캐너 클래스를 종료하기
		scanner.close();
		
	}

}
