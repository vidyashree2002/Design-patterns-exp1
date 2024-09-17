package behavioralpatterns.loadbalancer.main.java.models;

public class Server3 implements Server{
    final boolean serverUp;

     public Server3(boolean serverUp) {
        this.serverUp = serverUp;
    }

    @Override
    public boolean isServerUp() {
        return serverUp;
    }

    @Override
    public String processRequest(String fileName) {
        return "Server3 processed file: " + fileName;
    }
}
