import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AupdateUsers extends JFrame {
Connection connection=null;
	private JPanel contentPane;
	private JTable table;
	private JTextField Tid;
	private JTextField Taddress;
	private JTextField Trole;
	private JTextField Tmarket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AupdateUsers frame = new AupdateUsers();
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
	public AupdateUsers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 29, 743, 214);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 274, 54, 14);
		contentPane.add(lblNewLabel);
		
		Tid = new JTextField();
		Tid.setBounds(47, 271, 86, 20);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Adress");
		lblNewLabel_1.setBounds(168, 274, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(366, 274, 46, 14);
		contentPane.add(lblRole);
		
		JLabel lblNewLabel_2 = new JLabel("Market");
		lblNewLabel_2.setBounds(563, 274, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		Taddress = new JTextField();
		Taddress.setBounds(241, 271, 86, 20);
		contentPane.add(Taddress);
		Taddress.setColumns(10);
		
		Trole = new JTextField();
		Trole.setBounds(441, 271, 86, 20);
		contentPane.add(Trole);
		Trole.setColumns(10);
		
		Tmarket = new JTextField();
		Tmarket.setBounds(648, 271, 86, 20);
		contentPane.add(Tmarket);
		Tmarket.setColumns(10);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel ap=new AdminPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(44, 378, 89, 23);
		contentPane.add(Bback);
		
		JButton Bdelete = new JButton("Delete User");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
				String query="delete from WorkerInfo where ID= "+ Integer.parseInt(Tid.getText());
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(386, 378, 101, 23);
		contentPane.add(Bdelete);
		
		JButton Bupdate = new JButton("Update User");
		Bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
				String query="update WorkerInfo set Address='"+Taddress.getText()+"' ,Role='"+Trole.getText()+"' ,Sube='"+Tmarket.getText()+"' where ID='"+Integer.parseInt(Tid.getText())+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				pst.close();
				}catch(Exception ab) {
					
				}
			}
		});
		Bupdate.setBounds(597, 378, 112, 23);
		contentPane.add(Bupdate);
		
		JButton Bload = new JButton("Load Users");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Manager m=new Manager();
				try {
					String query="select * from WorkerInfo";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception a) {
					
				
			}
			}
		});
		Bload.setBounds(216, 378, 101, 23);
		contentPane.add(Bload);
	}

}
