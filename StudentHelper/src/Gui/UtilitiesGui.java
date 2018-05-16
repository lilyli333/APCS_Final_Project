package Gui;

/**
 * gui for calculator (math operations) and time operatons
 */
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UtilitiesGui extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblStopWatch;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JButton btnReset;

	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int milliseconds = 0;
	private static boolean state = true;
	/**
	 * Create the panel.
	 */
	public UtilitiesGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(6, 6, 838, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("UTILITIES");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(350, 19, 179, 43);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(41, 429, 317, 243);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(391, 429, 401, 243);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel hoursLbl = new JLabel("00:");
		hoursLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		hoursLbl.setForeground(new Color(255, 0, 0));
		hoursLbl.setBounds(16, 75, 64, 27);
		panel_2.add(hoursLbl);
		
		JLabel minutesLbl = new JLabel("00:");
		minutesLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		minutesLbl.setForeground(new Color(255, 0, 0));
		minutesLbl.setBounds(100, 75, 54, 27);
		panel_2.add(minutesLbl);
		
		JLabel secondsLbl = new JLabel("00:");
		secondsLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		secondsLbl.setForeground(new Color(255, 0, 0));
		secondsLbl.setBounds(185, 75, 64, 27);
		panel_2.add(secondsLbl);
		
		JLabel millisecLbl = new JLabel("00:");
		millisecLbl.setForeground(new Color(255, 0, 0));
		millisecLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		millisecLbl.setBounds(300, 76, 95, 27);
		panel_2.add(millisecLbl);
		
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(6, 191, 117, 29);
		panel_2.add(btnStart);
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
		
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBounds(135, 191, 117, 29);
		panel_2.add(btnStop);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				
			}
		});
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(264, 191, 117, 29);
		panel_2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
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
		
		lblNewLabel_1 = new JLabel("CALCULATOR");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(111, 401, 146, 16);
		contentPane.add(lblNewLabel_1);
		
		lblStopWatch = new JLabel("STOP WATCH");
		lblStopWatch.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStopWatch.setBounds(530, 401, 146, 16);
		contentPane.add(lblStopWatch);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(83, 128, 650, 263);
		contentPane.add(panel_3);
		
		JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().getComboBox().setBackground(new Color(224, 255, 255));
		calendar.getDayChooser().getDayPanel().setBackground(new Color(224, 255, 255));
		calendar.setDecorationBackgroundColor(new Color(30, 144, 255));
		calendar.setBackground(new Color(135, 206, 250));
		panel_3.add(calendar);
		
		lblNewLabel_2 = new JLabel("CALANDER");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(342, 100, 108, 16);
		contentPane.add(lblNewLabel_2);

	}
}
