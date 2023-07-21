package client;

public class EmpDriver {
    public static void main(String[] args){

        ClientEmp client = new ClientEmp();
        Employee e = new Employee("88787","43343","Lucas","UUU","UUU@gmail","223343","Rep");

            
        client.sendAction("Add Employee");
        System.out.println("Message Sent to server");
        client.sendEmployee(e);
        client.receiveResponse();
        System.out.println("Response received from server");   
        
        client.sendAction("Find Employee");
        client.sendEmployeeId("777");
        client.receiveResponse();

    }


}
