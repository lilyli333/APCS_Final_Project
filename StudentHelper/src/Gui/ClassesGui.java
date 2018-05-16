package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class ClassesGui extends JPanel {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Create the frame.
	 */
	public ClassesGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(6, 6, 638, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClassesGui.class.getResource("/Resource/ps_classes.jpg")));
		lblNewLabel.setBounds(6, 6, 54, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your classes Here");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel_1.setBounds(169, 16, 366, 31);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 83, 638, 596);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("English");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(55, 42, 101, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblMathematics = new JLabel("Mathematics");
		lblMathematics.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMathematics.setBounds(55, 107, 121, 29);
		panel_1.add(lblMathematics);
		
		JLabel lblScience = new JLabel("Science");
		lblScience.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblScience.setBounds(55, 177, 101, 29);
		panel_1.add(lblScience);
		
		JLabel lblSocialScience = new JLabel("Social Science");
		lblSocialScience.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSocialScience.setBounds(55, 241, 121, 29);
		panel_1.add(lblSocialScience);
		
		JLabel lblPhysicalEducation = new JLabel("Physical Education");
		lblPhysicalEducation.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPhysicalEducation.setBounds(55, 319, 175, 29);
		panel_1.add(lblPhysicalEducation);
		
		JLabel lblFineArts = new JLabel("Fine Arts");
		lblFineArts.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblFineArts.setBounds(55, 386, 101, 29);
		panel_1.add(lblFineArts);
		
		JLabel lblAppliedArts = new JLabel("Applied Arts");
		lblAppliedArts.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAppliedArts.setBounds(55, 452, 144, 29);
		panel_1.add(lblAppliedArts);
		
		textField = new JTextField();
		textField.setBounds(270, 110, 130, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 180, 130, 26);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 244, 130, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(270, 322, 130, 26);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(270, 389, 130, 26);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(270, 455, 130, 26);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(270, 45, 130, 26);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_3 = new JLabel("Subjects");
		lblNewLabel_3.setBounds(307, 17, 101, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblGrades = new JLabel("Grades");
		lblGrades.setBounds(487, 17, 101, 16);
		panel_1.add(lblGrades);
		
		textField_7 = new JTextField();
		textField_7.setBounds(467, 45, 87, 26);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(467, 110, 87, 26);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(467, 180, 87, 26);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(467, 244, 87, 26);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(467, 322, 87, 26);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(467, 389, 87, 26);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(467, 455, 87, 26);
		panel_1.add(textField_13);
		
		JLabel lblOtherElective = new JLabel("Other Elective");
		lblOtherElective.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblOtherElective.setBounds(55, 524, 144, 29);
		panel_1.add(lblOtherElective);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(270, 527, 130, 26);
		panel_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(467, 527, 87, 26);
		panel_1.add(textField_15);
	}
}
