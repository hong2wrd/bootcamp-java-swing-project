package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;

import dao.DogDAO;
import dao.SubmitDAO;
import dto.DogDTO;
import dto.SubmitDTO;
import graphics.RoundPanel;

public class ListPage {
	
	protected JPanel listPanel;
	protected JPanel dogPanel;

	protected JTextField userField;
	
	protected JButton listBtn;
	protected JButton adoptBtn;
	protected JButton unadoptBtn;
	protected JButton shelterBtn;
	protected JButton hospitalBtn;
	
	protected JScrollPane scroll;
//	protected CustomScrollPane scroll;
	
	private DogDAO dogDAO = new DogDAO();
	private SubmitDAO subDAO = new SubmitDAO();
	
	public ListPage() {
		
		/* list panel */
		listPanel = new JPanel();
		listPanel.setBackground(new Color(236, 229, 199));
		listPanel.setLayout(null);
		
		/* dog panel */
		dogPanel = new JPanel();
		dogPanel.setBackground(new Color(236, 229, 199));
		dogPanel.setBorder(null);
		dogPanel.setPreferredSize(new Dimension(1100, 750));
		dogPanel.setLayout(null);
		
		/* scroll pane*/
		scroll = new JScrollPane(dogPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(450, 180, 1100, 750);
		scroll.setBackground(new Color(205, 194, 174));
		scroll.createVerticalScrollBar();
		scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(205, 194, 174);
		    }
		});
		
		listPanel.add(scroll);
		
		List<DogDTO> list = dogDAO.listDogUser();
		
		
		int count = 0;
		int x=0; int y=0;
		int height = 800;
		
		for(DogDTO dog : list) {
			
			RoundPanel detailPanel = new RoundPanel();
			detailPanel.setBounds(x, y, 300, 380);
			detailPanel.setRoundPanel(15, 15, 50, 50);
			detailPanel.setBackground(new Color(205, 194, 174));
			detailPanel.setLayout(null);
			dogPanel.add(detailPanel);
			
		
			ImageIcon icon = new ImageIcon("D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\dog\\"+dog.getDogImage());
			dog.getDetailBtn().setBounds(0, 0, 300, 300);
			dog.getDetailBtn().setIcon(icon);
			dog.getDetailBtn().setBorderPainted(false);
			dog.getDetailBtn().setFocusPainted(false);
			dog.getDetailBtn().setContentAreaFilled(false);
	        
//	        JLabel desc = new JLabel("이름 : " + dog.getDogName());
	        JLabel desc = new JLabel(dog.getDogName());
//	        desc.setText("이름: " + dog.getDogName() + " 종: " + dog.getDogSpe() + " 나이: " + dog.getDogAge());
	        desc.setBounds(50, 300, 200, 40);
	        desc.setBackground(new Color(205, 194, 174));
	        desc.setFont(new Font("강원교육튼튼", Font.PLAIN, 25));
	        desc.setForeground(new Color(53, 66, 89));
	        desc.setHorizontalAlignment(JLabel.CENTER);
	        desc.setOpaque(true);
	        desc.setVisible(true);
	        
//	        JLabel desc2 = new JLabel("종 : " + dog.getDogSpe());
	        JLabel desc2 = new JLabel("종은 " + dog.getDogSpe() + ", " + dog.getDogAge() + "살이에요!");
	        desc2.setBounds(25, 340, 250, 30);
	        desc2.setBackground(new Color(205, 194, 174));
	        desc2.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
	        desc2.setForeground(new Color(53, 66, 89));
	        desc2.setHorizontalAlignment(JLabel.CENTER);
	        desc2.setOpaque(true);
	        desc2.setVisible(true);
	        	        
	        detailPanel.add(dog.getDetailBtn());
	        detailPanel.add(desc);
	        detailPanel.add(desc2);
	        count++;
			x+=350;
			
			if(count%3==0) {
				x=0;
				y+=400;
				height+=400;
				dogPanel.setPreferredSize(new Dimension(1100, height));
			}
			
			
			dog.getDetailBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					MainFrame.dog.setDogCode(dog.getDogCode());
					MainFrame.dog.setMemCode(dog.getMemCode());
					MainFrame.dog.setDogName(dog.getDogName());
					MainFrame.dog.setDogImage(dog.getDogImage());
					MainFrame.dog.setDogAge(dog.getDogAge());
					MainFrame.dog.setDogSpe(dog.getDogSpe());
					MainFrame.dog.setDogIno(dog.getDogIno());
					MainFrame.dog.setDogNeu(dog.getDogNeu());
					MainFrame.dog.setDogSex(dog.getDogSex());
					MainFrame.dog.setDogDis(dog.getDogDis());
					
					DogDetailPage dogDetailPage = new DogDetailPage();
					dogDetailPage.frame.setVisible(true);
					
					
				}
			});
			
		}
		
		
	}
	

}
