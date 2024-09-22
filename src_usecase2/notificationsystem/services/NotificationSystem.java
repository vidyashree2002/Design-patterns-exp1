package src_usecase2.notificationsystem.services;

import src_usecase2.notificationsystem.models.Server;

public class NotificationSystem {
    private final UserService userService;
    private final ThirdPartyService thirdPartyService;

    public NotificationSystem(UserService userService, ThirdPartyService thirdPartyService) {
        this.userService = userService;
        this.thirdPartyService = thirdPartyService;
    }

    public void sendNotification(String email) {
        // Check if the provided email is valid
        if (userService.isValidEmail(email)) {
            String userEmail = userService.getUserEmail(email); // Get user's email
            Server server = new Server("The app is available for update."); // Message to be sent
            thirdPartyService.sendUser(userEmail, server.getMessage()); // Send the message via third-party service
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public UserService getUserService() {
        return userService;
    }
}
