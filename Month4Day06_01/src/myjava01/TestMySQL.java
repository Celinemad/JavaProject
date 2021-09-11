package myjava01;
/*
 * 1. 현재까지 수행한 작업 목록
 * 1) MySQL DBMS 설치
 * 2) MySQL DBMS Server 환경 설정
 * 가. root 사용자(관리자)와 일반 사용자인 user1을 생성 + 서버에 접속된 상태 
 *     -> MySQL Workbench 프로그램을 사용해서 수행
 * 나. 자바 프로그램에서 서버에 접속해서 SQL 명령어 중의 하나인 select 명령어를 수행하고 결과를 콘솔 화면에 출력
 * a. select 명령어란? 현재 데이터베이스에 저장되어 있는 데이터들을 검색해서 원하는 데이터들을 가져오는 명령어
 *     - 형식: select(대소문자 구분하지 않음) 컬럼명(id 또는 name 또는 dept) from 테이블명
 *     - 예: student 테이블에 저장되어 있는 3개의 레코드(행)를 가져오는 select 명령어
 *         - select id,name,dept from student
 *             - 실행결과: 
 *             id 컬럼명 name 컬럼명 dept 컬럼명
 *             값1      값2        값3 
 *             값4      값5        값6 
 *             값7      값8        값9 
 * 위와 같은 실행 결과를 얻기 위해서 수행할 작업 절차
 * 1. JDBC Driver 클래스 라이브러리를 현재 프로젝트에 추가하기
 *     - MySQL DBMS를 설치할 때 함께 설치된 Connector/J 프로그램에서 설치
 *         - 저장 경로: C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.25.jar
 *         
 * 2. JDBC Driver 클래스를 사용하는 명령어를 작성
 *     - main() 메소드 내부에 아래 명령어를 입력
 *         - try {
 *             // 아래 명령어는 JDBC Driver 클래스인 Driver를 사용해서 MySQL 데이터베이스에 접속할 때 사용할 객체를 생성
 *             // 방금 전에 추가한 mysql-connector-java-8.0.25.jar 파일 안에 존재
 *             java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
 *             // 성공 메시지를 출력하기
 *             System.out.println("MySQL 데이터베이스에 접속할 때 사용할 객체를 생성");
 *         } catch(Exception 예외처리변수명) {
 *             예외처리변수명.printStackTrace();
 *         }
 *         
 * 3. 실제 MySQL 데이터베이스에 접속하는 명령어를 작성
 * 1) 알아야 할 정보들
 * 가. 서버이름(컴퓨터이름) 또는 아이피 주소: 예) localhost(지역 + 호스트: 자기 자신의 컴퓨터 이름)
 *    , 아이피 주소: 127.0.0.1
 * 나. 데이터베이스 이름: sampledb
 * 다. 문자 인코딩(MySQL 8.0 부터 추가 예) characterEncoding=문자인코딩
 *     -> 실제 예) characterEncoding=euckr
 * 라. 서버 시간 영역: 예) serverTimezone=시간
 *     -> 시간은 세계 표준 시간인 UTC를 사용
 *     -> 실제 예) serverTimezone=UTC
 * 위에서 작성한 4개의 정보들을 하나의 문자열로 연결하기
 *     - String url = jdbc://서버컴퓨터이름 또는 아이피주소/스키마이름?characterEncoding=문자인코딩&serverTimezone=시간
 *     
 * 마. MySQL 데이터베이스에 접속할 때 사용할 사용자 계정 이름: String userID = "user1";
 * 바. MySQL 데이터베이스에 접속할 때 사용할 사용자 계정의 비밀번호: String pwd = "1234";
 * 사. DriverManager 클래스의 getConnection() 메소드를 호출하기
 *     -> try~catch 블럭 내부에 작성
 *     -> Connection mysql_접속_연결변수명 = DriverManager.getConnection(url, userID, pwd);
 */

import java.sql.DriverManager;

public class TestMySQL {

	public static void main(String[] args) {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL 데이터베이스에 접속할 때 사용할 객체를 생성");
			java.sql.Connection conn = 
			DriverManager.getConnection("jdbc:mysql://localhost/sampledb?characterEncoding=euckr&serverTimezone=UTC", "user1", "1234");
			// MySQL 데이터베이스에 접속이 성공되었을 때 실행할 명령어를 작성
			/*
			 * select sql 명령어를 사용해서 student 테이블에 저장되어 있는 모든 데이터들을 가져와서 화면에 출력하기
			 * 1. java.sql 패키지에 있는 Statement 클래스를 사용해서 새로운 객체를 생성
			 *     -> 역할: select sql 명령어를 메모리에 보관
			 *     -> 형식) java.sql.Statement 변수명 = 연결변수명.createStatement();
			 *     -> 예) java.sql.Statement st = conn.createStatement();
			 *     
			 * 2. select sql 명령어를 실행하는 명령어를 작성
			 *     - 형식) Statement 클래스의 executeQuery() 메소드를 호출
			 *         - java.sql.ResultSet 변수명 = Statement_객체_참조변수명.executeQuery("select sql 명령어를 작성");
			 *     - 예) java.sql.ResultSet rs = st.executeQuery("select id, name, dept from student");
			 *     - ResultSet: select sql 명령어의 결과를 표(테이블) 구조를 만들어서 저장해주는 클래스
			 *         -> 첫 번재 레코드는 첫 번째 행에 저장
			 *         -> 두 번째 레코드는 두 번째 행에 저장
			 *         -> 세 번째 레코드도 세 번째 행에 저장
			 *         
			 * 3. ResultSet 클래스에 보관되어 있는 3개의 행을 가져와서 콘솔 화면에 출력하는 명령어를 작성
			 *     - 형식) while(ResultSet 클래스의 next() 메소드를 호출해서 자바 컬렉션의 반복자인 Iterator와 내부 동작이 동일: hasNext())
			 *            수행을 동일하게 함 -> 가져올 값이 있는지를 검사해서 있는 경우는 true를 반환, 값이 없으면 false를 반환)
			 *     - 예) while(rs.next() == true) {
			 *              // ResultSet에서 실제 값을 가져오는 메소드는 get+데이터의자료형("컬럼명") 또는 get+데이터의자료형(컬럼의위치번호:1부터 시작)
			 *              //     - 만약 가져올 데이터의 자료형이 문자열인 경우에는 String 변수명 = getString("id");
			 *              //         - id, name, dept 컬럼을 만들 때 char(), varchar() 자료형을 사용한 경우
			 *              String idValue = rs.getString("id");
			 *              String nameValue = rs.getString("name");
			 *              String deptValue = rs.getString("dept");
			 *              System.out.println("student 테이블에서 가져온 학생의 아이디 값은 " 		+ idValue);
			 *              System.out.println("student 테이블에서 가져온 학생의 학생의 이름 값은 " 	+ nameValue);
			 *              System.out.println("student 테이블에서 가져온 학생의 학과(전공) 값은 " 	+ deptValue);
			 *          }
			 */
			java.sql.Statement st = conn.createStatement();
			java.sql.ResultSet rs = st.executeQuery("select id,name,dept from student");
			while(rs.next() == true) {
				String idValue = rs.getString("id");
				String nameValue = rs.getString("name");
				String deptValue = rs.getString("dept");
				System.out.println("student 테이블에서 가져온 학생의 아이디 값은 " + idValue);
				System.out.println("student 테이블에서 가져온 학생의 학생의 이름 값은 " 	+ nameValue);
				System.out.println("student 테이블에서 가져온 학생의 학과(전공) 값은 " 	+ deptValue);
			}
			
			System.out.println("MySQL 데이터베이스에 접속 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
