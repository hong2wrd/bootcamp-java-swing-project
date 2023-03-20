package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.SubmitDAO;
import dto.SubmitDTO;
import graphics.RoundPanel;

public class AdminSubmitPage {

   protected JPanel adminSubmitPanel;
   protected JPanel submitPanel;

   protected JTextField userField;
   
   protected JButton listBtn;
   protected JButton adoptBtn;
   protected JButton unadoptBtn;
   protected JButton shelterBtn;
   protected JButton hospitalBtn;
   
   protected JScrollPane scroll;
   
   private SubmitDAO submitDAO = new SubmitDAO();
   
   public AdminSubmitPage() {
      
      /* list panel */
      adminSubmitPanel = new JPanel();
      adminSubmitPanel.setBackground(new Color(236, 229, 199));
      adminSubmitPanel.setLayout(null);
      
      /* dog panel */
      submitPanel = new JPanel();
      submitPanel.setBackground(new Color(236, 229, 199));
      submitPanel.setPreferredSize(new Dimension(1100, 750));
      submitPanel.setLayout(null);
      
      /* scroll pane*/
      scroll = new JScrollPane(submitPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scroll.setBounds(450, 180, 1100, 750);
      scroll.setBackground(new Color(236, 229, 199));
      scroll.setBorder(null);
      scroll.createVerticalScrollBar();
      adminSubmitPanel.add(scroll);

      /* column panel */
      JPanel column = new JPanel();
      column.setBounds(0, 0, 1100, 50);
      column.setBackground(new Color(236, 229, 199));
      column.setLayout(null);
      submitPanel.add(column);
      
      // columns
      JLabel col1 = new JLabel("접 수  번 호");
      col1.setBounds(25, 0, 150, 50);
      col1.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
      col1.setForeground(new Color(53, 66, 89));
      col1.setHorizontalAlignment(JLabel.CENTER);
      
      JLabel col2 = new JLabel("강 아 지  번 호");
      col2.setBounds(175, 0, 150, 50);
      col2.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
      col2.setForeground(new Color(53, 66, 89));
      col2.setHorizontalAlignment(JLabel.CENTER);
      
      JLabel col2_2 = new JLabel("강 아 지  이 름");
      col2_2.setBounds(325, 0, 150, 50);
      col2_2.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
      col2_2.setForeground(new Color(53, 66, 89));
      col2_2.setHorizontalAlignment(JLabel.CENTER);
      
      JLabel col3 = new JLabel("회 원  번 호");
      col3.setBounds(474, 0, 150, 50);
      col3.setFont(new Font("강원교육튼튼", Font.PLAIN, 20));
      col3.setForeground(new Color(53, 66, 89));
      col3.setHorizontalAlignment(JLabel.CENTER);
      
      column.add(col1);
      column.add(col2);
      column.add(col3);
      column.add(col2_2);
      
      // 입양신청 리스트
      List<SubmitDTO> list = submitDAO.submitList();

      int count = 0;
      int y=100;
      int height = 750;
      
      for(SubmitDTO sub : list) {
         
         RoundPanel rows = new RoundPanel();
         rows.setBounds(0, y, 1100, 50);
         rows.setRoundPanel(50, 5, 50, 5);
         rows.setBackground(new Color(205, 194, 174));
         rows.setLayout(null);
         submitPanel.add(rows);
         
         JLabel row1 = new JLabel();
         row1.setBounds(50, 0, 100, 50);
         row1.setText(String.valueOf(sub.getSubCode()));
         row1.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
         row1.setForeground(new Color(53, 66, 89));
         row1.setHorizontalAlignment(JLabel.CENTER);
         
         JLabel row2 = new JLabel();
         row2.setBounds(200, 0, 100, 50);
         row2.setText(String.valueOf(sub.getDogCode()));
         row2.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
         row2.setForeground(new Color(53, 66, 89));
         row2.setHorizontalAlignment(JLabel.CENTER);
         
         JLabel row2_2 = new JLabel();
         row2_2.setBounds(350, 0, 100, 50);
         row2_2.setText(String.valueOf(sub.getDogName()));
         row2_2.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
         row2_2.setForeground(new Color(53, 66, 89));
         row2_2.setHorizontalAlignment(JLabel.CENTER);
         
         JLabel row3 = new JLabel();
         row3.setBounds(500, 0, 100, 50);
         row3.setText(String.valueOf(sub.getMemCode()));
         row3.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
         row3.setForeground(new Color(53, 66, 89));
         row3.setHorizontalAlignment(JLabel.CENTER);
         
         rows.add(row1);
         rows.add(row2);
         rows.add(row2_2);
         rows.add(row3);
         
         y+=100;
         count++;
         
         if(count%7==0) {
            height+=100;
            submitPanel.setPreferredSize(new Dimension(1100, height));
         }
         
      }
      
      
      
      
      

   }
      
}