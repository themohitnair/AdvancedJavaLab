package substringSearch;
import java.util.Scanner;

public class FreqSubstr {
	int substringFrequency(String str, String pat) {
		int index = 0;
		int freq = 0;
		while ((index = str.indexOf(pat, index)) != -1) {
			freq++;
			index += pat.length();
		}
		
		return freq;
	}
	
	public static void main(String args[]) {
		FreqSubstr ob = new FreqSubstr();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to be searched from: ");
		String str = sc.nextLine();
		System.out.println("Enter the String to be searched for: ");
		String pat = sc.nextLine();
		System.out.println("The substring " + pat + " occurs " + ob.substringFrequency(str, pat) + " times in the String");
		sc.close();
	}
}