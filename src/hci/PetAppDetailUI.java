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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class PetAppDetailUI extends JFrame implements ActionListener{

	public PetAppDetailUI() {
		super("PetAppDetailUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//제목 항목
		JLabel TitleLabel = new JLabel("상세 정보");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		add(TitleLabel);
		TitleLabel.setBounds(50, 30, 500, 70);
		
		
		JButton CancelButton = new JButton("뒤로가기");
		add(CancelButton);
		CancelButton.setBounds(30, 700, 100, 30);
		CancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CancelButton.addActionListener(this);
		
		JButton AcceptButton = new JButton("수락");
		add(AcceptButton);
		AcceptButton.setBounds(450, 700, 100, 30);
		AcceptButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		AcceptButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			dispose();
		}
		else if(ActionCmd.equals("수락")) {
			int ans = JOptionPane.showConfirmDialog(null,"신청을 수락하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 신청 수락
				JOptionPane.showMessageDialog(null,"신청 수락이 완료되었습니다","신청 수락 완료",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
