package customerLogin;
import java.util.HashMap;
import java.util.Map;

public class ItemCollection {
	HashMap<Integer, Integer> ICol = new HashMap<>();
	ItemCollection() {
		ICol.put(1, 45);
		ICol.put(2, 60);
		ICol.put(3, 80);
		ICol.put(4, 50);
		ICol.put(5, 95);		
	}
	
	double returnBill(int discount, int id, int qty) {
		if (discount < 100 && discount > 0) {
			return(ICol.get(id) - ((discount/100.0) * ICol.get(id))) * qty;
		}
		else {
			return -1.0;
		}
	}
	
	int[] getItemIDs() {
        int[] items = new int[ICol.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : ICol.entrySet()) {
            items[index] = entry.getKey();
            index++;
        }
        return items;
    }	
}
