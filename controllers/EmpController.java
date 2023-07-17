package controllers;



import java.util.List;
import models.Complaint;
import models.Service;
import models.Technician;


public class EmpController {
    public List<Service> getServices() {
        // Logic to retrieve the list of services
    }

    public int getResolvedComplaintCount(Service service) {
        // Logic to retrieve the number of resolved complaints for a service
    }

    public int getOutstandingComplaintCount(Service service) {
        // Logic to retrieve the number of outstanding complaints for a service
    }

    public List<Complaint> getComplaintsByService(Service service) {
        // Logic to retrieve all complaints for a particular service
    }

    public void assignComplaint(Complaint complaint, Technician technician) {
        // Logic to assign a complaint to a technician
    }

    public Complaint getComplaintDetails(String complaintId) {
        // Logic to retrieve the details of a complaint
    }
}
