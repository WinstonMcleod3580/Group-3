package controllers;

import connector.Database;
import connector.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
    private Connection conn;

    // Constructor
    public Authentication(Connection conn) {
        this.conn = conn;
    }

    public Authentication() {
        // Get the database connection using DatabaseConnection
        conn = DatabaseConnection.getDatabaseConnection();
    }

    public boolean loginCustomer(String customerId, String password) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM customers WHERE customerId = ?");
            statement.setString(1, customerId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    return password.equals(storedPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean loginEmployee(String staffId, String password) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM employees WHERE staffId = ?");
            statement.setString(1, staffId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    return password.equals(storedPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
