package general;

import java.awt.Color;import java.sql.*;  

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;  
public class reg_student implements  ActionListener{
	Connection myConn;
	 Statement myStmt;
	 JButton Continue;
	 JTextField Tsetpass;
	   JTextField Tconpass;
		JTextField Tname=new JTextField(); 
		JTextField Temail=new JTextField(); 
		JTextField Trno=new JTextField(); 
		String year[]={"FY","SY","TY"};        
		String course[]={"BSC","BCA","BCS","BBA","MCA","MCS","MBA"};        
		JFrame f=new JFrame();

	    JComboBox cbClass=new JComboBox(year);    
	    JComboBox cbCourse=new JComboBox(course);    

	public reg_student() {
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
    
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.setSize(869,499);  
		f.getContentPane().setLayout(null);
		
		f.setVisible(true);
		JLabel Ltitle = new JLabel("REGISTER YOURSELF...");
		Ltitle.setForeground(new Color(255, 255, 255));
		Ltitle.setBounds(30,30, 650,30); 
		Ltitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));


		JLabel Lname = new JLabel("Name :-");
		Lname.setForeground(new Color(255, 255, 255));
		Lname.setBounds(30,117, 100,30); 
		Lname.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		
		Tname.setBounds(110,117, 200,30); 
		
		JLabel Lemail = new JLabel("Email :-");
		Lemail.setForeground(new Color(255, 255, 255));
		Lemail.setBounds(30,201, 100,30); 
		Lemail.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

		Temail.setBounds(110,205, 200,30); 
		
		JLabel Lclass = new JLabel("Class :-");
		Lclass.setForeground(new Color(255, 255, 255));
		Lclass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		Lclass.setBounds(450,201, 100,30); 

	    cbClass.setBounds(550, 204,60,30);     
	    cbCourse.setBounds(625, 204,123,30);     
		
		JLabel Lrno = new JLabel("Roll no :-");
		Lrno.setForeground(new Color(255, 255, 255));
		Lrno.setBounds(450,113, 100,30); 
		Lrno.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

		Trno.setBounds(550,117, 200,30); 
		 Continue=new JButton("CONTINUE");
		Continue.setBackground(new Color(255, 255, 255));
		Continue.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		Continue.setBounds(328,376, 153,37); 
Continue.addActionListener(this);

Tsetpass = new JTextField();
Tsetpass.setBounds(179, 288, 128, 30);
f.getContentPane().add(Tsetpass);
Tconpass = new JTextField();
Tconpass.setBounds(635, 288, 123, 30);
f.getContentPane().add(Tconpass);


f.getContentPane().add(Tname);
f.getContentPane().add(Ltitle);
f.getContentPane().add(Lname);
f.getContentPane().add(cbClass);
f.getContentPane().add(cbCourse);

f.getContentPane().add(Lemail);
f.getContentPane().add(Lclass);
f.getContentPane().add(Temail);
f.getContentPane().add(Trno);
f.getContentPane().add(Lrno);
f.getContentPane().add(Continue);
JSeparator separator = new JSeparator();
separator.setBounds(10, 69, 383, 2);
f.getContentPane().add(separator);

JLabel lblSetPassword = new JLabel("Set Password :-");
lblSetPassword.setForeground(Color.WHITE);
lblSetPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
lblSetPassword.setBounds(30, 284, 128, 30);
f.getContentPane().add(lblSetPassword);
JLabel lblConfirmPassword = new JLabel("Confirm Password :-");
lblConfirmPassword.setForeground(Color.WHITE);
lblConfirmPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
lblConfirmPassword.setBounds(450, 284, 165, 30);
f.getContentPane().add(lblConfirmPassword);


		
		
	}

	public static void main(String[] args) {
		new reg_student();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String Rno = Trno.getText().toString();
		String name =Tname.getText().toString();
		String email = Temail.getText().toString();
		
		
		if(e.getSource()== Continue) {
			
			if(Rno.equals("")||name.equals("")||email.equals(""))
			{
	            JOptionPane.showMessageDialog(f, "Please Provide All Details");

			}
			else {
				if((Tsetpass.getText().toString()).equals(Tconpass.getText().toString())) {
		    		String sql = "INSERT INTO student(rno,name,email,year,course,pass) VALUES ('"+Trno.getText().toString()+"', '"+Tname.getText().toString()+"', '"+Temail.getText().toString()+"', '"+(String)cbClass.getSelectedItem()+"','"+(String)cbCourse.getSelectedItem()+"','"+Tsetpass.getText().toString()+"')";
					 
		            try {
					myStmt.executeUpdate(sql);
					 myConn.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
					
					}
		            JOptionPane.showMessageDialog(f, "Registered Sucessfully");
		         
					
					new Entry_Screen();
		    f.dispose();
			}else {
	            JOptionPane.showMessageDialog(f, "PASSWORD MISMATCH");

				
			}
			 
			

		}	
	}

	}}
