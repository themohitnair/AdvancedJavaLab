package callSimulate;
import java.util.ArrayDeque;

public class MissedCalls {
	ArrayDeque<Call> missedCallsList;
	
	MissedCalls() {
		missedCallsList = new ArrayDeque<Call>();
	}
	
	void addCall(Call call) {
		if(missedCallsList.size() == 10) {
			missedCallsList.removeFirst();
		}
		missedCallsList.addLast(call);
	}
	
	void deleteCall() {
		missedCallsList.removeLast();
	}
	
	void displayCallsList(ContactList contactsList) {
		if(missedCallsList.isEmpty()) {
			System.out.println("You have no missed calls. ");
			return;
		}
		for(Call call: missedCallsList) {
			System.out.println(call.callInfo(contactsList));
		}
	}	
}
