package general;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Menu_staff  implements MouseListener{

	JButton EnterMarks=new JButton("ENTER MARKS");
	JButton UpdateMarks=new JButton("UPDATE MARKS");
	JButton Analysis=new JButton("SHOW ALL");
	private final JLabel lblNewLabel = new JLabel("MENU");
	private final JSeparator separator = new JSeparator();
	JFrame f=new JFrame();

	public Menu_staff() {
		f.getContentPane().setBackground(new Color(32, 178, 170));
        
		EnterMarks.setBounds(130,133,200, 50);
		EnterMarks.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		EnterMarks.setBackground(new Color(255, 255, 255));
		EnterMarks.setForeground(new Color(0, 128, 128));
		EnterMarks.addMouseListener(this);

		UpdateMarks.setBounds(130,223,200, 50);
		UpdateMarks.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		UpdateMarks.setBackground(Color.WHITE);
		UpdateMarks.setForeground(new Color(0, 128, 128));
		UpdateMarks.addMouseListener(this);


		Analysis.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

		Analysis.setBounds(130,316,200, 50);
		Analysis.setBackground(new Color(255, 255, 255));
		Analysis.setForeground(new Color(0, 128, 128));
		Analysis.addMouseListener(this);

		f.getContentPane().add(EnterMarks);
		f.getContentPane().add(UpdateMarks);

		f.getContentPane().add(Analysis);

		          
		f.setSize(514,500);  
		f.getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(189, 51, 79, 26);
		
		f.getContentPane().add(lblNewLabel);
		separator.setBounds(178, 87, 102, 2);
		
		f.getContentPane().add(separator);
		f.setVisible(true);
		
			}
	public static void main(String[] args) {
new Menu_staff();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==EnterMarks) {
			new student_det();
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
