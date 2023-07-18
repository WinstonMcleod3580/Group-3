package models;
import java.util.ArrayList;
import java.util.List;

public class Customer extends SystemUser {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
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
