package simulateCalls;
import java.util.HashMap;
import java.util.Map;

public class ContactList {
	HashMap<String, String> cList;
	ContactList() {
		 cList = new HashMap<String, String>();
	}
	
	boolean validatePhone(String phone) {
		if (phone.trim().length() != 10) {
			return false;			
		}
		else {
			char[] p = phone.toCharArray();
			for (char dig: p) {
				if (!Character.isDigit(dig)) {
					return false;
				}
			}
		}
		return true;
	}
	
	void addContact(String phone, String ID) {
		if (validatePhone(phone)) {
			this.cList.put(phone, ID);
		}
	}
	
	void deleteContact(String phone) {
		if (validatePhone(phone)) {
			this.cList.remove(phone);
		}
	}
	
	String retrieve(String phone) {
		if (validatePhone(phone)) {
			if (cList.containsKey(phone)) {
				return cList.get(phone);
			}
			else {
				return "Private Caller";
			}
		}
		else {
			return "Private Caller";
		}
	}
	
	void displayContacts() {
		for (Map.Entry<String, String> entry: this.cList.entrySet()) {
			System.out.println("Caller ID: " + entry.getKey() + "Phone number: " + entry.getValue());			
		}
	}
}
