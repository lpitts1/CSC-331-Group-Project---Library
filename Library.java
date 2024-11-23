package com.example.library;

import java.util.Scanner;

public class Library {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // create object of com.example.library.book class
        Books ob = new Books();
        // create object of member class
        Members obMember = new Members();

        int choice;
        int searchChoice;

        do{
            ob.dispMenu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    Book b = new Book("Moby Dick", "Herman Melville", "Fiction", 1);
                    ob.newBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Press 1 to search with com.example.library.book serial number.");
                    System.out.println("Press 2 to search with author name");
                    searchChoice = input.nextInt();

                    switch(searchChoice){
                        case 1:
                            ob.searchBySno();

                        case 2:
                            ob.searchAuthor();
                    }break;

                case 4:
                    ob.showAllBooks();

                case 5:
                    Member m = new Member("12345", "John Doe");
                    obMember.addMember(m);
                    break;

                case 6:
                    obMember.showMembers();
                    break;

                case 7:
                    //obMember.checkOut(ob);
                    break;

                case 8:
                    obMember.checkIn(ob);
                    break;

                default:

                    System.out.println("Enter number between 0 and 8");
            }
        }
        while (choice != 0);



    }
}
