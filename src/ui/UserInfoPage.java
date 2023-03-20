package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundPasswordField;
import graphics.RoundTextField;

public class UserInfoPage {
	
	protected JFrame frame;
	protected RoundPanel mainPanel;
	protected RoundPanel joinPanel;
	
	protected JScrollPane termsPanel;
	
	protected RoundPanel name;
	protected RoundPanel id;
	protected RoundPanel pass;
	protected RoundPanel passConfirm;
	protected RoundPanel phone;
	protected RoundPanel addr;
	
	protected RoundPanel nameInput;
	protected RoundPanel idInput;
	protected RoundPanel passInput;
	protected RoundPanel passConfirmInput;
	protected RoundPanel phoneInput;
	protected RoundPanel addrInput;
	
	protected JLabel nameLabel;
	protected JLabel idLabel;
	protected JLabel passLabel;
	protected JLabel passConfirmLabel;
	protected JLabel phoneLabel;
	protected JLabel addrLabel;
	protected JLabel hpLabel;
	
	protected RoundTextField nameField;
	protected RoundTextField idField;
	protected RoundPasswordField passField;
	protected RoundPasswordField passConfirmField;
	public RoundTextField phoneField1;
	public RoundTextField phoneField2;
	public RoundTextField phoneField3;
	public RoundTextField addrField;
	
	protected JLabel joinLabel;
	
	protected RoundButton modPassBtn;
	protected RoundButton modInfoBtn;
	protected RoundButton deleteMemberBtn;
	protected RoundButton cancelBtn;
	
	protected String terms;
	
	public UserInfoPage() {
		
//		frame = new JFrame();
//		frame.setSize(1600, 1000);
//		frame.setLocationRelativeTo(null);
//	    frame.setUndecorated(true);
//	    frame.setLayout(null);
//	    frame.setBackground(new Color(194, 222, 209, 100));
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    mainPanel = new RoundPanel();
	    mainPanel.setLayout(null);
	    mainPanel.setRoundPanel(50, 50, 50, 50);
	    mainPanel.setBackground(new Color(194, 222, 209, 100));
//	    frame.setContentPane(mainPanel);
	    
	    joinPanel = new RoundPanel();
	    joinPanel.setRoundPanel(50, 50, 50, 50);
	    joinPanel.setBounds(500, 125, 600, 700);
	    joinPanel.setBackground(new Color(236, 229, 199));
	    joinPanel.setLayout(null);
		mainPanel.add(joinPanel);
	    
		/* 페이지 이름 */
		joinLabel = new JLabel("회원 정보 수정");
		joinLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 40));
		joinLabel.setForeground(new Color(53, 66, 89));
		joinLabel.setBounds(150, 25, 300, 100);
		joinLabel.setHorizontalAlignment(JLabel.CENTER);
		joinPanel.add(joinLabel);
		
		/* name */
		name = new RoundPanel();
		name.setBounds(50, 165, 200, 70);
		name.setLayout(null);
		name.setBackground(new Color(53, 66, 89));
		name.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(name);
		
		nameInput = new RoundPanel();
		nameInput.setBounds(250, 165, 300, 70);
		nameInput.setLayout(null);
		nameInput.setBackground(new Color(255, 255, 255));
		nameInput.setRoundPanel(0, 50, 0, 50);
		joinPanel.add(nameInput);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(0, 0, 200, 70);
		nameLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 30));
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		name.add(nameLabel);
		
		nameField = new RoundTextField(100);
		nameField.setBounds(0, 0, 280, 70);
		nameField.setBorderColor(255, 255, 255);
		nameField.setFont(new Font("강원교육모두 Light", Font.PLAIN, 30));
		nameField.setForeground(new Color(53, 66, 89));
		nameField.setHorizontalAlignment(RoundTextField.CENTER);
		nameField.setEnabled(false);
		nameInput.add(nameField);
		
		/* id */
		id = new RoundPanel();
		id.setBounds(50, 265, 200, 70);
		id.setLayout(null);
		id.setBackground(new Color(53, 66, 89));
		id.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(id);
		
		idInput = new RoundPanel();
		idInput.setBounds(250, 265, 300, 70);
		idInput.setLayout(null);
		idInput.setBackground(new Color(255, 255, 255));
		idInput.setRoundPanel(0, 50, 0, 50);
		joinPanel.add(idInput);
		
		idLabel = new JLabel("아이디");
		idLabel.setBounds(0, 0, 200, 70);
		idLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 30));
		idLabel.setForeground(new Color(255, 255, 255));
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		id.add(idLabel);
		
		idField = new RoundTextField(100);
		idField.setBounds(0, 0, 280, 70);
		idField.setBorderColor(255, 255, 255);
		idField.setFont(new Font("강원교육모두 Light", Font.PLAIN, 30));
		idField.setForeground(new Color(53, 66, 89));
		idField.setHorizontalAlignment(RoundTextField.CENTER);
		idField.setEnabled(false);
		idInput.add(idField);
		
		
		/* addr */
		addr = new RoundPanel();
		addr.setBounds(50, 365, 200, 70);
		addr.setLayout(null);
		addr.setBackground(new Color(53, 66, 89));
		addr.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(addr);
		
		addrInput = new RoundPanel();
		addrInput.setBounds(250, 365, 300, 70);
		addrInput.setLayout(null);
		addrInput.setBackground(new Color(255, 255, 255));
		addrInput.setRoundPanel(0, 50, 0, 50);
		joinPanel.add(addrInput);
		
		addrLabel = new JLabel("주소");
		addrLabel.setBounds(0, 0, 200, 70);
		addrLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 30));
		addrLabel.setForeground(new Color(255, 255, 255));
		addrLabel.setHorizontalAlignment(JLabel.CENTER);
		addr.add(addrLabel);
		
		addrField = new RoundTextField(100);
		addrField.setBounds(0, 0, 280, 70);
		addrField.setBorderColor(255, 255, 255);
		addrField.setFont(new Font("강원교육모두 Light", Font.PLAIN, 25));
		addrField.setForeground(new Color(53, 66, 89));
		addrField.setHorizontalAlignment(RoundTextField.CENTER);
		addrInput.add(addrField);
		
		/* phone */
		phone = new RoundPanel();
		phone.setBounds(50, 465, 200, 70);
		phone.setLayout(null);
		phone.setBackground(new Color(53, 66, 89));
		phone.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(phone);
		
		phoneInput = new RoundPanel();
		phoneInput.setBounds(250, 465, 300, 70);
		phoneInput.setLayout(null);
		phoneInput.setBackground(new Color(255, 255, 255));
		phoneInput.setRoundPanel(0, 50, 0, 50);
		joinPanel.add(phoneInput);
		
		phoneLabel = new JLabel("연락처");
		phoneLabel.setBounds(0, 0, 200, 70);
		phoneLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 30));
		phoneLabel.setForeground(new Color(255, 255, 255));
		phoneLabel.setHorizontalAlignment(JLabel.CENTER);
		phone.add(phoneLabel);
		
		phoneField1 = new RoundTextField(100);
		phoneField1.setText("010");
		phoneField1.setBounds(10, 10, 80, 50);
		phoneField1.setBorderColor(255, 255, 255);
		phoneField1.setRoundTextField(20, 20);
		phoneField1.setBackground(new Color(236, 229, 199, 100));
		phoneField1.setFont(new Font("강원교육모두 Light", Font.PLAIN, 25));
		phoneField1.setForeground(new Color(53, 66, 89));
		phoneField1.setHorizontalAlignment(RoundTextField.CENTER);
		phoneInput.add(phoneField1);
		
		phoneField2 = new RoundTextField(100);
		phoneField2.setBounds(100, 10, 90, 50);
		phoneField2.setBorderColor(255, 255, 255);
		phoneField2.setRoundTextField(20, 20);
		phoneField2.setBackground(new Color(236, 229, 199, 100));
		phoneField2.setFont(new Font("강원교육모두 Light", Font.PLAIN, 25));
		phoneField2.setForeground(new Color(53, 66, 89));
		phoneField2.setHorizontalAlignment(RoundTextField.CENTER);
		phoneInput.add(phoneField2);
		
		phoneField3 = new RoundTextField(100);
		phoneField3.setBounds(200, 10, 90, 50);
		phoneField3.setBorderColor(255, 255, 255);
		phoneField3.setRoundTextField(20, 20);
		phoneField3.setBackground(new Color(236, 229, 199, 100));
		phoneField3.setFont(new Font("강원교육모두 Light", Font.PLAIN, 25));
		phoneField3.setForeground(new Color(53, 66, 89));
		phoneField3.setHorizontalAlignment(RoundTextField.CENTER);
		phoneInput.add(phoneField3);
		
		
		/* 버튼 */
		modPassBtn = new RoundButton("비밀번호 변경");
		modPassBtn.setBounds(50, 620, 130, 35);
		modPassBtn.setBackground(new Color(205, 194, 174));
		modPassBtn.setRoundButton(10, 10);
		modPassBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		modPassBtn.setForeground(new Color(53, 66, 89));
		joinPanel.add(modPassBtn);
		
		modInfoBtn = new RoundButton("회원정보 변경");
		modInfoBtn.setBounds(190, 620, 130, 35);
		modInfoBtn.setBackground(new Color(205, 194, 174));
		modInfoBtn.setRoundButton(10, 10);
		modInfoBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		modInfoBtn.setForeground(new Color(53, 66, 89));
		joinPanel.add(modInfoBtn);
		
		deleteMemberBtn = new RoundButton("가족 떠나기");
		deleteMemberBtn.setBounds(330, 620, 100, 35);
		deleteMemberBtn.setBackground(new Color(216, 33, 72)); // rgb(216, 33, 72)
		deleteMemberBtn.setRoundButton(10, 10);
		deleteMemberBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		deleteMemberBtn.setForeground(new Color(205, 194, 174));
		joinPanel.add(deleteMemberBtn);
		
		cancelBtn = new RoundButton("돌아가기");
		cancelBtn.setBounds(440, 620, 100, 35);
		cancelBtn.setBackground(new Color(53, 66, 89));
		cancelBtn.setRoundButton(10, 10);
		cancelBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		cancelBtn.setForeground(new Color(205, 194, 174));
		joinPanel.add(cancelBtn);
		
	
	}

	
}
