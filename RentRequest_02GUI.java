package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RentRequest_02GUI {
	private JFrame frame;

	DAO dao = new DAO();
	VO_S vo_S;
	productionVO pvo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RentRequest_02GUI window = new RentRequest_02GUI();
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
	public RentRequest_02GUI(VO_S vo_S, productionVO pvo, String choiceMonth) {
		initialize(vo_S, pvo, choiceMonth);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO_S vo_S, productionVO pvo, String choiceMonth) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uB300\uC5EC \uC2E0\uCCAD");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1172, 142);
		frame.getContentPane().add(lbl_BackHome);

		JLabel label_3 = new JLabel("\uC608\uCE58\uAE08\uC561:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("굴림", Font.PLAIN, 15));
		label_3.setBounds(12, 111, 125, 41);
		frame.getContentPane().add(label_3);

		JLabel lbl_MoneyPrint01 = new JLabel("\uC608\uCE58\uAE08\uC561 \uCD9C\uB825");
		lbl_MoneyPrint01.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_MoneyPrint01.setBounds(143, 120, 97, 21);
		frame.getContentPane().add(lbl_MoneyPrint01);
		// -------------------예치금 보여주는 알고리즘-------------------
		if (vo_S.getId() != null) {
			// 일반 고객으로 로그인 했을 때
			lbl_MoneyPrint01.setText(dao.loginMoney(vo_S.getId()));
		} else if (vo_S.getId().equals("admin")) {
			// admin으로 로그인 했을 때
			lbl_MoneyPrint01.setVisible(false);
		} else {
			// 로그인하지 않았을 때
			lbl_MoneyPrint01.setVisible(false);
		}

		JButton btn_MyPage = new JButton("My page");
		btn_MyPage.setFont(new Font("굴림", Font.PLAIN, 19));
		btn_MyPage.setBounds(917, 67, 109, 41);
		frame.getContentPane().add(btn_MyPage);

		JButton btn_LogOut = new JButton("Logout");
		btn_LogOut.setFont(new Font("굴림", Font.PLAIN, 19));
		btn_LogOut.setBounds(1038, 67, 121, 41);
		frame.getContentPane().add(btn_LogOut);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 151, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBB3C\uD488\uBA85 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(123, 333, 125, 80);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lbl_ProductNamePrint = new JLabel("\uBB3C\uD488\uC774\uB984");
		lbl_ProductNamePrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ProductNamePrint.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_ProductNamePrint.setBounds(254, 332, 310, 80);
		frame.getContentPane().add(lbl_ProductNamePrint);
		lbl_ProductNamePrint.setText(pvo.getPname());

		JLabel label_1 = new JLabel("\uACE0\uAC1D\uBA85 : ");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("굴림", Font.PLAIN, 24));
		label_1.setBounds(123, 423, 125, 80);
		frame.getContentPane().add(label_1);

		JLabel lbl_CustomerNamePrint = new JLabel("\uACE0\uAC1D\uBA85");
		lbl_CustomerNamePrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CustomerNamePrint.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_CustomerNamePrint.setBounds(254, 423, 310, 80);
		frame.getContentPane().add(lbl_CustomerNamePrint);
		lbl_CustomerNamePrint.setText(dao.returnCustomerName(vo_S.getId()));

		JLabel label_2 = new JLabel("\uBC30\uC1A1\uC9C0 : ");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("굴림", Font.PLAIN, 24));
		label_2.setBounds(123, 510, 125, 86);
		frame.getContentPane().add(label_2);

		JLabel lbl_DeliveryAddressPrint = new JLabel("\uBC30\uC1A1\uC9C0 \uC8FC\uC18C");
		lbl_DeliveryAddressPrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DeliveryAddressPrint.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_DeliveryAddressPrint.setBounds(254, 510, 310, 86);
		frame.getContentPane().add(lbl_DeliveryAddressPrint);
		lbl_DeliveryAddressPrint.setText(dao.returnCustomerAddress(vo_S.getId()));

		JLabel label = new JLabel("\uACB0\uC81C\uAE08\uC561");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.PLAIN, 24));
		label.setBounds(688, 219, 264, 79);
		frame.getContentPane().add(label);

		JLabel deposit = new JLabel("\uC608\uCE58\uAE08\uC561");
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		deposit.setFont(new Font("굴림", Font.PLAIN, 18));
		deposit.setBounds(642, 308, 160, 41);
		frame.getContentPane().add(deposit);

		JLabel deposit_print = new JLabel("\uC608\uCE58\uAE08\uC561");
		deposit_print.setHorizontalAlignment(SwingConstants.LEFT);
		deposit_print.setFont(new Font("굴림", Font.PLAIN, 18));
		deposit_print.setBounds(827, 309, 191, 41);
		frame.getContentPane().add(deposit_print);
		if (vo_S.getId() != null) {
			// 일반 고객으로 로그인 했을 때
			deposit_print.setText(dao.loginMoney(vo_S.getId()));
		} else if (vo_S.getId().equals("admin")) {
			// admin으로 로그인 했을 때
			deposit_print.setVisible(false);
		} else {
			// 로그인하지 않았을 때
			deposit_print.setVisible(false);
		}

		JLabel lbl_MoneyPrint02 = new JLabel("- \uBCF4\uC99D\uAE08");
		lbl_MoneyPrint02.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MoneyPrint02.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl_MoneyPrint02.setBounds(643, 345, 159, 41);
		frame.getContentPane().add(lbl_MoneyPrint02);

		JLabel lbl_TotalPaymentPrint = new JLabel("- \uB300\uC5EC \uC6D4 * \uC6D4 \uAE08\uC561");
		lbl_TotalPaymentPrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TotalPaymentPrint.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl_TotalPaymentPrint.setBounds(642, 380, 160, 48);
		frame.getContentPane().add(lbl_TotalPaymentPrint);

		JLabel label_5 = new JLabel("");
		label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_5.setBounds(642, 457, 376, 1);
		frame.getContentPane().add(label_5);

		JLabel label_4 = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("굴림", Font.PLAIN, 18));
		label_4.setBounds(642, 469, 176, 48);
		frame.getContentPane().add(label_4);

		JLabel label_9 = new JLabel("\uACB0\uC81C \uD6C4 \uB0A8\uC740 \uC608\uCE58\uAE08");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("굴림", Font.PLAIN, 18));
		label_9.setBounds(642, 516, 176, 48);
		frame.getContentPane().add(label_9);

		JLabel money_print = new JLabel("- \uBCF4\uC99D\uAE08");
		money_print.setHorizontalAlignment(SwingConstants.LEFT);
		money_print.setFont(new Font("굴림", Font.PLAIN, 18));
		money_print.setBounds(828, 346, 190, 41);
		frame.getContentPane().add(money_print);
		int deposit_30 = (int) (Integer.parseInt(pvo.getCurrentprice()) * 0.3);
		String deposit_30_string = deposit_30 + "";
		money_print.setText("- " + deposit_30_string);

		JLabel pay_print = new JLabel(" \u3134\u3147\u313B");
		pay_print.setHorizontalAlignment(SwingConstants.LEFT);
		pay_print.setFont(new Font("굴림", Font.PLAIN, 18));
		pay_print.setBounds(827, 381, 191, 48);
		frame.getContentPane().add(pay_print);
		pay_print.setText("- " + choiceMonth + " * " + pvo.getMonthmoney());

		JLabel full_pay_print = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		full_pay_print.setHorizontalAlignment(SwingConstants.LEFT);
		full_pay_print.setFont(new Font("굴림", Font.PLAIN, 18));
		full_pay_print.setBounds(827, 469, 176, 48);
		frame.getContentPane().add(full_pay_print);
		int totalMinus = Integer.parseInt(pvo.getMonthmoney()) * Integer.parseInt(choiceMonth)
				+ Integer.parseInt(deposit_30_string);
		full_pay_print.setText(totalMinus + "");

		JLabel remain_money = new JLabel("\uACB0\uC81C \uD6C4 \uB0A8\uC740 \uC608\uCE58\uAE08");
		remain_money.setHorizontalAlignment(SwingConstants.LEFT);
		remain_money.setFont(new Font("굴림", Font.PLAIN, 18));
		remain_money.setBounds(827, 516, 176, 48);
		frame.getContentPane().add(remain_money);
		int remainMoney = Integer.parseInt(dao.loginMoney(vo_S.getId())) - totalMinus;
		remain_money.setText(remainMoney + "");

		// 버튼 달았을 때 업데이트 되어야 하는 것
		// 고객 (예치금을 빼줘야 함)
		// 물품 (대여 상태를 T로 바꿔줘야 함, 외부참조 customer_ID )
		// 대여 (1행을 아예 만들어 줘야 함)
		JButton btn_PaymentFinish = new JButton("\uACB0\uC81C \uC644\uB8CC");
		btn_PaymentFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	int cnt = dao.updateMoney(vo_S.getId(), totalMinus+"");
				new AfterLogin_MainGUI2();
				JOptionPane.showMessageDialog(null, "결제(대여) 성공");
			}
		});
		btn_PaymentFinish.setFont(new Font("굴림", Font.PLAIN, 24));
		btn_PaymentFinish.setBounds(642, 574, 374, 80);
		frame.getContentPane().add(btn_PaymentFinish);

	}
}
