package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import loginSystem.Dashboard;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textGrade;
	private JTextField textSchool;
	private JTextField textGPA;

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
		lblNewLabel_1.setBounds(38, 72, 84, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(38, 150, 84, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grade");
		lblNewLabel_3.setBounds(38, 225, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("School");
		lblNewLabel_4.setBounds(38, 302, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Current GPA");
		lblNewLabel_6.setBounds(38, 385, 84, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(160, 67, 130, 26);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(160, 145, 130, 26);
		frame.getContentPane().add(textLastName);
		
		textGrade = new JTextField();
		textGrade.setColumns(10);
		textGrade.setBounds(160, 220, 130, 26);
		frame.getContentPane().add(textGrade);
		
		textSchool = new JTextField();
		textSchool.setColumns(10);
		textSchool.setBounds(160, 297, 130, 26);
		frame.getContentPane().add(textSchool);
		
		textGPA = new JTextField();
		textGPA.setColumns(10);
		textGPA.setBounds(160, 382, 130, 26);
		frame.getContentPane().add(textGPA);
		
		JButton btnNewButton = new JButton("Create Profile");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt;
				String sql = "INSERT INTO PROFILE(firstName,lastName,grade,school)"
					    + " values(?,?,?,?)";
				try {
					
					con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					stmt.setString(1,textFirstName.getText());
					stmt.setString(2,textLastName.getText());
					stmt.setInt(3,Integer.parseInt((textGrade.getText())));
					stmt.setString(4,textSchool.getText());
					//stmt.setInt(5,Integer.parseInt((textGrade.getText())));
					stmt.executeUpdate();
					//stmt.close();
					//con.close();
					Statement st = null;
					st = con.createStatement();
					System.out.println("Data Entered in profile");
					String sql3 = "SELECT * FROM PROFILE ";
				    ResultSet rs = st.executeQuery(sql3);
				    while(rs.next()) {
				    	System.out.println(rs.getInt(1)+" "
				    			           +rs.getString(2) + " "
				    			           +rs.getString(3)+ " "
				    			           +rs.getInt(4)+ " "
				    			           +rs.getString(5));
				    			           
				    }	
				   // Dashboard.setLblGrade();
					//Dashboard.main(new String[] {userName.getText()});
				    stmt.close();
				    st.close();
					frame.dispose();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		btnNewButton.setBounds(160, 468, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(6, 6, 438, 29);
		frame.getContentPane().add(panel);
	}
}
