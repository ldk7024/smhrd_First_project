package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_RentCurrentSearchGUI {
	private JFrame frame;
	private JTable tbl_RentCurrentList;
	DAO dao = new DAO();
	ArrayList<VO> al = dao.select_R();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_RentCurrentSearchGUI window = new Admin_RentCurrentSearchGUI();
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
	public Admin_RentCurrentSearchGUI() {
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
		
		JLabel lbl_BachHome = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0 - \uB300\uC5EC \uD604\uD669 \uC870\uD68C");
		lbl_BachHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BachHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BachHome.setBounds(0, 10, 1172, 178);
		frame.getContentPane().add(lbl_BachHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 187, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane pnl_RentCurrentList = new JScrollPane();
		pnl_RentCurrentList.setBounds(33, 217, 1103, 330);
		frame.getContentPane().add(pnl_RentCurrentList);
		
//		tbl_RentCurrentList = new JTable();
		String[][] data = new String[al.size()][7];
		String[] header = { "고객명", "물품명", "대여일", "반납예정일", "연체여부", "총결제금액","예상반환금액" };
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j <= 6; j++) {
				if (j == 0) {
					data[i][j] = al.get(i).getId();
				} else if (j == 1) {
					data[i][j] = al.get(i).getPnumber();
				} else if (j == 2) {
					data[i][j] = al.get(i).getRstart();
				} else if (j == 3) {
					data[i][j] = al.get(i).getRfinish();
				} else if (j == 4) {
					data[i][j] = al.get(i).getLatepayment();
				} else if (j == 5) {
					data[i][j] = al.get(i).getTpmoney();
				}else if (j == 6) {
					data[i][j] = al.get(i).getEpayback();
				}
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 403, 398, -278);
		//패널 스크롤 추가
		
		//pnl_ProductList.add(scrollPane);
			
		JTable tbl_RentCurrentList = new JTable(data,header);
		tbl_RentCurrentList.setFillsViewportHeight(true);

		tbl_RentCurrentList.addMouseListener(new MouseAdapter() {
			});
		pnl_RentCurrentList.setViewportView(tbl_RentCurrentList);
		
		JButton button = new JButton("Main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_MainGUI ();
				frame.dispose();
			}
		});
		button.setBounds(995, 137, 155, 40);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
