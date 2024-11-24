package com.example.library;

import java.util.Scanner;
// main library class 
public class Library {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // create object of com.example.library.book class
        Books ob = new Books();
        // create object of member class
        Members obMember = new Members();

        int choice;
        int searchChoice;
        // displays menu
        do{
            ob.dispMenu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    //add moby dick to library
                    Book b = new Book("Moby Dick", "Herman Melville", "Fiction", 1);
                    ob.newBook(b);
                    break;

                case 2:
                    //increase quantity of book
                    ob.upgradeBookQty();
                    break;

                case 3:
                    //search for book 
                    System.out.println("Press 1 to search with com.example.library.book serial number.");
                    System.out.println("Press 2 to search with author name");
                    searchChoice = input.nextInt();
                    
                    switch(searchChoice){
                        case 1:
                            ob.searchBySno();// serial number search

                        case 2:
                            ob.searchAuthor();// author search
                    }break;

                case 4:
                    ob.showAllBooks(); //display all books

                case 5:
                    Member m = new Member("12345", "John Doe");
                    obMember.addMember(m);
                    break;

                case 6:
                    obMember.showMembers();
                    // shows all members
                    break;

                case 7:
                    //obMember.checkOut(ob);
                    break;

                case 8:
                    // check in a book 
                    obMember.checkIn(ob);
                    break;

                default:
                    // invalid choice error
                    System.out.println("Enter number between 0 and 8");
            }
        }
        while (choice != 0);



    }
}
