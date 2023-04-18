package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class Log_Staff implements ActionListener{
    JButton Res=new JButton("LOGIN");
	JFrame f=new JFrame();
	JTextField Trno=new JTextField(); 
	JTextField Tpass=new JTextField(); 

	Connection myConn;
	 Statement myStmt;
	public Log_Staff() {
		f.getContentPane().setBackground(new Color(32, 178, 170));
		
		f.setSize(650,350);  
		f.getContentPane().setLayout(null);
		f.setVisible(true);

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

		JLabel Lrno = new JLabel("ID :-");
		Lrno.setForeground(new Color(255, 255, 255));
		Lrno.setBounds(130,105, 100,30); 
		Lrno.setFont(new Font("Arial", Font.PLAIN, 20));
		
		Trno.setBounds(289,109, 200,30); 
		

		JLabel Lclass = new JLabel("Password :-");
		Lclass.setForeground(new Color(255, 255, 255));
		Lclass.setBounds(130,164, 130,30); 
		Lclass.setFont(new Font("Arial", Font.PLAIN, 20));
		
		Tpass.setBounds(289,164, 200,30); 
		    Res.setBackground(new Color(255, 255, 255));
		
		    Res.setFont(new Font("Arial", Font.PLAIN, 15));
		    Res.setBounds(206,241,150, 35);
		    Res.addActionListener(this);
		
		f.getContentPane().add(Lrno);
		f.getContentPane().add(Trno);
		f.getContentPane().add(Res);
		f.getContentPane().add(Tpass);

		f.getContentPane().add(Lclass);
		
		JLabel lblNewLabel = new JLabel("STAFF LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(31, 20, 164, 26);
		f.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 47, 180, 2);
		f.getContentPane().add(separator);

		
		
	}

	public static void main(String[] args) {

		new Log_Staff();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Res) {
			String sql = "SELECT * FROM staff WHERE id = '"+Trno.getText().toString()+"' and pass = '"+Tpass.getText().toString()+"'";
			 
	           
			
			
	           
			try {
				ResultSet rs = myStmt.executeQuery(sql);

				if(!rs.isBeforeFirst() && rs.getRow() == 0)
				{
					 JOptionPane.showMessageDialog(f, "Please Provide Correct Details!");

				}
				else {
					 JOptionPane.showMessageDialog(f, "Login Sucessfull !");
				     
						
						new Menu_staff();
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
