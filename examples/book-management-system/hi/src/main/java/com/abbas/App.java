package com.abbas;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
    private static BookStore bookStore = new BookStore(); // Initialize the BookStore
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input
    private static String filePath = "C:\\Users\\abbas\\Desktop\\hopeitworks\\hi\\src\\main\\java\\com\\abbas\\Books.txt";
    public static void main(String[] args) {
        readFromFile();
        boolean running = true;


        while (running) {
            // Display the menu options
            System.out.println("----- Book Store Menu -----");
            System.out.println("1. Add Book");
            System.out.println("2. Search by ISBN");
            System.out.println("3. Display All Books");
            System.out.println("4. Delete by ISBN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Read user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Handle user choice with a switch statement
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchByISBN();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    deleteByISBN();
                    break;
                case 5:
                    running = false; // Exit the loop
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] bookDetails = line.split(",");

                // Store values in respective variables
                String isbn = bookDetails[0];
                String title = bookDetails[1];
                String author = bookDetails[2];
                double price = Double.parseDouble(bookDetails[3]);
                
                Book newBook = new Book(isbn, title, author, price);
                BookStore.addBook(newBook);
            }
        } catch (IOException e) {
            System.err.println("book is not added successfully");
            e.printStackTrace();
        }
    }

    public static boolean validateISBN(String isbn) {
        // Regular expression to match exactly six digits
        String isbnRegex = "\\d{6}";
        return isbn != null && isbn.matches(isbnRegex);
    }

    // Validate Title (must not be empty or null)
    public static boolean validateTitle(String title) {
        return title != null && !title.trim().isEmpty();
    }

    // Validate Author (must not be empty or null)
    public static boolean validateAuthor(String author) {
        char [] charArr = author.toCharArray();
        for(Character c : charArr){
            if (Character.isDigit(c)){
                return false;
            }
        }
        return author != null && !author.trim().isEmpty();
    }

    // Validate Price (must be a positive value)
    public static boolean validatePrice(String price) {
        boolean valid = true;
        for (int i = 0; i<price.length(); i++){
            if (Character.isAlphabetic(price.charAt(i))){
                valid = false;
                break;
            }
                
        }
        return price != null && !price.trim().isEmpty() && valid;
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        while(true){
            if (bookStore.searchByISBN(isbn) != null){
            System.out.println("book was found already");
            System.out.print("Enter ISBN: ");
            isbn = scanner.nextLine();
            }
            if (!validateISBN(isbn)){
                System.out.println("isbn is entered in an invalid format");
                System.out.print("Enter ISBN: ");
                isbn = scanner.nextLine();
            }
            else 
                break;
        }
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        while(true){
            if (!validateTitle(title)){
                System.out.println("Book title is invalid :(");
                System.out.print("Enter Title: ");
                title = scanner.nextLine();
            }
            else 
                break;
        }
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        while(true){
            if (!validateAuthor(author)){
                System.out.println("Author name intered is in invalid format :(");
                System.out.print("Enter Author: ");
                author = scanner.nextLine();
            }
            else
                break;
        }
        System.out.print("Enter Price: ");
        String price = scanner.nextLine();;
        while(true){
                if (!validatePrice(price)){
                    System.out.println("Price entered is in invalid formate :(");
                    System.out.print("Enter Price: ");
                    price = scanner.nextLine();
                }
                else 
                    break;
        }
        String contentToAppend = System.lineSeparator()+isbn+","+title+","+author+","+price; 
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {  // 'true' enables append mode
            fileWriter.write(contentToAppend);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
        // Create a new Book object and add it to the BookStore
        double priced = Double.parseDouble(price); 
        Book book = new Book(isbn, title, author, priced);
        BookStore.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void searchByISBN() {
        System.out.print("Enter ISBN to search: ");
        String isbn = scanner.nextLine();
        while (true){
            if (validateISBN(isbn))
                break;    
            else{
                System.out.println("isbn is entered in an invalid format");
                System.out.print("Enter ISBN: ");
                isbn = scanner.nextLine();
            }
            }
        Book book = bookStore.searchByISBN(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        }
    
    }
    private static void displayAllBooks() {
        System.out.println("Displaying all books:");
        bookStore.displayBooks(); // Display all books in the store
    }

    private static void deleteByISBN() {
        System.out.print("Enter ISBN to delete: ");
        String isbn = scanner.nextLine();
        while (true){
            if (validateISBN(isbn))
                break;    
            else{
                System.out.println("isbn is entered in an invalid format");
                System.out.print("Enter ISBN: ");
                isbn = scanner.nextLine();
            }
        }
        bookStore.deleteByISBN(isbn); // Attempt to delete the book
        String newContent = "";
        for (int i=0; i<bookStore.getBooks().size(); i++){
            Book ittr = bookStore.getBooks().get(i);
            newContent += ittr.getIsbn() + "," + ittr.getTitle()+"," + ittr.getAuthor()+","+ Double.toString(ittr.getPrice());
            if (i != bookStore.getBooks().size() - 1)
                newContent += System.lineSeparator();       
        }
            try (FileWriter fileWriter = new FileWriter(filePath)) {  // No 'true', so it overwrites
            fileWriter.write(newContent);
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        
    
}
}