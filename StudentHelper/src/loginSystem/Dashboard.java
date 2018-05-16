package loginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import Gui.AssignmentGui;
import Gui.ClassesGui;
import Gui.CollegesGui;
import Gui.GradesGui;
import Gui.ProfileGui;
import Gui.UtilitiesGui;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JEditorPane;

public class Dashboard extends JPanel{

	private JFrame frame;
	private JPanel panelMain;
	private JTextField textField;
	private  String name = "";
	private JLabel lblClock;
	private JLabel lblDate;
	
	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int milliseconds = 0;
	private static boolean state = true;
	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		if(args == null)
			name = "";
		else if((args != null) && (args.length != 0))
		      name = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}*/
	private void clock() {
		Thread t = new Thread() {
			public void run() {
				while(true) {
		   Calendar cal = Calendar.getInstance();
		   int day = cal.get(Calendar.DAY_OF_MONTH);
		   int month = cal.get(Calendar.MONTH);
		   int year = cal.get(Calendar.YEAR);
		   
		   int second = cal.get(Calendar.SECOND);
		   int minute = cal.get(Calendar.MINUTE);
		   int hour = cal.get(Calendar.HOUR);
		   int tz = cal.get(Calendar.AM_PM);
		   String tm = (tz == 0)?"AM":"PM";
		   
		   lblClock.setText("TIME   "+hour+":"+minute+":"+second+" "+tm);
		   lblDate.setText("DATE   "+day+"/"+month+"/"+year);
				}
			}
		};
		t.start();
	}

	/**
	 * Create the application.
	 */
	public Dashboard(String userName) {
		this.name = userName;
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(6, 24, 1138, 127);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Welcome "+name);
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Copperplate", Font.BOLD, 30));
		lblNewLabel_13.setBounds(398, 51, 320, 27);
		panel.add(lblNewLabel_13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(6, 154, 160, 481);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(6, 11, 148, 36);
		panel_2.add(panel_1);
		
		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setBounds(49, 6, 99, 24);
		lblDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDashboard.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDashboard.setForeground(new Color(0));
			}
		});
		panel_1.setLayout(null);
		panel_1.add(lblDashboard);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/dashboard.jpg")));
		lblNewLabel.setBounds(6, 6, 41, 24);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(6, 59, 148, 36);
		panel_2.add(panel_3);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProfile.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblProfile.setForeground(new Color(0));
			}
		});
		lblProfile.setBounds(50, 6, 92, 24);
		panel_3.add(lblProfile);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_user.jpg")));
		lblNewLabel_1.setBounds(5, 6, 33, 24);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(6, 107, 148, 36);
		panel_2.add(panel_4);
		
		JLabel lblClasses = new JLabel("CLASSES");
		lblClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClasses.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClasses.setForeground(new Color(0));
			}
		});
		lblClasses.setBounds(51, 6, 91, 24);
		panel_4.add(lblClasses);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_classes.jpg")));
		label.setBounds(6, 6, 33, 24);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(6, 156, 148, 36);
		panel_2.add(panel_5);
		
		JLabel lblGrades = new JLabel("GRADES");
		lblGrades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGrades.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGrades.setForeground(new Color(0));
			}
		});
		lblGrades.setBounds(53, 6, 89, 24);
		panel_5.add(lblGrades);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_grades.jpg")));
		label_2.setBounds(6, 6, 35, 24);
		panel_5.add(label_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(6, 204, 148, 36);
		panel_2.add(panel_6);
		
		JLabel lblAssignments = new JLabel("ASSIGNMENTS");
		lblAssignments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAssignments.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAssignments.setForeground(new Color(0));
			}
		});
		lblAssignments.setBounds(53, 6, 89, 24);
		panel_6.add(lblAssignments);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_assignment.jpg")));
		label_3.setBounds(8, 6, 32, 24);
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(6, 252, 148, 36);
		panel_2.add(panel_7);
		
		JLabel lblClleges = new JLabel("COLLEGES");
		lblClleges.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClleges.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClleges.setForeground(new Color(0));
			}
		});
		lblClleges.setBounds(52, 6, 90, 24);
		panel_7.add(lblClleges);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_colleges.jpg")));
		label_4.setBounds(7, 6, 33, 24);
		panel_7.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(6, 300, 148, 36);
		panel_2.add(panel_8);
		
		JLabel lblCalendar = new JLabel("CALENDAR");
		lblCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCalendar.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCalendar.setForeground(new Color(0));
			}
		});
		lblCalendar.setBounds(56, 6, 86, 24);
		panel_8.add(lblCalendar);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/calendar (1).jpg")));
		label_5.setBounds(6, 6, 38, 24);
		panel_8.add(label_5);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(204, 153, 255));
		panel_9.setBounds(6, 6, 1138, 19);
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(848, 0, 118, 19);
		panel_9.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_search.jpg")));
		lblNewLabel_3.setBounds(964, 0, 66, 18);
		panel_9.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_user.jpg")));
		lblNewLabel_4.setBounds(783, 2, 42, 16);
		panel_9.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ombre.jpg")));
		lblNewLabel_6.setBounds(0, 2, 982, 16);
		panel_9.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(6, 6, 717, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
	    panelMain = new JPanel();
		panelMain.setBounds(178, 154, 769, 481);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(83, 247, 147, 132);
		panelMain.add(panel_13);
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ProfileGui window = new ProfileGui();
				
				frame.getContentPane().add(window);
				window.setRequestFocusEnabled(true);
				
				
			}
		});
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(176, 224, 230));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_1526257620127blob.jpg")));
		label_6.setBounds(52, 15, 105, 69);
		panel_13.add(label_6);
		
		JLabel lblCreateProfile = new JLabel("Create Profile");
		lblCreateProfile.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCreateProfile.setBounds(35, 96, 105, 16);
		panel_13.add(lblCreateProfile);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(314, 42, 147, 132);
		panelMain.add(panel_11);
		panel_11.setBackground(new Color(204, 204, 255));
		panel_11.setLayout(null);
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ClassesGui window = new ClassesGui();
				
				frame.getContentPane().add(window);
				//window.setRequestFocusEnabled(true);
				
				
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("Classes");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_9.setBounds(47, 95, 69, 16);
		panel_11.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_classes.jpg")));
		lblNewLabel_10.setBounds(47, 17, 94, 66);
		panel_11.add(lblNewLabel_10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(314, 247, 147, 132);
		panelMain.add(panel_14);
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(102, 153, 153));
		panel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				CollegesGui window = new CollegesGui();
				
				frame.getContentPane().add(window);
				//window.setRequestFocusEnabled(true);
				
				
			}
		});
		
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_colleges.jpg")));
		label_8.setBounds(49, 6, 128, 82);
		panel_14.add(label_8);
		
		JLabel lblSearchColleges = new JLabel("Search Colleges");
		lblSearchColleges.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSearchColleges.setBounds(20, 96, 120, 16);
		panel_14.add(lblSearchColleges);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(553, 42, 147, 132);
		panelMain.add(panel_12);
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(153, 204, 255));
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				GradesGui window = new GradesGui();
				
				frame.getContentPane().add(window);
				//window.setRequestFocusEnabled(true);
				
				
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_grades.jpg")));
		label_1.setBounds(45, 6, 132, 82);
		panel_12.add(label_1);
		
		JLabel lblCheckGrades = new JLabel("Grades");
		lblCheckGrades.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCheckGrades.setBounds(45, 93, 102, 16);
		panel_12.add(lblCheckGrades);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(553, 247, 147, 132);
		panelMain.add(panel_15);
		panel_15.setLayout(null);
		panel_15.setBackground(new Color(102, 102, 153));
		panel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				UtilitiesGui window = new UtilitiesGui();
				
				frame.getContentPane().add(window);
				//window.setRequestFocusEnabled(true);
				
				
			}
		});
		
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_Reminders.jpg")));
		label_10.setBounds(41, 17, 56, 56);
		panel_15.add(label_10);
		
		
		JLabel lblUtilities = new JLabel("Utilities");
		lblUtilities.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUtilities.setBounds(41, 96, 112, 16);
		panel_15.add(lblUtilities);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(83, 42, 147, 132);
		panelMain.add(panel_10);
		panel_10.setBackground(new Color(216, 191, 216));
		panel_10.setLayout(null);
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				AssignmentGui window = new AssignmentGui();
				
				frame.getContentPane().add(window);
				//window.setRequestFocusEnabled(true);
				
				
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(45, 6, 132, 82);
		lblNewLabel_7.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ps_assignment.jpg")));
		panel_10.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Assignments");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_8.setBounds(31, 96, 109, 16);
		panel_10.add(lblNewLabel_8);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(0, 0, 128));
		panel_17.setBounds(6, 639, 1138, 11);
		frame.getContentPane().add(panel_17);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_17.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setIcon(new ImageIcon(Dashboard.class.getResource("/Resource/ombre.jpg")));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(6, 647, 1144, 25);
		frame.getContentPane().add(panel_18);
		panel_18.setLayout(null);
		
	    lblClock = new JLabel("clock");
	    lblClock.setBackground(new Color(255, 255, 255));
	    lblClock.setForeground(new Color(255, 0, 0));
		lblClock.setBounds(988, 6, 150, 19);
		panel_18.add(lblClock);
		
	    lblDate = new JLabel("date");
	    lblDate.setForeground(new Color(255, 0, 0));
	    lblDate.setBounds(850, 6, 126, 19);
		panel_18.add(lblDate);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(128, 128, 128));
		panel_16.setBounds(940, 154, 204, 481);
		frame.getContentPane().add(panel_16);
		panel_16.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(240, 255, 255));
		editorPane.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		editorPane.setBounds(16, 52, 182, 318);
		panel_16.add(editorPane);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 255, 255));
		panel_19.setBounds(16, 6, 182, 34);
		panel_16.add(panel_19);
		panel_19.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Current Assignments");
		lblNewLabel_12.setBounds(21, 6, 144, 22);
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_19.add(lblNewLabel_12);
	}
}
