package view;
import client.ClientCus;
import client.Customer;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInDashboard extends JFrame {
	private static final long serialVersionUID = 1L;
    Customer cus = null;


    private void NewAccWin(){

		JFrame frame1 = new JFrame("Create new Account");
		//JButton lodge;
		JButton enter = new JButton("Enter");
		
		JButton back;
		back = new JButton("Enter");
		
		JLabel id,fn,ln,email,cno,pass;
		JTextArea area;
		JTextField idtext,fntext,lntext,etext,contacttext,passtext;
		
		id=new JLabel ("ID:");
		id.setBounds(10,10, 100,30); 
		fn=new JLabel ("First Name:");
		fn.setBounds(10,50, 100,30); 
		ln=new JLabel ("Last Name:");
		ln.setBounds(10,90, 100,30); 
		email=new JLabel ("Email:");
		email.setBounds(10,130, 100,30); 
		cno=new JLabel ("Contact No.:");
		cno.setBounds(10,170, 100,30); 
        pass=new JLabel ("Password");
        pass.setBounds(10,220, 100,30); 
		
		
		
		idtext = new JTextField();
		fntext = new JTextField();
		lntext = new JTextField();
        etext = new JTextField();
		contacttext = new JTextField();
		passtext = new JTextField();
		
	
		
		idtext.setBounds(90,10, 200,30);  
		fntext.setBounds(90,50, 200,30);  
		lntext.setBounds(90,90, 200,30);  
		etext.setBounds(90,130, 200,30);  
		contacttext.setBounds(90,170, 200,30);  
        passtext.setBounds(90,220,200,30);
						
		frame1.setSize(500,500);
		
		//lodge.setBounds(10,320,100,40);
		enter.setBounds(10,380,100,40);
		
		frame1.add(id);frame1.add(idtext);
		frame1.add(fn);frame1.add(fntext);
		frame1.add(ln); frame1.add(email); frame1.add(etext);
		frame1.add(lntext);frame1.add(contacttext);frame1.add(cno);
        frame1.add(passtext);
        frame1.add(pass);
		
		
		//frame1.add(lodge);
		frame1.add(enter);
		frame1.setLayout(null);
		frame1.setVisible(true);
		//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                ClientCus client = new ClientCus();
				cus = new Customer(idtext.getText(),passtext.getText(),fntext.getText(),lntext.getText(),etext.getText(),contacttext.getText());
                client.sendAction("Add Customer");
                System.out.println("Message Sent to server");
                client.sendCustomer(cus);
                client.receiveResponse();
                System.out.println("Response received from server");
               
					

		}	});
		
	}
	
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

        JButton newacc = new JButton("new Account");
        newacc.setBounds(10, 200, 110, 25);

        
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
        add(newacc);
        //finalize frame settings
        setTitle("LogIn Dashboard");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        //action listener for NewAccount
        newacc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NewAccWin();
            }
            
        });


        //action listener for enter
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String idNumber = idNumberField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                ClientCus client = new ClientCus();
                client.sendAction("Find Customer");
                client.sendCustomerId(idNumber);
                client.receiveResponse();
                cus = client.getCustomer();


                
                //System.out.println("idNumber is " + idNumber + "\nPassword is " + password);

                //WILL NEED TO CHANGE to send the information to the server and get password instead 


                boolean authenticated = authenticate(idNumber, password);

                if (cus.getCustomerId() == idNumber && cus.getPassword() == password) {
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
