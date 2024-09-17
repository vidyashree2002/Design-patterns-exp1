
package behavioralpatterns.loadbalancer.main;

import behavioralpatterns.loadbalancer.main.java.models.Server1;
import behavioralpatterns.loadbalancer.main.java.models.Server2;
import behavioralpatterns.loadbalancer.main.java.models.Server3;
import behavioralpatterns.loadbalancer.main.java.models.Server4;
import behavioralpatterns.loadbalancer.main.services.FileRequestSystem;
import behavioralpatterns.loadbalancer.main.services.LoadBalancer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Server1 server1 = new Server1(false);  // server1 is down
        Server2 server2 = new Server2(false); // Server2 is down
        Server3 server3 = new Server3(true);  // server3 is up
        Server4 server4 = new Server4(true); // Server4 is down

        LoadBalancer loadBalancer = new LoadBalancer(Arrays.asList(server1, server2, server3, server4));
        FileRequestSystem fileRequestSystem = new FileRequestSystem(loadBalancer);
        
        fileRequestSystem.run();
    }
}