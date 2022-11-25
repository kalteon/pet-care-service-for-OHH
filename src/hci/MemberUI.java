package hci;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MemberUI extends JFrame implements ActionListener{
	
	Color c;
	String name = "박태정";
	
	public MemberUI() {
		super("MemberUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		c = new Color(188,204,250);
		getContentPane().setBackground(c);
		
		JLabel TitleLabel = new JLabel("안녕하세요!");
		TitleLabel.setHorizontalAlignment(JLabel.LEFT);
		TitleLabel.setForeground(Color.BLACK);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(30, 50, 500, 70);
		
		JLabel NameLabel = new JLabel(name + "님");
		NameLabel.setHorizontalAlignment(JLabel.LEFT);
		c = new Color(103,155,245);
		NameLabel.setForeground(Color.BLACK);
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(NameLabel);
		NameLabel.setBounds(320, 50, 500, 70);
		
		JSeparator JSep = new JSeparator();
		add(JSep);
		JSep.setBounds(0, 170, 600, 70);
		
		
		RoundedButton ApplicationButton = new RoundedButton("돌봄 서비스 신청하기");
		add(ApplicationButton);
		c = new Color(64,126,219);
		ApplicationButton.setBackground(c);
		ApplicationButton.setForeground(Color.WHITE);
		ApplicationButton.setBounds(30, 230, 530, 150);
		ApplicationButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		ApplicationButton.addActionListener(this);
		
		RoundedButton AppListButton = new RoundedButton("신청 내역 확인");
		add(AppListButton);
		AppListButton.setBackground(Color.WHITE);
		AppListButton.setBounds(30, 430, 530, 50);
		AppListButton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		AppListButton.addActionListener(this);
		
		RoundedButton ChangeMemInfoButton = new RoundedButton("회원 정보 수정");
		add(ChangeMemInfoButton);
		ChangeMemInfoButton.setBackground(Color.WHITE);
		ChangeMemInfoButton.setBounds(30, 500, 530, 50);
		ChangeMemInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		JButton LogoutButton = new JButton("로그아웃");
		add(LogoutButton);
		LogoutButton.setBounds(30, 700, 100, 30);
		LogoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		LogoutButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("돌봄 서비스 신청하기")) {
			int ans = JOptionPane.showConfirmDialog(null,"신청을 생성하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 신청 생성하기
				MemAppInfoUI AppInfoWindow = new MemAppInfoUI();
				AppInfoWindow.setVisible(true);
				dispose();
			}
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
