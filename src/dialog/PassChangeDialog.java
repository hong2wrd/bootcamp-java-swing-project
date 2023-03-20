package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import dao.MemberDAO;
import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundPasswordField;
import ui.MainFrame;

public class PassChangeDialog extends JFrame implements ActionListener {
	
	protected RoundPanel userDelete;
	
	protected JLabel message;
	protected JLabel message2;
	protected JLabel message3;
	protected RoundPasswordField confirmPwd;
	protected RoundPasswordField changePwd;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	private MemberDAO memberDAO = new MemberDAO();
	
	public PassChangeDialog() {
		
		/* 프레임 */
		setSize(300, 290);
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
		message = new JLabel("비밀번호를 변경할게요! :)");
		message2 = new JLabel("기존 비밀번호를 입력해주세요");
		message3 = new JLabel("변경할 비밀번호를 입력해주세요");
		
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
		
		message3.setBounds(0, 135, 300, 30);
		message3.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		message3.setForeground(new Color(53, 66, 89));
		message3.setHorizontalAlignment(JLabel.CENTER);
		userDelete.add(message3);
		
		confirmPwd = new RoundPasswordField(20);;
		confirmPwd.setBounds(50, 90, 200, 30);
		confirmPwd.setRoundPasswordField(20, 20);
		confirmPwd.setBorderColor(240, 236, 227);
		confirmPwd.setHorizontalAlignment(JPasswordField.CENTER);
		userDelete.add(confirmPwd);
		
		changePwd = new RoundPasswordField(20);;
		changePwd.setBounds(50, 180, 200, 30);
		changePwd.setRoundPasswordField(20, 20);
		changePwd.setBorderColor(240, 236, 227);
		changePwd.setHorizontalAlignment(JPasswordField.CENTER);
		userDelete.add(changePwd);
		
		/* 버튼 */
		submit = new RoundButton("확인");
		submit.setBounds(45, 235, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		cancel = new RoundButton("취소");
		cancel.setBounds(155, 235, 100, 30);
		cancel.setRoundButton(20, 20);
		cancel.setBackground(new Color(53, 66, 89));
		cancel.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		cancel.setForeground(new Color(240, 236, 227));
		cancel.addActionListener(this);
		
		userDelete.add(submit);
		userDelete.add(cancel);
	}
	
	
	public static void main(String[] args) {
		PassChangeDialog ud = new PassChangeDialog();
		ud.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj==cancel) {
			confirmPwd.setText("");
			changePwd.setText("");
			dispose();
		}else {
			
			String currentPw = String.valueOf(confirmPwd.getPassword());
			if(currentPw.equals(MainFrame.loggedin.getMemPw())) {
				String newPw = String.valueOf(changePwd.getPassword());
				int res = memberDAO.updateMemberPw(newPw, MainFrame.loggedin.getMemCode());
				if(res>0) {
					confirmPwd.setText("");
					changePwd.setText("");
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
					changePwd.setText("");
					MainFrame.errorDial.setVisible(true);
				}
			}else {
				confirmPwd.setText("");
				changePwd.setText("");
				MainFrame.logFailPassDial.setVisible(true);
			}
		}

		
	}
}
