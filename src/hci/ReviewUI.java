package hci;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ReviewUI extends JFrame implements ActionListener{
		
	JTextField ReviewTitleField;
	JTextArea ReviewArea;
	
	JComboBox<String> ReviewCombo;
	
	public ReviewUI() {
		super("ReviewUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel ReviewLabel = new JLabel("별점");
		add(ReviewLabel);
		ReviewLabel.setBounds(120, 130, 100, 40);
		ReviewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		String ReviewPoint[] = {"★★★★★","★★★★☆","★★★☆☆","★★☆☆☆","★☆☆☆☆"};
		ReviewCombo = new JComboBox<String>(ReviewPoint);
		add(ReviewCombo);
		ReviewCombo.setBounds(220, 130, 200, 40);
		ReviewCombo.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		ReviewTitleField = new JTextField();
		add(ReviewTitleField);
		ReviewTitleField.setToolTipText("제목");
		
		ReviewTitleField.setBounds(30, 200, 520, 50);
		ReviewTitleField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	
		ReviewArea = new JTextArea();
		add(ReviewArea);
		
		ReviewArea.setBounds(30, 300, 520, 300);
		ReviewArea.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		
		JButton CancelButton = new JButton("뒤로가기");
		add(CancelButton);
		CancelButton.setBounds(30, 700, 100, 30);
		CancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CancelButton.addActionListener(this);
		
		JButton SubmitButton = new JButton("제출");
		add(SubmitButton);
		SubmitButton.setBounds(450, 700, 100, 30);
		SubmitButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		SubmitButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String ActionCmd = e.getActionCommand();
		if(ActionCmd.equals("뒤로가기")) {
			MemberUI MemberWindow = new MemberUI();
			MemberWindow.setVisible(true);
			dispose();
		}
		else if(ActionCmd.equals("제출")) {
			int ans = JOptionPane.showConfirmDialog(null,"리뷰를 제출하시겠습니까?","확인 메세지",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ans == 0){ // 리뷰 제출 수락
				JOptionPane.showMessageDialog(null,"리뷰가 제출되었습니다","제출 완료",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
	
}
