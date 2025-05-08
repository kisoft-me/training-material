---
layout: task
title: "Setup Development Environment with small Java Project"
nav_order: 10
next_page: 010-basics-of-unit-testing-and-mocking-and-dummy-data
previous_page: 008-introduction-to-maven
---
# **Bookstore Managment System**

## Project Objective
#### **The aim of this project is to create a basic Bookstore Management System in Java. This project will help you understand Java's object-oriented programming concepts and give you hands-on experience with file handling in Java.**
## Features
### 1. Book Class: 
#### **Create a class called Book with the following attributes:**

- ### **```ISBN (String)```**

- ### **```Title (String)```**

- ### **```Author (String)```**

- ### **```Price (double)```**

#### **Methods to Implement in Book Class:**
- ### **```toString(): To display book information.```**

### 2. BookStore Class:
#### **Create another class called BookStore which will have a list of Book objects.**
#### **Methods to Implement in BookStore Class:**
- ### **```addBook() : To add a new book to the list```**
- ### **```searchByISBN(String ISBN) : To search for a book using its ISBN```**
- ### **```displayBooks() : To display all the books in the list```**
- ### **```deleteByISBN(String ISBN) : To delete a book from the list using its ISBN```**


### 3. Main Program: 
#### **Create a Main class that contains the main method and handles the user interface.**
#### **Features to Implement in Main Class:**
- ##### **Menu-driven interface for the user with the following options:**
    - ##### **Add Book**
    - ##### **Search by ISBN**
    - ##### **Display All Books**
    - ##### **Delete by ISBN**
    - ##### **Exit**

- ##### **Use a Scanner object to take user input for the menu options and details.**
- ##### **Call the appropriate methods in the BookStore class based on user input.**

- ##### **Additional Features:**
    - ##### **File Handling: Implement saving and retrieving of bookstore information to and from a file.**
    - ##### **Input validation: Add code to validate the user input where needed (e.g., for ISBN, Price etc.)**   

## Useful Links for References:

- [Java Documentaion](https://docs.oracle.com/javase/tutorial/){:target="_blank"}

- [Working with ArrayList in Java](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html){:target="_blank"}

- [File Handling in Java](https://www.w3schools.com/java/java_files.asp){:target="_blank"}

## Example
- [Book Management System](https://github.com/kisoft-me/training-material/tree/master/examples/book-management-system){:target="_blank"}