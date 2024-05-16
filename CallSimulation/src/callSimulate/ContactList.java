package callSimulate;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ContactList {
	HashMap<String, String> contacts;
	
	ContactList() {
		contacts = new HashMap<String, String>();
	}
	
	void addContact(String phoneNumber, String callerID) {
		if(validatePhoneNumber(phoneNumber)) {
			contacts.put(phoneNumber, callerID);
		}
	}
	
	static boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10) {
			return false;			
		}
		for(char phoneDigit: phoneNumber.toCharArray()) {
			if(!Character.isDigit(phoneDigit)) {
				return false;				
			}
		}
		return true;
	}
	
	void removeContact(String callerID) {
		ArrayList<String> keysToDelete = new ArrayList<String>();
		if(contacts.containsValue(callerID)) {			
			for(Map.Entry<String, String> entry: contacts.entrySet()) {
				if(entry.getValue().equals(callerID)) {
					keysToDelete.add(entry.getKey());
				}
			}
		}
		for(String key: keysToDelete) {
			contacts.remove(key);
		}
	}
	
	String getCallerID(String phoneNumber) {
		if(contacts.containsKey(phoneNumber) && validatePhoneNumber(phoneNumber)) {
			return contacts.get(phoneNumber);
		}
		else {
			return "Private Caller";
		}
	}
	
	boolean hasPhone(String phoneNumber) {
		if(validatePhoneNumber(phoneNumber)) {
			if(contacts.containsKey(phoneNumber)) {
				return true;
			}
		}
		return false;		
	}
	
	void displayContactsList() {
		if(contacts.isEmpty()) {
			System.out.println("You have no contacts yet.");
			return;
		}
		for(Map.Entry<String, String> entry: contacts.entrySet()) {
			System.out.println("Caller ID: "+entry.getValue()+"  Phone: "+entry.getKey());			
		}
	}

}
