import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.JLabel;
public class Cshow extends JFrame {

	private JPanel contentPane;
	private   JTable table;
	Connection connection=null;	
	private JTextArea textArea;
	private JButton Bsave;
	private JButton Bback;
	private JButton Bglist;
	private JLabel lblNewLabel;
	private JLabel lblCount;
	private JLabel lblSell;
	private JLabel lblNewLabel_1;
	private JLabel lblPrice;
	private JLabel lblDueDate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cshow frame = new Cshow();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Cshow() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(30, 33, 716, 224);
		contentPane.add(table);
		
		JButton Bload = new JButton("Load Inventory");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try{
					Clerk c=new Clerk();
				String query=c.showMarketInvent();
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		
				}
				catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(30, 273, 123, 29);
		contentPane.add(Bload);
		
		
		
		textArea = new JTextArea();
		textArea.setBounds(180, 268, 518, 134);
		contentPane.add(textArea);
		
		
		Bsave = new JButton("Save List");
		Bsave.addActionListener(new ActionListener() {
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
		
		Bsave.setBounds(30, 313, 123, 29);
		contentPane.add(Bsave);
		
		Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClerkPanel cp= new ClerkPanel();
				dispose();
				cp.setVisible(true);
			}
		});
		Bback.setBounds(30, 386, 123, 29);
		contentPane.add(Bback);
		
		Bglist = new JButton("Get List");
		Bglist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		Bglist.setBounds(30, 353, 123, 29);
		contentPane.add(Bglist);
		
		lblNewLabel = new JLabel("Product");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblCount = new JLabel("Count");
		lblCount.setBounds(156, 8, 46, 14);
		contentPane.add(lblCount);
		
		lblSell = new JLabel("Sell");
		lblSell.setBounds(283, 11, 46, 14);
		contentPane.add(lblSell);
		
		lblNewLabel_1 = new JLabel("Goal");
		lblNewLabel_1.setBounds(390, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(525, 11, 46, 14);
		contentPane.add(lblPrice);
		
		lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(652, 11, 46, 14);
		contentPane.add(lblDueDate);
	
	}
}
