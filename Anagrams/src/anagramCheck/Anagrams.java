package anagramCheck;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
	boolean checkAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;		
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		if (Arrays.equals(s1, s2)) return true;
		else return false;
	}
	
	public static void main(String args[]) {
		Anagrams ob = new Anagrams();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String s1 = sc.nextLine();
		System.out.println("Enter the second string: ");
		String s2 = sc.nextLine();
		if (ob.checkAnagram(s1, s2)) System.out.println("The two strings are anagrams. ");
		else System.out.println("The two strings are not anagrams. ");
		sc.close();
	}
}
