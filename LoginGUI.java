package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LoginGUI {
	private JFrame frame;
	private JPasswordField tfd_PWInput;
	private JButton btn_Login;
	private JTextField tfd_IDInput;
	DAO_C dao_C = null;
	VO_S VO_S;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("굴림", Font.BOLD, 40));
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uB85C\uADF8\uC778");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(12, 10, 1172, 125);
		frame.getContentPane().add(lbl_BackHome);

		btn_Login = new JButton("\uB85C\uADF8\uC778");
		btn_Login.addMouseListener(new MouseAdapter() {
		});
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 텍스트필드에 입력한 id와 pw의 값을 변수에 저장
				String id = tfd_IDInput.getText();
				String pw = tfd_PWInput.getText();
				
				
				if( id.equals("admin") && pw.equals("1234") ) {
					new Admin_MainGUI();
					frame.dispose();
				}
				
				// 만약 입력을 하지 않았으면 else문의 문장 출력
				else if (!id.equals("") && !pw.equals("")) {
					// loginselect메서드를 사용하여 DB에서 id와 pw의 데이터를 가져옴.
					dao_C = new DAO_C();
					VO_S = dao_C.loginselect(id, pw);

					// DB의 정보와 사용자가 입력한 텍스트 값이 일치하면 로그인 성공
					if (VO_S != null) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
						new AfterLogin_MainGUI( VO_S );
						frame.dispose();
					}
					// 그렇지 않으면 로그인 실패
					else {
						JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력하시오", "로그인", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		tfd_IDInput = new JTextField();
		tfd_IDInput.setBounds(419, 227, 373, 38);
		frame.getContentPane().add(tfd_IDInput);
		tfd_IDInput.setColumns(10);

		tfd_PWInput = new JPasswordField();
		tfd_PWInput.setBounds(419, 320, 372, 38);
		frame.getContentPane().add(tfd_PWInput);
		btn_Login.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_Login.setBounds(457, 408, 334, 79);
		frame.getContentPane().add(btn_Login);

		JButton btn_Create = new JButton("\uD68C\uC6D0 \uAC00\uC785");
		btn_Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGUI();
				frame.dispose();
			}
		});
		btn_Create.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_Create.setBounds(457, 523, 334, 79);
		frame.getContentPane().add(btn_Create);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(380, 188, -29, -5);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PW:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_3.setBounds(261, 298, 130, 85);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 134, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(251, 193, 139, 102);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
