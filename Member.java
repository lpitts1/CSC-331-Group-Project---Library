package com.example.project_2_331;

import java.util.Scanner;

public class Member {

    String memberName;
    String actNumber;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Member()
    {
        System.out.println("Enter Member's Name:");

        this.memberName = input.nextLine();

        System.out.println("Enter Account Number:");
        this.actNumber = input.nextLine();
    }
}
