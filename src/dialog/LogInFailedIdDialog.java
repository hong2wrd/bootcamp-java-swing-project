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

public class LogInFailedIdDialog extends JFrame implements ActionListener {
	
	protected RoundPanel LogIn;
	
	protected JLabel message;
	protected JLabel message2;
	
	protected RoundButton submit;
	
	public LogInFailedIdDialog() {
		
		/* 프레임 */
		setSize(300, 150);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
//		프레임 투명
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* 패널 */
		LogIn = new RoundPanel();
//		라운드 패널
		LogIn.setRoundPanel(100, 100, 100, 10);
		LogIn.setBackground(new Color(240, 236, 227));
		LogIn.setLayout(null);
		setContentPane(LogIn);
		
		/* 메시지 */
		message = new JLabel("잠깐!");
		message2 = new JLabel("아이디가 달라요 :(");
		
		message.setBounds(0, 5, 300, 50);
		message.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		message.setForeground(new Color(53, 66, 89));
		message.setHorizontalAlignment(JLabel.CENTER);
		LogIn.add(message);
		
		message2.setBounds(0, 45, 300, 40);
		message2.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		message2.setForeground(new Color(53, 66, 89));
		message2.setHorizontalAlignment(JLabel.CENTER);
		LogIn.add(message2);
		
		/* 버튼 */
		submit = new RoundButton("확인");
		submit.setBounds(100, 100, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		LogIn.add(submit);
	}
	
	
	public static void main(String[] args) {
		LogInFailedIdDialog ld = new LogInFailedIdDialog();
		ld.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
