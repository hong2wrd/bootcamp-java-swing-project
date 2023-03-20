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
import ui.MainFrame;

public class SignUpDialog extends JFrame implements ActionListener {
	
	protected RoundPanel LogIn;
	
	protected JLabel LogInImg;
	protected JLabel message;
	
	protected RoundButton submit;
	
	public SignUpDialog() {
		
		/* 프레임 */
		setSize(300, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
//		프레임 투명
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		LogInImg = new JLabel();
		LogInImg.setBounds(50, 1, 150, 150);
		LogInImg.setIcon(new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\newPro\\dialog\\signUpImg.png"));
		add(LogInImg);
		
		/* 패널 */
		LogIn = new RoundPanel();
//		라운드 패널
		LogIn.setBounds(0, 150, 300, 150);
		LogIn.setRoundPanel(100, 100, 10, 100);
		LogIn.setBackground(new Color(240, 236, 227));
		LogIn.setLayout(null);
		add(LogIn);
		
		/* 메시지 */
		message = new JLabel("우린 이제 한 가족이에요! :>");
		message.setBounds(0, 5, 300, 100);
		message.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		message.setForeground(new Color(53, 66, 89));
		message.setHorizontalAlignment(JLabel.CENTER);
		LogIn.add(message);
		
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
		SignUpDialog ld = new SignUpDialog();
		ld.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
