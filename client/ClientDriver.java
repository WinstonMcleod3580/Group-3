package client;

import com.mysql.cj.xdevapi.Client;

public class ClientDriver {

    public static void main(String[] args){
        ClientCus client = new ClientCus();
        Customer cus = new Customer("1001","password","Mary", "Sue", "the1sue@gmail.com", "1834421");

        client.sendAction("Add Customer");
        System.out.println("Message Sent to server");
        client.sendCustomer(cus);
        client.receiveResponse();
        System.out.println("Response received from server");
    }
}
