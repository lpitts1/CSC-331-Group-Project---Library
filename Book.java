package com.example.library;


import java.time.LocalDate;

public class Book {
    public String bookName;
    public String authorName;
    public String genre;
    public int bookQty;
    public int bookQtyCopy;
    public int sNo;
    public LocalDate checkOutDate;

    // Constructor for library usage?
    public Book(String bookName, String authorName, String genre, int bookQty)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.bookQty = bookQty;
    }

    // Constructor for checked out com.example.librarygroupproject.books usage?
    public Book(String bookName, String authorName, String genre, LocalDate checkOutDate)
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

    public void checkOut(){
        this.bookQty = bookQty -1;
    }
    public void checkIn(){
        this.bookQty = bookQty +1;
    }
}