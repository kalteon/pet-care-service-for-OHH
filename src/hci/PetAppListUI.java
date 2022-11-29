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

@SuppressWarnings("serial")
public class PetAppListUI extends JFrame implements ActionListener, MouseListener{

	protected JTable AppTable;
	protected DefaultTableModel AppModel;
	
	Color c;
	
	ImageIcon Cancelimg1 = new ImageIcon("././Image/CancelButton1.png");
	ImageIcon Cancelimg2 = new ImageIcon("././Image/CancelButton2.png");
	
	Image img1 = Cancelimg1.getImage();
	Image changeImg1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon1 = new ImageIcon(changeImg1);
	
	Image img2 = Cancelimg2.getImage();
	Image changeImg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon CancelButtonicon2 = new ImageIcon(changeImg2);
	
	int SelectedRow;
	
	RoundedButton AppCancelButton;
	
	public PetAppListUI() {
		super("PetAppListUI");
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
		AppTable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
		AppTable.getTableHeader().setForeground(Color.WHITE);
		AppTable.getTableHeader().setBackground(c);
		AppTable.setFont(new Font("맑은 고딕", Font.PLAIN, 13)); // 테이블 내용 폰트 조정
		
		
		// 셀 글자 가운데 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				
		AppTable.getColumn("신청 ID").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 기간").setCellRenderer(celAlignCenter);
		AppTable.getColumn("신청 상태").setCellRenderer(celAlignCenter);
		AppTable.getTableHeader().setReorderingAllowed(false);
		AppTable.addMouseListener(this);
		
		AppModel.removeRow(0); // 0번째 행 삭제(빈칸)
		String a[] = {"1234", "11월 29일", "진행중"}; 
		AppModel.addRow(a); // 데이터 추가
		
		// 데이터가 화면 넘어갈 시 정렬
		JScrollPane AppScroll = new JScrollPane(AppTable);
		add(AppScroll);
		AppScroll.setBounds(20, 190, 540, 480);
		AppScroll.getViewport().setBackground(Color.WHITE);
		
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
		
		AppCancelButton = new RoundedButton("신청 취소");
		add(AppCancelButton);
		c = new Color(240,62,62);
		AppCancelButton.setBackground(c);
		AppCancelButton.setForeground(Color.WHITE);
		AppCancelButton.setBounds(450, 680, 100, 50);
		AppCancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		AppCancelButton.addActionListener(this);
		AppCancelButton.setVisible(false);
		
	}
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			PetSitterUI PetSitterWindow = new PetSitterUI();
			PetSitterWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("신청 취소")) {
			int ans = ConfirmUI.showConfirmDialog(this,"정말 신청을 취소하시겠습니까?","확인 메세지",ConfirmUI.YES_NO_OPTION);
			if(ans == 0){ // 신청 취소 수락
				AppModel.removeRow(SelectedRow);
				ConfirmUI.showMessageDialog(this,"신청이 취소되었습니다","신청 취소 완료");
				AppCancelButton.setVisible(false);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		SelectedRow = AppTable.getSelectedRow(); // 선택된 Table의 Row값 가져오기
		AppCancelButton.setVisible(true);
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
