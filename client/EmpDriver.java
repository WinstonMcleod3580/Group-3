package client;

public class EmpDriver {
    public static void main(String[] args){

        ClientEmp client = new ClientEmp();
            Employee e = new Employee("122","1222","Mog","Di","33@gmail","3344","Tech");


            client.sendAction("Add Employee");
            System.out.println("Message Sent to server");
            client.sendEmployee(e);
            client.receiveResponse();
            System.out.println("Response received from server");   
    }


}
