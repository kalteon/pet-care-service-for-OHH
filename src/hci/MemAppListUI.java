package hci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*	  회원 신청 내역 확인화면입니다.
 *	 
 *  대문 글자(신청 정보 입력)
 *  
 *  JTable : 신청목록입니다. 아직 내용은 추가 X
 *  
 *  뒤로가기 버튼 -> MemberUI
 *  리뷰 버튼 -> ReviewUI
 *  결제 버튼 -> ?? (평소엔 보이지 않음) 리뷰버튼 자리에 존재
 *  으로 구성됩니다
 */

@SuppressWarnings("serial")
public class MemAppListUI extends JFrame implements ActionListener{

	
	protected JTable AppTable;
	protected DefaultTableModel AppModel;
	
	Color c;
	
	// 버튼 이미지 & 크기 변환
	ImageIcon Cancelimg1 = new ImageIcon("././Image/CancelButton1.png");
	ImageIcon Cancelimg2 = new ImageIcon("././Image/CancelButton2.png");
	
	Image img1 = Cancelimg1.getImage();
	Image changeImg1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon1 = new ImageIcon(changeImg1);
	
	Image img2 = Cancelimg2.getImage();
	Image changeImg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon2 = new ImageIcon(changeImg2);
	
	
	public MemAppListUI() {
		super("MemAppListUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		getContentPane().setBackground(Color.WHITE);
		
		//제목 항목
		JLabel TitleLabel = new JLabel("신청 내역");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(30, 50, 500, 70);
		
		// 구분선
		JSeparator JSepStart = new JSeparator();
		add(JSepStart);
		JSepStart.setBounds(0, 170, 600, 70);			
		
		// 신청 목록
		String header[] = {"신청 ID", "신청 기간", "신청 상태"};
		String contents[][] = {{"","",""}};
		
		AppModel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		AppTable = new JTable(AppModel);
		c = new Color(64,126,219);
		AppTable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15)); // 테이블 헤더 폰트 조정
		AppTable.getTableHeader().setForeground(Color.WHITE);
		AppTable.getTableHeader().setBackground(c);
		AppTable.setFont(new Font("맑은 고딕", Font.PLAIN, 13)); // 테이블 내용 폰트 조정
		
		
		// 셀 글자 가운데 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		AppTable.getColumn("신청 ID").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 기간").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 상태").setCellRenderer(celAlignCenter);
		
		// 데이터가 화면 넘어갈 시 정렬
		JScrollPane AppScroll = new JScrollPane(AppTable);
		add(AppScroll);
		AppScroll.setBounds(20, 190, 540, 480);
		AppScroll.getViewport().setBackground(Color.WHITE);
		
		AppModel.removeRow(0); // 0번째 행 삭제(빈칸)
		String a[] = {"1234", "11월 29일", "진행중"}; 
		AppModel.addRow(a); // 데이터 추가
		
		// 뒤로가기 버튼
		JButton CancelButton = new JButton(CancelButtonicon1);
		add(CancelButton);
		CancelButton.setBounds(0, 660, 100, 100);
		CancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CancelButton.setActionCommand("뒤로가기");
		CancelButton.setRolloverIcon(CancelButtonicon2);
		CancelButton.setBorderPainted(false);
		CancelButton.setContentAreaFilled(false);
		CancelButton.setFocusPainted(false);
		CancelButton.addActionListener(this);
		
		// 리뷰 버튼
		RoundedButton ReviewButton = new RoundedButton("리뷰");
		add(ReviewButton);
		c = new Color(64,126,219);
		ReviewButton.setBackground(c);
		ReviewButton.setForeground(Color.WHITE);
		ReviewButton.setBounds(450, 680, 100, 50);
		ReviewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ReviewButton.addActionListener(this);
		ReviewButton.setVisible(true);
		
		// 결제 버튼 (안보임)
		RoundedButton PayButton = new RoundedButton("리뷰");
		add(PayButton);
		c = new Color(64,126,219);
		PayButton.setBackground(c);
		PayButton.setForeground(Color.WHITE);
		PayButton.setBounds(450, 680, 100, 50);
		PayButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PayButton.addActionListener(this);
		PayButton.setVisible(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			MemberUI MemberWindow = new MemberUI();
			MemberWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("리뷰")) {
			int ans = ConfirmUI.showConfirmDialog(this,"리뷰를 작성하시겠습니까?","확인 메세지",ConfirmUI.YES_NO_OPTION);
			if(ans == 0){ // 리뷰 작성 수락
				ReviewUI ReviewWindow = new ReviewUI();
				ReviewWindow.setVisible(true);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
