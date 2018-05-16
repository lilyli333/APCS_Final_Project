package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;

public class AssignmentGui extends JPanel {
	
	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_5;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AssignmentGui() {
		setLayout(null);
		
		frame = new JFrame();
		frame.setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 650, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		//frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assignments");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(218, 6, 224, 39);
		frame.getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(16, 6, 617, 48);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 617, 235);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 0));
		panel_4.setBounds(0, 0, 617, 26);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Current Assignments");
		lblNewLabel_1.setBounds(0, 0, 617, 20);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		
		String[] columnNames =  {"Subjects",
                "Assignments",
                "Due Date"};
		Object[][] data = {{"Language Arts","Complete Essay","05/12/2018"},
				           {" Math","Complete workSheet Page 124-136","05/15/2018"},
				           {"Science","Chapter 2 test","05/14/2018"}
		};
		table = new JTable(data,columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(new Color(255, 255, 255));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(0, 0, 255));
		table.setBounds(0, 42, 617, 183);
		panel_1.add(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 325, 617, 187);
		contentPane.add(scrollPane_1);
		
		panel_2 = new JPanel();
		scrollPane_1.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 0));
		panel_5.setBounds(0, 0, 617, 31);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Future Assignments");
		lblNewLabel_2.setBounds(6, 6, 617, 19);
		panel_5.add(lblNewLabel_2);
		
		String[] columnNames1 =  {"Subjects",
                "Assignments",
                "Due Date"};
		Object[][] data1 = {{"Language Arts","Complete Essay","05/12/2018"},
				           {" Math","Complete workSheet Page 124-136","05/15/2018"},
				           {"Science","Chapter 2 test","05/14/2018"}
		};
		table_1 = new JTable(data1,columnNames1);
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBackground(new Color(0, 0, 255));
		table_1.setBounds(0, 58, 617, 129);
		panel_2.add(table_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(16, 524, 617, 22);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Add Assignments");
		lblNewLabel_3.setBounds(6, 0, 605, 28);
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(16, 524, 617, 149);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 24, 617, 125);
		panel_6.add(panel_3);
		panel_3.setBackground(new Color(0, 0, 255));
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 54, 191, 26);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(211, 54, 190, 26);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(411, 54, 200, 26);
		panel_3.add(textField_2);
		
		JLabel lblSubject = new JLabel("Enter Subject");
		lblSubject.setBounds(39, 92, 134, 29);
		panel_3.add(lblSubject);
		
		JLabel lblAssignment = new JLabel("Enter Assignment");
		lblAssignment.setBounds(234, 92, 134, 29);
		panel_3.add(lblAssignment);
		
		JLabel lblDueDate = new JLabel("Enter Due Date");
		lblDueDate.setBounds(447, 92, 134, 29);
		panel_3.add(lblDueDate);

	}
}
