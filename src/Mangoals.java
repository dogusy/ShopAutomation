import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Mangoals extends JFrame {
Connection connection=null;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private JTable table3;
	private JTextField Tmarket;
	private JTextField Tcount;
	private JTextField Tdate;
	private JTextField Tproduct;
	private JLabel lblProduct_1;
	private JLabel lblCount;
	private JLabel lblSell;
	private JLabel lblGoalCount_1;
	private JLabel lblPrice;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCount_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblGoalCount_2;
	private JLabel lblGoalDate_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mangoals frame = new Mangoals();
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
	public Mangoals() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 36, 529, 203);
		contentPane.add(table);
		
		table2 = new JTable();
		table2.setBounds(549, 36, 231, 227);
		contentPane.add(table2);
		
		table3 = new JTable();
		table3.setBounds(10, 265, 529, 181);
		contentPane.add(table3);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setBounds(549, 274, 46, 14);
		contentPane.add(lblMarket);
		
		JLabel lblGoalCount = new JLabel("Goal Count");
		lblGoalCount.setBounds(549, 299, 67, 14);
		contentPane.add(lblGoalCount);
		
		JLabel lblGoalDate = new JLabel("Goal Date");
		lblGoalDate.setBounds(549, 324, 67, 14);
		contentPane.add(lblGoalDate);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(549, 349, 46, 14);
		contentPane.add(lblProduct);
		
		Tmarket = new JTextField();
		Tmarket.setBounds(666, 274, 86, 20);
		contentPane.add(Tmarket);
		Tmarket.setColumns(10);
		
		Tcount = new JTextField();
		Tcount.setBounds(666, 299, 86, 20);
		contentPane.add(Tcount);
		Tcount.setColumns(10);
		
		Tdate = new JTextField();
		Tdate.setBounds(666, 324, 86, 20);
		contentPane.add(Tdate);
		Tdate.setColumns(10);
		
		Tproduct = new JTextField();
		Tproduct.setBounds(666, 356, 86, 20);
		contentPane.add(Tproduct);
		Tproduct.setColumns(10);
		
		JButton Bgoals = new JButton("Assign Goals");
		Bgoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="";
						if(Tmarket.getText().equals("Ankara")||Tmarket.getText().equals("Yalova")) {
							if(Tmarket.getText().equals("Ankara"))
									query="update InventoryAnkara set Goal='"+Integer.parseInt(Tcount.getText())+"' , GoalDueDate='"+Tdate.getText()+"' where Product='"+Tproduct.getText()+"'";
							else if(Tmarket.getText().equals("Yalova"))
								query="update InventoryYalova set Goal='"+Integer.parseInt(Tcount.getText())+"' , GoalDueDate='"+Tdate.getText()+"' where Product='"+Tproduct.getText()+"'";
						}else {
								JOptionPane.showMessageDialog(null,"Please enter market Ankara or Yalova");
								}
						
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						pst.close();
				}catch(Exception ab) {
					
				}
			}
		});
		Bgoals.setBounds(648, 387, 132, 23);
		contentPane.add(Bgoals);
		
		JButton Bdelete = new JButton("Delete Goal");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection=sqliteConnection.dbConnector();

				try {
					String query="";
					if(Tproduct.getText().isEmpty())
						JOptionPane.showMessageDialog(null,"Please enter product.");
					else
						query="delete Goals where Product='"+Tproduct.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					
				}catch(Exception a) {
					
				}
				
			}
		});
		Bdelete.setBounds(536, 387, 102, 23);
		contentPane.add(Bdelete);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ManagerPanel ap= new ManagerPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(549, 423, 89, 23);
		contentPane.add(Bback);
		
		JButton btnLoadTables = new JButton("Load Tables");
		btnLoadTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try{String query="select * from Inventory";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				String query1="select * from Goals";
				PreparedStatement pst1=connection.prepareStatement(query1);
				ResultSet rs1=pst1.executeQuery();
				table2.setModel(DbUtils.resultSetToTableModel(rs1));
				String query2="";
				if(Tmarket.getText().equals("Ankara")||Tmarket.getText().equals("Yalova")) {
				if(Tmarket.getText().equals("Ankara"))
				 query2="select * from InventoryAnkara";
				else if(Tmarket.equals("Yalova"))
					query2="select * from InventoryYalova";}
				else
					JOptionPane.showMessageDialog(null,"Please enter market Ankara or Yalova");
				PreparedStatement pst2=connection.prepareStatement(query2);
				ResultSet rs2=pst2.executeQuery();
				table3.setModel(DbUtils.resultSetToTableModel(rs2));
				
				
				}catch(Exception a) {
					
					
				}
			}
		});
		btnLoadTables.setBounds(648, 423, 132, 23);
		contentPane.add(btnLoadTables);
		
		lblProduct_1 = new JLabel("Product");
		lblProduct_1.setBounds(31, 249, 46, 14);
		contentPane.add(lblProduct_1);
		
		lblCount = new JLabel("Count");
		lblCount.setBounds(113, 250, 46, 14);
		contentPane.add(lblCount);
		
		lblSell = new JLabel("Sell");
		lblSell.setBounds(201, 249, 46, 14);
		contentPane.add(lblSell);
		
		lblGoalCount_1 = new JLabel("Goal Count");
		lblGoalCount_1.setBounds(289, 249, 67, 14);
		contentPane.add(lblGoalCount_1);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(393, 250, 46, 14);
		contentPane.add(lblPrice);
		
		lblNewLabel = new JLabel("Goal Date");
		lblNewLabel.setBounds(463, 249, 76, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Product");
		lblNewLabel_1.setBounds(74, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblCount_1 = new JLabel("Count");
		lblCount_1.setBounds(239, 11, 46, 14);
		contentPane.add(lblCount_1);
		
		lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(403, 11, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Produt");
		lblNewLabel_3.setBounds(569, 11, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblGoalCount_2 = new JLabel("Goal Count");
		lblGoalCount_2.setBounds(627, 11, 67, 14);
		contentPane.add(lblGoalCount_2);
		
		lblGoalDate_1 = new JLabel("Goal Date");
		lblGoalDate_1.setBounds(706, 11, 64, 14);
		contentPane.add(lblGoalDate_1);
	}
}
