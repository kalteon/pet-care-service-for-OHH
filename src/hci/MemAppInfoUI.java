package hci;

import pd.application.Application;
import pd.application.ApplicationList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

/*	  회원 신청정보 입력화면입니다.
 *	 
 *  대문 글자(신청 정보 입력)
 *  
 *  이름 : 미리 회원정보에서 받아 입력
 *  시작 시간 : 회원이 직접 입력
 *  종료 시간 : 회원이 직접 입력
 *  위치 : 미리 회원정보에서 받아 입력
 *  신청 서비스 : 회원이 체크박스 체크
 *  가격 : 서비스 & 시간에 따라 계산
 *  뒤로가기 버튼 -> MemberUI
 *  제출 버튼 -> 확인 창 뜬 후 MemberUI
 *  으로 구성됩니다
 */

@SuppressWarnings("serial")
public class MemAppInfoUI extends JFrame implements ActionListener {

	final static int nameY = 20; // 이름 항목의 Y축 좌표
	final static int StartY = 80; // 시작 시간 항목의 Y축 좌표
	final static int EndY = 140; // 종료 시간 항목의 Y축 좌표
	final static int LocationY = 200; // 위치 항목의 Y축 좌표
	final static int ServiceY1 = 260; // 서비스 종류 항목의 Y축 좌표 1
	final static int ServiceY2 = 320; // 서비스 종류 항목의 Y축 좌표 2
	final static int priceY = 380; // 가격 항목의 Y축 좌표
	
	Color c;
	String name = "박태정";
	String Location = "경북대학교 IT 대학";
	String price = "40,000원";
	
	// 버튼 이미지 & 크기 변환
	ImageIcon Cancelimg1 = new ImageIcon("././Image/CancelButton1.png");
	ImageIcon Cancelimg2 = new ImageIcon("././Image/CancelButton2.png");
	
	Image img1 = Cancelimg1.getImage();
	Image changeImg1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon1 = new ImageIcon(changeImg1);
	
	Image img2 = Cancelimg2.getImage();
	Image changeImg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon2 = new ImageIcon(changeImg2);
	
	protected JTextField NameField;
	
	protected JTextField StartYearField;
	protected JTextField StartMonthField;
	protected JTextField StartDayField;
	protected JTextField StartHourField;

	protected JTextField EndYearField;
	protected JTextField EndMonthField;
	protected JTextField EndDayField;
	protected JTextField EndHourField;
	
	protected JTextField LocationField;
	
	protected JCheckBox ServiceCheck1;
	protected JCheckBox ServiceCheck2;
	protected JCheckBox ServiceCheck3;
	protected JCheckBox ServiceCheck4;
	
	protected JTextField PriceField;
	
	protected JComboBox<String> StartAMPMCombo;
	protected JComboBox<String> EndAMPMCombo;
	
	public MemAppInfoUI() {
		super("MemAppInfoUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		// 제목 항목
		JLabel TitleLabel = new JLabel("신청 정보 입력");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(30, 50, 500, 70);
		
		// 구분선
		JSeparator JSepStart = new JSeparator();
		add(JSepStart);
		JSepStart.setBounds(0, 170, 600, 70);
		
		// 신청 항목들을 담은 Panel
		JPanel ContentPanel = new JPanel();
		add(ContentPanel);
		ContentPanel.setBackground(Color.WHITE);
		ContentPanel.setBounds(0, 170, 600, 450);
		ContentPanel.setLayout(null);
		
	
		// 이름 항목
		JLabel NameLabel = new JLabel("이름 ");
		ContentPanel.add(NameLabel);
		NameLabel.setBounds(30,nameY,40,30);
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		// 이름 텍스트필드 생성 & 테두리 없애기
		NameField = new JTextField(name){
            @Override
            public void setBorder(Border border) {
                
            }
        };
        
		ContentPanel.add(NameField);
		NameField.setEditable(false);
		NameField.setBounds(140, nameY, 80, 30);
		NameField.setBackground(Color.WHITE);
		NameField.setForeground(Color.BLACK);
		NameField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		// 시작 시간 항목
		JLabel StartTimeLabel = new JLabel("시작 시간 ");
		ContentPanel.add(StartTimeLabel);
		StartTimeLabel.setBounds(30,StartY,80,30);
		StartTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartYearField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
        
    	ContentPanel.add(StartYearField);
		StartYearField.setBounds(140,StartY,40,31);
		StartYearField.setBackground(Color.WHITE);
		StartYearField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		// 텍스트 필드와 배경색이 같아 밑에 구분선 추가
		JSeparator JSepStartYear = new JSeparator();
		ContentPanel.add(JSepStartYear);
		JSepStartYear.setBounds(140, StartY+31, 40, 30);

		
		JLabel StartYearLabel = new JLabel("년");
		ContentPanel.add(StartYearLabel);
		StartYearLabel.setBounds(185,StartY,90,30);
		StartYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartMonthField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };;
    	ContentPanel.add(StartMonthField);
		StartMonthField.setBounds(210,StartY,30,31);
		StartMonthField.setBackground(Color.WHITE);
		StartMonthField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JSeparator JSepStartMonth = new JSeparator();
		ContentPanel.add(JSepStartMonth);
		JSepStartMonth.setBounds(210, StartY+31, 30, 30);
		
		JLabel StartMonthLabel = new JLabel("월");
		ContentPanel.add(StartMonthLabel);
		StartMonthLabel.setBounds(245,StartY,90,30);
		StartMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		StartDayField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
        
		ContentPanel.add(StartDayField);
		StartDayField.setBounds(270,StartY,30,31);
		StartDayField.setBackground(Color.WHITE);
		StartDayField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JSeparator JSepStartDay = new JSeparator();
		ContentPanel.add(JSepStartDay);
		JSepStartDay.setBounds(270, StartY+31, 30, 30);
		
		
		JLabel StartDayLabel = new JLabel("일");
		ContentPanel.add(StartDayLabel);
		StartDayLabel.setBounds(305,StartY,90,30);
		StartDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		// 오전 오후를 고르는 ComboBox
		String AMPMString[] = {"오전", "오후"};
		StartAMPMCombo = new JComboBox<String>(AMPMString);
		ContentPanel.add(StartAMPMCombo);
		StartAMPMCombo.setBounds(330,StartY,70,30);
		StartAMPMCombo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartHourField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(StartHourField);
		StartHourField.setBounds(410,StartY,30,31);
		StartHourField.setBackground(Color.WHITE);
		StartHourField.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JSeparator JSepStartHour = new JSeparator();
		ContentPanel.add(JSepStartHour);
		JSepStartHour.setBounds(410, StartY+31, 30, 30);
		
		
		JLabel StartHourLabel = new JLabel("시");
		ContentPanel.add(StartHourLabel);
		StartHourLabel.setBounds(445,StartY,80,30);
		StartHourLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		// 종료 시간 항목
		JLabel EndTimeLabel = new JLabel("종료 시간 ");
		ContentPanel.add(EndTimeLabel);
		EndTimeLabel.setBounds(30,EndY,80,30);
		EndTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndYearField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(EndYearField);
		EndYearField.setBounds(140,EndY,40,31);
		EndYearField.setBackground(Color.WHITE);
		EndYearField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JSeparator JSepEndYear = new JSeparator();
		ContentPanel.add(JSepEndYear);
		JSepEndYear.setBounds(140, EndY+31, 40, 30);
		
		JLabel EndYearLabel = new JLabel("년");
		ContentPanel.add(EndYearLabel);
		EndYearLabel.setBounds(185,EndY,80,30);
		EndYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndMonthField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(EndMonthField);
		EndMonthField.setBounds(210,EndY,30,31);
		EndMonthField.setBackground(Color.WHITE);
		EndMonthField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		JSeparator JSepEndMonth = new JSeparator();
		ContentPanel.add(JSepEndMonth);
		JSepEndMonth.setBounds(210, EndY+31, 30, 30);
		
		
		JLabel EndMonthLabel = new JLabel("월");
		ContentPanel.add(EndMonthLabel);
		EndMonthLabel.setBounds(245,EndY,80,30);
		EndMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		
		EndDayField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(EndDayField);
		EndDayField.setBounds(270,EndY,30,31);
		EndDayField.setBackground(Color.WHITE);
		EndDayField.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JSeparator JSepEndDay = new JSeparator();
		ContentPanel.add(JSepEndDay);
		JSepEndDay.setBounds(270, EndY+31, 30, 30);
		
		JLabel EndDayLabel = new JLabel("일");
		ContentPanel.add(EndDayLabel);
		EndDayLabel.setBounds(305,EndY,80,30);
		EndDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndAMPMCombo = new JComboBox<String>(AMPMString);
		ContentPanel.add(EndAMPMCombo);
		EndAMPMCombo.setBounds(330,EndY,70,30);
		EndAMPMCombo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndHourField = new JTextField(){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(EndHourField);
		EndHourField.setBounds(410,EndY,30,31);
		EndHourField.setBackground(Color.WHITE);
		EndHourField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JSeparator JSepEndHour = new JSeparator();
		ContentPanel.add(JSepEndHour);
		JSepEndHour.setBounds(410, EndY+31, 30, 30);
		
		JLabel EndHourLabel = new JLabel("시");
		ContentPanel.add(EndHourLabel);
		EndHourLabel.setBounds(445,EndY,80,30);
		EndHourLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		// 위치 항목
		JLabel LocationLabel = new JLabel("위치 ");
		ContentPanel.add(LocationLabel);
		LocationLabel.setBounds(30,LocationY,40,30);
		LocationLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		LocationField = new JTextField(Location){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(LocationField);
		LocationField.setEditable(false);
		LocationField.setBounds(140,LocationY,350,31);
		LocationField.setBackground(Color.WHITE);
		LocationField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		// 신청 서비스 종류 항목
		JLabel ServiceTypeLabel = new JLabel("신청 서비스");
		ContentPanel.add(ServiceTypeLabel);
		ServiceTypeLabel.setBounds(30,ServiceY1,130,30);
		ServiceTypeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		ServiceCheck1 = new JCheckBox("서비스 1");
		ContentPanel.add(ServiceCheck1);
		ServiceCheck1.setBounds(140,ServiceY1,150,30);
		ServiceCheck1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ServiceCheck1.setBackground(Color.WHITE);
		
		ServiceCheck2 = new JCheckBox("서비스 2");
		ContentPanel.add(ServiceCheck2);
		ServiceCheck2.setBounds(350,ServiceY1,150,30);
		ServiceCheck2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ServiceCheck2.setBackground(Color.WHITE);
		
		ServiceCheck3 = new JCheckBox("서비스 3");
		ContentPanel.add(ServiceCheck3);
		ServiceCheck3.setBounds(140,ServiceY2,150,30);
		ServiceCheck3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ServiceCheck3.setBackground(Color.WHITE);
		
		ServiceCheck4 = new JCheckBox("서비스 4");
		ContentPanel.add(ServiceCheck4);
		ServiceCheck4.setBounds(350,ServiceY2,150,30);
		ServiceCheck4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ServiceCheck4.setBackground(Color.WHITE);
		
		// 가격 항목
		JLabel PriceLabel = new JLabel("가격 ");
		ContentPanel.add(PriceLabel);
		PriceLabel.setBounds(30,priceY,40,30);
		PriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		PriceField = new JTextField(price){
            @Override
            public void setBorder(Border border) {
                
            }
        };
		ContentPanel.add(PriceField);
		PriceField.setEditable(false);
		PriceField.setBounds(140,priceY,80,30);
		PriceField.setBackground(Color.WHITE);
		PriceField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		// 구분선
		JSeparator JSepEnd = new JSeparator();
		add(JSepEnd);
		JSepEnd.setBounds(0, 620, 600, 70);
				
		
		JButton CancelButton = new JButton(CancelButtonicon1);
		add(CancelButton);
		CancelButton.setBounds(0, 660, 100, 100);
		CancelButton.setActionCommand("뒤로가기");
		CancelButton.setRolloverIcon(CancelButtonicon2);
		CancelButton.setBorderPainted(false);
		CancelButton.setContentAreaFilled(false);
		CancelButton.setFocusPainted(false);
		CancelButton.addActionListener(this);
		
		RoundedButton SubmitButton = new RoundedButton("제출");
		add(SubmitButton);
		c = new Color(64,126,219);
		SubmitButton.setBackground(c);
		SubmitButton.setForeground(Color.WHITE);
		SubmitButton.setBounds(450, 680, 100, 50);
		SubmitButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		SubmitButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			MemberUI MemberWindow = new MemberUI();
			MemberWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("제출")) {
			int ans = ConfirmUI.showConfirmDialog(this,"제출하시겠습니까?","확인 메세지",ConfirmUI.YES_NO_OPTION);
			if(ans == 0){ // 제출 수락
				Application application = new Application();
				String isRedundant;
				int price;
				String start = String.join(".", StartYearField.getText(), StartMonthField.getText(),
						StartDayField.getText(), StartHourField.getText());
				String end = String.join(".", EndYearField.getText(), EndMonthField.getText(),
						EndDayField.getText(), EndHourField.getText());
				application.setPeriodOfService(String.join(" ~ ", start, end));
				application.setLocation(LocationField.getText());
				application.setKindOfServices(String.join(", ", ServiceCheck1.getText(), ServiceCheck2.getText(),
						ServiceCheck3.getText(), ServiceCheck4.getText()));
				// 가격 계산 필요
				// 회원 아이디를 얻는 법 필요
				application.setApplicationID("임시 ID");

				if((isRedundant = application.requestApplication()) != null){
					int doYouReplace = ConfirmUI.showConfirmDialog(this,
							"신청이 존재합니다.\n대체하시겠습니까?","확인 메세지",
							ConfirmUI.YES_NO_OPTION);
					if(doYouReplace == 0){
						application.requestReplaceApplication(isRedundant);
						application.requestApplication();
					}
					else{
						ConfirmUI.showMessageDialog(this,"신청이 취소되었습니다","신청 취소");
						dispose();
					}
				}
				ApplicationList list = ApplicationList.getList();
				list.printHashTable();
				ConfirmUI.showMessageDialog(this,"신청이 완료되었습니다","신청 완료");
				MemberUI MemberWindow = new MemberUI();
				MemberWindow.setVisible(true);
				dispose();
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
