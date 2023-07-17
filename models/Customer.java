package models;
import java.util.ArrayList;
import java.util.List;

public class Customer extends SystemUser {
    private List<Complaint> complaints;

    public Customer(String customerId, String password) {
        super(customerId, password);
        this.complaints = new ArrayList<>();
    }
    

    // Getters and setters
    
	/**
	 * @return the complaints
	 */
	public List<Complaint> getComplaints() {
		return complaints;
	}

	/**
	 * @param complaints 
	 * description: the complaints to set
	 */
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

}