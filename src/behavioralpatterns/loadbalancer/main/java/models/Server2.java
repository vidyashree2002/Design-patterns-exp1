package behavioralpatterns.loadbalancer.main.java.models;

// this is the creation of 3rd server and the concrete classes are initialised with the methods and functions of superclass

public class Server2 implements Server {
    final boolean serverUp;

    public Server2(boolean serverUp){
        this.serverUp = serverUp;
    }
    @Override
    public boolean isServerUp(){
        return serverUp;
    }
     @Override
    public String processRequest(String filename){
        return "Server2 processed file: " + filename;
    }
}