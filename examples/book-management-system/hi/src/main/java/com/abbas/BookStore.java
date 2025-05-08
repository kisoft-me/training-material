package com.abbas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
    // List to hold Book objects
    private static  List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        BookStore.books = books;
    }

    // Constructor
    public BookStore() {
        books = new ArrayList<>();
    }

    // Method to add a new book to the list
    public static void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Method to search for a book using its ISBN
    public Book searchByISBN(String isbn) {

        List<Book> targetedBook = books
        .stream()
        .filter(c -> c.getIsbn().equals(isbn))
        .collect(Collectors.toList());
        if (!targetedBook.isEmpty()){
            Book book = targetedBook.get(0);
            return book;
        }
        else {
            System.out.println("Book with isbn: " + isbn + " is not found :(");
            return null;
        } 
    }

    // Method to display all the books in the list
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in the store:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to delete a book from the list using its ISBN
    public boolean deleteByISBN(String isbn) {
        Book bookToRemove = searchByISBN(isbn);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book deleted: " + bookToRemove);
            return true;
        } else {
            return false;
        }
    }
}
