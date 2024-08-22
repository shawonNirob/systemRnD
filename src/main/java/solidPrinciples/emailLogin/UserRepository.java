package solidPrinciples.emailLogin;

import java.util.HashMap;
import java.util.Map;


public interface UserRepository {
    void saveUser(User user);
    User findUserByEmail(String email);
}
