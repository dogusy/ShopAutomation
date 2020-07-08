import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Madminfeedback extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Tid;
Connection connection=null;
private JTextArea textArea;
private JTextField Tname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Madminfeedback frame = new Madminfeedback();
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
	public Madminfeedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(21, 24, 465, 208);
		contentPane.add(table);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(496, 55, 46, 14);
		contentPane.add(lblId);
		
		Tid = new JTextField();
		Tid.setBounds(550, 52, 86, 20);
		contentPane.add(Tid);
		Tid.setColumns(10);
		
		JButton Bview = new JButton("View Report");
		Bview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Manager m=new Manager();
				try {
					String query="select * from AdminSendManager";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception a) {
					
				
			}}}
		);
		Bview.setBounds(496, 153, 127, 23);
		contentPane.add(Bview);
		
		JButton Bload = new JButton("Load Report");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="";
				if(Tname.getText().isEmpty()||Tid.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter name and ID");
               }else
				 query="select * from AdminSendManager   where ID= '"+Integer.parseInt(Tid.getText())+"' and Name='"+Tname.getText()+"'";
				try{
					
					PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				textArea.setText(rs.getString("Report"));
				}catch(Exception a) {
					
				}
			}
		});
		Bload.setBounds(496, 214, 127, 23);
		contentPane.add(Bload);
		
		JButton Bdelete = new JButton("Delete Report");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
				String query="delete from AdminSendManager where ID= "+ Integer.parseInt(Tid.getText());
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(496, 266, 127, 23);
		contentPane.add(Bdelete);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPanel mp=new ManagerPanel();
				mp.setVisible(true);
			}
		});
		Bback.setBounds(496, 316, 127, 23);
		contentPane.add(Bback);
		
		 textArea = new JTextArea();
		textArea.setBounds(21, 270, 465, 139);
		contentPane.add(textArea);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(496, 95, 46, 14);
		contentPane.add(lblName);
		
		Tname = new JTextField();
		Tname.setBounds(550, 94, 86, 20);
		contentPane.add(Tname);
		Tname.setColumns(10);
	}

}
