package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Log_Student implements MouseListener{
    JButton Res=new JButton("View Result");
    JLabel Lreg= new JLabel("Register? Click Here..");
	JFrame f=new JFrame();
	 JTextField Tpass;
	public static JTextField Trno=new JTextField(); 

	Connection myConn;
	 Statement myStmt;
	public Log_Student(){
		f.getContentPane().setBackground(new Color(32, 178, 170));

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

		f.setSize(582,377);  
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		String Class[]={"FY","SY","TY"};        
		String course[]={"BSC","BCA","BCS","BBA","MCA","MCS","MBA"};        


		JLabel Lrno = new JLabel("Roll no :-");
		Lrno.setForeground(new Color(255, 255, 255));
		Lrno.setBounds(100,93, 100,30); 
		Lrno.setFont(new Font("Arial", Font.PLAIN, 20));
		
		Trno.setBounds(224,93, 200,30); 
		

		JLabel Lclass = new JLabel("Password  :-");
		Lclass.setForeground(new Color(255, 255, 255));
		Lclass.setBounds(100,150, 125,30); 
		Lclass.setFont(new Font("Arial", Font.PLAIN, 20));
		    Res.setBackground(new Color(255, 255, 255));
			 
		    Res.setFont(new Font("Arial", Font.PLAIN, 15));
		    Res.setBounds(168,223,150, 35);
		    Res.addMouseListener(this);

		    Lreg.setBounds(168,268, 200,30); 
		    Lreg.setFont(new Font("Arial", Font.PLAIN, 16));
		    Lreg.setForeground(new Color(255, 222, 173));
		    Lreg.addMouseListener(this);
		
		
		f.getContentPane().add(Lrno);
		f.getContentPane().add(Trno);
		f.getContentPane().add(Res);
		f.getContentPane().add(Lreg);
		f.getContentPane().add(Lclass);
		
		JLabel lblNewLabel = new JLabel("STUDENT LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(32, 13, 214, 26);
		f.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 41, 214, 9);
		f.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(159, 302, 166, 9);
		f.getContentPane().add(separator_1);
		
		Tpass = new JTextField();
		Tpass.setBounds(224, 150, 200, 30);
		f.getContentPane().add(Tpass);


	
		
	}

	public static void main(String[] args) {

		new Log_Student();
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource()== Res) {
			String sql = "SELECT * FROM student WHERE rno = '"+Trno.getText().toString()+"' and pass = '"+Tpass.getText().toString()+"'";
			 
	           
		
			try {
				ResultSet rs = myStmt.executeQuery(sql);

				if(!rs.isBeforeFirst() && rs.getRow() == 0)
				{
					 JOptionPane.showMessageDialog(f, "Please Provide Correct Details!");

				}
				else {
					 JOptionPane.showMessageDialog(f, "Login Sucessfull !");
				     
						
						new marksheet();
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
		if(e.getSource()== Lreg) {
			new reg_student();
			f.dispose();
			
		}	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()== Lreg) {
		    Lreg.setForeground(Color.RED);

		}			
	}

	@Override
	public void mouseExited(MouseEvent e) {
	    Lreg.setForeground(Color.BLUE);
		
	}

}
