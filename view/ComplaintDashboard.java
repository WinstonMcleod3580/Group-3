package view;

import javax.swing.*;

import client.model.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplaintDashboard extends JFrame {
    private static final long serialVersionUID = 1L;

    public ComplaintDashboard() {
        
    	//should be at CustomerDashboard.java
    	//Request Service is LIVE Chat feature
        //String[] serviceType = {"Lodge Complaint", "Make a Query", "Request Service"};
    	
    	//basic guide for setBounds
        //(x coordinate,y coordinate,width,height)
        //increasing the x value moves it to the right
        //decreasing the x value moves it to the left
        //increasing the y value moves it down
        //decreasing the y value moves it up
        
        String[] category = {"severe", "medium", "moderate"};
        
        String[] natureOfComplaint = {"Technical Issue", "Billing Problem", "Service Request"};

        //setting the labels
        JLabel cusIdNumLabel = new JLabel("Customer ID#:");
        cusIdNumLabel.setBounds(20, 20, 100, 25);
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        firstNameLabel.setBounds(20, 60, 100, 25);
        
        JLabel lastNameLabel = new JLabel("Lastname:");
        lastNameLabel.setBounds(20, 100, 100, 25);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 140, 100, 25);
        
        JLabel contactLabel = new JLabel("Contact No.:");
        contactLabel.setBounds(20, 180, 100, 25);
        
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(20, 220, 100, 25);	
        
        JLabel natureOfComplaintLabel = new JLabel("Nature of Complaint:");
        natureOfComplaintLabel.setBounds(20, 260, 130, 25);	

        //setting the fields
        JTextField cusIdNumField = new JTextField();
        cusIdNumField.setBounds(170, 20, 300, 25);
        
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(170, 60, 300, 25);
        
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(170, 100, 300, 25);
        
        JTextField emailField = new JTextField();
        emailField.setBounds(170, 140, 300, 25);
        
        JTextField contactField = new JTextField();
        contactField.setBounds(170, 180, 300, 25);    
        
        //setting the select options
        JComboBox<String> categoryField = new JComboBox<>(category);
        categoryField.setBounds(170, 220, 300, 25);
        
        JComboBox<String> natureOfComplaintField = new JComboBox<>(natureOfComplaint);
        natureOfComplaintField.setBounds(170, 260, 300, 25);
                
        //setting the buttons
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 350, 80, 25);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(110, 350, 80, 25);
            
        //add label
        add(cusIdNumLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);
        add(contactLabel);
        add(categoryLabel);
        add(natureOfComplaintLabel);

        //add field
        add(cusIdNumField);
        add(firstNameField);
        add(lastNameField);
        add(emailField);
        add(contactField);
        add(categoryField);
        add(natureOfComplaintField);
        
        //add buttons
        add(submitButton);
        add(exitButton);

        //finalize frame settings
        setTitle("Complaint Dashboard");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Action Listener for Submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	          	
            	String cusIdNum = cusIdNumField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String contact = contactField.getText();
                String category = (String) categoryField.getSelectedItem();
                String natureOfComplaint = (String) natureOfComplaintField.getSelectedItem();

                //print to console for testing purposes for now
                System.out.println("ID Number: " + cusIdNumField);
                System.out.println("Service Type: " + firstNameField);
                System.out.println("Category: " + lastNameField);
                System.out.println("Email: " + emailField);
                System.out.println("contact: " + contactField);
                System.out.println("category: " + categoryField);
                System.out.println("Nature of Complaint: " + natureOfComplaintField);
                
                //Customer customer = new Customer(idNumber, firstName, lastName, emailAddress, contactNumber);
           
                //client.sendCustomer(customer);
                                
                //clearBut.doClick();
                
            }
        });

        // Action Listener for Exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the exit button action here
                // For example, you can close the current frame and return to the LogInDashboard
                dispose();
                new LogInDashboard(); // Assuming LogInDashboard is the class for the login screen
            }
        });
    }
}
