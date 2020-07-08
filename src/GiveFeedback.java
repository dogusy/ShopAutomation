import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class GiveFeedback extends JFrame {

	private JPanel contentPane;
	Connection connection=null;
	private JTextField Tname;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveFeedback frame = new GiveFeedback();
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
	public GiveFeedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 31, 356, 268);
		contentPane.add(textArea);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel ap=new AdminPanel();
				ap.setVisible(true);
			}
		});
		Bback.setBounds(50, 348, 89, 23);
		contentPane.add(Bback);
		
		JButton Bsend = new JButton("Send");
		Bsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				Admin a=new Admin();
				Random random = new Random();
				int x = random.nextInt(90) + 10;
				try {
				
					PreparedStatement pst=connection.prepareStatement(a.giveFeedback());
					pst.setInt(1,x);
					pst.setString(2, textArea.getText());
					pst.setString(3, Tname.getText());
					pst.execute();
					pst.close();
				}catch(Exception ab) {
					
				}
			}
		});
		Bsend.setBounds(525, 348, 89, 23);
		contentPane.add(Bsend);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(178, 310, 46, 14);
		contentPane.add(lblNewLabel);
		
		Tname = new JTextField();
		Tname.setBounds(234, 310, 86, 20);
		contentPane.add(Tname);
		Tname.setColumns(10);
		
		table = new JTable();
		table.setBounds(428, 27, 235, 268);
		contentPane.add(table);
		
		JButton Bmanager = new JButton("Get Manager List");
		Bmanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
				
				try {
					String query="select Name,ID from WorkerInfo where  Role='Manager'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				}catch(Exception a) {
					
				}
			}
		});
		Bmanager.setBounds(295, 348, 136, 23);
		contentPane.add(Bmanager);
	}

}
