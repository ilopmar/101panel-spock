package demo;

public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void createUser(String name, String lastName) {
        User user = new User(name, lastName);

        // Storing user on DB

        notificationService.sendNotification(user, "User created");
    }
}
