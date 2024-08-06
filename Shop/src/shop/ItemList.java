package shop;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ItemList {
	HashMap<String, Double> itemDict;
	
	ItemList() {
		this.itemDict = new HashMap<String, Double>();
	}
	
	void addItem(String name, double price) {
		this.itemDict.put(name, price);	
	}
	
	String[] arrayOfItems() {
		ArrayList<String> itemList = new ArrayList<String>();
		for (Map.Entry<String, Double> entry: this.itemDict.entrySet()) {
			itemList.add(entry.getKey()); 			
		}
		String[] items = new String[itemList.size()];
        items = itemList.toArray(items);
		return items;	
	}
	
	double totalCost(String item, int qty, double discPer) {
		double price = this.itemDict.get(item);
		price *= qty;
		double discount = (discPer / 100.0) * price;
		price -= discount;
		return price;								
	}
}

