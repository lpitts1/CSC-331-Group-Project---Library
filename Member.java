package com.example.library;

import java.util.Scanner;

public class Member extends Members {

    String memberName;
    String actNumber;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Member(String actNumber, String memberName)
    {
        this.memberName = memberName;

        this.actNumber = actNumber;
    }
}
