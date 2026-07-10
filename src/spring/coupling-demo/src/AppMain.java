import loose.EmailNotificationService;
import loose.NotificationService;
import loose.SMSNotificationService;
import tight.UserService;

public class AppMain {
    public static void main(String[] args) {

        //Tight coupling
        UserService userService = new UserService();
        userService.notifyUser("Order placed!");

        //Loose coupling
        NotificationService emailService = new EmailNotificationService();
        loose.UserService userServiceLoose1 = new loose.UserService(emailService);

        NotificationService smsService = new SMSNotificationService();
        loose.UserService userServiceLoose = new loose.UserService(smsService);

        userServiceLoose.notifyUser("Order Processed!");
        userServiceLoose1.notifyUser("Order Processed!");
    }
}
