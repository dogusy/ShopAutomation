import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Massigntable extends JFrame {

	private JPanel contentPane;
	Connection connection = null;
	private JTable table;
	private JTextField Tplace;
	private JTextField Tproduct;
	private JTextField Tcount;
	private	JTextArea textArea;
	private JTextField Tgoal;
	private JTextField Tprice;
	private JTextField Tdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Massigntable frame = new Massigntable();
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
	public Massigntable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(27, 24, 593, 143);
		contentPane.add(table);

		JLabel lblPlace = new JLabel("Place");
		lblPlace.setBounds(194, 178, 46, 14);
		contentPane.add(lblPlace);

		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(194, 212, 46, 14);
		contentPane.add(lblProduct);

		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(194, 241, 46, 14);
		contentPane.add(lblCount);

		Tplace = new JTextField();
		Tplace.setBounds(250, 178, 86, 20);
		contentPane.add(Tplace);
		Tplace.setColumns(10);

		Tproduct = new JTextField();
		Tproduct.setBounds(250, 209, 86, 20);
		contentPane.add(Tproduct);
		Tproduct.setColumns(10);

		Tcount = new JTextField();
		Tcount.setText("");
		Tcount.setBounds(250, 238, 86, 20);
		contentPane.add(Tcount);
		Tcount.setColumns(10);

		JButton Bload = new JButton("Load Inventory");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection = sqliteConnection.dbConnector();
				String query = "";
				if (Tplace.getText().matches("Ankara") || Tplace.getText().matches("Yalova")) {
					if (Tplace.getText().equals("Ankara"))
						query = "select * from InventoryAnkara";
					else if (Tplace.getText().equals("Yalova"))
						query = "select * from InventoryYalova";
				} else
					JOptionPane.showMessageDialog(null, "Please enter place Ankara/Yalova");
				try {
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				} catch (Exception a) {

				}
			}
		});
		Bload.setBounds(10, 195, 135, 23);
		contentPane.add(Bload);
	
		JButton Bupdate = new JButton("Update Inventory");
		Bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection = sqliteConnection.dbConnector();
				Manager m = new Manager();
			

				try {
				

					String count =m.Getcount("Ankara",Tproduct.getText());
					PreparedStatement pst1=connection.prepareStatement(count);
					ResultSet rs1=pst1.executeQuery();
					int sayi=rs1.getInt("Count");
					int updatedcount=Integer.parseInt(Tcount.getText())+sayi;
					System.out.println(updatedcount);
					String query = "";
					
					
				
				
					
				
						
			if(Tplace.getText().equals("Ankara")) {
					query = "update InventoryAnkara set Count = '" + updatedcount
							+ "'  where Product = '" + Tproduct.getText() + "'";
			
					
			 }
			else if (Tplace.getText().equals("Yalova")) {
				query="update InventoryYalova set Count = '"+updatedcount+ "' where Product = '"+Tproduct.getText()+"' ";
				
			}
					PreparedStatement pst = connection.prepareStatement(query);
			
					pst.execute();
					
					pst.close();

				} catch (Exception a) {

				}
			}
		});
		Bupdate.setBounds(10, 234, 135, 23);
		contentPane.add(Bupdate);

		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPanel mp=new ManagerPanel();
				mp.setVisible(true);
			}
		});
		Bback.setBounds(10, 334, 135, 23);
		contentPane.add(Bback);
		
		JButton Bget = new JButton("Get List");
		Bget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection = sqliteConnection.dbConnector();
				String query="select List from UrunDagýt ";
				try{
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					textArea.setText(rs.getString("List"));
				}catch(Exception a) {
					
				}
			}
		});
		Bget.setBounds(10, 269, 135, 23);
		contentPane.add(Bget);
		
		 textArea = new JTextArea();
		textArea.setBounds(346, 199, 357, 130);
		contentPane.add(textArea);
		
		JLabel lblProduct_1 = new JLabel("Product");
		lblProduct_1.setBounds(27, -1, 46, 14);
		contentPane.add(lblProduct_1);
		
		JLabel lblNewLabel = new JLabel("Count");
		lblNewLabel.setBounds(133, -1, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sell");
		lblNewLabel_1.setBounds(227, -1, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Goal");
		lblNewLabel_2.setBounds(322, -1, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(418, -1, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblPlace_1 = new JLabel("Place");
		lblPlace_1.setBounds(533, -1, 46, 14);
		contentPane.add(lblPlace_1);
		
		Tgoal = new JTextField();
		Tgoal.setBounds(250, 270, 86, 20);
		contentPane.add(Tgoal);
		Tgoal.setColumns(10);
		
		Tprice = new JTextField();
		Tprice.setBounds(250, 304, 86, 20);
		contentPane.add(Tprice);
		Tprice.setColumns(10);
		
		Tdate = new JTextField();
		Tdate.setBounds(250, 335, 86, 20);
		contentPane.add(Tdate);
		Tdate.setColumns(10);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(194, 273, 46, 14);
		contentPane.add(lblGoal);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(194, 307, 46, 14);
		contentPane.add(lblPrice_1);
		
		JLabel lblGoalDate = new JLabel("Goal Date");
		lblGoalDate.setBounds(182, 338, 58, 14);
		contentPane.add(lblGoalDate);
		
		JButton Baddnewproduct = new JButton("Add New Product");
		Baddnewproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					
					String query="";
					if(Tplace.getText().equals("Ankara"))
						query="insert into InventoryAnkara(Product,Count,Sell,Goal,Price,GoalDueDate) values(?,?,?,?,?,?)";
					else if(Tplace.getText().equals("Yalova"))
						query="insert into InventoryYalova(Product,Count,Sell,Goal,Price,GoalDueDate) values(?,?,?,?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,Tproduct.getText());
					pst.setInt(2, Integer.parseInt(Tcount.getText()));
					pst.setInt(3, 0);
					pst.setInt(4, Integer.parseInt(Tgoal.getText()));
					pst.setDouble(5, Double.parseDouble(Tprice.getText()));
					pst.setString(6, Tdate.getText());
					
					pst.execute();
					pst.close();
				}catch(Exception ab) {
					
				}
			}
		});
		Baddnewproduct.setBounds(10, 303, 135, 23);
		contentPane.add(Baddnewproduct);
	}
}
