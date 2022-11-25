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
public class PetAppListUI extends JFrame implements ActionListener{

	protected JTable AppTable;
	protected DefaultTableModel AppModel;
	
	public PetAppListUI() {
		super("PetAppListUI");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		String header[] = {"-", "지역", "시간"};
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
		
		JButton LookupButton = new JButton("조회");
		add(LookupButton);
		LookupButton.setBounds(450, 700, 100, 30);
		LookupButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
			
		}
		else {
			System.out.println("Unexpected Error");
			System.exit(0);
		}
	}
}
