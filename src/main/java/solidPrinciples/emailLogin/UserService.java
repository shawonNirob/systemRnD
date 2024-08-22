package solidPrinciples.emailLogin;

public interface UserService {
    void registerUser(String email, String password);
    boolean loginUser(String email, String password);
}

