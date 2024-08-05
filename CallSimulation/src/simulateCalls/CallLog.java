package simulateCalls;
import java.util.ArrayList;
import java.util.Iterator;

public class CallLog {
	ArrayList<Call> cLog;
	
	CallLog() {
		cLog = new ArrayList<Call>();
	}
	
	void addCall(String phone, ContactList c) {
		Call call = new Call(phone, c);
		if (cLog.size() == 10) {
			cLog.remove(0);
		}
		this.cLog.add(call);
	}
	
	void deleteRecentCall() {
		if (!cLog.isEmpty()) {
			this.cLog.remove(this.cLog.size() - 1);
		}
	}
	
	void deleteCallAtIndex(int index) {
		if (index < 10 && index >= 0) {
			this.cLog.remove(index);
		}
	}
	
	void deleteCallOfPhone(String phone) {
		Iterator<Call> it = this.cLog.iterator();
		while (it.hasNext()) {
			if (it.next().phone.equals(phone)) {
				it.remove();
			}
		}		
	}	
	
	String viewLastCallDetails(ContactList c) {
		if (!this.cLog.isEmpty()) {
			Call lastCall = this.cLog.get(this.cLog.size() - 1);
			return lastCall.toString(c);			
		}
		return "No Calls yet.";		
	}
	
	void displayLog(ContactList c) {
		for (Call call: this.cLog) {
			System.out.println(call.toString(c));
		}		
	}
}
