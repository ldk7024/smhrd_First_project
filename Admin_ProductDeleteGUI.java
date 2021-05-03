package BabyProductsRental;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Admin_ProductDeleteGUI {
	private JFrame frame;
	private JTextField tf_id;
	DAO dao = new DAO();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Admin_ProductDeleteGUI() {
		initialize();
		frame.setVisible(true);//현재 창을 보여줄때
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 297, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("DELETE");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Consolas", Font.BOLD, 25));
		lblLogin.setBounds(89, 26, 97, 33);
		frame.getContentPane().add(lblLogin);
		
		
		
		JLabel lbl_id = new JLabel("\uC0AD\uC81C \uD560 \uBB3C\uD488\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694 ");
		lbl_id.setBounds(59, 69, 210, 33);
		frame.getContentPane().add(lbl_id);
		
		tf_id = new JTextField();
		tf_id.setBounds(82, 112, 116, 21);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		JButton btn_login = new JButton("complete");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cnt = dao.delete_P(tf_id.getText());
				new Admin_ProductSearchGUI();
				//현재창 사라지게
				frame.dispose();
			}
		});
		btn_login.setBounds(89, 169, 97, 23);
		frame.getContentPane().add(btn_login);
	}

}
