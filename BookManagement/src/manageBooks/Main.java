package manageBooks;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		BooksList books = new BooksList();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(choice != 7) {
			System.out.println("Book Management System. Options: ");
			System.out.println("1. Add a Book");
			System.out.println("2. Remove a Book by ISBN");
			System.out.println("3. View Books List");
			System.out.println("4. View Books List Sorted by Price");
			System.out.println("5. View Books List of Books above a given price");
			System.out.println("6. View Books List of Books written by a given author");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				System.out.println();
				books.addBook();
				break;
			case 2:
				System.out.println("\nEnter the ISBN of the book to be deleted: ");
				String ISBNToBeDeleted = sc.nextLine();
				books.removeBook(ISBNToBeDeleted);
				break;
			case 3:
				System.out.println();
				books.displayBooksList();
				break;
			case 4:
				System.out.println();
				books.booksListSortedByPrice();
				break;
			case 5:
				System.out.println("\nEnter the price: ");
				double abovePrice = Double.parseDouble(sc.nextLine());
				books.booksListAbovePrice(abovePrice);
				break;
			case 6:
				System.out.println("\nEnter the author: ");
				String byAuthor = sc.nextLine();
				books.booksListByAuthor(byAuthor);
				break;
			case 7:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;			
			}
		}
		sc.close();
	}

}
