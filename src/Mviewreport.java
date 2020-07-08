import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Mviewreport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Tid;
	Connection connection=null;	
    private JLabel Ltext;
    private JTextField Trole;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mviewreport frame = new Mviewreport();
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
	public Mviewreport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 26, 504, 207);
		contentPane.add(table);
		
		JLabel Lid = new JLabel("ID");
		Lid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lid.setBounds(524, 48, 46, 14);
		contentPane.add(Lid);
		
		Tid = new JTextField();
		Tid.setBounds(564, 47, 86, 20);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JButton Bload = new JButton("View Reports Clerk");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				
				try {
					String query="select * from CSendReport";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				Ltext.setText(rs.getString("Report"));
				}catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(524, 123, 160, 23);
		contentPane.add(Bload);
		
		JButton Bdelete = new JButton("Delete Report");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				String query="";
				try {
					if(Trole.getText().equals("Clerk"))
					 query="delete from CSendReport where ID= '"+Integer.parseInt(Tid.getText())+"'";
					else if(Trole.getText().equals("Admin"))
						query="delete from AdminSendManager where ID= '"+Integer.parseInt(Tid.getText())+"'";
					else 
						JOptionPane.showMessageDialog(null,"Please enter Admin or Clerk");
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(524, 167, 160, 23);
		contentPane.add(Bdelete);
		
		JLabel Ltext = new JLabel("");
		Ltext.setBounds(63, 280, 370, 111);
		contentPane.add(Ltext);
		
		JButton Bloadreport = new JButton("Load Report");
		Bloadreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Manager m=new Manager();
				String query="";
				try {
					
					if(Trole.getText().equals("Clerk"))
						query=m.viewReport(Integer.parseInt(Tid.getText()));
					else if (Trole.getText().equals("Admin"))
						query="select Report from AdminSendManager where ID='"+Tid.getText()+"'";
				else 
					JOptionPane.showMessageDialog(null,"Please enter Admin/Clerk");
				
					
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				Ltext.setText(rs.getString("Report"));
				}catch(Exception a) {
					
				}
			}
		});
		Bloadreport.setBounds(524, 210, 160, 23);
		contentPane.add(Bloadreport);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPanel mp=new ManagerPanel();
				mp.setVisible(true);
			}
		});
		Bback.setBounds(524, 244, 160, 28);
		contentPane.add(Bback);
		
		JButton Badmin = new JButton("View Reports Admin");
		Badmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	connection=sqliteConnection.dbConnector();
				
				try {
					String query="select * from AdminSendManager";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				Ltext.setText(rs.getString("Report"));
				}catch(Exception a) {
					
				}
				
			}
		});
		Badmin.setBounds(524, 89, 160, 23);
		contentPane.add(Badmin);
		
		JLabel lblAdminclerk = new JLabel("Admin/Clerk");
		lblAdminclerk.setBounds(63, 244, 86, 14);
		contentPane.add(lblAdminclerk);
		
		Trole = new JTextField();
		Trole.setBounds(172, 244, 86, 20);
		contentPane.add(Trole);
		Trole.setColumns(10);
	}

}
