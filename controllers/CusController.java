package controllers;

import models.Complaint;
import models.Customer;
import connector.Database;
import connector.Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CusController {
    private Connection conn;

    public CusController(Connection conn) {
        this.conn = conn;
    }
     public CusController() {
        // Get the database connection using DatabaseConnection
        conn = DatabaseConnection.getDatabaseConnection();
    }
    public void lodgeComplaint(Customer customer, String category, String details) {
        try (PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO complaints (customer_id, category, details) VALUES (?, ?, ?)")) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, category);
            statement.setString(3, details);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Complaint> getPastComplaints(Customer customer) {
        List<Complaint> pastComplaints = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM complaints WHERE customer_id = ?")) {
            statement.setInt(1, customer.getCustomerId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int complaintId = resultSet.getInt("complaint_id");
                    String category = resultSet.getString("category");
                    String details = resultSet.getString("details");
                    Complaint complaint = new Complaint(complaintId, customer, category, details);
                    pastComplaints.add(complaint);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pastComplaints;
    }

    public Complaint getComplaint(Customer customer, int complaintId) {
        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM complaints WHERE customer_id = ? AND complaint_id = ?")) {
            statement.setInt(1, customer.getCustomerId());
            statement.setInt(2, complaintId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String category = resultSet.getString("category");
                    String details = resultSet.getString("details");
                    return new Complaint(complaintId, customer, category, details);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
