package hci;

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

/*	  돌봄이 돌봄 서비스 신청 조회 화면입니다.
 *	 
 *  대문 글자(신청 내역)
 *  
 *  JTable : 신청 내역입니다. 아직 내용은 추가 X
 *  
 *  뒤로가기 버튼 -> PetSitterUI
 *  조회 버튼 -> PetAppDetailUI
 *  으로 구성됩니다
 */

@SuppressWarnings("serial")
public class PetAppSearchUI extends JFrame implements ActionListener, MouseListener{

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
	
	int SelectedRow;
	
	RoundedButton LookupButton;
	
	public PetAppSearchUI() {
		super("PetAppSearchUI");
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
		String header[] = {"지역", "신청 기간","가격"};
		String contents[][] = {{"","",""}};
		
		// 신청 내역
		AppModel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		AppTable = new JTable(AppModel);
		c = new Color(64,126,219);
		AppTable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
		AppTable.getTableHeader().setForeground(Color.WHITE);
		AppTable.getTableHeader().setBackground(c);
		AppTable.setFont(new Font("맑은 고딕", Font.PLAIN, 13)); // 테이블 내용 폰트 조정
		AppTable.addMouseListener(this);
		
		// 셀 글자 가운데 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				
		AppTable.getColumn("지역").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 기간").setCellRenderer(celAlignCenter);
		AppTable.getColumn("가격").setCellRenderer(celAlignCenter);
		AppTable.getTableHeader().setReorderingAllowed(false);
		
		// 데이터가 화면 넘어갈 시 정렬
		JScrollPane AppScroll = new JScrollPane(AppTable);
		add(AppScroll);
		AppScroll.setBounds(20, 190, 540, 480);
		AppScroll.getViewport().setBackground(Color.WHITE);
		
		AppModel.removeRow(0); // 0번째 행 삭제(빈칸)
		String a[] = {"경북대 IT대학", "11월 29일", "1800원"}; 
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
		
		// 조회 버튼
		LookupButton = new RoundedButton("조회");
		add(LookupButton);
		c = new Color(64,126,219);
		LookupButton.setBackground(c);
		LookupButton.setForeground(Color.WHITE);
		LookupButton.setBounds(450, 680, 100, 50);
		LookupButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		LookupButton.setVisible(false);
		LookupButton.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			PetSitterUI PetSitterWindow = new PetSitterUI();
			PetSitterWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("조회")) {
			PetAppDetailUI PetAppDetailWindow = new PetAppDetailUI();
			PetAppDetailWindow.setVisible(true);
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		SelectedRow = AppTable.getSelectedRow(); // 선택된 Table의 Row값 가져오기
		LookupButton.setVisible(true);
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
