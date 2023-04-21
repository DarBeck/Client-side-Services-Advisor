package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.ClientHandler;
import domain.Credential;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ClientHandler client;
	private Credential cred;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdLogin frame = new AdLogin();
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
	public AdLogin() {
		client = new ClientHandler();
		cred = new Credential();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID#");
		lblNewLabel.setBounds(79, 67, 61, 16);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setBounds(79, 122, 81, 25);
		contentPane.add(lblNewLabel_1);
	
		
		textField = new JTextField();
		textField.setBounds(200, 62, 182, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 121, 182, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stu = textField.getText();
				String pass = textField_1.getText();
				int id = Integer.parseInt(stu);
				cred.setId(id);
				cred.setPassword(pass);
				client.sendAction("Login Advisor");
				client.sendCredential(cred);
				var res = client.receiveResponse();
				//clientid = stu;
				if (res) {
					var AdvisorDashboardGUI = new AdvisorDashboardGUI(client);
	            	setVisible(false);
	                JOptionPane.showMessageDialog(null, "Login successful!");
	                AdvisorDashboardGUI.setVisible(true);
				}		
				
			}
			
		});
		btnNewButton.setBounds(182, 194, 117, 29);
		contentPane.add(btnNewButton);
		
		
	}
}
