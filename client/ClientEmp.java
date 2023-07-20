package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import view.CustomerView;

public class ClientEmp {
    private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
    private String action;

    public ClientEmp(){
        this.createconnection();
        this.getStreams();
     }

     private void createconnection() {
		try{
							
			connection = new Socket("127.0.0.1",8888);
			
		}catch(IOException ex){
		    ex.printStackTrace();
		}
	}

    public final void getStreams(){
		try{
			
			os = new ObjectOutputStream(connection.getOutputStream());
			is = new ObjectInputStream(connection.getInputStream());
			
		}catch(IOException ex){
		    ex.printStackTrace();
		}
	}	
	public void closeConnection() {
		try {
			
			os.close();
			is.close();
			connection.close();
			
		}catch(IOException ex){
		   ex.printStackTrace();
		}
	}

    public void sendAction(String action){
        this.action = action;
        try{
            os.writeObject(action);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void sendEmployee(Employee emp){
		try{
		  
		  os.writeObject(emp);
		  
		}
		catch(IOException ex){
		  ex.printStackTrace();
		}
	}



    public void receiveResponse(){
		 try{
            if(action.equalsIgnoreCase("Add Employee")){
                Boolean flag = (Boolean) is.readObject();
                if (flag == true){
                    JOptionPane.showMessageDialog(null,"Record added successfully","Add Record Status",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        
            if(action.equalsIgnoreCase("Find Employee")){
                CustomerView customer = new CustomerView();
                customer = (CustomerView) is.readObject();
                if (customer == null){
                    JOptionPane.showMessageDialog(null,"Record could not be found","Find Record Status",JOptionPane.ERROR_MESSAGE);
                    return;
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
