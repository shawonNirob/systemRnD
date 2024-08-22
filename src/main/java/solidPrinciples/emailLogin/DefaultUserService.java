package solidPrinciples.emailLogin;


public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public DefaultUserService(UserRepository userRepository, PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public void registerUser(String email, String password) {
        String hashedPassword = passwordHasher.hashPassword(password);
        User user = new User(email, hashedPassword);
        userRepository.saveUser(user);
        System.out.println("User registered: " + email);
    }

    @Override
    public boolean loginUser(String email, String password){
        User user = userRepository.findUserByEmail(email);
        if (user != null && passwordHasher.verifyPassword(password, user.getHashedPassword())) {
            System.out.println("User logged in: " + email);
            return true;
        }
        System.out.println("Invalid login attempt for: " + email);
        return false;
    }
}


