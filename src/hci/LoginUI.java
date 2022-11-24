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


public class LoginUI extends JFrame implements ActionListener {
	
	public LoginUI() {
		super("LoginUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel TitleLabel = new JLabel("로그인 선택");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(50, 50, 500, 70);
		
		JButton MemberLoginButton = new JButton("회원 로그인");
		add(MemberLoginButton);
		MemberLoginButton.setBounds(100, 300, 150, 150);
		MemberLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		MemberLoginButton.addActionListener(this);
		
		JButton PetSitterLoginButton = new JButton("돌봄이 로그인");
		add(PetSitterLoginButton);
		PetSitterLoginButton.setBounds(350, 300, 150, 150);
		PetSitterLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		PetSitterLoginButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("회원 로그인")) {
			MemberUI MemberWindow = new MemberUI();
			MemberWindow.setVisible(true);
		}
		else if(ActionCmd.equals("돌봄이 로그인")) {
			
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
