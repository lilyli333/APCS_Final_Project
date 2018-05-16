package loginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class Login extends JPanel {

	private JFrame frame;
	private JTextField studentName;
	private boolean tableCreated = false;
    private static Connection con;
    private String url = "jdbc:h2:"+"./Database/my"; 
    private JPasswordField passwordField;
    private String userName,password;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		try {
			con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
	    } catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Connection successful");
		
		if(!tableCreated && con !=null)
			createTable(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 132, 94, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(114, 73, 256, 47);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		studentName = new JTextField();
		studentName.setBounds(208, 133, 162, 28);
		frame.getContentPane().add(studentName);
		studentName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(89, 203, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    
				    printInfoFromTable(con);
					
				    userName =  studentName.getText();
				    password = passwordField.getText();
				    System.out.println("Entered value "+userName +" "+password);
				    if(userName.equals("") && password.equals(""))
			    		JOptionPane.showConfirmDialog(null, "Enter Username and Password");
				    else if(!userName.equals(null) && !password.equals(null))
				       validateUser(con, userName,password);
				    else
				    	JOptionPane.showMessageDialog(null, "Enter Correct Info");
				    
			}
		});
		
		loginButton.setBounds(84, 255, 107, 29);
		frame.getContentPane().add(loginButton);
		
		JButton signInButton = new JButton("Register");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn window = new SignIn();
				frame.dispose();
				frame.add(window);
			}
		});
		signInButton.setBounds(247, 255, 101, 29);
		frame.getContentPane().add(signInButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 196, 162, 30);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 6, 374, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(51, 55, 382, 16);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(51, 313, 382, 16);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Apple Chancery", Font.BOLD, 30));
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setIcon(new ImageIcon("/Users/speedy/Downloads/backgrounds-of-books.jpg"));
		lblNewLabel_3.setBounds(0, 42, 1244, 570);
		frame.getContentPane().add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(0, 0, 1000, 82);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("High School-Decoded");
		lblNewLabel_4.setFont(new Font("Apple Chancery", Font.BOLD, 30));
		lblNewLabel_4.setForeground(Color.RED);
		panel.add(lblNewLabel_4);
		

	}
			
	private void createTable(Connection con) {
		Statement stmt;
		String sql = "CREATE TABLE IF NOT EXISTS VALIDATION"
    		    + "(id INTEGER auto_increment,"
    		    + "userName VARCHAR(255),"
    		    + "password VARCHAR(255),)";
		try {
			stmt = con.createStatement();
		    stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Table created");
		tableCreated = true;
	
	}
	
	public void addInfo(Connection con,String user,String pass) {
		Statement stmt;
		String sql = "INSERT INTO VALIDATION(userName,password)"
			    + " values(user,pass)";
		try {
			stmt = con.createStatement();
		    stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Info entered");
		
	}
	
	private void printInfoFromTable(Connection con) {
		Statement stmt ;
		String sql = "SELECT * FROM VALIDATION ";
	    try {
	    	stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	   
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "
						           +rs.getString(2) + " "
						           +rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void validateUser(Connection con,String userName,String password) {
		
		String sql3 = "SELECT * FROM VALIDATION ";
		Statement stmt;
		try {
		stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql3);
	    while(rs.next()) {
	    	System.out.println(rs.getString(2)+ " "+rs.getString(3));
	    	
	    	if(rs.getString(2).equals(userName) && rs.getString(3).equals(password)) {
	    		
	    		Dashboard window = new Dashboard(userName);
	    		
	    	    frame.dispose();
	    	    frame.add(window);
	            return;
	    	}
	    }
	    		JOptionPane.showConfirmDialog(null, "Wrong Username or Password");
	    	
	    
	    
	} catch (SQLException e1) {
		e1.printStackTrace();
	}finally {
	}
	}
}
