package customerLogin;
import java.util.HashMap;

public class CustomerCollection {
	HashMap<String, Integer> cusCol = new HashMap<String, Integer>();
	int nextID = 1;
	
	boolean ValidatePhone(String phone) {
		boolean isValidPhone = true;
		for (char ch: phone.toCharArray()) {
			if(!Character.isDigit(ch)) {
				isValidPhone = false;
			}
		}
		if (phone.length() != 10) {
			isValidPhone = false;
		}
		return isValidPhone;
	}
	
	void addNewCustomer(String phone) {
		
		if (ValidatePhone(phone) && !checkCustomerExists(phone)) {
			cusCol.put(phone, this.nextID);
			nextID += 1;
		} else {
			System.out.println("Invalid phone");
		}
	}
	
	boolean checkCustomerExists(String phone) {
		if (cusCol.containsKey(phone.trim())) {
			return true;
		}
		return false;		
	}
	
	int retrieveCustomerID(String phone) {
		if(checkCustomerExists(phone) && ValidatePhone(phone)) {
			return cusCol.get(phone);
		}
		else {
			return -1;
		}
	}
}