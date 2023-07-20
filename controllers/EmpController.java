package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Complaint;
import models.Service;


public class EmpController {
    /*

    public EmpController(Connection conn) {
        this.conn = conn;
    }
    public EmpController() {
        // Get the database connection using DatabaseConnection
        
    }

    public List<Service> getServices() {
        List<Service> services = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM services")) {
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                Service service = new Service(serviceId, serviceName);
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }

    public int getResolvedComplaintCount(Service service) {
        int resolvedCount = 0;

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT COUNT(*) AS resolved_count FROM complaints WHERE service_id = ? AND status = 'Resolved'")) {
            statement.setInt(1, service.getServiceId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    resolvedCount = resultSet.getInt("resolved_count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resolvedCount;
    }

    public int getOutstandingComplaintCount(Service service) {
        int outstandingCount = 0;

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT COUNT(*) AS outstanding_count FROM complaints WHERE service_id = ? AND status = 'Outstanding'")) {
            statement.setInt(1, service.getServiceId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    outstandingCount = resultSet.getInt("outstanding_count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outstandingCount;
    }

    public List<Complaint> getComplaintsByService(Service service) {
        List<Complaint> complaints = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM complaints WHERE service_id = ?")) {
            statement.setInt(1, service.getServiceId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int complaintId = resultSet.getInt("complaint_id");
                    String category = resultSet.getString("category");
                    String details = resultSet.getString("details");
                    Complaint complaint = new Complaint(complaintId, service, category, details);
                    complaints.add(complaint);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaints;
    }

    public void assignComplaint(Complaint complaint, Technician technician) {
        try (PreparedStatement statement = conn.prepareStatement(
                "UPDATE complaints SET technician_id = ? WHERE complaint_id = ?")) {
            statement.setInt(1, technician.getTechnicianId());
            statement.setInt(2, complaint.getComplaintId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Complaint getComplaintDetails(String complaintId) {
        Complaint complaint = null;

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM complaints WHERE complaint_id = ?")) {
            statement.setString(1, complaintId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int serviceId = resultSet.getInt("service_id");
                    Service service = getServiceById(serviceId);
                    String category = resultSet.getString("category");
                    String details = resultSet.getString("details");
                    complaint = new Complaint(complaintId, service, category, details);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaint;
    }

    private Service getServiceById(int serviceId) {
        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM services WHERE service_id = ?")) {
            statement.setInt(1, serviceId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String serviceName = resultSet.getString("service_name");
                    return new Service(serviceId, serviceName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    */
}
