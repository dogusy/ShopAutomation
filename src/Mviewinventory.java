import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Mviewinventory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection connection=null;
	private JTextArea textArea;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mviewinventory frame = new Mviewinventory();
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
	public Mviewinventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(30, 21, 315, 236);
		contentPane.add(table);
		
		JButton Bload = new JButton("Load Inventory");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Manager m= new Manager();
				try{
					String query=m.ViewAllInvent();
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		
				}
				catch(Exception a) {
					
				}
				
				
			}
		});
		Bload.setBounds(10, 296, 139, 23);
		contentPane.add(Bload);
		
		JButton Bsave = new JButton("Save List");
		Bsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				
				try {
					String query="update UrunDagýt set List = '"+textArea.getText()+"' where ID ='"+1+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bsave.setBounds(10, 330, 139, 23);
		contentPane.add(Bsave);
		
		JButton Bget = new JButton("Get List");
		Bget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="select List from UrunDagýt ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					textArea.setText(rs.getString("List"));
					
					
				pst.close();
				rs.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bget.setBounds(10, 364, 139, 23);
		contentPane.add(Bget);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPanel mp=new ManagerPanel();
				mp.setVisible(true);
			}
		});
		Bback.setBounds(10, 398, 139, 23);
		contentPane.add(Bback);
		
		 textArea = new JTextArea();
		textArea.setBounds(159, 284, 506, 108);
		contentPane.add(textArea);
		
		table_1 = new JTable();
		table_1.setBounds(353, 21, 335, 229);
		contentPane.add(table_1);
		
		JButton Bdemand = new JButton("Get Demand List");
		Bdemand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="select * from DemandProduct ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception a) {
					
				}
				
			}
		});
		Bdemand.setBounds(10, 262, 139, 23);
		contentPane.add(Bdemand);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(40, 0, 56, 14);
		contentPane.add(lblProduct);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(150, 0, 46, 14);
		contentPane.add(lblCount);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(263, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProduct_1 = new JLabel("Product");
		lblProduct_1.setBounds(351, 0, 46, 14);
		contentPane.add(lblProduct_1);
		
		JLabel lblCount_1 = new JLabel("Count");
		lblCount_1.setBounds(445, 0, 46, 14);
		contentPane.add(lblCount_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(544, 0, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Place");
		lblNewLabel_1.setBounds(619, 0, 46, 14);
		contentPane.add(lblNewLabel_1);
	}

}
