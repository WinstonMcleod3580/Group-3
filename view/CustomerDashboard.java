package view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public CustomerDashboard() {
		
		//basic guide for setBounds
        //(x coordinate,y coordinate,width,height)
        //increasing the x value moves it to the right
        //decreasing the x value moves it to the left
        //increasing the y value moves it down
        //decreasing the y value moves it up
		
		//setting the buttons
        JButton lodgeAComplaintButton = new JButton("Lodge a Complaint");
        lodgeAComplaintButton.setBounds(180, 20, 200, 30);
        
        JButton makeAQueryButton = new JButton("Make a Query");
        makeAQueryButton.setBounds(180, 80, 200, 30);
        
        //Request service is the LIVE chat feature
        //used "Request Service" based on what's on project instructions
        JButton requestServiceButton = new JButton("Request Service");
        requestServiceButton.setBounds(180, 140, 200, 30);
        
        JButton exitButton = new JButton("SIGN-OUT");
        exitButton.setBounds(180, 200, 200, 30);
        
        exitButton.setBackground(Color.PINK);
        
        add(lodgeAComplaintButton);
        add(makeAQueryButton);
        add(requestServiceButton);
        add(exitButton);
        
        setTitle("Customer Dashboard");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        lodgeAComplaintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	          	
            	
            	new ComplaintDashboard().setVisible(true);
            	dispose();                
            }
        });
        
        makeAQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	          	
            	
            	new QueryDashboard().setVisible(true);
            	dispose();                
            }
        });
        
        requestServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	          	
            	
            	new ComplaintDashboard().setVisible(true);
            	dispose();                
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new LogInDashboard().setVisible(true); 
                dispose();
            }
        });
    
	} //end CustomerDashboard constructor

}//end CustomerDashboard class
