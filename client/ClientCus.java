package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import view.CustomerView;


public class ClientCus {

	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
	private static final Logger logger = LogManager.getLogger(ClientCus.class);
	private String action;

	public ClientCus(){
	   this.createconnection();
	   this.getStreams();
	}

	private void createconnection() {
		try{
							
			connection = new Socket("127.0.0.1",8888);
			logger.info("Socket Successfully Configured");
		}catch(IOException ex){
		    logger.error(ex.getMessage());
		}
	}
		
	public final void getStreams(){
		try{
			logger.warn("Attempting to setup Socket, Errors may occur");
			os = new ObjectOutputStream(connection.getOutputStream());
			is = new ObjectInputStream(connection.getInputStream());
			logger.info("Client Streams Successfully Configured to Server");
		}catch(IOException ex){
		    logger.error(ex.getMessage());
		}
	}	
	public void closeConnection() {
		try {
			logger.warn("Attempting to close Client Streams to Server, Errors may occur");
			os.close();
			is.close();
			connection.close();
			logger.info("Client Streams Successfully Closed to Server");
		}catch(IOException ex){
		   logger.error(ex.getMessage());
		}
	}
	public void sendAction(String action){
		this.action = action;
		try {
			logger.warn("Attempting to send information to Server, Errors may occur");
			os.writeObject(action);
		    logger.info("CIient Streams Successfully Closed to Server");
		}
		catch(IOException ex){
		   logger.error("Data Not Sent to Server\n" + ex.getMessage());
		}
	}
	
	public void sendCustomer(Customer cus){
		try{
		  
		  os.writeObject(cus);
		  
		}
		catch(IOException ex){
		  ex.printStackTrace();
		}
	}


	public void sendCustomerId(String id){
        try{
            os.writeObject(id);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }





	public void receiveResponse(){
		 try{
            if(action.equalsIgnoreCase("Add Customer")){
                Boolean flag = (Boolean) is.readObject();
                if (flag == true){
                    JOptionPane.showMessageDialog(null,"Record added successfully","Add Record Status",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        
            if(action.equalsIgnoreCase("Find Customer")){
                Customer customer = new Customer();
                customer = (Customer) is.readObject();
                if (customer == null){
                    JOptionPane.showMessageDialog(null,"Record could not be found","Find Record Status",JOptionPane.ERROR_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Record  found","Find Record Status",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(customer.getFirstName());
                }
            }
        }catch(ClassCastException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
	}


}
