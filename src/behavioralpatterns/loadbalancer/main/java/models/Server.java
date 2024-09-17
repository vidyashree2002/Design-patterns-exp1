package behavioralpatterns.loadbalancer.main.java.models;


////as a loadbalancer role is to distribute requests from the client to to all the existing servers, hence we are creating 4 servers where 
//we will be using interface for passing on the same kind of attributes and method to all the 4 servers by overriding it. 
public interface Server {     
    boolean isServerUp();                 // this attribute is for checking if the particular server is in active state or has a crash down.
    String processRequest(String filename);    // the client request the server for a particular file hence the server has a function that processes that request
}

