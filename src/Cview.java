import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.sql.*;
public class Cview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Tid;
Connection connection=null;
private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cview frame = new Cview();
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
	public Cview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 23, 430, 241);
		contentPane.add(table);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(465, 55, 46, 14);
		contentPane.add(lblId);
		
		Tid = new JTextField();
		Tid.setBounds(537, 54, 86, 20);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JButton btnViewReport = new JButton("View Reports");
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Manager m=new Manager();
				try {
					String query="select * from ManagersendClerk";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception a) {
					
				}
			}
		});
		btnViewReport.setBounds(465, 108, 119, 23);
		contentPane.add(btnViewReport);
		
		JButton Bload = new JButton("Load Report");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="select * from ManagersendClerk   where ID= '"+Integer.parseInt(Tid.getText())+"'";
				try{PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				textArea.setText(rs.getString("Report"));
				}catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(465, 154, 119, 23);
		contentPane.add(Bload);
		
		JButton btnNewButton = new JButton("Delete Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
				String query="delete from ManagersendClerk where ID= "+ Integer.parseInt(Tid.getText());
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				pst.close();
				}catch(Exception a) {
					
				}
				}
		});
		btnNewButton.setBounds(465, 199, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkPanel cp= new ClerkPanel();
				cp.setVisible(true);
			}
		});
		Bback.setBounds(465, 233, 119, 23);
		contentPane.add(Bback);
		
		 textArea = new JTextArea();
		textArea.setBounds(26, 306, 467, 102);
		contentPane.add(textArea);
	}

}
