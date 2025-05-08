package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        // Load configuration
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123123";

        // Run Flyway migrations
        FlywayMigration.migrateDatabase(url, user, password);

        DataSource dataSource = DatabaseConfig.createDataSource(url, user, password);
        try (Connection connection = dataSource.getConnection()) {

         UserDao userDao = new UserDao(dataSource);


        userDao.insertUser("Alice", "alice@example.com");
        userDao.insertUser("Bob", "bob@example.com");
 
        System.out.println("Users:");     
 
        userDao.updateUser(1, "Alice Smith", "alice.smith@example.com");
 
        userDao.deleteUser(2);
        userDao.getAllUsers().forEach(u -> 
        System.out.println(u.toString()));
        System.out.println("Number of users: " + userDao.getAllUsers().size());   
        connection.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
}

