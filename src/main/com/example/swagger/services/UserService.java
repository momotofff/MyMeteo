package com.example.swagger.services;

import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static User usersRegisterPost(Connection connection, String name, String email) throws SQLException
    {
        if (!isValidEmail(email))
            throw new SQLException("Invalid email: " + email);

        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0)
            {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        user = new User();
                        user.setId(id);
                        user.setUsername(name);
                        user.setEmail(email);
                        logger.info("User with ID = {} created successfully!", id); //
                    }
                }
            }
        } catch (SQLException e) {
            String sqlState = e.getSQLState();

            if ("23505".equals(sqlState)) // Код ошибки для нарушения уникального ограничения для PostgreSQL
                throw new SQLException("Username already exists: " + name, e);
            else
                throw new SQLException("Error creating user: " + name, e);
        }
        return user;
    }


    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}