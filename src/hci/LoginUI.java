package hci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;


import javax.swing.JFrame;

/*	 로그인 화면입니다
 * 
 *  타이틀 화면(추가 예정)
 *  회원 로그인 -> MemberUI
 *  돌봄이 로그인 -> PetSitterUI
 *  종료 -> Exit
 *  로 구성됩니다.
 */

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {
	
	Color c;
	
	public LoginUI() {
		
		super("LoginUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
				
		getContentPane().setBackground(Color.WHITE); // 배경색 설정

		// 타이틀 추가 예정
		/*
		JLabel TitleLabel = new JLabel("로그인 선택");
		TitleLabel.setHorizontalAlignment(JLabel.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(TitleLabel);
		TitleLabel.setBounds(50, 50, 500, 70);
		*/
		
		// 회원 로그인 버튼
		RoundedButton MemberLoginButton = new RoundedButton("회원 로그인");
		add(MemberLoginButton);
		c = new Color(64,126,219);
		MemberLoginButton.setBackground(c); // 버튼 색깔
		MemberLoginButton.setForeground(Color.WHITE); // 버튼 글자 색깔
		MemberLoginButton.setBounds(30, 550, 530, 50); // 위치 설정 (x,y,width,height)
		MemberLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20)); // 글꼴 설정
		MemberLoginButton.addActionListener(this); // 이벤트 처리 등록
		
		// 돌봄이 로그인 버튼
		RoundedButton PetSitterLoginButton = new RoundedButton("돌봄이 로그인");
		add(PetSitterLoginButton);
		c = new Color(64,126,219);
		PetSitterLoginButton.setBackground(c);
		PetSitterLoginButton.setForeground(Color.WHITE);
		PetSitterLoginButton.setBounds(30, 610, 530, 50);
		PetSitterLoginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PetSitterLoginButton.addActionListener(this);
		
		// 종료 버튼
		RoundedButton ExitButton = new RoundedButton("종료하기");
		add(ExitButton);
		c = new Color(162,202,255);
		ExitButton.setBackground(c);
		ExitButton.setBounds(30, 670, 530, 50);
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ExitButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) { // 버튼 눌렀을 시 이벤트 처리
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
			int ans = ConfirmUI.showConfirmDialog(this,"정말 종료하시겠습니까?","확인 메세지",ConfirmUI.YES_NO_OPTION);
			if(ans == 0){ // 종료하기 선택 (Yes = 0 / No = 1)
				System.exit(0);
			}
			
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
	
}
