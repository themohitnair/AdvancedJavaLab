package empList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class EmployeeList {
	ArrayList<Employee> emplist;
	
	EmployeeList() {
		emplist = new ArrayList<>();
	}
	
	void addEmployee() {
		Employee e = new Employee();
		emplist.add(e);
	}
	
	Employee getEmployeeByName(String givenName) {
		for(Employee e: emplist) {
			if (e.name.equals(givenName.trim())) {
				return e;
			}
		}
		return null;
	}
	
	void sortEmployeeByID() {
		Collections.sort(this.emplist, new CompareID());		
	}
	
	void filterBySalary(double givenSalary) {
		for(Employee e: emplist) {
			if (e.salary > givenSalary) {
				System.out.println(e.getEmployeeInfo());
			}
		}
	}
	
	void printList() {
		for(Employee e: emplist) {
			System.out.println(e.getEmployeeInfo());
		}
		
	}
	
	public static void main(String args[]) {
		EmployeeList emplist = new EmployeeList();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your choice: \n0. Exit\n1. Add Employee\n2. Retrieve by name\n3. Sort by ID\n4. Filter by Salary\n");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 0:
				System.exit(0);
				break;
			case 1:
				emplist.addEmployee();
				break;
			case 2:
				System.out.println("Enter the name: ");
				String name = sc.nextLine();
				Employee e = emplist.getEmployeeByName(name);
				System.out.println(e.getEmployeeInfo());
				break;
			case 3:
				emplist.sortEmployeeByID();
				emplist.printList();
				break;
			case 4:
				System.out.println("Enter the filter salary: ");
				double salary = Double.parseDouble(sc.nextLine());
				emplist.filterBySalary(salary);
				break;
			default:
				System.out.println("Invalid choice. Try again");				
			}
		}
	}
}
