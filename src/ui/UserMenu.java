package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundTextField;

public class UserMenu {

	protected RoundPanel topPanel;
	protected RoundPanel navPanel;

	protected JLabel compLabel;

	protected RoundTextField userField;

	protected JLabel compName;
	protected JLabel compCont;
	protected JLabel compTel;

	protected RoundButton myPageBtn;
	protected RoundButton logoutBtn;

	protected RoundButton userInfoBtn;
	protected RoundButton adoptBtn;
	protected RoundButton unadoptBtn;
	protected RoundButton shelterBtn;
	protected RoundButton hospitalBtn;

	public UserMenu() {

		/* top panel */
		topPanel = new RoundPanel();
		topPanel.setBackground(new Color(205, 194, 174));
		topPanel.setBounds(50, 25, 1500, 100);
		topPanel.setRoundPanel(50, 50, 50, 50);
		topPanel.setLayout(null);

		/* user field */
		userField = new RoundTextField(100);
		userField.setBounds(25, 10, 300, 80);
		userField.setBackground(new Color(205, 194, 174));
		userField.setDisabledTextColor(new Color(53, 66, 89));
		userField.setBorderColor(205, 194, 174);
		userField.setFont(new Font("강원교육모두 Bold", Font.BOLD, 20));;
		userField.setHorizontalAlignment(RoundTextField.CENTER);
		userField.setEnabled(false);

		topPanel.add(userField);

		logoutBtn = new RoundButton("로그아웃");
		logoutBtn.setBounds(1350, 20, 130, 60);
		logoutBtn.setRoundButton(50, 50);
		logoutBtn.setBackground(new Color(205, 194, 174));
		logoutBtn.setFont(new Font("강원교육모두 Bold", Font.BOLD, 25));;
		logoutBtn.setForeground(new Color(53, 66, 89));
		logoutBtn.setBorderPainted(false);
		logoutBtn.setFocusPainted(false);
		logoutBtn.setContentAreaFilled(false);

		topPanel.add(logoutBtn);

		/* navPanel */
		navPanel = new RoundPanel();
		navPanel.setBackground(new Color(205, 194, 174));
		navPanel.setBounds(50, 175, 350, 750);
		navPanel.setRoundPanel(50, 50, 50, 50);
		navPanel.setLayout(null);

		/* company panel */
		compLabel = new JLabel();
		compLabel.setBounds(0, 420, 350, 330);
		compLabel.setIcon(new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\newPro\\compLabel.png"));
		navPanel.add(compLabel);

		compName = new JLabel("Choose ME");
		compName.setBounds(0, 630, 240, 30);
		compName.setFont(new Font("Passion One Bold", Font.PLAIN, 45));
		compName.setForeground(new Color(255, 255, 255));
		compName.setHorizontalAlignment(JLabel.CENTER);
		navPanel.add(compName);

		compCont = new JLabel("2 4 시  상 담  센 터");
		compCont.setBounds(0, 660, 240, 30);
		compCont.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		compCont.setForeground(new Color(255, 255, 255));
		compCont.setHorizontalAlignment(JLabel.CENTER);
		navPanel.add(compCont);

		compTel = new JLabel("1588-2828");
		compTel.setBounds(0, 690, 240, 30);
		compTel.setFont(new Font("강원교육튼튼", Font.PLAIN, 30));
		compTel.setForeground(new Color(255, 255, 255));
		compTel.setHorizontalAlignment(JLabel.CENTER);
		navPanel.add(compTel);

		/* list */
		userInfoBtn = new RoundButton("회 원  정 보");
		userInfoBtn.setBounds(0, 0, 350, 60);
		userInfoBtn.setRoundButton(30, 30);
		userInfoBtn.setBackground(new Color(205, 194, 174));
		userInfoBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		userInfoBtn.setForeground(new Color(53, 66, 89));
		userInfoBtn.setBorderPainted(false);
		userInfoBtn.setFocusPainted(false);
		navPanel.add(userInfoBtn);

		if(MainFrame.loginToken == 0) {
			adoptBtn = new RoundButton("입 양  신 청 서");
			adoptBtn.setBounds(0, 84, 350, 60);
			adoptBtn.setRoundButton(30, 30);
			adoptBtn.setBackground(new Color(205, 194, 174));
			adoptBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
			adoptBtn.setForeground(new Color(53, 66, 89));
			adoptBtn.setBorderPainted(false);
			adoptBtn.setFocusPainted(false);
			navPanel.add(adoptBtn);
			
			unadoptBtn = new RoundButton("강 아 지  등 록");
			unadoptBtn.setBounds(0, 168, 350, 60);
			unadoptBtn.setRoundButton(30, 30);
			unadoptBtn.setBackground(new Color(205, 194, 174));
			unadoptBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
			unadoptBtn.setForeground(new Color(53, 66, 89));
			unadoptBtn.setBorderPainted(false);
			unadoptBtn.setFocusPainted(false);
			navPanel.add(unadoptBtn);
			
		} else if(MainFrame.loginToken == 1) {
			adoptBtn = new RoundButton("A B O U T");
			adoptBtn.setBounds(0, 84, 350, 60);
			adoptBtn.setRoundButton(30, 30);
			adoptBtn.setBackground(new Color(205, 194, 174));
			adoptBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
			adoptBtn.setForeground(new Color(53, 66, 89));
			adoptBtn.setBorderPainted(false);
			adoptBtn.setFocusPainted(false);
			navPanel.add(adoptBtn);
			
			unadoptBtn = new RoundButton("입 소  신 청");
			unadoptBtn.setBounds(0, 168, 350, 60);
			unadoptBtn.setRoundButton(30, 30);
			unadoptBtn.setBackground(new Color(205, 194, 174));
			unadoptBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
			unadoptBtn.setForeground(new Color(53, 66, 89));
			unadoptBtn.setBorderPainted(false);
			unadoptBtn.setFocusPainted(false);
			navPanel.add(unadoptBtn);
			
		}
		
		/* shelter */
		shelterBtn = new RoundButton("돌 봄  센 터");
		shelterBtn.setBounds(0, 252, 350, 60);
		shelterBtn.setRoundButton(30, 30);
		shelterBtn.setBackground(new Color(205, 194, 174));
		shelterBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		shelterBtn.setForeground(new Color(53, 66, 89));
		shelterBtn.setBorderPainted(false);
		shelterBtn.setFocusPainted(false);
		navPanel.add(shelterBtn);

		/* hospital */
		hospitalBtn = new RoundButton("동 물  병 원");
		hospitalBtn.setBounds(0, 336, 350, 60);
		hospitalBtn.setRoundButton(30, 30);
		hospitalBtn.setBackground(new Color(205, 194, 174));
		hospitalBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		hospitalBtn.setForeground(new Color(53, 66, 89));
		hospitalBtn.setBorderPainted(false);
		hospitalBtn.setFocusPainted(false);
		navPanel.add(hospitalBtn);


	}
	

}
