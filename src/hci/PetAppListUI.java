package hci;

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
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PetAppListUI extends JFrame implements ActionListener{

	protected JTable AppTable;
	protected DefaultTableModel AppModel;
	
	
	public PetAppListUI() {
		super("PetAppListUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//제목 항목
		JLabel TitleLabel = new JLabel("신청 내역");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		add(TitleLabel);
		TitleLabel.setBounds(50, 30, 500, 70);
		
		String header[] = {"A", "B", "C"};
		String contents[][] = {{"","",""}};
		
		AppModel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		AppTable = new JTable(AppModel);
		
		JScrollPane SellScroll = new JScrollPane(AppTable);
		add(SellScroll);
		SellScroll.setBounds(20, 150, 540, 480);
		
		JButton CancelButton = new JButton("뒤로가기");
		add(CancelButton);
		CancelButton.setBounds(30, 700, 100, 30);
		CancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CancelButton.addActionListener(this);
		
		JButton AppCancelButton = new JButton("신청 취소");
		add(AppCancelButton);
		AppCancelButton.setBounds(450, 700, 100, 30);
		AppCancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		AppCancelButton.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			PetSitterUI PetSitterWindow = new PetSitterUI();
			PetSitterWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("신청 취소")) {
			int ans = JOptionPane.showConfirmDialog(null,"정말 신청을 취소하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 신청 취소 수락
				JOptionPane.showMessageDialog(null,"신청이 취소되었습니다","신청 취소 완료",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
