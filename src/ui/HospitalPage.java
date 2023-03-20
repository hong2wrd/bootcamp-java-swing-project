package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import dao.HospitalDAO;
import dto.HospitalDTO;
import graphics.RoundButton;
import graphics.RoundPanel;

public class HospitalPage {
	
//	protected JFrame frame;
	protected RoundPanel main;
	protected RoundPanel mainPanel;
	protected RoundPanel hospitalPanel;
	
	protected RoundPanel list;
	protected RoundPanel list1;

	protected JLabel list1Label, list1Tel, list1Addr;
	
	protected JLabel hospitalLabel;
	
	protected RoundButton backBtn;
	protected RoundButton addHosBtn;
	
	protected JScrollPane scroll;
	
	private HospitalDAO hosDAO = new HospitalDAO();
	
	public HospitalPage() {
		
		
	    mainPanel = new RoundPanel();
	    mainPanel.setBackground(new Color(194, 222, 209, 100));
	    mainPanel.setLayout(null);
	    
	    hospitalPanel = new RoundPanel();
	    hospitalPanel.setBackground(new Color(236, 229, 199));
	    hospitalPanel.setLocation(450, 180);
	    hospitalPanel.setPreferredSize(new Dimension(700, 600));
	    hospitalPanel.setLayout(null);
	    
	    scroll = new JScrollPane(hospitalPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	    							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(450, 180, 700, 600);
	    scroll.createVerticalScrollBar();
	    scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(205, 194, 174);
		    }
		});
	    mainPanel.add(scroll);
	    
	    /* 목록 */
	    list = new RoundPanel();
	    list.setBounds(0, 25, 700, 600);
//	    list.setBackground(new Color(255, 255, 255));
	    list.setBackground(new Color(236, 229, 199));
	    list.setRoundPanel(50, 50, 5, 50);
	    list.setLayout(null);
	    hospitalPanel.add(list);
	    
	    RoundPanel shelterNamePanel = new RoundPanel();
	    shelterNamePanel.setBackground(new Color(236, 229, 199));
	    shelterNamePanel.setBounds(450, 100, 700, 80);
	    shelterNamePanel.setLayout(null);
	    mainPanel.add(shelterNamePanel);
	    
	    /* 버튼 패널 */
	    RoundPanel buttonPanel = new RoundPanel();
	    buttonPanel.setBackground(new Color(236, 229, 199));
	    buttonPanel.setBounds(450, 780, 700, 100);
	    buttonPanel.setLayout(null);
	    mainPanel.add(buttonPanel);
	    
	    
	    /* 페이지 이름 */
	    hospitalLabel = new JLabel("동물병원");
	    hospitalLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 40));
	    hospitalLabel.setForeground(new Color(53, 66, 89));
	    hospitalLabel.setBounds(0, 0, 700, 80);
	    hospitalLabel.setHorizontalAlignment(JLabel.CENTER);
	    hospitalLabel.setVerticalAlignment(JLabel.CENTER);
	    shelterNamePanel.add(hospitalLabel);
	    
	    List<HospitalDTO> hosList = hosDAO.hospitalList();
	    
	    int y = 0;
	    int x = 25;
	    int count = 0;
	    int first = 0;
	    int height = 700;
	    
	    for(HospitalDTO dto : hosList) {
	    	
	    	 /* list1 */
		    list1 = new RoundPanel();
		    list1.setBounds(30, y, 540, 100); // 15
//		    list1.setBackground(new Color(255, 255, 255));
		    list1.setBackground(new Color(205, 194, 174));
		    list1.setRoundPanel(50, 50, 5, 50);
		    list1.setLayout(null);
		    list.add(list1);
		    
		    list1Label = new JLabel(dto.getHosName());
		    list1Label.setBounds(0, 0, 120, 100);
		    list1Label.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		    list1Label.setForeground(new Color(53, 66, 89));
		    list1Label.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Label);
		    
		    list1Tel = new JLabel(dto.getHosPh1()+"-"+dto.getHosPh2()+"-"+dto.getHosPh3());
		    list1Tel.setBounds(120, 0, 150, 100);
		    list1Tel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		    list1Tel.setForeground(new Color(53, 66, 89));
		    list1Tel.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Tel);
		    
		    list1Addr = new JLabel(dto.getHosAddr());
		    list1Addr.setBounds(270, 0, 300, 100);
		    list1Addr.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		    list1Addr.setForeground(new Color(53, 66, 89));
		    list1Addr.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Addr);
		    
		    list.add(dto.getSelectHosBtn());
		    dto.getSelectHosBtn().setRoundButton(50, 50);
		    dto.getSelectHosBtn().setBounds(600, x, 50, 50);
		    dto.getSelectHosBtn().setBackground(new Color(205, 194, 174));
		    dto.getSelectHosBtn().setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		    dto.getSelectHosBtn().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					MainFrame.selectedHos.setHosCode(dto.getHosCode());
					MainFrame.selectedHos.setHosName(dto.getHosName());
					MainFrame.selectedHos.setHosPh1(dto.getHosPh1());
					MainFrame.selectedHos.setHosPh2(dto.getHosPh2());
					MainFrame.selectedHos.setHosPh3(dto.getHosPh3());
					
					HospitalDetailPage hospitalDetailPage = new HospitalDetailPage();
					hospitalDetailPage.nameField.setText(dto.getHosName());
					hospitalDetailPage.addrField.setText(dto.getHosAddr());
					hospitalDetailPage.phoneField1.setText(dto.getHosPh1());
					hospitalDetailPage.phoneField2.setText(dto.getHosPh2());
					hospitalDetailPage.phoneField3.setText(dto.getHosPh3());
					
					MainFrame.mainPanel.add(hospitalDetailPage.mainPanel, "hospitalDetailPanel");
					
					MainFrame.card.show(MainFrame.mainPanel, "hospitalDetailPanel");
					
				}
			});
		    
		    y+=130;
	    	x+=130;
	    	if(first==0) {
	    		count++;
		    	if(count%5==0) {
		    		first++;
		    		count=0;
		    		height+=100;
		    		list.setSize(new Dimension(700, height));
		    		hospitalPanel.setPreferredSize(new Dimension(700, height));
		    	}
	    	}else {
	    		height+=100;
	    		list.setSize(new Dimension(700, height));
	    		hospitalPanel.setPreferredSize(new Dimension(700, height));
	    	}
	    }
	    
	   
	    /* 등록 버튼 */
	    if(MainFrame.loginToken==0) {
			addHosBtn = new RoundButton("등록하기");
			addHosBtn.setBounds(360, 35, 200, 35);
			addHosBtn.setBackground(new Color(205, 194, 174));
			addHosBtn.setRoundButton(10, 10);
			addHosBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			addHosBtn.setForeground(new Color(53, 66, 89));
			addHosBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.card.show(MainFrame.mainPanel, "hospitalAddPanel");
				}
			});
			buttonPanel.add(addHosBtn);
			
			backBtn = new RoundButton("뒤로가기");
			backBtn.setBounds(140, 35, 200, 35);
			backBtn.setBackground(new Color(53, 66, 89));
			backBtn.setRoundButton(10, 10);
			backBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			backBtn.setForeground(new Color(205, 194, 174));
			backBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.adminList = new AdminListPage();
					MainFrame.adminList.adminListPanel.add(MainFrame.menu.topPanel);
					MainFrame.adminList.adminListPanel.add(MainFrame.menu.navPanel);
					MainFrame.mainPanel.add(MainFrame.adminList.adminListPanel, "adminList");
					MainFrame.card.show(MainFrame.mainPanel, "adminList");
				}
			});
			buttonPanel.add(backBtn);
		}else {
			/* 버튼 */
			backBtn = new RoundButton("뒤로가기");
			backBtn.setBounds(250, 35, 200, 35);
			backBtn.setBackground(new Color(53, 66, 89));
			backBtn.setRoundButton(10, 10);
			backBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			backBtn.setForeground(new Color(205, 194, 174));
			backBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(MainFrame.loginToken==0) {
						MainFrame.adminList = new AdminListPage();
						MainFrame.adminList.adminListPanel.add(MainFrame.menu.topPanel);
						MainFrame.adminList.adminListPanel.add(MainFrame.menu.navPanel);
						MainFrame.mainPanel.add(MainFrame.adminList.adminListPanel, "adminList");
						MainFrame.card.show(MainFrame.mainPanel, "adminList");
					}else if(MainFrame.loginToken==1) {
						MainFrame.listPage = new ListPage();
						MainFrame.listPage.listPanel.add(MainFrame.menu.topPanel);
						MainFrame.listPage.listPanel.add(MainFrame.menu.navPanel);
						MainFrame.mainPanel.add(MainFrame.listPage.listPanel, "listPanel");
						MainFrame.card.show(MainFrame.mainPanel, "listPanel");
					}    	  
				}
			});
			buttonPanel.add(backBtn);
		}
	   
		
		
		
		
	}
	
	
}
