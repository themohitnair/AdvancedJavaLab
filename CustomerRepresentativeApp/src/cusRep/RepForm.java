package cusRep;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

public class RepForm extends JFrame {
    
    public RepForm() {
        this.setSize(500, 250);
        this.setTitle("Representative Form");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       
        JPanel panel = new JPanel();
        
        JLabel repno = new JLabel("Representative No.");
        JLabel repname = new JLabel("Representative Name");
        JLabel state = new JLabel("State");
        JLabel commission = new JLabel("Commission");
        JLabel rate = new JLabel("Rate");
        
        JTextField repnofield = new JTextField();
        JTextField repnamefield = new JTextField();
        JTextField statefield = new JTextField();
        JTextField commissionfield = new JTextField();
        JTextField ratefield = new JTextField();
        
        JButton submit = new JButton("Add Representative");
        
        panel.setLayout(new GridLayout(6, 2));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panel.add(repno);
        panel.add(repnofield);
        panel.add(repname);
        panel.add(repnamefield);
        panel.add(state);
        panel.add(statefield);
        panel.add(commission);
        panel.add(commissionfield);
        panel.add(rate);
        panel.add(ratefield);
        
        
        panel.add(new JLabel());
        panel.add(submit);   
        
        submit.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = DatabaseConn.getConn();
				
				String repNo = repnofield.getText().trim();
				String repName = repnamefield.getText().trim();
				String State = statefield.getText().trim();
				String comm = commissionfield.getText().trim();
				String rate = ratefield.getText().trim();
				
				try {
					String query = "INSERT INTO repr (repno, repname, state, commission, rate) " + "VALUES (?, ?, ?, ?, ?)";
					PreparedStatement prep = conn.prepareStatement(query);	
					prep.setInt(1, Integer.parseInt(repNo));
					prep.setString(2, repName);
					prep.setString(3, State);
					prep.setInt(4, Integer.parseInt(comm));
					prep.setInt(5, Integer.parseInt(rate));	
					
					int rowsInserted = prep.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Representative added successfully!");
                    }

                    prep.close();
                    conn.close();
				}
				catch (SQLException ex) {
					System.err.println("Database error.");
				}			
			}
		});
        
        
        this.add(panel);
        
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RepForm();
    }
}
