package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_PopularProductViewGUI {
	private JFrame frame;
	showChart sc = new showChart();

	// DB
	ChartDAO Chartdao = new ChartDAO();
	ArrayList<chartVO> al = null;
	chartVO cvo = null;
	productionDAO pdao = new productionDAO();

	// CHART
	Chart c = new Chart();
	String[] head = null;
	String[] rank = null;
	int[] rankInt = null;
	int[] arcAngle = null;
	Color[] color = { new Color(253, 115, 0), new Color(255, 175, 0), new Color(255, 236, 0), new Color(213, 243, 11),
			new Color(45, 203, 117), new Color(127, 127, 127), new Color(166, 166, 166), new Color(191, 191, 191),
			new Color(217, 217, 217), new Color(242, 242, 242), };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_PopularProductViewGUI window = new Admin_PopularProductViewGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void drawChart() {
		arcAngle = new int[rankInt.length];
		for (int i = 0; i < rankInt.length; i++) {
			arcAngle[i] = (int) Math.round((double) rankInt[i] / (double) c.sum_arr(rankInt) * 360);
			sc.repaint(); // 차트패널의 PAINT호출
		}
	}

	/**
	 * Create the application.
	 */
	public Admin_PopularProductViewGUI() {
		al = Chartdao.rankSmallCTG();
		initialize();
		drawChart();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		// al 데이터 = 2차원 배열 (카시트 12 \t 보행기 35 \t 구조)
		head = new String[al.size()];
		rank = new String[al.size()];

		// 2칸 짜리 2차원 배열을 2개의 1차원 배열로 쪼갠다.
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					head[i] = al.get(i).getHead();
				} else if (j == 1) {
					rank[i] = al.get(i).getRank();
				}
			}
		}
		// rank가 String 타입이므로 int로 바꾼 후, head와 rankInt를 정렬해준다.
		rankInt = new int[al.size()];
		rankInt = c.StringToIntArray(rank);
		head = c.selectSort(rankInt, head);
		rankInt = c.selectSort(rankInt);

		// 이하 GUI
		JLabel lbl_BackHome = new JLabel(
				"\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0 - \uC778\uAE30\uD488\uBAA9 \uC2DC\uAC01\uD654");
		lbl_BackHome.setFont(new Font("굴림", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1172, 134);
		frame.getContentPane().add(lbl_BackHome);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 143, 1184, 1);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uCE74\uD14C\uACE0\uB9AC\uBCC4 \uCC28\uD2B8");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(42, 232, 265, 69);
		frame.getContentPane().add(lblNewLabel_2);

		JPanel pnl_CircleChart = new JPanel();
		pnl_CircleChart.setBounds(42, 290, 412, 264);
		frame.getContentPane().add(pnl_CircleChart);
		pnl_CircleChart.setLayout(null);

		JPanel pnl_ShowLegend = new JPanel();
		pnl_ShowLegend.setBackground(Color.BLACK);
		pnl_ShowLegend.setBounds(14, 10, 117, 244);
		pnl_CircleChart.add(pnl_ShowLegend);
		pnl_ShowLegend.setLayout(new GridLayout(0, 1, 0, 0));

		// 범례 라벨에 값 추가해주기
		JLabel[] headLbls = new JLabel[rank.length];
		for (int i = 0; i < rank.length; i++) {
			// 그리드 레이아웃으로 자동 정렬
			headLbls[i] = new JLabel();
			headLbls[i].setText(head[i] + " : " + rankInt[i] + "번");
			headLbls[i].setForeground(color[i]);
			pnl_ShowLegend.add(headLbls[i]);
		}

		CircleChart cirEX = new CircleChart(rankInt);
		
		cirEX.chartPanel.setBounds(-80, -25, 600, 600);
		JPanel pnl_ShowChart = new JPanel();
		pnl_ShowChart.setBounds(94, 10, 308, 244);
		pnl_CircleChart.add(pnl_ShowChart);
		pnl_ShowChart.add(cirEX.chartPanel);
		pnl_ShowChart.setLayout(null);

		JLabel label = new JLabel("\uAC1C\uBCC4 \uBB3C\uD488\uBCC4 \uCC28\uD2B8");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("굴림", Font.PLAIN, 24));
		label.setBounds(483, 232, 282, 69);
		frame.getContentPane().add(label);

		JPanel pnl_BarCahrt = new JPanel();
		pnl_BarCahrt.setBounds(483, 290, 655, 264);
		
		frame.getContentPane().add(pnl_BarCahrt);
		pnl_BarCahrt.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 236, 655, 18);
		pnl_BarCahrt.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton[] btnBars = new JButton[10];
		JLabel[] lbls = new JLabel[10];

		
		for (int i = 0; i < 10; i++) {

			int xlen =33;
			int ylen = 7;
			int gy = 223; // 패널의 높이(길이)
			int cnt = Integer.parseInt(pdao.all_desc().get(i).getRcount());
			btnBars[i] = new JButton();
			btnBars[i].setBounds(xlen * 2 * i, (gy - (cnt * ylen)), 25, cnt * ylen);
			pnl_BarCahrt.add(btnBars[i]);
			btnBars[i].setBackground(color[i]);

			btnBars[i].setEnabled(false);

			lbls[i] = new JLabel();
			lbls[i].setText(pdao.all_desc().get(i).getPname());
			panel.add(lbls[i]);
			lbls[i].setFont(new Font("굴림", Font.PLAIN, 12));

		}
		
		JButton btnNewButton = new JButton("Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Admin_MainGUI ();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(1005, 92, 155, 40);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public class showChart extends JPanel { // 차트 표시 패널
		public void ChartPanel(Graphics g) {
			super.paintComponent(g);// 부모 페인트 호출
			int startAngle = 90; // 90도가 12시 방향
			for (int i = 0; i < rankInt.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, -arcAngle[i]); // 앵글을 음수로 주면 시계방향
				startAngle -= arcAngle[i];// 음수로 주기위해 빼주어야 함.
			}
		}

	}
}
