package behavioralpatterns.loadbalancer.main.java.models;

public class Server4 implements Server {
    final boolean serverUp;

    public Server4(boolean serverUp) {
        this.serverUp = serverUp;
    }

    @Override
    public boolean isServerUp() {
        return serverUp;
    }

    @Override
    public String processRequest(String fileName) {
        return "Server4 processed file: " + fileName;
    }
}