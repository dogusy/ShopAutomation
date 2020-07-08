import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClerkPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClerkPanel frame = new ClerkPanel();
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
	public ClerkPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Breport = new JButton("Create Report");
		Breport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setVisible(false);
					Ccreate cr = new Ccreate();
					cr.setVisible(true);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		Breport.setBounds(81, 146, 185, 49);
		contentPane.add(Breport);
		
		JButton Bdemand = new JButton("Demand Product");
		Bdemand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Cdemand cd = new Cdemand();
					cd.setVisible(true);
				}catch(Exception d) {
					JOptionPane.showMessageDialog(null,d);
				}
			}
		});
		Bdemand.setBounds(81, 206, 185, 49);
		contentPane.add(Bdemand);
		
		JButton Bshow = new JButton("Show Market Inventory");
		Bshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Cshow cs = new Cshow();
					cs.setVisible(true);
				}catch(Exception s) {
					JOptionPane.showMessageDialog(null,s);
				}
			}
		});
		Bshow.setBounds(81, 266, 185, 49);
		contentPane.add(Bshow);
		
		JButton BView = new JButton("View Report");
		BView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cview cv=new Cview();
				cv.setVisible(true);
			}
		});
		BView.setBounds(81, 86, 185, 49);
		contentPane.add(BView);
		
		JButton Blogout = new JButton("Logout");
		Blogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		Blogout.setBounds(81, 326, 185, 49);
		contentPane.add(Blogout);
	}
}
