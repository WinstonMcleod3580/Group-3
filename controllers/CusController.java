package controllers;

import models.Complaint;
import models.Customer;
import java.util.List;



public class CusController {
    public void lodgeComplaint(Customer customer, String category, String details) {
        // Logic to register a complaint for a customer
    }

    public List<Complaint> getPastComplaints(Customer customer) {
        return null;
        // Logic to retrieve past complaints for a customer
    }

    public Complaint getComplaint(Customer customer, String complaintId) {
        return null;
        // Logic to retrieve a specific complaint for a customer
    }
}