public class Login extends Registration {
    public String loginUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (registeredUsers[i].equals(username) && passwords[i].equals(password)) {
                return "Welcome " + username + ". It is great to see you again.";
            }
        }
        return "Username or password incorrect, please try again.";
    }
}