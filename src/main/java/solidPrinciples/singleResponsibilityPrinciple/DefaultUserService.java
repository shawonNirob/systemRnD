package solidPrinciples.singleResponsibilityPrinciple;

public class DefaultUserService implements UserService {
    private final EmailService emailService;
    public DefaultUserService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void addUser(User user) {
        System.out.println("Adding user to the database: " + user);
        emailService.sendEmail(user, "Wellcome to our service!");
    }

}
