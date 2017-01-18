package demo;

public class EmailService {

    void sendEmail(User user, String message) {
        System.out.println("Sending email to " + user.getName() + "with content: " + message);
    }
}
