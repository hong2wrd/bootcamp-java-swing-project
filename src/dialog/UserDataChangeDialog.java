package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import dao.MemberDAO;
import dto.MemberDTO;
import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundPasswordField;
import ui.AdminListPage;
import ui.ListPage;
import ui.MainFrame;

public class UserDataChangeDialog extends JFrame implements ActionListener {
	
	protected RoundPanel userDelete;
	
	protected JLabel message;
	protected JLabel message2;
	protected RoundPasswordField confirmPwd;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	private MemberDAO memberDAO = new MemberDAO();
	
	public UserDataChangeDialog() {
		
		/* 프레임 */
		setSize(300, 200);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
//		프레임 투명
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* 패널 */
		userDelete = new RoundPanel();
//		라운드 패널
		userDelete.setRoundPanel(100, 100, 100, 10);
		userDelete.setBackground(new Color(240, 236, 227));
		userDelete.setLayout(null);
		setContentPane(userDelete);
		
		/* 메시지 */
		message = new JLabel("정보를 변경할게요! :)");
		message2 = new JLabel("비밀번호를 입력해주세요");
		
		message.setBounds(0, 5, 300, 40);
		message.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		message.setForeground(new Color(53, 66, 89));
		message.setHorizontalAlignment(JLabel.CENTER);
		userDelete.add(message);
		
		message2.setBounds(0, 45, 300, 30);
		message2.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		message2.setForeground(new Color(53, 66, 89));
		message2.setHorizontalAlignment(JLabel.CENTER);
		userDelete.add(message2);
		
		confirmPwd = new RoundPasswordField(20);;
		confirmPwd.setBounds(50, 90, 200, 30);
		confirmPwd.setRoundPasswordField(20, 20);
		confirmPwd.setBorderColor(240, 236, 227);
		confirmPwd.setHorizontalAlignment(JPasswordField.CENTER);
		userDelete.add(confirmPwd);
		
		/* 버튼 */
		submit = new RoundButton("확인");
		submit.setBounds(45, 150, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		cancel = new RoundButton("취소");
		cancel.setBounds(155, 150, 100, 30);
		cancel.setRoundButton(20, 20);
		cancel.setBackground(new Color(53, 66, 89));
		cancel.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		cancel.setForeground(new Color(240, 236, 227));
		cancel.addActionListener(this);
		
		userDelete.add(submit);
		userDelete.add(cancel);
	}
	
	
	public static void main(String[] args) {
		UserDataChangeDialog ud = new UserDataChangeDialog();
		ud.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj==cancel) {
			confirmPwd.setText("");
			dispose();
		}else if(obj==submit) {
			String name = MainFrame.loggedin.getMemName();
			String addr = MainFrame.userInfoPage.addrField.getText();
			String ph1 = MainFrame.userInfoPage.phoneField1.getText();
			String ph2 = MainFrame.userInfoPage.phoneField2.getText();
			String ph3 = MainFrame.userInfoPage.phoneField3.getText();
			
			String pwd = String.valueOf(confirmPwd.getPassword());
			if(MainFrame.loggedin.getMemPw().equals(pwd)) {
				MemberDTO dto = new MemberDTO();
				dto.setMemCode(MainFrame.loggedin.getMemCode());
				dto.setMemName(name);
				dto.setMemAddr(addr);
				dto.setMemPh1(ph1);
				dto.setMemPh2(ph2);
				dto.setMemPh3(ph3);
				
				int res = memberDAO.updateMemberInfo(dto);
				if(res>0) {
					confirmPwd.setText("");
					MainFrame.loggedin = memberDAO.selectOneMember(MainFrame.loggedin.getMemId());
					dispose();
					MainFrame.confirmDial.setVisible(true);
					if(MainFrame.loggedin.getMemCode()==0) {
						MainFrame.card.show(MainFrame.mainPanel, "adminList");
					}else {
						MainFrame.card.show(MainFrame.mainPanel, "listPanel");
					}
				}else {
					confirmPwd.setText("");
					dispose();
					MainFrame.errorDial.setVisible(true);
				}
				
			}else {
				confirmPwd.setText("");
				dispose();
				MainFrame.logFailPassDial.setVisible(true);
			}
			
		}
				
		
	}
}
