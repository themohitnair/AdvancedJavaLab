package dbOfBooks;
import java.util.Comparator;

public class CompareBooks implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return Double.compare(b1.price, b2.price);
	}
}