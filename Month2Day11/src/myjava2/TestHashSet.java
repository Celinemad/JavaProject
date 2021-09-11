package myjava2;
/*
 * 1. 제목: HashSet 클래스를 사용해서 중복이 없는 로또 번호들을 6개 만들기
 * 		1) 난수를 생성: java.util.Random 클래스를 사용(정수)
 */
import java.util.*;
public class TestHashSet {

	public static void main(String[] args) {
		// 2. 로또 번호를 생성할 때 사용할 객체를 생성
		Random random = new Random();
		
		// 3. 중복 없는 6개의 로또 번호를 보관할 HashSet 객체를 생성
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		// 4. while 반복문을 사용해서 총 6개의 로또 번호를 만들고 hashSet 객체에 저장하기
		while(hashSet.size() != 6) {
			
			// 5. 로또 번호를 생성하기: 1 ~ 45 사이에 있는 임의의 정수를 생성해서 int 자료형에 저장하기
			int no = random.nextInt(45) + 1;
			
			// 6. HashSet 클래스가 갖고 있는 add() 메소드를 실행해서 정수를 입력
			// 		-> 중복 검사를 위해서 if 조건문을 사용
			boolean result = hashSet.add(no);
			if(result == true) {
				System.out.println("새로운 정수가 해시세트 객체에 저장됨");
			} else {
				System.out.println("중복되어 저장되지 않음");
			}
			System.out.println("현재까지 해시세트에 저장된 로또 번호의 갯수는 " + hashSet.size());
		}
		// while 반복문을 벗어난 위치에서 6개의 로또 번호들을 출력
		Object[] lottoNo = hashSet.toArray();
		String str = Arrays.toString(lottoNo);
		System.out.println("총 6개의 로또 번호들은 "+ str);
		
		
		/*
		 * HashSet 클래스에 있는 6개의 로또 번호들을 정렬하기
		 * 1) TreeSet 클래스의 생성자를 사용하기: TreeSet(Collection) 
		 * 	-> 객체 생성 형식: TreeSet<데이터타입> 참조변수명 = new TreeSet<데이터타입>(해시세트참조변수명);
		 */
		TreeSet<Integer> treeSet = new TreeSet<Integer>(hashSet);
		System.out.println(treeSet);
	}

}
