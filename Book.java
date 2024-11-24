package com.example.library;


import java.time.LocalDate;
/**
 * Represents a book in the library with the details of the book
 */
public class Book {
    public String bookName;
    public String authorName;
    public String genre;
    public int bookQty;
    public int bookQtyCopy;
    public int sNo;
    public LocalDate checkOutDate;
    
    /**
     * Constructs the Book object for the library
     *
     * @param bookName
     * @param authorName
     * @param genre
     * @param bookQty
     */
    
    public Book(String bookName, String authorName, String genre, int bookQty)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.bookQty = bookQty;
    }

    // Constructor for checked out com.example.librarygroupproject.books usage?
    /**
     * Constructs the Book object for the checked-out books
     *
     * @param bookName
     * @param authorName
     * @param genre
     * @param checkOutDate
     */
    public Book(String bookName, String authorName, String genre, LocalDate checkOutDate)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.checkOutDate = checkOutDate;
    }

    /**
     * Getter for the bookName
     * @return bookName
     */
    public String getBookName() {
        return bookName;
    }
    /**
     * Getter for the authorName
     * @return authorName
     */
    
    public String getAuthorName() {
        return authorName;
    }
    
    /**
     * Getter for the Genre
     * @return Genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Getter for the Book Quantity
     * @return Book Quantity
     */
    public int getBookQty() {

        return bookQty;
    }
    
    /**
     * Getter for the checkOutDate
     * @return checkOutDate
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    
    /**
     * Decreases the book quantity by one if the book is checked out
     */
    public void checkOut(){
        this.bookQty = bookQty -1;
    }
    
    /**
     * Increases the book quantity by one if the book is checked in
     */
    public void checkIn(){
        this.bookQty = bookQty +1;
    }
}
