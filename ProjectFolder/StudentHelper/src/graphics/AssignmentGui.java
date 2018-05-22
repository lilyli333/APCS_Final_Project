package graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import functions.Assignment;
import functions.Points;
import functions.Subject;
import loginSystem.Dashboard;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class AssignmentGui extends JPanel {
	
	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textSubject;
	private JTextField textAssignment;
	private JTextField textDuedate;
	private DefaultTableModel model;
	private static Connection con = null;
	private JScrollPane scrollPane_2;
	private JTextField textTime;
	private JTextField textPriority;
	private int totalPoints = 0;
	private JLabel lblPoints;
	private JLabel lblPt;
	private int timeTaken;
	private Points pts;
	private JLabel lbl_hour;
	private JLabel label_minute;
	private JLabel label_second;
	
	private boolean state = false;
	
	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int milliseconds = 0;
	
	private ArrayList<Integer> pointList;
	
	private void timer() {

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				JOptionPane.showMessageDialog(null,"Take a Break!");
			}
			
		},15*60*1000,15*60*1000);
	}

	/**
	 * Create the panel.
	 */
	public AssignmentGui() {
		
		setLayout(null);
		
		frame = new JFrame();
		frame.setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 850, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(16, 6, 796, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPoints = new JLabel("TOTAL POINTS:");
		lblPoints.setForeground(Color.RED);
		lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPoints.setBounds(549, 6, 156, 39);
		panel.add(lblPoints);
		
		//frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assignments");
		lblNewLabel.setBounds(23, 6, 224, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		JLabel lblPt = new JLabel("0");
		lblPt.setForeground(Color.RED);
		lblPt.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPt.setBounds(727, 6, 63, 39);
		panel.add(lblPt);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 796, 235);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 0));
		panel_4.setBounds(0, 0, 792, 26);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Current Assignments");
		lblNewLabel_1.setBounds(0, 0, 793, 20);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		
		String[] columnNames =  {"IsCompleted","Subjects",
                "Assignments","Due Date","Tme(in min.)","Priority"};
		Object[][] data = {};//{java.lang.Boolean.class},{java.lang.Object.class},{java.lang.Object.class},{java.lang.Object.class},{java.lang.Integer.class},{java.lang.Integer.class}};/*{"Language Arts","Complete Essay","05/12/2018"},
				          // {" Math","Complete workSheet Page 124-136","05/15/2018"},
				          // {"Science","Chapter 2 test","05/14/2018"}*/
		
		
		
		model = new DefaultTableModel(data,columnNames);//data,columnNames
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 38, 776, 183);
		panel_1.add(scrollPane_2);
		table = new JTable(model) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class getColumnClass(int column){
				switch(column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return Integer.class;
				case 5:
					return Integer.class;
					
					default:
						return String.class;
				}
				
			}
		};
		scrollPane_2.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement stmt = null;
				
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				textSubject.setText(model.getValueAt(i, 1).toString()); 
				textAssignment.setText(model.getValueAt(i, 2).toString());
				textDuedate.setText(model.getValueAt(i, 3).toString());
				textTime.setText(model.getValueAt(i, 4).toString());
				textPriority.setText(model.getValueAt(i, 5).toString());

				if(model.getValueAt(i, 0).toString().equals("false")) {
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

									
									lbl_hour.setText(""+hours);
									label_minute.setText(" : "+minutes);
									label_second.setText(" : "+seconds);
									
									
									milliseconds++;
								} catch(Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				};
				t.start();
				}else
				{
					state = false;
					int hours = 0,minutes = 0,seconds = 0, t = 0,p = 0;
					if(lbl_hour.getText().equals("00:") ||  lbl_hour.getText().equals(" : 0") || lbl_hour.getText().equals(""))
						hours = 0;
					else if(label_minute.getText().equals("00:") || label_minute.getText().equals(" : 0") ||  label_minute.getText().equals(""))
						minutes = 0;
					else if(label_second.getText().equals("00:") || label_second.getText().equals(" : 0") ||  label_second.getText().equals(""))
						seconds = 0;
					else
					{
						hours = Integer.parseInt(lbl_hour.getText())*60;
						minutes = Integer.parseInt(label_minute.getText());
						seconds = Integer.parseInt(label_second.getText())/60;
					}
					timeTaken = hours + minutes + seconds;
					if(!textTime.getText().equals("") )
					t = Integer.parseInt(textTime.getText());
					else
						t = 0;
					if(!textPriority.getText().equals("") )
						p = Integer.parseInt(textPriority.getText());
						else
							p = 0;
					pts = new Points(t,timeTaken,true,p);
					totalPoints +=pts.getPoints();
					lblPt.setText(""+totalPoints);
					pointList.add(totalPoints);
					insertIntoPoint(pts.getPoints());
					
				/*	
					
					milliseconds = 0;
					seconds = 0;
					minutes = 0;
					hours = 0;

					lbl_hour.setText("00: ");
					label_minute.setText("00: ");
					label_second.setText("00: ");*/
					
				}
					
					
			
				
				
				/*if(model.getValueAt(i, 0).toString().equals("true")) {
					points += 10;
					lblPt.setText(""+points);
					
				
					
					insertIntoPoint(stmt, points);*/
					
				//////////////delete assignment from table
					/*String query = "DELETE FROM  CLASS_ASSIGNMENTS WHERE  subjects = "+ "'"+model.getValueAt(table.getSelectedRow(), 1)+"'";

					executeSQLQuery(query);
					
					textSubject.setText("");
					textAssignment.setText("");
					textDuedate.setText("");
					textTime.setText("");
					textPriority.setText("");
					
					for(int i1 =0 ;i1<table.getModel().getRowCount();i1++) {
			    		for(int j =0 ;j<table.getModel().getColumnCount();j++) {
			    			table.getModel().setValueAt("", i1, j);
			    		}
			    	}
					show_Assignment_Table();*/
				//}
				
					
				}

			private void insertIntoPoint(int points) {
				PreparedStatement stmt = null;
				String sql = "INSERT INTO POINTS(point)"
					    + " values(?)";
				try {
					
					con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					
					stmt.setInt(1, points);
					
					
					stmt.executeUpdate();
					
					// print assignments table to console

					
					System.out.println("Data Entered in points");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						stmt.close();
						//st.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//frame.dispose();
				}
			}
		
			
		});
		//TableCellEditor tcl = new TableCellEditor(table,action);
		//table.setToolTipText("");
		
		table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(new Color(255, 255, 255));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setBackground(new Color(30, 144, 255));
		show_Assignment_Table();
		
		
		/*JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE  ASSIGNMENTS SET subjects = "+ "'"+textSubject.getText()+"'"+", assignments = "
                        +"'"+ textAssignment.getText()+"'"+ ", due_date = " + "'"+textDuedate.getText() +"'"+  " WHERE id = "+table.getSelectedRow();
				executeSQLQuery(query);
				
				textSubject.setText("");
				textAssignment.setText("");
				textDuedate.setText("");
				
			}
		});
		btnUpdate.setBounds(256, 89, 100, 30);
		panel_3.add(btnUpdate);*/
		
		JLabel lblNewLabel_3 = new JLabel("Add Assignments");
		lblNewLabel_3.setBounds(16, 304, 792, 28);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(16, 304, 796, 22);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		
		panel_3 = new JPanel();
		panel_3.setBounds(16, 327, 796, 125);
		contentPane.add(panel_3);
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setLayout(null);
		
		textAssignment = new JTextField();
		textAssignment.setColumns(10);
		textAssignment.setBounds(169, 29, 247, 26);
		panel_3.add(textAssignment);
		
		textDuedate = new JTextField();
		textDuedate.setColumns(10);
		textDuedate.setBounds(430, 29, 134, 26);
		panel_3.add(textDuedate);
		
		JLabel lblAssignment = new JLabel("Enter Assignment");
		lblAssignment.setBounds(253, 58, 134, 29);
		panel_3.add(lblAssignment);
		
		JLabel lblDueDate = new JLabel("Enter Due Date");
		lblDueDate.setBounds(440, 59, 134, 26);
		panel_3.add(lblDueDate);
		
		textPriority = new JTextField();
		textPriority.setColumns(10);
		textPriority.setBounds(728, 29, 62, 26);
		panel_3.add(textPriority);
		
		JLabel lblEnterTimeIn = new JLabel("Enter time in mins.");
		lblEnterTimeIn.setBounds(576, 60, 134, 26);
		panel_3.add(lblEnterTimeIn);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(738, 60, 54, 26);
		panel_3.add(lblPriority);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(30, 144, 255));
		panel_6.setBounds(0, 0, 796, 125);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(261, 89, 100, 30);
		panel_6.add(btnEnter);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(467, 89, 100, 30);
		panel_6.add(btnDelete);
		
		textSubject = new JTextField();
		textSubject.setBounds(18, 28, 130, 26);
		panel_6.add(textSubject);
		textSubject.setColumns(10);
		
		JLabel lblSubject = new JLabel("Enter Subject");
		lblSubject.setBounds(28, 54, 134, 30);
		panel_6.add(lblSubject);
		
		textTime = new JTextField();
		textTime.setBounds(585, 28, 130, 26);
		panel_6.add(textTime);
		textTime.setColumns(10);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "DELETE FROM  CLASS_ASSIGNMENTS WHERE  subjects = "+ "'"+model.getValueAt(table.getSelectedRow(), 1)+"'";

				executeSQLQuery(query);
				
				
				textSubject.setText("");
				textAssignment.setText("");
				textDuedate.setText("");
				textTime.setText("");
				textPriority.setText("");
				
				for(int i =0 ;i<table.getModel().getRowCount();i++) {
		    		for(int j =0 ;j<table.getModel().getColumnCount();j++) {
		    			table.getModel().setValueAt("", i, j);
		    		}
		    	}
				show_Assignment_Table();
			}
		});
		btnEnter.addActionListener(new ActionListener() {
			
			boolean isCompleted = false;
			String subject;
			String assignment;
			String duedate;
			int time;
			int priority;
			
			public void actionPerformed(ActionEvent e) {
				
				//isCompleted = Boolean.valueOf(textCompleted.getText());
			    subject = textSubject.getText();
				assignment = textAssignment.getText();
				duedate = textDuedate.getText();
				if(!textTime.getText().equals("")) {
					time = Integer.parseInt(textTime.getText());
				}else
				time = 0;
				if(!textPriority.getText().equals("")) {
				
				priority = Integer.parseInt(textPriority.getText());
				}else 
					priority = 0;
				
				//textCompleted.setText("");
				textSubject.setText("");
				textAssignment.setText("");
				textDuedate.setText("");
				textTime.setText("");
				textPriority.setText("");
				if(!subject.equals("")  && !assignment.equals("") && !duedate.equals("")) {
					((DefaultTableModel) table.getModel()).insertRow(model.getRowCount(), new Object[] {isCompleted,subject,assignment,duedate,time,priority});
					// Dashboard.getEditorPane().setText(subject+":"+assignment+":"+duedate);
					insertIntoAssignments();
				}
			     else {
				     JOptionPane.showMessageDialog(null, "enter valid info");
			    }
			}

			private void insertIntoAssignments() {
                  
				Connection con = null;
				PreparedStatement stmt = null;
				Statement st = null;
				String sql = "INSERT INTO CLASS_ASSIGNMENTS(isCompleted,subjects,assignments,due_date,time,priority)"
					    + " values(?,?,?,?,?,?)";
				try {
					
					con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					
					stmt.setBoolean(1, isCompleted);
					stmt.setString(2,subject);
					stmt.setString(3,assignment);
					stmt.setString(4,duedate);
					stmt.setInt(5,time);
					stmt.setInt(6,priority);
					
					stmt.executeUpdate();
					
					// print assignments table to console
			
					
					System.out.println("Data Entered in assignment");
					readTableAssignments(con);	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						stmt.close();
						//st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//frame.dispose();
				}
			}

			private void readTableAssignments(Connection con) {
				Statement st = null;
				ResultSet rs = null;
				String sql3 = "SELECT * FROM CLASS_ASSIGNMENTS ";
				try {
				st = con.createStatement();
				rs = st.executeQuery(sql3);
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "
							           +rs.getBoolean(2)+" "
							           +rs.getString(3) + " "
							           +rs.getString(4)+ " "
							           +rs.getString(5)+" "
							           +rs.getInt(6)+" "
							           +rs.getInt(7));
							           
				}
				}catch(SQLException e) {
					e.getMessage();
				}
				finally {
					try {
						st.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(16, 464, 796, 28);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Show Graph");
		lblNewLabel_2.setBounds(6, 6, 119, 16);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(30, 144, 255));
		panel_5.setBounds(16, 493, 796, 118);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Graph");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graph window = new Graph(pointList);
				JFrame f = new JFrame();
				
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.getContentPane().add(window);//new Graph());
				f.setSize(450,450);
				f.setLocation(200,200);
				f.setVisible(true);
				
				f.getContentPane().add(window);

			}
		});
		btnNewButton.setBounds(311, 34, 168, 29);
		panel_5.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Use this button to see the points you have earned over time");
		lblNewLabel_4.setBounds(204, 63, 385, 16);
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 0));
		panel_8.setBounds(16, 623, 796, 53);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Start Timer when starting an Assignment");
		lblNewLabel_5.setBounds(6, 6, 296, 41);
		panel_8.add(lblNewLabel_5);
		
	    lbl_hour = new JLabel("00:");
		lbl_hour.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lbl_hour.setBounds(302, 1, 53, 41);
		panel_8.add(lbl_hour);
		
		label_minute = new JLabel("00:");
		label_minute.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label_minute.setBounds(365, 1, 48, 41);
		panel_8.add(label_minute);
		
		label_second = new JLabel("00");
		label_second.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label_second.setBounds(439, 1, 72, 41);
		panel_8.add(label_second);
		
		
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

									
									lbl_hour.setText(""+hours);
									label_minute.setText(" : "+minutes);
									label_second.setText(" : "+seconds);
									
									
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
		
		
		btnStart.setBounds(512, 13, 88, 29);
		panel_8.add(btnStart);
		
		
		JButton btnStop = new JButton("STOP");
		pointList = new ArrayList<>();
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				int hours = 0,minutes = 0,seconds = 0, t = 0,p = 0;
				if(lbl_hour.getText().equals("00:") ||  lbl_hour.getText().equals(" : 0") || lbl_hour.getText().equals(""))
					hours = 0;
				else if(label_minute.getText().equals("00:") || label_minute.getText().equals(" : 0") ||  label_minute.getText().equals(""))
					minutes = 0;
				else if(label_second.getText().equals("00:") || label_second.getText().equals(" : 0") ||  label_second.getText().equals(""))
					seconds = 0;
				else
				{
					hours = Integer.parseInt(lbl_hour.getText())*60;
					minutes = Integer.parseInt(label_minute.getText());
					seconds = Integer.parseInt(label_second.getText())/60;
				}
				timeTaken = hours + minutes + seconds;
				if(!textTime.getText().equals("") )
				t = Integer.parseInt(textTime.getText());
				else
					t = 0;
				if(!textPriority.getText().equals("") )
					p = Integer.parseInt(textPriority.getText());
					else
						p = 0;
				pts = new Points(t,timeTaken,true,p);
				lblPt.setText(""+pts.getPoints());
				pointList.add(pts.getPoints());
				System.out.println("points:"+pts.getPoints());
				}
				
		
		});
		btnStop.setBounds(612, 13, 88, 29);
		panel_8.add(btnStop);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				milliseconds = 0;
				seconds = 0;
				minutes = 0;
				hours = 0;

				lbl_hour.setText("00: ");
				label_minute.setText("00: ");
				label_second.setText("00: ");
				
			}
		});
		btnReset.setBounds(702, 13, 88, 29);
		panel_8.add(btnReset);
		timer();
		
		pointList =readFromPoint();
		int previousPoint = 0;
		for(int i: pointList)
			previousPoint +=i;
		lblPt.setText(Integer.toString(previousPoint));

	}
	private ArrayList<Integer> readFromPoint() {
		
		ArrayList<Integer> list = new ArrayList<>();
		try{
			con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
			String query = "SELECT * FROM POINTS";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while(rs.next()){
				list.add(rs.getInt("point"));

				//lblPt.setText(Integer.toString(rs.getInt("point")));
			}

		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}
		return list;

	}
		
	

	public static Connection getConnection() {
		try {
			if(con == null)
			 con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public void executeSQLQuery(String query) {
		Statement st = null;
		try {
			Connection con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
		    st = con.createStatement();
		    if(st.executeUpdate(query) == 1) {
		    	JOptionPane.showMessageDialog(null, " operation sucessfull");
		    }
		    else
		    	JOptionPane.showMessageDialog(null, " operation not sucessfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void show_Assignment_Table() {
		

	          ArrayList<Assignment> list = readAssignToList();
	          Object[] row = new Object[6];
	          for(int i=0;i<list.size();i++){
                 
	        	  row[0] = list.get(i).isCompleted();
	        	  row[1] = list.get(i).getSubject();
	        	  row[2] = list.get(i).getAssignment();
	        	  row[3] = list.get(i).getDuedate();
	        	  row[4] = list.get(i).getTime();
	        	  row[5] = list.get(i).getPriority();

	        	  model.addRow(row);
	        	  

	          }
	          System.out.println(" list to table read complete");

	}

	
	private	ArrayList<Assignment> readAssignToList(){
		Connection con;
		ArrayList<Assignment>  assignList = new ArrayList<>();
		try{

			con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
			String query = "SELECT * FROM CLASS_ASSIGNMENTS";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			Assignment assign;

			while(rs.next()){

				assign = new Assignment(rs.getBoolean("isCompleted"),rs.getString("subjects"),rs.getString("assignments"),rs.getString("due_date"),rs.getInt("time"),rs.getInt("priority"));
				assignList.add(assign);
				

			}
 
			System.out.println("reading database to list complete");
		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}
		return assignList;

	}
	public static void readAssignToText(){
		try{

			con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
			String query = "SELECT * FROM CLASS_ASSIGNMENTS";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while(rs.next()){

				Dashboard.getTextArea().append(rs.getString("subjects")+": \n" +rs.getString("assignments")+": \n"+rs.getString("due_date")+"\n");
			}

		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}

	}
}

