package hci;

import pd.application.Application;
import pd.application.ApplicationList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class MemAppListUI extends JFrame implements ActionListener, MouseListener{
	
	protected JTable AppTable;
	protected DefaultTableModel AppModel;
	
	RoundedButton ReviewButton;
	RoundedButton PayButton;
	RoundedButton RemoveButton;
	
	int SelectedRow;
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
		AppTable.addMouseListener(this);
		
		// 셀 글자 가운데 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		AppTable.getColumn("신청 ID").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 기간").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 상태").setCellRenderer(celAlignCenter);
		AppTable.getTableHeader().setReorderingAllowed(false);
		// 데이터가 화면 넘어갈 시 정렬
		JScrollPane AppScroll = new JScrollPane(AppTable);
		add(AppScroll);
		AppScroll.setBounds(20, 190, 540, 480);
		AppScroll.getViewport().setBackground(Color.WHITE);
		
		AppModel.removeRow(0); // 0번째 행 삭제(빈칸)
		/**
		 *
		* for 문으로 해시 테이블에 있는 값 추가
		* */
		ApplicationList list = ApplicationList.getList();
		Application application;
		for(String key: list.getForAcceptTable().keySet()){
			String temp = key.split("-")[0];
				if(temp.compareTo("임시 ID") == 0){
					 application = list.getForAcceptTable().get(key);
					 String[] data = new String[3];
					 data[0] = application.getApplicationID();
					 data[1] = application.getPeriodOfService();
					 data[2] = application.getState();
					 AppModel.addRow(data);
				}
		}
//		String[] a = {"1234", "11월 29일", "결제 대기"};
//		AppModel.addRow(a); // 데이터 추가
		
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
		
		// 리뷰 버튼 (완료 상태에만 보임)
		ReviewButton = new RoundedButton("리뷰");
		add(ReviewButton);
		c = new Color(64,126,219);
		ReviewButton.setBackground(c);
		ReviewButton.setForeground(Color.WHITE);
		ReviewButton.setBounds(450, 680, 100, 50);
		ReviewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ReviewButton.addActionListener(this);
		ReviewButton.setVisible(false);
		
		// 결제 버튼 (결제 대기시에만 보임)
		PayButton = new RoundedButton("결제");
		add(PayButton);
		c = new Color(64,126,219);
		PayButton.setBackground(c);
		PayButton.setForeground(Color.WHITE);
		PayButton.setBounds(450, 680, 100, 50);
		PayButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PayButton.addActionListener(this);
		PayButton.setVisible(false);
		
		// 삭제 버튼 (수락 대기시에만 보임)
		RemoveButton = new RoundedButton("삭제");
		add(RemoveButton);
		c = new Color(240,62,62);
		RemoveButton.setBackground(c);
		RemoveButton.setForeground(Color.WHITE);
		RemoveButton.setBounds(450, 680, 100, 50);	
		RemoveButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		RemoveButton.addActionListener(this);	
		RemoveButton.setVisible(false);
				
		
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
		}else if(ActionCmd.equals("결제")) {
			//ReviewUI ReviewWindow = new ReviewUI();
			//ReviewWindow.setVisible(true);
		}else if(ActionCmd.equals("삭제")) {
			int ans = ConfirmUI.showConfirmDialog(this,"정말 삭제하시겠습니까?","확인 메세지",ConfirmUI.YES_NO_OPTION);
			if(ans == 0){ // 삭제하기
				AppModel.removeRow(SelectedRow);
				/**
				 * 이 부분에 신청 데이터베이스 정보 삭제하면 됨.
				 */
				ReviewButton.setVisible(false);
				PayButton.setVisible(false);
				RemoveButton.setVisible(false);
				ConfirmUI.showMessageDialog(this,"삭제가 완료되었습니다.","확인 메세지");
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
	 public void mouseClicked(MouseEvent e) {
		 SelectedRow = AppTable.getSelectedRow(); // 선택된 Table의 Row값 가져오기
		 String Status = (String)AppTable.getModel().getValueAt(SelectedRow,2);
		 if(Status.equals("수락 대기")) {
			 PayButton.setVisible(false);
			 ReviewButton.setVisible(false);
			 RemoveButton.setVisible(true);
			 PayButton.setBounds(450, 680, 100, 50);
		 }else if(Status.equals("결제 대기")) {
			 ReviewButton.setVisible(false);
			 RemoveButton.setVisible(true);
			 PayButton.setVisible(true);
			 PayButton.setBounds(330, 680, 100, 50);
		 }else if(Status.equals("완료")) {
			 RemoveButton.setVisible(false);
			 PayButton.setVisible(false);
			 ReviewButton.setVisible(true);
			 PayButton.setBounds(450, 680, 100, 50);
		 }else {
			 ReviewButton.setVisible(false);
			 PayButton.setVisible(false);
			 RemoveButton.setVisible(false);
			 PayButton.setBounds(450, 680, 100, 50);
		 }
	 }

	 public void mousePressed(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }

	 public void mouseReleased(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }

	 public void mouseEntered(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }

	 public void mouseExited(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }
}
