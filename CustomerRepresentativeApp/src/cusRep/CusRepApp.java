package cusRep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class CusRepApp extends JFrame{
	CusRepApp() {
		this.setTitle("Customer-Representative App");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JButton cusform = new JButton("Customer Form");
		JButton repform = new JButton("Representative Form");
		JButton cred = new JButton("Credit Limit > 15000");
		
		panel.setLayout(new GridLayout(5, 2));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panel.add(cusform);
        panel.add(new JLabel());
        panel.add(repform);
        panel.add(new JLabel());
        panel.add(cred);
        
        this.add(panel);
        this.setVisible(true);
        
        cusform.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		new CusForm();
        	}
        }
        );
        
        repform.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		new RepForm();
        	}
        }
        );
        
        cred.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		new CreditLimitFrame(getRepresentativesAboveCreditLimit(15000));
        	}
        });
	}
	
	public List<String> getRepresentativesAboveCreditLimit(int creditLimit) {
        List<String> repsAboveCredit = new ArrayList<>();
        try {
            Connection conn = DatabaseConn.getConn();
            String query = "SELECT repname FROM repr WHERE repno IN " +"(SELECT repno FROM cust WHERE credlim > ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, creditLimit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String repName = resultSet.getString("repname");
                repsAboveCredit.add(repName);
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return repsAboveCredit;
    }
	
	
	public static void main(String args[]) {
    	new CusRepApp();
    }
    
}
