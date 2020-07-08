import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Aupdate extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Tid;
	Connection connection=null;
	private JTextField Tname;
	private JTextField Tnewid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aupdate frame = new Aupdate();
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
	public Aupdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 27, 664, 252);
		contentPane.add(table);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel ap= new AdminPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(10, 331, 89, 23);
		contentPane.add(Bback);
		
		JButton Bupdate = new JButton("Update User");
		Bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Admin a= new Admin();
				try {
					a.updateUser(Integer.parseInt(Tid.getText()));
				
				}catch(Exception c) {
					
				}
			}
		});
		Bupdate.setBounds(565, 331, 109, 23);
		contentPane.add(Bupdate);
		
		JLabel Lid = new JLabel("ID");
		Lid.setBounds(171, 321, 46, 14);
		contentPane.add(Lid);
		
		Tid = new JTextField();
		Tid.setBounds(259, 318, 86, 20);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JButton Bget = new JButton("Get Users");
		Bget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Admin a= new Admin();
				try {
					PreparedStatement pst=connection.prepareStatement(a.getRegisterRecords());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception c) {
					
				}
				
			}
		});
		Bget.setBounds(446, 298, 109, 23);
		contentPane.add(Bget);
		
		JButton Bdelete = new JButton("Delete User");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				
				try{String query2="delete from updateClerk where ID= '"+Integer.parseInt(Tid.getText())+"'";
				PreparedStatement pst2=connection.prepareStatement(query2);
				pst2.execute();
				pst2.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(565, 297, 109, 23);
		contentPane.add(Bdelete);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(171, 290, 46, 14);
		contentPane.add(lblName);
		
		Tname = new JTextField();
		Tname.setBounds(259, 290, 86, 20);
		contentPane.add(Tname);
		Tname.setColumns(10);
		
		JButton Bedit = new JButton("Edit User");
		Bedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="update updateClerk set Name='"+Tname.getText()+"' , ID='"+Integer.parseInt(Tnewid.getText())+"' where ID='"+Integer.parseInt(Tid.getText())+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
				}catch(Exception ab) {
					
				}
			}
		});
		Bedit.setBounds(446, 331, 109, 23);
		contentPane.add(Bedit);
		
		JLabel lblNewId = new JLabel("New ID");
		lblNewId.setBounds(171, 346, 46, 14);
		contentPane.add(lblNewId);
		
		Tnewid = new JTextField();
		Tnewid.setBounds(259, 349, 86, 20);
		contentPane.add(Tnewid);
		Tnewid.setColumns(10);
	}
}
