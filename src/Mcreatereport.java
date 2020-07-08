import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
public class Mcreatereport extends JFrame {

	private JPanel contentPane;
	Connection connection=null;	
	private JTextField Tname;
	private JTable table;
	private JTextField Tplace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mcreatereport frame = new Mcreatereport();
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
	public Mcreatereport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 63, 309, 192);
		contentPane.add(textArea);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPanel mp=new ManagerPanel();
				mp.setVisible(true);
			}
		});
		Bback.setBounds(121, 312, 89, 23);
		contentPane.add(Bback);
		
		JButton Bsend = new JButton("Send Admin");
		Bsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager  m= new Manager();
				
				try {
					m.report=textArea.getText();
					m.createreport();
				
				}catch(Exception a){
					
				}
			}
		});
		Bsend.setBounds(425, 312, 113, 23);
		contentPane.add(Bsend);
		
		JButton Bsclerk = new JButton("Send Clerk");
		Bsclerk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Random random = new Random();
				int x = random.nextInt(50) + 10;
				try {
					connection=sqliteConnection.dbConnector();
					
					
						String query="insert into ManagersendClerk (ID,Report,Name)"+"values(?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.setInt(1, x);
						pst.setString(2, textArea.getText());
						pst.setString(3, Tname.getText());
						pst.execute();
						pst.close();
						
					}catch(Exception a) {
						
					}
					
				
			}
		});
		Bsclerk.setBounds(281, 312, 113, 23);
		contentPane.add(Bsclerk);
		
		Tname = new JTextField();
		Tname.setBounds(121, 266, 113, 20);
		contentPane.add(Tname);
		Tname.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(53, 269, 46, 14);
		contentPane.add(lblName);
		
		table = new JTable();
		table.setBounds(425, 66, 179, 192);
		contentPane.add(table);
		
		Tplace = new JTextField();
		Tplace.setBounds(329, 266, 86, 20);
		contentPane.add(Tplace);
		Tplace.setColumns(10);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setBounds(273, 266, 46, 14);
		contentPane.add(lblMarket);
		
		JButton Bget = new JButton("Get Clerk List");
		Bget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			connection=sqliteConnection.dbConnector();
			
				try {
					String query="select Name,ID from WorkerInfo where Sube='"+Tplace.getText()+"' and Role='Clerk'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bget.setBounds(449, 265, 130, 23);
		contentPane.add(Bget);
	}
}
