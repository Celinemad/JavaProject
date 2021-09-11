package myjava1;
/*
 * 1. ���α׷� ����: FileDialog Ŭ������ ����� ���� ����� ���� ���� ����
 * 	-> AWT GUI ���̺귯���� ����ϱ�
 * 		-> import java.awt.*;
 * 		-> import java.awt.event.*;
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
//���� ���õ� Ŭ������ �������̽��� ���
import java.io.*;

// 2. Frame Ŭ������ ��� �޴� MyFrame Ŭ������ ����
class MyFrame extends Frame implements ActionListener {
	
	// 4. ������ �����쿡 ��¿� ����� ��ü���� �����ϱ�
	// 1) TextArea Ŭ������ ����� ��ü�� ����: �뵵�� ����ڰ� ���Ͽ� ������ ���� ���� �ؽ�Ʈ�� �Է��ϰų�
	// 	  ������ ������ ȭ�鿡 ���
	private TextArea m_ta = new TextArea();
	
	// 2) ScrollPane Ŭ������ ����� ��ü�� ����: �뵵�� TextArea�� �����ʰ� �Ʒ��ʿ� ��ũ�ѹٸ� ���
	private ScrollPane m_sp = new ScrollPane();
	
	// 3) ���� ���� ��ư�� ����� Button ��ü�� ���� (file open)
	private Button m_fo = new Button("���� ����");
	
	// 4) ���� ���� ��ư�� ����� Button ��ü�� ����
	private Button m_fs = new Button("���� ����");
	
	// 5) ���̾ƿ� ������ ������ ������ GridLayout Ŭ������ ����� ��ü�� ����: ���� ������ 3, ���� ������ 1
	private GridLayout m_gl = new GridLayout(3,1);
	
	// awt�� �����̳� �ʿ� ���� �׳� add�ϸ� ��.
	// 6) �����ڸ� ����
	public MyFrame(String title) {
		// 7) �������� ���� ���ڿ� ����
		super(title);
		// 8) ������ �������� �⺻ ���̾ƿ� �����ڸ� GridLayout���� �����ϱ�
		setLayout(m_gl);
		// 9) ScrollPane�� TextArea�� �ֱ�
		m_sp.add(m_ta);
		// 10) ScrollPane ��ü�� ù ���� �࿡ �ֱ�
		add(m_sp);
		
		// ��ư�� actionPerformed() �޼ҵ带 �����ϱ�
		m_fo.addActionListener(this);
		m_fs.addActionListener(this);
		
		// 11) ���� ���� ��ư ��ü�� �� ��° �࿡ �ֱ�
		add(m_fo);
		// 12) ���� ���� ��ư ��ü�� �� ��° �࿡ �ֱ�
		add(m_fs);
		// 13) ������ ���� �̺�Ʈ ó�� ���
		/*
		 * 1. WindowListener �������̽��� ���: 7���� �߻� �޼ҵ带 �������ؾ� ��
		 * 2. WindowAdpater Ŭ������ ���: �ʿ��� �޼ҵ常 �������ϸ� ��
		 * 	1) �ܺο� ���ο� Ŭ������ ����
		 * 		- ����) class Ŭ������ extends WindowAdapter {
		 * 			       // ����ڰ� X ��ư�� ������ �� ������ windowClosing() �޼ҵ带 ������
		 * 			   }
		 *  		   Ŭ������ ����ϱ� ���� ��ü�� ����: private Ŭ������ ������ = new  Ŭ������();
		 *  		   addWindowListener(������);
		 *  
		 * 	2) �͸� ��ü�� ����(�̸��� ���� Ŭ������ ����)
		 * 		- ����) addWindowListener (
		 * 			       new WindowAdapter() {
		 * 				       @Override
		 * 				       public void windowClosing(WindowEvent �̺�Ʈó��������) {
		 * 				       System.exit(0);
		 * 				       }
		 * 				   }
		 *             );
		 * 		- Ư¡: �����쿡 �ٷ� �̺�Ʈ ó�� �ڵ鷯�� ���̴� ���(�ڵ鷯�� �ѹ��� ����ϴ� ���)
		 */
		// �͸� ��ü(�̸��� ���� ��ü)�� ����
		addWindowListener(new WindowAdapter() {
			// windowClosing() �޼ҵ带 ������
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("����ڰ� �������� X ��ư�� Ŭ����");
				System.out.println("���α׷��� ������");
				System.exit(0);
			}
		});
		// setSize() �޼ҵ带 ����ؼ� �������� ����ũ��� ����ũ�⸦ ���ϱ�
		setSize(500,500);
		// setResizable() �޼ҵ带 ����ؼ� ����ڰ� �������� ũ�⸦ �ٲ��� ���ϵ��� �ϱ�
		setResizable(false);
		// setVisible() �޼ҵ带 ����ؼ� �����츦 ȭ�鿡 ����ϱ�
		setVisible(true);
	}
	
	// 3. actionPerformed() �޼ҵ带 ������
	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ڰ� ���� ���� ��ư�� Ŭ������ �� ������ ��ɾ���� �ۼ��ϱ�
		Button clickedButton = (Button)e.getSource();
		
		if(clickedButton == m_fs) {
			System.out.println("����ڰ� ���� ���� ��ư�� Ŭ����");
			String tempString = m_ta.getText();
			if(tempString.isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "���Ͽ� ������ ������ ��! �Է��ϼ���!");
				m_ta.setFocusable(true);
				m_ta.requestFocus();
				return;
			} else {
				FileDialog fd = new FileDialog(this, "���� ���� â", FileDialog.SAVE);
				fd.setVisible(true);
				/*
				 * ����ڰ� ���� ���� â���� ���� �̸��� �Է��ϰ� ���� ��ư�� Ŭ���� ����� �̺�Ʈ ó�� ���
				 * 	1) ���� �̸��� Ȯ���ڰ� .txt�� ����: ��) myfile01.txt
				 * 	2) ���α׷����� ����ڰ� �Է��� ���Ͽ� �����ϱ�
				 * 		-> ����ڰ� ���� ��ư�� ������ �ʰ� ��� ��ư�� ���� ����� �̺�Ʈ ó���� ���� �ۼ��ؾ� ��
				 * 			-> ���� ���(�ʿ� ���� ��ɵ��� ���� �Ÿ��� �۾�)�� �ٸ� ��ɺ��� ���� �ۼ��ؾ� ��
				 * 		-> FileDialog Ŭ������ getFile() �޼ҵ带 ���
				 * 			-> ����) String ������ = fd.getFile();
				 * 			-> if(������ == null) {
				 * 			       // ����ڰ� ��� ��ư�� ���� ��쿡 ������ ��ɾ���� �ۼ�
				 * 				   JOptionPane.showMessageDialog(null, "��� ��ư�� ����");
				 * 				   return;
				 * 			   } else {
				 * 				   // ����ڰ� ���� ��ư�� ���� ��쿡�� ����ڰ� �Է��� ������ �̸��� ������
				 * 				   // ����� ������ ��ü ��θ� �о�;� �մϴ�.
				 * 				   // 1) ������ ������ ��ü ���: FileDialog Ŭ������ getDirectory() �޼ҵ带 ���
				 * 				   // -> ����) String ������ = fd.getDirectory();
				 * 				   // 2) ����ڰ� �Է��� ������ �̸�: FileDialog Ŭ������ getFile() �޼ҵ带 ���
				 * 				   // -> ����) String ������ = fd.getFile();
				 * 				   // 3) File Ŭ������ exists() �޼ҵ带 ����ؼ� ����ڰ� �Է��� ������ �ִ����� �˻��ϱ�
				 * 				   // -> ����) File ������3 = new File(������1+������2);
				 * 				   // 4) exists() �޼ҵ带 �����ϱ�
				 * 				   // -> ����) boolean ������4 = ������3.exists();
				 * 				   // if(������4 == true) { // ������ �ִ� ��� }
				 * 				   // else { // ������ ���� ��� }		
				 * 			   }
				 */
				String selectedFile = fd.getFile();
				if(selectedFile == null) {
					JOptionPane.showMessageDialog(null, "����ڰ� ��� ��ư�� ����");
					return;
				} else {
					System.out.println("����ڰ� ���� ��ư�� ����");
					if(selectedFile.isEmpty()) {
						JOptionPane.showMessageDialog(null, "���� �̸��� �Է����� ����");
						return;
					} else {
						System.out.println("����ڰ� �Է��� ���� �̸��� " + selectedFile);
						System.out.println("������ ����(����) ��δ� " + fd.getDirectory());
						
						// ����ڰ� �Է��� ������ �ִ����� �˻��ϱ�
						File tempFile = new File(fd.getDirectory() + selectedFile);
						// exists() �޼ҵ带 �����ϱ�
						boolean chkFile = tempFile.exists();
						if(chkFile == true) {
							JOptionPane.showMessageDialog(null, "������ ����");
							return;
						} else {
							System.out.println(selectedFile + " ������ �����ϱ�");
							// ���� ������ ����� ��ü���� ����
							FileWriter tempfw = null;
							BufferedWriter tempbw = null;
							// ���ܻ�Ȳ�� �غ��ϱ� ���� try~catch~finally ���� �ۼ�
							try {
								tempfw = new FileWriter(tempFile);
								tempbw = new BufferedWriter(tempfw);
								// ����ڰ� �Է��� �ؽ�Ʈ���� ���Ͽ� �����ϱ�: BufferedWriter Ŭ������
								// write() �޼ҵ带 ����
								tempbw.write(tempString);
								System.out.println(selectedFile + " ������ �����ϰ� �ؽ�Ʈ ���� �Ϸ�");
							} catch(IOException e1) {
								JOptionPane.showMessageDialog(null, "���� ���� ����");
							} catch(Exception e2) {
								JOptionPane.showMessageDialog(null, "�Ϲ� ����");
							} finally {
								try {
									// ��Ʈ��ũ ������ BufferedReader�� �ݱ�
//									if(tempfw != null) tempfw.close(); 
									if(tempbw != null) tempbw.close();
									System.out.println("���� �ݱ� �Ϸ�");
								} catch(IOException e3) {
									JOptionPane.showMessageDialog(null, "���� �ݱ� ����");
									e3.printStackTrace();
								} // end of catch(IOException e3) {
							} // end of finally {
						} // end of if(chkFile == true) {
					} // end of if(selectedFile.isEmpty()) {
				} // end of if(selectedFile == null) {
			}
		}
			else if(clickedButton == m_fo) {
				/*
				 * ����ڰ� ���� ���� ��ư�� Ŭ���� ����� ó���� ��ɾ���� �ۼ��ϱ�
				 */
				FileDialog tempdf = new FileDialog(this, "���� ���� â", FileDialog.LOAD);
				tempdf.setVisible(true);
				
				String tempfile = tempdf.getFile();
				if(tempfile == null || tempfile.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "���� ���� ����");
					return;
				} else {
					System.out.println("����ڰ� ������ ���� �̸��� " + tempfile);
					String tempdir = tempdf.getDirectory();
					if(tempdir == null || tempdir.isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "���� ��� ����");
						return;
					} else {
						System.out.println("����ڰ� ������ ������ ��ü ��δ� " + tempdir);
						FileReader tempfr = null;
						BufferedReader tempbr = null;
						try {
							tempfr = new FileReader(tempdir + tempfile);
							tempbr = new BufferedReader(tempfr);
							String inputLine = "";
							m_ta.setText("");
							while((inputLine = tempbr.readLine()) != null) {
								m_ta.append(inputLine + "\n");
							}
							System.out.println("������ ������ �о�ͼ� TextArea�� �߰� �Ϸ�");
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(null, "������ ����");
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "���� �Է� ����");
						} catch (Exception e3) {
							JOptionPane.showMessageDialog(null, "�Ϲ� ����");
						} finally {
							try {
								if(tempbr != null) tempbr.close();
							} catch(IOException e4) {
								JOptionPane.showMessageDialog(null, "���� �ݱ� ����");
							}
						}
					}
				}
			}
	}
}


public class TestFileDialog {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("test filedialog");
		
	}

}
