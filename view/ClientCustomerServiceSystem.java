package view;

import view.AuthenticationView;
import view.CustomerView;
import view.EmployeeView;
import view.LiveChatView;


public class CustomerServiceSystem {

	public static void main(String[] args) {
		AuthenticationView authenticationView = new AuthenticationView();
        authenticationView.displayLoginCustomer();
        
        CustomerView customerView = new CustomerView();
        customerView.displayDashboard();
        
        EmployeeView employeeView = new EmployeeView();
        employeeView.displayDashboard();
        
        LiveChatView liveChatView = new LiveChatView();
        liveChatView.displayTechnicianAvailability(true);

	}

}
