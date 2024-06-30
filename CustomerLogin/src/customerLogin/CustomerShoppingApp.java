package customerLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerShoppingApp {
	CustomerShoppingApp() {
		JFrame frame = new JFrame("Customer Shopping App");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JDialog loginDialog = new JDialog(frame, "Login", true);
		loginDialog.setLayout(new GridLayout(4, 2));
		loginDialog.setSize(300, 150);
		loginDialog.setLocationRelativeTo(frame);
		
		JTextField uname = new JTextField();
		JLabel user = new JLabel("Username");
		JLabel pass = new JLabel("Password");
		JLabel phn = new JLabel("Phone");
		JPasswordField pwd = new JPasswordField();
		JTextField ph = new JTextField();
		loginDialog.add(user);
		loginDialog.add(uname);
		loginDialog.add(pass);
		loginDialog.add(pwd);
		loginDialog.add(phn);
		loginDialog.add(ph);
		
		
		JButton loginButton = new JButton("Login");
		loginDialog.add(new JLabel());
		loginDialog.add(loginButton);
		
		CustomerCollection col = new CustomerCollection();
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = uname.getText();
				String password = new String(pwd.getPassword());
				String phone = ph.getText();
				
				if (username.equals("user") && password.equals("password")) {
					JOptionPane.showMessageDialog(loginDialog, "Login successful");	
				}
				else {
					JOptionPane.showMessageDialog(loginDialog, "Invalid Credentials");						
				}
				
				
				if (col.checkCustomerExists(phone)) {
					JOptionPane.showMessageDialog(loginDialog, "Your Customer ID is: "+ col.retrieveCustomerID(phone));
					loginDialog.dispose();
				}
				else {
					col.addNewCustomer(phone);
					JOptionPane.showMessageDialog(loginDialog, "Your New Customer ID is: "+ col.retrieveCustomerID(phone));		
					loginDialog.dispose();
				}
				ShoppingApp shop = new ShoppingApp(col.retrieveCustomerID(phone));
			}
		});
		loginDialog.setVisible(true);
	}
	
	public static void main(String args[]) {
		CustomerShoppingApp app = new CustomerShoppingApp();
	}
	
}
