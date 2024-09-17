package behavioralpatterns.loadbalancer.main.java.models;

// these concrete classes also called as subclass implements the attributes and methods of the superclass.
public class Server1 implements Server {  
    final boolean serverUp;

//concrete classes consists of constructors for initialisation
    public Server1(boolean serverUp) {
        this.serverUp = serverUp;
    }

// the methods that are declared in the superclass(Server) is implementated by the subclasses, this returns the status of the server thats taken from the user panel.
@Override
    public boolean isServerUp() {
        return serverUp;
    }

// this method processes any request from the client/user. The implementation of processrequest is been shown in the LoadBalancer class as that's where the actual checking
// of the servers takes place and the response is prepared accordingly.
    @Override
    public String processRequest(String fileName) {
        return "Server1 processed file: " + fileName;
    }
}