package com.example.library;

import java.util.Scanner;

/**
 * Represents a collection of members
 */
public class Members {
    Scanner input = new Scanner(System.in);
    
    //Array of all of the members with a max of 20
    Member allMembers[] = new Member[20];
    
    //Count of all members
    public static int count = 0;
    
    /**
     * This method adds a new member to the members of the library system
     * @param m, the member object to be added to the library system
     */
    public void addMember(Member m) {
        //Checks if the member already exists
        for (int i = 0; i < count; i++) {
            if (m.actNumber.equalsIgnoreCase(
                    allMembers[i].actNumber)) {
                System.out.println("Member" + m.actNumber + "already exists.");
                //Returns, no need to add an already existing member
                return;
            }
        }
        
        //If there is enough space, add the member and add one to the member count
        if (count <= 20) {
            allMembers[count] = m;
            count++;
        }
    }
    
    /**
     * Displays all of the registered members of the library
     */
    public void showMembers(){
            System.out.println("Member Name\t\tAccount Number");
            
            //Display the information for the member
            for (int i = 0; i<count; i++){
                System.out.println(allMembers[i].memberName + "\t\t"+ allMembers[i].actNumber);
            }
        }
    
    /**
     * Checks the status of a member using their account number
      * @return the index of the member if the member is found, -1 otherwise
     */
    public int memberStatus(){
        System.out.println("Enter Account Number:");
        String actNumber = input.nextLine();
        
        //Search for the member with the given account number
        for (int i = 0; i<count; i++){
            if(allMembers[i].actNumber.equalsIgnoreCase(actNumber)){
                return i; //Member found, returning the member's index number
            }
        }
        System.out.println("Member is not registered, please register member");
        return -1; //Member is not found
    }
    
    /**
     * This method allows a member to checkout a book from the library
     * @param book, the book object that the member wants to checkout
     */
    public void checkOut(Books book){
        int memberIndex = this.memberStatus(); //Get the index of the member
        
        //If the member is found
        if (memberIndex != -1){
            System.out.println("Checking out");
            
            //Display all the available books
            book.showAllBooks();
            Book b = book.checkOut(); //Checkout the book

            System.out.println("Checking out");
            //If the book is available and the member has room, checkout the book, add one to the members books count
            if (b != null){
                if(allMembers[memberIndex].booksCount <= 3){
                    System.out.println("adding book");
                    allMembers[memberIndex].borrowedBooks[allMembers[memberIndex].booksCount] = b;
                    allMembers[memberIndex].booksCount++;
                    return;
                }
                else{
                    System.out.println("You cannot borrow more than 3 books.");
                    return;
                }
            }
        System.out.println("Book not available");
        }
    }

    /**
     * Allows a member to return/check in a book they have borrowed
     * @param book, the book being returned
     */
    public void checkIn(Books book){
        int memberIndex = this.memberStatus(); //Get the index of the member
        
        // If the member is found
        if (memberIndex != -1){
            System.out.println("Here are the books currently borrowed:");

            Member m = allMembers[memberIndex];
            //Display the borrowed books of the member
            for (int i = 0; i < m.booksCount; i++){
                System.out.println(m.borrowedBooks[i].bookName
                + "by" + m.borrowedBooks[i].authorName);
            }
            
        System.out.println("Enter name of book to be checked in:");
        String name = input.nextLine();
            
        //Search for the book to check in, in the members list of borrowed books
        for(int i = 0; i < m.booksCount; i++){
            //If the book is found then return the book, otherwise print message
            if (name.equalsIgnoreCase(m.borrowedBooks[i].bookName)){
                book.checkIn(m.borrowedBooks[i]);
                m.borrowedBooks[i] = null;
                return;
                }
            }
        System.out.println("Book" + name + "not found.");
        }
    }
}
