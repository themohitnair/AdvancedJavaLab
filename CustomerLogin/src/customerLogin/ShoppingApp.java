package customerLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingApp {
	ShoppingApp(int customerID) {
		JFrame shop = new JFrame("Item Selection");
		shop.setSize(400, 400);
		shop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		ItemCollection itcol = new ItemCollection();
		
		JPanel pan = new JPanel(new GridLayout(8,2,10,10));
		pan.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JLabel select = new JLabel("Select Item ID: ");
		JLabel dis = new JLabel("Discounts available: ");
		JComboBox<Integer> itemDD = new JComboBox<>();
		
		itemDD.add(select);
		for(int item: itcol.getItemIDs()) {
			itemDD.addItem(item);
		}
		
		JComboBox<Integer> discounts = new JComboBox<>();
		
		itemDD.add(dis);
		discounts.addItem(25);
		discounts.addItem(30);
		discounts.addItem(50);
		
		JLabel qty = new JLabel("Quantity: ");
		JTextField quant = new JTextField();
		
		JButton buy = new JButton("Buy");
		
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(quant.getText());
				int itemid = (Integer)(itemDD.getSelectedItem());
				int discount = (Integer)(discounts.getSelectedItem());
				
				JOptionPane.showMessageDialog(pan, "Total purchase made by customer ID "+customerID+" is Rs. "+itcol.returnBill(discount, itemid, qty));
				shop.dispose();
				
				
			}
		});
		
		
		
		pan.add(select);
		pan.add(itemDD);
		pan.add(qty);
		pan.add(quant);
		pan.add(dis);
		pan.add(discounts);
		pan.add(buy);
		shop.add(pan);
		
		
		
		shop.setVisible(true);
		
		
	}
	
}
