package custs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class CustomerApp extends JFrame {
	CustomerApp(Connection c) {
		this.setTitle("Customer Database");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(new JLabel("Customer No."));
		JTextField custno = new JTextField();
		panel.add(custno);
		
		panel.add(new JLabel("Customer Name"));
		JTextField custname = new JTextField();
		panel.add(custname);
		
		panel.add(new JLabel("State"));
		JTextField state = new JTextField();
		panel.add(state);
		
		panel.add(new JLabel("Credit Limit (INR)"));
		JTextField creditlimit = new JTextField();
		panel.add(creditlimit);
		
		JButton add = new JButton("Add Customer");
		panel.add(add);
		JButton show = new JButton("Show Customers");
		panel.add(show);
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int CustomerNumber = Integer.parseInt(custno.getText());
					String CustomerName = custname.getText();
					String CustomerState = state.getText();
					int CustomerCredlim = Integer.parseInt(creditlimit.getText());
					
					String insert = "INSERT INTO customers(custno, custname, state, creditlimit) VALUES(?, ?, ?, ?)";
					PreparedStatement statement = c.prepareStatement(insert);
					statement.setInt(1, CustomerNumber);
					statement.setString(2, CustomerName);
					statement.setString(3, CustomerState);
					statement.setInt(4, CustomerCredlim);
					
					int rowsAffected = statement.executeUpdate();
					
					if (rowsAffected > 0) {
						JOptionPane.showMessageDialog(null, "Record inserted successfully");
					}
					else  {
						JOptionPane.showMessageDialog(null, "Record not inserted");
					}
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for Customer No. and Credit Limit");
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Database Error");
					ex.printStackTrace();
				}
				
			}
		});
		
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					StringBuilder cusInfo = new StringBuilder();
					String q = "SELECT * FROM customers";
					PreparedStatement query = c.prepareStatement(q);
					ResultSet rs = query.executeQuery();
					
					while(rs.next()) {
						int CustomerNumber = rs.getInt("custno");
						String CustomerName = rs.getString("custname");
						String CustomerState = rs.getString("state");
						int CustomerCredlim = rs.getInt("creditlimit");
						
						cusInfo.append("Customer number: ").append(CustomerNumber).append("   Customer Name: ").append(CustomerName).append("   State: ").append(CustomerState).append("   Credit Limit: ").append(CustomerCredlim).append("\n");
					}
					if (cusInfo.length() > 0) {
						JOptionPane.showMessageDialog(null, cusInfo.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "No customers inserted yet");
					}
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Database Error");
				}
			}
		}); 
		
		this.add(panel);		
		this.setVisible(true);		
	}
	
	public static void main(String args[] ) {
		Connection c = DatabaseConn.obtainConnection();
		CustomerApp cus = new CustomerApp(c);
	}
}
