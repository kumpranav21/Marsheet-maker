package general;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Enter_Marks implements ActionListener{
	JFrame f=new JFrame();
	 JTextField E1;
	 JTextField P1;
	 JTextField J1;
	 JTextField M1;
	 JTextField EL1;
	 JTextField EN1;
	 JTextField E2;
	 JTextField P2;
	 JTextField J2;
	 JTextField M2;
	 JTextField EL2;
	 JTextField EN2;
	JLabel ENGLISH = new JLabel("ENGLISH");
	JLabel PYTHON = new JLabel("PYTHON");
	JLabel JAVA = new JLabel("JAVA");
	JLabel MATH = new JLabel("MATH");
	JLabel ELECTRONICS = new JLabel("ELECTRONICS");
	JLabel ENVIRONMENT = new JLabel("ENVIRONMENT");

	Connection myConn;
	 Statement myStmt;
	 JButton ConFmarks = new JButton("CONFIRM MARKS");
	public Enter_Marks() {
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.getContentPane().setForeground(new Color(32, 178, 170));
		f.setSize(932,799);  
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
    
		JLabel lblNewLabel = new JLabel("ENTER MARKS....");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(364, 20, 220, 26);
		f.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(344, 56, 231, 2);
		f.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("SUBJECT");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(56, 133, 110, 21);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("INTERNAL");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(378, 133, 125, 21);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("EXTERNAL");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(669, 133, 131, 21);
		f.getContentPane().add(lblNewLabel_1_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 153, 797, 12);
		f.getContentPane().add(separator_1);
		
		ENGLISH.setBackground(new Color(255, 255, 255));
		ENGLISH.setForeground(new Color(255, 255, 255));
		ENGLISH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ENGLISH.setBounds(56, 205, 103, 21);
		f.getContentPane().add(ENGLISH);
		
		PYTHON.setForeground(new Color(255, 255, 255));
		PYTHON.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PYTHON.setBounds(56, 271, 103, 21);
		f.getContentPane().add(PYTHON);
		
		JAVA.setForeground(new Color(255, 255, 255));
		JAVA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JAVA.setBounds(56, 335, 103, 21);
		f.getContentPane().add(JAVA);
		
		MATH.setForeground(new Color(255, 255, 255));
		MATH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		MATH.setBounds(56, 398, 103, 21);
		f.getContentPane().add(MATH);
		
		ELECTRONICS.setForeground(new Color(255, 255, 255));
		ELECTRONICS.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ELECTRONICS.setBounds(56, 470, 157, 21);
		f.getContentPane().add(ELECTRONICS);
		
		ENVIRONMENT.setForeground(new Color(255, 255, 255));
		ENVIRONMENT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ENVIRONMENT.setBounds(56, 542, 157, 21);
		f.getContentPane().add(ENVIRONMENT);
		
		E1 = new JTextField();
		E1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		E1.setBounds(378, 194, 136, 32);
		f.getContentPane().add(E1);
		E1.setColumns(10);
		
		P1 = new JTextField();
		P1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		P1.setColumns(10);
		P1.setBounds(378, 260, 136, 32);
		f.getContentPane().add(P1);
		
		J1 = new JTextField();
		J1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		J1.setColumns(10);
		J1.setBounds(378, 324, 136, 32);
		f.getContentPane().add(J1);
		
		M1 = new JTextField();
		M1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		M1.setColumns(10);
		M1.setBounds(378, 387, 136, 32);
		f.getContentPane().add(M1);
		
		EL1 = new JTextField();
		EL1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EL1.setColumns(10);
		EL1.setBounds(378, 459, 136, 32);
		f.getContentPane().add(EL1);
		
		EN1 = new JTextField();
		EN1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EN1.setColumns(10);
		EN1.setBounds(378, 531, 136, 32);
		f.getContentPane().add(EN1);
		
		E2 = new JTextField();
		E2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		E2.setColumns(10);
		E2.setBounds(664, 194, 136, 32);
		f.getContentPane().add(E2);
		
		P2 = new JTextField();
		P2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		P2.setColumns(10);
		P2.setBounds(664, 260, 136, 32);
		f.getContentPane().add(P2);
		
		J2 = new JTextField();
		J2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		J2.setColumns(10);
		J2.setBounds(664, 324, 136, 32);
		f.getContentPane().add(J2);
		
		M2 = new JTextField();
		M2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		M2.setColumns(10);
		M2.setBounds(664, 387, 136, 32);
		f.getContentPane().add(M2);
		
		EL2 = new JTextField();
		EL2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EL2.setColumns(10);
		EL2.setBounds(664, 459, 136, 32);
		f.getContentPane().add(EL2);
		
		EN2 = new JTextField();
		EN2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EN2.setColumns(10);
		EN2.setBounds(664, 531, 136, 32);
		f.getContentPane().add(EN2);
		
		
		ConFmarks.setBackground(new Color(255, 255, 255));
		ConFmarks.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		ConFmarks.setBounds(364, 706, 178, 40);
		f.getContentPane().add(ConFmarks);
		ConFmarks.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("NOTE  :-");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(69, 647, 80, 21);
		f.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Marks entered should not exceed 20.");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(157, 647, 313, 21);
		f.getContentPane().add(lblNewLabel_2_1);
		f.setVisible(true);
	}

	public static void main(String[] args) {
new Enter_Marks();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String Eng_I = E1.getText().toString();
		String Eng_E = E2.getText().toString();
		
		String Pyth_I = P1.getText().toString();
		String Pyth_E = P2.getText().toString();
		
		String Java_I = J1.getText().toString();
		String Java_E = J2.getText().toString();
		
		String Math_I = M1.getText().toString();
		String Math_E = M2.getText().toString();
		
		String Elec_I = EL1.getText().toString();
		String ELec_E = EL2.getText().toString();
		
		String Envrn_I = EN1.getText().toString();
		String Envrn_E = EN2.getText().toString();
		
		
	    String Rno = student_det.Rno.getText().toString();
	    
		
		if(e.getSource()== ConFmarks) {
			
			if(Eng_I.equals("")||Eng_E.equals("")||Pyth_I.equals("") || Pyth_E.equals("")
					||Java_I.equals("") ||Java_E.equals("") ||Math_I.equals("") 
					||Math_E.equals("") ||Elec_I.equals("") ||ELec_E.equals("") ||Envrn_I.equals("")
					||Envrn_E.equals(""))
			{
	            JOptionPane.showMessageDialog(f, "Please Provide All Marks");

			}
			else {
				if(Integer.parseInt(Eng_I)>20 || Integer.parseInt(Eng_E)>20 
						|| Integer.parseInt(Pyth_I)>20 || Integer.parseInt(Pyth_E)>20 || Integer.parseInt(Java_I)>20 
						|| Integer.parseInt(Java_E)>20 || Integer.parseInt(Math_I)>20 || Integer.parseInt(Math_E)>20 
						|| Integer.parseInt(Elec_I)>20 || Integer.parseInt(ELec_E)>20
						|| Integer.parseInt(Envrn_I)>20 || Integer.parseInt(Envrn_E)>20 ) {
					
					
					
		            JOptionPane.showMessageDialog(f, "Some of Marks exceeded 20");

					
					
				}
				else if(Integer.parseInt(Eng_I)<0 || Integer.parseInt(Eng_E)<0 
						|| Integer.parseInt(Pyth_I)<0 || Integer.parseInt(Pyth_E)<0 || Integer.parseInt(Java_I)<0
						|| Integer.parseInt(Java_E)<0 || Integer.parseInt(Math_I)<0 || Integer.parseInt(Math_E)<0 
						|| Integer.parseInt(Elec_I)<0 || Integer.parseInt(ELec_E)<0
						|| Integer.parseInt(Envrn_I)<0|| Integer.parseInt(Envrn_E)<0 ) {
					
					
					
		            JOptionPane.showMessageDialog(f, "Some of Marks is less than 0");

					
					
				}
				else {
					
		    		//String sql = "INSERT INTO marks(Rno,name,email,Year,course,pass) VALUES ('"+Trno.getText().toString()+"', '"+Tname.getText().toString()+"', '"+Temail.getText().toString()+"', '"+(String)cbClass.getSelectedItem()+"','"+(String)cbCourse.getSelectedItem()+"','"+Tsetpass.getText().toString()+"')";
					 
		        try {
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('ENGLISH', '"+Eng_I+"', '"+Eng_E+"', '"+Rno+"')");
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('PYTHON', '"+Pyth_I+"', '"+Pyth_E+"', '"+Rno+"')");
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('JAVA', '"+Java_I+"', '"+Java_E+"', '"+Rno+"')");
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('ELECTRONICS', '"+Elec_I+"', '"+ELec_E+"', '"+Rno+"')");
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('ENVIRONMENT', '"+Envrn_I+"', '"+Envrn_E+"', '"+Rno+"')");
			myStmt.executeUpdate("INSERT INTO marks(subject,internal,external,rno) VALUES ('MATH', '"+Math_I+"', '"+Math_E+"', '"+Rno+"')");
					 myConn.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
					
					}
		            JOptionPane.showMessageDialog(f, "Marks Added Successfully for Roll no : "+Rno);
		         
					
					new Entry_Screen();
		    f.dispose();
			}
			 
			

		}	
	}
	}
}
