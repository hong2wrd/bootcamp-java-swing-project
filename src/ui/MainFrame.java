package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.DogDAO;
import dao.MemberDAO;
import dialog.AppDialog;
import dialog.ConfirmDialog;
import dialog.DataRequestDialog;
import dialog.DeleteDialog;
import dialog.ErrorDialog;
import dialog.IdDuplicateDialog;
import dialog.LogInDialog;
import dialog.LogInFailedIdDialog;
import dialog.LogInFailedPassDialog;
import dialog.LogOutDialog;
import dialog.PassChangeDialog;
import dialog.RegiDialog;
import dialog.SignUpDialog;
import dialog.TermsDialog;
import dialog.UserDataChangeDialog;
import dialog.UserDeleteDialog;
import dto.DogDTO;
import dto.HospitalDTO;
import dto.MemberDTO;
import dto.ShelterDTO;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JPanel mainPanel;
   	public static CardLayout card = new CardLayout();

	// Menu
	public static UserMenu menu = new UserMenu();
	
	public static LogInDialog logDial = new LogInDialog();
	public static LogInFailedIdDialog logFailIdDial = new LogInFailedIdDialog();
	public static LogInFailedPassDialog logFailPassDial = new LogInFailedPassDialog();
	public static LogOutDialog logoutDial = new LogOutDialog();
	public static UserDeleteDialog userDelDial = new UserDeleteDialog();
	public static TermsDialog termsDial = new TermsDialog();
	public static UserDataChangeDialog userDataChangeDial = new UserDataChangeDialog();
	public static DataRequestDialog dataRequestDial = new DataRequestDialog();
	public static PassChangeDialog passChangeDial = new PassChangeDialog();
	public static ConfirmDialog confirmDial = new ConfirmDialog();
	public static ErrorDialog errorDial = new ErrorDialog();
	public static DeleteDialog deleteDial = new DeleteDialog();
	
	public static SignUpDialog signUpDial = new SignUpDialog();
	public static RegiDialog regiDial = new RegiDialog();
	public static AppDialog appDial = new AppDialog();
	public static IdDuplicateDialog idDuplicateDial = new IdDuplicateDialog();
	

	// Pages
	public static LoginPage loginPage = new LoginPage();
	private JoinPage joinPage = new JoinPage();
	public static ListPage listPage = new ListPage();
	public static UserInfoPage userInfoPage = new UserInfoPage();
	private IpsoPage ipsoPage = new IpsoPage();
	
	public static HospitalPage hospitalPage = new HospitalPage();
	protected static HospitalAddPage hospitalAddPage = new HospitalAddPage();
	
	public static ShelterPage shelterPage = new ShelterPage();
	protected static ShelterAddPage shelterAddPage = new ShelterAddPage();
	
	// Admin Pages
	public static AdminListPage adminList = new AdminListPage();
	public static AdminSubmitPage adminSubmit = new AdminSubmitPage();

	// DAO
	private static MemberDAO memberDAO = new MemberDAO();
	private static DogDAO dogDAO = new DogDAO();

	// DTO
	public static MemberDTO loggedin = new MemberDTO();
	public static ShelterDTO selectedShel = new ShelterDTO();
	public static HospitalDTO selectedHos = new HospitalDTO();
	public static DogDTO dog = new DogDTO();

	// Login Token
	public static int loginToken = -1;
	
	/* main frame constructor */
	public MainFrame() {

		// 프레임 가운데 띄우기 
		setTitle("Choose your Happiness");
		setSize(1600, 1000);
		setLocationRelativeTo(null);
		setUndecorated(true); // 테두리 없애기
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/* content pane */
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1600, 1000);
		contentPane.setBackground(new Color(194, 222, 209));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		/* main panel */
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1600, 1000);
		mainPanel.setBackground(new Color(194, 222, 209));
		mainPanel.setLayout(card);
		contentPane.add(mainPanel);

		// 카드에 페이지 추가
		mainPanel.add(loginPage.loginPanel, "loginPanel");
		mainPanel.add(joinPage.mainPanel, "joinPanel");
		mainPanel.add(listPage.listPanel, "listPanel");
		mainPanel.add(userInfoPage.mainPanel, "userInfoPanel");
		mainPanel.add(ipsoPage.mainPanel, "ipsoPanel");
		
		// 7.25 추가
		mainPanel.add(hospitalPage.mainPanel, "hospitalPanel");
		mainPanel.add(shelterPage.mainPanel, "shelterPanel");

		// 관리자 페이지 추가 
		mainPanel.add(adminList.adminListPanel, "adminList");
		mainPanel.add(adminSubmit.adminSubmitPanel, "adminSubmit");
		mainPanel.add(shelterAddPage.mainPanel, "shelterAddPanel");
		mainPanel.add(hospitalAddPage.mainPanel, "hospitalAddPanel");

		// 시작 페이지
		card.show(mainPanel, "loginPanel");

		// 버튼 액션 등록
		// 로그인
		loginPage.signUpBtn.addActionListener(this);
		loginPage.loginBtn.addActionListener(this);

		// 회원가입
		joinPage.cancelBtn.addActionListener(this);
		joinPage.joinBtn.addActionListener(this);

		// 입소신청
		ipsoPage.submitBtn.addActionListener(this);
		ipsoPage.cancelBtn.addActionListener(this);

		// 강아지 상세

		// 회원정보
		userInfoPage.modInfoBtn.addActionListener(this);
		userInfoPage.modPassBtn.addActionListener(this);
		userInfoPage.deleteMemberBtn.addActionListener(this);
		userInfoPage.cancelBtn.addActionListener(this);

	}

	// 프레임 시작
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}

	// 페이지 전환 버튼
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 회원가입 버튼
		if(obj==loginPage.signUpBtn) {
			termsDial.setVisible(true);
		}
		// 로그인 버튼
		else if(obj==loginPage.loginBtn) {

			String id = loginPage.idField.getText();
			String pw = String.valueOf(loginPage.passField.getPassword());

			int res = memberDAO.loginCheck(id, pw);
			if(res==0) {
				logFailIdDial.setVisible(true);
				loginPage.idField.requestFocus();
			}else if(res==-1) {
				logFailPassDial.setVisible(true);
				loginPage.passField.requestFocus();
			}else if(res==1) {
				loggedin = memberDAO.selectOneMember(id);
				logDial.setVisible(true);
				
				
				
				if(loggedin.getMemCode()==0) {
					loginToken=0;
					menu = new UserMenu();
					menu.logoutBtn.addActionListener(this);
					menu.userInfoBtn.addActionListener(this);
					menu.unadoptBtn.addActionListener(this);
					menu.adoptBtn.addActionListener(this);
					menu.shelterBtn.addActionListener(this);
					menu.hospitalBtn.addActionListener(this);
					adminList = new AdminListPage();
					adminList.adminListPanel.add(menu.topPanel);
					adminList.adminListPanel.add(menu.navPanel);
					mainPanel.add(adminList.adminListPanel, "adminList");
					card.show(mainPanel, "adminList");
				}else {
					loginToken = 1;
					menu = new UserMenu();
					menu.logoutBtn.addActionListener(this);
					menu.userInfoBtn.addActionListener(this);
					menu.unadoptBtn.addActionListener(this);
					menu.adoptBtn.addActionListener(this);
					menu.shelterBtn.addActionListener(this);
					menu.hospitalBtn.addActionListener(this);
					listPage = new ListPage();
					listPage.listPanel.add(menu.topPanel);
					listPage.listPanel.add(menu.navPanel);
					mainPanel.add(listPage.listPanel, "listPanel");
					card.show(mainPanel, "listPanel");
				}
			}

		}
		// 로그아웃 버튼
		else if(obj==menu.logoutBtn) {
			loginToken = -1;
			loggedin = new MemberDTO();
			loginPage.idField.setText("");
			loginPage.passField.setText("");
			logoutDial.setVisible(true);
			card.show(mainPanel, "loginPanel");
		}

		/* 회원가입 페이지 */
		else if(obj==joinPage.cancelBtn) {
			card.show(mainPanel, "loginPanel");
		}else if(obj==joinPage.joinBtn) {

			String id = joinPage.idField.getText();
			String pw = String.valueOf(joinPage.passField.getPassword());
			String pwConfirm = new String(joinPage.passConfirmField.getPassword());
			String name = joinPage.nameField.getText();
			String addr = joinPage.addrField.getText();
			String ph1 = joinPage.phoneField1.getText();
			String ph2 = joinPage.phoneField2.getText();
			String ph3 = joinPage.phoneField3.getText();

			if(id.isEmpty()) {
				dataRequestDial.setVisible(true);
				joinPage.idField.requestFocus();
			} else if(pw.isEmpty()) {
				dataRequestDial.setVisible(true);
				joinPage.passField.requestFocus();
			} else if(pwConfirm.isEmpty()) {
				dataRequestDial.setVisible(true);
				joinPage.passConfirmField.requestFocus();
			} else if(name.isEmpty()) {
				dataRequestDial.setVisible(true);
				joinPage.nameField.requestFocus();
			} else if(addr.isEmpty()) {
				dataRequestDial.setVisible(true);
				joinPage.addrField.requestFocus();
			} else if(ph1.length()!=3) {
				dataRequestDial.setVisible(true);
				joinPage.phoneField1.requestFocus();
			} else if(ph2.length()!=4) {
				dataRequestDial.setVisible(true);
				joinPage.phoneField2.requestFocus();
			} else if(ph3.length()!=4) {
				dataRequestDial.setVisible(true);
				joinPage.phoneField3.requestFocus();
			} else if(!pw.equals(pwConfirm)) {
				dataRequestDial.setVisible(true);
				joinPage.passField.setText("");
				joinPage.passConfirmField.setText("");
				joinPage.passField.requestFocus();
			} else {
				MemberDTO dto = new MemberDTO(id, pw, name, addr, ph1, ph2, ph3);
				int res = memberDAO.insertMember(dto);

				if(res==1) {
					signUpDial.setVisible(true);
					joinPage.idField.setText("");
					joinPage.passField.setText("");
					joinPage.passConfirmField.setText("");
					joinPage.nameField.setText("");
					joinPage.addrField.setText("");
					joinPage.phoneField1.setText("");
					joinPage.phoneField2.setText("");
					joinPage.phoneField3.setText("");
					card.show(mainPanel, "loginPanel");
				} else {
					idDuplicateDial.setVisible(true);
					joinPage.idField.setText("");
					joinPage.idField.requestFocus();
				}
			}
		}
		// 메인 페이지

		// 마이페이지 버튼
		else if(obj==menu.userInfoBtn) {
			userInfoPage.idField.setText(loggedin.getMemId());
			userInfoPage.nameField.setText(loggedin.getMemName());
			userInfoPage.addrField.setText(loggedin.getMemAddr());
			userInfoPage.phoneField1.setText(loggedin.getMemPh1());
			userInfoPage.phoneField2.setText(loggedin.getMemPh2());
			userInfoPage.phoneField3.setText(loggedin.getMemPh3());
			
			
			mainPanel.add(userInfoPage.mainPanel, "userInfoPanel");
			card.show(mainPanel, "userInfoPanel");

		} 
		
		// 7.25 추가
		// 병원, 쉘터 버튼
		else if(obj == menu.hospitalBtn) {
			hospitalPage = new HospitalPage();
			mainPanel.add(hospitalPage.mainPanel, "hospitalPanel");
			card.show(mainPanel, "hospitalPanel");
		}
		else if(obj == menu.shelterBtn) {
			shelterPage = new ShelterPage();
			mainPanel.add(shelterPage.mainPanel, "shelterPanel");
			card.show(mainPanel, "shelterPanel");
		}

		// 입소신청 버튼
		else if(obj==menu.unadoptBtn) {
			card.show(mainPanel, "ipsoPanel");
		}

		// 입양신청목록 && About 
		else if(obj==menu.adoptBtn) {

			if(loginToken==0) {
				System.out.println(123);
				adminSubmit = new AdminSubmitPage();
				adminSubmit.adminSubmitPanel.add(menu.topPanel);
				adminSubmit.adminSubmitPanel.add(menu.navPanel);
				mainPanel.add(adminSubmit.adminSubmitPanel, "adminSubmit");
				card.show(mainPanel, "adminSubmit");
			}else {
				
			}
		}

		// 입소 신청 페이지
		else if(obj==ipsoPage.submitBtn) {

			String dogName = ipsoPage.dogName.getText();
			String dogSpe = ipsoPage.dogSpe.getText();
			String dogAge = ipsoPage.dogAge.getText();
			String dogImage = ipsoPage.dogImage.getText();
			String dogNeu = "";
			String dogSex = "";
			String dogDis = "";
			String dogIno = "";

			if(ipsoPage.dogNeuT.isSelected()) dogNeu = "완료";
			else if(ipsoPage.dogNeuF.isSelected()) dogNeu = "미완료";

			if(ipsoPage.dogSexM.isSelected()) dogSex = "남아";
			else if(ipsoPage.dogSexF.isSelected()) dogSex = "여아";

			if(ipsoPage.dogDisT.isSelected()) dogDis = "건강해요 :)";
			if(ipsoPage.dogDisF.isSelected()) dogDis = "조금 아파요 :(";

			if(ipsoPage.dogInoF.isSelected()) dogIno = "미완료";
			else if(ipsoPage.dogIno1.isSelected()) dogIno = "1차";
			else if(ipsoPage.dogIno2.isSelected()) dogIno = "2차";
			else if(ipsoPage.dogIno3.isSelected()) dogIno = "3차";
			// 7.25 추가
			else if(ipsoPage.dogIno4.isSelected()) dogIno = "4차";
			else dogIno = "완료";
			
			if(dogName.isEmpty()||dogSpe.isEmpty()||dogAge.isEmpty()||dogImage.isEmpty()||dogNeu.isEmpty()
					||dogSex.isEmpty()||dogDis.isEmpty()||dogIno.isEmpty()) {
				dataRequestDial.setVisible(true);
			} else {
				dog.setMemCode(loggedin.getMemCode());
				dog.setDogName(dogName);
				dog.setDogSpe(dogSpe);
				dog.setDogAge(Integer.parseInt(dogAge));
				dog.setDogImage(dogImage);
				dog.setDogNeu(dogNeu);
				dog.setDogSex(dogSex);
				dog.setDogDis(dogDis);
				dog.setDogIno(dogIno);
				int res = dogDAO.insertDog(dog);

				if(res>0) {
					String nextPage = "";
					
					appDial.setVisible(true);
					ipsoPage.dogName.setText("");
					ipsoPage.dogSpe.setText("");
					ipsoPage.dogAge.setText("");
					ipsoPage.dogImage.setText("");
					
					ipsoPage.neuGroup.clearSelection();
					ipsoPage.sexGroup.clearSelection();
					ipsoPage.disGroup.clearSelection();
					ipsoPage.inoGroup.clearSelection();

					if(loginToken==0) {
						adminList = new AdminListPage();
						adminList.adminListPanel.add(menu.topPanel);
						adminList.adminListPanel.add(menu.navPanel);
						mainPanel.add(adminList.adminListPanel, "adminList");
						nextPage = "adminList";
					}else if(loginToken==1) {
						nextPage = "listPanel";
						
					}

					card.show(mainPanel, nextPage);

				} else {
					errorDial.setVisible(true);
				}
			}

		} else if(obj==ipsoPage.cancelBtn) {

			ipsoPage.dogName.setText("");
			ipsoPage.dogSpe.setText("");
			ipsoPage.dogAge.setText("");
			ipsoPage.dogImage.setText("");

			ipsoPage.neuGroup.clearSelection();
			ipsoPage.sexGroup.clearSelection();
			ipsoPage.disGroup.clearSelection();
			ipsoPage.inoGroup.clearSelection();

			if(loggedin.getMemCode()==0) {
				adminList = new AdminListPage();
				adminList.adminListPanel.add(menu.topPanel);
				adminList.adminListPanel.add(menu.navPanel);
				mainPanel.add(adminList.adminListPanel, "adminList");
				
				card.show(mainPanel, "adminList");
			}else {
				listPage.listPanel.add(menu.topPanel);
				listPage.listPanel.add(menu.navPanel);
				mainPanel.add(listPage.listPanel, "listPanel");
				
				card.show(mainPanel, "listPanel");
			}
			
			

		}

		// 회원 정보 페이지
		else if(obj==userInfoPage.cancelBtn) {
			if(loggedin.getMemCode()==0) {
				loginToken=0;
				adminList = new AdminListPage();
				adminList.adminListPanel.add(menu.topPanel);
				adminList.adminListPanel.add(menu.navPanel);
				mainPanel.add(adminList.adminListPanel, "adminList");
				card.show(mainPanel, "adminList");
			}else {
				loginToken = 1;
				listPage = new ListPage();
				listPage.listPanel.add(menu.topPanel);
				listPage.listPanel.add(menu.navPanel);
				mainPanel.add(listPage.listPanel, "listPanel");
				card.show(mainPanel, "listPanel");
			}
		}
		// 회원 탈퇴
		else if(obj==userInfoPage.deleteMemberBtn) {
			userDelDial.setVisible(true);
		}
		// 회원 수정
		else if(obj==userInfoPage.modInfoBtn) {
			String addr = userInfoPage.addrField.getText();
			String ph1 = userInfoPage.phoneField1.getText();
			String ph2 = userInfoPage.phoneField2.getText();
			String ph3 = userInfoPage.phoneField3.getText();
			if(addr.isEmpty()||ph1.isEmpty()||ph2.isEmpty()||ph3.isEmpty()) {
				dataRequestDial.setVisible(true);
			}else if(ph1.length()!=3||ph2.length()!=4||ph3.length()!=4) {
				dataRequestDial.setVisible(true);
			}else {
				userDataChangeDial.setVisible(true);
			}
		}
		// 회원 비밀번호 변경
		else if(obj==userInfoPage.modPassBtn) {
			passChangeDial.setVisible(true);
		}

		// top panel
		if(loginToken!=-1) {
			menu.userField.setText(loggedin.getMemName().toUpperCase()+"님 환영합니다!");
		}



	}

}