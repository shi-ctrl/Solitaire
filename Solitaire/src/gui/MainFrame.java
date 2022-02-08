package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import javax.swing.Box;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					
             
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Solitaire");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 500);
		getContentPane().setLayout(new GridLayout(4, 3));
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 100, 100, 100, 100, 100, 100, 100, 0 };
		gbl_contentPane.rowHeights = new int[] { 39, 138, 267, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Toolbar to display time, moves and buttons for new game, vegas mode
		JToolBar toolBar = new JToolBar();
		toolBar.setMinimumSize(new Dimension(450, 2));
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setBackground(new Color(34, 139, 34));
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.fill = GridBagConstraints.BOTH;
		gbc_toolBar.gridwidth = 7;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);

		JLabel lblTimeLeftLabel = new JLabel("Time: ");
		toolBar.add(lblTimeLeftLabel);
		lblTimeLeftLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimeLeftLabel.setForeground(new Color(255, 255, 255));
		lblTimeLeftLabel.setAlignmentY(Component.TOP_ALIGNMENT);

		JLabel lblTimeLeft = new JLabel("00:00");
		lblTimeLeftLabel.setLabelFor(lblTimeLeft);
		toolBar.add(lblTimeLeft);
		lblTimeLeft.setForeground(new Color(255, 255, 255));
		lblTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimeLeft.setAlignmentY(Component.TOP_ALIGNMENT);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);

		JLabel lblMovesLabel = new JLabel("Moves: ");
		toolBar.add(lblMovesLabel);
		lblMovesLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMovesLabel.setForeground(new Color(255, 255, 255));
		lblMovesLabel.setAlignmentY(Component.TOP_ALIGNMENT);

		JLabel lblMoves = new JLabel("0");
		lblMovesLabel.setLabelFor(lblMoves);
		toolBar.add(lblMoves);
		lblMoves.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMoves.setForeground(new Color(255, 255, 255));
		lblMoves.setAlignmentY(Component.TOP_ALIGNMENT);

		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
		toolBar.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewGame.setAlignmentY(Component.TOP_ALIGNMENT);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);

		JButton btnVegasMode = new JButton("Vegas Mode");
		btnVegasMode.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVegasMode.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnVegasMode.setAlignmentY(Component.TOP_ALIGNMENT);
		toolBar.add(btnVegasMode);
		btnVegasMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// Stockpile component
		JPanel stockpile = new JPanel();
		stockpile.setBorder(new TitledBorder(null, "Stockpile", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		stockpile.setBackground(new Color(34, 139, 34));
		stockpile.setAlignmentY(Component.TOP_ALIGNMENT);
		stockpile.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc_stockpile = new GridBagConstraints();
		gbc_stockpile.fill = GridBagConstraints.BOTH;
		gbc_stockpile.anchor = GridBagConstraints.WEST;
		gbc_stockpile.insets = new Insets(0, 0, 5, 5);
		gbc_stockpile.gridx = 0;
		gbc_stockpile.gridy = 1;
		contentPane.add(stockpile, gbc_stockpile);
		stockpile.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblCardBack = new JLabel("");
		lblCardBack.setIcon(new ImageIcon(MainFrame.class.getResource("/images/generic-card-back.jpg")));
		stockpile.add(lblCardBack);
		JLayeredPane layeredPane = new JLayeredPane();
		stockpile.add(layeredPane);

		// Talon component
		JPanel talon = new JPanel();
		talon.setSize(new Dimension(50, 10));
		talon.setBorder(
				new TitledBorder(null, "Talon", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		talon.setBackground(new Color(34, 139, 34));
		talon.setAlignmentY(Component.TOP_ALIGNMENT);
		talon.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc_talon = new GridBagConstraints();
		gbc_talon.gridwidth = 2;
		gbc_talon.fill = GridBagConstraints.BOTH;
		gbc_talon.anchor = GridBagConstraints.WEST;
		gbc_talon.insets = new Insets(0, 0, 5, 5);
		gbc_talon.gridx = 1;
		gbc_talon.gridy = 1;
		contentPane.add(talon, gbc_talon);
		talon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLayeredPane layeredPane_Talon = new JLayeredPane();
		talon.add(layeredPane_Talon);
		JLabel lblCardDeal1 = new JLabel("test");
		lblCardDeal1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCardDeal1.setHorizontalAlignment(SwingConstants.LEFT);
		// lblCardDeal1.setBounds()
		JLabel lblCardDeal2 = new JLabel("test2");
		lblCardDeal2.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCardDeal2.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel lblCardDeal3 = new JLabel("test3");
		lblCardDeal3.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCardDeal3.setHorizontalAlignment(SwingConstants.LEFT);
		layeredPane_Talon.add(lblCardDeal1, 0);
		layeredPane_Talon.add(lblCardDeal2, 1);
		layeredPane_Talon.add(lblCardDeal3, 2);

		// Foundations component
		JPanel foundations = new JPanel();
		foundations.setBorder(new TitledBorder(null, "Foundations", TitledBorder.RIGHT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		foundations.setBackground(new Color(34, 139, 34));
		foundations.setAlignmentY(Component.TOP_ALIGNMENT);
		foundations.setAlignmentX(Component.LEFT_ALIGNMENT);
		foundations.setLayout(null);
		GridBagConstraints gbc_foundations = new GridBagConstraints();
		gbc_foundations.gridwidth = 4;
		gbc_foundations.fill = GridBagConstraints.BOTH;
		gbc_foundations.insets = new Insets(0, 0, 5, 5);
		gbc_foundations.anchor = GridBagConstraints.WEST;
		gbc_foundations.gridx = 3;
		gbc_foundations.gridy = 1;
		contentPane.add(foundations, gbc_foundations);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 21, 375, 101);
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		foundations.add(horizontalBox);

		JPanel suit1 = new JPanel();
		suit1.setSize(new Dimension(5, 10));
		suit1.setPreferredSize(new Dimension(5, 10));
		suit1.setAlignmentX(Component.LEFT_ALIGNMENT);
		suit1.setMinimumSize(new Dimension(5, 10));
		suit1.setBorder(new LineBorder(new Color(119, 136, 153)));
		suit1.setBackground(new Color(34, 139, 34));
		horizontalBox.add(suit1);

		Component horizontalStrut = Box.createHorizontalStrut(5);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		horizontalBox.add(horizontalStrut);

		JPanel suit2 = new JPanel();
		suit2.setBorder(new LineBorder(new Color(119, 136, 153)));
		suit2.setBackground(new Color(34, 139, 34));
		horizontalBox.add(suit2);

		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		horizontalStrut_3.setMinimumSize(new Dimension(10, 0));
		horizontalStrut_3.setPreferredSize(new Dimension(10, 0));
		horizontalBox.add(horizontalStrut_3);

		JPanel suit3 = new JPanel();
		suit3.setBorder(new LineBorder(new Color(119, 136, 153)));
		suit3.setBackground(new Color(34, 139, 34));
		horizontalBox.add(suit3);

		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		horizontalStrut_4.setPreferredSize(new Dimension(10, 0));
		horizontalBox.add(horizontalStrut_4);

		JPanel suit4 = new JPanel();
		suit4.setBorder(new LineBorder(new Color(119, 136, 153)));
		suit4.setBackground(new Color(34, 139, 34));
		horizontalBox.add(suit4);

		// Tableau component
		JPanel tableau = new JPanel();
		tableau.setForeground(new Color(255, 255, 255));
		tableau.setBorder(new TitledBorder(null, "Tableau", TitledBorder.RIGHT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		tableau.setBackground(new Color(34, 139, 34));
		tableau.setLayout(null);
		GridBagConstraints gbc_tableau = new GridBagConstraints();
		gbc_tableau.insets = new Insets(0, 0, 5, 5);
		gbc_tableau.gridwidth = 7;
		gbc_tableau.fill = GridBagConstraints.BOTH;
		gbc_tableau.gridx = 0;
		gbc_tableau.gridy = 2;
		contentPane.add(tableau, gbc_tableau);

		Box horizontalBox_Tableau = Box.createHorizontalBox();
		horizontalBox_Tableau.setBounds(10, 21, 678, 218);

		horizontalBox_Tableau.setAlignmentX(Component.LEFT_ALIGNMENT);
		tableau.add(horizontalBox_Tableau);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		panel_1.setPreferredSize(new Dimension(5, 10));
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_Tableau.add(panel_1);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		panel_1.add(layeredPane_1);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_2);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		panel_2.add(layeredPane_2);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_6);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_3);

		JLayeredPane layeredPane_3 = new JLayeredPane();
		panel_3.add(layeredPane_3);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_7);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_4);

		JLayeredPane layeredPane_4 = new JLayeredPane();
		panel_4.add(layeredPane_4);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_8);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_5);

		JLayeredPane layeredPane_5 = new JLayeredPane();
		panel_5.add(layeredPane_5);

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalStrut_9.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_9);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_6);

		JLayeredPane layeredPane_6 = new JLayeredPane();
		panel_6.add(layeredPane_6);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		horizontalStrut_10.setPreferredSize(new Dimension(10, 0));
		horizontalBox_Tableau.add(horizontalStrut_10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(34, 139, 34));
		horizontalBox_Tableau.add(panel_7);

		JLayeredPane layeredPane_7 = new JLayeredPane();
		panel_7.add(layeredPane_7);

		// Event Listener
		lblCardBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCardDeal1.setText("card1");
				lblCardDeal2.setText("card2");
				lblCardDeal3.setText("card3");
				// lblCardDeal.setIcon(new
				// ImageIcon(MainFrame.class.getResource("/images/hearts_king.png")));
			}
		});

	}
}
