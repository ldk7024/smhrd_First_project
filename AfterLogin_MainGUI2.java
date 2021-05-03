package BabyProductsRental;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterLogin_MainGUI2 {
	private JFrame frame;
	private JPanel pnl_CircleChart;
	private JTable tbl_ProductList;
	DAO dao = new DAO();
	VO_C vo_C;
	VO_S vo_S;
	productionDAO pdao = new productionDAO();
	productionVO pvo;
	ArrayList<productionVO> al = null;
	String selected_pid = null;

	Color[] color = { new Color(253, 115, 0), new Color(255, 175, 0), new Color(255, 236, 0), new Color(213, 243, 11),
			new Color(45, 203, 117), new Color(127, 127, 127), new Color(166, 166, 166), new Color(191, 191, 191),
			new Color(217, 217, 217), new Color(242, 242, 242), };
	int i;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
//	      EventQueue.invokeLater(new Runnable() {
//	         public void run() { 
//	            try {
//	               AfterLogin_MainGUI window = new AfterLogin_MainGUI(vo);
//	               window.frame.setVisible(true);
//	            } catch (Exception e) {
//	               e.printStackTrace();
//	            }
//	         }
//	      });
	// }

	/**
	 * Create the application.
	 */
	public AfterLogin_MainGUI2() {
		al = pdao.mainTableSelect();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String[] header = { "물품번호", "물품명", "월금액", "소분류", "상세정보" };
		// 데이터 = 2차원 배열
		String[][] data = new String[al.size()][5];
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getPnumber();
				} else if (j == 1) {
					data[i][j] = al.get(i).getPname();
				} else if (j == 2) {
					data[i][j] = al.get(i).getSmallctg();
				} else if (j == 3) {
					data[i][j] = al.get(i).getMonthmoney();
				} else if (j == 4) {
					data[i][j] = al.get(i).getPdetail();
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

		JLabel lbl_BackHome = new JLabel("\uBA54\uC778 \uD654\uBA74");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 44));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 0, 1184, 131);
		frame.getContentPane().add(lbl_BackHome);

		JButton btn_MyPage = new JButton("My Page");
		btn_MyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				new MyPageGUI();
				frame.dispose();
			}
		});
		btn_MyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_MyPage.setFont(new Font("굴림", Font.PLAIN, 19));
		btn_MyPage.setBounds(930, 95, 137, 34);
		frame.getContentPane().add(btn_MyPage);

		JButton btn_LogOut = new JButton("LogOut");
		btn_LogOut.setFont(new Font("굴림", Font.PLAIN, 19));
		btn_LogOut.setBounds(1075, 95, 97, 34);
		frame.getContentPane().add(btn_LogOut);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 139, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("\uC608\uCE58\uAE08\uC561:");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 95, 112, 34);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lbl_MoneyPrint = new JLabel("25000");
		lbl_MoneyPrint.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_MoneyPrint.setBounds(90, 95, 98, 34);
		frame.getContentPane().add(lbl_MoneyPrint);

		// -------------------예치금 보여주는 알고리즘-------------------
//		if (vo_S.getId() != null) {
//			// 일반 고객으로 로그인 했을 때
//			lbl_MoneyPrint.setText(dao.loginMoney(vo_S.getId()));
//		} else if (vo_S.getId().equals("admin")) {
//			// admin으로 로그인 했을 때
//			lbl_MoneyPrint.setVisible(false);
//		} else {
//			// 로그인하지 않았을 때
//			lbl_MoneyPrint.setVisible(false);
//		}

		JLabel lblNewLabel_2 = new JLabel("\uC774\uB2EC\uC758 TOP10");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(90, 153, 297, 34);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("TOP10 \uC0C1\uC138\uC815\uBCF4");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(656, 153, 369, 34);
		frame.getContentPane().add(lblNewLabel_3);

		JPanel pnl_BarChart = new JPanel();
		pnl_BarChart.setBounds(12, 197, 516, 243);
		frame.getContentPane().add(pnl_BarChart);
		pnl_BarChart.setLayout(null);
		
				JPanel pnl_ShowLegend = new JPanel();
				pnl_ShowLegend.setBounds(12, 10, 146, 223);
				pnl_BarChart.add(pnl_ShowLegend);
				pnl_ShowLegend.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnl_ShowBarChart = new JPanel();
		pnl_ShowBarChart.setBounds(168, 10, 336, 223);
		pnl_BarChart.add(pnl_ShowBarChart);
		pnl_ShowBarChart.setLayout(null);

		pnl_CircleChart = new JPanel();
		pnl_CircleChart.setBounds(29, 197, 297, 243);
		frame.getContentPane().add(pnl_CircleChart);
		pnl_CircleChart.setLayout(null);


		JPanel pnl_DetailInfoTOP10 = new JPanel();
		pnl_DetailInfoTOP10.setBounds(540, 197, 613, 243);
		frame.getContentPane().add(pnl_DetailInfoTOP10);
		pnl_DetailInfoTOP10.setLayout(null);
		
				
				JLabel pname = new JLabel("\uBB3C\uD488\uBA85");
				pname.setHorizontalAlignment(SwingConstants.LEFT);
				pname.setFont(new Font("굴림", Font.PLAIN, 24));
				pname.setBounds(248, 11, 103, 52);
				pnl_DetailInfoTOP10.add(pname);
				pname.setVisible(false);
		
		JLabel pmonthMoney = new JLabel("\uC6D4 \uAE08\uC561");
		pmonthMoney.setHorizontalAlignment(SwingConstants.LEFT);
		pmonthMoney.setFont(new Font("굴림", Font.PLAIN, 24));
		pmonthMoney.setBounds(248, 76, 103, 52);
		pnl_DetailInfoTOP10.add(pmonthMoney);
		pmonthMoney.setVisible(false);

		JLabel pnamePrint = new JLabel((String) null);
		pnamePrint.setHorizontalAlignment(SwingConstants.LEFT);
		pnamePrint.setFont(new Font("굴림", Font.PLAIN, 24));
		pnamePrint.setBounds(357, 11, 265, 52);
		pnl_DetailInfoTOP10.add(pnamePrint);
		

		JLabel pdetailPrint = new JLabel((String) null);
		pdetailPrint.setHorizontalAlignment(SwingConstants.CENTER);
		pdetailPrint.setFont(new Font("굴림", Font.PLAIN, 24));
		pdetailPrint.setBounds(47, 181, 585, 52);
		pnl_DetailInfoTOP10.add(pdetailPrint);

		// --------------------잠시 사진 업로드가 있겠습니다... ^^-----------------------
		ImageIcon img1 = new ImageIcon("img/babyCarriage.jpg");
		Image c_img1 = img1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon c_ic_img1 = new ImageIcon(c_img1);

		ImageIcon img2 = new ImageIcon("img/babyStool.jpg");
		Image c_img2 = img2.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH);
		ImageIcon c_ic_img2 = new ImageIcon(c_img2);

		ImageIcon img3 = new ImageIcon("img/bed.jpg");
		Image c_img3 = img3.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH);
		ImageIcon c_ic_img3 = new ImageIcon(c_img3);

		ImageIcon img4 = new ImageIcon("img/carSeat.jpg");
		Image c_img4 = img4.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH);
		ImageIcon c_ic_img4 = new ImageIcon(c_img4);

		ImageIcon img5 = new ImageIcon("img/jumperoo.jpg");
		Image c_img5 = img5.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH);
		ImageIcon c_ic_img5 = new ImageIcon(c_img5);

		ImageIcon img6 = new ImageIcon("img/saucer.jpg");
		Image c_img6 = img6.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon c_ic_img6 = new ImageIcon(c_img6);

		ImageIcon img7 = new ImageIcon("img/step.jpg");
		Image c_img7 = img7.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH);
		ImageIcon c_ic_img7 = new ImageIcon(c_img7);

		ImageIcon img8 = new ImageIcon("img/walker.jpg");
		Image c_img8 = img8.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon c_ic_img8 = new ImageIcon(c_img8);
		// --------------------잠시 사진 업로드가 있었습니다... ^^-----------------------

		JLabel top10productImage = new JLabel("");
		top10productImage.setBounds(27, 11, 187, 160);
		pnl_DetailInfoTOP10.add(top10productImage);

		


		JLabel pmonthMoneyPrint = new JLabel((String) null);
		pmonthMoneyPrint.setHorizontalAlignment(SwingConstants.LEFT);
		pmonthMoneyPrint.setFont(new Font("굴림", Font.PLAIN, 24));
		pmonthMoneyPrint.setBounds(357, 76, 265, 52);
		pnl_DetailInfoTOP10.add(pmonthMoneyPrint);

		JButton[] btnsLegend = new JButton[10];
		for ( i = 0; i < 10; i++) {
			btnsLegend[i] = new JButton();
			btnsLegend[i].setText((i + 1) + ". " + pdao.all_desc().get(i).getPname());
			pnl_ShowLegend.add(btnsLegend[i]);
			btnsLegend[i].setBackground(color[i]);
			btnsLegend[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton btn = new JButton();
					btn = (JButton) arg0.getSource();
					String btnName = btn.getText().substring(3);
					pnamePrint.setText(btnName);
					pname.setVisible(true);
									
					pvo = pdao.selectByName(btnName);
					
					switch (pvo.getSmallctg()) {
					case "카시트":
						top10productImage.setIcon(c_ic_img4);
						break;
					case "보행기":
						top10productImage.setIcon(c_ic_img8);
						break;
					case "식탁의자":
						top10productImage.setIcon(c_ic_img2);
						break;
					case "유아용 침대":
						top10productImage.setIcon(c_ic_img3);
						break;
					case "유모차":
						top10productImage.setIcon(c_ic_img1);
						break;
					case "스텝":
						top10productImage.setIcon(c_ic_img7);
						break;
					case "소서":
						top10productImage.setIcon(c_ic_img6);
						break;
					case "점퍼루":
						top10productImage.setIcon(c_ic_img5);
						break;
					}
					
					pmonthMoney.setVisible(true);
					pmonthMoneyPrint.setText(pvo.getMonthmoney());
					
					pdetailPrint.setText(pvo.getPdetail());
				}
			});
		}

		JButton[] btnBars = new JButton[10];
		for (int i = 0; i < 10; i++) {
			
			int xlen = 17;
			int ylen = 7;
			int gy = 223; // 패널의 높이(길이)
			int cnt = Integer.parseInt(pdao.all_desc().get(i).getRcount());
			btnBars[i] = new JButton();
			btnBars[i].setBounds(xlen * 2 * i, (gy - (cnt * ylen)), 25, cnt * ylen);
			pnl_ShowBarChart.add(btnBars[i]);
			btnBars[i].setBackground(color[i]);

			btnBars[i].setEnabled(false);
		
		}

		JScrollPane scrollPane = new JScrollPane();
		JPanel pnl_ProductList = new JPanel();
		pnl_ProductList.setBounds(27, 461, 1126, 361);
		frame.getContentPane().add(pnl_ProductList);
		pnl_ProductList.setLayout(new BorderLayout(0, 0));
		// 패널에 스크롤 추가!!
		pnl_ProductList.add(scrollPane);

		// 테이블 생성
		JTable table = new JTable(data, header);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			// 클릭한 열의 물품번호를 받아와서 상세 페이지로 전환 할 때 사용하기
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				selected_pid = (String) table.getModel().getValueAt(row, 0);
				System.out.println();
				new Product_DetailPageGUI(vo_S, pdao.selectByID(selected_pid));
				frame.dispose();
			}
		});
		scrollPane.setViewportView(table);
		// 패널전체에 테이블이 꽉차게 만들고 싶을 때
		table.setFillsViewportHeight(true);
		// 테이블을 스크롤 패널에 추가, 컬럼 이름 보이기 위해서 추가 **
//	      scrollPane.setViewportView(table);

		// tbl_ProductList = new JTable();
		// pnl_ProductList.add(tbl_ProductList);

		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
