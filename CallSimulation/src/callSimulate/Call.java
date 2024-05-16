package callSimulate;
import java.time.LocalTime;

public class Call {
	String phoneNumber;
	String callerID;
	LocalTime timeOfCall;
	
	Call(String phoneNumber, ContactList contactsList) {
		this.phoneNumber = phoneNumber;
		if(contactsList.hasPhone(phoneNumber)) {
			this.callerID = contactsList.getCallerID(phoneNumber);
		}
		this.timeOfCall = LocalTime.now();
	}
	
	String fetchCallerID(String phoneNumber, ContactList contactsList) {
		this.callerID = contactsList.getCallerID(phoneNumber);	
		return this.callerID;
	}
	
	String callInfo(ContactList contactsList) {
		return "Caller ID: "+this.fetchCallerID(phoneNumber, contactsList)+"  PhoneNumber: "+this.phoneNumber+"  Time of Call: "+this.timeOfCall;
	}
	
}
