package behavioralpatterns.loadbalancer.main.services;

import behavioralpatterns.loadbalancer.main.java.models.Server;
import java.util.List;

public class LoadBalancer{
   
    private final List<Server> servers;

    public LoadBalancer(List<Server> servers){
        this.servers = servers;
    }

    public String handleRequest(String filename) throws Exception {
        if(filename == null || filename.isEmpty()){
            throw new IllegalArgumentException("A file of that anme does not exist ");
        }
        for(Server server : servers){
                try {
                    if(server.isServerUp()){
                        return server.processRequest(filename);
                    }
                    
                } catch (Exception e) {
                    System.out.println("Server :" + server.getClass().getSimpleName() + " encountered an error:" + e.getMessage());
                }

        }
        throw new Exception ("All the servers are down with a status code 505"); 
    }

}