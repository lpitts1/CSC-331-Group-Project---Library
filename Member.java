package com.example.library;

import java.util.Scanner;

/**
 * Represents a library member with an account number and that can borrow
 * books from the library, extends the 'Members' class
 */
public class Member extends Members {
    
    // Member name and account number
    String memberName;
    String actNumber;

    //Array of the books that the member is borrowing, with a max of 3
    Book borrowedBooks[] = new Book[3];

    //Tracking the current number of books
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);
    
    /**
     * Constructor to create the library member
     * @param actNumber, account number for the member
     * @param memberName, account number for the member
     */
    public Member(String actNumber, String memberName){
        //Setting the member name
        this.memberName = memberName;

        //Setting the member name
        this.actNumber = actNumber;
    }
}
