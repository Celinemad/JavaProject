package myjava01;
/*
 * 1. ������� ������ �۾� ���
 * 1) MySQL DBMS ��ġ
 * 2) MySQL DBMS Server ȯ�� ����
 * ��. root �����(������)�� �Ϲ� ������� user1�� ���� + ������ ���ӵ� ���� 
 *     -> MySQL Workbench ���α׷��� ����ؼ� ����
 * ��. �ڹ� ���α׷����� ������ �����ؼ� SQL ��ɾ� ���� �ϳ��� select ��ɾ �����ϰ� ����� �ܼ� ȭ�鿡 ���
 * a. select ��ɾ��? ���� �����ͺ��̽��� ����Ǿ� �ִ� �����͵��� �˻��ؼ� ���ϴ� �����͵��� �������� ��ɾ�
 *     - ����: select(��ҹ��� �������� ����) �÷���(id �Ǵ� name �Ǵ� dept) from ���̺��
 *     - ��: student ���̺� ����Ǿ� �ִ� 3���� ���ڵ�(��)�� �������� select ��ɾ�
 *         - select id,name,dept from student
 *             - ������: 
 *             id �÷��� name �÷��� dept �÷���
 *             ��1      ��2        ��3 
 *             ��4      ��5        ��6 
 *             ��7      ��8        ��9 
 * ���� ���� ���� ����� ��� ���ؼ� ������ �۾� ����
 * 1. JDBC Driver Ŭ���� ���̺귯���� ���� ������Ʈ�� �߰��ϱ�
 *     - MySQL DBMS�� ��ġ�� �� �Բ� ��ġ�� Connector/J ���α׷����� ��ġ
 *         - ���� ���: C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.25.jar
 *         
 * 2. JDBC Driver Ŭ������ ����ϴ� ��ɾ �ۼ�
 *     - main() �޼ҵ� ���ο� �Ʒ� ��ɾ �Է�
 *         - try {
 *             // �Ʒ� ��ɾ�� JDBC Driver Ŭ������ Driver�� ����ؼ� MySQL �����ͺ��̽��� ������ �� ����� ��ü�� ����
 *             // ��� ���� �߰��� mysql-connector-java-8.0.25.jar ���� �ȿ� ����
 *             java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
 *             // ���� �޽����� ����ϱ�
 *             System.out.println("MySQL �����ͺ��̽��� ������ �� ����� ��ü�� ����");
 *         } catch(Exception ����ó��������) {
 *             ����ó��������.printStackTrace();
 *         }
 *         
 * 3. ���� MySQL �����ͺ��̽��� �����ϴ� ��ɾ �ۼ�
 * 1) �˾ƾ� �� ������
 * ��. �����̸�(��ǻ���̸�) �Ǵ� ������ �ּ�: ��) localhost(���� + ȣ��Ʈ: �ڱ� �ڽ��� ��ǻ�� �̸�)
 *    , ������ �ּ�: 127.0.0.1
 * ��. �����ͺ��̽� �̸�: sampledb
 * ��. ���� ���ڵ�(MySQL 8.0 ���� �߰� ��) characterEncoding=�������ڵ�
 *     -> ���� ��) characterEncoding=euckr
 * ��. ���� �ð� ����: ��) serverTimezone=�ð�
 *     -> �ð��� ���� ǥ�� �ð��� UTC�� ���
 *     -> ���� ��) serverTimezone=UTC
 * ������ �ۼ��� 4���� �������� �ϳ��� ���ڿ��� �����ϱ�
 *     - String url = jdbc://������ǻ���̸� �Ǵ� �������ּ�/��Ű���̸�?characterEncoding=�������ڵ�&serverTimezone=�ð�
 *     
 * ��. MySQL �����ͺ��̽��� ������ �� ����� ����� ���� �̸�: String userID = "user1";
 * ��. MySQL �����ͺ��̽��� ������ �� ����� ����� ������ ��й�ȣ: String pwd = "1234";
 * ��. DriverManager Ŭ������ getConnection() �޼ҵ带 ȣ���ϱ�
 *     -> try~catch �� ���ο� �ۼ�
 *     -> Connection mysql_����_���ắ���� = DriverManager.getConnection(url, userID, pwd);
 */

import java.sql.DriverManager;

public class TestMySQL {

	public static void main(String[] args) {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL �����ͺ��̽��� ������ �� ����� ��ü�� ����");
			java.sql.Connection conn = 
			DriverManager.getConnection("jdbc:mysql://localhost/sampledb?characterEncoding=euckr&serverTimezone=UTC", "user1", "1234");
			// MySQL �����ͺ��̽��� ������ �����Ǿ��� �� ������ ��ɾ �ۼ�
			/*
			 * select sql ��ɾ ����ؼ� student ���̺� ����Ǿ� �ִ� ��� �����͵��� �����ͼ� ȭ�鿡 ����ϱ�
			 * 1. java.sql ��Ű���� �ִ� Statement Ŭ������ ����ؼ� ���ο� ��ü�� ����
			 *     -> ����: select sql ��ɾ �޸𸮿� ����
			 *     -> ����) java.sql.Statement ������ = ���ắ����.createStatement();
			 *     -> ��) java.sql.Statement st = conn.createStatement();
			 *     
			 * 2. select sql ��ɾ �����ϴ� ��ɾ �ۼ�
			 *     - ����) Statement Ŭ������ executeQuery() �޼ҵ带 ȣ��
			 *         - java.sql.ResultSet ������ = Statement_��ü_����������.executeQuery("select sql ��ɾ �ۼ�");
			 *     - ��) java.sql.ResultSet rs = st.executeQuery("select id, name, dept from student");
			 *     - ResultSet: select sql ��ɾ��� ����� ǥ(���̺�) ������ ���� �������ִ� Ŭ����
			 *         -> ù ���� ���ڵ�� ù ��° �࿡ ����
			 *         -> �� ��° ���ڵ�� �� ��° �࿡ ����
			 *         -> �� ��° ���ڵ嵵 �� ��° �࿡ ����
			 *         
			 * 3. ResultSet Ŭ������ �����Ǿ� �ִ� 3���� ���� �����ͼ� �ܼ� ȭ�鿡 ����ϴ� ��ɾ �ۼ�
			 *     - ����) while(ResultSet Ŭ������ next() �޼ҵ带 ȣ���ؼ� �ڹ� �÷����� �ݺ����� Iterator�� ���� ������ ����: hasNext())
			 *            ������ �����ϰ� �� -> ������ ���� �ִ����� �˻��ؼ� �ִ� ���� true�� ��ȯ, ���� ������ false�� ��ȯ)
			 *     - ��) while(rs.next() == true) {
			 *              // ResultSet���� ���� ���� �������� �޼ҵ�� get+���������ڷ���("�÷���") �Ǵ� get+���������ڷ���(�÷�����ġ��ȣ:1���� ����)
			 *              //     - ���� ������ �������� �ڷ����� ���ڿ��� ��쿡�� String ������ = getString("id");
			 *              //         - id, name, dept �÷��� ���� �� char(), varchar() �ڷ����� ����� ���
			 *              String idValue = rs.getString("id");
			 *              String nameValue = rs.getString("name");
			 *              String deptValue = rs.getString("dept");
			 *              System.out.println("student ���̺��� ������ �л��� ���̵� ���� " 		+ idValue);
			 *              System.out.println("student ���̺��� ������ �л��� �л��� �̸� ���� " 	+ nameValue);
			 *              System.out.println("student ���̺��� ������ �л��� �а�(����) ���� " 	+ deptValue);
			 *          }
			 */
			java.sql.Statement st = conn.createStatement();
			java.sql.ResultSet rs = st.executeQuery("select id,name,dept from student");
			while(rs.next() == true) {
				String idValue = rs.getString("id");
				String nameValue = rs.getString("name");
				String deptValue = rs.getString("dept");
				System.out.println("student ���̺��� ������ �л��� ���̵� ���� " + idValue);
				System.out.println("student ���̺��� ������ �л��� �л��� �̸� ���� " 	+ nameValue);
				System.out.println("student ���̺��� ������ �л��� �а�(����) ���� " 	+ deptValue);
			}
			
			System.out.println("MySQL �����ͺ��̽��� ���� ����");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
