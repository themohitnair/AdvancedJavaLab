# Advanced Java Lab

A collection of Advanced Java Laboratory Programs (ISL48, RITB ISE 2022).

## Questions and Their Corresponding Project Directories in This Repository

1. **Write a program to demonstrate the working of String methods:**
   - **a.** To determine the frequency of substrings in a string  
     **[Click here](SubstringFreq/src/substringSearch/)**
   - **b.** To check for anagrams (two strings having the same characters)  
     **[Click here](Anagrams/src/anagramCheck/)**

2. **Write a program to create a generic Stack class with `push()`, `pop()`, `clear()`, `isEmpty()`, and `display()` methods. Demonstrate the creation of a Stack of String and Integer objects.**  
   **[Click here](StackGen/src/genericStack/)**

3. **Write a program that simulates a telephone that records missed incoming calls. For each missed call, store the time of the call, telephone number of origin, and name of the caller if the name is available. For unlisted numbers, set the name to “private caller”. Choose or extend the most appropriate collection class and provide the following features:**
   - **a.** Numbers are recalled in the order they arrive.
   - **b.** After each number display, the user can select:
     - **i.** To delete the call.
     - **ii.** To display the call details (number, caller name, and time). Delete the number if the user specifies a number to delete.
   - Write a helper class to represent an incoming call with fields to hold the number, name of the caller, and time of the call. Write a tester class that stores several numbers, simulates the user pressing the missed-calls button, and finally prints the entire collection of stored calls.  
   **[Click here](CallSimulation/src/simulateCalls/)**

4. **Write a Java program using user-defined storage classes to create a book database and store it in a Collection List:**
   - **a.** The book collection should include title, author, publisher, and price.
   - **b.** Write a method to sort the books in ascending order of price and store them in another list. Maintain the book details with respect to a unique book ID.
   - **c.** Prompt for an author name and list all the books with the same author name.  
   **[Click here](BookDB/src/dbOfBooks/)**

5. **Write a Java program using user-defined storage classes to create a book database and store it in a Collection List:**
   - **a.** The book collection should include title, author, publisher, and price.
   - **b.** Maintain the book details with respect to a unique book ID. Create a new list holding all the book details with a price greater than a user-specified price.
   - **c.** Prompt for a publisher name and list all the books with the same publisher name.  
   **[Click here](BookDB/src/dbOfBooks/)**

6. **Create a desktop Java application using Swing to enable a user to enter student information such as name, USN, age, address, and SGPA of 4 semesters, and category:**
   - **a.** Perform validations on all the fields. Display appropriate messages in popup boxes to indicate wrong entries.
   - **b.** On clicking the “compute” button, find the CGPA. On clicking the “done” button, place the student details in a collection. Display the collection in a textarea on the click of a button.  
   **[Click here](StudentInformation/src/stuInfo/)**

7. **Write a Java program using Swing to perform the following:**
   - **a.** Allow the user to enter the item purchased by giving the item ID and quantity purchased.
   - **b.** On clicking a button, the item name and the total cost should appear in the corresponding GUI components.
   - **c.** Using an option dialog box, indicate the types of discounts available for the customer. On clicking the print button, print the details of the final cost in an information dialog box.  
   **[Click here](Shop/src/shop/)**

8. **Write a program that uses Java Swing and JDBC to create a stand-alone application. Create a table named `Customer` (CustNo, CustName, State, Credit_Limit) in a MySQL database. Use appropriate Swing components to insert values in a form and populate the MySQL table. Using JDBC, display the `Customer` table.**  
   **[Click here](Customers/src/custs/)**

9. **Write a program that uses Java Swing and JDBC to create a stand-alone application. Create a table named `Representative` (RepNo, RepName, State, Commission, Rate) in a MySQL database. Use appropriate Swing components to insert values in a form and populate the MySQL table. Using JDBC, display the `Representative` table.**  
   **[Click here](Representatives/src/reps/)**