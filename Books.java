package com.example.library;

import java.util.Scanner;
/**
 * This creates the books class
 */
public class Books {

    Book allBooks[] = new Book[25];  //Array of all the books in the library
    public static int count; //Total in library

    Scanner input = new Scanner(System.in);


    /**
     * Compares the two books by the name
     * @param b1, first book to compare
     * @param b2, second book to compare
     * @return 0 if books have the same name, 1 if not
     */
    public int compareBooks(Book b1, Book b2){

        if(b1.bookName.equalsIgnoreCase(b2.bookName)){
            System.out.println("This com.example.librarygroupproject.book already exists"); //Checks if the books are the same
            return 0; //Same name
        }
        return 1; //Different name
    }

    /**
     * Adds a new book to the library if the book does not already exist
     * @param b, book added
     */
    public void newBook(Book b){
        for (int i = 0; i<count; i++){
            if(this.compareBooks(b,this.allBooks[i])==0){  //Checking for duplicates
                return; //Exiting if the book exists or there is a duplicate
            }
        }

        //Checks if the library is full or not
        if (count < 25){
            allBooks[count] = b; //Add the book to the array
            count++;  //Add one to the count
        }
        else{
            System.out.println("com.example.librarygroupproject.Library is Full");
        }
    }
    
    /**
     * Searches by author and prompts for the author name
     */
    public void searchAuthor(){
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
        int flag = 0;  //Tracks whether any books by the inputted author are found in the library
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        
        //Loop through all the books and print the detail for the matching authors
        for(int i = 0; i<count; i++){
            if (authorName.equalsIgnoreCase(allBooks[i].authorName)){
                System.out.println(allBooks[i].bookName +"\t\t"
                        + allBooks[i].authorName + "\t\t"
                        + allBooks[i].genre + "\t\t"
                        + allBooks[i].bookQty + "\t\t"
                        + allBooks[i].bookQtyCopy);
                flag++;
            }
        }
        //Message for if no books by the author are found
        if (flag == 0){
            System.out.println("No com.example.librarygroupproject.books from that author found.");
        }
    }

    /**
     * Searches for a book by the serial number
     */
    public void searchBySno(){
        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        // Class data com.example.librarygroupproject.members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();
        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        //Loop through for all matching serial number books
        for (int i = 0; i < count; i++) {
            if (sNo == allBooks[i].sNo) {
                System.out.println(
                        allBooks[i].sNo + "\t\t"
                                + allBooks[i].bookName + "\t\t"
                                + allBooks[i].authorName + "\t\t"
                                + allBooks[i].bookQtyCopy + "\t\t"
                                + allBooks[i].bookQty);
                flag++;
                return;
            }
        }
         //Display if no matching book is found
        if (flag == 0)
            System.out.println("No Book for Serial No "
                    + sNo + " Found.");
    }
    
    /**
     * Displays all the books in the library
     */
    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        //Looping through and displaying all the books
        for (int i = 0; i < count; i++) {
            System.out.println(
                    allBooks[i].sNo + "\t\t"
                            + allBooks[i].bookName + "\t\t"
                            + allBooks[i].authorName + "\t\t"
                            + allBooks[i].bookQtyCopy + "\t\t"
                            + allBooks[i].bookQty);

        }
    }

    /**
     * Updates the qauntity of a book
     */
    public void upgradeBookQty(){
        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
        int sNo = input.nextInt();
        //Search for the book and update the quanitity of the book
        for (int i = 0; i < count; i++) {
            if (sNo == allBooks[i].sNo) {
                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                allBooks[i].bookQty += addingQty;
                allBooks[i].bookQtyCopy += addingQty;
                return;
            }
        }
    }

    /**
     * Method to display the menu
     */
    public void dispMenu(){
        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");

    }
    
    /**
     * Checks if a book is a by its name and the quantity
     * @param b, name of book
     * @return index number if found, -1 otherwise
     */
    public int isAvailable(String b){
        for(int i= 0; i<count; i++){
            if(b.equalsIgnoreCase(allBooks[i].bookName)){
                if(allBooks[i].bookQtyCopy > 0){
                    System.out.println(b + "is available.");
                    return i;
                }
                System.out.println(b + "is unavailable.");
                return -1;
            }
        }
      System.out.println("No book named" + b + "exists in library.");

        return -1;
    }

    /**
     * Method for checking out a book from the libraru
     * Method also reduces the number of available books by one
     * @return null or the book that is checked out
     */
    public Book checkOut(){
        System.out.println("Enter name of book to be checked out:");
        //User input
        String name = input.nextLine();
        int bookIndex = isAvailable(name);
        //If the book is available, the quantity is decreased
        if (bookIndex!= -1){
            allBooks[bookIndex].bookQtyCopy--;
            return allBooks[bookIndex];
        }
        //Null if the book is not available
        return null;
    }

    /**
     * Checks in the book that has been borrowed
     * Book quantity is increased if the book is returned
     * @param b, the book that has been checked out/is being returned
     */
    public void checkIn(Book b){
        // Loop through the list of book and find the match, if there is a match
        // Add one and increase the book quantity
        for (int i = 0; i < count; i++){
            if (b.equals(allBooks[i])){
                allBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
