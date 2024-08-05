package simulateCalls;
import java.time.LocalTime;

public class Call {
	String phone;
	LocalTime time;
	String callerID;
	Call(String phone, ContactList c) {
		this.phone = phone;
		this.time = LocalTime.now();
		if (c.validatePhone(phone)) {
			this.callerID = c.retrieve(phone);			
		}
	}
	
	public String toString(ContactList c) {
		return "Phone: " + this.phone + "  Caller ID: " + c.retrieve(this.phone) + "  Time of call: " + this.time;  
	}
}