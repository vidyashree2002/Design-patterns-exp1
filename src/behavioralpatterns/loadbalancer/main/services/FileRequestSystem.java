
package behavioralpatterns.loadbalancer.main.services;


import java.util.Scanner;


public class FileRequestSystem {

    
    private final LoadBalancer loadBalancer;

    public FileRequestSystem(LoadBalancer loadBalancer){
        this.loadBalancer = loadBalancer;
    }

    public void run (){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter the file name to fetch:");
            String filename = scanner.nextLine();

           try {
            String result = loadBalancer.handleRequest(filename);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        }
    }
}



       
      
    



