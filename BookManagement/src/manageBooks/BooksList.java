package manageBooks;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BooksList {
	HashMap<String, Book> booksList;
	Scanner sc = new Scanner(System.in);
	BooksList() {
		booksList = new HashMap<String, Book>();
	}
	
	static boolean validateISBN(String ISBN) {
		if(!(ISBN.length() <= 13)) {				
			return false;
		}
		for(char ISBNDigit: ISBN.toCharArray()) {
			if(!Character.isDigit(ISBNDigit)) {
				return false;
			}
		}
		return true;
	}
	
	void addBook() {
		Book book = new Book(sc);
		String ISBN = new String();
		
		System.out.println("Enter Book ISBN: ");
		ISBN = sc.nextLine();
		
		if(validateISBN(ISBN)) {
			booksList.put(ISBN, book);			
		}		
	}
	
	void removeBook(String ISBN) {
		if(validateISBN(ISBN)) {
			booksList.remove(ISBN);			
		}		
	}
	
	void displayBooksList() {
		for(Map.Entry<String, Book> entry: this.booksList.entrySet()) {
			System.out.println("ISBN: "+entry.getKey()+"  "+entry.getValue().bookInfo());						
		}
	}
	
	void displayBookByISBN(String ISBN) {
		if(validateISBN(ISBN)) {
			System.out.println(booksList.get(ISBN).bookInfo());
		}
	}
	
	void booksListSortedByPrice() {
		List<Map.Entry<String, Book>> sortedBooksList = new ArrayList<>(booksList.entrySet());
		
		CompareBookByPrice comparePrice = new CompareBookByPrice(); 
		
		sortedBooksList.sort(comparePrice);		
		
		for(Map.Entry<String, Book> entry: sortedBooksList) {
			System.out.println("ISBN: "+entry.getKey()+"  "+entry.getValue().bookInfo());						
		}
		
	}
	
	void booksListAbovePrice(double price) {
		for(Map.Entry<String, Book> entry: booksList.entrySet()) {
			if(entry.getValue().price > price) {
				System.out.println("ISBN: "+entry.getKey()+"  "+entry.getValue().bookInfo());				
			}
		}
	}
	
	void booksListByAuthor(String author) {
		for(Map.Entry<String, Book> entry: booksList.entrySet()) {
			if(entry.getValue().author.equals(author)) {
				System.out.println("ISBN: "+entry.getKey()+"  "+entry.getValue().bookInfo());				
			}
		}
		
	}
}
