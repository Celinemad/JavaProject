package myjava1;
/*
 * 1. ����: ȸ�� ���� ���α׷��� ����
 * 
 * 1) ���� Frame Ŭ������ �⺻ ���̾ƿ� �������� BorderLayout�� ����(����)�� ���α׷� ������ ���
 * 	��. Label�� ����� �ؽ�Ʈ�� ũ�⸦ �����ϴ� ���
 * 		- java.awt ��Ű���� Font Ŭ������ ���
 * 			- ����) import java.awt.*;
 * 				   import java.awt.event.*;
 * 
 * Font Ŭ������ ����ؼ� ��ü�� ����: 
 * 	Font ������ = new Font("�۲�(���ڸ��)", ���ڽ�Ÿ��(���� �Ǵ� ���Ÿ�) ���� �����, ����ũ�⸦ �ȼ� ������ ����(����));
 * 	��) Font myFont = new Font("�ü�ü", Font.BOLD, 30); 
 * 
 * 2) Frame �����̳� Ŭ������ ����ϴ� ����
 * 	��. Frame ������ = new Frame("�����������ڿ�");
 * 	   �Ǵ�
 * 	   Frame Ŭ������ ��� �޾Ƽ� ���ο� �ڽ� Ŭ������ ���� ������ �ڵ带 �ۼ�
 *	-> ����) class ���ο�Ŭ������ extends Frame implements WindowListener, ActionListener {
 *			
 *		    }
 *	-> WindowListener �������̽��� �뵵: ����ڰ� ������ ���� ��ư�� ������ �� ������ ��ɾ �ۼ�
 *	-> ActionListener �������̽��� �뵵: ����ڰ� ��ư �Ǵ� TextField���� �׼� �̺�Ʈ�� �߻���ų �� ���
 *		- ��ư������ �׼� �̺�Ʈ: ���콺 ���� ��ư��ȣ Ŭ��
 *		- TestField������ �׼� �̺�Ʈ: ����Ű�� ����
 *
 * 3) ������ ������ â�� ��� ��ġ�� �Ʒ��� ���� ������Ʈ���� ���� ����ϱ�
 * 	0. ���� ����� ���� �ִ� GridLayout Ŭ������ ����ؼ� ���ο� ��ü�� ����
 * 		-> ����) private GridLayout ������ = new GridLayout(��, ��);
 * 	��. �����̳��� �ǳ� Ŭ������ ����ؼ� ���ο� ��ü�� ����
 * 		-> ����) private Panel ������2 = new Panel(������);
 * 	��. "���̵�:" �ؽ�Ʈ�� ȭ�鿡 ������ �� ����� Label ��ü�� ����
 * 		-> ����) private Label ������3 = new Label("���̵�:", Label.RIGHT);
 * 	��. ����ڰ� ���̵� ������ �Է��� �� �ִ� �Է� â�� �����
 * 		-> ���� �Է� -> TextField Ŭ������ ����ϱ�
 * 		-> ����) private TextField ������4 = new TextField("", ȭ�鿡�����ٱ��ڼ�);
 * 	��. "��й�ȣ:" �ؽ�Ʈ�� ȭ�鿡 ������ �� ����� Label ��ü�� ����
 * 		-> ����) private Label ������5 = new Label("��й�ȣ:", Label.RIGHT);
 * 	��. ���� ��й�ȣ�� �Է��� �� �ִ� �Է�â �����
 * 		-> ����) private TextField ������6 = new TextField("");
 *  ��. ������ ���� 4���� ������Ʈ���� �ǳڿ� �ֱ�
 *  	-> ����) �ǳڰ�ü����������(������2).add(������Ʈ��ü����������);
 *  ��. �ǳ� ��ü�� ������ �����̳��� ��� ��ġ�� �ֱ�
 *  	-> ����) add(�ǳڰ�ü����������, BorderLayout.CENTER); 
 *  
 * 4) 3���� ��ư���� BorderLayout ��ġ �������� ���� �Ʒ� ����(BorderLayout.SOUTH)�� ���
 * 	��. FlowLayout ������ = new FlowLayout();
 * 	��. Button ������2 = new Button("�α���");
 * 	��. Button ������3 = new Button("ȸ������");
 * 	��. Button ������4 = new Button("����");
 * 	��. FlowLayout ��ü�� ����� �����̳ʸ� ����
 * 		-> Panel ������5 = new Panel(������);
 * 	��. �ǳ� ��ü�� 3���� ��ư���� �ֱ�
 * 		-> ������5.add(������2);
 * 		-> ������5.add(������3);
 * 		-> ������5.add(������4);
 * 	��. �ǳ� ��ü�� ������ �������� ���� �Ʒ� ��ġ�� �ֱ�:
 * 		-> add(������5, BorderLayout.SOUTH);
 */
import java.awt.*;
import java.awt.event.*;
// ���� ���� Ŭ������ �������̽��� ���(�α��ΰ� ȸ������ �ÿ� ���)
import java.io.*;
// �޽��� â�� ��� �� ����� Ŭ����(JOptionPane)
import javax.swing.*;

/*
 * WindowAdapter: �߻� Ŭ����
 * 	-> �ʿ��� �޼ҵ常 �������ϸ� ��.
 */
class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

// MyFrame Ŭ������ ����
class MyFrame extends Frame implements ActionListener {
	
	// ������ ������ MyWindowAdapter Ŭ������ ����ϱ� ���� ��ü�� ����
	private MyWindowAdapter m_wa = new MyWindowAdapter();
	// 	-> m_wa ���� ������ MyFrame Ŭ������ ����
	// 		-> Frame Ŭ������ ���� �ִ� addWindowListener(m_wa);
	// 			-> ������ �޼ҵ� ���η� �̵��� �Ŀ� �߰�
	
	// �߻� �޼ҵ���� ������
	
	// Font Ŭ������ ����ؼ� ���ο� ��ü�� ����: �뵵�� Label�� ����� �ؽ�Ʈ�� ���� ũ�⸦ ����(����)
	private Font m_font = new Font("�ü�ü", Font.BOLD, 30);
	
	// Label Ŭ������ ����ؼ� ���α׷��� ������ ����� ��ü�� ����
	private Label m_titleLabel = new Label("*** ȸ�� ���� ����(���� 1.0) ***", Label.CENTER);
	// ���α׷� ���� �Ŀ� ����� Ȯ���ϰ� Label.CENTER ���� Label.LEFT �Ǵ� Label.RIGHT�� ������ �� �ٽ� ����
	
	// 2�� 2�� ������ ���� GridLayout ��ü�� ����
	private GridLayout m_gridLayout = new GridLayout(2,2);
	
	// �ǳ� ��ü�� ����
	private Panel m_panel  = new Panel(m_gridLayout);
	
	// "���̵�:" �ؽ�Ʈ�� ����� �� ��ü�� ����
	private Label m_idLabel = new Label("���̵�:", Label.RIGHT);
	
	// ���̵� �Է� â �����
	private TextField m_idTextField = new TextField("");
	
	// "��й�ȣ:" �ؽ�Ʈ�� ����� �� ��ü�� ����
	private Label m_pwdLabel = new Label("��й�ȣ:", Label.RIGHT);
	
	// ��й�ȣ �Է� â �����
	private TextField m_pwdTextField = new TextField("");
	
	// �� 3���� ��ư���� ���� �Ʒ� ���⿡ ���
	private FlowLayout m_flowLayout = new FlowLayout();
	private Panel m_panel2 			= new Panel(m_flowLayout);
	private Button m_loginButton 	= new Button("�α���");
	private Button m_registerButton	= new Button("ȸ������");
	private Button m_exitButton 	= new Button("����");
	
	/*
	 * ���ο� static �Լ��� ����
	 * 1) ����� ����ڰ� �Է��� ���̵� �Ǵ� ��й�ȣ�� �Է� ������ �Ǵ�
	 */
	public static int checkStringValue(String value, int sortValue) {
		if(sortValue == 1) {
			if(value.isEmpty()) return 1;
			else return 3;
		}
		if(sortValue == 2) {
			if(value.isEmpty()) return 2;
			else return 4;
		}
		
		return 5;
	}
	
	
	
	// �ٸ� Ŭ�����κ��� ������ ���� ���ڿ��� �޴� �����ڸ� ����
	public MyFrame(String title) {
		// super() ��ɾ�: �θ� Ŭ������ Frame�� ���ǵǾ� �ִ� �����ڸ� ȣ�� -> public Frame(String) �����ڸ� ȣ��
		// -> ����: ������ ���� ���ڿ��� ������ �θ� Ŭ������ ��Ź�ϱ� ����
		super(title);
		
		// ��Ʈ ��ü�� �� ��ü�� �����ϱ�: setFont() �޼ҵ带 ȣ��
		m_titleLabel.setFont(m_font);
		
		m_idLabel.setFont(m_font);
		m_pwdLabel.setFont(m_font);
		
		m_idTextField.setFont(m_font);
		m_pwdTextField.setFont(m_font);
		
		// 3���� ��ư�� ��Ʈ ��ü�� ����ϱ�
		m_loginButton.setFont(m_font);
		m_registerButton.setFont(m_font);
		m_exitButton.setFont(m_font);
		
		// ����ڰ� ��й�ȣ �Է� â���� �Է��� ���� �Ǵ� ���ڸ� �����ִ� ���ڸ� ����
		// (���÷��̸� ��������, �޸𸮿��� ���� �Է��� ���� ����)
		m_pwdTextField.setEchoChar('��');
		
		// ��ư���� ���Ӱ� ������ �ִ� ���ڿ� ���� ����(��ư���� Ŭ�� �̺�Ʈ�� �߻����� �� ���)
		m_loginButton.setActionCommand("1");
		m_registerButton.setActionCommand("2");
		m_exitButton.setActionCommand("3");
		
		// add() �޼ҵ带 ȣ���ϱ� ���� ��� set���� �����ϴ� �޼ҵ带 ȣ��
		
		
		// �ǳ� ��ü�� 3���� ��ư���� �ֱ�
		m_panel2.add(m_loginButton);
		m_panel2.add(m_registerButton);
		m_panel2.add(m_exitButton);
		
		// �ǳ� ��ü�� �� 4���� ������Ʈ���� �߰��ϱ� 
		m_panel.add(m_idLabel);
		m_panel.add(m_idTextField);
		
		m_panel.add(m_pwdLabel);
		m_panel.add(m_pwdTextField);
		
		
		/*
		 * ���� ȭ���� �ػ� ũ�⸦ �о�ͼ� ����ϱ�
		 */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		System.out.println("���� ȭ���� �ػ� ũ�⸦ ���");
		System.out.println("���� ũ��� " + width + ", ���� ũ��� " + height);
		
		
		// �� ��° �ǳ� ��ü�� ������ �������� �Ʒ� ������ �ֱ�
		add(m_panel2, BorderLayout.SOUTH);
		
		// �ǳ��� ������ �����쿡 �ֱ�
		add(m_panel, BorderLayout.CENTER);
		
		// ����(����)�� �� ��ü�� ���: BorderLayout.NORTH
		add(m_titleLabel, BorderLayout.NORTH);
		
		
		// �������� ���� �̺�Ʈ�� ó���� ���� �غ�
		addWindowListener(m_wa);
		// this -> ������ WindowListener �������̽�
		
		// ��ư�� Ŭ�� �̺�Ʈ�� ó���� ���� �غ�
		m_loginButton.addActionListener(this);
		// this -> ������ ActionListener �������̽�
		
		m_registerButton.addActionListener(this);
		m_exitButton.addActionListener(this);
		
		// �������� ũ�⸦ �����ϱ�
		setSize(500, 500);
		
		pack();
		
		/*
		 * setLocation() �޼ҵ带 �����ؼ� �����츦 ��� ��ġ�� �̵�
		 */
		int x = width/2 - getWidth()/2;
		int y = height/2 - getHeight()/2;
		setLocation(x,y);
		
		// setResizable() �޼ҵ带 �����ϱ�
		setResizable(false);
		
		// �����츦 ȭ�鿡 ����ϱ�
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button clickedButton = (Button)e.getSource();
		
		// �����ڿ��� ��ư���� ���Ӱ� ������ ���ڿ� ���� �����ͼ� ȭ�鿡 ���
		String str = clickedButton.getActionCommand();
		System.out.println("��ư ���� ���ڿ� ���� " + str);
		
		if(clickedButton == m_loginButton) {
			System.out.println("����ڰ� �α��� ��ư�� Ŭ����");
			
			// ����ڰ� �Է��� ���̵� ���� �����ͼ� �ӽ� ������ ����
			String tempID = m_idTextField.getText();
			
			// ��� ���� ���� �ۼ��� �Լ��� �����ؼ� ��ȯ���� ��������
			int retValue = checkStringValue(tempID, 1);
			// ���� �Էµ��� �ʾ����� �޼��� â�� ����ϱ�
			if(retValue == 1) {
				JOptionPane.showMessageDialog(null, "���̵� �� �Է��ϼ���!");
				return;
			}
			else {
				System.out.println("����ڰ� �Է��� ���̵�� " + tempID);
			}
			
			// ����ڰ� ��й�ȣ�� �Է� ������ ���� ������ �Լ��� ���ؼ� �˻��ϱ�
			String tempPwd = m_pwdTextField.getText();
			retValue = checkStringValue(tempPwd, 2);
			if(retValue == 2) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� �� �Է��ϼ���!");
				return;
			}
			else {
				System.out.println("����ڰ� �Է��� ��й�ȣ�� " + tempPwd);
			}
			
			// ����ڰ� �Է��� ���̵�� ������ �ִ����� �˻��ϱ�
			File file = new File(tempID + ".txt");
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				// File Ŭ������ exists() �޼ҵ带 �����ϱ�
				boolean tempExists = file.exists();
				if(tempExists == true) {
					System.out.println("ȸ������ ���Ե� ����");
					// ���Ͽ��� ��й�ȣ�� ��������
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					// while �ݺ����� ����ؼ� ���Ͽ��� ��й�ȣ�� �о�ͼ� �ӽú����� tempCmpPwd�� ����
					String tempCmpPwd = "";
					
					// ��й�ȣ ��ġ ���� �Ǻ� ���� ���� ���� + �ʱⰪ ����
					boolean flag = false;
					
					while((tempCmpPwd = br.readLine()) != null) {
						if(tempCmpPwd.equals(tempPwd)) {
							flag = true;
							break;
						} 	
					}
					
					if(flag == true) {
						JOptionPane.showMessageDialog(null, "�α��� ����!");
					} else {
						JOptionPane.showMessageDialog(null, "��й�ȣ ����ġ!");
					}
					
					
					/*
					 * ������ ���: ��й�ȣ�� ��ġ���� ���� ��� 
					 * 	-> ȭ�鿡 ��й�ȣ ����ġ ���� �޽����� ����ϱ�
					 * 		-> JOptionPane.showMessageDialog(null, "�α��� ����!");
					 */
				} else {
					JOptionPane.showMessageDialog(null, "���� ȸ���� �ƴ�");
					return;
				}
				
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			} catch(IOException e2) {
				e2.printStackTrace();
			} catch(Exception e3) {
				e3.printStackTrace();
			} finally {
				try {
					if(fr != null) fr.close();
					if(br != null) br.close();
				} catch (IOException e4) {
					e4.printStackTrace();
				}
			}
			
		} else if(clickedButton == m_registerButton) {
			System.out.println("����ڰ� ȸ������ ��ư�� Ŭ����");
			
			String idv = m_idTextField.getText();
			File file = new File(idv + ".txt");
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				if(file.exists() == true) {
					JOptionPane.showMessageDialog(null, "�̹� ȸ������ ���ԵǾ� ����");
					return;
				} else {
					System.out.println(idv + ".txt �̸��� ���� ������ ����ϴ�.");
					boolean chk = file.createNewFile();
					if(chk == true) {
						System.out.println("������ ���������� ������");
						// ���� ���� ���Ͽ� ����ڰ� �Է��� ��й�ȣ�� �����ϱ�
						String pwdv = m_pwdTextField.getText();
						fw = new FileWriter(file);
						bw = new BufferedWriter(fw);
						bw.write(pwdv);
						JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�");
					} else {
						System.out.println("���� ���� ����");
						return;
					}
				}
			} catch(IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(bw != null)
						bw.close();
				} catch(IOException e2) {
					e2.printStackTrace();
				}
			}
			
		} else if(clickedButton == m_exitButton) {
			System.out.println("����ڰ� �����ư�� Ŭ����");
			System.exit(0);
		}
	}
	
}
public class TestMemberManager {

	public static void main(String[] args) {
		// MyFrame Ŭ������ ����ϱ� ���� ��ü�� ����
		MyFrame frame = new MyFrame("member manager");
		
		
	}

}
