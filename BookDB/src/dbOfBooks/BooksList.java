package dbOfBooks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class BooksList {
	ArrayList<Book> bList;
	
	BooksList() {
		this.bList = new ArrayList<Book>();
	}
	
	void addBook() {
		Book book = new Book();
		Iterator<Book> it = this.bList.iterator();
		while(it.hasNext()) {
			Book listbook = it.next();
			if (listbook.ISBN.equals(book.ISBN) || (book.ISBN == null)) {
				System.out.println("Book with the same ISBN aleady exists or the ISBN is invalid.");
				return;
			}
		}
		this.bList.add(book);				
	}
	
	void deleteBook(String ISBN) {
		Iterator<Book> it = this.bList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (Book.validateISBN(ISBN) && book.ISBN.equals(ISBN)) {
				it.remove();				
			}
		}
	}
	
	void getBooksByAuthor(String Author) {
		Iterator<Book> it = this.bList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.author.equals(Author)) {
				System.out.println(book.toString());			
			}
		}
	}
	
	void getBooksByPublisher(String Publisher) {
		Iterator<Book> it = this.bList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.publisher.equals(Publisher)) {
				System.out.println(book.toString());		
			}
		}
	}
	
	void getBooksAbovePrice(double Price) {
		Iterator<Book> it = this.bList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.price > Price) {
				System.out.println(book.toString());		
			}
		}		
	}
	
	void sortBooksByPrice() {
		CompareBooks c = new CompareBooks();
		Collections.sort(this.bList, c);
		this.displayBooksList();
	}
	
	void displayBooksList() {
		Iterator<Book> it = this.bList.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			System.out.println(book.toString());
		}			
	}
}
