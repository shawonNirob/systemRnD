package solidPrinciples.emailLogin;

public class User {
    private String email;
    private String hashedPassword;

    public User(String email, String hashedPassword) {
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
