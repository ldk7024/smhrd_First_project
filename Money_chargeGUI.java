package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Money_chargeGUI<VO_S> {
	private JFrame frame;
	private JTextField tfd_ChargeMoneyInput;
	DAO_C dao_C = new DAO_C();
	VO_C vo_C;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Money_chargeGUI window = new Money_chargeGUI();
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
	public Money_chargeGUI(VO_C vo_C) {
		initialize(vo_C);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO_C vo_C) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uC608\uCE58\uAE08 \uCDA9\uC804");
		lbl_BackHome.setFont(new Font("±¼¸²", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 0, 1184, 136);
		frame.getContentPane().add(lbl_BackHome);

		JButton btn_MyPage = new JButton("My page");
		btn_MyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new MyPageGUI();
				frame.dispose();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 146, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("\uC608\uCE58\uAE08\uC561:");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(50, 100, 84, 47);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lbl_MoneyInput = new JLabel("\uC608\uCE58\uAE08\uC561\uCD9C\uB825");
		lbl_MoneyInput.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lbl_MoneyInput.setBounds(120, 106, 96, 34);
		frame.getContentPane().add(lbl_MoneyInput);
		btn_MyPage.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		btn_MyPage.setBounds(919, 62, 116, 45);
		frame.getContentPane().add(btn_MyPage);

		JButton btn_LogOut = new JButton("Logout");
		btn_LogOut.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		btn_LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LogOut.setBounds(1066, 62, 116, 45);
		frame.getContentPane().add(btn_LogOut);

		JLabel lblNewLabel_2 = new JLabel("\uACC4\uC88C\uBC88\uD638:");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(32, 229, 252, 94);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("\uD604\uC7AC \uC608\uCE58\uAE08:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		label.setBounds(103, 349, 181, 37);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\uCDA9\uC804\uD560 \uAE08\uC561:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		label_1.setBounds(151, 431, 140, 66);
		frame.getContentPane().add(label_1);

		JLabel lbl_AccountPrint = new JLabel("\uACC4\uC88C\uBC88\uD638 \uCD9C\uB825");
		lbl_AccountPrint.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lbl_AccountPrint.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AccountPrint.setBounds(306, 249, 718, 37);
		frame.getContentPane().add(lbl_AccountPrint);

		JLabel lbl_CurrentMoneyPrint = new JLabel("\uD604\uC7AC \uC608\uCE58\uAE08 \uCD9C\uB825 ");
		lbl_CurrentMoneyPrint.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CurrentMoneyPrint.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lbl_CurrentMoneyPrint.setBounds(310, 350, 707, 38);
		frame.getContentPane().add(lbl_CurrentMoneyPrint);

		tfd_ChargeMoneyInput = new JTextField();
		tfd_ChargeMoneyInput.setBounds(325, 445, 692, 34);
		frame.getContentPane().add(tfd_ChargeMoneyInput);
		tfd_ChargeMoneyInput.setColumns(10);

		JButton btn_Charge = new JButton("\uCDA9\uC804\uD558\uAE30");
		btn_Charge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Charge.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_Charge.setBounds(470, 574, 343, 94);
		frame.getContentPane().add(btn_Charge);
	}

}
