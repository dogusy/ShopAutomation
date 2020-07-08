import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Ashowfeedback extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel Ltext;
Connection connection=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ashowfeedback frame = new Ashowfeedback();
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
	public Ashowfeedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 722, 195);
		contentPane.add(table);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel ap=new AdminPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(10, 256, 89, 23);
		contentPane.add(Bback);
		
		JButton Bload = new JButton("Load Reports");
		Bload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="select * from MSendReport ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception a) {
					
				}
				
			}
		});
		Bload.setBounds(161, 256, 112, 23);
		contentPane.add(Bload);
		
		JButton Bdelete = new JButton("Delete Report");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					String query="delete from MSendReport where ID= '"+Integer.parseInt(textField.getText())+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bdelete.setBounds(319, 256, 121, 23);
		contentPane.add(Bdelete);
		
		JButton Bview = new JButton("View Report");
		Bview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				try {
					Admin ad=new Admin();
					PreparedStatement pst=connection.prepareStatement(ad.viewfeedback(Integer.parseInt(textField.getText())));
					ResultSet rs=pst.executeQuery();
					
					Ltext.setText(rs.getString("Report"));
					pst.close();
					rs.close();

					
				}catch(Exception a) {
					
				}
			}
		});
		Bview.setBounds(516, 256, 141, 23);
		contentPane.add(Bview);
		
		textField = new JTextField();
		textField.setBounds(298, 217, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(229, 218, 46, 13);
		contentPane.add(lblId);
		
		 Ltext = new JLabel("");
		Ltext.setBounds(71, 327, 581, 112);
		contentPane.add(Ltext);
	}

}
