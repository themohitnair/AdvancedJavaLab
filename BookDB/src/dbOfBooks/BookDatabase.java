package dbOfBooks;
import java.util.Scanner;

public class BookDatabase {
	
	public static void main(String args[]) {
		BooksList bList = new BooksList();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("----BOOK REGISTRY----");
			System.out.println("0. Exit\n1. Add a book\n2. Delete a book\n3. Get books sorted by price\n4. Get books above a certain price\n5. Get books by Author name\n6. Get books by Publisher name");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 0: 
				System.exit(0);
			case 1:
				bList.addBook();
				break;
			case 2:
				System.out.println("Enter the ISBN of the book to delete. ");
				String ISBN = sc.nextLine();
				bList.deleteBook(ISBN);
				break;
			case 3:
				bList.sortBooksByPrice();
				break;
			case 4:
				System.out.println("Enter the price: ");
				double price = Double.parseDouble(sc.nextLine());
				bList.getBooksAbovePrice(price);
				break;
			case 5:
				System.out.println("Enter the name of the author: ");
				String author = sc.nextLine();
				bList.getBooksByAuthor(author);
				break;
			case 6:
				System.out.println("Enter the name of the publisher: ");
				String publisher = sc.nextLine();
				bList.getBooksByPublisher(publisher);
				break;
			default:
				System.out.println("Invalid entry. Please try again. ");			
			}			
		}
	}
}