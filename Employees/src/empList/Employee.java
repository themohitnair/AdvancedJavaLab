package empList;
import java.util.Scanner;


public class Employee {
	int id;
	double salary;
	String name;
	
	Employee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the employee: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name of the employee: ");
		this.name = sc.nextLine();
		System.out.println("Enter the salary of the employee: ");		
		this.salary = sc.nextDouble();
		sc.nextLine();
	}
	
	String getEmployeeInfo() {
		return "ID: "+this.id+"  Name: "+this.name+"  Salary: "+this.salary;
	}
}
