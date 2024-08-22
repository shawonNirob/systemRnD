package solidPrinciples.singleResponsibilityPrinciple;

public class SRPTesting {
    public static void main(String[] args) {
        EmailService emailService = new DefaultEmailService();

        UserService userService = new DefaultUserService(emailService);

        User user = new User("nirobruet18@gmail.com");
        userService.addUser(user);
    }
}
