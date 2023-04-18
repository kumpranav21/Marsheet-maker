package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Menu_Admin  implements MouseListener{
	JButton AddStaff=new JButton("ADD STAFF");
	JButton AddStud=new JButton("ADD STUDENT");
	JButton ShowAll=new JButton("SHOW ALL");
	private final JLabel lblNewLabel = new JLabel("MENU");
	private final JSeparator separator = new JSeparator();
	JFrame f=new JFrame();

	public Menu_Admin() {

		f.getContentPane().setBackground(new Color(32, 178, 170));
        
		AddStaff.setBounds(130,122,200, 50);
		AddStaff.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		AddStaff.setBackground(new Color(255, 255, 255));
		AddStaff.setForeground(new Color(0, 128, 128));
		AddStaff.addMouseListener(this);

		AddStud.setBounds(130,218,200, 50);
		AddStud.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		AddStud.setBackground(Color.WHITE);
		AddStud.setForeground(new Color(0, 128, 128));
		AddStud.addMouseListener(this);
		ShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});


		ShowAll.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		ShowAll.setBounds(130,310,200, 50);
		ShowAll.setBackground(new Color(255, 255, 255));
		ShowAll.setForeground(new Color(0, 128, 128));
		ShowAll.addMouseListener(this);

		f.getContentPane().add(AddStaff);
		f.getContentPane().add(AddStud);

		f.getContentPane().add(ShowAll);

		          
		f.setSize(514,500);  
		f.getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(179, 45, 85, 24);
		
		f.getContentPane().add(lblNewLabel);
		separator.setBounds(169, 79, 104, 2);
		
		f.getContentPane().add(separator);
		f.setVisible(true);
	}
	public static void main(String[] args) {
new Menu_Admin();

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()== AddStaff) {
			new reg_staff();
			f.dispose();
		}
		if(e.getSource()== AddStud) {
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
