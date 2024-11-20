package com.example.project_2_331;


import java.time.LocalDate;

public class BookTesting {
    public String bookName;
    public String authorName;
    public String genre;
    public int bookQty;
    public LocalDate checkOutDate;

    // Constructor for library usage?
    public BookTesting(String bookName, String authorName, String genre, int bookQty)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.bookQty = bookQty;
    }

    // Constructor for checked out books usage?
    public BookTesting(String bookName, String authorName, String genre, LocalDate checkOutDate)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.checkOutDate = checkOutDate;
    }
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenre() {
        return genre;
    }

    public int getBookQty() {

        return bookQty;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
