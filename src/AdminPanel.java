import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bupdate = new JButton("Register Requests");
		Bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Aupdate au = new Aupdate();
					au.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bupdate.setBounds(108, 123, 147, 38);
		contentPane.add(Bupdate);
		
		JButton Bcreate = new JButton("Create Table");
		Bcreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Acreatetable ac = new Acreatetable();
					ac.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bcreate.setBounds(108, 172, 147, 38);
		contentPane.add(Bcreate);
		
		JButton Bview = new JButton("View Feedback");
		Bview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Ashowfeedback as = new Ashowfeedback();
					as.setVisible(true);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		Bview.setBounds(108, 221, 147, 38);
		contentPane.add(Bview);
		
		JButton Bgive = new JButton("Give Feedback");
		Bgive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					GiveFeedback gf=new GiveFeedback();
					gf.setVisible(true);
					
				}catch(Exception a) {
					
				}
			}
		});
		Bgive.setBounds(108, 270, 147, 38);
		contentPane.add(Bgive);
		
		JButton Buser = new JButton("Update Users");
		Buser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					AupdateUsers au= new AupdateUsers();
					au.setVisible(true);
				}catch(Exception a) {
					
				}
			}
		});
		Buser.setBounds(108, 65, 147, 38);
		contentPane.add(Buser);
		
		JButton Blogout = new JButton("Logout");
		Blogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		Blogout.setBounds(108, 324, 147, 38);
		contentPane.add(Blogout);
	}

}
