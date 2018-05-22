package loginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JPanel{

	private JFrame frame;
	private JTextField userName;
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel userLabel = new JLabel("Enter Username");
		userLabel.setBounds(55, 114, 121, 16);
		frame.getContentPane().add(userLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password");
		passwordLabel.setBounds(55, 169, 121, 16);
		frame.getContentPane().add(passwordLabel);
		
		JLabel lblReEnterPassword = new JLabel("Re enter Password");
		lblReEnterPassword.setBounds(55, 233, 121, 16);
		frame.getContentPane().add(lblReEnterPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt;
				String sql = "INSERT INTO USER_VALIDATION(userName,password,name,email)"
					    + " values(?,?,?,?)";
				try {
					
					con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					stmt.setString(1,userName.getText());
					stmt.setString(2,passwordField.getText());
					stmt.setString(3,nameField.getText() );
					stmt.setString(4,emailField.getText() );
					stmt.executeUpdate();
					stmt.close();
					//con.close();
					//Dashboard.main(new String[] {userName.getText()});
					Dashboard window = new Dashboard(nameField.getText());
		    		
			    	   
		    	    frame.add(window);
					frame.dispose();
					System.out.println("Data Entered into validation");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(167, 467, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Your Name");
		lblNewLabel_1.setBounds(55, 292, 112, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("E_mail");
		lblEmail.setBounds(55, 358, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		userName = new JTextField();
		userName.setBounds(203, 109, 130, 26);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(203, 287, 130, 26);
		frame.getContentPane().add(nameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(203, 353, 130, 26);
		frame.getContentPane().add(emailField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 438, 40);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Registration");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 166, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(203, 228, 130, 21);
		frame.getContentPane().add(passwordField_1);
	}
}