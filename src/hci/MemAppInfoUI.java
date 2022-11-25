package hci;

import pd.application.Application;
import pd.application.ApplicationList;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;



@SuppressWarnings("serial")
public class MemAppInfoUI extends JFrame implements ActionListener {

	final static int nameY = 150; // 이름 항목의 Y축 좌표
	final static int StartY = 210; // 시작 시간 항목의 Y축 좌표
	final static int EndY = 270; // 종료 시간 항목의 Y축 좌표
	final static int LocationY = 330; // 위치 항목의 Y축 좌표
	final static int ServiceY1 = 390; // 서비스 종류 항목의 Y축 좌표 1
	final static int ServiceY2 = 450; // 서비스 종류 항목의 Y축 좌표 2
	final static int priceY = 510; // 가격 항목의 Y축 좌표
	
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
		
		// 제목 항목
		JLabel TitleLabel = new JLabel("신청 정보 입력");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		add(TitleLabel);
		TitleLabel.setBounds(50, 30, 500, 70);
		
		// 이름 항목
		JLabel NameLabel = new JLabel("이름 ");
		add(NameLabel);
		NameLabel.setBounds(30,nameY,30,30);
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		NameField = new JTextField();
		add(NameField);
		NameField.setEditable(false);
		NameField.setBounds(140,nameY,80,30);
		
		
		// 시작 시간 항목
		JLabel StartTimeLabel = new JLabel("시작 시간 ");
		add(StartTimeLabel);
		StartTimeLabel.setBounds(30,StartY,70,30);
		StartTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		StartYearField = new JTextField();
		add(StartYearField);
		StartYearField.setBounds(140,StartY,40,30);
		
		JLabel StartYearLabel = new JLabel("년");
		add(StartYearLabel);
		StartYearLabel.setBounds(185,StartY,80,30);
		StartYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartMonthField = new JTextField();
		add(StartMonthField);
		StartMonthField.setBounds(210,StartY,30,30);
		
		JLabel StartMonthLabel = new JLabel("월");
		add(StartMonthLabel);
		StartMonthLabel.setBounds(245,StartY,80,30);
		StartMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartDayField = new JTextField();
		add(StartDayField);
		StartDayField.setBounds(270,StartY,30,30);
		
		JLabel StartDayLabel = new JLabel("일");
		add(StartDayLabel);
		StartDayLabel.setBounds(305,StartY,80,30);
		StartDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		String AMPMString[] = {"오전", "오후"};
		StartAMPMCombo = new JComboBox<String>(AMPMString);
		add(StartAMPMCombo);
		StartAMPMCombo.setBounds(330,StartY,70,30);
		StartAMPMCombo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		StartHourField = new JTextField();
		add(StartHourField);
		StartHourField.setBounds(410,StartY,30,30);
		
		JLabel StartHourLabel = new JLabel("시");
		add(StartHourLabel);
		StartHourLabel.setBounds(445,StartY,80,30);
		StartHourLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		// 종료 시간 항목
		JLabel EndTimeLabel = new JLabel("종료 시간 ");
		add(EndTimeLabel);
		EndTimeLabel.setBounds(30,EndY,70,30);
		EndTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		EndYearField = new JTextField();
		add(EndYearField);
		EndYearField.setBounds(140,EndY,40,30);
		
		JLabel EndYearLabel = new JLabel("년");
		add(EndYearLabel);
		EndYearLabel.setBounds(185,EndY,80,30);
		EndYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndMonthField = new JTextField();
		add(EndMonthField);
		EndMonthField.setBounds(210,EndY,30,30);
		
		JLabel EndMonthLabel = new JLabel("월");
		add(EndMonthLabel);
		EndMonthLabel.setBounds(245,EndY,80,30);
		EndMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndDayField = new JTextField();
		add(EndDayField);
		EndDayField.setBounds(270,EndY,30,30);
		
		JLabel EndDayLabel = new JLabel("일");
		add(EndDayLabel);
		EndDayLabel.setBounds(305,EndY,80,30);
		EndDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndAMPMCombo = new JComboBox<String>(AMPMString);
		add(EndAMPMCombo);
		EndAMPMCombo.setBounds(330,EndY,70,30);
		EndAMPMCombo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		EndHourField = new JTextField();
		add(EndHourField);
		EndHourField.setBounds(410,EndY,30,30);
		
		JLabel EndHourLabel = new JLabel("시");
		add(EndHourLabel);
		EndHourLabel.setBounds(445,EndY,80,30);
		EndHourLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		// 위치 항목
		JLabel LocationLabel = new JLabel("위치 ");
		add(LocationLabel);
		LocationLabel.setBounds(30,LocationY,30,30);
		LocationLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		LocationField = new JTextField();
		add(LocationField);
		LocationField.setEditable(false);
		LocationField.setBounds(140,LocationY,350,30);
		
		// 신청 서비스 종류 항목
		JLabel ServiceTypeLabel = new JLabel("신청 서비스 종류");
		add(ServiceTypeLabel);
		ServiceTypeLabel.setBounds(30,ServiceY1,130,30);
		ServiceTypeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		ServiceCheck1 = new JCheckBox("서비스 1");
		add(ServiceCheck1);
		ServiceCheck1.setBounds(140,ServiceY1,150,30);
		ServiceCheck1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		ServiceCheck2 = new JCheckBox("서비스 2");
		add(ServiceCheck2);
		ServiceCheck2.setBounds(350,ServiceY1,150,30);
		ServiceCheck2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		ServiceCheck3 = new JCheckBox("서비스 3");
		add(ServiceCheck3);
		ServiceCheck3.setBounds(140,ServiceY2,150,30);
		ServiceCheck3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		ServiceCheck4 = new JCheckBox("서비스 4");
		add(ServiceCheck4);
		ServiceCheck4.setBounds(350,ServiceY2,150,30);
		ServiceCheck4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		
		// 가격 항목
		JLabel PriceLabel = new JLabel("가격 ");
		add(PriceLabel);
		PriceLabel.setBounds(30,priceY,30,30);
		PriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		PriceField = new JTextField();
		add(PriceField);
		PriceField.setEditable(false);
		PriceField.setBounds(140,priceY,80,30);
		
		
		JButton CancelButton = new JButton("뒤로가기");
		add(CancelButton);
		CancelButton.setBounds(30, 700, 100, 30);
		CancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CancelButton.addActionListener(this);
		
		JButton SubmitButton = new JButton("제출");
		add(SubmitButton);
		SubmitButton.setBounds(450, 700, 100, 30);
		SubmitButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
			int ans = JOptionPane.showConfirmDialog(null,"제출하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
					int doYouReplace = JOptionPane.showConfirmDialog(null,
							"신청이 존재합니다.\n대체하시겠습니까?","확인 메세지",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(doYouReplace == 0){
						application.requestReplaceApplication(isRedundant);
						application.requestApplication();
					}
					else{
						JOptionPane.showMessageDialog(null,"신청이 취소되었습니다","신청 취소",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				ApplicationList list = ApplicationList.getList();
				list.printHashTable();
				JOptionPane.showMessageDialog(null,"신청이 완료되었습니다","신청 완료",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
