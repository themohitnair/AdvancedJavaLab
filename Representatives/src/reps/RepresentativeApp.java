package reps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class RepresentativeApp extends JFrame {
	RepresentativeApp(Connection c) {
		this.setTitle("Customer Database");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(new JLabel("Representative No."));
		JTextField repno = new JTextField();
		panel.add(repno);
		
		panel.add(new JLabel("Representative Name"));
		JTextField repname = new JTextField();
		panel.add(repname);
		
		panel.add(new JLabel("State"));
		JTextField state = new JTextField();
		panel.add(state);
		
		panel.add(new JLabel("Commission (INR)"));
		JTextField comm = new JTextField();
		panel.add(comm);
		
		panel.add(new JLabel("Rate %"));
		JTextField rate = new JTextField();
		panel.add(rate);
		
		JButton add = new JButton("Add Representative");
		panel.add(add);
		JButton show = new JButton("Show Representatives");
		panel.add(show);
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int RepresentativeNumber = Integer.parseInt(repno.getText());
					String RepresentativeName = repname.getText();
					String RepresentativeState = state.getText();
					int RepresentativeComm = Integer.parseInt(comm.getText());
					int RepresentativeRate = Integer.parseInt(rate.getText());
					
					String insert = "INSERT INTO representatives(repno, repname, state, commission, rate) VALUES(?, ?, ?, ?, ?)";
					PreparedStatement statement = c.prepareStatement(insert);
					statement.setInt(1, RepresentativeNumber);
					statement.setString(2, RepresentativeName);
					statement.setString(3, RepresentativeState);
					statement.setInt(4, RepresentativeComm);
					statement.setInt(5, RepresentativeRate);
					
					int rowsAffected = statement.executeUpdate();
					
					if (rowsAffected > 0) {
						JOptionPane.showMessageDialog(null, "Record inserted successfully");
					}
					else  {
						JOptionPane.showMessageDialog(null, "Record not inserted");
					}
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter numeric values for Representative No., Representative Commission and Rate");
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
					String q = "SELECT * FROM representatives";
					PreparedStatement query = c.prepareStatement(q);
					ResultSet rs = query.executeQuery();
					
					while(rs.next()) {
						int RepresentativeNumber = rs.getInt("repno");
						String RepresentativeName = rs.getString("repname");
						String RepresentativeState = rs.getString("state");
						int RepresentativeComm = rs.getInt("commission");
						int RepresentativeRate = rs.getInt("rate");
						
						cusInfo.append("Representative number: ").append(RepresentativeNumber).append("   Representative Name: ").append(RepresentativeName).append("   State: ").append(RepresentativeState).append("   Representative Commission: ").append(RepresentativeComm).append("Rate: ").append(RepresentativeRate).append("\n");
					}
					if (cusInfo.length() > 0) {
						JOptionPane.showMessageDialog(null, cusInfo.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "No representatives inserted yet");
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
		Connection c = DatabaseConnection.obtainConnection();
		RepresentativeApp rep = new RepresentativeApp(c);
	}
}

