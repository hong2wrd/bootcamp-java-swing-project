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

public class UserDeleteDialog extends JFrame implements ActionListener {
	
	protected RoundPanel userDelete;
	
	protected JLabel message;
	protected JLabel message2;
	protected RoundPasswordField confirmPwd;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	private static MemberDAO memberDAO = new MemberDAO();
	
	public UserDeleteDialog() {
		
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
		message = new JLabel("정말 떠나실건가요? :(");
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
		UserDeleteDialog ud = new UserDeleteDialog();
		ud.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancel) {
			dispose();
		}else {
			if(MainFrame.loggedin.getMemPw().equals(String.valueOf(confirmPwd.getPassword()))) {
				int res = memberDAO.deleteMember(MainFrame.loggedin.getMemCode());
				if(res==1) {
					dispose();
					MainFrame.loggedin = null;
					MainFrame.loginPage.idField.setText("");
					MainFrame.loginPage.passField.setText("");
					MainFrame.loginToken = -1;
					MainFrame.card.show(MainFrame.mainPanel, "loginPanel");
				}else {
					dispose();
  				  	MainFrame.errorDial.setVisible(true);
				}
			}else {
				dispose();
				MainFrame.logFailPassDial.setVisible(true);
			}
			confirmPwd.setText("");
		}
	}
}
