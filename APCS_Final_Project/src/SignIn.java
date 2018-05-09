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

public class SignIn {

	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * @wbp.nonvisual location=-20,41
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel userLabel = new JLabel("Enter Username");
		userLabel.setBounds(55, 114, 121, 16);
		frame.getContentPane().add(userLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password");
		passwordLabel.setBounds(55, 182, 121, 16);
		frame.getContentPane().add(passwordLabel);
		
		JLabel lblReEnterPassword = new JLabel("Re enter Password");
		lblReEnterPassword.setBounds(55, 233, 121, 16);
		frame.getContentPane().add(lblReEnterPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt;
				String sql = "INSERT INTO VALIDATION(userName,password)"
					    + " values(?,?)";
				try {
					
					con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					stmt.setString(1,userName.getText());
					stmt.setString(2,password.getText());
					stmt.executeUpdate();
					stmt.close();
					Register.main(new String[] {userName.getText()});
					frame.dispose();
					System.out.println("Data Entered");
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
		
		password = new JTextField();
		password.setBounds(203, 177, 130, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 228, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(203, 287, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(203, 353, 130, 26);
		frame.getContentPane().add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 438, 40);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Registration");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
	}
}
