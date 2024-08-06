package shop;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.*;

public class Shop extends JFrame {
	Shop(ItemList items) {
		this.setTitle("Shop");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 3, 3));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(new JLabel("Item Name"));
		JComboBox<String> it = new JComboBox<String>(items.arrayOfItems());
		panel.add(it);
		panel.add(new JLabel("Quantity"));
		JTextField qty = new JTextField();
		panel.add(qty);
		panel.add(new JLabel("Discount"));
		JComboBox<Double> disc = new JComboBox<Double>(new Double[]{25.0, 45.0, 55.0});
		panel.add(disc);
		panel.add(new JLabel("Grand Total in INR"));
		JTextArea area = new JTextArea();
		area.setEditable(false);
		panel.add(area);
		JButton comp = new JButton("Compute");
		panel.add(comp);
		JButton buy = new JButton("Buy");
		panel.add(buy);
		
		comp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String itemname = it.getSelectedItem().toString();
					int quantity = Integer.parseInt(qty.getText());
					double discount = Double.parseDouble(disc.getSelectedItem().toString());
					
					double grandTot = items.totalCost(itemname, quantity, discount);
					area.append("INR " + String.valueOf(grandTot));				
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Enter only numeric values of discount");
				}
			}
		});
		
		buy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String itemname = it.getSelectedItem().toString();
					int quantity = Integer.parseInt(qty.getText());
					double discount = Double.parseDouble(disc.getSelectedItem().toString());
					
					double grandTot = items.totalCost(itemname, quantity, discount);
					JOptionPane.showConfirmDialog(null, "Total Bill Amount: " + grandTot);	
					qty.setText("");
					area.setText("");
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Enter only numeric values of discount");
				}
			}
		});
		
		this.add(panel);
		this.setVisible(true);	
	}
	
	public static void main(String args[]) {
		ItemList items = new ItemList();
		items.addItem("Item 1", 100.0);
		items.addItem("Item 2", 200.0);
		items.addItem("Item 3", 50.0);
		Shop app = new Shop(items);		
	}
}