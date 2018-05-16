package loginSystem;

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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.toedter.calendar.JDateChooser;

public class Register {

	private JFrame frame;
	private static  String name = "";
	private JLabel lblClock;
	private JLabel lblDate;
	
	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int milliseconds = 0;
	private static boolean state = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//System.out.println(args[0]);
		if(args == null)
			name = "";
		else if((args != null) && (args.length != 0))
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
	// clock method
	private void clock() {
		   Calendar cal = Calendar.getInstance();
		   int day = cal.get(Calendar.DAY_OF_MONTH);
		   int month = cal.get(Calendar.MONTH);
		   int year = cal.get(Calendar.YEAR);
		   
		   int second = cal.get(Calendar.SECOND);
		   int minute = cal.get(Calendar.MINUTE);
		   int hour = cal.get(Calendar.HOUR);
		   
		   lblClock.setText("TIME   "+hour+":"+minute+":"+second);
		    lblDate.setText("DATE   "+day+"/"+month+"/"+year);
	
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Register() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(0, 0, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setForeground(Color.WHITE);
		panel_9.setBackground(new Color(176, 224, 230));
		panel_9.setBounds(556, 359, 157, 36);
		frame.getContentPane().add(panel_9);
		
		JButton btnProgressReport = new JButton("Progress Report");
		btnProgressReport.setBackground(new Color(0, 128, 0));
		panel_9.add(btnProgressReport);
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(Color.WHITE);
		panel_8.setBackground(new Color(255, 165, 0));
		panel_8.setBounds(197, 359, 157, 36);
		frame.getContentPane().add(panel_8);
		
		JButton btnGpaCalculator = new JButton("GPA Calculator");
		btnGpaCalculator.setBackground(new Color(0, 128, 0));
		panel_8.add(btnGpaCalculator);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.WHITE);
		panel_7.setBackground(new Color(0, 139, 139));
		panel_7.setBounds(556, 260, 157, 36);
		frame.getContentPane().add(panel_7);
		
		JButton btnCheckGrades = new JButton("Check Grades");
		btnCheckGrades.setBackground(new Color(0, 128, 0));
		panel_7.add(btnCheckGrades);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(Color.WHITE);
		panel_6.setBackground(new Color(0, 0, 255));
		panel_6.setBounds(556, 161, 157, 36);
		frame.getContentPane().add(panel_6);
		
		JButton btnSeeAssignments = new JButton("See Assignments");
		btnSeeAssignments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeeAssignments.setBackground(new Color(0, 128, 0));
		panel_6.add(btnSeeAssignments);
		
		JLabel headerLabel = new JLabel("Welcome " + name);
		headerLabel.setBounds(0, 0, 1200, 108);
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
		panel_1.setBounds(0, 133, 166, 539);
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
		panel_2.setBounds(4, 104, 1290, 17);
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
		
		JLabel lblNewLabel_3 = new JLabel((String) null);
		lblNewLabel_3.setBackground(new Color(255, 239, 213));
		lblNewLabel_3.setIcon(new ImageIcon("/Users/speedy/Downloads/RegisterBackground.jpg"));
		lblNewLabel_3.setBounds(129, 88, 627, 445);
		frame.getContentPane().add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(761, 116, 561, 239);
		frame.getContentPane().add(panel_5);
		
		
		
		JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().getComboBox().setBackground(new Color(224, 255, 255));
		calendar.getDayChooser().getDayPanel().setBackground(new Color(224, 255, 255));
		calendar.setDecorationBackgroundColor(new Color(30, 144, 255));
		calendar.setBackground(new Color(135, 206, 250));
		panel_5.add(calendar);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(490, 139, 10, 10);
		frame.getContentPane().add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.BLUE);
		panel_12.setBounds(842, 359, 296, 146);
		frame.getContentPane().add(panel_12);
	    panel_12.setLayout(null);
	    
	    lblDate = new JLabel("New label");
	    lblDate.setBounds(47, 29, 202, 31);
	    lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	    lblDate.setForeground(Color.GREEN);
	    panel_12.add(lblDate);
		
	    lblClock = new JLabel("Clock");
	    lblClock.setBounds(47, 87, 233, 31);
	    lblClock.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
	    lblClock.setForeground(Color.GREEN);
	    lblClock.setBackground(Color.BLACK);
		panel_12.add(lblClock);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 206, 209));
		panel_13.setBounds(836, 519, 302, 146);
		frame.getContentPane().add(panel_13);
		panel_13.setLayout(null);
		
		JLabel hoursLbl = new JLabel("00:");
		hoursLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		hoursLbl.setForeground(new Color(255, 255, 0));
		hoursLbl.setBounds(15, 52, 64, 27);
		panel_13.add(hoursLbl);
		
		JLabel minutesLbl = new JLabel("00:");
		minutesLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		minutesLbl.setForeground(new Color(255, 255, 0));
		minutesLbl.setBounds(84, 52, 54, 27);
		panel_13.add(minutesLbl);
		
		JLabel secondsLbl = new JLabel("00:");
		secondsLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		secondsLbl.setForeground(new Color(255, 255, 0));
		secondsLbl.setBounds(150, 52, 64, 27);
		panel_13.add(secondsLbl);
		
		JLabel millisecLbl = new JLabel("00:");
		millisecLbl.setForeground(Color.YELLOW);
		millisecLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		millisecLbl.setBounds(223, 54, 73, 27);
		panel_13.add(millisecLbl);
		
		JLabel lblStopwatch = new JLabel("STOPWATCH");
		lblStopwatch.setForeground(Color.YELLOW);
		lblStopwatch.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStopwatch.setBounds(63, 6, 163, 27);
		panel_13.add(lblStopwatch);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state =true;
				Thread t = new Thread() {

					public void run() {
						for(;;) {
							if(state == true)
							{
								try {
									sleep(1);

									//long time = System.currentTimeMillis();
									if(milliseconds > 1000)
									{
										seconds++;
										milliseconds = 0;	
									}
									if(seconds > 60) {
										milliseconds = 0;
										seconds = 0;
										minutes++;
									}
									if(minutes > 60) {
										milliseconds = 0;
										seconds = 0;
										minutes = 0;
										hours++;
									}

									
									hoursLbl.setText(""+hours);
									minutesLbl.setText(" : "+minutes);
									secondsLbl.setText(" : "+seconds);
									millisecLbl.setText(" : "+milliseconds);
									
									milliseconds++;
								} catch(Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				};
				t.start();
			}
			
		});
		
		btnStart.setBackground(new Color(255, 255, 0));
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setBounds(6, 99, 86, 29);
		panel_13.add(btnStart);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				
			}
		});
		btnStop.setForeground(Color.BLACK);
		btnStop.setBackground(Color.YELLOW);
		btnStop.setBounds(96, 99, 87, 29);
		panel_13.add(btnStop);
		
		JButton resetbutton = new JButton("RESET");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state = false;
				milliseconds = 0;
				seconds = 0;
				minutes = 0;
				hours = 0;

				hoursLbl.setText("00: ");
				minutesLbl.setText("00: ");
				secondsLbl.setText("00: ");
				millisecLbl.setText("00 ");
				
			}
		});
		resetbutton.setForeground(Color.BLACK);
		resetbutton.setBackground(Color.YELLOW);
		resetbutton.setBounds(195, 99, 86, 29);
		panel_13.add(resetbutton);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(240, 248, 255));
		panel_14.setBounds(168, 505, 287, 167);
		frame.getContentPane().add(panel_14);
		
		JLabel label_17 = new JLabel("Reminders");
		panel_14.add(label_17);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 192, 203));
		panel_4.setBounds(469, 505, 287, 167);
		frame.getContentPane().add(panel_4);
		
		JLabel label_18 = new JLabel("Notes");
		panel_4.add(label_18);
		
		JLabel label_7 = new JLabel("");
		
		JLabel label_8 = new JLabel("");
		
		JLabel label_9 = new JLabel("");
		
		JLabel label_10 = new JLabel("");
		
		JLabel label_11 = new JLabel("");
		
		JLabel label_12 = new JLabel("");
		
		JLabel label_13 = new JLabel("");
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		JLabel label_4 = new JLabel("");
		
		JLabel label_5 = new JLabel("");
		
		JLabel label_6 = new JLabel("");
		
		
	}
}
