package solidPrinciples.emailLogin;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void saveUser(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public User findUserByEmail(String email) {
        return users.get(email);
    }
}


