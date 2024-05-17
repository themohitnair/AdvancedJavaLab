package manageBooks;
import java.util.Comparator;
import java.util.Map;

public class CompareBookByPrice implements Comparator<Map.Entry<String, Book>>{
	@Override
	public int compare(Map.Entry<String, Book> entry1, Map.Entry<String, Book> entry2) {
		return Double.compare(entry1.getValue().price, entry2.getValue().price);		
	}
	
}
