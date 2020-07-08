import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPanel frame = new ManagerPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bview = new JButton("View Report Clerk");
		Bview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Mviewreport vr = new Mviewreport();
					vr.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bview.setBounds(77, 97, 143, 42);
		contentPane.add(Bview);
		
		JButton Bcreate = new JButton("Create Report");
		Bcreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Mcreatereport cr = new Mcreatereport();
					cr.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bcreate.setBounds(77, 150, 143, 35);
		contentPane.add(Bcreate);
		
		JButton Bassign = new JButton("Assign Table");
		Bassign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Massigntable at = new Massigntable();
					at.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bassign.setBounds(77, 196, 143, 29);
		contentPane.add(Bassign);
		
		JButton Býnventory = new JButton("View Inventory");
		Býnventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Mviewinventory vi = new Mviewinventory();
					vi.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Býnventory.setBounds(77, 236, 143, 35);
		contentPane.add(Býnventory);
		
		JButton Badmin = new JButton("View Report Admin");
		Badmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Madminfeedback ma=new Madminfeedback();
					ma.setVisible(true);
				}catch(Exception a) {
					
				}
			}
		});
		Badmin.setBounds(77, 44, 143, 42);
		contentPane.add(Badmin);
		
		JButton Bgoal = new JButton("Goals");
		Bgoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			Mangoals ag=new Mangoals();
			ag.setVisible(true);
			}
		});
		Bgoal.setBounds(77, 282, 143, 35);
		contentPane.add(Bgoal);
		
		JButton Blogout = new JButton("Logout");
		Blogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		Blogout.setBounds(77, 328, 143, 35);
		contentPane.add(Blogout);
	}
}
