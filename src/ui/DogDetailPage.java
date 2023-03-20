package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.SubmitDAO;
import dialog.DogAppDialog;
import dto.DogDTO;
import dto.SubmitDTO;
import graphics.RoundButton;
import graphics.RoundPanel;

public class DogDetailPage {
	
	protected DogDTO dto = new DogDTO();
	
	protected JFrame frame;
	protected RoundPanel mainPanel;
	
	protected RoundPanel detailPanel;
	
	protected JLabel dogLabel;
	protected JLabel dogImg;
	protected RoundPanel dogName;
	protected RoundPanel dogSpec;
	protected RoundPanel dogGender;
	protected RoundPanel dogHealth;
	protected RoundPanel dogIno;
	
	protected JLabel name;
	protected JLabel age;
	protected JLabel gender;
	protected JLabel health;
	protected JLabel ino;
	
	protected RoundButton submit;
	protected RoundButton cancel;
	
	private SubmitDAO submitDAO = new SubmitDAO();
	
	public DogDetailPage() {
		frame = new JFrame();
		frame.setSize(1600, 1000);
		frame.setLocationRelativeTo(null);
	    frame.setUndecorated(true);
	    frame.setLayout(null);
	    frame.setBackground(new Color(194, 222, 209, 0));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		detailPanel = new RoundPanel();
		detailPanel.setRoundPanel(50, 50, 50, 50);
		detailPanel.setBounds(500, 50, 600, 900);
		detailPanel.setBackground(new Color(240, 236, 227));
		detailPanel.setLayout(null);
		frame.add(detailPanel);
		
		/* 페이지 이름 */
		dogLabel = new JLabel(MainFrame.dog.getDogName());
		dogLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 40));
		dogLabel.setForeground(new Color(53, 66, 89));
		dogLabel.setBounds(200, 25, 200, 100);
		dogLabel.setHorizontalAlignment(JLabel.CENTER);
		detailPanel.add(dogLabel);
		
		/* 패널 */
		dogImg = new JLabel();
		dogImg.setBounds(100, 150, 400, 300);
		ImageIcon icon = new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\dog\\"+MainFrame.dog.getDogImage());
		dogImg.setIcon(icon);
		dogImg.setHorizontalAlignment(JLabel.CENTER);
		detailPanel.add(dogImg);
		
		dogName = new RoundPanel();
		dogName.setBounds(100, 470, 400, 50);
		dogName.setBackground(new Color(255, 255, 255));
		dogName.setRoundPanel(50, 50, 5, 50);
		detailPanel.add(dogName);
		
		dogSpec = new RoundPanel();
		dogSpec.setBounds(100, 540, 400, 50);
		dogSpec.setBackground(new Color(255, 255, 255));
		dogSpec.setRoundPanel(50, 50, 5, 50);
		detailPanel.add(dogSpec);
		
		dogGender = new RoundPanel();
		dogGender.setBounds(100, 610, 400, 50);
		dogGender.setBackground(new Color(255, 255, 255));
		dogGender.setRoundPanel(50, 50, 5, 50);
		detailPanel.add(dogGender);
		
		dogIno = new RoundPanel();
		dogIno.setBounds(100, 680, 400, 50);
		dogIno.setBackground(new Color(255, 255, 255));
		dogIno.setRoundPanel(50, 50, 5, 50);
		detailPanel.add(dogIno);

		dogHealth = new RoundPanel();
		dogHealth.setBounds(100, 750, 400, 50);
		dogHealth.setBackground(new Color(255, 255, 255));
		dogHealth.setRoundPanel(50, 50, 5, 50);
		detailPanel.add(dogHealth);
		
		/* 라벨 */
		name = new JLabel("종 : " + MainFrame.dog.getDogSpe());
		name.setBounds(0, 0, 400, 50);
		name.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		name.setForeground(new Color(53, 66, 89));
		name.setHorizontalAlignment(JLabel.CENTER);
		dogName.add(name);

		age = new JLabel("성별 : " + MainFrame.dog.getDogSex());
		age.setBounds(0, 0, 400, 50);
		age.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		age.setForeground(new Color(53, 66, 89));
		age.setHorizontalAlignment(JLabel.CENTER);
		dogSpec.add(age);
		
		gender = new JLabel("중성화 : " + MainFrame.dog.getDogNeu());
		gender.setBounds(0, 0, 400, 50);
		gender.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		gender.setForeground(new Color(53, 66, 89));
		gender.setHorizontalAlignment(JLabel.CENTER);
		dogGender.add(gender);
		
		ino = new JLabel("예방접종 : " + MainFrame.dog.getDogIno());
		ino.setBounds(0, 0, 400, 50);
		ino.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		ino.setForeground(new Color(53, 66, 89));
		ino.setHorizontalAlignment(JLabel.CENTER);
		dogIno.add(ino);
		
		health = new JLabel("건강상태 : " + MainFrame.dog.getDogDis());
		health.setBounds(0, 0, 400, 50);
		health.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
		health.setForeground(new Color(53, 66, 89));
		health.setHorizontalAlignment(JLabel.CENTER);
		dogHealth.add(health);
		
		/* 버튼 */
		submit = new RoundButton("신청하기");
		submit.setBounds(100, 820, 200, 35);
		submit.setBackground(new Color(205, 194, 174));
		submit.setRoundButton(10, 10);
		submit.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		submit.setForeground(new Color(53, 66, 89));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				SubmitDTO sub = new SubmitDTO();
				sub.setMemCode(MainFrame.loggedin.getMemCode());
				sub.setDogCode(MainFrame.dog.getDogCode());
				sub.setDogName(MainFrame.dog.getDogName());
				
				int res = submitDAO.insertSubmit(sub);
				
				if(res==1) {
					MainFrame.appDial.setVisible(true);
					frame.dispose();
				}else {
					MainFrame.errorDial.setVisible(true);
				}
			}
		});
		detailPanel.add(submit);
		
		cancel = new RoundButton("취소");
		cancel.setBounds(310, 820, 190, 35);
		cancel.setBackground(new Color(53, 66, 89));
		cancel.setRoundButton(10, 10);
		cancel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		cancel.setForeground(new Color(205, 194, 174));
		detailPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
	}
	
	public static void main(String[] args) {
		DogDetailPage ddp = new DogDetailPage();
		ddp.frame.setVisible(true);
	}
}
