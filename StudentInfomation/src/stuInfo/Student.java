package stuInfo;
import java.util.Scanner;

public class Student {
	String name, address, category;
	int age, usn;
	double[] SGPA;
	Scanner sc = new Scanner(System.in);
	
	Student(String name, int usn, int age, String address, String category, double sgpa1, double sgpa2, double sgpa3, double sgpa4) {
		this.name = name;
		this.usn = usn;
		this.age = age;
		this.address = address;
		this.category = category;
		this.SGPA = new double[]{sgpa1, sgpa2, sgpa3, sgpa4};
	}
	
	double CGPA() {
		double sum = 0;
		for (double sgpa: this.SGPA ) {
			sum += sgpa;
		}
		return (sum / 4.0);
	}
	
	public String toString() {
		return "Name: " + this.name + "\nUSN: " + this.usn + "\nAge: " + this.age + "\nAddress: " + this.address + "\nCategory: " + this.category + "\nCGPA: " + this.CGPA();
	}
}