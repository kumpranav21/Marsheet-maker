package general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class marksheet extends JFrame {

	 JPanel contentPane;
	 JTable table;
	 JLabel lblNewLabel_1;
	 JLabel lblNewLabel_2;
	 JLabel lblNewLabel_3;
	 JLabel lblNewLabel_4;
	 JTextField name;
	 JTextField year;
	 JTextField rno;
	 JTextField course;
	 JTextField Ttotal;
	 JTextField max;
	 JTextField result;
	 JTextField perc;
	Connection myConn;
	Connection myConn1;
	 Statement myStmt;
	 Statement myStmt1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marksheet frame = new marksheet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public marksheet() {
		setVisible(true);


		String [][]data = new String[6][5];
		int i=0;
		

		try {
			Class.forName("org.postgresql.Driver");
			
            //1. Create a connection
			 myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/marksheet","postgres","12345678");
			 myConn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5434/marksheet","postgres","12345678");
             
            //2. Create a statement
	         myStmt = myConn.createStatement();
            
        }
 
        catch(Exception e){
            e.printStackTrace();
        }
		
		try {
Class.forName("org.postgresql.Driver");
			
            //1. Create a connection
			 myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/marksheet","postgres","12345678");
             
            //2. Create a statement
	         myStmt = myConn.createStatement();
             myStmt1 = myConn1.createStatement();
     		ResultSet rs = myStmt.executeQuery("SELECT * FROM marks WHERE rno = '"+Log_Student.Trno.getText().toString()+"'");
     		ResultSet rs1 = myStmt1.executeQuery("SELECT * FROM student WHERE rno = '"+Log_Student.Trno.getText().toString()+"'");
     		
     		
     		while (rs.next()) {
  			
                         data[i][0]= rs.getString("subject");
                         data[i][1]= rs.getString("internal");
                         data[i][2]= rs.getString("external");
                         int total = Integer.parseInt( data[i][1]) + Integer.parseInt(data[i][2]);
                         data[i][3]= total+"";
             		
               		
             		
              		if(total>=15)
              		{
              			data[i][4]= "PASS";
              		}
              		else
              		{
              			data[i][4]= "FAIL";
               		}
              		i++;
           }
     		
     		while (rs1.next()) {
      			
                name.setText(rs1.getString("name"));
                rno.setText(rs1.getString("rno"));
                year.setText(rs1.getString("Year"));
                course.setText(rs1.getString("course"));
                
  }
     		
     		
//     		while (rs1.next()) {
//     			
//     			name.setText(rs.getString("name"));
//     			rno.setText(rs.getString("Rno"));
//     			year.setText(rs.getString("Year"));
//     			course.setText(rs.getString("course"));
//     			
//     			
//     			
//     		}
     		
     		myConn.close();
     		myConn1.close();

     		
        }
 
        catch(Exception e){
            e.printStackTrace();
        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String column[]={"SUB NAME","INTERNAL","EXTERNAL","TOTAL","REMARK"};
   
		JLabel lblNewLabel = new JLabel("STATEMENT OF MARKS");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 32));
		lblNewLabel.setBounds(280, 10, 407, 50);
		contentPane.add(lblNewLabel);
		table = new JTable(data,column);
		table.setRowHeight(50);
		table.setFillsViewportHeight(true);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Serif", Font.PLAIN, 16));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.WHITE);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setBounds(25, 220, 948, 368);
//		contentPane.add(table);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(24, 244, 948, 324);
		contentPane.add(panel);

		panel.setLayout(new BorderLayout());
		panel.add(header, BorderLayout.NORTH);
		panel.add(table, BorderLayout.SOUTH);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(255, 54, 447, 17);
		contentPane.add(separator);
		
		lblNewLabel_1 = new JLabel("NAME :-");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(35, 115, 95, 28);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("YEAR  :-");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(35, 168, 95, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ROLL NO  :-");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(622, 115, 114, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("COURSE  :-");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(622, 168, 105, 17);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(138, 115, 191, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(140, 164, 191, 28);
		contentPane.add(year);
		
		rno = new JTextField();
		rno.setColumns(10);
		rno.setBounds(746, 115, 191, 28);
		contentPane.add(rno);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(746, 164, 191, 28);
		contentPane.add(course);
		
		JLabel lblNewLabel_1_1 = new JLabel("TOTAL :-");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(35, 620, 95, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MAX MARKS :-");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(27, 682, 154, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("RESULT :-");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(674, 620, 114, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("PERCENTAGE :-");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(674, 682, 176, 28);
		contentPane.add(lblNewLabel_1_4);
		
		Ttotal = new JTextField();
		Ttotal.setColumns(10);
		Ttotal.setBounds(176, 623, 114, 28);
		contentPane.add(Ttotal);
		
		max = new JTextField();
		max.setColumns(10);
		max.setBounds(176, 685, 114, 28);
		contentPane.add(max);
		
		result = new JTextField();
		result.setColumns(10);
		result.setBounds(840, 623, 114, 28);
		contentPane.add(result);
		
		perc = new JTextField();
		perc.setColumns(10);
		perc.setBounds(840, 685, 114, 28);
		contentPane.add(perc);
		
		 
	}
}
