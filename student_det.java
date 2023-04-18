package general;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class student_det implements ActionListener{
	JFrame f=new JFrame();
	 public static JTextField Rno;
	 Connection myConn;
	 Statement myStmt;
	JButton btnNewButton = new JButton("CONTINUE");
	public student_det() {
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.setSize(674,390);  
		f.getContentPane().setLayout(null);
		String year[]={"FY","SY","TY"};        
		String course[]={"BSC","BCA","BCS","BBA","MCA","MCS","MBA"};        
		try {
			Class.forName("org.postgresql.Driver");
			
            //1. Create a connection
			 myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/marksheet","postgres","12345678");
             
            //2. Create a statement
	         myStmt = myConn.createStatement();
            
        }
 
        catch(Exception e){
            e.printStackTrace();
        }
		JLabel lblNewLabel = new JLabel("ENTER STUDENT DETAILS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 28, 268, 24);
		f.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 54, 289, 14);
		f.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No :-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(136, 119, 98, 24);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Class :-");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(136, 178, 98, 24);
		f.getContentPane().add(lblNewLabel_1_1);
		
		Rno = new JTextField();
		Rno.setBounds(261, 111, 181, 32);
		f.getContentPane().add(Rno);
		Rno.setColumns(10);
		f.setVisible(true);
		
		JComboBox cbClass=new JComboBox(year);    
		cbClass.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
	    cbClass.setBounds(261, 179,60,30);     
	    JComboBox cbCourse=new JComboBox(course);    
	    cbCourse.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
	    cbCourse.setBounds(331, 179,100,30);     
		f.getContentPane().add(cbClass);
		f.getContentPane().add(cbCourse);
		
	
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(238, 264, 128, 32);
		f.getContentPane().add(btnNewButton);


	}
	public static void main(String[] args) {
new  student_det();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {

			
				String sql = "SELECT * FROM student WHERE rno = '"+Rno.getText().toString()+"'";
				 
		           
				
				
		           
				try {
					ResultSet rs = myStmt.executeQuery(sql);

					if(!rs.isBeforeFirst() && rs.getRow() == 0)
					{
						 JOptionPane.showMessageDialog(f, "Student Not Exist");

					}
					else {
				
					     
							
							new Enter_Marks();
					         f.dispose();
							 myConn.close();

					}

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			
		}		
	}

}
