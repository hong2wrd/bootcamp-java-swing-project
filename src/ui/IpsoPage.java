package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import graphics.CustomRadioButton;
import graphics.RoundButton;
import graphics.RoundPanel;
import graphics.RoundTextField;

public class IpsoPage {
		
//	protected JFrame frame;
	protected RoundPanel mainPanel;
	protected RoundPanel ipsoPanel;
	
	protected JLabel dogLabel;
	protected RoundPanel namePanel;
	protected RoundPanel spePanel;
	protected RoundPanel agePanel;
	protected RoundPanel imagePanel;
	protected RoundPanel neuPanel;
	protected RoundPanel sexPanel;
	protected RoundPanel disPanel;
	protected RoundPanel inoPanel;
	
	protected JLabel name;
	protected JLabel spec;
	protected JLabel age;
	protected JLabel img;
	protected JLabel neu;
	protected JLabel sex;
	protected JLabel dis;
	protected JLabel ino;
	
	protected RoundTextField dogName;
	protected RoundTextField dogSpe;
	protected RoundTextField dogAge;
	protected RoundTextField dogImage;
	
	protected CustomRadioButton dogNeuT;
	protected CustomRadioButton dogNeuF;

	protected CustomRadioButton dogSexM;
	protected CustomRadioButton dogSexF;
	
	protected CustomRadioButton dogDisT;
	protected CustomRadioButton dogDisF;
	
	protected CustomRadioButton dogInoT;
	protected CustomRadioButton dogIno4;
	protected CustomRadioButton dogIno3;
	protected CustomRadioButton dogIno2;
	protected CustomRadioButton dogIno1;
	protected CustomRadioButton dogInoF;
	
	protected ButtonGroup neuGroup;
	protected ButtonGroup sexGroup;
	protected ButtonGroup disGroup;
	protected ButtonGroup inoGroup;
	
	protected RoundButton imgBtn;
	protected RoundButton submitBtn;
	protected RoundButton cancelBtn;
		
		private static String path = "D:\\20220607\\java_work\\MiniProject2\\src\\images\\main\\dog\\"; // PC마다 수정
		
		public IpsoPage() {
			
//			frame = new JFrame();
//			frame.setSize(1600, 1000);
//			frame.setLocationRelativeTo(null);
//		    frame.setUndecorated(true);
//		    frame.setLayout(null);
//		    frame.setBackground(new Color(194, 222, 209, 100));
//		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			mainPanel = new RoundPanel();
			mainPanel.setBackground(new Color(194, 222, 209, 100));
			mainPanel.setLayout(null);
			
		    ipsoPanel = new RoundPanel();
		    ipsoPanel.setRoundPanel(50, 50, 50, 50);
		    ipsoPanel.setBounds(500, 25, 600, 900);
		    ipsoPanel.setBackground(new Color(236, 229, 199));
		    ipsoPanel.setLayout(null);
		    mainPanel.add(ipsoPanel);
//			frame.add(ipsoPanel);
		    
			/* 페이지 이름 */
			dogLabel = new JLabel("신청서 작성");
			dogLabel.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 40));
			dogLabel.setForeground(new Color(53, 66, 89));
			dogLabel.setBounds(200, 25, 200, 100);
			dogLabel.setHorizontalAlignment(JLabel.CENTER);
			ipsoPanel.add(dogLabel);
			
			/* 패널(텍스트) */
			namePanel = new RoundPanel();
			namePanel.setBounds(100, 150, 400, 50);
			namePanel.setBackground(new Color(255, 255, 255));
			namePanel.setRoundPanel(50, 50, 5, 50);
			namePanel.setLayout(null);
			ipsoPanel.add(namePanel);
			
			spePanel = new RoundPanel();
			spePanel.setBounds(100, 220, 400, 50);
			spePanel.setBackground(new Color(255, 255, 255));
			spePanel.setRoundPanel(50, 50, 5, 50);
			spePanel.setLayout(null);
			ipsoPanel.add(spePanel);
			
			agePanel = new RoundPanel();
			agePanel.setBounds(100, 290, 400, 50);
			agePanel.setBackground(new Color(255, 255, 255));
			agePanel.setRoundPanel(50, 50, 5, 50);
			agePanel.setLayout(null);
			ipsoPanel.add(agePanel);
			
			imagePanel = new RoundPanel();
			imagePanel.setBounds(100, 360, 400, 50);
			imagePanel.setBackground(new Color(255, 255, 255));
			imagePanel.setRoundPanel(50, 50, 5, 50);
			imagePanel.setLayout(null);
			ipsoPanel.add(imagePanel);
			
			/* 패널(버튼) */
			neuPanel = new RoundPanel();
			neuPanel.setBounds(100, 440, 400, 70);
			neuPanel.setBackground(new Color(255, 255, 255));
			neuPanel.setRoundPanel(50, 50, 5, 50);
			neuPanel.setLayout(null);
			ipsoPanel.add(neuPanel);
			
			sexPanel = new RoundPanel();
			sexPanel.setBounds(100, 530, 400, 70);
			sexPanel.setBackground(new Color(255, 255, 255));
			sexPanel.setRoundPanel(50, 50, 5, 50);
			sexPanel.setLayout(null);
			ipsoPanel.add(sexPanel);
			
			disPanel = new RoundPanel();
			disPanel.setBounds(100, 620, 400, 70);
			disPanel.setBackground(new Color(255, 255, 255));
			disPanel.setRoundPanel(50, 50, 5, 50);
			disPanel.setLayout(null);
			ipsoPanel.add(disPanel);
			
			inoPanel = new RoundPanel();
			inoPanel.setBounds(100, 710, 400, 70);
			inoPanel.setBackground(new Color(255, 255, 255));
			inoPanel.setRoundPanel(50, 50, 5, 50);
			inoPanel.setLayout(null);
			ipsoPanel.add(inoPanel);
			
			/* 라벨(텍스트) */
			name = new JLabel("이름 : ");
			name.setBounds(0, 0, 150, 50);
			name.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			name.setForeground(new Color(53, 66, 89));
			name.setHorizontalAlignment(JLabel.CENTER);
			namePanel.add(name);
			
			spec = new JLabel("종 : ");
			spec.setBounds(0, 0, 150, 50);
			spec.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			spec.setForeground(new Color(53, 66, 89));
			spec.setHorizontalAlignment(JLabel.CENTER);
			spePanel.add(spec);
			
			age = new JLabel("나이 : ");
			age.setBounds(0, 0, 150, 50);
			age.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			age.setForeground(new Color(53, 66, 89));
			age.setHorizontalAlignment(JLabel.CENTER);
			agePanel.add(age);
			
			img = new JLabel("사진 : ");
			img.setBounds(0, 0, 150, 50);
			img.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			img.setForeground(new Color(53, 66, 89));
			img.setHorizontalAlignment(JLabel.CENTER);
			imagePanel.add(img);
			
			/* 라벨(라디오버튼) */
			neu = new JLabel("중성화 : ");
			neu.setBounds(0, 0, 150, 70);
			neu.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			neu.setForeground(new Color(53, 66, 89));
			neu.setHorizontalAlignment(JLabel.CENTER);
			neuPanel.add(neu);
			
			sex = new JLabel("성별 : ");
			sex.setBounds(0, 0, 150, 70);
			sex.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			sex.setForeground(new Color(53, 66, 89));
			sex.setHorizontalAlignment(JLabel.CENTER);
			sexPanel.add(sex);
			
			dis = new JLabel("건강상태 : ");
			dis.setBounds(0, 0, 150, 70);
			dis.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			dis.setForeground(new Color(53, 66, 89));
			dis.setHorizontalAlignment(JLabel.CENTER);
			disPanel.add(dis);
			
			ino = new JLabel("예방접종 : ");
			ino.setBounds(0, 0, 150, 70);
			ino.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 25));
			ino.setForeground(new Color(53, 66, 89));
			ino.setHorizontalAlignment(JLabel.CENTER);
			inoPanel.add(ino);
			
			/* 텍스트필드 */
			dogName = new RoundTextField(50);
			dogName.setBounds(150, 10, 200, 30);
			dogName.setBorderColor(255, 255, 255);
			dogName.setHorizontalAlignment(JTextField.CENTER);
			dogName.setFont(new Font("강원교육모두 Light", Font.PLAIN, 20));
			namePanel.add(dogName);

			dogSpe = new RoundTextField(50);
			dogSpe.setBounds(150, 10, 200, 30);
			dogSpe.setBorderColor(255, 255, 255);
			dogSpe.setHorizontalAlignment(JTextField.CENTER);
			dogSpe.setFont(new Font("강원교육모두 Light", Font.PLAIN, 20));
			spePanel.add(dogSpe);

			dogAge = new RoundTextField(50);
			dogAge.setBounds(150, 10, 200, 30);
			dogAge.setBorderColor(255, 255, 255);
			dogAge.setHorizontalAlignment(JTextField.CENTER);
			dogAge.setFont(new Font("강원교육모두 Light", Font.PLAIN, 20));
			agePanel.add(dogAge);

			dogImage = new RoundTextField(200);
			dogImage.setBounds(150, 10, 200, 31);
			dogImage.setBorderColor(255, 255, 255);
			dogImage.setHorizontalAlignment(JTextField.CENTER);
			dogImage.setFont(new Font("강원교육모두 Light", Font.PLAIN, 20));
			dogImage.setEditable(false);
			imagePanel.add(dogImage);
			
			/* 라디오버튼 */
			neuGroup = new ButtonGroup();
			
			dogNeuT = new CustomRadioButton(53, 66, 89);
			dogNeuT.setBounds(150, 0, 100, 70);
			dogNeuT.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogNeuT.setText("했어요");
			dogNeuT.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			neuPanel.add(dogNeuT);
			neuGroup.add(dogNeuT);
			
			dogNeuF = new CustomRadioButton(53, 66, 89);
			dogNeuF.setBounds(250, 0, 100, 70);
			dogNeuF.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogNeuF.setText("안했어요");
			dogNeuF.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			neuPanel.add(dogNeuF);
			neuGroup.add(dogNeuF);
			
			sexGroup = new ButtonGroup();
			
			dogSexM = new CustomRadioButton(53, 66, 89);
			dogSexM.setBounds(150, 0, 100, 70);
			dogSexM.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogSexM.setText("남아에요");
			dogSexM.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			sexPanel.add(dogSexM);
			sexGroup.add(dogSexM);
			
			dogSexF = new CustomRadioButton(53, 66, 89);
			dogSexF.setBounds(250, 0, 100, 70);
			dogSexF.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogSexF.setText("여아에요");
			dogSexF.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			sexPanel.add(dogSexF);
			sexGroup.add(dogSexF);
			
			disGroup = new ButtonGroup();
			
			dogDisT = new CustomRadioButton(53, 66, 89);
			dogDisT.setBounds(150, 0, 100, 70);
			dogDisT.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogDisT.setText("건강해요");
			dogDisT.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			disPanel.add(dogDisT);
			disGroup.add(dogDisT);
			
			dogDisF = new CustomRadioButton(53, 66, 89);
			dogDisF.setBounds(250, 0, 100, 70);
			dogDisF.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogDisF.setText("조금 아파요");
			dogDisF.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			disPanel.add(dogDisF);
			disGroup.add(dogDisF);
			
			inoGroup = new ButtonGroup();
			
			dogInoT = new CustomRadioButton(53, 66, 89);
			dogInoT.setBounds(150, 0, 100, 35);
			dogInoT.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogInoT.setText("접종 완료");
			dogInoT.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogInoT);
			inoGroup.add(dogInoT);
			
			dogInoF = new CustomRadioButton(53, 66, 89);
			dogInoF.setBounds(250, 0, 100, 35);
			dogInoF.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogInoF.setText("접종 미완료");
			dogInoF.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogInoF);
			inoGroup.add(dogInoF);
			
			dogIno4 = new CustomRadioButton(53, 66, 89);
			dogIno4.setBounds(150, 35, 50, 35);
			dogIno4.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogIno4.setText("4차");
			dogIno4.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogIno4);
			inoGroup.add(dogIno4);
			
			dogIno3 = new CustomRadioButton(53, 66, 89);
			dogIno3.setBounds(200, 35, 50, 35);
			dogIno3.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogIno3.setText("3차");
			dogIno3.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogIno3);
			inoGroup.add(dogIno3);
			
			dogIno2 = new CustomRadioButton(53, 66, 89);
			dogIno2.setBounds(250, 35, 50, 35);
			dogIno2.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogIno2.setText("2차");
			dogIno2.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogIno2);
			inoGroup.add(dogIno2);
			
			dogIno1 = new CustomRadioButton(53, 66, 89);
			dogIno1.setBounds(300, 35, 50, 35);
			dogIno1.setBorder(new TitledBorder(new LineBorder(new Color(205, 240, 234), 2)));
			dogIno1.setText("1차");
			dogIno1.setFont(new Font("강원교육모두 Light", Font.PLAIN, 15));
			inoPanel.add(dogIno1);
			inoGroup.add(dogIno1);
			
			/* 버튼 */
			imgBtn = new RoundButton("a        선택");
			imgBtn.setBounds(300, 10, 90, 30);
			imgBtn.setBackground(new Color(53, 66, 89));
			imgBtn.setRoundButton(30, 30);
			imgBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 18));
			imgBtn.setForeground(new Color(205, 194, 174));
			imagePanel.add(imgBtn);
			
			imgBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					JFileChooser jc = new JFileChooser();
					int res = jc.showOpenDialog(null);
					
					if(res==jc.APPROVE_OPTION) {
						int count = 0;
						File f = jc.getSelectedFile();
						String fname = f.getName();
							
						int pos = fname.lastIndexOf(".");
						String fileName = fname.substring(0,pos);
						String ext = fname.substring(pos);
						
						try {
							File file = new File(path+fname);
							while(true) {
								if(file.exists()) {
									count++;
									file = new File(path+fileName+count+ext);
								}else {
									break;
								}
							}
							String filePath = "";
							if(count==0) {
								filePath = path+fname;
								dogImage.setText(fname);
							}else {
								filePath = path + fileName+count+ext;
								dogImage.setText(fileName+count+ext);
							}
							
							FileInputStream fis = new FileInputStream(f);
							FileOutputStream fos = new FileOutputStream(filePath);
							
							int i = 0;
							byte[] buffer = new byte[1024];
							
							while((i=fis.read(buffer, 0, 1024))!=-1) {
								fos.write(buffer, 0, i);
							}
							
							fis.close();
							fos.close();
							
							
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					
				}
				
			});
			
			submitBtn = new RoundButton("신청하기");
			submitBtn.setBounds(100, 820, 200, 35);
			submitBtn.setBackground(new Color(205, 194, 174));
			submitBtn.setRoundButton(10, 10);
			submitBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			submitBtn.setForeground(new Color(53, 66, 89));
			ipsoPanel.add(submitBtn);
			
			cancelBtn = new RoundButton("취소");
			cancelBtn.setBounds(310, 820, 190, 35);
			cancelBtn.setBackground(new Color(53, 66, 89));
			cancelBtn.setRoundButton(10, 10);
			cancelBtn.setFont(new Font("강원교육모두 Bold", Font.PLAIN, 20));
			cancelBtn.setForeground(new Color(205, 194, 174));
			ipsoPanel.add(cancelBtn);
			
//			cancelBtn.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.exit(0);
//				}
//				
//			});
			
		}
		
//		public static void main(String[] args) {
//			IpsoPage ap = new IpsoPage();
//			ap.frame.setVisible(true);
//		}
	
}
