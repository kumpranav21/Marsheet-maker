package general;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class reg_staff implements ActionListener{
	JTextField Tname=new JTextField(); 
	JTextField Temail=new JTextField(); 
	JTextField Trno=new JTextField(); 
	Connection myConn;
	 Statement myStmt;
	String year[]={"FY","SY","TY"};        
	String course[]={"BSC","BCA","BCS","BBA","MCA","MCS","MBA"};        
	JFrame f=new JFrame();
	JButton Continue=new JButton("ADD STAFF");

    JComboBox cbClass=new JComboBox(year);    
    JComboBox cbCourse=new JComboBox(course);  
  JTextField Tsetpass;
   JTextField Tconpass;
    
    
	public reg_staff() {
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.setSize(825,454);  
		f.getContentPane().setLayout(null);
	       
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

		f.setVisible(true);
		JLabel Ltitle = new JLabel("REGISTER STAFF...");
		Ltitle.setForeground(new Color(255, 255, 255));
		Ltitle.setBounds(30,30, 650,30); 
		Ltitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));


		JLabel Lname = new JLabel("Name :-");
		Lname.setForeground(new Color(255, 255, 255));
		Lname.setBounds(30,114, 100,30); 
		Lname.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		
		Tname.setBounds(110,114, 200,30); 
		
		JLabel Lemail = new JLabel("Email :-");
		Lemail.setForeground(new Color(255, 255, 255));
		Lemail.setBounds(450,193, 100,30); 
		Lemail.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

		Temail.setBounds(537,197, 200,30); 
		
		JLabel Lclass = new JLabel("Class :-");
		Lclass.setForeground(new Color(255, 255, 255));
		Lclass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		Lclass.setBounds(30,193, 100,30); 

	    cbClass.setBounds(121, 196,60,30);     
	    JComboBox cbCourse=new JComboBox(course);    
	    cbCourse.setBounds(202, 196,108,30);     
		
		JLabel Lrno = new JLabel("ID :-");
		Lrno.setForeground(new Color(255, 255, 255));
		Lrno.setBounds(450,114, 100,30); 
		Lrno.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

		Trno.setBounds(537,114, 200,30); 
		Continue.setBackground(new Color(255, 255, 255));
		Continue.addActionListener(this);
		Continue.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		Continue.setBounds(313,351, 150,30); 


	


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
separator.setBounds(10, 70, 329, 2);
f.getContentPane().add(separator);
JLabel lblSetPassword = new JLabel("Set Password :-");
lblSetPassword.setForeground(Color.WHITE);
lblSetPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
lblSetPassword.setBounds(30, 269, 128, 30);
f.getContentPane().add(lblSetPassword);
JLabel lblConfirmPassword = new JLabel("Confirm Password :-");
lblConfirmPassword.setForeground(Color.WHITE);
lblConfirmPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
lblConfirmPassword.setBounds(450, 269, 165, 30);
f.getContentPane().add(lblConfirmPassword);
Tsetpass = new JTextField();
Tsetpass.setBounds(182, 273, 128, 30);
f.getContentPane().add(Tsetpass);
Tconpass = new JTextField();
Tconpass.setBounds(625, 273, 108, 30);
f.getContentPane().add(Tconpass);




		
		
	}

	public static void main(String[] args) {
new reg_staff();
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
		    		String sql = "INSERT INTO staff(id,name,email,year,course,pass) VALUES ('"+Trno.getText().toString()+"', '"+Tname.getText().toString()+"', '"+Temail.getText().toString()+"', '"+(String)cbClass.getSelectedItem()+"','"+(String)cbCourse.getSelectedItem()+"','"+Tsetpass.getText().toString()+"')";
					 
		            try {
					myStmt.executeUpdate(sql);
					 myConn.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
					
					}
		            JOptionPane.showMessageDialog(f, "Registered Sucessfully");
		         
					
					new Entry_Screen();
		    f.dispose();
				}
				else {
		            JOptionPane.showMessageDialog(f, "PASSWORD MISMATCH");

			
				}
				
	}

}
	}}
