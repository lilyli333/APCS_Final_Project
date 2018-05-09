package registerSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Home page
 * @author Anushka (based on kumawat ajay Youtube tutorial)
 *
 */
public class Register {

	private JFrame frame;
	private static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		name = args[0];
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel headerLabel = new JLabel("Welcome " + name);
		headerLabel.setBounds(0, 0, 800, 108);
		headerLabel.setToolTipText("");
		headerLabel.setBackground(Color.DARK_GRAY);
		headerLabel.setForeground(Color.RED);
		headerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		headerLabel.setIcon(new ImageIcon("/Users/speedy/Downloads/headerimage.png"));
		frame.getContentPane().add(headerLabel);
		
		JList list = new JList();
		list.setBounds(0, 0, 0, 478);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(800, 0, 0, 478);
		frame.getContentPane().add(list_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(197, 161, 157, 36);
		panel.setBackground(new Color(0, 128, 0));
		panel.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		
		JButton btnAddTasks = new JButton("Add Tasks");
		btnAddTasks.setIcon(null);
		btnAddTasks.setBackground(new Color(0, 128, 0));
		panel.add(btnAddTasks);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 133, 177, 347);
		panel_1.setBackground(new Color(128, 128, 128));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Tasks");
		mntmNewMenuItem.setBounds(6, 35, 154, 19);
		panel_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("See Assignments");
		mntmNewMenuItem_2.setBounds(7, 58, 153, 19);
		panel_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmCheckGrades = new JMenuItem("Check Grades");
		mntmCheckGrades.setBounds(6, 81, 153, 19);
		panel_1.add(mntmCheckGrades);
		
		JMenuItem mntmGpaCalculator = new JMenuItem("GPA Calculator");
		mntmGpaCalculator.setBounds(6, 104, 154, 19);
		panel_1.add(mntmGpaCalculator);
		
		JMenuItem mntmReminders = new JMenuItem("Reminders");
		mntmReminders.setBounds(6, 129, 154, 19);
		panel_1.add(mntmReminders);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Notes");
		mntmNewMenuItem_1.setBounds(6, 151, 154, 19);
		panel_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmCreateProfile = new JMenuItem("Create Profile");
		mntmCreateProfile.setBounds(7, 174, 153, 19);
		panel_1.add(mntmCreateProfile);
		
		JLabel lblNewLabel_1 = new JLabel("Student Menu");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(6, 7, 154, 16);
		panel_1.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 61, 16);
		lblNewLabel.setBackground(new Color(128, 128, 128));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 104, 815, 17);
		panel_2.setBackground(new Color(128, 128, 128));
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 182, 193));
		panel_3.setBounds(197, 260, 157, 36);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButton = new JButton("Create Profile");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setBounds(184, 329, 266, 143);
		frame.getContentPane().add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Reminders");
		panel_4.add(lblNewLabel_2);
	}
}
