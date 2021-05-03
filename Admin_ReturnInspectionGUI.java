package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Admin_ReturnInspectionGUI {
	private JFrame frame;
	private JTable tbl_InspectionList;
	DAO dao = new DAO();
	ArrayList<VOreturn> al = dao.select_T();
	int deposit = 0;
	int tdeposit = 0;
	String rnumber = "";
	int rmoney = 0;
	int num ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_ReturnInspectionGUI window = new Admin_ReturnInspectionGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_ReturnInspectionGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0 - \uBC18\uB0A9\uD488 \uAC80\uC218");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1184, 116);
		frame.getContentPane().add(lbl_BackHome);

		JScrollPane pnl_InspectionList = new JScrollPane();
		pnl_InspectionList.setBounds(38, 276, 1082, 247);
		frame.getContentPane().add(pnl_InspectionList);

//		tbl_InspectionList = new JTable();
		String[][] data = new String[al.size()][7];// DB에는int로 설정 , String을 같이 가지고 와야해서 VO 싹다 String으로 바꿈(문제생길듯일단해봄);
		String[] header = { "대여번호", "보증금", "대여개월수", "대여금액", "총결제금액", "연체여부", "예상반환금액" };
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j <= 6; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getRnumber();
				} else if (j == 1) {
					data[i][j] = al.get(i).getDeposit();
				} else if (j == 2) {
					data[i][j] = al.get(i).getRmonth();
				} else if (j == 3) {
					data[i][j] = al.get(i).getRmoney();
				} else if (j == 4) {
					data[i][j] = al.get(i).getTpmoney();
				} else if (j == 5) {
					data[i][j] = al.get(i).getLatepayment();
				} else if (j == 6) {
					data[i][j] = al.get(i).getEpayback();
				}
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 403, 398, -278);
		// 패널 스크롤 추가

		// pnl_ProductList.add(scrollPane);

		JTable tbl_InspectionList = new JTable(data, header);// 보증금
		tbl_InspectionList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_InspectionList.getSelectedRow();
				deposit = Integer.parseInt((String) tbl_InspectionList.getModel().getValueAt(row, 1));
				System.out.println(deposit);
				rnumber = (String) tbl_InspectionList.getModel().getValueAt(row, 0);
				System.out.println(rnumber);
				rmoney = Integer.parseInt((String) tbl_InspectionList.getModel().getValueAt(row, 3));
				System.out.println(rmoney);
				
			}
		});
		tbl_InspectionList.setFillsViewportHeight(true);

		tbl_InspectionList.addMouseListener(new MouseAdapter() {
		});
		pnl_InspectionList.setViewportView(tbl_InspectionList);

		JLabel lblNewLabel_1 = new JLabel("\uBB3C\uD488\uC758 \uC0C1\uD0DC \uC810\uC218:");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(83, 569, 221, 62);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBC18\uD658 \uBCF4\uC99D\uAE08:");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(124, 669, 162, 53);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lbl_ReturnDepositPrint = new JLabel("");// 반환보증금 변수 입력
		lbl_ReturnDepositPrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ReturnDepositPrint.setFont(new Font("굴림", Font.PLAIN, 20));
		lbl_ReturnDepositPrint.setBounds(298, 671, 269, 53);
		frame.getContentPane().add(lbl_ReturnDepositPrint);

		JLabel label = new JLabel("\uBC18\uD658 \uC608\uCE58\uAE08(\uD398\uC774\uBC31):");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.PLAIN, 24));
		label.setBounds(582, 674, 281, 43);
		frame.getContentPane().add(label);

		JLabel lbl_ReturnMoneyPrint = new JLabel(String.valueOf(num));// 반환예치금 변수입력
		lbl_ReturnMoneyPrint.setFont(new Font("굴림", Font.PLAIN, 20));
		lbl_ReturnMoneyPrint.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ReturnMoneyPrint.setBounds(875, 679, 269, 36);
		frame.getContentPane().add(lbl_ReturnMoneyPrint);

		JLabel lblNewLabel_5 = new JLabel(String.valueOf(tdeposit));
		lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5.setBounds(0, 124, 1184, 1);
		frame.getContentPane().add(lblNewLabel_5);

		String[] score = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JComboBox cmb_ProductStateScore = new JComboBox(score);// 점수변수
		cmb_ProductStateScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println(cmb_ProductStateScore.getSelectedItem().toString());
				String rm = dao.select_rmoney(rnumber);
				String rn = dao.select_rnumber(rnumber);
				if(rn.equals(rnumber)) {
					num = (int) (rmoney*0.3);
				}
				switch (cmb_ProductStateScore.getSelectedItem().toString()) {
				case "0":
					tdeposit = (int) (deposit * 0);
					break;
				case "1":
					tdeposit = (int) (deposit * 0.1);
					break;
				case "2":
					tdeposit = (int) (deposit * 0.2);
					break;
				case "3":
					tdeposit = (int) (deposit * 0.3);
					break;
				case "4":
					tdeposit = (int) (deposit * 0.4);
					break;
				case "5":
					tdeposit = (int) (deposit * 0.5);
					break;
				case "6":
					tdeposit = (int) (deposit * 0.6);
					break;
				case "7":
					tdeposit = (int) (deposit * 0.7);
					break;
				case "8":
					tdeposit = (int) (deposit * 0.8);
					break;
				case "9":
					tdeposit = (int) (deposit * 0.9);
					break;
				case "10":
					tdeposit = deposit;
					break;
				}

			}
		});

		cmb_ProductStateScore.setBounds(331, 594, 320, 21);
		frame.getContentPane().add(cmb_ProductStateScore);

		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn_Inspection = new JButton("\uAC80\uC218");
		btn_Inspection.setFont(new Font("굴림", Font.PLAIN, 24));
		btn_Inspection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JLabel lbl_ReturnDepositPrint = new JLabel(String.valueOf(result));//반환보증금 변수
				// 입력
				lbl_ReturnDepositPrint.setText(tdeposit + " ");
				lbl_ReturnMoneyPrint.setText(num + " ");
			}
		});
		btn_Inspection.setBounds(932, 149, 188, 62);
		frame.getContentPane().add(btn_Inspection);
		
		JButton button = new JButton("Main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_MainGUI ();
				frame.dispose();
			}
		});
		button.setBounds(1006, 69, 155, 40);
		frame.getContentPane().add(button);
	}

//	public static int[] StringToIntArray(String[] sArr) {
//	      //스트링 배열을 int배열로 만들어주는 메소드
//	      //인트 배열 = StringToIntArray(인트로 바꿀 스트링 배열)
//	      int[] arr = new int[sArr.length];
//	      for (int i = 0; i < sArr.length; i++) {
//	         arr[i] = Integer.parseInt(sArr[i]);
//	      }
//	      return arr;
//	   }
//	  public static String[] IntToStringArray(int[] arr) {
//	      //int 배열을 String 배열로 바꿔주는 메소드
//	      String[] sArr = new String[arr.length];
//	      for (int i = 0; i < arr.length; i++) {
//	         sArr[i] = Integer.toString(arr[i]);
//	      }
//	      return sArr;
//	   }
}
