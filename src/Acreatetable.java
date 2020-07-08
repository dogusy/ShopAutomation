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

public class Acreatetable extends JFrame {
	Connection connection=null;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private JTextField Tproduct;
	private JTextField Tcount;
	private JTextField Tdate;
	private JButton Bshow;
	private JButton Bdelete;
	private JButton Bback;
	private JLabel lblProduct_1;
	private JLabel lblCount;
	private JLabel lblPrice;
	private JLabel lblProduct_2;
	private JLabel lblGoalcount;
	private JLabel lblGoaldate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acreatetable frame = new Acreatetable();
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
	public Acreatetable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 32, 440, 239);
		contentPane.add(table);
		
		table2 = new JTable();
		table2.setBounds(460, 32, 272, 366);
		contentPane.add(table2);
		
		JButton Bload = new JButton("Load Inventory");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try{
					
				String query="select * from Inventory";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		
				}
				catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(236, 282, 143, 23);
		contentPane.add(Bload);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(10, 296, 46, 14);
		contentPane.add(lblProduct);
		
		JLabel lblGoalCount = new JLabel("Goal Count");
		lblGoalCount.setBounds(10, 339, 72, 14);
		contentPane.add(lblGoalCount);
		
		JLabel lblGoalDate = new JLabel("Goal Date");
		lblGoalDate.setBounds(10, 384, 72, 14);
		contentPane.add(lblGoalDate);
		
		Tproduct = new JTextField();
		Tproduct.setBounds(102, 293, 86, 20);
		contentPane.add(Tproduct);
		Tproduct.setColumns(10);
		
		Tcount = new JTextField();
		Tcount.setBounds(102, 336, 86, 20);
		contentPane.add(Tcount);
		Tcount.setColumns(10);
		
		Tdate = new JTextField();
		Tdate.setBounds(102, 378, 86, 20);
		contentPane.add(Tdate);
		Tdate.setColumns(10);
		
		JButton Bupdate = new JButton("Update Goals");
		Bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				
				try{
					String query="insert into Goals(Product,GoalCount,GoalDate)  values(?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, Tproduct.getText());
					pst.setInt(2, Integer.parseInt(Tcount.getText()));
					pst.setString(3, Tdate.getText());
					
					pst.execute();

					pst.close();
			
					}
					catch(Exception ab) {
						
					}
				
			}
		});
		Bupdate.setBounds(236, 316, 143, 23);
		contentPane.add(Bupdate);
		
		Bshow = new JButton("Show Goals");
		Bshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection=sqliteConnection.dbConnector();
				try {
				
				String query="select * from Goals";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table2.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception ab) {
					
				}
			}
		});
		Bshow.setBounds(236, 350, 143, 23);
		contentPane.add(Bshow);
		
		Bdelete = new JButton("Delete Goal");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="delete from Goals where Product='"+Tproduct.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					
				}catch(Exception ab) {
					
				}
			}
		});
		Bdelete.setBounds(236, 380, 143, 23);
		contentPane.add(Bdelete);
		
		Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel ap=new AdminPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(235, 407, 144, 23);
		contentPane.add(Bback);
		
		lblProduct_1 = new JLabel("Product");
		lblProduct_1.setBounds(59, 7, 54, 14);
		contentPane.add(lblProduct_1);
		
		lblCount = new JLabel("Count");
		lblCount.setBounds(203, 7, 46, 14);
		contentPane.add(lblCount);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(333, 7, 46, 14);
		contentPane.add(lblPrice);
		
		lblProduct_2 = new JLabel("Product");
		lblProduct_2.setBounds(496, 7, 46, 14);
		contentPane.add(lblProduct_2);
		
		lblGoalcount = new JLabel("GoalCount");
		lblGoalcount.setBounds(567, 7, 61, 14);
		contentPane.add(lblGoalcount);
		
		lblGoaldate = new JLabel("GoalDate");
		lblGoaldate.setBounds(662, 7, 46, 14);
		contentPane.add(lblGoaldate);
	}

}
