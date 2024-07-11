package genStack;

import java.util.ArrayList;
import java.util.Scanner;

class Stack<T> {
	private ArrayList<T> stack = new ArrayList<>();

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public void clear() {
        stack.clear();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println(stack);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        boolean exit = false;

        System.out.println("Choose the type of stack to interact with:");
        System.out.println("1. String Stack");
        System.out.println("2. Integer Stack");
        System.out.print("Enter your choice: ");
        int stackChoice = scanner.nextInt();

        while (!exit) {
            System.out.println("\nChoose an operation:");
            if (stackChoice == 1) {
                System.out.println("1. Push to String Stack");
                System.out.println("2. Pop from String Stack");
                System.out.println("3. Peek at String Stack");
                System.out.println("4. Clear String Stack");
                System.out.println("5. Check if String Stack is Empty");
                System.out.println("6. Display String Stack");
            } else if (stackChoice == 2) {
                System.out.println("1. Push to Integer Stack");
                System.out.println("2. Pop from Integer Stack");
                System.out.println("3. Peek at Integer Stack");
                System.out.println("4. Clear Integer Stack");
                System.out.println("5. Check if Integer Stack is Empty");
                System.out.println("6. Display Integer Stack");
            }
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (stackChoice == 1) {
                        System.out.print("Enter a string to push: ");
                        scanner.nextLine(); // Consume newline
                        String strValue = scanner.nextLine();
                        stringStack.push(strValue);
                    } else {
                        System.out.print("Enter an integer to push: ");
                        int intValue = scanner.nextInt();
                        integerStack.push(intValue);
                    }
                    break;
                case 2:
                    if (stackChoice == 1) {
                        System.out.println("Popped: " + stringStack.pop());
                    } else {
                        System.out.println("Popped: " + integerStack.pop());
                    }
                    break;
                case 3:
                    if (stackChoice == 1) {
                        System.out.println("Peek: " + stringStack.peek());
                    } else {
                        System.out.println("Peek: " + integerStack.peek());
                    }
                    break;
                case 4:
                    if (stackChoice == 1) {
                        stringStack.clear();
                        System.out.println("String Stack cleared");
                    } else {
                        integerStack.clear();
                        System.out.println("Integer Stack cleared");
                    }
                    break;
                case 5:
                    if (stackChoice == 1) {
                        System.out.println("Is String Stack empty? " + stringStack.isEmpty());
                    } else {
                        System.out.println("Is Integer Stack empty? " + integerStack.isEmpty());
                    }
                    break;
                case 6:
                    if (stackChoice == 1) {
                        System.out.print("String Stack: ");
                        stringStack.display();
                    } else {
                        System.out.print("Integer Stack: ");
                        integerStack.display();
                    }
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
