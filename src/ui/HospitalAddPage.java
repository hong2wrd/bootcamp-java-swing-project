package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.HospitalDAO;
import dto.HospitalDTO;
import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundTextField;

public class HospitalAddPage {
	
	protected JFrame frame;
	protected RoundPanel mainPanel;
	protected RoundPanel joinPanel;
	
	protected RoundPanel name;
	protected RoundPanel addr;
	protected RoundPanel phone;
	
	protected RoundPanel nameInput;
	protected RoundPanel addrInput;
	protected RoundPanel phoneInput;
	
	protected JLabel nameLabel;
	protected JLabel addrLabel;
	protected JLabel phoneLabel;
	
	protected RoundTextField nameField;
	public RoundTextField addrField;
	public RoundTextField phoneField1;
	public RoundTextField phoneField2;
	public RoundTextField phoneField3;
	
	protected JLabel joinLabel;
	
	protected RoundButton regiShelBtn;
	protected RoundButton cancelBtn;
	
	private HospitalDAO hosDAO = new HospitalDAO();
	
	
	public HospitalAddPage() {
		
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
	    mainPanel.setBackground(new Color(194, 222, 209));
//	    frame.setContentPane(mainPanel);
	    
	    joinPanel = new RoundPanel();
	    joinPanel.setRoundPanel(50, 50, 50, 50);
	    joinPanel.setBounds(500, 175, 600, 600);
	    joinPanel.setBackground(new Color(236, 229, 199));
	    joinPanel.setLayout(null);
		mainPanel.add(joinPanel);
	    
		/* 페이지 이름 */
		joinLabel = new JLabel("동물병원 등록");
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
		nameInput.add(nameField);
		
		/* address */
		addr = new RoundPanel();
		addr.setBounds(50, 265, 200, 70);
		addr.setLayout(null);
		addr.setBackground(new Color(53, 66, 89));
		addr.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(addr);
		
		addrInput = new RoundPanel();
		addrInput.setBounds(250, 265, 300, 70);
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
		addrField.setFont(new Font("강원교육모두 Light", Font.PLAIN, 30));
		addrField.setForeground(new Color(53, 66, 89));
		addrField.setHorizontalAlignment(RoundTextField.CENTER);
		addrInput.add(addrField);
		
		/* phone */
		phone = new RoundPanel();
		phone.setBounds(50, 365, 200, 70);
		phone.setLayout(null);
		phone.setBackground(new Color(53, 66, 89));
		phone.setRoundPanel(50, 0, 50, 0);
		joinPanel.add(phone);
		
		phoneInput = new RoundPanel();
		phoneInput.setBounds(250, 365, 300, 70);
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
		regiShelBtn = new RoundButton("등록하기");
		regiShelBtn.setBounds(150, 520, 150, 35);
		regiShelBtn.setBackground(new Color(205, 194, 174));
		regiShelBtn.setRoundButton(10, 10);
		regiShelBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		regiShelBtn.setForeground(new Color(53, 66, 89));
		regiShelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String hosName = nameField.getText();
				String hosAddr = addrField.getText();
				String hosPh1 = phoneField1.getText();
				String hosPh2 = phoneField2.getText();
				String hosPh3 = phoneField3.getText();
				
				if(hosName.isEmpty()||hosAddr.isEmpty()||hosPh1.isEmpty()||hosPh2.isEmpty()||hosPh3.isEmpty()) {
					MainFrame.dataRequestDial.setVisible(true);
				}else {
					HospitalDTO hos = new HospitalDTO();
					hos.setHosName(hosName);
					hos.setHosAddr(hosAddr);
					hos.setHosPh1(hosPh1);
					hos.setHosPh2(hosPh2);
					hos.setHosPh3(hosPh3);
					
					int res = hosDAO.insertHospital(hos);
					
					if(res>0) {
						
						nameField.setText("");
						addrField.setText("");
						phoneField1.setText("");
						phoneField2.setText("");
						phoneField3.setText("");
						
						MainFrame.confirmDial.setVisible(true);
						
						MainFrame.hospitalPage = new HospitalPage();
						MainFrame.mainPanel.add(MainFrame.hospitalPage.mainPanel, "hospitalPanel");
						MainFrame.card.show(MainFrame.mainPanel, "hospitalPanel");
					}else {
						MainFrame.errorDial.setVisible(true);
					}
					
				}
			}
		});
		joinPanel.add(regiShelBtn);
		
		cancelBtn = new RoundButton("돌아가기");
		cancelBtn.setBounds(350, 520, 150, 35);
		cancelBtn.setBackground(new Color(53, 66, 89));
		cancelBtn.setRoundButton(10, 10);
		cancelBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		cancelBtn.setForeground(new Color(205, 194, 174));
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				addrField.setText("");
				phoneField1.setText("");
				phoneField2.setText("");
				phoneField3.setText("");
				MainFrame.card.show(MainFrame.mainPanel, "hospitalPanel");
			}
		});
		joinPanel.add(cancelBtn);
		

	}
	
//	public static void main(String[] args) {
//		ShelterAddPage ap = new ShelterAddPage();
//		ap.frame.setVisible(true);
//	}
//	
}
