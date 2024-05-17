package callSimulate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Call {
	String phoneNumber;
	String callerID;
	String timeOfCall;
	
	Call(String phoneNumber, ContactList contactsList) {
		this.phoneNumber = phoneNumber;
		this.callerID = contactsList.getCallerID(this.phoneNumber);
		
		LocalTime currentTime = LocalTime.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
		
		this.timeOfCall = formattedTime;
	}
	
	String fetchCallerID(String phoneNumber, ContactList contactsList) {
		this.callerID = contactsList.getCallerID(phoneNumber);	
		return this.callerID;
	}
	
	String callInfo(ContactList contactsList) {
		return "Caller ID: "+this.fetchCallerID(phoneNumber, contactsList)+"  Phone Number: "+this.phoneNumber+"  Time of Call: "+this.timeOfCall;
	}
	
}
