package genStack;

import java.util.ArrayList;
import java.util.Scanner;

class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
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

        System.out.println("Choose stack type: 1. String 2. Integer");
        int stackChoice = scanner.nextInt();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Push 2. Pop 3. Peek 4. Clear 5. Check Empty 6. Display 7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    if (stackChoice == 1) {
                        scanner.nextLine(); // Consume newline
                        stringStack.push(scanner.nextLine());
                    } else {
                        integerStack.push(scanner.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("Popped: " + (stackChoice == 1 ? stringStack.pop() : integerStack.pop()));
                    break;
                case 3:
                    System.out.println("Peek: " + (stackChoice == 1 ? stringStack.peek() : integerStack.peek()));
                    break;
                case 4:
                    if (stackChoice == 1) stringStack.clear(); else integerStack.clear();
                    System.out.println("Stack cleared");
                    break;
                case 5:
                    System.out.println("Is empty? " + (stackChoice == 1 ? stringStack.isEmpty() : integerStack.isEmpty()));
                    break;
                case 6:
                    if (stackChoice == 1) stringStack.display(); else integerStack.display();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
