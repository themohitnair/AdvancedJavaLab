package checkAnagrams;
import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = sc.nextLine();
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + areAnagrams(str1, str2));
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.trim().length() != str2.trim().length()) {
            return false;
        }

        char[] charArray1 = str1.trim().toCharArray();
        char[] charArray2 = str2.trim().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}