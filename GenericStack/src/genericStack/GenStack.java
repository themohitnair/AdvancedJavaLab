package genericStack;
import java.util.ArrayDeque;
import java.util.Scanner;

public class GenStack<T> {
	ArrayDeque<T> stack;
	
	GenStack() {
		stack = new ArrayDeque<T>();
	}
	
	void push(T ele) {
		stack.addLast(ele);
	}
	
	T pop() {
		T ele = stack.pollLast();
		if (ele == null) {
			System.out.println("Stack is empty");
		}
		return ele;
	}
	
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	void clear() {
		stack.clear();
	}
	
	void display() {
		if (stack.isEmpty() == false) {
			for (T ele: stack) {
				System.out.print(" " + ele);
			}			
		}
		else {
			System.out.print("Stack is empty");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		GenStack<Integer> stack = new GenStack<Integer>();
		
		while (true) {
			System.out.println("0. Exit\n1. Push element\n2. Pop\n3. Check if the stack is empty\n4. Clear Stack\n5. Display Stack\nEnter your choice (0, 1, 2, 3, 4, 5): ");
			
			int choice = 0;
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 0:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter the element: ");
				int ele = Integer.parseInt(sc.nextLine());
				stack.push(ele);
				break;
			case 2:
				System.out.println("The popped element is: " + stack.pop());
				break;
			case 3:
				if (stack.isEmpty()) {
					System.out.println("Stack is empty.");
				}
				else {
					System.out.println("Stack is not empty. ");
				}
				break;
			case 4:
				System.out.println("Stack cleared.");
				stack.clear();
				break;
			case 5:
				if (stack.isEmpty()) {
					System.out.println("Stack is empty. No elements");
				} else {
					System.out.println("The elements are: ");
					stack.display();
				}
				break;
			default: 
				System.out.println("Invalid choice. Try again.");
			}					
		}		
	}
}