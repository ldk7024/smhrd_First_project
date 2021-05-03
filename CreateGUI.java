package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CreateGUI {
	private JFrame frame;
	private JTextField tfd_IDInput;
	private JPasswordField tfd_PWInput;
	private JPasswordField tfd_ConfirmPWInput;
	private JTextField tfd_NameInput;
	private JTextField tfd_PhoneNumberInput;
	private JTextField tfd_AddressInput;
	private JTextField tfd_BankAccountInput;

	DAO_C dao_C = null;
	VO_C vo_C = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI window = new CreateGUI();
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
	public CreateGUI() {
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

		JLabel lbl_BackHome = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1184, 87);
		frame.getContentPane().add(lbl_BackHome);

		tfd_IDInput = new JTextField();
		tfd_IDInput.setBounds(228, 180, 777, 24);
		frame.getContentPane().add(tfd_IDInput);
		tfd_IDInput.setColumns(10);

		tfd_PWInput = new JPasswordField();
		tfd_PWInput.setBounds(228, 220, 777, 24);
		frame.getContentPane().add(tfd_PWInput);

		tfd_ConfirmPWInput = new JPasswordField();
		tfd_ConfirmPWInput.setBounds(228, 260, 777, 24);
		frame.getContentPane().add(tfd_ConfirmPWInput);

		tfd_NameInput = new JTextField();
		tfd_NameInput.setBounds(228, 300, 777, 24);
		frame.getContentPane().add(tfd_NameInput);
		tfd_NameInput.setColumns(10);

		tfd_PhoneNumberInput = new JTextField();
		tfd_PhoneNumberInput.setBounds(228, 340, 777, 24);
		frame.getContentPane().add(tfd_PhoneNumberInput);
		tfd_PhoneNumberInput.setColumns(10);

		tfd_AddressInput = new JTextField();
		tfd_AddressInput.setBounds(228, 380, 777, 24);
		frame.getContentPane().add(tfd_AddressInput);
		tfd_AddressInput.setColumns(10);

		tfd_BankAccountInput = new JTextField();
		tfd_BankAccountInput.setBounds(228, 420, 777, 24);
		frame.getContentPane().add(tfd_BankAccountInput);
		tfd_BankAccountInput.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(120, 180, 96, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblPw = new JLabel("PW:");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("굴림", Font.PLAIN, 24));
		lblPw.setBounds(50, 220, 168, 29);
		frame.getContentPane().add(lblPw);

		JLabel lblNewLabel02 = new JLabel("Confirm Password:");
		lblNewLabel02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel02.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel02.setBounds(0, 256, 216, 29);
		frame.getContentPane().add(lblNewLabel02);

		JLabel lbl_NameInput = new JLabel("Name:");
		lbl_NameInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_NameInput.setFont(new Font("굴림", Font.PLAIN, 24));
		lbl_NameInput.setBounds(92, 295, 124, 35);
		frame.getContentPane().add(lbl_NameInput);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 24));
		lblAddress.setBounds(37, 380, 179, 35);
		frame.getContentPane().add(lblAddress);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("굴림", Font.PLAIN, 24));
		lblPhoneNumber.setBounds(44, 341, 172, 29);
		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblBankAccont = new JLabel("Bank accont:");
		lblBankAccont.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBankAccont.setFont(new Font("굴림", Font.PLAIN, 24));
		lblBankAccont.setBounds(38, 420, 178, 24);
		frame.getContentPane().add(lblBankAccont);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(0, 106, 1184, 1);
		frame.getContentPane().add(lblNewLabel_2);

		JCheckBox cbx_PrivateInfoAgree = new JCheckBox("\uAC1C\uC778\uC815\uBCF4 \uD65C\uC6A9 \uB3D9\uC758");
		cbx_PrivateInfoAgree.setFont(new Font("굴림", Font.PLAIN, 30));
		cbx_PrivateInfoAgree.setBackground(Color.WHITE);
		cbx_PrivateInfoAgree.setBounds(183, 461, 331, 72);
		frame.getContentPane().add(cbx_PrivateInfoAgree);

		// 회원가입 버튼
		JButton btn_SignUp = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 회원가입에 필요한 정보를 입력받으면 텍스트 필드의 문자를 가져와서 변수에 저장.
				String id = tfd_IDInput.getText();
				String pw = tfd_PWInput.getText();
				String confirmpassword = tfd_ConfirmPWInput.getText();
				String name = tfd_NameInput.getText();
				String phonenumber = tfd_PhoneNumberInput.getText();
				String address = tfd_AddressInput.getText();
				String bankaccount = tfd_BankAccountInput.getText();
				// 신규 회원가입시 예치금을 충전하지 않는 상태이므로 money를 0으로 설정.
				int money = 0;

				// 만약 텍스트 필드에 빈공간이 있으면
				if (!id.equals("") && !pw.equals("") && !confirmpassword.equals("") && !name.equals("")
						&& !phonenumber.equals("") && !address.equals("") && !bankaccount.equals("")) {
					// 만약 패스워드와 패스워드 확인의 값이 같으면
					if (pw.equals(confirmpassword)) {
						// 만약 개인정보 활용 동의 체크박스가 체크되어있으면
						if (cbx_PrivateInfoAgree.isSelected()) {
							// insert_Create메서드를 이용해서 DB에 새로운 고객 데이터를 입력 및 저장.
							dao_C = new DAO_C();
							int cnt = dao_C.insert_Create(id, pw, name, phonenumber, address, bankaccount, money);
							// 입력 받은 값이 정상적으로 들어가면 cnt의 값이 증가한다.
							// 만약 cnt의 값이 양수면 => 값이 정상정으로 입력되었다는 의미.
							if (cnt > 0) {
								// 알림창 출력 후 LoginGUI창 실행
								JOptionPane.showMessageDialog(null, "회원가입이 되었습니다.");
								new LoginGUI();
								frame.dispose();
							} else {
								JOptionPane.showMessageDialog(null, id+ " 회원가입이 되었습니다", "회원가입", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "개인정보 활용 동의를 체크해주세요", "회원가입", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "패스워드를 맞춰주세요", "회원가입", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력하시오", "회원가입", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_SignUp.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_SignUp.setForeground(Color.BLACK);
		btn_SignUp.setBackground(new Color(255, 255, 255));
		btn_SignUp.setBounds(466, 539, 347, 122);
		frame.getContentPane().add(btn_SignUp);

	}
}
