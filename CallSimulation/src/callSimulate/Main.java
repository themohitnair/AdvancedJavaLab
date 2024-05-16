package callSimulate;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String generateRandomPhoneNumberFromList() {
		Random random = new Random();
		ArrayList<String> phoneNumberList = new ArrayList<String>(Arrays.asList("8073273865", "3298732859", "8123037597", "8884255882", "5120460504", "6362234444", "7171474289", "8898589381", "1889843422", "9274238612"));
		return phoneNumberList.get(random.nextInt(10));
	}
	
	public static void main(String args[]) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		ContactList contactsList = new ContactList();
		MissedCalls missedCallsList = new MissedCalls();
		while(choice != 7) {
			
			String randomCall = generateRandomPhoneNumberFromList();
			Call call = new Call(randomCall, contactsList);
			System.out.println("\nYou have received a missed call from "+call.callerID+". Your options: ");			
			missedCallsList.addCall(call);
			System.out.println("1. View Caller Details");
			System.out.println("2. Show Call Log");
			System.out.println("3. Add Caller to Contacts");
			System.out.println("4. Delete Call from Log");
			System.out.println("5. Delete Caller from Contacts");
			System.out.println("6. Display Contact List");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				System.out.println("\n"+call.callInfo(contactsList));
				break;
			case 2:
				System.out.println();
				missedCallsList.displayCallsList(contactsList);
				break;
			case 3:
				System.out.println("\nEnter the Caller ID you'd like to assign to this caller: ");
				String CallerIDToAdd = sc.nextLine();
				contactsList.addContact(call.phoneNumber, CallerIDToAdd);
				break;
			case 4:
				missedCallsList.deleteCall();
				System.out.println("\nContact Deleted from Call Log.");
				break;
			case 5:
				System.out.println("\nEnter the Caller ID you'd like to delete from the contacts: ");
				String CallerIDToDelete = sc.nextLine();
				contactsList.removeContact(CallerIDToDelete);
				System.out.println("Contact Deleted from Contact List.");
				break;
			case 6:
				System.out.println();
				contactsList.displayContactsList();
				break;
			case 7:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Retry. ");				
				
			}
			
		}
		sc.close();
	}
}
