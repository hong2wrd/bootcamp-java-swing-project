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

import dao.ShelterDAO;
import dto.ShelterDTO;
import graphics.RoundButton;
import graphics.RoundPanel;

public class ShelterPage {
	
//	protected JFrame frame;
	protected RoundPanel main;
	protected RoundPanel mainPanel;
	protected RoundPanel shelterPanel;
	
	protected RoundPanel list;
	protected RoundPanel list1;

	protected JLabel list1Label, list1Tel, list1Addr;
	
	protected JLabel shelterLabel;
	
	protected RoundButton backBtn;
	protected RoundButton addShelBtn;
	
	protected JScrollPane scroll;
	
	private ShelterDAO shelDAO = new ShelterDAO();
	
	public ShelterPage() {
		
		
	    mainPanel = new RoundPanel();
	    mainPanel.setBackground(new Color(194, 222, 209, 100));
	    mainPanel.setLayout(null);
	    
	    shelterPanel = new RoundPanel();
	    shelterPanel.setBackground(new Color(236, 229, 199));
	    shelterPanel.setLocation(450, 180);
	    shelterPanel.setPreferredSize(new Dimension(700, 600));
	    shelterPanel.setLayout(null);
	    
	    scroll = new JScrollPane(shelterPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
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
	    shelterPanel.add(list);
	    
	    /* 페이지 이름 패널 */
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
	    shelterLabel = new JLabel("보호소");
	    shelterLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 40));
	    shelterLabel.setForeground(new Color(53, 66, 89));
	    shelterLabel.setBounds(0, 0, 700, 80);
	    shelterLabel.setVerticalAlignment(JLabel.CENTER);
	    shelterLabel.setHorizontalAlignment(JLabel.CENTER);
	    shelterNamePanel.add(shelterLabel);
	    
	    List<ShelterDTO> shelList = shelDAO.shelterList();
	    
	    int y = 0;
	    int x = 25;
	    int count = 0;
	    int first = 0;
	    int height = 700;
	    
	    for(ShelterDTO shel : shelList) {
	    	
	    	 /* list1 */
		    list1 = new RoundPanel();
		    list1.setBounds(30, y, 540, 100); // 15
//		    list1.setBackground(new Color(255, 255, 255));
		    list1.setBackground(new Color(205, 194, 174));
		    list1.setRoundPanel(50, 50, 5, 50);
		    list1.setLayout(null);
		    list.add(list1);
		    
		    list1Label = new JLabel(shel.getShelName());
		    list1Label.setBounds(0, 0, 120, 100);
		    list1Label.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
		    list1Label.setForeground(new Color(53, 66, 89));
		    list1Label.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Label);
		    
		    list1Tel = new JLabel(shel.getShelPh1()+"-"+shel.getShelPh2()+"-"+shel.getShelPh3());
		    list1Tel.setBounds(120, 0, 120, 100);
		    list1Tel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		    list1Tel.setForeground(new Color(53, 66, 89));
		    list1Tel.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Tel);
		    
		    list1Addr = new JLabel(shel.getShelAddr());
		    list1Addr.setBounds(240, 0, 300, 100);
		    list1Addr.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
		    list1Addr.setForeground(new Color(53, 66, 89));
		    list1Addr.setHorizontalAlignment(JLabel.CENTER);
		    list1.add(list1Addr);
		    
		    list.add(shel.getSelectShelBtn());
		    shel.getSelectShelBtn().setRoundButton(50, 50);
		    shel.getSelectShelBtn().setBounds(600, x, 50, 50);
		    shel.getSelectShelBtn().setBackground(new Color(205, 194, 174));
		    shel.getSelectShelBtn().setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
		    shel.getSelectShelBtn().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					MainFrame.selectedShel.setShelCode(shel.getShelCode());
					MainFrame.selectedShel.setShelName(shel.getShelName());
					MainFrame.selectedShel.setShelPh1(shel.getShelPh1());
					MainFrame.selectedShel.setShelPh2(shel.getShelPh2());
					MainFrame.selectedShel.setShelPh3(shel.getShelPh3());
					
					ShelterDetailPage shelterDetailPage = new ShelterDetailPage();
					shelterDetailPage.nameField.setText(shel.getShelName());
					shelterDetailPage.addrField.setText(shel.getShelAddr());
					shelterDetailPage.phoneField1.setText(shel.getShelPh1());
					shelterDetailPage.phoneField2.setText(shel.getShelPh2());
					shelterDetailPage.phoneField3.setText(shel.getShelPh3());
					
					MainFrame.mainPanel.add(shelterDetailPage.mainPanel, "shelterDetailPanel");
					
					MainFrame.card.show(MainFrame.mainPanel, "shelterDetailPanel");
					
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
	    			shelterPanel.setPreferredSize(new Dimension(700, height));
	    		}
	    	}else {
	    		height+=100;
	    		list.setSize(new Dimension(700, height));
    			shelterPanel.setPreferredSize(new Dimension(700, height));
	    	}
	    	
	    }
	    
	   
	    /* 등록 버튼 */
	    if(MainFrame.loginToken==0) {
			addShelBtn = new RoundButton("등록하기");
			addShelBtn.setBounds(360, 35, 200, 35);
			addShelBtn.setBackground(new Color(205, 194, 174));
			addShelBtn.setRoundButton(10, 10);
			addShelBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			addShelBtn.setForeground(new Color(53, 66, 89));
			addShelBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.card.show(MainFrame.mainPanel, "shelterAddPanel");
				
				}
			});
			buttonPanel.add(addShelBtn);
			
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
					MainFrame.listPage = new ListPage();
					MainFrame.listPage.listPanel.add(MainFrame.menu.topPanel);
					MainFrame.listPage.listPanel.add(MainFrame.menu.navPanel);
					MainFrame.mainPanel.add(MainFrame.listPage.listPanel, "listPanel");
					MainFrame.card.show(MainFrame.mainPanel, "listPanel");
				}
			});
			buttonPanel.add(backBtn);
			
		}
	   
	    
		
		
		
		
		
	}
	
	
}
