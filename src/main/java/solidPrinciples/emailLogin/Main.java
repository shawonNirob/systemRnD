package solidPrinciples.emailLogin;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        PasswordHasher passwordHasher = new PasswordHasher();
        UserService userService = new DefaultUserService(userRepository, passwordHasher);

        // Register a new user
        userService.registerUser("john.doe@example.com", "password123");

        // Attempt to log in
        boolean loginSuccessful = userService.loginUser("john.doe@example.com", "password123");
        System.out.println("Login successful: " + loginSuccessful);

        // Attempt to log in with incorrect password
        boolean loginFailed = userService.loginUser("john.doe@example.com", "wrongpassword");
        System.out.println("Login successful: " + loginFailed);
    }
}
