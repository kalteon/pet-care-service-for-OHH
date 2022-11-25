package hci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {
	
	Color c;
	
	public LoginUI() {
		
		super("LoginUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
				
		c = new Color(188,204,250);
		getContentPane().setBackground(c);

		
		/*
		JLabel TitleLabel = new JLabel("로그인 선택");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(50, 50, 500, 70);
		*/
		
		RoundedButton MemberLoginButton = new RoundedButton("회원 로그인");
		add(MemberLoginButton);
		c = new Color(64,126,219);
		MemberLoginButton.setBackground(c);
		MemberLoginButton.setForeground(Color.WHITE);
		MemberLoginButton.setBounds(30, 550, 530, 50);
		MemberLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		MemberLoginButton.addActionListener(this);
		
		
		RoundedButton PetSitterLoginButton = new RoundedButton("돌봄이 로그인");
		add(PetSitterLoginButton);
		c = new Color(64,126,219);
		PetSitterLoginButton.setBackground(c);
		PetSitterLoginButton.setForeground(Color.WHITE);
		PetSitterLoginButton.setBounds(30, 610, 530, 50);
		PetSitterLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PetSitterLoginButton.addActionListener(this);
		
		RoundedButton ExitButton = new RoundedButton("종료하기");
		add(ExitButton);
		ExitButton.setBackground(Color.WHITE);
		ExitButton.setBounds(30, 670, 530, 50);
		ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ExitButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("회원 로그인")) {
			MemberUI MemberWindow = new MemberUI();
			MemberWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("돌봄이 로그인")) {
			PetSitterUI PetSitterWindow = new PetSitterUI();
			PetSitterWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("종료하기")) {
			int ans = JOptionPane.showConfirmDialog(null,"정말 종료하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 종료하기
				System.exit(0);
			}
			
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
	
}
