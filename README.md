# Advanced Java Lab
A collection of Advanced Java Laboratory Programs (ISL48, RITB ISE 2022) 

## Questions and their corresponding Project directories in this Repository

1. Write program to demonstrate the working of String methods:
    a. To determine frequency of substrings in a string
    b. To check for anagrams (two strings having same characters)
a. -> [Click here](SubstringFreq/bin/substringSearch/)
b. -> [Click here](Anagrams/bin/anagramCheck/)

2. Write a program to create generic Stack class with push(), pop(), clear(), isEmpty() and display() methods. Demonstrate creation of Stack of String and Integer objects.
[Click here](StackGen/bin/genericStack/)

3. Write a Program that simulates a telephone that records missed incoming calls. For each missed call, store the time of call, telephone number of origin, and name of the caller if the name is available. For unlisted numbers, set the name to “private caller”. Choose or extend the most appropriate collection class and provide the following features.
    a. Numbers are recalled in the order they arrive
    b. After each number display, the user can select
        i. To delete the call
        ii. To display the call details (number, caller name and time). Delete the number if user specifies a number to delete.
Write a helper class to represent an incoming call with fields to hold the number, name of the caller, and time of the call. Write a tester call that stores the several numbers, simulate the user pressing the missed-calls button and finally prints the entire collection of stored calls.
[Click here](CallSimulation/bin/simulateCalls/)

4. Write a Java program using user-defined storage classes to create a book database and store it in a Collection List.
a. Book collection should include title, author, publisher and price. 
b. Write a method to sort the books in ascending order of price and store it in another list. Maintain the book details with respect to a unique book id.
c. Prompt for an author name and list all the books with the same author name.
[Click here](BookDB/src/dbOfBooks/)

5. Write a Java program using user-defined storage classes to create a book database and store it in a Collection List.
a. Books collection should include title, author, publisher and price. 
b. Maintain the book details with respect to a unique book id. Create a new list holding all the book details with price greater than a user specified price.
c. Prompt for a publisher name and list all the books with the same publisher name. 
[Click here](BookDB/src/dbOfBooks/)

6. Create a desktop java application using swings to enable a user to enter student information such as name, usn, age, address, sgpa of 4 semesters, category.
a. Perform validations on all the fields. Display appropriate messages in pop up boxes to indicate wrong entries.
b. On clicking of the “compute” button, find the cgpa. On clicking of the “done” button, place the student details in a collection. Display the collection in a textarea on the click of a button.
[Click here](StudentInformation/src/stuInfo)

7. Write a java program using Swing to perform the following: 
    a. Allow the user to enter the item purchased by giving the item id and quantity purchased.
    b. On clicking of a button, the item name and the total cost should appear in the corresponding GUI components.
    c. Using option dialog box, indicate the types of discount available for the customer. On clicking on the print button, print the details of final cost in information dialog box.
[Click here](Shop/src/shop/)

8. Write a program that uses Java Swing and JDBC to create a stand-alone application. Create a table named Customer (CustNo, CustName, State, Credit_Limit) in MySQL database. Use appropriate Swing components to insert values in a form and populate the MySQL table. Using JDBC, display the Customer table.
[Click here](Customers/src/custs)

9. Write a program that uses Java Swing and JDBC to create a stand-alone application. Create a table named Representative (RepNo, RepName, State, Comission, Rate) in MySQL database. Use appropriate Swing components to insert values in a form and populate the MySQL table. Using JDBC, display the Representative table.
[Click here](Representatives/src/reps)