package solidPrinciples.singleResponsibilityPrinciple;

public class DefaultEmailService implements EmailService {
    @Override
    public void sendEmail(User user, String massage) {
        System.out.println("Sending email to " + user.getEmail() + " with massage: " + massage);
    }
}
