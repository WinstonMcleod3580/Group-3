/**
 * 
 */
package models;

/**
 * @author Abby
 *
 */
public class SystemUser {
	    private String userId;
	    private String password;

	   
	    public SystemUser(String userId, String password) {
	        this.userId = userId;
	        this.password = password;
	    }

		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

	    // Getters and setters
	    
	

}
