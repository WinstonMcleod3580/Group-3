package client;


public class ClientDriver {

    public static void main(String[] args){
        ClientCus client = new ClientCus();
        //Customer cus = new Customer("57631","potato","Hugo", "lawrene", "lawh@gmail.com", "1834421");
        /*
        client.sendAction("Add Customer");
        System.out.println("Message Sent to server");
        client.sendCustomer(cus);
        client.receiveResponse();
        System.out.println("Response received from server");
        */
        client.sendAction("Find Customer");
            client.sendCustomerId("5763");
            client.receiveResponse();
    }
}
