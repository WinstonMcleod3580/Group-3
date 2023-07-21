package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QueryDashboard extends JFrame{
	private static final long serialVersionUID = 1L;

	public QueryDashboard() {
		
		//basic guide for setBounds
        //(x coordinate,y coordinate,width,height)
        //increasing the x value moves it to the right
        //decreasing the x value moves it to the left
        //increasing the y value moves it down
        //decreasing the y value moves it up
		
		//setting the labels
		JLabel cusIdNumLabel = new JLabel("Customer ID#:");
	    cusIdNumLabel.setBounds(20, 20, 100, 25);
	    
	    JLabel complaintIdNumLabel = new JLabel("Complaint #:");
	    complaintIdNumLabel.setBounds(20, 60, 100, 25);
	    
	    JLabel queryLabel = new JLabel("Query:");
	    queryLabel.setBounds(20, 100, 100, 25);
	    
	    String[] query = {"Technical Issue", "Bill Problem", "Service Termination",  "Plan Upgrade"};
	    
	    //setting the fields
	    JTextField cusIdNumField = new JTextField();
        cusIdNumField.setBounds(170, 20, 300, 25);
        
        JTextField complaintIdNumField = new JTextField();
        complaintIdNumField.setBounds(170, 60, 300, 25);
	    
        JComboBox<String> queryField = new JComboBox<>(query);
        queryField.setBounds(170, 100, 300, 25);
        
        //setting the buttons
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 350, 80, 25);
        
        JButton exitButton = new JButton("return to Customer Dashboard");
        exitButton.setBounds(110, 350, 250, 25);
        
        JButton signOutButton = new JButton("SIGN OUT");
        signOutButton.setBounds(370, 350, 100, 25);
        
        signOutButton.setBackground(Color.PINK);
        
        //add labels
        add(cusIdNumLabel);
        add(complaintIdNumLabel);
        add(queryLabel);
        
        //add fields
        add(cusIdNumField);
        add(complaintIdNumField);
        add(queryField);
        
        //add buttons
        add(submitButton);
        add(exitButton);
        add(signOutButton);
        
        //finalize frame settings
        setTitle("Query Dashboard");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                
            	//should clear instead and allow user to make another query if they wish
            	//can stay for now
            	//should also be updated to send data to the server
            	new CustomerDashboard().setVisible(true); 
                dispose();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                new CustomerDashboard().setVisible(true); 
                dispose();
            }
        });
               
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                new LogInDashboard().setVisible(true); 
                dispose();
            }
        });
	} //end QueryDashboard constructor	
} //end QueryDashboard class
