package Gui;

/**
 * graphics for the user profile, where user edits their information
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class ProfileGui extends JPanel{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public ProfileGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Create Profile");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(160, 6, 205, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(38, 139, 84, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(38, 200, 84, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grade");
		lblNewLabel_3.setBounds(38, 262, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("School");
		lblNewLabel_4.setBounds(38, 326, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Current GPA");
		lblNewLabel_6.setBounds(38, 385, 84, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(160, 134, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 195, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 257, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 321, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 382, 130, 26);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Create Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				Statement stmt;
				try {
					
				    con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					System.out.println("Connection successful");
					stmt = con.createStatement();
				    String sql1 = "CREATE TABLE IF NOT EXISTS PROFILE"
				    		    + "(id INTEGER auto_increment,"
				    		    + "firstName VARCHAR(255),"
				    		    + "lastName VARCHAR(255),"
				    		    + "grade INTEGER,"
				    		    + "school VARCHAR(255)," 
				    		    + "subjects VARCHAR(255),"
				    		    + "GPA DECIMAL(20,2),"
				    		    +"primary key(id))";
					String sql2 = "INSERT INTO PROFILE(firstName,lastName,grade,school,subjects)"
							    + "values('Anushka','Saran',10,'Homestead','calculus')";
					String sql3 = "SELECT * FROM PROFILE ";
				    ResultSet rs = stmt.executeQuery(sql3);
				    while(rs.next()) {
				    	System.out.println(rs.getInt(1)+" "
				    			           +rs.getString(2) + " "
				    			           +rs.getString(3)+ " "
				    			           +rs.getInt(4)+ " "
				    			           +rs.getString(5)+ " "
				    			           +rs.getString(6));
				    	
				    }
				    //System.out.println("RECORD INSERTED"); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
				}
				
				
			}
		});
		btnNewButton.setBounds(160, 468, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(6, 6, 438, 29);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(323, 48, 108, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Image");
		lblNewLabel_5.setBounds(6, 5, 96, 89);
		panel_1.add(lblNewLabel_5);
	}
}
