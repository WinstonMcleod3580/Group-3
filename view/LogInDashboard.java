package view;
import client.ClientCus;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInDashboard extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//default constructor
    public LogInDashboard() {
    	
    	//basic guide for setBounds
        //(x coordinate,y coordinate,width,height)
        //increasing the x value moves it to the right
        //decreasing the x value moves it to the left
        //increasing the y value moves it down
        //decreasing the y value moves it up
        
    	//setting the labels
        JLabel idNumberLabel = new JLabel("User ID#:");
        idNumberLabel.setBounds(20, 20, 100, 25);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 100, 25);
        
        //setting the fields
        JTextField idNumberField = new JTextField();
        idNumberField.setBounds(170, 20, 300, 25);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 60, 300, 25);
        
        //setting the buttons
        JButton enterButton = new JButton("enter");
        enterButton.setBounds(130, 200, 80, 25);
        
        JButton exitButton = new JButton("EXIT SYSTEM");
        exitButton.setBounds(230, 200, 140, 25);
        
        exitButton.setBackground(Color.PINK);
        
        //add labels
        add(idNumberLabel);
        add(passwordLabel);
        
        //add fields
        add(idNumberField);
        add(passwordField);
        
        //add buttons
        add(enterButton);
        add(exitButton);
        
        //finalize frame settings
        setTitle("LogIn Dashboard");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //action listener for enter
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String idNumber = idNumberField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                ClientCus client = new ClientCus();
                client.sendAction("Find Customer");
                client.sendCustomerId(password);
                client.receiveResponse();
                
                System.out.println("idNumber is " + idNumber + "\nPassword is " + password);

                //WILL NEED TO CHANGE to send the information to the server and get password instead 


                boolean authenticated = authenticate(idNumber, password);

                if (authenticated) {
                    new CustomerDashboard().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LogInDashboard.this, "Invalid credentials. Try again.",
                            "Authentication Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //action listener for exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //new LogInDashboard().setVisible(true); 
                //dispose();
            	System.exit(0);
            }
        });
    }//end LogInDashboard constructor
    
    private boolean authenticate(String idNumber, String password) {
        //should actually sent to server to get this data. use as test for now
        return idNumber.equals("aa") && password.equals("11");
    }
} //end LogInDashboard class
