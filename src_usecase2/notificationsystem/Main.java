package notificationsystem;


import java.util.Scanner;
import src_usecase2.notificationsystem.services.CacheService;
import src_usecase2.notificationsystem.services.NotificationSystem;
import src_usecase2.notificationsystem.services.ThirdPartyService;
import src_usecase2.notificationsystem.services.UserService;

public class Main {
    public static void main(String[] args) {
        CacheService cacheService = new CacheService();  
        UserService userService = new UserService(cacheService);  
        ThirdPartyService thirdPartyService = new ThirdPartyService();  
        NotificationSystem notificationSystem = new NotificationSystem(userService, thirdPartyService);  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        try {
            notificationSystem.sendNotification(email);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
