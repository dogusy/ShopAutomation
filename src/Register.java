import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Register extends JFrame {
	Connection connection=null;
	private JPanel contentPane;
	private JTextField Tname;
	private JTextField Taddress;
	private JTextField Tphone;
	private JTextField Temail;
	private JTextField Tpassword;
	private JComboBox comboBox;
	private JComboBox comboBox2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lname = new JLabel("Name");
		Lname.setBounds(56, 75, 46, 14);
		contentPane.add(Lname);
		
		JLabel Laddress = new JLabel("Address");
		Laddress.setBounds(56, 132, 46, 17);
		contentPane.add(Laddress);
		
		JLabel Lphone = new JLabel("Phone Number");
		Lphone.setBounds(56, 195, 86, 20);
		contentPane.add(Lphone);
		
		JLabel Lemail = new JLabel("E-mail");
		Lemail.setBounds(56, 260, 46, 14);
		contentPane.add(Lemail);
		
		JLabel Lpassword = new JLabel("Password");
		Lpassword.setBounds(56, 322, 46, 14);
		contentPane.add(Lpassword);
		
		Tname = new JTextField();
		Tname.setBounds(179, 72, 182, 20);
		contentPane.add(Tname);
		Tname.setColumns(10);
		
		Taddress = new JTextField();
		Taddress.setBounds(179, 130, 182, 20);
		Taddress.setText("");
		contentPane.add(Taddress);
		Taddress.setColumns(10);
		
		Tphone = new JTextField();
		Tphone.setBounds(179, 195, 182, 20);
		contentPane.add(Tphone);
		Tphone.setColumns(10);
		
		Temail = new JTextField();
		Temail.setBounds(179, 254, 182, 20);
		Temail.setText("");
		contentPane.add(Temail);
		Temail.setColumns(10);
		
		Tpassword = new JTextField();
		Tpassword.setBounds(179, 316, 182, 20);
		contentPane.add(Tpassword);
		Tpassword.setColumns(10);
		
		JButton Bconfrim = new JButton("Confirm");
		Bconfrim.setBounds(490, 129, 143, 41);
		Bconfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection=sqliteConnection.dbConnector();
				User ua=new User();
try {
					
					ua.address=Taddress.getText();
					ua.email=Temail.getText();
					ua.password=Tpassword.getText();
					ua.name=Tname.getText();
					ua.phone=Integer.parseInt(Tphone.getText());
					ua.sube=(String)comboBox.getSelectedItem();
					ua.role=(String)comboBox2.getSelectedItem();
					ua.register();
					setVisible(false);
					
				}catch(Exception e) {
					
				}
			}
		});
		contentPane.add(Bconfrim);
		
		JButton Bback = new JButton("Back");
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		Bback.setBounds(490, 260, 143, 41);
		contentPane.add(Bback);
		
	    comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ankara", "Yalova"}));
		comboBox.setBounds(179, 351, 182, 20);
		contentPane.add(comboBox);
		
		JLabel lblMarket = new JLabel("Market ");
		lblMarket.setBounds(56, 354, 46, 14);
		contentPane.add(lblMarket);
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Clerk", "Manager"}));
		comboBox2.setBounds(179, 382, 182, 20);
		contentPane.add(comboBox2);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(56, 385, 46, 14);
		contentPane.add(lblRole);
		
		
	}
}
