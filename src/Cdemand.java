import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Cdemand extends JFrame {

	private JPanel contentPane;
	Connection connection=null;	
	private JTable table;
	private JTextField Tid;
	private JTextField Tproduct;
	private JTextField Tcount;
	private JTextField Tplace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cdemand frame = new Cdemand();
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
	public Cdemand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 321, 297, 123);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="select List from DemandProductList ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					textArea.setText(rs.getString("List"));
					
					
				pst.close();
				rs.close();
				}catch(Exception a) {
					
				}
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(textArea);
		
		JButton Bsavelist = new JButton("Save List");
		Bsavelist.setBounds(317, 353, 126, 33);
		Bsavelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="update DemandProductList set List = '"+textArea.getText()+"' where ID = '"+1+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		contentPane.add(Bsavelist);
		
		table = new JTable();
		table.setBounds(10, 22, 230, 294);
		contentPane.add(table);
		
		JLabel Lid = new JLabel("ID");
		Lid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lid.setBounds(261, 40, 60, 14);
		contentPane.add(Lid);
		
		Tid = new JTextField();
		Tid.setBounds(331, 39, 138, 33);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JLabel Lproduct = new JLabel("Product");
		Lproduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lproduct.setBounds(250, 103, 71, 20);
		contentPane.add(Lproduct);
		
		Tproduct = new JTextField();
		Tproduct.setBounds(331, 99, 138, 33);
		contentPane.add(Tproduct);
		Tproduct.setColumns(10);
		
		JLabel Lcount = new JLabel("Count");
		Lcount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lcount.setBounds(250, 166, 71, 20);
		contentPane.add(Lcount);
		
		Tcount = new JTextField();
		Tcount.setBounds(331, 162, 138, 33);
		contentPane.add(Tcount);
		Tcount.setColumns(10);
		
		JButton Bload = new JButton("Load Table");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try{
					
				String query="select * from DemandProduct";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		
				}
				catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(250, 256, 106, 23);
		contentPane.add(Bload);
		
		JButton Binsert = new JButton("Update");
		Binsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Clerk c=new Clerk();
				try {
					c.demandProduct(Tproduct.getText(), Integer.parseInt(Tcount.getText()),Tplace.getText(),Integer.parseInt(Tid.getText()));
				
				}catch(Exception a) {
					
				}
			}
		});
		Binsert.setBounds(250, 290, 97, 20);
		contentPane.add(Binsert);
		
		JButton Bdelete = new JButton("Delete");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="delete from DemandProduct where ID= '"+Integer.parseInt(Tid.getText())+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(366, 256, 113, 23);
		contentPane.add(Bdelete);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClerkPanel cp=new ClerkPanel();
				dispose();
				cp.setVisible(true);
			}
		});
		Bback.setBounds(376, 289, 93, 23);
		contentPane.add(Bback);
		
		JLabel Lplace = new JLabel("Place");
		Lplace.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lplace.setBounds(250, 222, 46, 14);
		contentPane.add(Lplace);
		
		Tplace = new JTextField();
		Tplace.setBounds(331, 221, 138, 24);
		contentPane.add(Tplace);
		Tplace.setColumns(10);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(10, -3, 46, 14);
		contentPane.add(lblProduct);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(81, -3, 46, 14);
		contentPane.add(lblCount);
		
		JLabel lblPrice = new JLabel("ID");
		lblPrice.setBounds(131, -3, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setBounds(187, -3, 46, 14);
		contentPane.add(lblPlace);
	}
}
