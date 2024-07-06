package cusRep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CusForm extends JFrame{
	CusForm() {
		this.setSize(500, 250);
		this.setTitle("Customer Form");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel custno = new JLabel("Customer No. ");
		JLabel custname = new JLabel("Customer Name ");
		JLabel state = new JLabel("State ");
		JLabel credlim = new JLabel("Credit Limit ");
		JLabel repno = new JLabel("Representative No. ");
		JLabel nothing = new JLabel();
		JTextField custnofield = new JTextField();
		JTextField custnamefield = new JTextField();
		JTextField statefield = new JTextField();
		JTextField credlimfield = new JTextField();
		JTextField repnofield = new JTextField();
		JButton submit = new JButton("Add Customer");
		
		panel.setLayout(new GridLayout(6, 2));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panel.add(custno);
		panel.add(custnofield);
		panel.add(custname);
		panel.add(custnamefield);
		panel.add(state);
		panel.add(statefield);
		panel.add(credlim);
		panel.add(credlimfield);
		panel.add(repno);
		panel.add(repnofield);
		panel.add(nothing);
		panel.add(submit);		
		
		this.add(panel);
		this.setVisible(true);
		
		submit.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = DatabaseConn.getConn();
				
				String custNo = custnofield.getText().trim();
				String custName = custnamefield.getText().trim();
				String State = statefield.getText().trim();
				String credLim = credlimfield.getText().trim();
				String repNo = repnofield.getText().trim();
				
				try {
					String query = "INSERT INTO cust (custno, custname, state, credlim, repno) " + "VALUES (?, ?, ?, ?, ?)";
					PreparedStatement prep = conn.prepareStatement(query);	
					prep.setInt(1, Integer.parseInt(custNo));
					prep.setString(2, custName);
					prep.setString(3, State);
					prep.setInt(4, Integer.parseInt(credLim));
					prep.setInt(5, Integer.parseInt(repNo));	
					
					int rowsInserted = prep.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Customer added successfully!");
                    }

                    prep.close();
                    conn.close();
				}
				catch (SQLException ex) {
					System.err.println("Database error.");
				}			
			}
		});
	}

}
