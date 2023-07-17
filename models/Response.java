package models;


import java.util.Date;

public class Response {
    private String responseId;
    private String staffId;
    private Date responseDate;
    private String responseDetails;

    public Response(String responseId, String staffId, Date responseDate, String responseDetails) {
        this.responseId = responseId;
        this.staffId = staffId;
        this.responseDate = responseDate;
        this.responseDetails = responseDetails;
    }

	/**
	 * @return the responseId
	 */
	public String getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return the staffId
	 */
	public String getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	/**
	 * @return the responseDate
	 */
	public Date getResponseDate() {
		return responseDate;
	}

	/**
	 * @param responseDate the responseDate to set
	 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	/**
	 * @return the responseDetails
	 */
	public String getResponseDetails() {
		return responseDetails;
	}

	/**
	 * @param responseDetails the responseDetails to set
	 */
	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}

    // Getters and setters
}
