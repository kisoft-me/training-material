package com.example;

import java.util.List;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;

public class UserDao {
    private final Jdbi jdbi;

    public UserDao(DataSource dataSource) {
        this.jdbi = Jdbi.create(dataSource);
    }

    public void insertUser(String Username, String email) {
        jdbi.useHandle(handle ->
            handle.createUpdate("INSERT INTO users (name, email) VALUES (:Username, :email)")
                  .bind("Username", Username)
                  .bind("email", email)
                  .execute()
        );
    }

    public void updateUser(int id, String Username, String email) {
        jdbi.useHandle(handle ->
            handle.createUpdate("UPDATE users SET name = :Username, email = :email WHERE id = :id")
                  .bind("id", id)
                  .bind("Username", Username)
                  .bind("email", email)
                  .execute()
        );
    }

    public void deleteUser(int id) {
        jdbi.useHandle(handle ->
            handle.createUpdate("DELETE FROM users WHERE id = :id")
                  .bind("id", id)
                  .execute()
        );
    }

    public List<User> getAllUsers() {
        return jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM users")
                  .map((rs, ctx) -> {
                      User user = new User();
                      user.setUserId(Integer.parseInt(rs.getString("id")) );
                      user.setUserName(rs.getString("name"));
                      user.setUserEmail(rs.getString("email"));
                      return user;
                  })
                  .list()
        );
    }
}
