package BabyProductsRental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Product_DetailPageGUI {
	private JFrame frame;
	   productionDAO pdao = new productionDAO();
	   productionVO pvo;
	   ArrayList<productionVO> pal = null;
	   DAO dao = new DAO();
	   VO_S vo_S;
	   String choiceMonth = null;

	   /**
	    * Launch the application.
	    */
	//   public static void main(String[] args) {
//	      EventQueue.invokeLater(new Runnable() {
//	         public void run() {
//	            try {
//	               Product_DetailPageGUI window = new Product_DetailPageGUI();
//	               window.frame.setVisible(true);
//	            } catch (Exception e) {
//	               e.printStackTrace();
//	            }
//	         }
//	      });
	//   }

	   /**
	    * Create the application.
	    */

	   public Product_DetailPageGUI(VO_S vo_S, productionVO pvo) {
	      initialize(vo_S, pvo);
	      frame.setVisible(true);
	   }

	   /**
	    * Initialize the contents of the frame.
	    */
	   private void initialize(VO_S vo_S, productionVO pvo) {
	      frame = new JFrame();
	      frame.getContentPane().setBackground(Color.WHITE);
	      frame.setBounds(100, 100, 1200, 800);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);

	      JLabel lbl_BackHome = new JLabel("\uC81C\uD488 \uC0C1\uC138 \uD398\uC774\uC9C0");
	      lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
	      lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
	      lbl_BackHome.setBounds(0, 0, 1184, 163);
	      frame.getContentPane().add(lbl_BackHome);

	      JLabel lblNewLabel_4 = new JLabel("\uC608\uCE58\uAE08\uC561:");
	      lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
	      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_4.setBounds(50, 120, 91, 40);
	      frame.getContentPane().add(lblNewLabel_4);

	      JLabel lbl_MoneyPrint = new JLabel("\uC608\uCE58\uAE08\uC561 \uCD9C\uB825");
	      lbl_MoneyPrint.setFont(new Font("굴림", Font.PLAIN, 15));
	      lbl_MoneyPrint.setBounds(130, 130, 98, 21);
	      frame.getContentPane().add(lbl_MoneyPrint);
	      if (vo_S.getId() != null) {
	         // 일반 고객으로 로그인 했을 때
	         System.out.println(dao.loginMoney(vo_S.getId()));
	         lbl_MoneyPrint.setText(dao.loginMoney(vo_S.getId()));
	      } else if (vo_S.getId().equals("admin")) {
	         // admin으로 로그인 했을 때
	         lbl_MoneyPrint.setVisible(false);
	      } else {
	         // 로그인하지 않았을 때
	         lbl_MoneyPrint.setVisible(false);
	      }

	      JButton btn_MyPage = new JButton("My Page");
	      btn_MyPage.setFont(new Font("굴림", Font.PLAIN, 21));
	      btn_MyPage.setBounds(920, 100, 107, 40);
	      frame.getContentPane().add(btn_MyPage);

	      JButton btn_LogOut = new JButton("Logout");
	      btn_LogOut.setFont(new Font("굴림", Font.PLAIN, 21));
	      btn_LogOut.setBounds(1050, 100, 109, 40);
	      frame.getContentPane().add(btn_LogOut);

	      JLabel lblNewLabel_1 = new JLabel("");
	      lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	      lblNewLabel_1.setBounds(0, 160, 1184, 1);
	      frame.getContentPane().add(lblNewLabel_1);

	      JPanel pnl_PicturePrint = new JPanel();
	      pnl_PicturePrint.setBounds(90, 200, 400, 350);
	      frame.getContentPane().add(pnl_PicturePrint);
	      pnl_PicturePrint.setLayout(new BorderLayout(0, 0));
	      JLabel mainImage = new JLabel("");
	      pnl_PicturePrint.add(mainImage, BorderLayout.EAST);
	      // 사진 붙이는 패널

	      // --------------------잠시 사진 업로드가 있겠습니다... ^^-----------------------
	      ImageIcon img1 = new ImageIcon("img/babyCarriage.jpg");
	      Image c_img1 = img1.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img1 = new ImageIcon(c_img1);

	      ImageIcon img2 = new ImageIcon("img/babyStool.jpg");
	      Image c_img2 = img2.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img2 = new ImageIcon(c_img2);

	      ImageIcon img3 = new ImageIcon("img/bed.jpg");
	      Image c_img3 = img3.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img3 = new ImageIcon(c_img3);

	      ImageIcon img4 = new ImageIcon("img/carSeat.jpg");
	      Image c_img4 = img4.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img4 = new ImageIcon(c_img4);

	      ImageIcon img5 = new ImageIcon("img/jumperoo.jpg");
	      Image c_img5 = img5.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img5 = new ImageIcon(c_img5);

	      ImageIcon img6 = new ImageIcon("img/saucer.jpg");
	      Image c_img6 = img6.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img6 = new ImageIcon(c_img6);

	      ImageIcon img7 = new ImageIcon("img/step.jpg");
	      Image c_img7 = img7.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img7 = new ImageIcon(c_img7);

	      ImageIcon img8 = new ImageIcon("img/walker.jpg");
	      Image c_img8 = img8.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
	      ImageIcon c_ic_img8 = new ImageIcon(c_img8);
	      // --------------------잠시 사진 업로드가 있었습니다... ^^-----------------------

	      // ------------------------하드 코딩 미안합니다 ^^*---------------------------
	      switch (pvo.getSmallctg()) {
	      case "카시트":
	         mainImage.setIcon(c_ic_img4);
	         break;
	      case "보행기":
	         mainImage.setIcon(c_ic_img8);
	         break;
	      case "식탁의자":
	         mainImage.setIcon(c_ic_img2);
	         break;
	      case "유아용 침대":
	         mainImage.setIcon(c_ic_img3);
	         break;
	      case "유모차":
	         mainImage.setIcon(c_ic_img1);
	         break;
	      case "스텝":
	         mainImage.setIcon(c_ic_img7);
	         break;
	      case "소서":
	         mainImage.setIcon(c_ic_img6);
	         break;
	      case "점퍼루":
	         mainImage.setIcon(c_ic_img5);
	         break;

	      }

	      JLabel lbl_ProducName = new JLabel("\uBB3C\uD488\uBA85");
	      lbl_ProducName.setHorizontalAlignment(SwingConstants.LEFT);
	      lbl_ProducName.setFont(new Font("굴림", Font.PLAIN, 24));
	      lbl_ProducName.setBounds(602, 220, 181, 69);
	      frame.getContentPane().add(lbl_ProducName);

	      JLabel lbl_ProducNametPrint = new JLabel("\uBB3C\uD488\uBA85");
	      lbl_ProducNametPrint.setFont(new Font("굴림", Font.PLAIN, 24));
	      lbl_ProducNametPrint.setHorizontalAlignment(SwingConstants.LEFT);
	      lbl_ProducNametPrint.setBounds(821, 220, 265, 69);
	      frame.getContentPane().add(lbl_ProducNametPrint);
	      // 전달 받은 pvo의 이름을 내보낸다.
	      lbl_ProducNametPrint.setText(pvo.getPname());

	      JLabel lbl_RentPrice = new JLabel("\uC6D4 \uAE08\uC561");
	      lbl_RentPrice.setHorizontalAlignment(SwingConstants.LEFT);
	      lbl_RentPrice.setFont(new Font("굴림", Font.PLAIN, 24));
	      lbl_RentPrice.setBounds(602, 289, 181, 69);
	      frame.getContentPane().add(lbl_RentPrice);

	      JLabel lbl_RentPricePrint = new JLabel("\uC6D4 \uAE08\uC561");
	      lbl_RentPricePrint.setFont(new Font("굴림", Font.PLAIN, 24));
	      lbl_RentPricePrint.setHorizontalAlignment(SwingConstants.LEFT);
	      lbl_RentPricePrint.setBounds(821, 289, 265, 69);
	      frame.getContentPane().add(lbl_RentPricePrint);
	      // 전달 받은 pvo의 이름을 내보낸다.
	      lbl_RentPricePrint.setText(pvo.getMonthmoney());

	      JLabel label = new JLabel("\uB300\uC5EC \uAE30\uAC04 \uC120\uD0DD");
	      label.setHorizontalAlignment(SwingConstants.LEFT);
	      label.setFont(new Font("굴림", Font.PLAIN, 24));
	      label.setBounds(602, 361, 181, 69);
	      frame.getContentPane().add(label);

	      // 드롭다운
	      String[] choiceMonths = { "1", "2", "3" };
	      JComboBox cbx_ChoiceRentPeriod = new JComboBox(choiceMonths);
	      cbx_ChoiceRentPeriod.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            choiceMonth = cbx_ChoiceRentPeriod.getSelectedItem().toString();
	         }
	      });
	      cbx_ChoiceRentPeriod.setBounds(821, 380, 146, 31);
	      frame.getContentPane().add(cbx_ChoiceRentPeriod);
	      System.out.println(choiceMonth);

	      // 대여하기 버튼 누를 시!!
	      JButton btn_Rent = new JButton("\uB300\uC5EC\uD558\uAE30");
	      btn_Rent.setFont(new Font("굴림", Font.PLAIN, 24));
	      btn_Rent.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if (choiceMonth != null) {
	               new RentRequest_01GUI(vo_S, pvo, choiceMonth);
	               frame.dispose();
	            } else {
	               JOptionPane.showMessageDialog(null, "대여 기간을 선택해주세요");
	            }
	         }
	      });
	      btn_Rent.setBounds(602, 454, 484, 59);
	      frame.getContentPane().add(btn_Rent);

	      JPanel pnl_DetailList = new JPanel();

	      pnl_DetailList.setBounds(70, 577, 1040, 154);
	      frame.getContentPane().add(pnl_DetailList);
	      pnl_DetailList.setLayout(new BorderLayout(0, 0));

	      JLabel lbl_DetailListPrint = new JLabel("New label");
	      lbl_DetailListPrint.setHorizontalAlignment(SwingConstants.CENTER);
	      pnl_DetailList.add(lbl_DetailListPrint, BorderLayout.CENTER);
	      lbl_DetailListPrint.setText(pvo.getPdetail());
	      lbl_DetailListPrint.setFont(new Font("굴림", Font.PLAIN, 24));

	      JLabel label_1 = new JLabel("\uAC1C\uC6D4");
	      label_1.setHorizontalAlignment(SwingConstants.CENTER);
	      label_1.setFont(new Font("굴림", Font.PLAIN, 24));
	      label_1.setBounds(970, 361, 116, 69);
	      frame.getContentPane().add(label_1);
	   }

}
