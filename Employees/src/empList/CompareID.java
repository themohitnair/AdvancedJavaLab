package empList;
import java.util.Comparator;

public class CompareID implements Comparator<Employee> {
	@Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.id, e2.id);
    }
}
