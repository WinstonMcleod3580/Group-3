package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechnicianDashboard extends JFrame {
    private static final long serialVersionUID = 1L;

    public TechnicianDashboard() {    	
    	
    	//Labels
        final JLabel complaintLabel;
        final JLabel detailsLabel;
        final JTextArea detailsArea; 
        final JLabel proposedDateLabel;
        
        //Fields
        final JTextField complaintTextField;
        final JTextField proposedDateTextField;

        //Buttons
        final JButton viewComplaintButton;
        final JButton setProposedDateButton;
        final JButton startLiveChatButton;
        final JButton logOutButton;
        final JCheckBox chatAvailabilityCheckBox;
        final JButton submitAvailabilityButton;

        complaintLabel = new JLabel("Complaint:");
        detailsLabel = new JLabel("Details of the issue:");
        proposedDateLabel = new JLabel("Proposed Date of Visit (YYYY-MM-DD):");
        
        complaintTextField = new JTextField(50);
        
        detailsArea = new JTextArea(5, 50); // 5 rows, 50 columns
        detailsArea.setLineWrap(true); // Enable line wrapping
        detailsArea.setWrapStyleWord(true); // Wrap whole words
        
        JScrollPane detailsScrollPane = new JScrollPane(detailsArea);
        detailsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        proposedDateTextField = new JTextField(20);

        viewComplaintButton = new JButton("View a particular complaint");
        setProposedDateButton = new JButton("Set Proposed Date");
        startLiveChatButton = new JButton("Start Live Chat");
        logOutButton = new JButton("Log Out");
        
        logOutButton.setBackground(Color.PINK);

        chatAvailabilityCheckBox = new JCheckBox("Available for Live Chat");
        submitAvailabilityButton = new JButton("Submit Availability");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create sub-panels for each component group
        JPanel complaintPanel = new JPanel();
        complaintPanel.add(complaintLabel);
        complaintPanel.add(complaintTextField);
        
        JPanel detailsPanel = new JPanel();
        detailsPanel.add(detailsLabel);
        
        detailsPanel.add(detailsScrollPane);


        JPanel proposedDatePanel = new JPanel();
        proposedDatePanel.add(proposedDateLabel);
        proposedDatePanel.add(proposedDateTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewComplaintButton);
        buttonPanel.add(setProposedDateButton);
        buttonPanel.add(startLiveChatButton);      
        buttonPanel.add(chatAvailabilityCheckBox);
        buttonPanel.add(submitAvailabilityButton);
        buttonPanel.add(logOutButton);

        //Add the sub-panels to the main panel
        mainPanel.add(complaintPanel);
        mainPanel.add(detailsPanel);
        mainPanel.add(proposedDatePanel);
        mainPanel.add(buttonPanel);

        //Add the main panel to the JFrame
        add(mainPanel);
        
        //finalizing the frame
        setTitle("Technician Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null); // Center the JFrame on the screen 

        //Add action listeners to the buttons
        viewComplaintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //should communicate with server to get information from database
            }
        }); //end complaintButton action

        setProposedDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //should send response to the server
            }
        }); //end setProposeDateButton action

        startLiveChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //should send response to the server
            }
        }); //end liveChat button action
                
        submitAvailabilityButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {	             
	             boolean isAvailable = chatAvailabilityCheckBox.isSelected();
	
	             String availabilityStatus;
	             if (isAvailable) {
	                 availabilityStatus = "yes";
	             } else {
	                 availabilityStatus = "no";
	             }
	
	             //should be modified to submit response to the server
	             System.out.println("Availability Status: " + availabilityStatus);
	         }
	     });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new LogInDashboard().setVisible(true); 
                dispose();
            }
        });

        
    }//end TechnicianDashboard constructor
}//end TechnicianDashboard class