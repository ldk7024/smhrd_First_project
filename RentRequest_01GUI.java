package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RentRequest_01GUI {
	private JFrame frame;
	DAO dao = new DAO();
	VO_S vo_S ;
	productionVO pvo;
	boolean agree = false;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RentRequest_01GUI window = new RentRequest_01GUI();
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
	public RentRequest_01GUI(VO_S  vo_S , productionVO pvo, String choiceMonth) {
		initialize( vo_S , pvo,choiceMonth);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.E
	 */
	private void initialize(VO_S  vo_S , productionVO pvo, String choiceMonth) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uB300\uC5EC\uC2E0\uCCAD");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 46));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 0, 1184, 163);
		frame.getContentPane().add(lbl_BackHome);

		JLabel lblNewLabel_2 = new JLabel("\uC608\uCE58\uAE08\uC561:");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(50, 100, 125, 41);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lbl_MoneyPrint = new JLabel("\uC608\uCE58\uAE08\uC561 \uCD9C\uB825");
		lbl_MoneyPrint.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_MoneyPrint.setBounds(180, 109, 97, 21);
		frame.getContentPane().add(lbl_MoneyPrint);
		// -------------------예치금 보여주는 알고리즘-------------------
		if (vo_S .getId() != null) {
			// 일반 고객으로 로그인 했을 때
			lbl_MoneyPrint.setText(dao.loginMoney(vo_S .getId()));
		} else if (vo_S .getId().equals("admin")) {
			// admin으로 로그인 했을 때
			lbl_MoneyPrint.setVisible(false);
		} else {
			// 로그인하지 않았을 때
			lbl_MoneyPrint.setVisible(false);
		}

		JButton bnt_MyPage = new JButton("My page");
		bnt_MyPage.setFont(new Font("굴림", Font.PLAIN, 19));
		bnt_MyPage.setBounds(936, 70, 109, 41);
		frame.getContentPane().add(bnt_MyPage);

		JButton btn_LogOut = new JButton("Logout");
		btn_LogOut.setFont(new Font("굴림", Font.PLAIN, 19));
		btn_LogOut.setBounds(1051, 70, 121, 41);
		frame.getContentPane().add(btn_LogOut);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 173, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lbl_RentProductName = new JLabel("\uB300\uC5EC\uD560 \uBB3C\uD488\uBA85");
		lbl_RentProductName.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_RentProductName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_RentProductName.setBounds(226, 243, 200, 46);
		frame.getContentPane().add(lbl_RentProductName);

		JLabel lbl_RentProductNamePrint = new JLabel("\uB300\uC5EC\uD560 \uBB3C\uD488\uBA85");
		lbl_RentProductNamePrint.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RentProductNamePrint.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_RentProductNamePrint.setBounds(456, 243, 524, 46);
		frame.getContentPane().add(lbl_RentProductNamePrint);
		lbl_RentProductNamePrint.setText(pvo.getPname());

		JLabel lbl_RentPrice = new JLabel("\uC6D4 \uAE08\uC561");
		lbl_RentPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_RentPrice.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_RentPrice.setBounds(225, 301, 200, 46);
		frame.getContentPane().add(lbl_RentPrice);

		JLabel lbl_RentPricePrint = new JLabel("\uC6D4 \uAE08\uC561");
		lbl_RentPricePrint.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RentPricePrint.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_RentPricePrint.setBounds(456, 301, 524, 46);
		frame.getContentPane().add(lbl_RentPricePrint);
		lbl_RentPricePrint.setText(pvo.getMonthmoney());
		
		JLabel rentPeriod = new JLabel("\uB300\uC5EC\uAE30\uAC04");
		rentPeriod.setHorizontalAlignment(SwingConstants.LEFT);
		rentPeriod.setFont(new Font("굴림", Font.PLAIN, 24));
		rentPeriod.setBounds(226, 356, 200, 46);
		frame.getContentPane().add(rentPeriod);
		
		JLabel rentPeriodPrint = new JLabel((String) null);
		rentPeriodPrint.setHorizontalAlignment(SwingConstants.CENTER);
		rentPeriodPrint.setFont(new Font("굴림", Font.PLAIN, 24));
		rentPeriodPrint.setBounds(456, 356, 524, 46);
		frame.getContentPane().add(rentPeriodPrint);
		rentPeriodPrint.setText(choiceMonth);
		
		String warning = 
				"\n"
				+ "\n"
				+ "<주의사항> \n"
				+ "- 총 결제 금액은 보증금과 대여기간*월 금액을 합산한 만큼입니다.\n"
				+ "- 보증금은 도난 및 훼손에 방지하기 위한 장치로 대여기간이 끝났을 시 물품의 상태에 따라 일정 퍼센트로 반환됩니다.\n"
				+ "- 예치금은 결제 수단으로 사용되며  어쩌고 저쩌고\n"
				+ "- 대여기간은 최대 3개월이며, 이를 어기고 연체 시 사이트 내 예치금에 접근할 수 없습니다.\n";
		
		JTextArea ta_WarningPrint = new JTextArea();
		ta_WarningPrint.setBounds(226, 406, 754, 137);
		frame.getContentPane().add(ta_WarningPrint);
		ta_WarningPrint.setText("\r\n\r\n<\uC8FC\uC758\uC0AC\uD56D> \r\n- \uCD1D \uACB0\uC81C \uAE08\uC561\uC740 \uBCF4\uC99D\uAE08\uACFC \uB300\uC5EC\uAE30\uAC04*\uC6D4 \uAE08\uC561\uC744 \uD569\uC0B0\uD55C \uAE08\uC561\uC785\uB2C8\uB2E4.\r\n- \uBCF4\uC99D\uAE08\uC740 \uB3C4\uB09C \uBC0F \uD6FC\uC190\uC5D0 \uBC29\uC9C0\uD558\uAE30 \uC704\uD55C \uC7A5\uCE58\uB85C \uB300\uC5EC\uAE30\uAC04\uC774 \uB05D\uB0AC\uC744 \uC2DC \uBB3C\uD488\uC758 \uC0C1\uD0DC\uC5D0 \uB530\uB77C \uC77C\uC815 \uD37C\uC13C\uD2B8\uB85C \uBC18\uD658\uB429\uB2C8\uB2E4.\r\n- \uC608\uCE58\uAE08\uC740 \uACB0\uC81C \uC218\uB2E8\uC73C\uB85C \uC0AC\uC6A9\uB418\uBA70 \uC911\uB3C4 \uBC18\uB0A9 \uC2DC 30% \uBC18\uD658\uB429\uB2C8\uB2E4.\r\n- \uB300\uC5EC\uAE30\uAC04\uC740 \uCD5C\uB300 3\uAC1C\uC6D4\uC774\uBA70, \uC774\uB97C \uC5B4\uAE30\uACE0 \uC5F0\uCCB4 \uC2DC \uC0AC\uC774\uD2B8 \uB0B4 \uC608\uCE58\uAE08\uC5D0 \uC811\uADFC\uD560 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.\r\n");

		JCheckBox cbx_Agree = new JCheckBox("\uB3D9\uC758");
		cbx_Agree.setFont(new Font("굴림", Font.PLAIN, 24));
		cbx_Agree.setBounds(226, 549, 200, 58);
		frame.getContentPane().add(cbx_Agree);

		JButton btn_Payment = new JButton("\uACB0\uC81C \uC9C4\uD589\uD558\uAE30");
		btn_Payment.setFont(new Font("굴림", Font.PLAIN, 24));
		btn_Payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agree = cbx_Agree.isSelected();
				if(agree == false) {
					JOptionPane.showMessageDialog(null, "동의여부를 체크해주세요");
				}
				else {
					new RentRequest_02GUI(vo_S, pvo, choiceMonth);
					frame.dispose();
				}
			}
		});
		
		btn_Payment.setBounds(226, 639, 754, 71);
		frame.getContentPane().add(btn_Payment);
	}}
