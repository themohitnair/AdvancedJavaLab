package simulateCalls;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CallSimulator {
	static String genPhoneNumber() {
		Random r = new Random();
		ArrayList<String> nums = new ArrayList<String>(Arrays.asList("9854326804", "8105399399", "8073273865", "9738568404", "1234567809", "7902915034", "7764142321"));
		int i = r.nextInt(0, nums.size());
		return nums.get(i);
	}
	
	public static void main(String args[]) {
		ContactList c = new ContactList();
		CallLog log = new CallLog();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			String phone = genPhoneNumber();
			log.addCall(phone, c);
			System.out.println("You just received a call from "+c.retrieve(phone)+".");
			boolean contInner = true;
			while(contInner) {
				System.out.println("Your options are:\n0. Exit\n1. View Call Log\n2. Delete Recent Call\n3. Delete Call at Index\n4. Delete calls of a particular phone number\n5. Add to Contacts\n6. Delete from Contacts\n7. Next Call\n8. View Call Details\nEnter your choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 0: 
					System.exit(0);
				case 1:
					log.displayLog(c);
					break;
				case 2:
					log.deleteRecentCall();
					break;
				case 3:
					System.out.println("Enter the index at which the call is to be deleted: ");
					int index = Integer.parseInt(sc.nextLine());
					log.deleteCallAtIndex(index);
					break;
				case 4:
					System.out.println("Enter the phone number: ");
					String ph = sc.nextLine();
					if(c.validatePhone(phone)) {
						log.deleteCallOfPhone(ph);
					}
					break;
				case 5:
					System.out.println("Enter the ID of "+phone+".");
					String callerID = sc.nextLine();
					c.addContact(phone, callerID);
					break;
				case 6:
					c.deleteContact(phone);
					break;
				case 7:
					contInner = false;
					break;
				case 8:
					System.out.println(log.viewLastCallDetails(c));
					break;
				default:
					System.out.println("Invalid choice. Try again. ");
					
				}				
			}
		}
	}
}
