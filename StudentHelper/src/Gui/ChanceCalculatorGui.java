package Gui;

import javax.swing.JPanel;
import college.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChanceCalculatorGui extends JPanel{
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtMath;
	private JTextField txtReading;
	private JTextField txtCollege;

	private int totalTestScore = 0;


	/**
	 * Create the panel.
	 */
	public ChanceCalculatorGui() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);

		setBackground(new Color(240, 255, 255));
		setLayout(null);

		JPanel chancesCalculatorPanel = new JPanel();
		chancesCalculatorPanel.setBackground(new Color(255, 255, 255));
		chancesCalculatorPanel.setBounds(6, 6, 959, 59);
		contentPane.add(chancesCalculatorPanel);
		chancesCalculatorPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("COLLEGE SEARCH");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Copperplate", Font.PLAIN, 41));
		lblNewLabel.setBounds(21, 6, 443, 47);
		chancesCalculatorPanel.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(16, 77, 288, 164);
		contentPane.add(tabbedPane);
		JPanel ACTPane = new JPanel();

		JButton btnSat = new JButton("SAT");

		JButton btnAct = new JButton("ACT");
		tabbedPane.addTab("ACT", null, ACTPane, null);

		JPanel SATPane = new JPanel();
		tabbedPane.addTab("SAT", null, SATPane, null);

		JLabel lblMathScore = new JLabel("Math Score:");
		JLabel lblCriticalReadingLabel = new JLabel("Critical Reading Label:");

		SATPane.add(lblMathScore);

		txtMath = new JTextField();
		txtMath.setText("0");
		SATPane.add(txtMath);
		txtMath.setColumns(10);
		SATPane.add(lblCriticalReadingLabel);

		txtReading = new JTextField();
		txtReading.setText("0");
		SATPane.add(txtReading);
		txtReading.setColumns(10);
		try  
		{  
			totalTestScore = Integer.parseInt(txtReading.getText()) + Integer.parseInt(txtMath.getText());
		}  
		catch(NumberFormatException e)  
		{  
		}  


		JLabel lblTotal = new JLabel("Total Score: " + totalTestScore);
		SATPane.add(lblTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(316, 77, 317, 584);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 253, 278, 408);
		contentPane.add(panel_2);

		JLabel lblSearchColleges = new JLabel("Search Colleges:");
		panel_2.add(lblSearchColleges);

		JLabel lblEnterCollegeName = new JLabel("Enter College Name");
		panel_2.add(lblEnterCollegeName);

		txtCollege = new JTextField();
		txtCollege.setText("college");
		panel_2.add(txtCollege);
		txtCollege.setColumns(10);

		JButton btnSearch = new JButton("Search");
		panel_2.add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button pressed");
				SearchFunction newSearch;
				if(tabbedPane.getSelectedIndex() == 1) {
					newSearch = new SearchFunction(txtCollege.getText(), (double)totalTestScore, true);
				}
				else {
					newSearch = new SearchFunction(txtCollege.getText(), (double)totalTestScore, false);
				}				
			}


		});

	}

}
