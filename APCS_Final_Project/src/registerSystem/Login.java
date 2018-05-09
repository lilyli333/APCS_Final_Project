package registerSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import registerSystem.Register;
import registerSystem.SignIn;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Screen where you can enter in info to get started. THIS IS THE 
 * MAIN METHOD RUN THIS
 * @author kumawat ajay Youtube tutorial
 *
 */
public class Login {

	private JFrame frame;
	private JTextField studentName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(84, 99, 94, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(120, 20, 256, 47);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		studentName = new JTextField();
		studentName.setBounds(204, 101, 162, 28);
		frame.getContentPane().add(studentName);
		studentName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(84, 159, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 152, 162, 30);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con;
				Statement stmt;
try {
					
				    con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					System.out.println("Connection successful");
					stmt = con.createStatement();
					/* String sql1 = "CREATE TABLE IF NOT EXISTS VALIDATION"
				    		    + "(id INTEGER auto_increment,"
				    		    + "userName VARCHAR(255),"
				    		    + "password VARCHAR(255),)";
					String sql2 = "INSERT INTO VALIDATION(userName,password)"
							    + " values('Ashley','World')";
					String sql3 = "SELECT * FROM VALIDATION ";
				    ResultSet rs = stmt.executeQuery(sql3);
				    while(rs.next()) {
				    	System.out.println(rs.getInt(1)+" "
				    			           +rs.getString(2) + " "
				    			           +rs.getString(3));
				    	
				    }*/
				    String userName =  studentName.getText();
				    String password = passwordField.getText();
				    String sql3 = "SELECT * FROM VALIDATION ";
				    ResultSet rs = stmt.executeQuery(sql3);
				    while(rs.next()) {
				    	System.out.println(rs.getString(2)+ " "+rs.getString(3));
				    	if(rs.getString(2).equals(userName) && rs.getString(3).equals(password)) {
				    		
				    		Register.main(new String[] {userName});
				    		frame.dispose();
				            return;
				    	}
				    }
				    		JOptionPane.showConfirmDialog(null, "Wrong Username or Password");
				    	
				    
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
				}
				
			}
		});
		loginButton.setBounds(84, 217, 107, 29);
		frame.getContentPane().add(loginButton);
		
		JButton signInButton = new JButton("Register");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn.main(null);
				frame.dispose();
			}
		});
		signInButton.setBounds(247, 217, 101, 29);
		frame.getContentPane().add(signInButton);
	}
}
