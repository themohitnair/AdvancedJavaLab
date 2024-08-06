package dbOfBooks;
import java.util.Scanner;

public class Book {
	String ISBN;
	String title;
	String author;
	String publisher;
	double price;
	
	Book() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ISBN of the book: ");
		String isbn = sc.nextLine();
		if (validateISBN(isbn)) {
			this.ISBN = isbn;
		} else {
			System.out.println("Invalid ISBN");
			return;
		}
		System.out.println("Enter the Title of the book: ");
		this.title = sc.nextLine();
		System.out.println("Enter the Author name: ");
		this.author = sc.nextLine();
		System.out.println("Enter the Publisher name: ");
		this.publisher = sc.nextLine();
		System.out.println("Enter the Price of the book: ");
		this.price = Double.parseDouble(sc.nextLine());
	}
	
	static boolean validateISBN(String ISBN) {
		if (ISBN.length() != 10)		 {
			return false;
		}
		else {
			for (char dig: ISBN.toCharArray()) {
				if (!Character.isDigit(dig)) {
					return false;					
				}
			}
		}
		return true;
	}	
	
	public String toString() {
		return "ISBN: " + this.ISBN + "  Title: " + this.title + "  Author: " + this.author + "  Publisher: " + this.publisher + "  Price: " + this.price;
	}
}
