import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ccreate extends JFrame {

	private JPanel contentPane;
	private JTextArea Areport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ccreate frame = new Ccreate();
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
	public Ccreate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BSave = new JButton("Send");
		BSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clerk  c= new Clerk();
				User u= new User();
				c.report=Areport.getText();
				try {
					
					c.sendreport();
				u.getSube();
				}catch(Exception a){
					
				}
			}
		});
		BSave.setBounds(435, 329, 89, 23);
		contentPane.add(BSave);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkPanel cp=new ClerkPanel();
				cp.setVisible(true);
			}
		});
		Bback.setBounds(130, 329, 89, 23);
		contentPane.add(Bback);
		
		 Areport = new JTextArea();
		Areport.setBounds(121, 57, 403, 211);
		contentPane.add(Areport);
	}
}
