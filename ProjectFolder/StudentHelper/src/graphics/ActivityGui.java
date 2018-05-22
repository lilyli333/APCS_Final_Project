package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument.Content;

import functions.Activity;
import functions.Assignment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActivityGui extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField activityField;
	private JTextField timeField;
	private static Connection con;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel_1,panel_4;
	private JScrollPane scrollPane_1;

	/**
	 * Create the panel.
	 */
	public ActivityGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(6, 6, 638, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Today's Schedule");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(229, 6, 210, 44);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 617, 235);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 0));
		panel_4.setBounds(6, 6, 597, 26);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		String[] columnNames =  {"Activity","time"};
		Object[][] data = {/*{"Play Tennis","5:00"},
				           {"Meet Friends","6:00"},
				           {"Studies","7:00-8:00"}*/
		};
		
		
		model = new DefaultTableModel(data,columnNames);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 52, 597, 173);
		panel_1.add(scrollPane_1);
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		table.setToolTipText("Activity time");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				activityField.setText(model.getValueAt(i, 0).toString());
				timeField.setText(model.getValueAt(i, 1).toString());

			}
		});
		
		table.setBackground(new Color(173, 216, 230));table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(new Color(0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		//panel_1.add(table.getTableHeader());
		System.out.println(table.getTableHeader());
		readFromActivities(); 
		writeToActivities();
		
		
		
		activityField = new JTextField();
		activityField.setBounds(252, 327, 293, 37);
		contentPane.add(activityField);
		activityField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Activity");
		lblNewLabel_1.setBounds(113, 327, 63, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(113, 418, 63, 37);
		contentPane.add(lblTime);
		
		timeField = new JTextField();
		timeField.setColumns(10);
		timeField.setBounds(252, 418, 293, 37);
		contentPane.add(timeField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			String activity,time;
			public void actionPerformed(ActionEvent e) {
				addToActivities();
				readFromActivities();
			}

			private void addToActivities() {
				activity = activityField.getText();
				time = timeField.getText();
				
				activityField.setText("");
				timeField.setText("");
				
			  ((DefaultTableModel) table.getModel()).insertRow(model.getRowCount(), new Object[] {activity,time});
			  insertIntoActivities();
				
			}

			private void insertIntoActivities() {
				Connection con;
				PreparedStatement stmt = null;
				String sql = "INSERT INTO ACTIVITIES(activity,time)"
					    + " values(?,?)";
				try {
					
					con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
					stmt = con.prepareStatement(sql);
					stmt.setString(1,activity);
					stmt.setString(2,time);
					
					
					stmt.executeUpdate();
					
					// print assignments table to console
			
					
					System.out.println("Data Entered in activity");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//frame.dispose();
				}
				
			}
		});
		btnEnter.setBounds(130, 561, 117, 29);
		contentPane.add(btnEnter);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromList();
			}
		});
		btnRemove.setBounds(385, 561, 117, 29);
		contentPane.add(btnRemove);
		frame.setVisible(true);

	}
	
	private void writeToActivities() {
		ArrayList<Activity>  activityList = new ArrayList<>();
		try{

			con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
			String query = "SELECT * FROM ACTIVITIES";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			Activity activty;

			while(rs.next()){

				activty = new Activity(rs.getString("activity"),rs.getString("time"));
				activityList.add(activty);
				
			}
			 Object[] row = new Object[2];
	         for(int i=0;i<activityList.size();i++){

	                    row[0] = activityList.get(i).getActivity();
	                    row[1] = activityList.get(i).getTime();
	                   
	                                   
	                     model.addRow(row);
	                   
	          }

		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}
		
		
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
    private void readFromActivities() {
    	System.out.println("reading from activities");
    	Statement st = null;
		ResultSet rs = null;
		String sql3 = "SELECT * FROM ACTIVITIES ";
		try {
	    con = getConnection();
		st = con.createStatement();
		rs = st.executeQuery(sql3);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "
					           +rs.getString(2) + " "
					           +rs.getString(3));
					           
		}
		}catch(SQLException e) {
			e.getMessage();
		}
		finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
    
    private void removeFromList() {
    	
    	String query = "DELETE FROM  ACTIVITIES WHERE  activity = "+ "'"+model.getValueAt(table.getSelectedRow(), 0)+"'";
    	
    	Statement st = null;
		try {
			Connection con = getConnection();//DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
		    st = con.createStatement();
		    if(st.executeUpdate(query) == 1) {
		    	JOptionPane.showMessageDialog(null, " operation sucessfull");
		    	
		    	System.out.println(model.getValueAt(table.getSelectedRow(), 1));
		    
		    	for(int i =0 ;i<table.getModel().getRowCount();i++) {
		    		for(int j =0 ;j<table.getModel().getColumnCount();j++) {
		    			table.getModel().setValueAt("", i, j);
		    		}
		    	}
		    	writeToActivities();
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
		
        activityField.setText("");
		timeField.setText("");
		
    	
    }
}
