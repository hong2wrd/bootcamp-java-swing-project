package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundPasswordField;
import graphics.RoundTextField;

public class LoginPage {

	public RoundTextField idField;
	public RoundPasswordField passField;
	protected RoundPanel loginPanel;
	
	protected JLabel mainLabel;
	
	protected RoundButton signUpBtn;
	protected RoundButton loginBtn;
	protected RoundButton exitBtn;


	public LoginPage() {
		/* login panel */
		loginPanel = new RoundPanel();
		loginPanel.setBackground(new Color(236, 229, 199));
		loginPanel.setLayout(null);

		/* logo label */
		JLabel mainLabel = new JLabel();
		mainLabel.setBounds(0, 0, 1600, 1000);
		mainLabel.setIcon(new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\newPro\\loginMain.png"));

		loginPanel.add(mainLabel);

		/* id field */
		idField = new RoundTextField(20);
		idField.setBounds(675, 600, 250, 30);
		idField.setRoundTextField(20, 20);
		idField.setBorderColor(255, 255, 255);
		idField.setFont(new Font("강원교육모두 Light", Font.PLAIN, 20));
		idField.setForeground(new Color(53, 66, 89));
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginPanel.add(idField);

		/* pass field */
		passField = new RoundPasswordField(20);
		passField.setBounds(675, 650, 250, 30);;
		passField.setRoundPasswordField(20, 20);
		passField.setBorderColor(255, 255, 255);
		passField.setHorizontalAlignment(SwingConstants.CENTER);
		passField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginPanel.add(passField);

		/* login button */
		loginBtn = new RoundButton("로그인 하기");
		loginBtn.setBounds(675, 700, 140, 30); // 675 250 675
		loginBtn.setBackground(new Color(205, 194, 174));
		loginBtn.setRoundButton(20, 20);
		loginBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		loginBtn.setForeground(new Color(53, 66, 89));
		loginBtn.setBorderPainted(false);
		loginBtn.setFocusPainted(false);
		loginPanel.add(loginBtn);

		/* signup button */
		signUpBtn = new RoundButton("가족 되기");
		signUpBtn.setBounds(825, 700, 100, 30);
		signUpBtn.setBackground(new Color(53, 66, 89));
		signUpBtn.setRoundButton(20, 20);
		signUpBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		signUpBtn.setForeground(new Color(236, 229, 199));
		signUpBtn.setBorderPainted(false);
		signUpBtn.setFocusPainted(false);
		loginPanel.add(signUpBtn);
		
		exitBtn = new RoundButton("X");
		exitBtn.setBounds(1550, 20, 30, 30);
		exitBtn.setBackground(new Color(53, 66, 89));
		exitBtn.setRoundButton(50, 50);
		exitBtn.setFont(new Font("강원교육튼튼", Font.PLAIN, 14));
		exitBtn.setForeground(new Color(236, 229, 199));
		exitBtn.setHorizontalAlignment(RoundButton.CENTER);
		exitBtn.setBorderPainted(false);
		exitBtn.setFocusPainted(false);
		loginPanel.add(exitBtn);

		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		





	}


}
