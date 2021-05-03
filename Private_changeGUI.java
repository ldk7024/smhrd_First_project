package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Private_changeGUI {
	private JFrame frame;
	private JPasswordField tfd_PWInput;
	private JButton btn_Finish;
	private JPasswordField tfd_ConformPWInput;
	private JTextField tfd_Address;
	private JTextField tfd_PhoneNumber;
	private JTextField tfd_BankAccount;
	
	DAO_C dao_C = new DAO_C();
	VOupdate_C updatevo_C;
	VO_S num = null;
			

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Private_changeGUI window = new Private_changeGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	/**
	 * Create the application.
	 */
	public Private_changeGUI(VO_C vo_C) {
		num = dao_C.select_C(vo_C.getId());
		initialize(vo_C);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO_C vo_C) {
		
//		for (int i = 0; i < arr.size(); i++) {
//			
//			VO_C a = arr.get(i);
//		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_BackHome = new JLabel("\uAC1C\uC778 \uC815\uBCF4 \uC218\uC815");
		lbl_BackHome.setFont(new Font("±¼¸²", Font.BOLD, 44));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(10, 0, 1194, 108);
		frame.getContentPane().add(lbl_BackHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 105, 1172, 1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblId.setBounds(94, 163, 163, 32);
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel_2 = new JLabel("PW:");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(94, 219, 163, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblConformPw = new JLabel("Conform Password:");
		lblConformPw.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblConformPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConformPw.setBounds(10, 275, 247, 32);
		frame.getContentPane().add(lblConformPw);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(94, 335, 163, 32);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setBounds(94, 395, 163, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblBankAccount = new JLabel("Bank Account:");
		lblBankAccount.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblBankAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBankAccount.setBounds(66, 448, 191, 47);
		frame.getContentPane().add(lblBankAccount);
		
		JLabel lbl_LoginIDPrint = new JLabel("\uB85C\uADF8\uC778\uB41C \uD68C\uC6D0 ID \uCD9C\uB825");
		lbl_LoginIDPrint.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_LoginIDPrint.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lbl_LoginIDPrint.setBounds(273, 163, 284, 32);
		lbl_LoginIDPrint.setText( vo_C.getId() );
		frame.getContentPane().add(lbl_LoginIDPrint);
		
		tfd_PWInput = new JPasswordField();
		tfd_PWInput.setBounds(273, 220, 707, 31);
		frame.getContentPane().add(tfd_PWInput);
		tfd_PWInput.setText(num.getPw());
		
		tfd_ConformPWInput = new JPasswordField();
		tfd_ConformPWInput.setBounds(273, 280, 707, 31);
		frame.getContentPane().add(tfd_ConformPWInput);
		tfd_ConformPWInput.setText( num.getPw() );
		
		tfd_Address = new JTextField();
		tfd_Address.setBounds(269, 340, 711, 31);
		frame.getContentPane().add(tfd_Address);
		tfd_Address.setColumns(10);
		tfd_Address.setText( num.getAddress());
		
		tfd_PhoneNumber = new JTextField();
		tfd_PhoneNumber.setColumns(10);
		tfd_PhoneNumber.setBounds(269, 405, 711, 31);
		frame.getContentPane().add(tfd_PhoneNumber);
		tfd_PhoneNumber.setText( num.getPhonenumber());
		
		tfd_BankAccount = new JTextField();
		tfd_BankAccount.setColumns(10);
		tfd_BankAccount.setBounds(269, 465, 711, 31);
		frame.getContentPane().add(tfd_BankAccount);
		tfd_BankAccount.setText( num.getAccount());
		
		JButton btn_MyPage = new JButton("My Page");
		btn_MyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPageGUI(vo_S);
				frame.dispose();
				
			}
		});
		btn_MyPage.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		btn_MyPage.setBounds(1024, 65, 100, 30);
		frame.getContentPane().add(btn_MyPage);
		
		btn_Finish = new JButton("\uC644\uB8CC");
		btn_Finish.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_Finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = lbl_LoginIDPrint.getText();
				String pw = tfd_PWInput.getText();
				String confirmPW = tfd_ConformPWInput.getText();
				String address = tfd_Address.getText();
				String phonenumber = tfd_PhoneNumber.getText();		
				String bankaccount = tfd_BankAccount.getText();
				
				if( pw.equals( confirmPW ) ) {
					dao_C.update_customer( id, pw, address, phonenumber, bankaccount);
					new MyPageGUI(vo_S);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ÆÐ½º¿öµå¸¦ ¸ÂÃçÁÖ¼¼¿ä");
				}
			}
		});
		btn_Finish.setBounds(833, 552, 200, 47);
		frame.getContentPane().add(btn_Finish);
		
		
	}

}
