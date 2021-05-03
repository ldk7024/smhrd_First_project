package BabyProductsRental;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;



public class Admin_ProductInsertGUI {
	private JFrame frame;
	private JTextField tf_id;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	DAO dao = new DAO();
	public Admin_ProductInsertGUI() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 795);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ProductEnrollment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 25));
		lblNewLabel.setBounds(195, 26, 332, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_ID = new JLabel("\uBB3C\uD488\uBC88\uD638(\uD544\uC218): ");
		lbl_ID.setBounds(51, 65, 97, 49);
		frame.getContentPane().add(lbl_ID);
		
		tf_id = new JTextField("");
		tf_id.setBounds(157, 73, 440, 33);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		ButtonGroup gender = new ButtonGroup();
		
		JButton btn_join = new JButton("Complete");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.insert_P(tf_id.getText(), textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText(),textField_8.getText());
				new Admin_ProductSearchGUI();
				//현재창 사라지게
				frame.dispose();
			}
		});  
		btn_join.setBounds(301, 699, 97, 23);
		frame.getContentPane().add(btn_join);
		
		JLabel label = new JLabel("\uBB43\uD488\uBA85(\uD544\uC218):");
		label.setBounds(51, 124, 97, 49);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(157, 132, 440, 33);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("\uBB3C\uD488\uC6D0\uAC00(\uD544\uC218):");
		label_1.setBounds(51, 183, 97, 49);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 191, 440, 33);
		frame.getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("\uC6D4\uAE08\uC561(\uD544\uC218): ");
		label_2.setBounds(51, 242, 97, 49);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 250, 440, 33);
		frame.getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("\uC0C1\uC138\uC815\uBCF4:");
		label_3.setBounds(51, 301, 97, 49);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 309, 440, 33);
		frame.getContentPane().add(textField_3);
		
		JLabel label_4 = new JLabel("\uB300\uBD84\uB958(\uD544\uC218):");
		label_4.setBounds(51, 360, 97, 49);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(157, 368, 440, 33);
		frame.getContentPane().add(textField_4);
		
		JLabel label_5 = new JLabel("\uC18C\uBD84\uB958(\uD544\uC218):");
		label_5.setBounds(51, 419, 97, 49);
		frame.getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(157, 427, 440, 33);
		frame.getContentPane().add(textField_5);
		
		JLabel label_6 = new JLabel("\uB300\uC5EC\uD69F\uC218:");
		label_6.setBounds(51, 478, 97, 49);
		frame.getContentPane().add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(157, 486, 440, 33);
		frame.getContentPane().add(textField_6);
		
		JLabel label_7 = new JLabel("\uB300\uC5EC\uC0C1\uD0DC:");
		label_7.setBounds(51, 537, 97, 49);
		frame.getContentPane().add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(157, 545, 440, 33);
		frame.getContentPane().add(textField_7);
		
		JLabel label_8 = new JLabel("\uACE0\uAC1D\uBA85: ");
		label_8.setBounds(51, 593, 97, 49);
		frame.getContentPane().add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(157, 601, 440, 33);
		frame.getContentPane().add(textField_8);
	}
}
