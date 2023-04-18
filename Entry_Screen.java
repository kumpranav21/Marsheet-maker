package general;
import java.awt.Color;
import java.sql.*; 
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;  
public class Entry_Screen  implements MouseListener{  
	  JButton Principal=new JButton("PRINCIPAL");
		JButton Staff=new JButton("STAFF");
		JButton Student=new JButton("STUDENT");
		JFrame f=new JFrame();

	public Entry_Screen() {
		
		
		f.getContentPane().setBackground(new Color(32, 178, 170));
        
		Principal.setBounds(130,100,200, 50);
		Principal.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		Principal.setBackground(new Color(255, 255, 255));
		Principal.setForeground(new Color(0, 128, 128));
		Principal.addMouseListener(this);

		Staff.setBounds(130,190,200, 50);
		Staff.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		Staff.setBackground(new Color(255, 255, 255));
		Staff.setForeground(new Color(0, 128, 128));
		Staff.addMouseListener(this);


		Student.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		Student.setBounds(130,280,200, 50);
		Student.setBackground(new Color(255, 255, 255));
		Student.setForeground(new Color(0, 128, 128));
		Student.addMouseListener(this);

		f.getContentPane().add(Principal);
		f.getContentPane().add(Staff);

		f.getContentPane().add(Student);

		          
		f.setSize(500,500);  
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT USER MODE:-");
		lblNewLabel.setBackground(new Color(64, 224, 208));
		lblNewLabel.setForeground(new Color(255, 248, 220));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(114, 25, 264, 31);
		f.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(83, 55, 304, 8);
		f.getContentPane().add(separator);
		f.setVisible(true);
		
		
		
	}
	

	
public static void main(String[] args) {  
	new Entry_Screen();
	
}

@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==Principal) {
		new Log_admin();
		f.dispose();
	}
if(e.getSource()==Staff) {
		new Log_Staff();
		f.dispose();
	}
if(e.getSource()==Student) {
	new Log_Student();
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
	
		
		((JComponent) e.getSource()).setBackground(new Color(255, 235, 205));
	
}

@Override
public void mouseExited(MouseEvent e) {

		
	((JComponent) e.getSource()).setBackground(new Color(255, 255, 255));
	((JComponent) e.getSource()).setForeground(new Color(0, 128, 128));		
}  
}  