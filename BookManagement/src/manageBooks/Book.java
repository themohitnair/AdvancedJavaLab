package manageBooks;
import java.util.Scanner;

public class Book {
	String title;
	String publisher;
	double price;
	String author;
	Book(Scanner sc) {
		System.out.println("Enter the Title of the book: ");
		title = sc.nextLine();
		System.out.println("Enter the name of the Author of the book: ");
		author = sc.nextLine();
		System.out.println("Enter the name of the Publisher of the book: ");
		publisher = sc.nextLine();
		System.out.println("Enter the Price of the book: ");
		price = Double.parseDouble(sc.nextLine());				
	}
	
	String bookInfo() {
		return "Title: "+this.title+"  Publisher: "+this.publisher+"  Author: "+this.author+"  Price: "+this.price;
	}
}
