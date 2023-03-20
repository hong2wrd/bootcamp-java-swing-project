package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.DogDAO;
import graphics.RoundButton;
import graphics.RoundPanel;
import ui.MainFrame;

public class DogRegiDialog extends JFrame implements ActionListener {
	
	protected RoundPanel LogIn;
	
	protected JLabel message;
	protected JLabel message2;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	private DogDAO dogDAO = new DogDAO();
	
	public DogRegiDialog() {
		
		/* 프레임 */
		setSize(300, 480);
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
		message = new JLabel(MainFrame.dog.getDogName() + " ♥");
//		message = new JLabel("아지 ♥");
		message2 = new JLabel("등록하실건가요? :)");
		
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
		
		/* 정보 */
		JLabel age = new JLabel("나이 : ");
		age.setBounds(50, 100, 100, 50);
		age.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		age.setForeground(new Color(53, 66, 89));
		LogIn.add(age);
		
		JLabel ageTxt = new JLabel(MainFrame.dog.getDogAge() + "살");
		ageTxt.setBounds(150, 100, 200, 50);
		ageTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		ageTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(ageTxt);
		
		JLabel spe = new JLabel("종 : ");
		spe.setBounds(50, 150, 100, 50);
		spe.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		spe.setForeground(new Color(53, 66, 89));
		LogIn.add(spe);
		
		JLabel speTxt = new JLabel(MainFrame.dog.getDogSpe() + "");
		speTxt.setBounds(150, 150, 200, 50);
		speTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		speTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(speTxt);

		JLabel sex = new JLabel("성별 : ");
		sex.setBounds(50, 200, 100, 50);
		sex.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		sex.setForeground(new Color(53, 66, 89));
		LogIn.add(sex);
		
		JLabel sexTxt = new JLabel(MainFrame.dog.getDogSex() + "");
		sexTxt.setBounds(150, 200, 200, 50);
		sexTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		sexTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(sexTxt);

		JLabel ino = new JLabel("접종");
		ino.setBounds(50, 250, 100, 50);
		ino.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		ino.setForeground(new Color(53, 66, 89));
		LogIn.add(ino);
		
		JLabel inoTxt = new JLabel(MainFrame.dog.getDogIno() + "");
		inoTxt.setBounds(150, 250, 200, 50);
		inoTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		inoTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(inoTxt);

		JLabel neu = new JLabel("중성화 : ");
		neu.setBounds(50, 300, 100, 50);
		neu.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		neu.setForeground(new Color(53, 66, 89));
		LogIn.add(neu);
		
		JLabel neuTxt = new JLabel(MainFrame.dog.getDogNeu() + "");
		neuTxt.setBounds(150, 300, 200, 50);
		neuTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		neuTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(neuTxt);

		JLabel dis = new JLabel("건강상태 : ");
		dis.setBounds(50, 350, 100, 50);
		dis.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		dis.setForeground(new Color(53, 66, 89));
		LogIn.add(dis);
		
		JLabel disTxt = new JLabel(MainFrame.dog.getDogDis() + "");
		disTxt.setBounds(150, 350, 200, 50);
		disTxt.setFont(new Font("강원교육튼튼", Font.PLAIN, 18));
		disTxt.setForeground(new Color(53, 66, 89));
		LogIn.add(disTxt);
		
		/* 버튼 */
		submit = new RoundButton("확인");
		submit.setBounds(45, 430, 100, 30);
		submit.setRoundButton(20, 20);
		submit.setBackground(new Color(205, 194, 174));
		submit.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(this);
		
		LogIn.add(submit);
		
		cancel = new RoundButton("취소");
		cancel.setBounds(155, 430, 100, 30);
		cancel.setRoundButton(20, 20);
		cancel.setBackground(new Color(53, 66, 89));
		cancel.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		cancel.setForeground(new Color(205, 194, 174));
		cancel.addActionListener(this);
		
		LogIn.add(cancel);
	}
	
	
	public static void main(String[] args) {
		DogRegiDialog ld = new DogRegiDialog();
		ld.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==submit) {
			int res = dogDAO.regiDog(MainFrame.dog.getDogCode());
			if(res>0) {
				MainFrame.regiDial.setVisible(true);
			}else {
				MainFrame.errorDial.setVisible(true);
			}
		}
		dispose();
	}
}
