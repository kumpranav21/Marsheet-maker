package general;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;

public class Log_admin implements ActionListener{
    JButton Res=new JButton("LOGIN");
	JFrame f=new JFrame("LOGIN");
	private final JLabel lblNewLabel = new JLabel("PRINCIPAL LOGIN");
	private final JSeparator separator = new JSeparator();
	private JTextField Tuser;
	
	Connection myConn;
	 Statement myStmt;
	 
	JTextField Tpass=new JTextField(); 

	public Log_admin()
	{
		
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.setSize(571,353);  
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

		JLabel Lclass = new JLabel("Password :-");
		Lclass.setForeground(new Color(255, 255, 255));
		Lclass.setBackground(new Color(70, 130, 180));
		Lclass.setBounds(92,156, 130,30); 
		Lclass.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		
		Tpass.setBounds(250,156, 200,30); 
		
		
		    Res.setForeground(new Color(70, 130, 180));
		    Res.setBackground(new Color(255, 255, 255));
		    Res.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
		    Res.setBounds(187,232,150, 35);
		    Res.addActionListener(this);
		 
		
		
		f.getContentPane().add(Res);
		f.getContentPane().add(Tpass);

		f.getContentPane().add(Lclass);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 21, 192, 27);
		
		f.getContentPane().add(lblNewLabel);
		separator.setBounds(10, 46, 202, 2);
		
		f.getContentPane().add(separator);
		
		JLabel lblUsername = new JLabel("UserName :-");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		lblUsername.setBackground(new Color(70, 130, 180));
		lblUsername.setBounds(92, 95, 130, 30);
		f.getContentPane().add(lblUsername);
		
		Tuser = new JTextField();
		Tuser.setBounds(250, 95, 200, 30);
		f.getContentPane().add(Tuser);


		
		
	}

	public static void main(String[] args) {

		new Log_admin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String UserName = Tuser.getText().toString();
		String Password= Tpass.getText().toString();
		
		if(e.getSource()== Res) {
			
			String sql = "SELECT * FROM admin WHERE name = '"+UserName+"' and pass = '"+Password+"'";
			 
           
			
		
           
			try {
				ResultSet rs = myStmt.executeQuery(sql);

				if(!rs.isBeforeFirst() && rs.getRow() == 0)
				{
					 JOptionPane.showMessageDialog(f, "Please Provide Correct Details!");

				}
				else {
					 JOptionPane.showMessageDialog(f, "Login Sucessfull !");
				     
						
						new Menu_Admin();
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
