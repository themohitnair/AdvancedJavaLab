package genericStack;
import java.util.ArrayDeque;

public class GenStack<T> {
	ArrayDeque<T> stack;
	
	GenStack() {
		stack = new ArrayDeque<T>();
	}
	
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	void push(T ele) {
		stack.addLast(ele);
	}
	
	T pop() {
		if (this.isEmpty()) {
			return null;
		}
		return stack.removeLast();
	}
	
	void clear() {
		stack.clear();
	}
	
	void display() {
		System.out.print("Stack elements: ");
		for (T ele: stack) {
			System.out.print(" " + ele);
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		GenStack<Integer> intStack = new GenStack<Integer>();
		System.out.println("Integer Generic Stack: ");
		System.out.println("Pushing elements 69, 42, and 33. ");
		intStack.push(69);
		intStack.push(42);
		intStack.push(33);
		intStack.display();
		System.out.println("Popping two elements. ");
		System.out.println("Popped element 1: " + intStack.pop());
		System.out.println("Popped element 2: " + intStack.pop());
		intStack.display();
		System.out.println("Checking if the array is empty: ");
		System.out.println("Is the array empty? " + intStack.isEmpty());
		intStack.display();
		System.out.println("Clearing the stack. ");		
		intStack.clear();
		System.out.println("Checking again if the array is empty: ");
		System.out.println("Is the array empty? " + intStack.isEmpty());
		System.out.println();
		GenStack<String> strStack = new GenStack<String>();
		System.out.println("String Generic Stack: ");
		System.out.println("Pushing elements john, jack, and steve. ");
		strStack.push("john");
		strStack.push("jack");
		strStack.push("steve");
		strStack.display();
		System.out.println("Popping two elements. ");
		System.out.println("Popped element 1: " + strStack.pop());
		System.out.println("Popped element 2: " + strStack.pop());
		strStack.display();
		System.out.println("Checking if the array is empty: ");
		System.out.println("Is the array empty? " + strStack.isEmpty());
		strStack.display();
		System.out.println("Clearing the stack. ");		
		strStack.clear();
		System.out.println("Checking again if the array is empty: ");
		System.out.println("Is the array empty? " + strStack.isEmpty());
	}
}
