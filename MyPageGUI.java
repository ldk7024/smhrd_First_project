package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MyPageGUI {
	private JFrame frame;
	private JTable tbl_RentList;
	DAO_C dao_C = new DAO_C();
	VO_S vo_S;
	private JTable tbl_;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyPageGUI window = new MyPageGUI(vo);
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
	public MyPageGUI(VO_S vo_S) {
		initialize(vo_S);
		frame.setVisible(true);
	}

	/**
	 */
	private void initialize(VO_S vo_S) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("My Page");
		lbl_BackHome.setBounds(10, 10, 1174, 86);
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 44));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_BackHome);

		JButton btn_PrivateFix = new JButton("\uAC1C\uC778\uC815\uBCF4\uC218\uC815");
		btn_PrivateFix.setBounds(974, 52, 158, 36);
		btn_PrivateFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Private_changeGUI();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_PrivateFix);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 106, 1184, 1);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC608\uCE58\uAE08\uC561:");
		lblNewLabel_2.setBounds(0, 138, 116, 23);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lbl_MoneyPrint = new JLabel();
		lbl_MoneyPrint.setBounds(128, 138, 97, 23);
		lbl_MoneyPrint.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_MoneyPrint.setText("\uC608\uCE58\uAE08\uC561 \uCD9C\uB825");
		frame.getContentPane().add(lbl_MoneyPrint);
		// -------------------예치금 보여주는 알고리즘-------------------
		if (vo_S.getId() != null) {
			// 일반 고객으로 로그인 했을 때
			lbl_MoneyPrint.setText(dao_C.loginMoney(vo_S.getId()));
//					String m = dao.loginMoney(vo);
//					System.out.println(m);
		} else if (vo_S.getId().equals("admin")) {
			// admin으로 로그인 했을 때
			lbl_MoneyPrint.setVisible(false);
		} else {
			// 로그인하지 않았을 때
			lbl_MoneyPrint.setVisible(false);
		}

		JButton btn_MoneyCharge = new JButton("\uC608\uCE58\uAE08 \uCDA9\uC804");
		btn_MoneyCharge.setBounds(726, 115, 167, 60);
		btn_MoneyCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Money_chargeGUI();
				frame.dispose();
			}
		});
		btn_MoneyCharge.setFont(new Font("굴림", Font.PLAIN, 24));
		frame.getContentPane().add(btn_MoneyCharge);

		JButton btn_ReturnRequest = new JButton("\uBC18\uB0A9\uC2E0\uCCAD");
		btn_ReturnRequest.setBounds(929, 115, 158, 60);
		btn_ReturnRequest.setFont(new Font("굴림", Font.PLAIN, 24));
		frame.getContentPane().add(btn_ReturnRequest);

		JScrollPane pnl_InspectionList = new JScrollPane();
		pnl_InspectionList.setBounds(38, 276, 1082, 247);
		frame.getContentPane().add(pnl_InspectionList);
		
		tbl_ = new JTable();
		pnl_InspectionList.setViewportView(tbl_);


	}

}
