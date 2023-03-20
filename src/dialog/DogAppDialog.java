package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.SubmitDAO;
import dto.DogDTO;
import dto.SubmitDTO;
import graphics.RoundButton;
import graphics.RoundPanel;
import ui.MainFrame;

public class DogAppDialog extends JFrame implements ActionListener {
	
	protected RoundPanel LogIn;
	
	protected JLabel message;
	protected JLabel message2;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	protected DogDTO dto;
	
	private SubmitDAO submitDAO = new SubmitDAO();
	
	public DogAppDialog() {
		
		dto = new DogDTO();
		
		/* 프레임 */
		setSize(300, 160);
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
		message = new JLabel(MainFrame.dog.getDogName() + "♥");
		message2 = new JLabel("신청하실건가요? :)");
		
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
		submit.setBounds(45, 110, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		LogIn.add(submit);
		
		cancel = new RoundButton("취소");
		cancel.setBounds(155, 110, 100, 30);
		cancel.setRoundButton(20, 20);
		cancel.setBackground(new Color(53, 66, 89));
		cancel.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		cancel.setForeground(new Color(205, 194, 174));
		cancel.addActionListener(this);
		
		LogIn.add(cancel);
	}
	
	
	public static void main(String[] args) {
		DogAppDialog ld = new DogAppDialog();
		ld.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		dispose();
	}
}
