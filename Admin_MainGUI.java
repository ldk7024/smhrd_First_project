package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Admin_MainGUI {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_MainGUI window = new Admin_MainGUI();
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
	public Admin_MainGUI() {
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
		
		JLabel lbl_BackHome = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0");
		lbl_BackHome.setFont(new Font("±¼¸²", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1184, 129);
		frame.getContentPane().add(lbl_BackHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 149, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_ProductSearch = new JButton("\uBB3C\uD488\uC870\uD68C");
		btn_ProductSearch.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_ProductSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_ProductSearchGUI();
				frame.dispose();
			}
		});
		btn_ProductSearch.setBounds(101, 222, 356, 140);
		frame.getContentPane().add(btn_ProductSearch);
		
		JButton btn_PopularView = new JButton("\uC778\uAE30\uD488\uBAA9 \uC2DC\uAC01\uD654");
		btn_PopularView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Admin_PopularProductViewGUI();
				frame.dispose();
			}
		});
		btn_PopularView.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_PopularView.setBounds(738, 222, 356, 140);
		frame.getContentPane().add(btn_PopularView);
		
		JButton btn_RentSearch = new JButton("\uB300\uC5EC \uD604\uD669 \uC870\uD68C");
		btn_RentSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_RentCurrentSearchGUI();
				frame.dispose();
			}
		});
		btn_RentSearch.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_RentSearch.setBounds(101, 554, 356, 140);
		frame.getContentPane().add(btn_RentSearch);
		
		JButton btn_ReturnTCheck = new JButton("\uBC18\uB0A9\uD488 \uAC80\uC218");
		btn_ReturnTCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_ReturnInspectionGUI();
				frame.dispose();
			}
		});
		btn_ReturnTCheck.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		btn_ReturnTCheck.setBounds(738, 554, 356, 140);
		frame.getContentPane().add(btn_ReturnTCheck);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
