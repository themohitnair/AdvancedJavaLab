package StringMeth;

import java.util.Scanner;

public class SubstrFreq {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println("Enter the substring to be searched for: ");
        String substr = sc.nextLine();
        System.out.println("Frequency of '" + substr + "' in '" + str + "' is: " + countSubstrings(str, substr));
    }

    public static int countSubstrings(String str, String substr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }
}