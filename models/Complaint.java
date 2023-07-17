package models;

import java.util.ArrayList;
import java.util.List;

public class Complaint {
    private String complaintId;
    private String customerId;
    private String category;
    private String details;
    private List<Response> responses;

    public Complaint(String complaintId, String customerId, String category, String details) {
        this.complaintId = complaintId;
        this.customerId = customerId;
        this.category = category;
        this.details = details;
        this.responses = new ArrayList<>();
    }

	/**
	 * @return the complaintId
	 */
	public String getComplaintId() {
		return complaintId;
	}

	/**
	 * @param complaintId the complaintId to set
	 */
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the responses
	 */
	public List<Response> getResponses() {
		return responses;
	}

	/**
	 * @param responses the responses to set
	 */
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

    // Getters and setters
}
