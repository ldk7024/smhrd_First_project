package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Admin_ProductSearchGUI {
	private JFrame frame;
	private JTable tbl_ProductList;
	DAO dao = new DAO();

	ArrayList<VO> al = dao.select_P();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_ProductSearchGUI window = new Admin_ProductSearchGUI();
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
	public Admin_ProductSearchGUI() {
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

		JLabel lbl_BackHome = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0 - \uBB3C\uD488\uC870\uD68C");
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setBounds(0, 10, 1184, 140);
		frame.getContentPane().add(lbl_BackHome);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 148, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btn_ProductInput = new JButton("\uB4F1\uB85D");
		btn_ProductInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_ProductInsertGUI();
				// 현재창 사라지게
				frame.dispose();
			}
		});
		btn_ProductInput.setFont(new Font("굴림", Font.PLAIN, 24));
		btn_ProductInput.setBounds(89, 187, 463, 80);
		frame.getContentPane().add(btn_ProductInput);

//		JButton btn_InfoChange = new JButton("\uC218\uC815");
//		btn_InfoChange.setFont(new Font("굴림", Font.PLAIN, 24));
//		btn_InfoChange.setBounds(313, 187, 210, 80);
//		frame.getContentPane().add(btn_InfoChange);

		JButton btn_ProductDel = new JButton("\uC0AD\uC81C");
		btn_ProductDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_ProductDeleteGUI();
				// 현재창 사라지게
				frame.dispose();
			}
		});
		btn_ProductDel.setFont(new Font("굴림", Font.PLAIN, 24));
		btn_ProductDel.setBounds(677, 187, 445, 80);
		frame.getContentPane().add(btn_ProductDel);

		JScrollPane pnl_ProductList = new JScrollPane();
		pnl_ProductList.setBounds(45, 300, 1122, 482);
		frame.getContentPane().add(pnl_ProductList);

		// 컬럼값(데이터) ->2차원배열
		String[][] data = new String[al.size()][6];
		String[] header = { "물품명", "물품번호", "대분류", "소분류", "물품원가", "대여상태(T/F)" };
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j <= 5; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getPname();
				} else if (j == 1) {
					data[i][j] = al.get(i).getPnumber();
				} else if (j == 2) {
					data[i][j] = al.get(i).getBigctg();
				} else if (j == 3) {
					data[i][j] = al.get(i).getSmallctg();
				} else if (j == 4) {
					data[i][j] = al.get(i).getCurrentprice();
				} else if (j == 5) {
					data[i][j] = al.get(i).getRstate();
				}
			}
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 403, 398, -278);
		// 패널 스크롤 추가

		 pnl_ProductList.add(scrollPane);

		JTable tbl_ProductList = new JTable(data, header);
		tbl_ProductList.setFillsViewportHeight(true);

		tbl_ProductList.addMouseListener(new MouseAdapter() {
		});
		// 테이블을 스크롤패널에 추가, 컬럼이름 보여주기 위해서 추가
		// scrollPane.setViewportView(tbl_ProductList);
		pnl_ProductList.setViewportView(tbl_ProductList);
		
		JButton button = new JButton("Main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_MainGUI ();
				frame.dispose();
			}
		});
		button.setBounds(999, 96, 155, 40);
		frame.getContentPane().add(button);

		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	
	
	
	
}
