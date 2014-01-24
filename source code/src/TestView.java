import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


public class TestView extends JFrame {

	private JPanel contentPane;
	private JTextField Password;
	private JTextField Username;
	private JButton Login;
	private JLabel Respond;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestView frame = new TestView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 137);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(20, 11, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(20, 36, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		Password = new JTextField();
		Password.setBounds(101, 33, 86, 20);
		contentPane.add(Password);
		Password.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(101, 8, 86, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		Login = new JButton("Login");
		Login.setBounds(98, 64, 89, 23);
		contentPane.add(Login);
		
		Respond = new JLabel("");
		Respond.setBounds(20, 61, 46, 14);
		contentPane.add(Respond);
	}
	
	public String getName(){  
		return Username.getText();        
	}
	
	public String getPass(){  
		return Password.getText();        
	}
	
	public void setRespond(String respond){
		Respond.setText(respond);
	}
	
	void addLoginListener(ActionListener listenForLogcButton){
		Login.addActionListener(listenForLogcButton);        
    }
	
	void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
	
}
