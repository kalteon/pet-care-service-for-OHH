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
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PetSitterUI extends JFrame implements ActionListener{

	public PetSitterUI() {
		super("PetSitterUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel TitleLabel = new JLabel("돌봄이 기능");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(50, 50, 500, 70);
		
		JButton ApplicationButton = new JButton("신청 조회");
		add(ApplicationButton);
		ApplicationButton.setBounds(100, 300, 150, 150);
		ApplicationButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		ApplicationButton.addActionListener(this);
		
		JButton AppListButton = new JButton("신청 내역 확인");
		add(AppListButton);
		AppListButton.setBounds(350, 300, 150, 150);
		AppListButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		AppListButton.addActionListener(this);
		
		JButton LogoutButton = new JButton("로그아웃");
		add(LogoutButton);
		LogoutButton.setBounds(30, 700, 100, 30);
		LogoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		LogoutButton.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("신청 조회")) {
			PetAppListUI AppInfoWindow = new PetAppListUI();
			AppInfoWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("신청 내역 확인")) {
			MemAppListUI AppListWindow = new MemAppListUI();
			AppListWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("로그아웃")) {
			int ans = JOptionPane.showConfirmDialog(null,"정말 로그아웃 하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 로그아웃 수락
				LoginUI LoginWindow = new LoginUI();
		    	LoginWindow.setVisible(true);
				dispose();
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
