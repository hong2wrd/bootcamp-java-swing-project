package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import graphics.RoundButton;
import graphics.RoundPanel;

public class LogOutDialog extends JFrame implements ActionListener {
	
	protected RoundPanel logOut;
	
	protected JLabel logOutImg;
	protected JLabel message;
	
	protected RoundButton submit;
	
	public LogOutDialog() {
		
		/* 프레임 */
		setSize(300, 350);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
//		프레임 투명
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		logOutImg = new JLabel();
		logOutImg.setBounds(75, 0, 150, 150);
		logOutImg.setIcon(new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\newPro\\dialog\\logOutImg.png"));
		add(logOutImg);
		
		/* 패널 */
		logOut = new RoundPanel();
//		라운드 패널
		logOut.setBounds(0, 95, 300, 150);
		logOut.setRoundPanel(100, 100, 100, 10);
		logOut.setBackground(new Color(240, 236, 227));
		logOut.setLayout(null);
		add(logOut);
		
		/* 메시지 */
		message = new JLabel("다시 만나요! :>");
		message.setBounds(0, 5, 300, 100);
		message.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		message.setForeground(new Color(53, 66, 89));
		message.setHorizontalAlignment(JLabel.CENTER);
		logOut.add(message);
		
		/* 버튼 */
		submit = new RoundButton("확인");
		submit.setBounds(100, 100, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		logOut.add(submit);
	}
	
	
	public static void main(String[] args) {
		LogOutDialog ld = new LogOutDialog();
		ld.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
